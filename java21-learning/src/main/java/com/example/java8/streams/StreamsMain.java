package com.example.java8.streams;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.function.Consumer;

public class StreamsMain {
    public static void main(String[] args) {
        Consumer<Object> co1 =
                new Consumer<Object>() {
                    @Override
                    public void accept(Object t) {
                        System.out.println(t);
                    }
                };

        Consumer<String> cs1 =
                new Consumer<String>() {
                    @Override
                    public void accept(String t) {
                        System.out.println("S" + t);
                    }
                };

        Consumer<? extends Object> co2 = cs1;
        Consumer<? super String> cs2 = co1;

        display(co1);
        display(cs1);
        display(cs2);
        display(co2);

        Consumer<Integer> ci = System.out::println;
        //		display(ci);

        //		display(co1, "S123");
        //		display(cs1, "S123");
        //		display(cs2, "S123");
        //		display(co2, "S123");

        //		display(ci, 123);

    }

    @SuppressWarnings("unchecked")
    private static <T> void display(Consumer<? super T> action) {
        Type[] types = action.getClass().getGenericInterfaces();
        System.out.println(types.length);
        for (Type t : types) {
            if (t instanceof ParameterizedType pt && pt.getRawType() == Consumer.class) {

                System.out.println(pt.getActualTypeArguments()[0]);
            }
        }

        action.accept((T) "123");
    }

    //	private static <T> void display(Consumer<? super T> action, T v) {
    //		action.accept(v);
    //	}
}
