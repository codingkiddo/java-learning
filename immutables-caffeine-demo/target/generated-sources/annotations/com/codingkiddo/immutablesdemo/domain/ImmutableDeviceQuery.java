package com.codingkiddo.immutablesdemo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link DeviceQuery}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableDeviceQuery.builder()}.
 */
@Generated(from = "DeviceQuery", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableDeviceQuery implements DeviceQuery {
  private final String id;
  private final boolean includeMetrics;

  private ImmutableDeviceQuery(ImmutableDeviceQuery.Builder builder) {
    this.id = builder.id;
    this.includeMetrics = builder.includeMetricsIsSet()
        ? builder.includeMetrics
        : DeviceQuery.super.includeMetrics();
  }

  private ImmutableDeviceQuery(String id, boolean includeMetrics) {
    this.id = id;
    this.includeMetrics = includeMetrics;
  }

  /**
   * @return The value of the {@code id} attribute
   */
  @JsonProperty(value = "id", required = true)
  @Override
  public String id() {
    return id;
  }

  /**
   * @return The value of the {@code includeMetrics} attribute
   */
  @JsonProperty(value = "includeMetrics")
  @Override
  public boolean includeMetrics() {
    return includeMetrics;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DeviceQuery#id() id} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy or the {@code this} object
   */
  public final ImmutableDeviceQuery withId(String value) {
    String newValue = Objects.requireNonNull(value, "id");
    if (this.id.equals(newValue)) return this;
    return new ImmutableDeviceQuery(newValue, this.includeMetrics);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link DeviceQuery#includeMetrics() includeMetrics} attribute.
   * A value equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for includeMetrics
   * @return A modified copy or the {@code this} object
   */
  public final ImmutableDeviceQuery withIncludeMetrics(boolean value) {
    if (this.includeMetrics == value) return this;
    return new ImmutableDeviceQuery(this.id, value);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableDeviceQuery} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableDeviceQuery
        && equalsByValue((ImmutableDeviceQuery) another);
  }

  private boolean equalsByValue(ImmutableDeviceQuery another) {
    return id.equals(another.id)
        && includeMetrics == another.includeMetrics;
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code includeMetrics}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + id.hashCode();
    h += (h << 5) + Boolean.hashCode(includeMetrics);
    return h;
  }

  /**
   * Prints the immutable value {@code DeviceQuery} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "DeviceQuery{"
        + "id=" + id
        + ", includeMetrics=" + includeMetrics
        + "}";
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "DeviceQuery", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonDeserialize
  static final class Json implements DeviceQuery {
    @JsonIgnore String _id;
    @JsonIgnore boolean _includeMetrics;
    @JsonIgnore boolean includeMetricsIsSet;

    @JsonProperty(value = "id", required = true)
    public void setId(String id) {
      this._id = id;
    }

    @JsonProperty(value = "includeMetrics")
    public void setIncludeMetrics(boolean includeMetrics) {
      this._includeMetrics = includeMetrics;
      this.includeMetricsIsSet = true;
    }

    @Override
    public String id() { throw new UnsupportedOperationException(); }

    @Override
    public boolean includeMetrics() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableDeviceQuery fromJson(Json json) {
    ImmutableDeviceQuery.Builder builder = ImmutableDeviceQuery.builder();
    if (json._id != null) {
      builder.id(json._id);
    }
    if (json.includeMetricsIsSet) {
      builder.includeMetrics(json._includeMetrics);
    }
    return builder.build();
  }

  /**
   * Creates an immutable copy of a {@link DeviceQuery} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable DeviceQuery instance
   */
  public static ImmutableDeviceQuery copyOf(DeviceQuery instance) {
    if (instance instanceof ImmutableDeviceQuery) {
      return (ImmutableDeviceQuery) instance;
    }
    return ImmutableDeviceQuery.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableDeviceQuery ImmutableDeviceQuery}.
   * <pre>
   * ImmutableDeviceQuery.builder()
   *    .id(String) // required {@link DeviceQuery#id() id}
   *    .includeMetrics(boolean) // optional {@link DeviceQuery#includeMetrics() includeMetrics}
   *    .build();
   * </pre>
   * @return A new ImmutableDeviceQuery builder
   */
  public static ImmutableDeviceQuery.Builder builder() {
    return new ImmutableDeviceQuery.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableDeviceQuery ImmutableDeviceQuery}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "DeviceQuery", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private static final long OPT_BIT_INCLUDE_METRICS = 0x1L;
    private long initBits = 0x1L;
    private long optBits;

    private String id;
    private boolean includeMetrics;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code DeviceQuery} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(DeviceQuery instance) {
      Objects.requireNonNull(instance, "instance");
      this.id(instance.id());
      this.includeMetrics(instance.includeMetrics());
      return this;
    }

    /**
     * Initializes the value for the {@link DeviceQuery#id() id} attribute.
     * @param id The value for id 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty(value = "id", required = true)
    public final Builder id(String id) {
      this.id = Objects.requireNonNull(id, "id");
      initBits &= ~INIT_BIT_ID;
      return this;
    }

    /**
     * Initializes the value for the {@link DeviceQuery#includeMetrics() includeMetrics} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link DeviceQuery#includeMetrics() includeMetrics}.</em>
     * @param includeMetrics The value for includeMetrics 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty(value = "includeMetrics")
    public final Builder includeMetrics(boolean includeMetrics) {
      this.includeMetrics = includeMetrics;
      optBits |= OPT_BIT_INCLUDE_METRICS;
      return this;
    }

    /**
     * Builds a new {@link ImmutableDeviceQuery ImmutableDeviceQuery}.
     * @return An immutable instance of DeviceQuery
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableDeviceQuery build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableDeviceQuery(this);
    }

    private boolean includeMetricsIsSet() {
      return (optBits & OPT_BIT_INCLUDE_METRICS) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      return "Cannot build DeviceQuery, some of required attributes are not set " + attributes;
    }
  }
}
