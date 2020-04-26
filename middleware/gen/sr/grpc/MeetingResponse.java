// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: subscriptions.proto

package sr.grpc;

/**
 * Protobuf type {@code sr.grpc.MeetingResponse}
 */
public  final class MeetingResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:sr.grpc.MeetingResponse)
    MeetingResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use MeetingResponse.newBuilder() to construct.
  private MeetingResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private MeetingResponse() {
    team_ = "";
    room_ = "";
    datetime_ = "";
    type_ = 0;
    participants_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new MeetingResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private MeetingResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            team_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            room_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            datetime_ = s;
            break;
          }
          case 34: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              participants_ = new java.util.ArrayList<sr.grpc.Person>();
              mutable_bitField0_ |= 0x00000001;
            }
            participants_.add(
                input.readMessage(sr.grpc.Person.parser(), extensionRegistry));
            break;
          }
          case 40: {
            int rawValue = input.readEnum();

            type_ = rawValue;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        participants_ = java.util.Collections.unmodifiableList(participants_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return sr.grpc.Subscriptions.internal_static_sr_grpc_MeetingResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return sr.grpc.Subscriptions.internal_static_sr_grpc_MeetingResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            sr.grpc.MeetingResponse.class, sr.grpc.MeetingResponse.Builder.class);
  }

  public static final int TEAM_FIELD_NUMBER = 1;
  private volatile java.lang.Object team_;
  /**
   * <code>string team = 1;</code>
   * @return The team.
   */
  public java.lang.String getTeam() {
    java.lang.Object ref = team_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      team_ = s;
      return s;
    }
  }
  /**
   * <code>string team = 1;</code>
   * @return The bytes for team.
   */
  public com.google.protobuf.ByteString
      getTeamBytes() {
    java.lang.Object ref = team_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      team_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ROOM_FIELD_NUMBER = 2;
  private volatile java.lang.Object room_;
  /**
   * <code>string room = 2;</code>
   * @return The room.
   */
  public java.lang.String getRoom() {
    java.lang.Object ref = room_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      room_ = s;
      return s;
    }
  }
  /**
   * <code>string room = 2;</code>
   * @return The bytes for room.
   */
  public com.google.protobuf.ByteString
      getRoomBytes() {
    java.lang.Object ref = room_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      room_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DATETIME_FIELD_NUMBER = 3;
  private volatile java.lang.Object datetime_;
  /**
   * <code>string datetime = 3;</code>
   * @return The datetime.
   */
  public java.lang.String getDatetime() {
    java.lang.Object ref = datetime_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      datetime_ = s;
      return s;
    }
  }
  /**
   * <code>string datetime = 3;</code>
   * @return The bytes for datetime.
   */
  public com.google.protobuf.ByteString
      getDatetimeBytes() {
    java.lang.Object ref = datetime_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      datetime_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TYPE_FIELD_NUMBER = 5;
  private int type_;
  /**
   * <code>.sr.grpc.Type type = 5;</code>
   * @return The enum numeric value on the wire for type.
   */
  public int getTypeValue() {
    return type_;
  }
  /**
   * <code>.sr.grpc.Type type = 5;</code>
   * @return The type.
   */
  public sr.grpc.Type getType() {
    @SuppressWarnings("deprecation")
    sr.grpc.Type result = sr.grpc.Type.valueOf(type_);
    return result == null ? sr.grpc.Type.UNRECOGNIZED : result;
  }

  public static final int PARTICIPANTS_FIELD_NUMBER = 4;
  private java.util.List<sr.grpc.Person> participants_;
  /**
   * <code>repeated .sr.grpc.Person participants = 4;</code>
   */
  public java.util.List<sr.grpc.Person> getParticipantsList() {
    return participants_;
  }
  /**
   * <code>repeated .sr.grpc.Person participants = 4;</code>
   */
  public java.util.List<? extends sr.grpc.PersonOrBuilder> 
      getParticipantsOrBuilderList() {
    return participants_;
  }
  /**
   * <code>repeated .sr.grpc.Person participants = 4;</code>
   */
  public int getParticipantsCount() {
    return participants_.size();
  }
  /**
   * <code>repeated .sr.grpc.Person participants = 4;</code>
   */
  public sr.grpc.Person getParticipants(int index) {
    return participants_.get(index);
  }
  /**
   * <code>repeated .sr.grpc.Person participants = 4;</code>
   */
  public sr.grpc.PersonOrBuilder getParticipantsOrBuilder(
      int index) {
    return participants_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getTeamBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, team_);
    }
    if (!getRoomBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, room_);
    }
    if (!getDatetimeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, datetime_);
    }
    for (int i = 0; i < participants_.size(); i++) {
      output.writeMessage(4, participants_.get(i));
    }
    if (type_ != sr.grpc.Type.STANDUP.getNumber()) {
      output.writeEnum(5, type_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getTeamBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, team_);
    }
    if (!getRoomBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, room_);
    }
    if (!getDatetimeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, datetime_);
    }
    for (int i = 0; i < participants_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(4, participants_.get(i));
    }
    if (type_ != sr.grpc.Type.STANDUP.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(5, type_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof sr.grpc.MeetingResponse)) {
      return super.equals(obj);
    }
    sr.grpc.MeetingResponse other = (sr.grpc.MeetingResponse) obj;

    if (!getTeam()
        .equals(other.getTeam())) return false;
    if (!getRoom()
        .equals(other.getRoom())) return false;
    if (!getDatetime()
        .equals(other.getDatetime())) return false;
    if (type_ != other.type_) return false;
    if (!getParticipantsList()
        .equals(other.getParticipantsList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + TEAM_FIELD_NUMBER;
    hash = (53 * hash) + getTeam().hashCode();
    hash = (37 * hash) + ROOM_FIELD_NUMBER;
    hash = (53 * hash) + getRoom().hashCode();
    hash = (37 * hash) + DATETIME_FIELD_NUMBER;
    hash = (53 * hash) + getDatetime().hashCode();
    hash = (37 * hash) + TYPE_FIELD_NUMBER;
    hash = (53 * hash) + type_;
    if (getParticipantsCount() > 0) {
      hash = (37 * hash) + PARTICIPANTS_FIELD_NUMBER;
      hash = (53 * hash) + getParticipantsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static sr.grpc.MeetingResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.MeetingResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.MeetingResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.MeetingResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.MeetingResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static sr.grpc.MeetingResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static sr.grpc.MeetingResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static sr.grpc.MeetingResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static sr.grpc.MeetingResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static sr.grpc.MeetingResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static sr.grpc.MeetingResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static sr.grpc.MeetingResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(sr.grpc.MeetingResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code sr.grpc.MeetingResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:sr.grpc.MeetingResponse)
      sr.grpc.MeetingResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return sr.grpc.Subscriptions.internal_static_sr_grpc_MeetingResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return sr.grpc.Subscriptions.internal_static_sr_grpc_MeetingResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              sr.grpc.MeetingResponse.class, sr.grpc.MeetingResponse.Builder.class);
    }

    // Construct using sr.grpc.MeetingResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getParticipantsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      team_ = "";

      room_ = "";

      datetime_ = "";

      type_ = 0;

      if (participantsBuilder_ == null) {
        participants_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        participantsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return sr.grpc.Subscriptions.internal_static_sr_grpc_MeetingResponse_descriptor;
    }

    @java.lang.Override
    public sr.grpc.MeetingResponse getDefaultInstanceForType() {
      return sr.grpc.MeetingResponse.getDefaultInstance();
    }

    @java.lang.Override
    public sr.grpc.MeetingResponse build() {
      sr.grpc.MeetingResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public sr.grpc.MeetingResponse buildPartial() {
      sr.grpc.MeetingResponse result = new sr.grpc.MeetingResponse(this);
      int from_bitField0_ = bitField0_;
      result.team_ = team_;
      result.room_ = room_;
      result.datetime_ = datetime_;
      result.type_ = type_;
      if (participantsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          participants_ = java.util.Collections.unmodifiableList(participants_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.participants_ = participants_;
      } else {
        result.participants_ = participantsBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof sr.grpc.MeetingResponse) {
        return mergeFrom((sr.grpc.MeetingResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(sr.grpc.MeetingResponse other) {
      if (other == sr.grpc.MeetingResponse.getDefaultInstance()) return this;
      if (!other.getTeam().isEmpty()) {
        team_ = other.team_;
        onChanged();
      }
      if (!other.getRoom().isEmpty()) {
        room_ = other.room_;
        onChanged();
      }
      if (!other.getDatetime().isEmpty()) {
        datetime_ = other.datetime_;
        onChanged();
      }
      if (other.type_ != 0) {
        setTypeValue(other.getTypeValue());
      }
      if (participantsBuilder_ == null) {
        if (!other.participants_.isEmpty()) {
          if (participants_.isEmpty()) {
            participants_ = other.participants_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureParticipantsIsMutable();
            participants_.addAll(other.participants_);
          }
          onChanged();
        }
      } else {
        if (!other.participants_.isEmpty()) {
          if (participantsBuilder_.isEmpty()) {
            participantsBuilder_.dispose();
            participantsBuilder_ = null;
            participants_ = other.participants_;
            bitField0_ = (bitField0_ & ~0x00000001);
            participantsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getParticipantsFieldBuilder() : null;
          } else {
            participantsBuilder_.addAllMessages(other.participants_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      sr.grpc.MeetingResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (sr.grpc.MeetingResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object team_ = "";
    /**
     * <code>string team = 1;</code>
     * @return The team.
     */
    public java.lang.String getTeam() {
      java.lang.Object ref = team_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        team_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string team = 1;</code>
     * @return The bytes for team.
     */
    public com.google.protobuf.ByteString
        getTeamBytes() {
      java.lang.Object ref = team_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        team_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string team = 1;</code>
     * @param value The team to set.
     * @return This builder for chaining.
     */
    public Builder setTeam(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      team_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string team = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearTeam() {
      
      team_ = getDefaultInstance().getTeam();
      onChanged();
      return this;
    }
    /**
     * <code>string team = 1;</code>
     * @param value The bytes for team to set.
     * @return This builder for chaining.
     */
    public Builder setTeamBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      team_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object room_ = "";
    /**
     * <code>string room = 2;</code>
     * @return The room.
     */
    public java.lang.String getRoom() {
      java.lang.Object ref = room_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        room_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string room = 2;</code>
     * @return The bytes for room.
     */
    public com.google.protobuf.ByteString
        getRoomBytes() {
      java.lang.Object ref = room_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        room_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string room = 2;</code>
     * @param value The room to set.
     * @return This builder for chaining.
     */
    public Builder setRoom(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      room_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string room = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearRoom() {
      
      room_ = getDefaultInstance().getRoom();
      onChanged();
      return this;
    }
    /**
     * <code>string room = 2;</code>
     * @param value The bytes for room to set.
     * @return This builder for chaining.
     */
    public Builder setRoomBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      room_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object datetime_ = "";
    /**
     * <code>string datetime = 3;</code>
     * @return The datetime.
     */
    public java.lang.String getDatetime() {
      java.lang.Object ref = datetime_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        datetime_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string datetime = 3;</code>
     * @return The bytes for datetime.
     */
    public com.google.protobuf.ByteString
        getDatetimeBytes() {
      java.lang.Object ref = datetime_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        datetime_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string datetime = 3;</code>
     * @param value The datetime to set.
     * @return This builder for chaining.
     */
    public Builder setDatetime(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      datetime_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string datetime = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearDatetime() {
      
      datetime_ = getDefaultInstance().getDatetime();
      onChanged();
      return this;
    }
    /**
     * <code>string datetime = 3;</code>
     * @param value The bytes for datetime to set.
     * @return This builder for chaining.
     */
    public Builder setDatetimeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      datetime_ = value;
      onChanged();
      return this;
    }

    private int type_ = 0;
    /**
     * <code>.sr.grpc.Type type = 5;</code>
     * @return The enum numeric value on the wire for type.
     */
    public int getTypeValue() {
      return type_;
    }
    /**
     * <code>.sr.grpc.Type type = 5;</code>
     * @param value The enum numeric value on the wire for type to set.
     * @return This builder for chaining.
     */
    public Builder setTypeValue(int value) {
      type_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.sr.grpc.Type type = 5;</code>
     * @return The type.
     */
    public sr.grpc.Type getType() {
      @SuppressWarnings("deprecation")
      sr.grpc.Type result = sr.grpc.Type.valueOf(type_);
      return result == null ? sr.grpc.Type.UNRECOGNIZED : result;
    }
    /**
     * <code>.sr.grpc.Type type = 5;</code>
     * @param value The type to set.
     * @return This builder for chaining.
     */
    public Builder setType(sr.grpc.Type value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      type_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.sr.grpc.Type type = 5;</code>
     * @return This builder for chaining.
     */
    public Builder clearType() {
      
      type_ = 0;
      onChanged();
      return this;
    }

    private java.util.List<sr.grpc.Person> participants_ =
      java.util.Collections.emptyList();
    private void ensureParticipantsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        participants_ = new java.util.ArrayList<sr.grpc.Person>(participants_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        sr.grpc.Person, sr.grpc.Person.Builder, sr.grpc.PersonOrBuilder> participantsBuilder_;

    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public java.util.List<sr.grpc.Person> getParticipantsList() {
      if (participantsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(participants_);
      } else {
        return participantsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public int getParticipantsCount() {
      if (participantsBuilder_ == null) {
        return participants_.size();
      } else {
        return participantsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public sr.grpc.Person getParticipants(int index) {
      if (participantsBuilder_ == null) {
        return participants_.get(index);
      } else {
        return participantsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public Builder setParticipants(
        int index, sr.grpc.Person value) {
      if (participantsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureParticipantsIsMutable();
        participants_.set(index, value);
        onChanged();
      } else {
        participantsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public Builder setParticipants(
        int index, sr.grpc.Person.Builder builderForValue) {
      if (participantsBuilder_ == null) {
        ensureParticipantsIsMutable();
        participants_.set(index, builderForValue.build());
        onChanged();
      } else {
        participantsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public Builder addParticipants(sr.grpc.Person value) {
      if (participantsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureParticipantsIsMutable();
        participants_.add(value);
        onChanged();
      } else {
        participantsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public Builder addParticipants(
        int index, sr.grpc.Person value) {
      if (participantsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureParticipantsIsMutable();
        participants_.add(index, value);
        onChanged();
      } else {
        participantsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public Builder addParticipants(
        sr.grpc.Person.Builder builderForValue) {
      if (participantsBuilder_ == null) {
        ensureParticipantsIsMutable();
        participants_.add(builderForValue.build());
        onChanged();
      } else {
        participantsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public Builder addParticipants(
        int index, sr.grpc.Person.Builder builderForValue) {
      if (participantsBuilder_ == null) {
        ensureParticipantsIsMutable();
        participants_.add(index, builderForValue.build());
        onChanged();
      } else {
        participantsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public Builder addAllParticipants(
        java.lang.Iterable<? extends sr.grpc.Person> values) {
      if (participantsBuilder_ == null) {
        ensureParticipantsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, participants_);
        onChanged();
      } else {
        participantsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public Builder clearParticipants() {
      if (participantsBuilder_ == null) {
        participants_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        participantsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public Builder removeParticipants(int index) {
      if (participantsBuilder_ == null) {
        ensureParticipantsIsMutable();
        participants_.remove(index);
        onChanged();
      } else {
        participantsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public sr.grpc.Person.Builder getParticipantsBuilder(
        int index) {
      return getParticipantsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public sr.grpc.PersonOrBuilder getParticipantsOrBuilder(
        int index) {
      if (participantsBuilder_ == null) {
        return participants_.get(index);  } else {
        return participantsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public java.util.List<? extends sr.grpc.PersonOrBuilder> 
         getParticipantsOrBuilderList() {
      if (participantsBuilder_ != null) {
        return participantsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(participants_);
      }
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public sr.grpc.Person.Builder addParticipantsBuilder() {
      return getParticipantsFieldBuilder().addBuilder(
          sr.grpc.Person.getDefaultInstance());
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public sr.grpc.Person.Builder addParticipantsBuilder(
        int index) {
      return getParticipantsFieldBuilder().addBuilder(
          index, sr.grpc.Person.getDefaultInstance());
    }
    /**
     * <code>repeated .sr.grpc.Person participants = 4;</code>
     */
    public java.util.List<sr.grpc.Person.Builder> 
         getParticipantsBuilderList() {
      return getParticipantsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        sr.grpc.Person, sr.grpc.Person.Builder, sr.grpc.PersonOrBuilder> 
        getParticipantsFieldBuilder() {
      if (participantsBuilder_ == null) {
        participantsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            sr.grpc.Person, sr.grpc.Person.Builder, sr.grpc.PersonOrBuilder>(
                participants_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        participants_ = null;
      }
      return participantsBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:sr.grpc.MeetingResponse)
  }

  // @@protoc_insertion_point(class_scope:sr.grpc.MeetingResponse)
  private static final sr.grpc.MeetingResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new sr.grpc.MeetingResponse();
  }

  public static sr.grpc.MeetingResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<MeetingResponse>
      PARSER = new com.google.protobuf.AbstractParser<MeetingResponse>() {
    @java.lang.Override
    public MeetingResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new MeetingResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<MeetingResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<MeetingResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public sr.grpc.MeetingResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

