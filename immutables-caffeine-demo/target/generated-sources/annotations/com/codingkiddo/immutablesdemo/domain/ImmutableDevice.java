package com.codingkiddo.immutablesdemo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Var;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link Device}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableDevice.builder()}.
 */
@Generated(from = "Device", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableDevice implements Device {
  private final String id;
  private final String mac;
  private final String model;
  private final String vendor;
  private final Instant createdAt;
  private transient final String macCompact;

  private ImmutableDevice(ImmutableDevice.Builder builder) {
    this.id = builder.id;
    this.mac = builder.mac;
    this.model = builder.model;
    this.vendor = builder.vendor;
    if (builder.createdAt != null) {
      initShim.createdAt(builder.createdAt);
    }
    this.createdAt = initShim.createdAt();
    this.macCompact = initShim.macCompact();
    this.initShim = null;
  }

  private ImmutableDevice(
      String id,
      String mac,
      String model,
      String vendor,
      Instant createdAt) {
    this.id = id;
    this.mac = mac;
    this.model = model;
    this.vendor = vendor;
    initShim.createdAt(createdAt);
    this.createdAt = initShim.createdAt();
    this.macCompact = initShim.macCompact();
    this.initShim = null;
  }

  private static final byte STAGE_INITIALIZING = -1;
  private static final byte STAGE_UNINITIALIZED = 0;
  private static final byte STAGE_INITIALIZED = 1;
  @SuppressWarnings("Immutable")
  private transient volatile InitShim initShim = new InitShim();

  @Generated(from = "Device", generator = "Immutables")
  private final class InitShim {
    private byte createdAtBuildStage = STAGE_UNINITIALIZED;
    private Instant createdAt;

    Instant createdAt() {
      if (createdAtBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (createdAtBuildStage == STAGE_UNINITIALIZED) {
        createdAtBuildStage = STAGE_INITIALIZING;
        Instant computedValue = createdAtInitialize();
        this.createdAt = Objects.requireNonNull(computedValue, "createdAt");
        createdAtBuildStage = STAGE_INITIALIZED;
      }
      return this.createdAt;
    }

    void createdAt(Instant createdAt) {
      this.createdAt = createdAt;
      createdAtBuildStage = STAGE_INITIALIZED;
    }

    private byte macCompactBuildStage = STAGE_UNINITIALIZED;
    private String macCompact;

    String macCompact() {
      if (macCompactBuildStage == STAGE_INITIALIZING) throw new IllegalStateException(formatInitCycleMessage());
      if (macCompactBuildStage == STAGE_UNINITIALIZED) {
        macCompactBuildStage = STAGE_INITIALIZING;
        String computedValue = macCompactInitialize();
        this.macCompact = Objects.requireNonNull(computedValue, "macCompact");
        macCompactBuildStage = STAGE_INITIALIZED;
      }
      return this.macCompact;
    }

    private String formatInitCycleMessage() {
      List<String> attributes = new ArrayList<>();
      if (createdAtBuildStage == STAGE_INITIALIZING) attributes.add("createdAt");
      if (macCompactBuildStage == STAGE_INITIALIZING) attributes.add("macCompact");
      return "Cannot build Device, attribute initializers form cycle " + attributes;
    }
  }

  private Instant createdAtInitialize() {
    return Device.super.createdAt();
  }

  private String macCompactInitialize() {
    return Device.super.macCompact();
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
   * @return The value of the {@code mac} attribute
   */
  @JsonProperty(value = "mac", required = true)
  @Override
  public String mac() {
    return mac;
  }

  /**
   * @return The value of the {@code model} attribute
   */
  @JsonProperty(value = "model", required = true)
  @Override
  public String model() {
    return model;
  }

  /**
   * @return The value of the {@code vendor} attribute
   */
  @JsonProperty(value = "vendor")
  @Override
  public Optional<String> vendor() {
    return Optional.ofNullable(vendor);
  }

  /**
   * @return The value of the {@code createdAt} attribute
   */
  @JsonProperty(value = "createdAt")
  @Override
  public Instant createdAt() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.createdAt()
        : this.createdAt;
  }

  /**
   * @return The computed-at-construction value of the {@code macCompact} attribute
   */
  @JsonProperty(value = "macCompact")
  @Override
  public String macCompact() {
    InitShim shim = this.initShim;
    return shim != null
        ? shim.macCompact()
        : this.macCompact;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Device#id() id} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for id
   * @return A modified copy or the {@code this} object
   */
  public final ImmutableDevice withId(String value) {
    String newValue = Objects.requireNonNull(value, "id");
    if (this.id.equals(newValue)) return this;
    return validate(new ImmutableDevice(newValue, this.mac, this.model, this.vendor, this.createdAt));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Device#mac() mac} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for mac
   * @return A modified copy or the {@code this} object
   */
  public final ImmutableDevice withMac(String value) {
    String newValue = Objects.requireNonNull(value, "mac");
    if (this.mac.equals(newValue)) return this;
    return validate(new ImmutableDevice(this.id, newValue, this.model, this.vendor, this.createdAt));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Device#model() model} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for model
   * @return A modified copy or the {@code this} object
   */
  public final ImmutableDevice withModel(String value) {
    String newValue = Objects.requireNonNull(value, "model");
    if (this.model.equals(newValue)) return this;
    return validate(new ImmutableDevice(this.id, this.mac, newValue, this.vendor, this.createdAt));
  }

  /**
   * Copy the current immutable object by setting a <em>present</em> value for the optional {@link Device#vendor() vendor} attribute.
   * @param value The value for vendor
   * @return A modified copy or {@code this} if not changed
   */
  public final ImmutableDevice withVendor(String value) {
    String newValue = Objects.requireNonNull(value, "vendor");
    if (Objects.equals(this.vendor, newValue)) return this;
    return validate(new ImmutableDevice(this.id, this.mac, this.model, newValue, this.createdAt));
  }

  /**
   * Copy the current immutable object by setting an optional value for the {@link Device#vendor() vendor} attribute.
   * An equality check is used on inner value to prevent copying of the same value by returning {@code this}.
   * @param optional An optional value for vendor
   * @return A modified copy or {@code this} if not changed
   */
  public final ImmutableDevice withVendor(Optional<String> optional) {
    String value = optional.orElse(null);
    if (Objects.equals(this.vendor, value)) return this;
    return validate(new ImmutableDevice(this.id, this.mac, this.model, value, this.createdAt));
  }

  /**
   * Copy the current immutable object by setting a value for the {@link Device#createdAt() createdAt} attribute.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for createdAt
   * @return A modified copy or the {@code this} object
   */
  public final ImmutableDevice withCreatedAt(Instant value) {
    if (this.createdAt == value) return this;
    Instant newValue = Objects.requireNonNull(value, "createdAt");
    return validate(new ImmutableDevice(this.id, this.mac, this.model, this.vendor, newValue));
  }

  /**
   * This instance is equal to all instances of {@code ImmutableDevice} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableDevice
        && equalsByValue((ImmutableDevice) another);
  }

  private boolean equalsByValue(ImmutableDevice another) {
    return id.equals(another.id)
        && mac.equals(another.mac)
        && model.equals(another.model)
        && Objects.equals(vendor, another.vendor)
        && createdAt.equals(another.createdAt)
        && macCompact.equals(another.macCompact);
  }

  /**
   * Computes a hash code from attributes: {@code id}, {@code mac}, {@code model}, {@code vendor}, {@code createdAt}, {@code macCompact}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    @Var int h = 5381;
    h += (h << 5) + id.hashCode();
    h += (h << 5) + mac.hashCode();
    h += (h << 5) + model.hashCode();
    h += (h << 5) + Objects.hashCode(vendor);
    h += (h << 5) + createdAt.hashCode();
    h += (h << 5) + macCompact.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Device} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("Device{");
    builder.append("id=").append(id);
    builder.append(", ");
    builder.append("mac=").append(mac);
    builder.append(", ");
    builder.append("model=").append(model);
    if (vendor != null) {
      builder.append(", ");
      builder.append("vendor=").append(vendor);
    }
    builder.append(", ");
    builder.append("createdAt=").append(createdAt);
    builder.append(", ");
    builder.append("macCompact=").append(macCompact);
    return builder.append("}").toString();
  }

  /**
   * Utility type used to correctly read immutable object from JSON representation.
   * @deprecated Do not use this type directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Generated(from = "Device", generator = "Immutables")
  @Deprecated
  @SuppressWarnings("Immutable")
  @JsonDeserialize
  static final class Json implements Device {
    @JsonIgnore String _id;
    @JsonIgnore String _mac;
    @JsonIgnore String _model;
    @JsonIgnore Optional<String> _vendor = Optional.empty();
    @JsonIgnore Instant _createdAt;

    @JsonProperty(value = "id", required = true)
    public void setId(String id) {
      this._id = id;
    }

    @JsonProperty(value = "mac", required = true)
    public void setMac(String mac) {
      this._mac = mac;
    }

    @JsonProperty(value = "model", required = true)
    public void setModel(String model) {
      this._model = model;
    }

    @JsonProperty(value = "vendor")
    public void setVendor(Optional<String> vendor) {
      this._vendor = vendor;
    }

    @JsonProperty(value = "createdAt")
    public void setCreatedAt(Instant createdAt) {
      this._createdAt = createdAt;
    }

    @Override
    public String id() { throw new UnsupportedOperationException(); }

    @Override
    public String mac() { throw new UnsupportedOperationException(); }

    @Override
    public String model() { throw new UnsupportedOperationException(); }

    @Override
    public Optional<String> vendor() { throw new UnsupportedOperationException(); }

    @Override
    public Instant createdAt() { throw new UnsupportedOperationException(); }

    @JsonIgnore 
    @Override
    public String macCompact() { throw new UnsupportedOperationException(); }
  }

  /**
   * @param json A JSON-bindable data structure
   * @return An immutable value type
   * @deprecated Do not use this method directly, it exists only for the <em>Jackson</em>-binding infrastructure
   */
  @Deprecated
  @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
  static ImmutableDevice fromJson(Json json) {
    ImmutableDevice.Builder builder = ImmutableDevice.builder();
    if (json._id != null) {
      builder.id(json._id);
    }
    if (json._mac != null) {
      builder.mac(json._mac);
    }
    if (json._model != null) {
      builder.model(json._model);
    }
    if (json._vendor != null) {
      builder.vendor(json._vendor);
    }
    if (json._createdAt != null) {
      builder.createdAt(json._createdAt);
    }
    return builder.build();
  }

  private static ImmutableDevice validate(ImmutableDevice instance) {
    instance.validate();
    return instance;
  }

  /**
   * Creates an immutable copy of a {@link Device} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable Device instance
   */
  public static ImmutableDevice copyOf(Device instance) {
    if (instance instanceof ImmutableDevice) {
      return (ImmutableDevice) instance;
    }
    return ImmutableDevice.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableDevice ImmutableDevice}.
   * <pre>
   * ImmutableDevice.builder()
   *    .id(String) // required {@link Device#id() id}
   *    .mac(String) // required {@link Device#mac() mac}
   *    .model(String) // required {@link Device#model() model}
   *    .vendor(Optional&lt;String&gt;) // optional {@link Device#vendor() vendor}
   *    .createdAt(java.time.Instant) // optional {@link Device#createdAt() createdAt}
   *    .build();
   * </pre>
   * @return A new ImmutableDevice builder
   */
  public static ImmutableDevice.Builder builder() {
    return new ImmutableDevice.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableDevice ImmutableDevice}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "Device", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_ID = 0x1L;
    private static final long INIT_BIT_MAC = 0x2L;
    private static final long INIT_BIT_MODEL = 0x4L;
    private long initBits = 0x7L;

    private String id;
    private String mac;
    private String model;
    private String vendor;
    private Instant createdAt;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code Device} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder from(Device instance) {
      Objects.requireNonNull(instance, "instance");
      this.id(instance.id());
      this.mac(instance.mac());
      this.model(instance.model());
      Optional<String> vendorOptional = instance.vendor();
      if (vendorOptional.isPresent()) {
        vendor(vendorOptional);
      }
      this.createdAt(instance.createdAt());
      return this;
    }

    /**
     * Initializes the value for the {@link Device#id() id} attribute.
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
     * Initializes the value for the {@link Device#mac() mac} attribute.
     * @param mac The value for mac 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty(value = "mac", required = true)
    public final Builder mac(String mac) {
      this.mac = Objects.requireNonNull(mac, "mac");
      initBits &= ~INIT_BIT_MAC;
      return this;
    }

    /**
     * Initializes the value for the {@link Device#model() model} attribute.
     * @param model The value for model 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty(value = "model", required = true)
    public final Builder model(String model) {
      this.model = Objects.requireNonNull(model, "model");
      initBits &= ~INIT_BIT_MODEL;
      return this;
    }

    /**
     * Initializes the optional value {@link Device#vendor() vendor} to vendor.
     * @param vendor The value for vendor
     * @return {@code this} builder for chained invocation
     */
    @CanIgnoreReturnValue 
    public final Builder vendor(String vendor) {
      this.vendor = Objects.requireNonNull(vendor, "vendor");
      return this;
    }

    /**
     * Initializes the optional value {@link Device#vendor() vendor} to vendor.
     * @param vendor The value for vendor
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty(value = "vendor")
    public final Builder vendor(Optional<String> vendor) {
      this.vendor = vendor.orElse(null);
      return this;
    }

    /**
     * Initializes the value for the {@link Device#createdAt() createdAt} attribute.
     * <p><em>If not set, this attribute will have a default value as returned by the initializer of {@link Device#createdAt() createdAt}.</em>
     * @param createdAt The value for createdAt 
     * @return {@code this} builder for use in a chained invocation
     */
    @CanIgnoreReturnValue 
    @JsonProperty(value = "createdAt")
    public final Builder createdAt(Instant createdAt) {
      this.createdAt = Objects.requireNonNull(createdAt, "createdAt");
      return this;
    }

    /**
     * Builds a new {@link ImmutableDevice ImmutableDevice}.
     * @return An immutable instance of Device
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableDevice build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return ImmutableDevice.validate(new ImmutableDevice(this));
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_ID) != 0) attributes.add("id");
      if ((initBits & INIT_BIT_MAC) != 0) attributes.add("mac");
      if ((initBits & INIT_BIT_MODEL) != 0) attributes.add("model");
      return "Cannot build Device, some of required attributes are not set " + attributes;
    }
  }
}
