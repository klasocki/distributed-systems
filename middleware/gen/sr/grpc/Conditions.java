// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: subscriptions.proto

package sr.grpc;

/**
 * Protobuf enum {@code sr.grpc.Conditions}
 */
public enum Conditions
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>SUNNY = 0;</code>
   */
  SUNNY(0),
  /**
   * <code>CLOUDY = 1;</code>
   */
  CLOUDY(1),
  /**
   * <code>RAINY = 2;</code>
   */
  RAINY(2),
  /**
   * <code>STORMY = 3;</code>
   */
  STORMY(3),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>SUNNY = 0;</code>
   */
  public static final int SUNNY_VALUE = 0;
  /**
   * <code>CLOUDY = 1;</code>
   */
  public static final int CLOUDY_VALUE = 1;
  /**
   * <code>RAINY = 2;</code>
   */
  public static final int RAINY_VALUE = 2;
  /**
   * <code>STORMY = 3;</code>
   */
  public static final int STORMY_VALUE = 3;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static Conditions valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static Conditions forNumber(int value) {
    switch (value) {
      case 0: return SUNNY;
      case 1: return CLOUDY;
      case 2: return RAINY;
      case 3: return STORMY;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<Conditions>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      Conditions> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<Conditions>() {
          public Conditions findValueByNumber(int number) {
            return Conditions.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return sr.grpc.Subscriptions.getDescriptor().getEnumTypes().get(1);
  }

  private static final Conditions[] VALUES = values();

  public static Conditions valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private Conditions(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:sr.grpc.Conditions)
}
