package com.example.java8.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MiniStream<T> {

	private final T[] source;
	private boolean consumed;
	private final List<Predicate<? super T>> filters = new ArrayList<>();
	
	private MiniStream(T[] source) {
        this.source = Objects.requireNonNull(source);
    }
	
	public static <T> MiniStream<T> of(T[] source) {
		return new MiniStream<>(source);
	}
	
	public MiniStream<T> filter(Predicate<? super T> condition) {
		Objects.requireNonNull(condition);
		checkNotConsumed();
		filters.add(condition);
		return this;
	}
	
	public void forEach(Consumer<? super T> action) {
		Objects.requireNonNull(action);
		checkNotConsumed();
		consumed = true;
		for (T element : source) {
			if (processFilters(element)) {
				action.accept(element);
			}
		}
	}
	
	public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator) {
		Objects.requireNonNull(supplier);
	    Objects.requireNonNull(accumulator);
	    checkNotConsumed();
	    consumed = true;

	    R result = supplier.get();
	    
	    for (T element : source) {
	    	if (processFilters(element)) {
	    		accumulator.accept(result, element);
	    	}
	    }
	    
	    return result;
	}
	
	public <A, R> R collect(MiniCollector<? super T, A, R> collector) {
		Objects.requireNonNull(collector);
	    checkNotConsumed();

	    consumed = true;
	    
	    A container = collector.supplier().get();
	    
	    BiConsumer<A, ? super T> accumulator = collector.accumulator();
	    
	    for ( T element : source ) {
	    	if (processFilters(element)) {
	    		accumulator.accept(container, element);
	    	}
	    }
	    
	    return collector.finisher().apply(container);
	}
	
	private boolean processFilters(T element) {
		for( Predicate<? super T> condition : filters ) {
			if ( !condition.test(element) ) {
				return false;
			}
		}
		return true;
	}
	
	private void checkNotConsumed() {
		if (consumed) {
			throw new IllegalStateException("Stream has already been consumed");
		}
	}
}
