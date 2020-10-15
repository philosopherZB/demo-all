package com.philosopherzb.nettydemo.protobuf;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal.EnumLite;
import com.google.protobuf.Internal.EnumLiteMap;
import com.google.protobuf.Internal.ProtobufList;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat.FieldType;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * author: philosopherZB
 * date: 2020/8/11
 */
public class IBusCloudSDKProto {
    private IBusCloudSDKProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static final class MetaInfo extends GeneratedMessageLite<MetaInfo, MetaInfo.Builder> implements IBusCloudSDKProto.MetaInfoOrBuilder {
        private int bitField0_;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int PRODUCT_LIST_FIELD_NUMBER = 2;
        private ProtobufList<String> productList_ = GeneratedMessageLite.emptyProtobufList();
        public static final int CARD_ISSUER_NO_LIST_FIELD_NUMBER = 3;
        private ProtobufList<String> cardIssuerNoList_ = GeneratedMessageLite.emptyProtobufList();
        public static final int CODE_ISSUER_NO_LIST_FIELD_NUMBER = 4;
        private ProtobufList<String> codeIssuerNoList_ = GeneratedMessageLite.emptyProtobufList();
        private static final IBusCloudSDKProto.MetaInfo DEFAULT_INSTANCE = new IBusCloudSDKProto.MetaInfo();
        private static volatile Parser<MetaInfo> PARSER;

        private MetaInfo() {
        }

        public int getTypeValue() {
            return this.type_;
        }

        public IBusCloudSDKProto.MetaInfo.ChannelType getType() {
            IBusCloudSDKProto.MetaInfo.ChannelType result = IBusCloudSDKProto.MetaInfo.ChannelType.forNumber(this.type_);
            return result == null ? IBusCloudSDKProto.MetaInfo.ChannelType.UNRECOGNIZED : result;
        }

        private void setTypeValue(int value) {
            this.type_ = value;
        }

        private void setType(IBusCloudSDKProto.MetaInfo.ChannelType value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.type_ = value.getNumber();
            }
        }

        private void clearType() {
            this.type_ = 0;
        }

        public List<String> getProductListList() {
            return this.productList_;
        }

        public int getProductListCount() {
            return this.productList_.size();
        }

        public String getProductList(int index) {
            return (String) this.productList_.get(index);
        }

        public ByteString getProductListBytes(int index) {
            return ByteString.copyFromUtf8((String) this.productList_.get(index));
        }

        private void ensureProductListIsMutable() {
            if (!this.productList_.isModifiable()) {
                this.productList_ = GeneratedMessageLite.mutableCopy(this.productList_);
            }

        }

        private void setProductList(int index, String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureProductListIsMutable();
                this.productList_.set(index, value);
            }
        }

        private void addProductList(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureProductListIsMutable();
                this.productList_.add(value);
            }
        }

        private void addAllProductList(Iterable<String> values) {
            this.ensureProductListIsMutable();
            AbstractMessageLite.addAll(values, this.productList_);
        }

        private void clearProductList() {
            this.productList_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void addProductListBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.ensureProductListIsMutable();
                this.productList_.add(value.toStringUtf8());
            }
        }

        public List<String> getCardIssuerNoListList() {
            return this.cardIssuerNoList_;
        }

        public int getCardIssuerNoListCount() {
            return this.cardIssuerNoList_.size();
        }

        public String getCardIssuerNoList(int index) {
            return (String) this.cardIssuerNoList_.get(index);
        }

        public ByteString getCardIssuerNoListBytes(int index) {
            return ByteString.copyFromUtf8((String) this.cardIssuerNoList_.get(index));
        }

        private void ensureCardIssuerNoListIsMutable() {
            if (!this.cardIssuerNoList_.isModifiable()) {
                this.cardIssuerNoList_ = GeneratedMessageLite.mutableCopy(this.cardIssuerNoList_);
            }

        }

        private void setCardIssuerNoList(int index, String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureCardIssuerNoListIsMutable();
                this.cardIssuerNoList_.set(index, value);
            }
        }

        private void addCardIssuerNoList(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureCardIssuerNoListIsMutable();
                this.cardIssuerNoList_.add(value);
            }
        }

        private void addAllCardIssuerNoList(Iterable<String> values) {
            this.ensureCardIssuerNoListIsMutable();
            AbstractMessageLite.addAll(values, this.cardIssuerNoList_);
        }

        private void clearCardIssuerNoList() {
            this.cardIssuerNoList_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void addCardIssuerNoListBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.ensureCardIssuerNoListIsMutable();
                this.cardIssuerNoList_.add(value.toStringUtf8());
            }
        }

        public List<String> getCodeIssuerNoListList() {
            return this.codeIssuerNoList_;
        }

        public int getCodeIssuerNoListCount() {
            return this.codeIssuerNoList_.size();
        }

        public String getCodeIssuerNoList(int index) {
            return (String) this.codeIssuerNoList_.get(index);
        }

        public ByteString getCodeIssuerNoListBytes(int index) {
            return ByteString.copyFromUtf8((String) this.codeIssuerNoList_.get(index));
        }

        private void ensureCodeIssuerNoListIsMutable() {
            if (!this.codeIssuerNoList_.isModifiable()) {
                this.codeIssuerNoList_ = GeneratedMessageLite.mutableCopy(this.codeIssuerNoList_);
            }

        }

        private void setCodeIssuerNoList(int index, String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureCodeIssuerNoListIsMutable();
                this.codeIssuerNoList_.set(index, value);
            }
        }

        private void addCodeIssuerNoList(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureCodeIssuerNoListIsMutable();
                this.codeIssuerNoList_.add(value);
            }
        }

        private void addAllCodeIssuerNoList(Iterable<String> values) {
            this.ensureCodeIssuerNoListIsMutable();
            AbstractMessageLite.addAll(values, this.codeIssuerNoList_);
        }

        private void clearCodeIssuerNoList() {
            this.codeIssuerNoList_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void addCodeIssuerNoListBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.ensureCodeIssuerNoListIsMutable();
                this.codeIssuerNoList_.add(value.toStringUtf8());
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.type_ != IBusCloudSDKProto.MetaInfo.ChannelType.ZJRC_SCPP.getNumber()) {
                output.writeEnum(1, this.type_);
            }

            int i;
            for (i = 0; i < this.productList_.size(); ++i) {
                output.writeString(2, (String) this.productList_.get(i));
            }

            for (i = 0; i < this.cardIssuerNoList_.size(); ++i) {
                output.writeString(3, (String) this.cardIssuerNoList_.get(i));
            }

            for (i = 0; i < this.codeIssuerNoList_.size(); ++i) {
                output.writeString(4, (String) this.codeIssuerNoList_.get(i));
            }

            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            } else {
                size = 0;
                if (this.type_ != IBusCloudSDKProto.MetaInfo.ChannelType.ZJRC_SCPP.getNumber()) {
                    size += CodedOutputStream.computeEnumSize(1, this.type_);
                }

                int dataSize = 0;

                int i;
                for (i = 0; i < this.productList_.size(); ++i) {
                    dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.productList_.get(i));
                }

                size += dataSize;
                size += 1 * this.getProductListList().size();
                dataSize = 0;

                for (i = 0; i < this.cardIssuerNoList_.size(); ++i) {
                    dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.cardIssuerNoList_.get(i));
                }

                size += dataSize;
                size += 1 * this.getCardIssuerNoListList().size();
                dataSize = 0;

                for (i = 0; i < this.codeIssuerNoList_.size(); ++i) {
                    dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.codeIssuerNoList_.get(i));
                }

                size += dataSize;
                size += 1 * this.getCodeIssuerNoListList().size();
                size += this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }
        }

        public static IBusCloudSDKProto.MetaInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.MetaInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.MetaInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.MetaInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.MetaInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.MetaInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.MetaInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.MetaInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.MetaInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.MetaInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.MetaInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.MetaInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.MetaInfo parseFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.MetaInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.MetaInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.MetaInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.MetaInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.MetaInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.MetaInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.MetaInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.MetaInfo parseFrom(CodedInputStream input) throws IOException {
            return (IBusCloudSDKProto.MetaInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.MetaInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.MetaInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.MetaInfo.Builder newBuilder() {
            return (IBusCloudSDKProto.MetaInfo.Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static IBusCloudSDKProto.MetaInfo.Builder newBuilder(IBusCloudSDKProto.MetaInfo prototype) {
            return (IBusCloudSDKProto.MetaInfo.Builder) DEFAULT_INSTANCE.createBuilder(prototype);
        }

        protected final Object dynamicMethod(MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new IBusCloudSDKProto.MetaInfo();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.productList_.makeImmutable();
                    this.cardIssuerNoList_.makeImmutable();
                    this.codeIssuerNoList_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new IBusCloudSDKProto.MetaInfo.Builder();
                case VISIT:
                    Visitor visitor = (Visitor) arg0;
                    IBusCloudSDKProto.MetaInfo other = (IBusCloudSDKProto.MetaInfo) arg1;
                    this.type_ = visitor.visitInt(this.type_ != 0, this.type_, other.type_ != 0, other.type_);
                    this.productList_ = visitor.visitList(this.productList_, other.productList_);
                    this.cardIssuerNoList_ = visitor.visitList(this.cardIssuerNoList_, other.cardIssuerNoList_);
                    this.codeIssuerNoList_ = visitor.visitList(this.codeIssuerNoList_, other.codeIssuerNoList_);
                    if (visitor == MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= other.bitField0_;
                    }

                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream input = (CodedInputStream) arg0;
                    ExtensionRegistryLite extensionRegistry = (ExtensionRegistryLite) arg1;
                    if (extensionRegistry == null) {
                        throw new NullPointerException();
                    } else {
                        try {
                            boolean done = false;

                            while (!done) {
                                int tag = input.readTag();
                                String s;
                                switch (tag) {
                                    case 0:
                                        done = true;
                                        break;
                                    case 8:
                                        int rawValue = input.readEnum();
                                        this.type_ = rawValue;
                                        break;
                                    case 18:
                                        s = input.readStringRequireUtf8();
                                        if (!this.productList_.isModifiable()) {
                                            this.productList_ = GeneratedMessageLite.mutableCopy(this.productList_);
                                        }

                                        this.productList_.add(s);
                                        break;
                                    case 26:
                                        s = input.readStringRequireUtf8();
                                        if (!this.cardIssuerNoList_.isModifiable()) {
                                            this.cardIssuerNoList_ = GeneratedMessageLite.mutableCopy(this.cardIssuerNoList_);
                                        }

                                        this.cardIssuerNoList_.add(s);
                                        break;
                                    case 34:
                                        s = input.readStringRequireUtf8();
                                        if (!this.codeIssuerNoList_.isModifiable()) {
                                            this.codeIssuerNoList_ = GeneratedMessageLite.mutableCopy(this.codeIssuerNoList_);
                                        }

                                        this.codeIssuerNoList_.add(s);
                                        break;
                                    default:
                                        if (!this.parseUnknownField(tag, input)) {
                                            done = true;
                                        }
                                }
                            }
                        } catch (InvalidProtocolBufferException var16) {
                            throw new RuntimeException(var16.setUnfinishedMessage(this));
                        } catch (IOException var17) {
                            throw new RuntimeException((new InvalidProtocolBufferException(var17.getMessage())).setUnfinishedMessage(this));
                        } finally {
                            ;
                        }
                    }
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    if (PARSER == null) {
                        Class var4 = IBusCloudSDKProto.MetaInfo.class;
                        synchronized (IBusCloudSDKProto.MetaInfo.class) {
                            if (PARSER == null) {
                                PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }

                    return PARSER;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static IBusCloudSDKProto.MetaInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MetaInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        static {
            DEFAULT_INSTANCE.makeImmutable();
        }

        public static final class Builder extends GeneratedMessageLite.Builder<MetaInfo, Builder> implements IBusCloudSDKProto.MetaInfoOrBuilder {
            private Builder() {
                super(IBusCloudSDKProto.MetaInfo.DEFAULT_INSTANCE);
            }

            public int getTypeValue() {
                return ((IBusCloudSDKProto.MetaInfo) this.instance).getTypeValue();
            }

            public IBusCloudSDKProto.MetaInfo.Builder setTypeValue(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).setTypeValue(value);
                return this;
            }

            public IBusCloudSDKProto.MetaInfo.ChannelType getType() {
                return ((IBusCloudSDKProto.MetaInfo) this.instance).getType();
            }

            public IBusCloudSDKProto.MetaInfo.Builder setType(IBusCloudSDKProto.MetaInfo.ChannelType value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).setType(value);
                return this;
            }

            public IBusCloudSDKProto.MetaInfo.Builder clearType() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).clearType();
                return this;
            }

            public List<String> getProductListList() {
                return Collections.unmodifiableList(((IBusCloudSDKProto.MetaInfo) this.instance).getProductListList());
            }

            public int getProductListCount() {
                return ((IBusCloudSDKProto.MetaInfo) this.instance).getProductListCount();
            }

            public String getProductList(int index) {
                return ((IBusCloudSDKProto.MetaInfo) this.instance).getProductList(index);
            }

            public ByteString getProductListBytes(int index) {
                return ((IBusCloudSDKProto.MetaInfo) this.instance).getProductListBytes(index);
            }

            public IBusCloudSDKProto.MetaInfo.Builder setProductList(int index, String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).setProductList(index, value);
                return this;
            }

            public IBusCloudSDKProto.MetaInfo.Builder addProductList(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).addProductList(value);
                return this;
            }

            public IBusCloudSDKProto.MetaInfo.Builder addAllProductList(Iterable<String> values) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).addAllProductList(values);
                return this;
            }

            public IBusCloudSDKProto.MetaInfo.Builder clearProductList() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).clearProductList();
                return this;
            }

            public IBusCloudSDKProto.MetaInfo.Builder addProductListBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).addProductListBytes(value);
                return this;
            }

            public List<String> getCardIssuerNoListList() {
                return Collections.unmodifiableList(((IBusCloudSDKProto.MetaInfo) this.instance).getCardIssuerNoListList());
            }

            public int getCardIssuerNoListCount() {
                return ((IBusCloudSDKProto.MetaInfo) this.instance).getCardIssuerNoListCount();
            }

            public String getCardIssuerNoList(int index) {
                return ((IBusCloudSDKProto.MetaInfo) this.instance).getCardIssuerNoList(index);
            }

            public ByteString getCardIssuerNoListBytes(int index) {
                return ((IBusCloudSDKProto.MetaInfo) this.instance).getCardIssuerNoListBytes(index);
            }

            public IBusCloudSDKProto.MetaInfo.Builder setCardIssuerNoList(int index, String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).setCardIssuerNoList(index, value);
                return this;
            }

            public IBusCloudSDKProto.MetaInfo.Builder addCardIssuerNoList(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).addCardIssuerNoList(value);
                return this;
            }

            public IBusCloudSDKProto.MetaInfo.Builder addAllCardIssuerNoList(Iterable<String> values) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).addAllCardIssuerNoList(values);
                return this;
            }

            public IBusCloudSDKProto.MetaInfo.Builder clearCardIssuerNoList() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).clearCardIssuerNoList();
                return this;
            }

            public IBusCloudSDKProto.MetaInfo.Builder addCardIssuerNoListBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).addCardIssuerNoListBytes(value);
                return this;
            }

            public List<String> getCodeIssuerNoListList() {
                return Collections.unmodifiableList(((IBusCloudSDKProto.MetaInfo) this.instance).getCodeIssuerNoListList());
            }

            public int getCodeIssuerNoListCount() {
                return ((IBusCloudSDKProto.MetaInfo) this.instance).getCodeIssuerNoListCount();
            }

            public String getCodeIssuerNoList(int index) {
                return ((IBusCloudSDKProto.MetaInfo) this.instance).getCodeIssuerNoList(index);
            }

            public ByteString getCodeIssuerNoListBytes(int index) {
                return ((IBusCloudSDKProto.MetaInfo) this.instance).getCodeIssuerNoListBytes(index);
            }

            public IBusCloudSDKProto.MetaInfo.Builder setCodeIssuerNoList(int index, String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).setCodeIssuerNoList(index, value);
                return this;
            }

            public IBusCloudSDKProto.MetaInfo.Builder addCodeIssuerNoList(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).addCodeIssuerNoList(value);
                return this;
            }

            public IBusCloudSDKProto.MetaInfo.Builder addAllCodeIssuerNoList(Iterable<String> values) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).addAllCodeIssuerNoList(values);
                return this;
            }

            public IBusCloudSDKProto.MetaInfo.Builder clearCodeIssuerNoList() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).clearCodeIssuerNoList();
                return this;
            }

            public IBusCloudSDKProto.MetaInfo.Builder addCodeIssuerNoListBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.MetaInfo) this.instance).addCodeIssuerNoListBytes(value);
                return this;
            }
        }

        public static enum ChannelType implements EnumLite {
            ZJRC_SCPP(0),
            UNRECOGNIZED(-1);

            public static final int ZJRC_SCPP_VALUE = 0;
            private static final EnumLiteMap<ChannelType> internalValueMap = new EnumLiteMap<ChannelType>() {
                public IBusCloudSDKProto.MetaInfo.ChannelType findValueByNumber(int number) {
                    return IBusCloudSDKProto.MetaInfo.ChannelType.forNumber(number);
                }
            };
            private final int value;

            public final int getNumber() {
                if (this == UNRECOGNIZED) {
                    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                } else {
                    return this.value;
                }
            }

            /**
             * @deprecated
             */
            @Deprecated
            public static IBusCloudSDKProto.MetaInfo.ChannelType valueOf(int value) {
                return forNumber(value);
            }

            public static IBusCloudSDKProto.MetaInfo.ChannelType forNumber(int value) {
                switch (value) {
                    case 0:
                        return ZJRC_SCPP;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<ChannelType> internalGetValueMap() {
                return internalValueMap;
            }

            private ChannelType(int value) {
                this.value = value;
            }
        }
    }

    public interface MetaInfoOrBuilder extends MessageLiteOrBuilder {
        int getTypeValue();

        IBusCloudSDKProto.MetaInfo.ChannelType getType();

        List<String> getProductListList();

        int getProductListCount();

        String getProductList(int var1);

        ByteString getProductListBytes(int var1);

        List<String> getCardIssuerNoListList();

        int getCardIssuerNoListCount();

        String getCardIssuerNoList(int var1);

        ByteString getCardIssuerNoListBytes(int var1);

        List<String> getCodeIssuerNoListList();

        int getCodeIssuerNoListCount();

        String getCodeIssuerNoList(int var1);

        ByteString getCodeIssuerNoListBytes(int var1);
    }

    public static final class OnlineVerifyResponse extends GeneratedMessageLite<OnlineVerifyResponse, OnlineVerifyResponse.Builder> implements IBusCloudSDKProto.OnlineVerifyResponseOrBuilder {
        public static final int RESP_CODE_FIELD_NUMBER = 1;
        private int respCode_;
        public static final int RESP_MSG_FIELD_NUMBER = 2;
        private String respMsg_ = "";
        public static final int RESP_DATA_FIELD_NUMBER = 3;
        private ByteString respData_;
        private static final IBusCloudSDKProto.OnlineVerifyResponse DEFAULT_INSTANCE = new IBusCloudSDKProto.OnlineVerifyResponse();
        private static volatile Parser<OnlineVerifyResponse> PARSER;

        private OnlineVerifyResponse() {
            this.respData_ = ByteString.EMPTY;
        }

        public int getRespCode() {
            return this.respCode_;
        }

        private void setRespCode(int value) {
            this.respCode_ = value;
        }

        private void clearRespCode() {
            this.respCode_ = 0;
        }

        public String getRespMsg() {
            return this.respMsg_;
        }

        public ByteString getRespMsgBytes() {
            return ByteString.copyFromUtf8(this.respMsg_);
        }

        private void setRespMsg(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.respMsg_ = value;
            }
        }

        private void clearRespMsg() {
            this.respMsg_ = getDefaultInstance().getRespMsg();
        }

        private void setRespMsgBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.respMsg_ = value.toStringUtf8();
            }
        }

        public ByteString getRespData() {
            return this.respData_;
        }

        private void setRespData(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.respData_ = value;
            }
        }

        private void clearRespData() {
            this.respData_ = getDefaultInstance().getRespData();
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.respCode_ != 0) {
                output.writeInt32(1, this.respCode_);
            }

            if (!this.respMsg_.isEmpty()) {
                output.writeString(2, this.getRespMsg());
            }

            if (!this.respData_.isEmpty()) {
                output.writeBytes(3, this.respData_);
            }

            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            } else {
                size = 0;
                if (this.respCode_ != 0) {
                    size += CodedOutputStream.computeInt32Size(1, this.respCode_);
                }

                if (!this.respMsg_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(2, this.getRespMsg());
                }

                if (!this.respData_.isEmpty()) {
                    size += CodedOutputStream.computeBytesSize(3, this.respData_);
                }

                size += this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }
        }

        public static IBusCloudSDKProto.OnlineVerifyResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.OnlineVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.OnlineVerifyResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.OnlineVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.OnlineVerifyResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.OnlineVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.OnlineVerifyResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.OnlineVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.OnlineVerifyResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.OnlineVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.OnlineVerifyResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.OnlineVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.OnlineVerifyResponse parseFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.OnlineVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.OnlineVerifyResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.OnlineVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.OnlineVerifyResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.OnlineVerifyResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.OnlineVerifyResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.OnlineVerifyResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.OnlineVerifyResponse parseFrom(CodedInputStream input) throws IOException {
            return (IBusCloudSDKProto.OnlineVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.OnlineVerifyResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.OnlineVerifyResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.OnlineVerifyResponse.Builder newBuilder() {
            return (IBusCloudSDKProto.OnlineVerifyResponse.Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static IBusCloudSDKProto.OnlineVerifyResponse.Builder newBuilder(IBusCloudSDKProto.OnlineVerifyResponse prototype) {
            return (IBusCloudSDKProto.OnlineVerifyResponse.Builder) DEFAULT_INSTANCE.createBuilder(prototype);
        }

        protected final Object dynamicMethod(MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new IBusCloudSDKProto.OnlineVerifyResponse();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new IBusCloudSDKProto.OnlineVerifyResponse.Builder();
                case VISIT:
                    Visitor visitor = (Visitor) arg0;
                    IBusCloudSDKProto.OnlineVerifyResponse other = (IBusCloudSDKProto.OnlineVerifyResponse) arg1;
                    this.respCode_ = visitor.visitInt(this.respCode_ != 0, this.respCode_, other.respCode_ != 0, other.respCode_);
                    this.respMsg_ = visitor.visitString(!this.respMsg_.isEmpty(), this.respMsg_, !other.respMsg_.isEmpty(), other.respMsg_);
                    this.respData_ = visitor.visitByteString(this.respData_ != ByteString.EMPTY, this.respData_, other.respData_ != ByteString.EMPTY, other.respData_);
                    if (visitor == MergeFromVisitor.INSTANCE) {
                        ;
                    }

                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream input = (CodedInputStream) arg0;
                    ExtensionRegistryLite extensionRegistry = (ExtensionRegistryLite) arg1;
                    if (extensionRegistry == null) {
                        throw new NullPointerException();
                    } else {
                        try {
                            boolean done = false;

                            while (!done) {
                                int tag = input.readTag();
                                switch (tag) {
                                    case 0:
                                        done = true;
                                        break;
                                    case 8:
                                        this.respCode_ = input.readInt32();
                                        break;
                                    case 18:
                                        String s = input.readStringRequireUtf8();
                                        this.respMsg_ = s;
                                        break;
                                    case 26:
                                        this.respData_ = input.readBytes();
                                        break;
                                    default:
                                        if (!this.parseUnknownField(tag, input)) {
                                            done = true;
                                        }
                                }
                            }
                        } catch (InvalidProtocolBufferException var16) {
                            throw new RuntimeException(var16.setUnfinishedMessage(this));
                        } catch (IOException var17) {
                            throw new RuntimeException((new InvalidProtocolBufferException(var17.getMessage())).setUnfinishedMessage(this));
                        } finally {
                            ;
                        }
                    }
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    if (PARSER == null) {
                        Class var4 = IBusCloudSDKProto.OnlineVerifyResponse.class;
                        synchronized (IBusCloudSDKProto.OnlineVerifyResponse.class) {
                            if (PARSER == null) {
                                PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }

                    return PARSER;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static IBusCloudSDKProto.OnlineVerifyResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OnlineVerifyResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        static {
            DEFAULT_INSTANCE.makeImmutable();
        }

        public static final class Builder extends GeneratedMessageLite.Builder<OnlineVerifyResponse, Builder> implements IBusCloudSDKProto.OnlineVerifyResponseOrBuilder {
            private Builder() {
                super(IBusCloudSDKProto.OnlineVerifyResponse.DEFAULT_INSTANCE);
            }

            public int getRespCode() {
                return ((IBusCloudSDKProto.OnlineVerifyResponse) this.instance).getRespCode();
            }

            public IBusCloudSDKProto.OnlineVerifyResponse.Builder setRespCode(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyResponse) this.instance).setRespCode(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyResponse.Builder clearRespCode() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyResponse) this.instance).clearRespCode();
                return this;
            }

            public String getRespMsg() {
                return ((IBusCloudSDKProto.OnlineVerifyResponse) this.instance).getRespMsg();
            }

            public ByteString getRespMsgBytes() {
                return ((IBusCloudSDKProto.OnlineVerifyResponse) this.instance).getRespMsgBytes();
            }

            public IBusCloudSDKProto.OnlineVerifyResponse.Builder setRespMsg(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyResponse) this.instance).setRespMsg(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyResponse.Builder clearRespMsg() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyResponse) this.instance).clearRespMsg();
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyResponse.Builder setRespMsgBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyResponse) this.instance).setRespMsgBytes(value);
                return this;
            }

            public ByteString getRespData() {
                return ((IBusCloudSDKProto.OnlineVerifyResponse) this.instance).getRespData();
            }

            public IBusCloudSDKProto.OnlineVerifyResponse.Builder setRespData(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyResponse) this.instance).setRespData(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyResponse.Builder clearRespData() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyResponse) this.instance).clearRespData();
                return this;
            }
        }
    }

    public interface OnlineVerifyResponseOrBuilder extends MessageLiteOrBuilder {
        int getRespCode();

        String getRespMsg();

        ByteString getRespMsgBytes();

        ByteString getRespData();
    }

    public static final class OnlineVerifyRequest extends GeneratedMessageLite<OnlineVerifyRequest, OnlineVerifyRequest.Builder> implements IBusCloudSDKProto.OnlineVerifyRequestOrBuilder {
        public static final int VERSION_FIELD_NUMBER = 1;
        private String version_ = "";
        public static final int POS_ID_FIELD_NUMBER = 2;
        private String posId_ = "";
        public static final int BUS_ID_FIELD_NUMBER = 3;
        private String busId_ = "";
        public static final int ROUTE_ID_FIELD_NUMBER = 4;
        private String routeId_ = "";
        public static final int CITY_ID_FIELD_NUMBER = 5;
        private String cityId_ = "";
        public static final int TICKET_PRICE_FIELD_NUMBER = 6;
        private int ticketPrice_;
        public static final int COST_FIELD_NUMBER = 7;
        private int cost_;
        public static final int TIME_STAMP_FIELD_NUMBER = 8;
        private int timeStamp_;
        public static final int UNIQUE_RECORD_FIELD_NUMBER = 9;
        private String uniqueRecord_ = "";
        public static final int VERIFY_AREA_FIELD_NUMBER = 10;
        private ByteString verifyArea_;
        public static final int LONGITUDE_FIELD_NUMBER = 16;
        private double longitude_;
        public static final int LATITUDE_FIELD_NUMBER = 17;
        private double latitude_;
        public static final int DRIVER_ID_FIELD_NUMBER = 18;
        private String driverId_;
        public static final int ATTENDANCE_TIME_FIELD_NUMBER = 19;
        private int attendanceTime_;
        public static final int COMPANY_ID_FIELD_NUMBER = 20;
        private String companyId_;
        public static final int FLEET_CODE_FIELD_NUMBER = 22;
        private String fleetCode_;
        private static final IBusCloudSDKProto.OnlineVerifyRequest DEFAULT_INSTANCE = new IBusCloudSDKProto.OnlineVerifyRequest();
        private static volatile Parser<OnlineVerifyRequest> PARSER;

        private OnlineVerifyRequest() {
            this.verifyArea_ = ByteString.EMPTY;
            this.driverId_ = "";
            this.companyId_ = "";
            this.fleetCode_ = "";
        }

        public String getVersion() {
            return this.version_;
        }

        public ByteString getVersionBytes() {
            return ByteString.copyFromUtf8(this.version_);
        }

        private void setVersion(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.version_ = value;
            }
        }

        private void clearVersion() {
            this.version_ = getDefaultInstance().getVersion();
        }

        private void setVersionBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.version_ = value.toStringUtf8();
            }
        }

        public String getPosId() {
            return this.posId_;
        }

        public ByteString getPosIdBytes() {
            return ByteString.copyFromUtf8(this.posId_);
        }

        private void setPosId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.posId_ = value;
            }
        }

        private void clearPosId() {
            this.posId_ = getDefaultInstance().getPosId();
        }

        private void setPosIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.posId_ = value.toStringUtf8();
            }
        }

        public String getBusId() {
            return this.busId_;
        }

        public ByteString getBusIdBytes() {
            return ByteString.copyFromUtf8(this.busId_);
        }

        private void setBusId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.busId_ = value;
            }
        }

        private void clearBusId() {
            this.busId_ = getDefaultInstance().getBusId();
        }

        private void setBusIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.busId_ = value.toStringUtf8();
            }
        }

        public String getRouteId() {
            return this.routeId_;
        }

        public ByteString getRouteIdBytes() {
            return ByteString.copyFromUtf8(this.routeId_);
        }

        private void setRouteId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.routeId_ = value;
            }
        }

        private void clearRouteId() {
            this.routeId_ = getDefaultInstance().getRouteId();
        }

        private void setRouteIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.routeId_ = value.toStringUtf8();
            }
        }

        public String getCityId() {
            return this.cityId_;
        }

        public ByteString getCityIdBytes() {
            return ByteString.copyFromUtf8(this.cityId_);
        }

        private void setCityId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.cityId_ = value;
            }
        }

        private void clearCityId() {
            this.cityId_ = getDefaultInstance().getCityId();
        }

        private void setCityIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.cityId_ = value.toStringUtf8();
            }
        }

        public int getTicketPrice() {
            return this.ticketPrice_;
        }

        private void setTicketPrice(int value) {
            this.ticketPrice_ = value;
        }

        private void clearTicketPrice() {
            this.ticketPrice_ = 0;
        }

        public int getCost() {
            return this.cost_;
        }

        private void setCost(int value) {
            this.cost_ = value;
        }

        private void clearCost() {
            this.cost_ = 0;
        }

        public int getTimeStamp() {
            return this.timeStamp_;
        }

        private void setTimeStamp(int value) {
            this.timeStamp_ = value;
        }

        private void clearTimeStamp() {
            this.timeStamp_ = 0;
        }

        public String getUniqueRecord() {
            return this.uniqueRecord_;
        }

        public ByteString getUniqueRecordBytes() {
            return ByteString.copyFromUtf8(this.uniqueRecord_);
        }

        private void setUniqueRecord(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.uniqueRecord_ = value;
            }
        }

        private void clearUniqueRecord() {
            this.uniqueRecord_ = getDefaultInstance().getUniqueRecord();
        }

        private void setUniqueRecordBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.uniqueRecord_ = value.toStringUtf8();
            }
        }

        public ByteString getVerifyArea() {
            return this.verifyArea_;
        }

        private void setVerifyArea(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.verifyArea_ = value;
            }
        }

        private void clearVerifyArea() {
            this.verifyArea_ = getDefaultInstance().getVerifyArea();
        }

        public double getLongitude() {
            return this.longitude_;
        }

        private void setLongitude(double value) {
            this.longitude_ = value;
        }

        private void clearLongitude() {
            this.longitude_ = 0.0D;
        }

        public double getLatitude() {
            return this.latitude_;
        }

        private void setLatitude(double value) {
            this.latitude_ = value;
        }

        private void clearLatitude() {
            this.latitude_ = 0.0D;
        }

        public String getDriverId() {
            return this.driverId_;
        }

        public ByteString getDriverIdBytes() {
            return ByteString.copyFromUtf8(this.driverId_);
        }

        private void setDriverId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.driverId_ = value;
            }
        }

        private void clearDriverId() {
            this.driverId_ = getDefaultInstance().getDriverId();
        }

        private void setDriverIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.driverId_ = value.toStringUtf8();
            }
        }

        public int getAttendanceTime() {
            return this.attendanceTime_;
        }

        private void setAttendanceTime(int value) {
            this.attendanceTime_ = value;
        }

        private void clearAttendanceTime() {
            this.attendanceTime_ = 0;
        }

        public String getCompanyId() {
            return this.companyId_;
        }

        public ByteString getCompanyIdBytes() {
            return ByteString.copyFromUtf8(this.companyId_);
        }

        private void setCompanyId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.companyId_ = value;
            }
        }

        private void clearCompanyId() {
            this.companyId_ = getDefaultInstance().getCompanyId();
        }

        private void setCompanyIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.companyId_ = value.toStringUtf8();
            }
        }

        public String getFleetCode() {
            return this.fleetCode_;
        }

        public ByteString getFleetCodeBytes() {
            return ByteString.copyFromUtf8(this.fleetCode_);
        }

        private void setFleetCode(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.fleetCode_ = value;
            }
        }

        private void clearFleetCode() {
            this.fleetCode_ = getDefaultInstance().getFleetCode();
        }

        private void setFleetCodeBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.fleetCode_ = value.toStringUtf8();
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (!this.version_.isEmpty()) {
                output.writeString(1, this.getVersion());
            }

            if (!this.posId_.isEmpty()) {
                output.writeString(2, this.getPosId());
            }

            if (!this.busId_.isEmpty()) {
                output.writeString(3, this.getBusId());
            }

            if (!this.routeId_.isEmpty()) {
                output.writeString(4, this.getRouteId());
            }

            if (!this.cityId_.isEmpty()) {
                output.writeString(5, this.getCityId());
            }

            if (this.ticketPrice_ != 0) {
                output.writeInt32(6, this.ticketPrice_);
            }

            if (this.cost_ != 0) {
                output.writeInt32(7, this.cost_);
            }

            if (this.timeStamp_ != 0) {
                output.writeInt32(8, this.timeStamp_);
            }

            if (!this.uniqueRecord_.isEmpty()) {
                output.writeString(9, this.getUniqueRecord());
            }

            if (!this.verifyArea_.isEmpty()) {
                output.writeBytes(10, this.verifyArea_);
            }

            if (this.longitude_ != 0.0D) {
                output.writeDouble(16, this.longitude_);
            }

            if (this.latitude_ != 0.0D) {
                output.writeDouble(17, this.latitude_);
            }

            if (!this.driverId_.isEmpty()) {
                output.writeString(18, this.getDriverId());
            }

            if (this.attendanceTime_ != 0) {
                output.writeInt32(19, this.attendanceTime_);
            }

            if (!this.companyId_.isEmpty()) {
                output.writeString(20, this.getCompanyId());
            }

            if (!this.fleetCode_.isEmpty()) {
                output.writeString(22, this.getFleetCode());
            }

            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            } else {
                size = 0;
                if (!this.version_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(1, this.getVersion());
                }

                if (!this.posId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(2, this.getPosId());
                }

                if (!this.busId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(3, this.getBusId());
                }

                if (!this.routeId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(4, this.getRouteId());
                }

                if (!this.cityId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(5, this.getCityId());
                }

                if (this.ticketPrice_ != 0) {
                    size += CodedOutputStream.computeInt32Size(6, this.ticketPrice_);
                }

                if (this.cost_ != 0) {
                    size += CodedOutputStream.computeInt32Size(7, this.cost_);
                }

                if (this.timeStamp_ != 0) {
                    size += CodedOutputStream.computeInt32Size(8, this.timeStamp_);
                }

                if (!this.uniqueRecord_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(9, this.getUniqueRecord());
                }

                if (!this.verifyArea_.isEmpty()) {
                    size += CodedOutputStream.computeBytesSize(10, this.verifyArea_);
                }

                if (this.longitude_ != 0.0D) {
                    size += CodedOutputStream.computeDoubleSize(16, this.longitude_);
                }

                if (this.latitude_ != 0.0D) {
                    size += CodedOutputStream.computeDoubleSize(17, this.latitude_);
                }

                if (!this.driverId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(18, this.getDriverId());
                }

                if (this.attendanceTime_ != 0) {
                    size += CodedOutputStream.computeInt32Size(19, this.attendanceTime_);
                }

                if (!this.companyId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(20, this.getCompanyId());
                }

                if (!this.fleetCode_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(22, this.getFleetCode());
                }

                size += this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }
        }

        public static IBusCloudSDKProto.OnlineVerifyRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.OnlineVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.OnlineVerifyRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.OnlineVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.OnlineVerifyRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.OnlineVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.OnlineVerifyRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.OnlineVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.OnlineVerifyRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.OnlineVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.OnlineVerifyRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.OnlineVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.OnlineVerifyRequest parseFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.OnlineVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.OnlineVerifyRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.OnlineVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.OnlineVerifyRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.OnlineVerifyRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.OnlineVerifyRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.OnlineVerifyRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.OnlineVerifyRequest parseFrom(CodedInputStream input) throws IOException {
            return (IBusCloudSDKProto.OnlineVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.OnlineVerifyRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.OnlineVerifyRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.OnlineVerifyRequest.Builder newBuilder() {
            return (IBusCloudSDKProto.OnlineVerifyRequest.Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static IBusCloudSDKProto.OnlineVerifyRequest.Builder newBuilder(IBusCloudSDKProto.OnlineVerifyRequest prototype) {
            return (IBusCloudSDKProto.OnlineVerifyRequest.Builder) DEFAULT_INSTANCE.createBuilder(prototype);
        }

        protected final Object dynamicMethod(MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new IBusCloudSDKProto.OnlineVerifyRequest();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new IBusCloudSDKProto.OnlineVerifyRequest.Builder();
                case VISIT:
                    Visitor visitor = (Visitor) arg0;
                    IBusCloudSDKProto.OnlineVerifyRequest other = (IBusCloudSDKProto.OnlineVerifyRequest) arg1;
                    this.version_ = visitor.visitString(!this.version_.isEmpty(), this.version_, !other.version_.isEmpty(), other.version_);
                    this.posId_ = visitor.visitString(!this.posId_.isEmpty(), this.posId_, !other.posId_.isEmpty(), other.posId_);
                    this.busId_ = visitor.visitString(!this.busId_.isEmpty(), this.busId_, !other.busId_.isEmpty(), other.busId_);
                    this.routeId_ = visitor.visitString(!this.routeId_.isEmpty(), this.routeId_, !other.routeId_.isEmpty(), other.routeId_);
                    this.cityId_ = visitor.visitString(!this.cityId_.isEmpty(), this.cityId_, !other.cityId_.isEmpty(), other.cityId_);
                    this.ticketPrice_ = visitor.visitInt(this.ticketPrice_ != 0, this.ticketPrice_, other.ticketPrice_ != 0, other.ticketPrice_);
                    this.cost_ = visitor.visitInt(this.cost_ != 0, this.cost_, other.cost_ != 0, other.cost_);
                    this.timeStamp_ = visitor.visitInt(this.timeStamp_ != 0, this.timeStamp_, other.timeStamp_ != 0, other.timeStamp_);
                    this.uniqueRecord_ = visitor.visitString(!this.uniqueRecord_.isEmpty(), this.uniqueRecord_, !other.uniqueRecord_.isEmpty(), other.uniqueRecord_);
                    this.verifyArea_ = visitor.visitByteString(this.verifyArea_ != ByteString.EMPTY, this.verifyArea_, other.verifyArea_ != ByteString.EMPTY, other.verifyArea_);
                    this.longitude_ = visitor.visitDouble(this.longitude_ != 0.0D, this.longitude_, other.longitude_ != 0.0D, other.longitude_);
                    this.latitude_ = visitor.visitDouble(this.latitude_ != 0.0D, this.latitude_, other.latitude_ != 0.0D, other.latitude_);
                    this.driverId_ = visitor.visitString(!this.driverId_.isEmpty(), this.driverId_, !other.driverId_.isEmpty(), other.driverId_);
                    this.attendanceTime_ = visitor.visitInt(this.attendanceTime_ != 0, this.attendanceTime_, other.attendanceTime_ != 0, other.attendanceTime_);
                    this.companyId_ = visitor.visitString(!this.companyId_.isEmpty(), this.companyId_, !other.companyId_.isEmpty(), other.companyId_);
                    this.fleetCode_ = visitor.visitString(!this.fleetCode_.isEmpty(), this.fleetCode_, !other.fleetCode_.isEmpty(), other.fleetCode_);
                    if (visitor == MergeFromVisitor.INSTANCE) {
                        ;
                    }

                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream input = (CodedInputStream) arg0;
                    ExtensionRegistryLite extensionRegistry = (ExtensionRegistryLite) arg1;
                    if (extensionRegistry == null) {
                        throw new NullPointerException();
                    } else {
                        try {
                            boolean done = false;

                            while (!done) {
                                int tag = input.readTag();
                                String s;
                                switch (tag) {
                                    case 0:
                                        done = true;
                                        break;
                                    case 10:
                                        s = input.readStringRequireUtf8();
                                        this.version_ = s;
                                        break;
                                    case 18:
                                        s = input.readStringRequireUtf8();
                                        this.posId_ = s;
                                        break;
                                    case 26:
                                        s = input.readStringRequireUtf8();
                                        this.busId_ = s;
                                        break;
                                    case 34:
                                        s = input.readStringRequireUtf8();
                                        this.routeId_ = s;
                                        break;
                                    case 42:
                                        s = input.readStringRequireUtf8();
                                        this.cityId_ = s;
                                        break;
                                    case 48:
                                        this.ticketPrice_ = input.readInt32();
                                        break;
                                    case 56:
                                        this.cost_ = input.readInt32();
                                        break;
                                    case 64:
                                        this.timeStamp_ = input.readInt32();
                                        break;
                                    case 74:
                                        s = input.readStringRequireUtf8();
                                        this.uniqueRecord_ = s;
                                        break;
                                    case 82:
                                        this.verifyArea_ = input.readBytes();
                                        break;
                                    case 129:
                                        this.longitude_ = input.readDouble();
                                        break;
                                    case 137:
                                        this.latitude_ = input.readDouble();
                                        break;
                                    case 146:
                                        s = input.readStringRequireUtf8();
                                        this.driverId_ = s;
                                        break;
                                    case 152:
                                        this.attendanceTime_ = input.readInt32();
                                        break;
                                    case 162:
                                        s = input.readStringRequireUtf8();
                                        this.companyId_ = s;
                                        break;
                                    case 178:
                                        s = input.readStringRequireUtf8();
                                        this.fleetCode_ = s;
                                        break;
                                    default:
                                        if (!this.parseUnknownField(tag, input)) {
                                            done = true;
                                        }
                                }
                            }
                        } catch (InvalidProtocolBufferException var16) {
                            throw new RuntimeException(var16.setUnfinishedMessage(this));
                        } catch (IOException var17) {
                            throw new RuntimeException((new InvalidProtocolBufferException(var17.getMessage())).setUnfinishedMessage(this));
                        } finally {
                            ;
                        }
                    }
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    if (PARSER == null) {
                        Class var4 = IBusCloudSDKProto.OnlineVerifyRequest.class;
                        synchronized (IBusCloudSDKProto.OnlineVerifyRequest.class) {
                            if (PARSER == null) {
                                PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }

                    return PARSER;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static IBusCloudSDKProto.OnlineVerifyRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<OnlineVerifyRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        static {
            DEFAULT_INSTANCE.makeImmutable();
        }

        public static final class Builder extends GeneratedMessageLite.Builder<OnlineVerifyRequest, Builder> implements IBusCloudSDKProto.OnlineVerifyRequestOrBuilder {
            private Builder() {
                super(IBusCloudSDKProto.OnlineVerifyRequest.DEFAULT_INSTANCE);
            }

            public String getVersion() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getVersion();
            }

            public ByteString getVersionBytes() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getVersionBytes();
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setVersion(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setVersion(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder clearVersion() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).clearVersion();
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setVersionBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setVersionBytes(value);
                return this;
            }

            public String getPosId() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getPosId();
            }

            public ByteString getPosIdBytes() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getPosIdBytes();
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setPosId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setPosId(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder clearPosId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).clearPosId();
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setPosIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setPosIdBytes(value);
                return this;
            }

            public String getBusId() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getBusId();
            }

            public ByteString getBusIdBytes() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getBusIdBytes();
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setBusId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setBusId(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder clearBusId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).clearBusId();
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setBusIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setBusIdBytes(value);
                return this;
            }

            public String getRouteId() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getRouteId();
            }

            public ByteString getRouteIdBytes() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getRouteIdBytes();
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setRouteId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setRouteId(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder clearRouteId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).clearRouteId();
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setRouteIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setRouteIdBytes(value);
                return this;
            }

            public String getCityId() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getCityId();
            }

            public ByteString getCityIdBytes() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getCityIdBytes();
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setCityId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setCityId(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder clearCityId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).clearCityId();
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setCityIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setCityIdBytes(value);
                return this;
            }

            public int getTicketPrice() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getTicketPrice();
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setTicketPrice(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setTicketPrice(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder clearTicketPrice() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).clearTicketPrice();
                return this;
            }

            public int getCost() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getCost();
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setCost(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setCost(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder clearCost() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).clearCost();
                return this;
            }

            public int getTimeStamp() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getTimeStamp();
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setTimeStamp(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setTimeStamp(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder clearTimeStamp() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).clearTimeStamp();
                return this;
            }

            public String getUniqueRecord() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getUniqueRecord();
            }

            public ByteString getUniqueRecordBytes() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getUniqueRecordBytes();
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setUniqueRecord(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setUniqueRecord(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder clearUniqueRecord() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).clearUniqueRecord();
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setUniqueRecordBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setUniqueRecordBytes(value);
                return this;
            }

            public ByteString getVerifyArea() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getVerifyArea();
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setVerifyArea(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setVerifyArea(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder clearVerifyArea() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).clearVerifyArea();
                return this;
            }

            public double getLongitude() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getLongitude();
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setLongitude(double value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setLongitude(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder clearLongitude() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).clearLongitude();
                return this;
            }

            public double getLatitude() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getLatitude();
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setLatitude(double value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setLatitude(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder clearLatitude() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).clearLatitude();
                return this;
            }

            public String getDriverId() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getDriverId();
            }

            public ByteString getDriverIdBytes() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getDriverIdBytes();
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setDriverId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setDriverId(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder clearDriverId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).clearDriverId();
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setDriverIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setDriverIdBytes(value);
                return this;
            }

            public int getAttendanceTime() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getAttendanceTime();
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setAttendanceTime(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setAttendanceTime(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder clearAttendanceTime() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).clearAttendanceTime();
                return this;
            }

            public String getCompanyId() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getCompanyId();
            }

            public ByteString getCompanyIdBytes() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getCompanyIdBytes();
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setCompanyId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setCompanyId(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder clearCompanyId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).clearCompanyId();
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setCompanyIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setCompanyIdBytes(value);
                return this;
            }

            public String getFleetCode() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getFleetCode();
            }

            public ByteString getFleetCodeBytes() {
                return ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).getFleetCodeBytes();
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setFleetCode(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setFleetCode(value);
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder clearFleetCode() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).clearFleetCode();
                return this;
            }

            public IBusCloudSDKProto.OnlineVerifyRequest.Builder setFleetCodeBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.OnlineVerifyRequest) this.instance).setFleetCodeBytes(value);
                return this;
            }
        }
    }

    public interface OnlineVerifyRequestOrBuilder extends MessageLiteOrBuilder {
        String getVersion();

        ByteString getVersionBytes();

        String getPosId();

        ByteString getPosIdBytes();

        String getBusId();

        ByteString getBusIdBytes();

        String getRouteId();

        ByteString getRouteIdBytes();

        String getCityId();

        ByteString getCityIdBytes();

        int getTicketPrice();

        int getCost();

        int getTimeStamp();

        String getUniqueRecord();

        ByteString getUniqueRecordBytes();

        ByteString getVerifyArea();

        double getLongitude();

        double getLatitude();

        String getDriverId();

        ByteString getDriverIdBytes();

        int getAttendanceTime();

        String getCompanyId();

        ByteString getCompanyIdBytes();

        String getFleetCode();

        ByteString getFleetCodeBytes();
    }

    public static final class SystemInfo extends GeneratedMessageLite<SystemInfo, SystemInfo.Builder> implements IBusCloudSDKProto.SystemInfoOrBuilder {
        public static final int HOST_NAME_FIELD_NUMBER = 1;
        private String hostName_ = "";
        public static final int HOST_IP_FIELD_NUMBER = 2;
        private String hostIp_ = "";
        public static final int PORT_FIELD_NUMBER = 3;
        private int port_;
        public static final int CONN_TIMEOUT_MILIS_FIELD_NUMBER = 4;
        private int connTimeoutMilis_;
        public static final int SEND_TIMEOUT_MILIS_FIELD_NUMBER = 5;
        private int sendTimeoutMilis_;
        public static final int RECV_TIMEOUT_MILIS_FIELD_NUMBER = 6;
        private int recvTimeoutMilis_;
        private static final IBusCloudSDKProto.SystemInfo DEFAULT_INSTANCE = new IBusCloudSDKProto.SystemInfo();
        private static volatile Parser<SystemInfo> PARSER;

        private SystemInfo() {
        }

        public String getHostName() {
            return this.hostName_;
        }

        public ByteString getHostNameBytes() {
            return ByteString.copyFromUtf8(this.hostName_);
        }

        private void setHostName(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.hostName_ = value;
            }
        }

        private void clearHostName() {
            this.hostName_ = getDefaultInstance().getHostName();
        }

        private void setHostNameBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.hostName_ = value.toStringUtf8();
            }
        }

        public String getHostIp() {
            return this.hostIp_;
        }

        public ByteString getHostIpBytes() {
            return ByteString.copyFromUtf8(this.hostIp_);
        }

        private void setHostIp(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.hostIp_ = value;
            }
        }

        private void clearHostIp() {
            this.hostIp_ = getDefaultInstance().getHostIp();
        }

        private void setHostIpBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.hostIp_ = value.toStringUtf8();
            }
        }

        public int getPort() {
            return this.port_;
        }

        private void setPort(int value) {
            this.port_ = value;
        }

        private void clearPort() {
            this.port_ = 0;
        }

        public int getConnTimeoutMilis() {
            return this.connTimeoutMilis_;
        }

        private void setConnTimeoutMilis(int value) {
            this.connTimeoutMilis_ = value;
        }

        private void clearConnTimeoutMilis() {
            this.connTimeoutMilis_ = 0;
        }

        public int getSendTimeoutMilis() {
            return this.sendTimeoutMilis_;
        }

        private void setSendTimeoutMilis(int value) {
            this.sendTimeoutMilis_ = value;
        }

        private void clearSendTimeoutMilis() {
            this.sendTimeoutMilis_ = 0;
        }

        public int getRecvTimeoutMilis() {
            return this.recvTimeoutMilis_;
        }

        private void setRecvTimeoutMilis(int value) {
            this.recvTimeoutMilis_ = value;
        }

        private void clearRecvTimeoutMilis() {
            this.recvTimeoutMilis_ = 0;
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (!this.hostName_.isEmpty()) {
                output.writeString(1, this.getHostName());
            }

            if (!this.hostIp_.isEmpty()) {
                output.writeString(2, this.getHostIp());
            }

            if (this.port_ != 0) {
                output.writeInt32(3, this.port_);
            }

            if (this.connTimeoutMilis_ != 0) {
                output.writeInt32(4, this.connTimeoutMilis_);
            }

            if (this.sendTimeoutMilis_ != 0) {
                output.writeInt32(5, this.sendTimeoutMilis_);
            }

            if (this.recvTimeoutMilis_ != 0) {
                output.writeInt32(6, this.recvTimeoutMilis_);
            }

            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            } else {
                size = 0;
                if (!this.hostName_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(1, this.getHostName());
                }

                if (!this.hostIp_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(2, this.getHostIp());
                }

                if (this.port_ != 0) {
                    size += CodedOutputStream.computeInt32Size(3, this.port_);
                }

                if (this.connTimeoutMilis_ != 0) {
                    size += CodedOutputStream.computeInt32Size(4, this.connTimeoutMilis_);
                }

                if (this.sendTimeoutMilis_ != 0) {
                    size += CodedOutputStream.computeInt32Size(5, this.sendTimeoutMilis_);
                }

                if (this.recvTimeoutMilis_ != 0) {
                    size += CodedOutputStream.computeInt32Size(6, this.recvTimeoutMilis_);
                }

                size += this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }
        }

        public static IBusCloudSDKProto.SystemInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.SystemInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.SystemInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.SystemInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.SystemInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.SystemInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.SystemInfo parseFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.SystemInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.SystemInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.SystemInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.SystemInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.SystemInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.SystemInfo parseFrom(CodedInputStream input) throws IOException {
            return (IBusCloudSDKProto.SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.SystemInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.SystemInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.SystemInfo.Builder newBuilder() {
            return (IBusCloudSDKProto.SystemInfo.Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static IBusCloudSDKProto.SystemInfo.Builder newBuilder(IBusCloudSDKProto.SystemInfo prototype) {
            return (IBusCloudSDKProto.SystemInfo.Builder) DEFAULT_INSTANCE.createBuilder(prototype);
        }

        protected final Object dynamicMethod(MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new IBusCloudSDKProto.SystemInfo();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new IBusCloudSDKProto.SystemInfo.Builder();
                case VISIT:
                    Visitor visitor = (Visitor) arg0;
                    IBusCloudSDKProto.SystemInfo other = (IBusCloudSDKProto.SystemInfo) arg1;
                    this.hostName_ = visitor.visitString(!this.hostName_.isEmpty(), this.hostName_, !other.hostName_.isEmpty(), other.hostName_);
                    this.hostIp_ = visitor.visitString(!this.hostIp_.isEmpty(), this.hostIp_, !other.hostIp_.isEmpty(), other.hostIp_);
                    this.port_ = visitor.visitInt(this.port_ != 0, this.port_, other.port_ != 0, other.port_);
                    this.connTimeoutMilis_ = visitor.visitInt(this.connTimeoutMilis_ != 0, this.connTimeoutMilis_, other.connTimeoutMilis_ != 0, other.connTimeoutMilis_);
                    this.sendTimeoutMilis_ = visitor.visitInt(this.sendTimeoutMilis_ != 0, this.sendTimeoutMilis_, other.sendTimeoutMilis_ != 0, other.sendTimeoutMilis_);
                    this.recvTimeoutMilis_ = visitor.visitInt(this.recvTimeoutMilis_ != 0, this.recvTimeoutMilis_, other.recvTimeoutMilis_ != 0, other.recvTimeoutMilis_);
                    if (visitor == MergeFromVisitor.INSTANCE) {
                        ;
                    }

                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream input = (CodedInputStream) arg0;
                    ExtensionRegistryLite extensionRegistry = (ExtensionRegistryLite) arg1;
                    if (extensionRegistry == null) {
                        throw new NullPointerException();
                    } else {
                        try {
                            boolean done = false;

                            while (!done) {
                                int tag = input.readTag();
                                String s;
                                switch (tag) {
                                    case 0:
                                        done = true;
                                        break;
                                    case 10:
                                        s = input.readStringRequireUtf8();
                                        this.hostName_ = s;
                                        break;
                                    case 18:
                                        s = input.readStringRequireUtf8();
                                        this.hostIp_ = s;
                                        break;
                                    case 24:
                                        this.port_ = input.readInt32();
                                        break;
                                    case 32:
                                        this.connTimeoutMilis_ = input.readInt32();
                                        break;
                                    case 40:
                                        this.sendTimeoutMilis_ = input.readInt32();
                                        break;
                                    case 48:
                                        this.recvTimeoutMilis_ = input.readInt32();
                                        break;
                                    default:
                                        if (!this.parseUnknownField(tag, input)) {
                                            done = true;
                                        }
                                }
                            }
                        } catch (InvalidProtocolBufferException var16) {
                            throw new RuntimeException(var16.setUnfinishedMessage(this));
                        } catch (IOException var17) {
                            throw new RuntimeException((new InvalidProtocolBufferException(var17.getMessage())).setUnfinishedMessage(this));
                        } finally {
                            ;
                        }
                    }
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    if (PARSER == null) {
                        Class var4 = IBusCloudSDKProto.SystemInfo.class;
                        synchronized (IBusCloudSDKProto.SystemInfo.class) {
                            if (PARSER == null) {
                                PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }

                    return PARSER;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static IBusCloudSDKProto.SystemInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SystemInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        static {
            DEFAULT_INSTANCE.makeImmutable();
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SystemInfo, Builder> implements IBusCloudSDKProto.SystemInfoOrBuilder {
            private Builder() {
                super(IBusCloudSDKProto.SystemInfo.DEFAULT_INSTANCE);
            }

            public String getHostName() {
                return ((IBusCloudSDKProto.SystemInfo) this.instance).getHostName();
            }

            public ByteString getHostNameBytes() {
                return ((IBusCloudSDKProto.SystemInfo) this.instance).getHostNameBytes();
            }

            public IBusCloudSDKProto.SystemInfo.Builder setHostName(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.SystemInfo) this.instance).setHostName(value);
                return this;
            }

            public IBusCloudSDKProto.SystemInfo.Builder clearHostName() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.SystemInfo) this.instance).clearHostName();
                return this;
            }

            public IBusCloudSDKProto.SystemInfo.Builder setHostNameBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.SystemInfo) this.instance).setHostNameBytes(value);
                return this;
            }

            public String getHostIp() {
                return ((IBusCloudSDKProto.SystemInfo) this.instance).getHostIp();
            }

            public ByteString getHostIpBytes() {
                return ((IBusCloudSDKProto.SystemInfo) this.instance).getHostIpBytes();
            }

            public IBusCloudSDKProto.SystemInfo.Builder setHostIp(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.SystemInfo) this.instance).setHostIp(value);
                return this;
            }

            public IBusCloudSDKProto.SystemInfo.Builder clearHostIp() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.SystemInfo) this.instance).clearHostIp();
                return this;
            }

            public IBusCloudSDKProto.SystemInfo.Builder setHostIpBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.SystemInfo) this.instance).setHostIpBytes(value);
                return this;
            }

            public int getPort() {
                return ((IBusCloudSDKProto.SystemInfo) this.instance).getPort();
            }

            public IBusCloudSDKProto.SystemInfo.Builder setPort(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.SystemInfo) this.instance).setPort(value);
                return this;
            }

            public IBusCloudSDKProto.SystemInfo.Builder clearPort() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.SystemInfo) this.instance).clearPort();
                return this;
            }

            public int getConnTimeoutMilis() {
                return ((IBusCloudSDKProto.SystemInfo) this.instance).getConnTimeoutMilis();
            }

            public IBusCloudSDKProto.SystemInfo.Builder setConnTimeoutMilis(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.SystemInfo) this.instance).setConnTimeoutMilis(value);
                return this;
            }

            public IBusCloudSDKProto.SystemInfo.Builder clearConnTimeoutMilis() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.SystemInfo) this.instance).clearConnTimeoutMilis();
                return this;
            }

            public int getSendTimeoutMilis() {
                return ((IBusCloudSDKProto.SystemInfo) this.instance).getSendTimeoutMilis();
            }

            public IBusCloudSDKProto.SystemInfo.Builder setSendTimeoutMilis(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.SystemInfo) this.instance).setSendTimeoutMilis(value);
                return this;
            }

            public IBusCloudSDKProto.SystemInfo.Builder clearSendTimeoutMilis() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.SystemInfo) this.instance).clearSendTimeoutMilis();
                return this;
            }

            public int getRecvTimeoutMilis() {
                return ((IBusCloudSDKProto.SystemInfo) this.instance).getRecvTimeoutMilis();
            }

            public IBusCloudSDKProto.SystemInfo.Builder setRecvTimeoutMilis(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.SystemInfo) this.instance).setRecvTimeoutMilis(value);
                return this;
            }

            public IBusCloudSDKProto.SystemInfo.Builder clearRecvTimeoutMilis() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.SystemInfo) this.instance).clearRecvTimeoutMilis();
                return this;
            }
        }
    }

    public interface SystemInfoOrBuilder extends MessageLiteOrBuilder {
        String getHostName();

        ByteString getHostNameBytes();

        String getHostIp();

        ByteString getHostIpBytes();

        int getPort();

        int getConnTimeoutMilis();

        int getSendTimeoutMilis();

        int getRecvTimeoutMilis();
    }

    public static final class CardTypeList extends GeneratedMessageLite<CardTypeList, CardTypeList.Builder> implements IBusCloudSDKProto.CardTypeListOrBuilder {
        private int bitField0_;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int CARD_TYPES_FIELD_NUMBER = 2;
        private ProtobufList<String> cardTypes_ = GeneratedMessageLite.emptyProtobufList();
        public static final int CARD_ISSUER_NO_FIELD_NUMBER = 3;
        private String cardIssuerNo_ = "";
        public static final int CARD_ISSUER_NO_LIST_FIELD_NUMBER = 4;
        private ProtobufList<String> cardIssuerNoList_ = GeneratedMessageLite.emptyProtobufList();
        private static final IBusCloudSDKProto.CardTypeList DEFAULT_INSTANCE = new IBusCloudSDKProto.CardTypeList();
        private static volatile Parser<CardTypeList> PARSER;

        private CardTypeList() {
        }

        public int getTypeValue() {
            return this.type_;
        }

        public IBusCloudSDKProto.CardTypeList.ChannelType getType() {
            IBusCloudSDKProto.CardTypeList.ChannelType result = IBusCloudSDKProto.CardTypeList.ChannelType.forNumber(this.type_);
            return result == null ? IBusCloudSDKProto.CardTypeList.ChannelType.UNRECOGNIZED : result;
        }

        private void setTypeValue(int value) {
            this.type_ = value;
        }

        private void setType(IBusCloudSDKProto.CardTypeList.ChannelType value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.type_ = value.getNumber();
            }
        }

        private void clearType() {
            this.type_ = 0;
        }

        public List<String> getCardTypesList() {
            return this.cardTypes_;
        }

        public int getCardTypesCount() {
            return this.cardTypes_.size();
        }

        public String getCardTypes(int index) {
            return (String) this.cardTypes_.get(index);
        }

        public ByteString getCardTypesBytes(int index) {
            return ByteString.copyFromUtf8((String) this.cardTypes_.get(index));
        }

        private void ensureCardTypesIsMutable() {
            if (!this.cardTypes_.isModifiable()) {
                this.cardTypes_ = GeneratedMessageLite.mutableCopy(this.cardTypes_);
            }

        }

        private void setCardTypes(int index, String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureCardTypesIsMutable();
                this.cardTypes_.set(index, value);
            }
        }

        private void addCardTypes(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureCardTypesIsMutable();
                this.cardTypes_.add(value);
            }
        }

        private void addAllCardTypes(Iterable<String> values) {
            this.ensureCardTypesIsMutable();
            AbstractMessageLite.addAll(values, this.cardTypes_);
        }

        private void clearCardTypes() {
            this.cardTypes_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void addCardTypesBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.ensureCardTypesIsMutable();
                this.cardTypes_.add(value.toStringUtf8());
            }
        }

        public String getCardIssuerNo() {
            return this.cardIssuerNo_;
        }

        public ByteString getCardIssuerNoBytes() {
            return ByteString.copyFromUtf8(this.cardIssuerNo_);
        }

        private void setCardIssuerNo(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.cardIssuerNo_ = value;
            }
        }

        private void clearCardIssuerNo() {
            this.cardIssuerNo_ = getDefaultInstance().getCardIssuerNo();
        }

        private void setCardIssuerNoBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.cardIssuerNo_ = value.toStringUtf8();
            }
        }

        public List<String> getCardIssuerNoListList() {
            return this.cardIssuerNoList_;
        }

        public int getCardIssuerNoListCount() {
            return this.cardIssuerNoList_.size();
        }

        public String getCardIssuerNoList(int index) {
            return (String) this.cardIssuerNoList_.get(index);
        }

        public ByteString getCardIssuerNoListBytes(int index) {
            return ByteString.copyFromUtf8((String) this.cardIssuerNoList_.get(index));
        }

        private void ensureCardIssuerNoListIsMutable() {
            if (!this.cardIssuerNoList_.isModifiable()) {
                this.cardIssuerNoList_ = GeneratedMessageLite.mutableCopy(this.cardIssuerNoList_);
            }

        }

        private void setCardIssuerNoList(int index, String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureCardIssuerNoListIsMutable();
                this.cardIssuerNoList_.set(index, value);
            }
        }

        private void addCardIssuerNoList(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureCardIssuerNoListIsMutable();
                this.cardIssuerNoList_.add(value);
            }
        }

        private void addAllCardIssuerNoList(Iterable<String> values) {
            this.ensureCardIssuerNoListIsMutable();
            AbstractMessageLite.addAll(values, this.cardIssuerNoList_);
        }

        private void clearCardIssuerNoList() {
            this.cardIssuerNoList_ = GeneratedMessageLite.emptyProtobufList();
        }

        private void addCardIssuerNoListBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.ensureCardIssuerNoListIsMutable();
                this.cardIssuerNoList_.add(value.toStringUtf8());
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.type_ != IBusCloudSDKProto.CardTypeList.ChannelType.ALIPAY.getNumber()) {
                output.writeEnum(1, this.type_);
            }

            int i;
            for (i = 0; i < this.cardTypes_.size(); ++i) {
                output.writeString(2, (String) this.cardTypes_.get(i));
            }

            if (!this.cardIssuerNo_.isEmpty()) {
                output.writeString(3, this.getCardIssuerNo());
            }

            for (i = 0; i < this.cardIssuerNoList_.size(); ++i) {
                output.writeString(4, (String) this.cardIssuerNoList_.get(i));
            }

            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            } else {
                size = 0;
                if (this.type_ != IBusCloudSDKProto.CardTypeList.ChannelType.ALIPAY.getNumber()) {
                    size += CodedOutputStream.computeEnumSize(1, this.type_);
                }

                int dataSize = 0;

                int i;
                for (i = 0; i < this.cardTypes_.size(); ++i) {
                    dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.cardTypes_.get(i));
                }

                size += dataSize;
                size += 1 * this.getCardTypesList().size();
                if (!this.cardIssuerNo_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(3, this.getCardIssuerNo());
                }

                dataSize = 0;

                for (i = 0; i < this.cardIssuerNoList_.size(); ++i) {
                    dataSize += CodedOutputStream.computeStringSizeNoTag((String) this.cardIssuerNoList_.get(i));
                }

                size += dataSize;
                size += 1 * this.getCardIssuerNoListList().size();
                size += this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }
        }

        public static IBusCloudSDKProto.CardTypeList parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.CardTypeList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.CardTypeList parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.CardTypeList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.CardTypeList parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.CardTypeList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.CardTypeList parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.CardTypeList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.CardTypeList parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.CardTypeList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.CardTypeList parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.CardTypeList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.CardTypeList parseFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.CardTypeList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.CardTypeList parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.CardTypeList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.CardTypeList parseDelimitedFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.CardTypeList) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.CardTypeList parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.CardTypeList) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.CardTypeList parseFrom(CodedInputStream input) throws IOException {
            return (IBusCloudSDKProto.CardTypeList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.CardTypeList parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.CardTypeList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.CardTypeList.Builder newBuilder() {
            return (IBusCloudSDKProto.CardTypeList.Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static IBusCloudSDKProto.CardTypeList.Builder newBuilder(IBusCloudSDKProto.CardTypeList prototype) {
            return (IBusCloudSDKProto.CardTypeList.Builder) DEFAULT_INSTANCE.createBuilder(prototype);
        }

        protected final Object dynamicMethod(MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new IBusCloudSDKProto.CardTypeList();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.cardTypes_.makeImmutable();
                    this.cardIssuerNoList_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new IBusCloudSDKProto.CardTypeList.Builder();
                case VISIT:
                    Visitor visitor = (Visitor) arg0;
                    IBusCloudSDKProto.CardTypeList other = (IBusCloudSDKProto.CardTypeList) arg1;
                    this.type_ = visitor.visitInt(this.type_ != 0, this.type_, other.type_ != 0, other.type_);
                    this.cardTypes_ = visitor.visitList(this.cardTypes_, other.cardTypes_);
                    this.cardIssuerNo_ = visitor.visitString(!this.cardIssuerNo_.isEmpty(), this.cardIssuerNo_, !other.cardIssuerNo_.isEmpty(), other.cardIssuerNo_);
                    this.cardIssuerNoList_ = visitor.visitList(this.cardIssuerNoList_, other.cardIssuerNoList_);
                    if (visitor == MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= other.bitField0_;
                    }

                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream input = (CodedInputStream) arg0;
                    ExtensionRegistryLite extensionRegistry = (ExtensionRegistryLite) arg1;
                    if (extensionRegistry == null) {
                        throw new NullPointerException();
                    } else {
                        try {
                            boolean done = false;

                            while (!done) {
                                int tag = input.readTag();
                                String s;
                                switch (tag) {
                                    case 0:
                                        done = true;
                                        break;
                                    case 8:
                                        int rawValue = input.readEnum();
                                        this.type_ = rawValue;
                                        break;
                                    case 18:
                                        s = input.readStringRequireUtf8();
                                        if (!this.cardTypes_.isModifiable()) {
                                            this.cardTypes_ = GeneratedMessageLite.mutableCopy(this.cardTypes_);
                                        }

                                        this.cardTypes_.add(s);
                                        break;
                                    case 26:
                                        s = input.readStringRequireUtf8();
                                        this.cardIssuerNo_ = s;
                                        break;
                                    case 34:
                                        s = input.readStringRequireUtf8();
                                        if (!this.cardIssuerNoList_.isModifiable()) {
                                            this.cardIssuerNoList_ = GeneratedMessageLite.mutableCopy(this.cardIssuerNoList_);
                                        }

                                        this.cardIssuerNoList_.add(s);
                                        break;
                                    default:
                                        if (!this.parseUnknownField(tag, input)) {
                                            done = true;
                                        }
                                }
                            }
                        } catch (InvalidProtocolBufferException var16) {
                            throw new RuntimeException(var16.setUnfinishedMessage(this));
                        } catch (IOException var17) {
                            throw new RuntimeException((new InvalidProtocolBufferException(var17.getMessage())).setUnfinishedMessage(this));
                        } finally {
                            ;
                        }
                    }
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    if (PARSER == null) {
                        Class var4 = IBusCloudSDKProto.CardTypeList.class;
                        synchronized (IBusCloudSDKProto.CardTypeList.class) {
                            if (PARSER == null) {
                                PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }

                    return PARSER;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static IBusCloudSDKProto.CardTypeList getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CardTypeList> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        static {
            DEFAULT_INSTANCE.makeImmutable();
        }

        public static final class Builder extends GeneratedMessageLite.Builder<CardTypeList, Builder> implements IBusCloudSDKProto.CardTypeListOrBuilder {
            private Builder() {
                super(IBusCloudSDKProto.CardTypeList.DEFAULT_INSTANCE);
            }

            public int getTypeValue() {
                return ((IBusCloudSDKProto.CardTypeList) this.instance).getTypeValue();
            }

            public IBusCloudSDKProto.CardTypeList.Builder setTypeValue(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.CardTypeList) this.instance).setTypeValue(value);
                return this;
            }

            public IBusCloudSDKProto.CardTypeList.ChannelType getType() {
                return ((IBusCloudSDKProto.CardTypeList) this.instance).getType();
            }

            public IBusCloudSDKProto.CardTypeList.Builder setType(IBusCloudSDKProto.CardTypeList.ChannelType value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.CardTypeList) this.instance).setType(value);
                return this;
            }

            public IBusCloudSDKProto.CardTypeList.Builder clearType() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.CardTypeList) this.instance).clearType();
                return this;
            }

            public List<String> getCardTypesList() {
                return Collections.unmodifiableList(((IBusCloudSDKProto.CardTypeList) this.instance).getCardTypesList());
            }

            public int getCardTypesCount() {
                return ((IBusCloudSDKProto.CardTypeList) this.instance).getCardTypesCount();
            }

            public String getCardTypes(int index) {
                return ((IBusCloudSDKProto.CardTypeList) this.instance).getCardTypes(index);
            }

            public ByteString getCardTypesBytes(int index) {
                return ((IBusCloudSDKProto.CardTypeList) this.instance).getCardTypesBytes(index);
            }

            public IBusCloudSDKProto.CardTypeList.Builder setCardTypes(int index, String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.CardTypeList) this.instance).setCardTypes(index, value);
                return this;
            }

            public IBusCloudSDKProto.CardTypeList.Builder addCardTypes(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.CardTypeList) this.instance).addCardTypes(value);
                return this;
            }

            public IBusCloudSDKProto.CardTypeList.Builder addAllCardTypes(Iterable<String> values) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.CardTypeList) this.instance).addAllCardTypes(values);
                return this;
            }

            public IBusCloudSDKProto.CardTypeList.Builder clearCardTypes() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.CardTypeList) this.instance).clearCardTypes();
                return this;
            }

            public IBusCloudSDKProto.CardTypeList.Builder addCardTypesBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.CardTypeList) this.instance).addCardTypesBytes(value);
                return this;
            }

            public String getCardIssuerNo() {
                return ((IBusCloudSDKProto.CardTypeList) this.instance).getCardIssuerNo();
            }

            public ByteString getCardIssuerNoBytes() {
                return ((IBusCloudSDKProto.CardTypeList) this.instance).getCardIssuerNoBytes();
            }

            public IBusCloudSDKProto.CardTypeList.Builder setCardIssuerNo(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.CardTypeList) this.instance).setCardIssuerNo(value);
                return this;
            }

            public IBusCloudSDKProto.CardTypeList.Builder clearCardIssuerNo() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.CardTypeList) this.instance).clearCardIssuerNo();
                return this;
            }

            public IBusCloudSDKProto.CardTypeList.Builder setCardIssuerNoBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.CardTypeList) this.instance).setCardIssuerNoBytes(value);
                return this;
            }

            public List<String> getCardIssuerNoListList() {
                return Collections.unmodifiableList(((IBusCloudSDKProto.CardTypeList) this.instance).getCardIssuerNoListList());
            }

            public int getCardIssuerNoListCount() {
                return ((IBusCloudSDKProto.CardTypeList) this.instance).getCardIssuerNoListCount();
            }

            public String getCardIssuerNoList(int index) {
                return ((IBusCloudSDKProto.CardTypeList) this.instance).getCardIssuerNoList(index);
            }

            public ByteString getCardIssuerNoListBytes(int index) {
                return ((IBusCloudSDKProto.CardTypeList) this.instance).getCardIssuerNoListBytes(index);
            }

            public IBusCloudSDKProto.CardTypeList.Builder setCardIssuerNoList(int index, String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.CardTypeList) this.instance).setCardIssuerNoList(index, value);
                return this;
            }

            public IBusCloudSDKProto.CardTypeList.Builder addCardIssuerNoList(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.CardTypeList) this.instance).addCardIssuerNoList(value);
                return this;
            }

            public IBusCloudSDKProto.CardTypeList.Builder addAllCardIssuerNoList(Iterable<String> values) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.CardTypeList) this.instance).addAllCardIssuerNoList(values);
                return this;
            }

            public IBusCloudSDKProto.CardTypeList.Builder clearCardIssuerNoList() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.CardTypeList) this.instance).clearCardIssuerNoList();
                return this;
            }

            public IBusCloudSDKProto.CardTypeList.Builder addCardIssuerNoListBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.CardTypeList) this.instance).addCardIssuerNoListBytes(value);
                return this;
            }
        }

        public static enum ChannelType implements EnumLite {
            ALIPAY(0),
            ALIPAY_MOT(1),
            UNIONPAY(2),
            TRANSPORTPAY(5),
            UNRECOGNIZED(-1);

            public static final int ALIPAY_VALUE = 0;
            public static final int ALIPAY_MOT_VALUE = 1;
            public static final int UNIONPAY_VALUE = 2;
            public static final int TRANSPORTPAY_VALUE = 5;
            private static final EnumLiteMap<ChannelType> internalValueMap = new EnumLiteMap<ChannelType>() {
                public IBusCloudSDKProto.CardTypeList.ChannelType findValueByNumber(int number) {
                    return IBusCloudSDKProto.CardTypeList.ChannelType.forNumber(number);
                }
            };
            private final int value;

            public final int getNumber() {
                if (this == UNRECOGNIZED) {
                    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                } else {
                    return this.value;
                }
            }

            /**
             * @deprecated
             */
            @Deprecated
            public static IBusCloudSDKProto.CardTypeList.ChannelType valueOf(int value) {
                return forNumber(value);
            }

            public static IBusCloudSDKProto.CardTypeList.ChannelType forNumber(int value) {
                switch (value) {
                    case 0:
                        return ALIPAY;
                    case 1:
                        return ALIPAY_MOT;
                    case 2:
                        return UNIONPAY;
                    case 3:
                    case 4:
                    default:
                        return null;
                    case 5:
                        return TRANSPORTPAY;
                }
            }

            public static EnumLiteMap<ChannelType> internalGetValueMap() {
                return internalValueMap;
            }

            private ChannelType(int value) {
                this.value = value;
            }
        }
    }

    public interface CardTypeListOrBuilder extends MessageLiteOrBuilder {
        int getTypeValue();

        IBusCloudSDKProto.CardTypeList.ChannelType getType();

        List<String> getCardTypesList();

        int getCardTypesCount();

        String getCardTypes(int var1);

        ByteString getCardTypesBytes(int var1);

        String getCardIssuerNo();

        ByteString getCardIssuerNoBytes();

        List<String> getCardIssuerNoListList();

        int getCardIssuerNoListCount();

        String getCardIssuerNoList(int var1);

        ByteString getCardIssuerNoListBytes(int var1);
    }

    public static final class KeyInfo extends GeneratedMessageLite<KeyInfo, KeyInfo.Builder> implements IBusCloudSDKProto.KeyInfoOrBuilder {
        private int bitField0_;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int KEY_INFO_FIELD_NUMBER = 2;
        private MapFieldLite<String, String> keyInfo_ = MapFieldLite.emptyMapField();
        public static final int SM2_UID_FIELD_NUMBER = 3;
        private ByteString sm2Uid_;
        private static final IBusCloudSDKProto.KeyInfo DEFAULT_INSTANCE = new IBusCloudSDKProto.KeyInfo();
        private static volatile Parser<KeyInfo> PARSER;

        private KeyInfo() {
            this.sm2Uid_ = ByteString.EMPTY;
        }

        public int getTypeValue() {
            return this.type_;
        }

        public IBusCloudSDKProto.KeyInfo.KeyType getType() {
            IBusCloudSDKProto.KeyInfo.KeyType result = IBusCloudSDKProto.KeyInfo.KeyType.forNumber(this.type_);
            return result == null ? IBusCloudSDKProto.KeyInfo.KeyType.UNRECOGNIZED : result;
        }

        private void setTypeValue(int value) {
            this.type_ = value;
        }

        private void setType(IBusCloudSDKProto.KeyInfo.KeyType value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.type_ = value.getNumber();
            }
        }

        private void clearType() {
            this.type_ = 0;
        }

        private MapFieldLite<String, String> internalGetKeyInfo() {
            return this.keyInfo_;
        }

        private MapFieldLite<String, String> internalGetMutableKeyInfo() {
            if (!this.keyInfo_.isMutable()) {
                this.keyInfo_ = this.keyInfo_.mutableCopy();
            }

            return this.keyInfo_;
        }

        public int getKeyInfoCount() {
            return this.internalGetKeyInfo().size();
        }

        public boolean containsKeyInfo(String key) {
            if (key == null) {
                throw new NullPointerException();
            } else {
                return this.internalGetKeyInfo().containsKey(key);
            }
        }

        /**
         * @deprecated
         */
        @Deprecated
        public Map<String, String> getKeyInfo() {
            return this.getKeyInfoMap();
        }

        public Map<String, String> getKeyInfoMap() {
            return Collections.unmodifiableMap(this.internalGetKeyInfo());
        }

        public String getKeyInfoOrDefault(String key, String defaultValue) {
            if (key == null) {
                throw new NullPointerException();
            } else {
                Map<String, String> map = this.internalGetKeyInfo();
                return map.containsKey(key) ? (String) map.get(key) : defaultValue;
            }
        }

        public String getKeyInfoOrThrow(String key) {
            if (key == null) {
                throw new NullPointerException();
            } else {
                Map<String, String> map = this.internalGetKeyInfo();
                if (!map.containsKey(key)) {
                    throw new IllegalArgumentException();
                } else {
                    return (String) map.get(key);
                }
            }
        }

        private Map<String, String> getMutableKeyInfoMap() {
            return this.internalGetMutableKeyInfo();
        }

        public ByteString getSm2Uid() {
            return this.sm2Uid_;
        }

        private void setSm2Uid(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.sm2Uid_ = value;
            }
        }

        private void clearSm2Uid() {
            this.sm2Uid_ = getDefaultInstance().getSm2Uid();
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.type_ != IBusCloudSDKProto.KeyInfo.KeyType.SYSTEM.getNumber()) {
                output.writeEnum(1, this.type_);
            }

            Iterator var2 = this.internalGetKeyInfo().entrySet().iterator();

            while (var2.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry) var2.next();
                IBusCloudSDKProto.KeyInfo.KeyInfoDefaultEntryHolder.defaultEntry.serializeTo(output, 2, entry.getKey(), entry.getValue());
            }

            if (!this.sm2Uid_.isEmpty()) {
                output.writeBytes(3, this.sm2Uid_);
            }

            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            } else {
                size = 0;
                if (this.type_ != IBusCloudSDKProto.KeyInfo.KeyType.SYSTEM.getNumber()) {
                    size += CodedOutputStream.computeEnumSize(1, this.type_);
                }

                Map.Entry entry;
                for (Iterator var2 = this.internalGetKeyInfo().entrySet().iterator(); var2.hasNext();
                     size += IBusCloudSDKProto.KeyInfo.KeyInfoDefaultEntryHolder.defaultEntry.computeMessageSize(2, (String) entry.getKey(), (String) entry.getValue())) {
                    entry = (Map.Entry) var2.next();
                }

                if (!this.sm2Uid_.isEmpty()) {
                    size += CodedOutputStream.computeBytesSize(3, this.sm2Uid_);
                }

                size += this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }
        }

        public static IBusCloudSDKProto.KeyInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.KeyInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.KeyInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.KeyInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.KeyInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.KeyInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.KeyInfo parseFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.KeyInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.KeyInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.KeyInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.KeyInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.KeyInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.KeyInfo parseFrom(CodedInputStream input) throws IOException {
            return (IBusCloudSDKProto.KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.KeyInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.KeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.KeyInfo.Builder newBuilder() {
            return (IBusCloudSDKProto.KeyInfo.Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static IBusCloudSDKProto.KeyInfo.Builder newBuilder(IBusCloudSDKProto.KeyInfo prototype) {
            return (IBusCloudSDKProto.KeyInfo.Builder) DEFAULT_INSTANCE.createBuilder(prototype);
        }

        protected final Object dynamicMethod(MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new IBusCloudSDKProto.KeyInfo();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.keyInfo_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new IBusCloudSDKProto.KeyInfo.Builder();
                case VISIT:
                    Visitor visitor = (Visitor) arg0;
                    IBusCloudSDKProto.KeyInfo other = (IBusCloudSDKProto.KeyInfo) arg1;
                    this.type_ = visitor.visitInt(this.type_ != 0, this.type_, other.type_ != 0, other.type_);
                    this.keyInfo_ = visitor.visitMap(this.keyInfo_, other.internalGetKeyInfo());
                    this.sm2Uid_ = visitor.visitByteString(this.sm2Uid_ != ByteString.EMPTY, this.sm2Uid_, other.sm2Uid_ != ByteString.EMPTY, other.sm2Uid_);
                    if (visitor == MergeFromVisitor.INSTANCE) {
                        this.bitField0_ |= other.bitField0_;
                    }

                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream input = (CodedInputStream) arg0;
                    ExtensionRegistryLite extensionRegistry = (ExtensionRegistryLite) arg1;
                    if (extensionRegistry == null) {
                        throw new NullPointerException();
                    } else {
                        try {
                            boolean done = false;

                            while (!done) {
                                int tag = input.readTag();
                                switch (tag) {
                                    case 0:
                                        done = true;
                                        break;
                                    case 8:
                                        int rawValue = input.readEnum();
                                        this.type_ = rawValue;
                                        break;
                                    case 18:
                                        if (!this.keyInfo_.isMutable()) {
                                            this.keyInfo_ = this.keyInfo_.mutableCopy();
                                        }

                                        IBusCloudSDKProto.KeyInfo.KeyInfoDefaultEntryHolder.defaultEntry.parseInto(this.keyInfo_, input, extensionRegistry);
                                        break;
                                    case 26:
                                        this.sm2Uid_ = input.readBytes();
                                        break;
                                    default:
                                        if (!this.parseUnknownField(tag, input)) {
                                            done = true;
                                        }
                                }
                            }
                        } catch (InvalidProtocolBufferException var16) {
                            throw new RuntimeException(var16.setUnfinishedMessage(this));
                        } catch (IOException var17) {
                            throw new RuntimeException((new InvalidProtocolBufferException(var17.getMessage())).setUnfinishedMessage(this));
                        } finally {
                            ;
                        }
                    }
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    if (PARSER == null) {
                        Class var4 = IBusCloudSDKProto.KeyInfo.class;
                        synchronized (IBusCloudSDKProto.KeyInfo.class) {
                            if (PARSER == null) {
                                PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }

                    return PARSER;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static IBusCloudSDKProto.KeyInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<KeyInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        static {
            DEFAULT_INSTANCE.makeImmutable();
        }

        public static final class Builder extends GeneratedMessageLite.Builder<KeyInfo, Builder> implements IBusCloudSDKProto.KeyInfoOrBuilder {
            private Builder() {
                super(IBusCloudSDKProto.KeyInfo.DEFAULT_INSTANCE);
            }

            public int getTypeValue() {
                return ((IBusCloudSDKProto.KeyInfo) this.instance).getTypeValue();
            }

            public IBusCloudSDKProto.KeyInfo.Builder setTypeValue(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.KeyInfo) this.instance).setTypeValue(value);
                return this;
            }

            public IBusCloudSDKProto.KeyInfo.KeyType getType() {
                return ((IBusCloudSDKProto.KeyInfo) this.instance).getType();
            }

            public IBusCloudSDKProto.KeyInfo.Builder setType(IBusCloudSDKProto.KeyInfo.KeyType value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.KeyInfo) this.instance).setType(value);
                return this;
            }

            public IBusCloudSDKProto.KeyInfo.Builder clearType() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.KeyInfo) this.instance).clearType();
                return this;
            }

            public int getKeyInfoCount() {
                return ((IBusCloudSDKProto.KeyInfo) this.instance).getKeyInfoMap().size();
            }

            public boolean containsKeyInfo(String key) {
                if (key == null) {
                    throw new NullPointerException();
                } else {
                    return ((IBusCloudSDKProto.KeyInfo) this.instance).getKeyInfoMap().containsKey(key);
                }
            }

            public IBusCloudSDKProto.KeyInfo.Builder clearKeyInfo() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.KeyInfo) this.instance).getMutableKeyInfoMap().clear();
                return this;
            }

            public IBusCloudSDKProto.KeyInfo.Builder removeKeyInfo(String key) {
                if (key == null) {
                    throw new NullPointerException();
                } else {
                    this.copyOnWrite();
                    ((IBusCloudSDKProto.KeyInfo) this.instance).getMutableKeyInfoMap().remove(key);
                    return this;
                }
            }

            /**
             * @deprecated
             */
            @Deprecated
            public Map<String, String> getKeyInfo() {
                return this.getKeyInfoMap();
            }

            public Map<String, String> getKeyInfoMap() {
                return Collections.unmodifiableMap(((IBusCloudSDKProto.KeyInfo) this.instance).getKeyInfoMap());
            }

            public String getKeyInfoOrDefault(String key, String defaultValue) {
                if (key == null) {
                    throw new NullPointerException();
                } else {
                    Map<String, String> map = ((IBusCloudSDKProto.KeyInfo) this.instance).getKeyInfoMap();
                    return map.containsKey(key) ? (String) map.get(key) : defaultValue;
                }
            }

            public String getKeyInfoOrThrow(String key) {
                if (key == null) {
                    throw new NullPointerException();
                } else {
                    Map<String, String> map = ((IBusCloudSDKProto.KeyInfo) this.instance).getKeyInfoMap();
                    if (!map.containsKey(key)) {
                        throw new IllegalArgumentException();
                    } else {
                        return (String) map.get(key);
                    }
                }
            }

            public IBusCloudSDKProto.KeyInfo.Builder putKeyInfo(String key, String value) {
                if (key == null) {
                    throw new NullPointerException();
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.copyOnWrite();
                    ((IBusCloudSDKProto.KeyInfo) this.instance).getMutableKeyInfoMap().put(key, value);
                    return this;
                }
            }

            public IBusCloudSDKProto.KeyInfo.Builder putAllKeyInfo(Map<String, String> values) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.KeyInfo) this.instance).getMutableKeyInfoMap().putAll(values);
                return this;
            }

            public ByteString getSm2Uid() {
                return ((IBusCloudSDKProto.KeyInfo) this.instance).getSm2Uid();
            }

            public IBusCloudSDKProto.KeyInfo.Builder setSm2Uid(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.KeyInfo) this.instance).setSm2Uid(value);
                return this;
            }

            public IBusCloudSDKProto.KeyInfo.Builder clearSm2Uid() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.KeyInfo) this.instance).clearSm2Uid();
                return this;
            }
        }

        private static final class KeyInfoDefaultEntryHolder {
            static final MapEntryLite<String, String> defaultEntry;

            private KeyInfoDefaultEntryHolder() {
            }

            static {
                defaultEntry = MapEntryLite.newDefaultInstance(FieldType.STRING, "", FieldType.STRING, "");
            }
        }

        public static enum KeyType implements EnumLite {
            SYSTEM(0),
            ALIPAY(1),
            CUSTOMIZED_BUS(2),
            ALIPAY_MOT(3),
            UNIONPAY(4),
            TRANSPORTPAY(5),
            ZJRC_SCPP(6),
            UNRECOGNIZED(-1);

            public static final int SYSTEM_VALUE = 0;
            public static final int ALIPAY_VALUE = 1;
            public static final int CUSTOMIZED_BUS_VALUE = 2;
            public static final int ALIPAY_MOT_VALUE = 3;
            public static final int UNIONPAY_VALUE = 4;
            public static final int TRANSPORTPAY_VALUE = 5;
            public static final int ZJRC_SCPP_VALUE = 6;
            private static final EnumLiteMap<KeyType> internalValueMap = new EnumLiteMap<KeyType>() {
                public IBusCloudSDKProto.KeyInfo.KeyType findValueByNumber(int number) {
                    return IBusCloudSDKProto.KeyInfo.KeyType.forNumber(number);
                }
            };
            private final int value;

            public final int getNumber() {
                if (this == UNRECOGNIZED) {
                    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                } else {
                    return this.value;
                }
            }

            /**
             * @deprecated
             */
            @Deprecated
            public static IBusCloudSDKProto.KeyInfo.KeyType valueOf(int value) {
                return forNumber(value);
            }

            public static IBusCloudSDKProto.KeyInfo.KeyType forNumber(int value) {
                switch (value) {
                    case 0:
                        return SYSTEM;
                    case 1:
                        return ALIPAY;
                    case 2:
                        return CUSTOMIZED_BUS;
                    case 3:
                        return ALIPAY_MOT;
                    case 4:
                        return UNIONPAY;
                    case 5:
                        return TRANSPORTPAY;
                    case 6:
                        return ZJRC_SCPP;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<KeyType> internalGetValueMap() {
                return internalValueMap;
            }

            private KeyType(int value) {
                this.value = value;
            }
        }
    }

    public interface KeyInfoOrBuilder extends MessageLiteOrBuilder {
        int getTypeValue();

        IBusCloudSDKProto.KeyInfo.KeyType getType();

        int getKeyInfoCount();

        boolean containsKeyInfo(String var1);

        /**
         * @deprecated
         */
        @Deprecated
        Map<String, String> getKeyInfo();

        Map<String, String> getKeyInfoMap();

        String getKeyInfoOrDefault(String var1, String var2);

        String getKeyInfoOrThrow(String var1);

        ByteString getSm2Uid();
    }

    public static final class ZjrcScppTradeInfo extends GeneratedMessageLite<ZjrcScppTradeInfo, ZjrcScppTradeInfo.Builder> implements IBusCloudSDKProto.ZjrcScppTradeInfoOrBuilder {
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int USER_ID_FIELD_NUMBER = 2;
        private String userId_ = "";
        public static final int CARD_NO_FIELD_NUMBER = 3;
        private String cardNo_ = "";
        public static final int PRODUCT_ID_FIELD_NUMBER = 4;
        private String productId_ = "";
        public static final int CARD_ACCOUNT_TYPE_FIELD_NUMBER = 5;
        private int cardAccountType_;
        public static final int CODE_ISSUER_NO_FIELD_NUMBER = 6;
        private String codeIssuerNo_ = "";
        public static final int CARD_ISSUER_NO_FIELD_NUMBER = 7;
        private String cardIssuerNo_ = "";
        public static final int QRCODE_FIELD_NUMBER = 8;
        private ByteString qrcode_;
        private static final IBusCloudSDKProto.ZjrcScppTradeInfo DEFAULT_INSTANCE = new IBusCloudSDKProto.ZjrcScppTradeInfo();
        private static volatile Parser<ZjrcScppTradeInfo> PARSER;

        private ZjrcScppTradeInfo() {
            this.qrcode_ = ByteString.EMPTY;
        }

        public int getTypeValue() {
            return this.type_;
        }

        public IBusCloudSDKProto.ZjrcScppTradeInfo.CodeType getType() {
            IBusCloudSDKProto.ZjrcScppTradeInfo.CodeType result = IBusCloudSDKProto.ZjrcScppTradeInfo.CodeType.forNumber(this.type_);
            return result == null ? IBusCloudSDKProto.ZjrcScppTradeInfo.CodeType.UNRECOGNIZED : result;
        }

        private void setTypeValue(int value) {
            this.type_ = value;
        }

        private void setType(IBusCloudSDKProto.ZjrcScppTradeInfo.CodeType value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.type_ = value.getNumber();
            }
        }

        private void clearType() {
            this.type_ = 0;
        }

        public String getUserId() {
            return this.userId_;
        }

        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        private void setUserId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.userId_ = value;
            }
        }

        private void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        private void setUserIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.userId_ = value.toStringUtf8();
            }
        }

        public String getCardNo() {
            return this.cardNo_;
        }

        public ByteString getCardNoBytes() {
            return ByteString.copyFromUtf8(this.cardNo_);
        }

        private void setCardNo(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.cardNo_ = value;
            }
        }

        private void clearCardNo() {
            this.cardNo_ = getDefaultInstance().getCardNo();
        }

        private void setCardNoBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.cardNo_ = value.toStringUtf8();
            }
        }

        public String getProductId() {
            return this.productId_;
        }

        public ByteString getProductIdBytes() {
            return ByteString.copyFromUtf8(this.productId_);
        }

        private void setProductId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.productId_ = value;
            }
        }

        private void clearProductId() {
            this.productId_ = getDefaultInstance().getProductId();
        }

        private void setProductIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.productId_ = value.toStringUtf8();
            }
        }

        public int getCardAccountType() {
            return this.cardAccountType_;
        }

        private void setCardAccountType(int value) {
            this.cardAccountType_ = value;
        }

        private void clearCardAccountType() {
            this.cardAccountType_ = 0;
        }

        public String getCodeIssuerNo() {
            return this.codeIssuerNo_;
        }

        public ByteString getCodeIssuerNoBytes() {
            return ByteString.copyFromUtf8(this.codeIssuerNo_);
        }

        private void setCodeIssuerNo(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.codeIssuerNo_ = value;
            }
        }

        private void clearCodeIssuerNo() {
            this.codeIssuerNo_ = getDefaultInstance().getCodeIssuerNo();
        }

        private void setCodeIssuerNoBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.codeIssuerNo_ = value.toStringUtf8();
            }
        }

        public String getCardIssuerNo() {
            return this.cardIssuerNo_;
        }

        public ByteString getCardIssuerNoBytes() {
            return ByteString.copyFromUtf8(this.cardIssuerNo_);
        }

        private void setCardIssuerNo(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.cardIssuerNo_ = value;
            }
        }

        private void clearCardIssuerNo() {
            this.cardIssuerNo_ = getDefaultInstance().getCardIssuerNo();
        }

        private void setCardIssuerNoBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.cardIssuerNo_ = value.toStringUtf8();
            }
        }

        public ByteString getQrcode() {
            return this.qrcode_;
        }

        private void setQrcode(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.qrcode_ = value;
            }
        }

        private void clearQrcode() {
            this.qrcode_ = getDefaultInstance().getQrcode();
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.type_ != IBusCloudSDKProto.ZjrcScppTradeInfo.CodeType.ZJRC_SCPP.getNumber()) {
                output.writeEnum(1, this.type_);
            }

            if (!this.userId_.isEmpty()) {
                output.writeString(2, this.getUserId());
            }

            if (!this.cardNo_.isEmpty()) {
                output.writeString(3, this.getCardNo());
            }

            if (!this.productId_.isEmpty()) {
                output.writeString(4, this.getProductId());
            }

            if (this.cardAccountType_ != 0) {
                output.writeUInt32(5, this.cardAccountType_);
            }

            if (!this.codeIssuerNo_.isEmpty()) {
                output.writeString(6, this.getCodeIssuerNo());
            }

            if (!this.cardIssuerNo_.isEmpty()) {
                output.writeString(7, this.getCardIssuerNo());
            }

            if (!this.qrcode_.isEmpty()) {
                output.writeBytes(8, this.qrcode_);
            }

            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            } else {
                size = 0;
                if (this.type_ != IBusCloudSDKProto.ZjrcScppTradeInfo.CodeType.ZJRC_SCPP.getNumber()) {
                    size += CodedOutputStream.computeEnumSize(1, this.type_);
                }

                if (!this.userId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(2, this.getUserId());
                }

                if (!this.cardNo_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(3, this.getCardNo());
                }

                if (!this.productId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(4, this.getProductId());
                }

                if (this.cardAccountType_ != 0) {
                    size += CodedOutputStream.computeUInt32Size(5, this.cardAccountType_);
                }

                if (!this.codeIssuerNo_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(6, this.getCodeIssuerNo());
                }

                if (!this.cardIssuerNo_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(7, this.getCardIssuerNo());
                }

                if (!this.qrcode_.isEmpty()) {
                    size += CodedOutputStream.computeBytesSize(8, this.qrcode_);
                }

                size += this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }
        }

        public static IBusCloudSDKProto.ZjrcScppTradeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.ZjrcScppTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.ZjrcScppTradeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.ZjrcScppTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.ZjrcScppTradeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.ZjrcScppTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.ZjrcScppTradeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.ZjrcScppTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.ZjrcScppTradeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.ZjrcScppTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.ZjrcScppTradeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.ZjrcScppTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.ZjrcScppTradeInfo parseFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.ZjrcScppTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.ZjrcScppTradeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.ZjrcScppTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.ZjrcScppTradeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.ZjrcScppTradeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.ZjrcScppTradeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.ZjrcScppTradeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.ZjrcScppTradeInfo parseFrom(CodedInputStream input) throws IOException {
            return (IBusCloudSDKProto.ZjrcScppTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.ZjrcScppTradeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.ZjrcScppTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.ZjrcScppTradeInfo.Builder newBuilder() {
            return (IBusCloudSDKProto.ZjrcScppTradeInfo.Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static IBusCloudSDKProto.ZjrcScppTradeInfo.Builder newBuilder(IBusCloudSDKProto.ZjrcScppTradeInfo prototype) {
            return (IBusCloudSDKProto.ZjrcScppTradeInfo.Builder) DEFAULT_INSTANCE.createBuilder(prototype);
        }

        protected final Object dynamicMethod(MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new IBusCloudSDKProto.ZjrcScppTradeInfo();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new IBusCloudSDKProto.ZjrcScppTradeInfo.Builder();
                case VISIT:
                    Visitor visitor = (Visitor) arg0;
                    IBusCloudSDKProto.ZjrcScppTradeInfo other = (IBusCloudSDKProto.ZjrcScppTradeInfo) arg1;
                    this.type_ = visitor.visitInt(this.type_ != 0, this.type_, other.type_ != 0, other.type_);
                    this.userId_ = visitor.visitString(!this.userId_.isEmpty(), this.userId_, !other.userId_.isEmpty(), other.userId_);
                    this.cardNo_ = visitor.visitString(!this.cardNo_.isEmpty(), this.cardNo_, !other.cardNo_.isEmpty(), other.cardNo_);
                    this.productId_ = visitor.visitString(!this.productId_.isEmpty(), this.productId_, !other.productId_.isEmpty(), other.productId_);
                    this.cardAccountType_ = visitor.visitInt(this.cardAccountType_ != 0, this.cardAccountType_, other.cardAccountType_ != 0, other.cardAccountType_);
                    this.codeIssuerNo_ = visitor.visitString(!this.codeIssuerNo_.isEmpty(), this.codeIssuerNo_, !other.codeIssuerNo_.isEmpty(), other.codeIssuerNo_);
                    this.cardIssuerNo_ = visitor.visitString(!this.cardIssuerNo_.isEmpty(), this.cardIssuerNo_, !other.cardIssuerNo_.isEmpty(), other.cardIssuerNo_);
                    this.qrcode_ = visitor.visitByteString(this.qrcode_ != ByteString.EMPTY, this.qrcode_, other.qrcode_ != ByteString.EMPTY, other.qrcode_);
                    if (visitor == MergeFromVisitor.INSTANCE) {
                        ;
                    }

                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream input = (CodedInputStream) arg0;
                    ExtensionRegistryLite extensionRegistry = (ExtensionRegistryLite) arg1;
                    if (extensionRegistry == null) {
                        throw new NullPointerException();
                    } else {
                        try {
                            boolean done = false;

                            while (!done) {
                                int tag = input.readTag();
                                String s;
                                switch (tag) {
                                    case 0:
                                        done = true;
                                        break;
                                    case 8:
                                        int rawValue = input.readEnum();
                                        this.type_ = rawValue;
                                        break;
                                    case 18:
                                        s = input.readStringRequireUtf8();
                                        this.userId_ = s;
                                        break;
                                    case 26:
                                        s = input.readStringRequireUtf8();
                                        this.cardNo_ = s;
                                        break;
                                    case 34:
                                        s = input.readStringRequireUtf8();
                                        this.productId_ = s;
                                        break;
                                    case 40:
                                        this.cardAccountType_ = input.readUInt32();
                                        break;
                                    case 50:
                                        s = input.readStringRequireUtf8();
                                        this.codeIssuerNo_ = s;
                                        break;
                                    case 58:
                                        s = input.readStringRequireUtf8();
                                        this.cardIssuerNo_ = s;
                                        break;
                                    case 66:
                                        this.qrcode_ = input.readBytes();
                                        break;
                                    default:
                                        if (!this.parseUnknownField(tag, input)) {
                                            done = true;
                                        }
                                }
                            }
                        } catch (InvalidProtocolBufferException var16) {
                            throw new RuntimeException(var16.setUnfinishedMessage(this));
                        } catch (IOException var17) {
                            throw new RuntimeException((new InvalidProtocolBufferException(var17.getMessage())).setUnfinishedMessage(this));
                        } finally {
                            ;
                        }
                    }
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    if (PARSER == null) {
                        Class var4 = IBusCloudSDKProto.ZjrcScppTradeInfo.class;
                        synchronized (IBusCloudSDKProto.ZjrcScppTradeInfo.class) {
                            if (PARSER == null) {
                                PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }

                    return PARSER;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static IBusCloudSDKProto.ZjrcScppTradeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ZjrcScppTradeInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        static {
            DEFAULT_INSTANCE.makeImmutable();
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ZjrcScppTradeInfo, Builder> implements IBusCloudSDKProto.ZjrcScppTradeInfoOrBuilder {
            private Builder() {
                super(IBusCloudSDKProto.ZjrcScppTradeInfo.DEFAULT_INSTANCE);
            }

            public int getTypeValue() {
                return ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).getTypeValue();
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder setTypeValue(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).setTypeValue(value);
                return this;
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.CodeType getType() {
                return ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).getType();
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder setType(IBusCloudSDKProto.ZjrcScppTradeInfo.CodeType value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).setType(value);
                return this;
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder clearType() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).clearType();
                return this;
            }

            public String getUserId() {
                return ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).getUserId();
            }

            public ByteString getUserIdBytes() {
                return ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).getUserIdBytes();
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder setUserId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).setUserId(value);
                return this;
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder clearUserId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).clearUserId();
                return this;
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder setUserIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).setUserIdBytes(value);
                return this;
            }

            public String getCardNo() {
                return ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).getCardNo();
            }

            public ByteString getCardNoBytes() {
                return ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).getCardNoBytes();
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder setCardNo(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).setCardNo(value);
                return this;
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder clearCardNo() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).clearCardNo();
                return this;
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder setCardNoBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).setCardNoBytes(value);
                return this;
            }

            public String getProductId() {
                return ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).getProductId();
            }

            public ByteString getProductIdBytes() {
                return ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).getProductIdBytes();
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder setProductId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).setProductId(value);
                return this;
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder clearProductId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).clearProductId();
                return this;
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder setProductIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).setProductIdBytes(value);
                return this;
            }

            public int getCardAccountType() {
                return ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).getCardAccountType();
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder setCardAccountType(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).setCardAccountType(value);
                return this;
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder clearCardAccountType() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).clearCardAccountType();
                return this;
            }

            public String getCodeIssuerNo() {
                return ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).getCodeIssuerNo();
            }

            public ByteString getCodeIssuerNoBytes() {
                return ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).getCodeIssuerNoBytes();
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder setCodeIssuerNo(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).setCodeIssuerNo(value);
                return this;
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder clearCodeIssuerNo() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).clearCodeIssuerNo();
                return this;
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder setCodeIssuerNoBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).setCodeIssuerNoBytes(value);
                return this;
            }

            public String getCardIssuerNo() {
                return ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).getCardIssuerNo();
            }

            public ByteString getCardIssuerNoBytes() {
                return ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).getCardIssuerNoBytes();
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder setCardIssuerNo(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).setCardIssuerNo(value);
                return this;
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder clearCardIssuerNo() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).clearCardIssuerNo();
                return this;
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder setCardIssuerNoBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).setCardIssuerNoBytes(value);
                return this;
            }

            public ByteString getQrcode() {
                return ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).getQrcode();
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder setQrcode(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).setQrcode(value);
                return this;
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo.Builder clearQrcode() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.ZjrcScppTradeInfo) this.instance).clearQrcode();
                return this;
            }
        }

        public static enum CodeType implements EnumLite {
            ZJRC_SCPP(0),
            UNRECOGNIZED(-1);

            public static final int ZJRC_SCPP_VALUE = 0;
            private static final EnumLiteMap<CodeType> internalValueMap = new EnumLiteMap<CodeType>() {
                public IBusCloudSDKProto.ZjrcScppTradeInfo.CodeType findValueByNumber(int number) {
                    return IBusCloudSDKProto.ZjrcScppTradeInfo.CodeType.forNumber(number);
                }
            };
            private final int value;

            public final int getNumber() {
                if (this == UNRECOGNIZED) {
                    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                } else {
                    return this.value;
                }
            }

            /**
             * @deprecated
             */
            @Deprecated
            public static IBusCloudSDKProto.ZjrcScppTradeInfo.CodeType valueOf(int value) {
                return forNumber(value);
            }

            public static IBusCloudSDKProto.ZjrcScppTradeInfo.CodeType forNumber(int value) {
                switch (value) {
                    case 0:
                        return ZJRC_SCPP;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<CodeType> internalGetValueMap() {
                return internalValueMap;
            }

            private CodeType(int value) {
                this.value = value;
            }
        }
    }

    public interface ZjrcScppTradeInfoOrBuilder extends MessageLiteOrBuilder {
        int getTypeValue();

        IBusCloudSDKProto.ZjrcScppTradeInfo.CodeType getType();

        String getUserId();

        ByteString getUserIdBytes();

        String getCardNo();

        ByteString getCardNoBytes();

        String getProductId();

        ByteString getProductIdBytes();

        int getCardAccountType();

        String getCodeIssuerNo();

        ByteString getCodeIssuerNoBytes();

        String getCardIssuerNo();

        ByteString getCardIssuerNoBytes();

        ByteString getQrcode();
    }

    public static final class TransportPayTradeInfo extends GeneratedMessageLite<TransportPayTradeInfo, TransportPayTradeInfo.Builder> implements IBusCloudSDKProto.TransportPayTradeInfoOrBuilder {
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int USER_ID_FIELD_NUMBER = 2;
        private String userId_ = "";
        public static final int CARD_NO_FIELD_NUMBER = 3;
        private String cardNo_ = "";
        public static final int CARD_TYPE_FIELD_NUMBER = 4;
        private String cardType_ = "";
        public static final int CARD_ACCOUNT_TYPE_FIELD_NUMBER = 5;
        private int cardAccountType_;
        public static final int CARD_DATA_FIELD_NUMBER = 6;
        private ByteString cardData_;
        public static final int CODE_ISSUER_NO_FIELD_NUMBER = 7;
        private String codeIssuerNo_;
        public static final int CARD_ISSUER_NO_FIELD_NUMBER = 8;
        private String cardIssuerNo_;
        public static final int TRADE_RECORD_FIELD_NUMBER = 9;
        private ByteString tradeRecord_;
        private static final IBusCloudSDKProto.TransportPayTradeInfo DEFAULT_INSTANCE = new IBusCloudSDKProto.TransportPayTradeInfo();
        private static volatile Parser<TransportPayTradeInfo> PARSER;

        private TransportPayTradeInfo() {
            this.cardData_ = ByteString.EMPTY;
            this.codeIssuerNo_ = "";
            this.cardIssuerNo_ = "";
            this.tradeRecord_ = ByteString.EMPTY;
        }

        public int getTypeValue() {
            return this.type_;
        }

        public IBusCloudSDKProto.TransportPayTradeInfo.CodeType getType() {
            IBusCloudSDKProto.TransportPayTradeInfo.CodeType result = IBusCloudSDKProto.TransportPayTradeInfo.CodeType.forNumber(this.type_);
            return result == null ? IBusCloudSDKProto.TransportPayTradeInfo.CodeType.UNRECOGNIZED : result;
        }

        private void setTypeValue(int value) {
            this.type_ = value;
        }

        private void setType(IBusCloudSDKProto.TransportPayTradeInfo.CodeType value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.type_ = value.getNumber();
            }
        }

        private void clearType() {
            this.type_ = 0;
        }

        public String getUserId() {
            return this.userId_;
        }

        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        private void setUserId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.userId_ = value;
            }
        }

        private void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        private void setUserIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.userId_ = value.toStringUtf8();
            }
        }

        public String getCardNo() {
            return this.cardNo_;
        }

        public ByteString getCardNoBytes() {
            return ByteString.copyFromUtf8(this.cardNo_);
        }

        private void setCardNo(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.cardNo_ = value;
            }
        }

        private void clearCardNo() {
            this.cardNo_ = getDefaultInstance().getCardNo();
        }

        private void setCardNoBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.cardNo_ = value.toStringUtf8();
            }
        }

        public String getCardType() {
            return this.cardType_;
        }

        public ByteString getCardTypeBytes() {
            return ByteString.copyFromUtf8(this.cardType_);
        }

        private void setCardType(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.cardType_ = value;
            }
        }

        private void clearCardType() {
            this.cardType_ = getDefaultInstance().getCardType();
        }

        private void setCardTypeBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.cardType_ = value.toStringUtf8();
            }
        }

        public int getCardAccountType() {
            return this.cardAccountType_;
        }

        private void setCardAccountType(int value) {
            this.cardAccountType_ = value;
        }

        private void clearCardAccountType() {
            this.cardAccountType_ = 0;
        }

        public ByteString getCardData() {
            return this.cardData_;
        }

        private void setCardData(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.cardData_ = value;
            }
        }

        private void clearCardData() {
            this.cardData_ = getDefaultInstance().getCardData();
        }

        public String getCodeIssuerNo() {
            return this.codeIssuerNo_;
        }

        public ByteString getCodeIssuerNoBytes() {
            return ByteString.copyFromUtf8(this.codeIssuerNo_);
        }

        private void setCodeIssuerNo(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.codeIssuerNo_ = value;
            }
        }

        private void clearCodeIssuerNo() {
            this.codeIssuerNo_ = getDefaultInstance().getCodeIssuerNo();
        }

        private void setCodeIssuerNoBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.codeIssuerNo_ = value.toStringUtf8();
            }
        }

        public String getCardIssuerNo() {
            return this.cardIssuerNo_;
        }

        public ByteString getCardIssuerNoBytes() {
            return ByteString.copyFromUtf8(this.cardIssuerNo_);
        }

        private void setCardIssuerNo(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.cardIssuerNo_ = value;
            }
        }

        private void clearCardIssuerNo() {
            this.cardIssuerNo_ = getDefaultInstance().getCardIssuerNo();
        }

        private void setCardIssuerNoBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.cardIssuerNo_ = value.toStringUtf8();
            }
        }

        public ByteString getTradeRecord() {
            return this.tradeRecord_;
        }

        private void setTradeRecord(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.tradeRecord_ = value;
            }
        }

        private void clearTradeRecord() {
            this.tradeRecord_ = getDefaultInstance().getTradeRecord();
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.type_ != IBusCloudSDKProto.TransportPayTradeInfo.CodeType.TRANSPORTPAY.getNumber()) {
                output.writeEnum(1, this.type_);
            }

            if (!this.userId_.isEmpty()) {
                output.writeString(2, this.getUserId());
            }

            if (!this.cardNo_.isEmpty()) {
                output.writeString(3, this.getCardNo());
            }

            if (!this.cardType_.isEmpty()) {
                output.writeString(4, this.getCardType());
            }

            if (this.cardAccountType_ != 0) {
                output.writeUInt32(5, this.cardAccountType_);
            }

            if (!this.cardData_.isEmpty()) {
                output.writeBytes(6, this.cardData_);
            }

            if (!this.codeIssuerNo_.isEmpty()) {
                output.writeString(7, this.getCodeIssuerNo());
            }

            if (!this.cardIssuerNo_.isEmpty()) {
                output.writeString(8, this.getCardIssuerNo());
            }

            if (!this.tradeRecord_.isEmpty()) {
                output.writeBytes(9, this.tradeRecord_);
            }

            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            } else {
                size = 0;
                if (this.type_ != IBusCloudSDKProto.TransportPayTradeInfo.CodeType.TRANSPORTPAY.getNumber()) {
                    size += CodedOutputStream.computeEnumSize(1, this.type_);
                }

                if (!this.userId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(2, this.getUserId());
                }

                if (!this.cardNo_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(3, this.getCardNo());
                }

                if (!this.cardType_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(4, this.getCardType());
                }

                if (this.cardAccountType_ != 0) {
                    size += CodedOutputStream.computeUInt32Size(5, this.cardAccountType_);
                }

                if (!this.cardData_.isEmpty()) {
                    size += CodedOutputStream.computeBytesSize(6, this.cardData_);
                }

                if (!this.codeIssuerNo_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(7, this.getCodeIssuerNo());
                }

                if (!this.cardIssuerNo_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(8, this.getCardIssuerNo());
                }

                if (!this.tradeRecord_.isEmpty()) {
                    size += CodedOutputStream.computeBytesSize(9, this.tradeRecord_);
                }

                size += this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }
        }

        public static IBusCloudSDKProto.TransportPayTradeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.TransportPayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.TransportPayTradeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.TransportPayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.TransportPayTradeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.TransportPayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.TransportPayTradeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.TransportPayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.TransportPayTradeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.TransportPayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.TransportPayTradeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.TransportPayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.TransportPayTradeInfo parseFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.TransportPayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.TransportPayTradeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.TransportPayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.TransportPayTradeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.TransportPayTradeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.TransportPayTradeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.TransportPayTradeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.TransportPayTradeInfo parseFrom(CodedInputStream input) throws IOException {
            return (IBusCloudSDKProto.TransportPayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.TransportPayTradeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.TransportPayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.TransportPayTradeInfo.Builder newBuilder() {
            return (IBusCloudSDKProto.TransportPayTradeInfo.Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static IBusCloudSDKProto.TransportPayTradeInfo.Builder newBuilder(IBusCloudSDKProto.TransportPayTradeInfo prototype) {
            return (IBusCloudSDKProto.TransportPayTradeInfo.Builder) DEFAULT_INSTANCE.createBuilder(prototype);
        }

        protected final Object dynamicMethod(MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new IBusCloudSDKProto.TransportPayTradeInfo();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new IBusCloudSDKProto.TransportPayTradeInfo.Builder();
                case VISIT:
                    Visitor visitor = (Visitor) arg0;
                    IBusCloudSDKProto.TransportPayTradeInfo other = (IBusCloudSDKProto.TransportPayTradeInfo) arg1;
                    this.type_ = visitor.visitInt(this.type_ != 0, this.type_, other.type_ != 0, other.type_);
                    this.userId_ = visitor.visitString(!this.userId_.isEmpty(), this.userId_, !other.userId_.isEmpty(), other.userId_);
                    this.cardNo_ = visitor.visitString(!this.cardNo_.isEmpty(), this.cardNo_, !other.cardNo_.isEmpty(), other.cardNo_);
                    this.cardType_ = visitor.visitString(!this.cardType_.isEmpty(), this.cardType_, !other.cardType_.isEmpty(), other.cardType_);
                    this.cardAccountType_ = visitor.visitInt(this.cardAccountType_ != 0, this.cardAccountType_, other.cardAccountType_ != 0, other.cardAccountType_);
                    this.cardData_ = visitor.visitByteString(this.cardData_ != ByteString.EMPTY, this.cardData_, other.cardData_ != ByteString.EMPTY, other.cardData_);
                    this.codeIssuerNo_ = visitor.visitString(!this.codeIssuerNo_.isEmpty(), this.codeIssuerNo_, !other.codeIssuerNo_.isEmpty(), other.codeIssuerNo_);
                    this.cardIssuerNo_ = visitor.visitString(!this.cardIssuerNo_.isEmpty(), this.cardIssuerNo_, !other.cardIssuerNo_.isEmpty(), other.cardIssuerNo_);
                    this.tradeRecord_ = visitor.visitByteString(this.tradeRecord_ != ByteString.EMPTY, this.tradeRecord_, other.tradeRecord_ != ByteString.EMPTY, other.tradeRecord_);
                    if (visitor == MergeFromVisitor.INSTANCE) {
                        ;
                    }

                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream input = (CodedInputStream) arg0;
                    ExtensionRegistryLite extensionRegistry = (ExtensionRegistryLite) arg1;
                    if (extensionRegistry == null) {
                        throw new NullPointerException();
                    } else {
                        try {
                            boolean done = false;

                            while (!done) {
                                int tag = input.readTag();
                                String s;
                                switch (tag) {
                                    case 0:
                                        done = true;
                                        break;
                                    case 8:
                                        int rawValue = input.readEnum();
                                        this.type_ = rawValue;
                                        break;
                                    case 18:
                                        s = input.readStringRequireUtf8();
                                        this.userId_ = s;
                                        break;
                                    case 26:
                                        s = input.readStringRequireUtf8();
                                        this.cardNo_ = s;
                                        break;
                                    case 34:
                                        s = input.readStringRequireUtf8();
                                        this.cardType_ = s;
                                        break;
                                    case 40:
                                        this.cardAccountType_ = input.readUInt32();
                                        break;
                                    case 50:
                                        this.cardData_ = input.readBytes();
                                        break;
                                    case 58:
                                        s = input.readStringRequireUtf8();
                                        this.codeIssuerNo_ = s;
                                        break;
                                    case 66:
                                        s = input.readStringRequireUtf8();
                                        this.cardIssuerNo_ = s;
                                        break;
                                    case 74:
                                        this.tradeRecord_ = input.readBytes();
                                        break;
                                    default:
                                        if (!this.parseUnknownField(tag, input)) {
                                            done = true;
                                        }
                                }
                            }
                        } catch (InvalidProtocolBufferException var16) {
                            throw new RuntimeException(var16.setUnfinishedMessage(this));
                        } catch (IOException var17) {
                            throw new RuntimeException((new InvalidProtocolBufferException(var17.getMessage())).setUnfinishedMessage(this));
                        } finally {
                            ;
                        }
                    }
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    if (PARSER == null) {
                        Class var4 = IBusCloudSDKProto.TransportPayTradeInfo.class;
                        synchronized (IBusCloudSDKProto.TransportPayTradeInfo.class) {
                            if (PARSER == null) {
                                PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }

                    return PARSER;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static IBusCloudSDKProto.TransportPayTradeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TransportPayTradeInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        static {
            DEFAULT_INSTANCE.makeImmutable();
        }

        public static final class Builder extends GeneratedMessageLite.Builder<TransportPayTradeInfo, Builder> implements IBusCloudSDKProto.TransportPayTradeInfoOrBuilder {
            private Builder() {
                super(IBusCloudSDKProto.TransportPayTradeInfo.DEFAULT_INSTANCE);
            }

            public int getTypeValue() {
                return ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).getTypeValue();
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder setTypeValue(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).setTypeValue(value);
                return this;
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.CodeType getType() {
                return ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).getType();
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder setType(IBusCloudSDKProto.TransportPayTradeInfo.CodeType value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).setType(value);
                return this;
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder clearType() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).clearType();
                return this;
            }

            public String getUserId() {
                return ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).getUserId();
            }

            public ByteString getUserIdBytes() {
                return ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).getUserIdBytes();
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder setUserId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).setUserId(value);
                return this;
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder clearUserId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).clearUserId();
                return this;
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder setUserIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).setUserIdBytes(value);
                return this;
            }

            public String getCardNo() {
                return ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).getCardNo();
            }

            public ByteString getCardNoBytes() {
                return ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).getCardNoBytes();
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder setCardNo(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).setCardNo(value);
                return this;
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder clearCardNo() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).clearCardNo();
                return this;
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder setCardNoBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).setCardNoBytes(value);
                return this;
            }

            public String getCardType() {
                return ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).getCardType();
            }

            public ByteString getCardTypeBytes() {
                return ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).getCardTypeBytes();
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder setCardType(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).setCardType(value);
                return this;
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder clearCardType() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).clearCardType();
                return this;
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder setCardTypeBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).setCardTypeBytes(value);
                return this;
            }

            public int getCardAccountType() {
                return ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).getCardAccountType();
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder setCardAccountType(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).setCardAccountType(value);
                return this;
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder clearCardAccountType() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).clearCardAccountType();
                return this;
            }

            public ByteString getCardData() {
                return ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).getCardData();
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder setCardData(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).setCardData(value);
                return this;
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder clearCardData() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).clearCardData();
                return this;
            }

            public String getCodeIssuerNo() {
                return ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).getCodeIssuerNo();
            }

            public ByteString getCodeIssuerNoBytes() {
                return ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).getCodeIssuerNoBytes();
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder setCodeIssuerNo(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).setCodeIssuerNo(value);
                return this;
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder clearCodeIssuerNo() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).clearCodeIssuerNo();
                return this;
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder setCodeIssuerNoBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).setCodeIssuerNoBytes(value);
                return this;
            }

            public String getCardIssuerNo() {
                return ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).getCardIssuerNo();
            }

            public ByteString getCardIssuerNoBytes() {
                return ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).getCardIssuerNoBytes();
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder setCardIssuerNo(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).setCardIssuerNo(value);
                return this;
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder clearCardIssuerNo() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).clearCardIssuerNo();
                return this;
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder setCardIssuerNoBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).setCardIssuerNoBytes(value);
                return this;
            }

            public ByteString getTradeRecord() {
                return ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).getTradeRecord();
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder setTradeRecord(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).setTradeRecord(value);
                return this;
            }

            public IBusCloudSDKProto.TransportPayTradeInfo.Builder clearTradeRecord() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.TransportPayTradeInfo) this.instance).clearTradeRecord();
                return this;
            }
        }

        public static enum CodeType implements EnumLite {
            TRANSPORTPAY(0),
            UNRECOGNIZED(-1);

            public static final int TRANSPORTPAY_VALUE = 0;
            private static final EnumLiteMap<CodeType> internalValueMap = new EnumLiteMap<CodeType>() {
                public IBusCloudSDKProto.TransportPayTradeInfo.CodeType findValueByNumber(int number) {
                    return IBusCloudSDKProto.TransportPayTradeInfo.CodeType.forNumber(number);
                }
            };
            private final int value;

            public final int getNumber() {
                if (this == UNRECOGNIZED) {
                    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                } else {
                    return this.value;
                }
            }

            /**
             * @deprecated
             */
            @Deprecated
            public static IBusCloudSDKProto.TransportPayTradeInfo.CodeType valueOf(int value) {
                return forNumber(value);
            }

            public static IBusCloudSDKProto.TransportPayTradeInfo.CodeType forNumber(int value) {
                switch (value) {
                    case 0:
                        return TRANSPORTPAY;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<CodeType> internalGetValueMap() {
                return internalValueMap;
            }

            private CodeType(int value) {
                this.value = value;
            }
        }
    }

    public interface TransportPayTradeInfoOrBuilder extends MessageLiteOrBuilder {
        int getTypeValue();

        IBusCloudSDKProto.TransportPayTradeInfo.CodeType getType();

        String getUserId();

        ByteString getUserIdBytes();

        String getCardNo();

        ByteString getCardNoBytes();

        String getCardType();

        ByteString getCardTypeBytes();

        int getCardAccountType();

        ByteString getCardData();

        String getCodeIssuerNo();

        ByteString getCodeIssuerNoBytes();

        String getCardIssuerNo();

        ByteString getCardIssuerNoBytes();

        ByteString getTradeRecord();
    }

    public static final class UnionpayTradeInfo extends GeneratedMessageLite<UnionpayTradeInfo, UnionpayTradeInfo.Builder> implements IBusCloudSDKProto.UnionpayTradeInfoOrBuilder {
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int USER_ID_FIELD_NUMBER = 2;
        private String userId_ = "";
        public static final int CARD_NO_FIELD_NUMBER = 3;
        private String cardNo_ = "";
        public static final int CARD_TYPE_FIELD_NUMBER = 4;
        private String cardType_ = "";
        public static final int CARD_DATA_FIELD_NUMBER = 5;
        private ByteString cardData_;
        public static final int CODE_ISSUER_NO_FIELD_NUMBER = 6;
        private String codeIssuerNo_;
        public static final int APP_ID_FIELD_NUMBER = 7;
        private String appId_;
        public static final int TRADE_RECORD_FIELD_NUMBER = 8;
        private ByteString tradeRecord_;
        public static final int QRC_CREATE_TIME_FIELD_NUMBER = 9;
        private int qrcCreateTime_;
        public static final int QRC_VOUCHER_NO_FIELD_NUMBER = 10;
        private String qrcVoucherNo_;
        private static final IBusCloudSDKProto.UnionpayTradeInfo DEFAULT_INSTANCE = new IBusCloudSDKProto.UnionpayTradeInfo();
        private static volatile Parser<UnionpayTradeInfo> PARSER;

        private UnionpayTradeInfo() {
            this.cardData_ = ByteString.EMPTY;
            this.codeIssuerNo_ = "";
            this.appId_ = "";
            this.tradeRecord_ = ByteString.EMPTY;
            this.qrcVoucherNo_ = "";
        }

        public int getTypeValue() {
            return this.type_;
        }

        public IBusCloudSDKProto.UnionpayTradeInfo.CodeType getType() {
            IBusCloudSDKProto.UnionpayTradeInfo.CodeType result = IBusCloudSDKProto.UnionpayTradeInfo.CodeType.forNumber(this.type_);
            return result == null ? IBusCloudSDKProto.UnionpayTradeInfo.CodeType.UNRECOGNIZED : result;
        }

        private void setTypeValue(int value) {
            this.type_ = value;
        }

        private void setType(IBusCloudSDKProto.UnionpayTradeInfo.CodeType value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.type_ = value.getNumber();
            }
        }

        private void clearType() {
            this.type_ = 0;
        }

        public String getUserId() {
            return this.userId_;
        }

        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        private void setUserId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.userId_ = value;
            }
        }

        private void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        private void setUserIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.userId_ = value.toStringUtf8();
            }
        }

        public String getCardNo() {
            return this.cardNo_;
        }

        public ByteString getCardNoBytes() {
            return ByteString.copyFromUtf8(this.cardNo_);
        }

        private void setCardNo(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.cardNo_ = value;
            }
        }

        private void clearCardNo() {
            this.cardNo_ = getDefaultInstance().getCardNo();
        }

        private void setCardNoBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.cardNo_ = value.toStringUtf8();
            }
        }

        public String getCardType() {
            return this.cardType_;
        }

        public ByteString getCardTypeBytes() {
            return ByteString.copyFromUtf8(this.cardType_);
        }

        private void setCardType(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.cardType_ = value;
            }
        }

        private void clearCardType() {
            this.cardType_ = getDefaultInstance().getCardType();
        }

        private void setCardTypeBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.cardType_ = value.toStringUtf8();
            }
        }

        public ByteString getCardData() {
            return this.cardData_;
        }

        private void setCardData(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.cardData_ = value;
            }
        }

        private void clearCardData() {
            this.cardData_ = getDefaultInstance().getCardData();
        }

        public String getCodeIssuerNo() {
            return this.codeIssuerNo_;
        }

        public ByteString getCodeIssuerNoBytes() {
            return ByteString.copyFromUtf8(this.codeIssuerNo_);
        }

        private void setCodeIssuerNo(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.codeIssuerNo_ = value;
            }
        }

        private void clearCodeIssuerNo() {
            this.codeIssuerNo_ = getDefaultInstance().getCodeIssuerNo();
        }

        private void setCodeIssuerNoBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.codeIssuerNo_ = value.toStringUtf8();
            }
        }

        public String getAppId() {
            return this.appId_;
        }

        public ByteString getAppIdBytes() {
            return ByteString.copyFromUtf8(this.appId_);
        }

        private void setAppId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.appId_ = value;
            }
        }

        private void clearAppId() {
            this.appId_ = getDefaultInstance().getAppId();
        }

        private void setAppIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.appId_ = value.toStringUtf8();
            }
        }

        public ByteString getTradeRecord() {
            return this.tradeRecord_;
        }

        private void setTradeRecord(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.tradeRecord_ = value;
            }
        }

        private void clearTradeRecord() {
            this.tradeRecord_ = getDefaultInstance().getTradeRecord();
        }

        public int getQrcCreateTime() {
            return this.qrcCreateTime_;
        }

        private void setQrcCreateTime(int value) {
            this.qrcCreateTime_ = value;
        }

        private void clearQrcCreateTime() {
            this.qrcCreateTime_ = 0;
        }

        public String getQrcVoucherNo() {
            return this.qrcVoucherNo_;
        }

        public ByteString getQrcVoucherNoBytes() {
            return ByteString.copyFromUtf8(this.qrcVoucherNo_);
        }

        private void setQrcVoucherNo(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.qrcVoucherNo_ = value;
            }
        }

        private void clearQrcVoucherNo() {
            this.qrcVoucherNo_ = getDefaultInstance().getQrcVoucherNo();
        }

        private void setQrcVoucherNoBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.qrcVoucherNo_ = value.toStringUtf8();
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.type_ != IBusCloudSDKProto.UnionpayTradeInfo.CodeType.UNIONPAY.getNumber()) {
                output.writeEnum(1, this.type_);
            }

            if (!this.userId_.isEmpty()) {
                output.writeString(2, this.getUserId());
            }

            if (!this.cardNo_.isEmpty()) {
                output.writeString(3, this.getCardNo());
            }

            if (!this.cardType_.isEmpty()) {
                output.writeString(4, this.getCardType());
            }

            if (!this.cardData_.isEmpty()) {
                output.writeBytes(5, this.cardData_);
            }

            if (!this.codeIssuerNo_.isEmpty()) {
                output.writeString(6, this.getCodeIssuerNo());
            }

            if (!this.appId_.isEmpty()) {
                output.writeString(7, this.getAppId());
            }

            if (!this.tradeRecord_.isEmpty()) {
                output.writeBytes(8, this.tradeRecord_);
            }

            if (this.qrcCreateTime_ != 0) {
                output.writeUInt32(9, this.qrcCreateTime_);
            }

            if (!this.qrcVoucherNo_.isEmpty()) {
                output.writeString(10, this.getQrcVoucherNo());
            }

            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            } else {
                size = 0;
                if (this.type_ != IBusCloudSDKProto.UnionpayTradeInfo.CodeType.UNIONPAY.getNumber()) {
                    size += CodedOutputStream.computeEnumSize(1, this.type_);
                }

                if (!this.userId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(2, this.getUserId());
                }

                if (!this.cardNo_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(3, this.getCardNo());
                }

                if (!this.cardType_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(4, this.getCardType());
                }

                if (!this.cardData_.isEmpty()) {
                    size += CodedOutputStream.computeBytesSize(5, this.cardData_);
                }

                if (!this.codeIssuerNo_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(6, this.getCodeIssuerNo());
                }

                if (!this.appId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(7, this.getAppId());
                }

                if (!this.tradeRecord_.isEmpty()) {
                    size += CodedOutputStream.computeBytesSize(8, this.tradeRecord_);
                }

                if (this.qrcCreateTime_ != 0) {
                    size += CodedOutputStream.computeUInt32Size(9, this.qrcCreateTime_);
                }

                if (!this.qrcVoucherNo_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(10, this.getQrcVoucherNo());
                }

                size += this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }
        }

        public static IBusCloudSDKProto.UnionpayTradeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.UnionpayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.UnionpayTradeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.UnionpayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.UnionpayTradeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.UnionpayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.UnionpayTradeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.UnionpayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.UnionpayTradeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.UnionpayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.UnionpayTradeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.UnionpayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.UnionpayTradeInfo parseFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.UnionpayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.UnionpayTradeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.UnionpayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.UnionpayTradeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.UnionpayTradeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.UnionpayTradeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.UnionpayTradeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.UnionpayTradeInfo parseFrom(CodedInputStream input) throws IOException {
            return (IBusCloudSDKProto.UnionpayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.UnionpayTradeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.UnionpayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.UnionpayTradeInfo.Builder newBuilder() {
            return (IBusCloudSDKProto.UnionpayTradeInfo.Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static IBusCloudSDKProto.UnionpayTradeInfo.Builder newBuilder(IBusCloudSDKProto.UnionpayTradeInfo prototype) {
            return (IBusCloudSDKProto.UnionpayTradeInfo.Builder) DEFAULT_INSTANCE.createBuilder(prototype);
        }

        protected final Object dynamicMethod(MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new IBusCloudSDKProto.UnionpayTradeInfo();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new IBusCloudSDKProto.UnionpayTradeInfo.Builder();
                case VISIT:
                    Visitor visitor = (Visitor) arg0;
                    IBusCloudSDKProto.UnionpayTradeInfo other = (IBusCloudSDKProto.UnionpayTradeInfo) arg1;
                    this.type_ = visitor.visitInt(this.type_ != 0, this.type_, other.type_ != 0, other.type_);
                    this.userId_ = visitor.visitString(!this.userId_.isEmpty(), this.userId_, !other.userId_.isEmpty(), other.userId_);
                    this.cardNo_ = visitor.visitString(!this.cardNo_.isEmpty(), this.cardNo_, !other.cardNo_.isEmpty(), other.cardNo_);
                    this.cardType_ = visitor.visitString(!this.cardType_.isEmpty(), this.cardType_, !other.cardType_.isEmpty(), other.cardType_);
                    this.cardData_ = visitor.visitByteString(this.cardData_ != ByteString.EMPTY, this.cardData_, other.cardData_ != ByteString.EMPTY, other.cardData_);
                    this.codeIssuerNo_ = visitor.visitString(!this.codeIssuerNo_.isEmpty(), this.codeIssuerNo_, !other.codeIssuerNo_.isEmpty(), other.codeIssuerNo_);
                    this.appId_ = visitor.visitString(!this.appId_.isEmpty(), this.appId_, !other.appId_.isEmpty(), other.appId_);
                    this.tradeRecord_ = visitor.visitByteString(this.tradeRecord_ != ByteString.EMPTY, this.tradeRecord_, other.tradeRecord_ != ByteString.EMPTY, other.tradeRecord_);
                    this.qrcCreateTime_ = visitor.visitInt(this.qrcCreateTime_ != 0, this.qrcCreateTime_, other.qrcCreateTime_ != 0, other.qrcCreateTime_);
                    this.qrcVoucherNo_ = visitor.visitString(!this.qrcVoucherNo_.isEmpty(), this.qrcVoucherNo_, !other.qrcVoucherNo_.isEmpty(), other.qrcVoucherNo_);
                    if (visitor == MergeFromVisitor.INSTANCE) {
                        ;
                    }

                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream input = (CodedInputStream) arg0;
                    ExtensionRegistryLite extensionRegistry = (ExtensionRegistryLite) arg1;
                    if (extensionRegistry == null) {
                        throw new NullPointerException();
                    } else {
                        try {
                            boolean done = false;

                            while (!done) {
                                int tag = input.readTag();
                                String s;
                                switch (tag) {
                                    case 0:
                                        done = true;
                                        break;
                                    case 8:
                                        int rawValue = input.readEnum();
                                        this.type_ = rawValue;
                                        break;
                                    case 18:
                                        s = input.readStringRequireUtf8();
                                        this.userId_ = s;
                                        break;
                                    case 26:
                                        s = input.readStringRequireUtf8();
                                        this.cardNo_ = s;
                                        break;
                                    case 34:
                                        s = input.readStringRequireUtf8();
                                        this.cardType_ = s;
                                        break;
                                    case 42:
                                        this.cardData_ = input.readBytes();
                                        break;
                                    case 50:
                                        s = input.readStringRequireUtf8();
                                        this.codeIssuerNo_ = s;
                                        break;
                                    case 58:
                                        s = input.readStringRequireUtf8();
                                        this.appId_ = s;
                                        break;
                                    case 66:
                                        this.tradeRecord_ = input.readBytes();
                                        break;
                                    case 72:
                                        this.qrcCreateTime_ = input.readUInt32();
                                        break;
                                    case 82:
                                        s = input.readStringRequireUtf8();
                                        this.qrcVoucherNo_ = s;
                                        break;
                                    default:
                                        if (!this.parseUnknownField(tag, input)) {
                                            done = true;
                                        }
                                }
                            }
                        } catch (InvalidProtocolBufferException var16) {
                            throw new RuntimeException(var16.setUnfinishedMessage(this));
                        } catch (IOException var17) {
                            throw new RuntimeException((new InvalidProtocolBufferException(var17.getMessage())).setUnfinishedMessage(this));
                        } finally {
                            ;
                        }
                    }
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    if (PARSER == null) {
                        Class var4 = IBusCloudSDKProto.UnionpayTradeInfo.class;
                        synchronized (IBusCloudSDKProto.UnionpayTradeInfo.class) {
                            if (PARSER == null) {
                                PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }

                    return PARSER;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static IBusCloudSDKProto.UnionpayTradeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UnionpayTradeInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        static {
            DEFAULT_INSTANCE.makeImmutable();
        }

        public static final class Builder extends GeneratedMessageLite.Builder<UnionpayTradeInfo, Builder> implements IBusCloudSDKProto.UnionpayTradeInfoOrBuilder {
            private Builder() {
                super(IBusCloudSDKProto.UnionpayTradeInfo.DEFAULT_INSTANCE);
            }

            public int getTypeValue() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getTypeValue();
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setTypeValue(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setTypeValue(value);
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.CodeType getType() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getType();
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setType(IBusCloudSDKProto.UnionpayTradeInfo.CodeType value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setType(value);
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder clearType() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).clearType();
                return this;
            }

            public String getUserId() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getUserId();
            }

            public ByteString getUserIdBytes() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getUserIdBytes();
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setUserId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setUserId(value);
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder clearUserId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).clearUserId();
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setUserIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setUserIdBytes(value);
                return this;
            }

            public String getCardNo() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getCardNo();
            }

            public ByteString getCardNoBytes() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getCardNoBytes();
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setCardNo(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setCardNo(value);
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder clearCardNo() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).clearCardNo();
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setCardNoBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setCardNoBytes(value);
                return this;
            }

            public String getCardType() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getCardType();
            }

            public ByteString getCardTypeBytes() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getCardTypeBytes();
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setCardType(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setCardType(value);
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder clearCardType() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).clearCardType();
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setCardTypeBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setCardTypeBytes(value);
                return this;
            }

            public ByteString getCardData() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getCardData();
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setCardData(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setCardData(value);
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder clearCardData() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).clearCardData();
                return this;
            }

            public String getCodeIssuerNo() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getCodeIssuerNo();
            }

            public ByteString getCodeIssuerNoBytes() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getCodeIssuerNoBytes();
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setCodeIssuerNo(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setCodeIssuerNo(value);
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder clearCodeIssuerNo() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).clearCodeIssuerNo();
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setCodeIssuerNoBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setCodeIssuerNoBytes(value);
                return this;
            }

            public String getAppId() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getAppId();
            }

            public ByteString getAppIdBytes() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getAppIdBytes();
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setAppId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setAppId(value);
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder clearAppId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).clearAppId();
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setAppIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setAppIdBytes(value);
                return this;
            }

            public ByteString getTradeRecord() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getTradeRecord();
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setTradeRecord(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setTradeRecord(value);
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder clearTradeRecord() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).clearTradeRecord();
                return this;
            }

            public int getQrcCreateTime() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getQrcCreateTime();
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setQrcCreateTime(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setQrcCreateTime(value);
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder clearQrcCreateTime() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).clearQrcCreateTime();
                return this;
            }

            public String getQrcVoucherNo() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getQrcVoucherNo();
            }

            public ByteString getQrcVoucherNoBytes() {
                return ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).getQrcVoucherNoBytes();
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setQrcVoucherNo(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setQrcVoucherNo(value);
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder clearQrcVoucherNo() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).clearQrcVoucherNo();
                return this;
            }

            public IBusCloudSDKProto.UnionpayTradeInfo.Builder setQrcVoucherNoBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UnionpayTradeInfo) this.instance).setQrcVoucherNoBytes(value);
                return this;
            }
        }

        public static enum CodeType implements EnumLite {
            UNIONPAY(0),
            UNRECOGNIZED(-1);

            public static final int UNIONPAY_VALUE = 0;
            private static final EnumLiteMap<CodeType> internalValueMap = new EnumLiteMap<CodeType>() {
                public IBusCloudSDKProto.UnionpayTradeInfo.CodeType findValueByNumber(int number) {
                    return IBusCloudSDKProto.UnionpayTradeInfo.CodeType.forNumber(number);
                }
            };
            private final int value;

            public final int getNumber() {
                if (this == UNRECOGNIZED) {
                    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                } else {
                    return this.value;
                }
            }

            /**
             * @deprecated
             */
            @Deprecated
            public static IBusCloudSDKProto.UnionpayTradeInfo.CodeType valueOf(int value) {
                return forNumber(value);
            }

            public static IBusCloudSDKProto.UnionpayTradeInfo.CodeType forNumber(int value) {
                switch (value) {
                    case 0:
                        return UNIONPAY;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<CodeType> internalGetValueMap() {
                return internalValueMap;
            }

            private CodeType(int value) {
                this.value = value;
            }
        }
    }

    public interface UnionpayTradeInfoOrBuilder extends MessageLiteOrBuilder {
        int getTypeValue();

        IBusCloudSDKProto.UnionpayTradeInfo.CodeType getType();

        String getUserId();

        ByteString getUserIdBytes();

        String getCardNo();

        ByteString getCardNoBytes();

        String getCardType();

        ByteString getCardTypeBytes();

        ByteString getCardData();

        String getCodeIssuerNo();

        ByteString getCodeIssuerNoBytes();

        String getAppId();

        ByteString getAppIdBytes();

        ByteString getTradeRecord();

        int getQrcCreateTime();

        String getQrcVoucherNo();

        ByteString getQrcVoucherNoBytes();
    }

    public static final class AlipayTradeInfo extends GeneratedMessageLite<AlipayTradeInfo, AlipayTradeInfo.Builder> implements IBusCloudSDKProto.AlipayTradeInfoOrBuilder {
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int USER_ID_FIELD_NUMBER = 2;
        private String userId_ = "";
        public static final int CARD_NO_FIELD_NUMBER = 3;
        private String cardNo_ = "";
        public static final int CARD_TYPE_FIELD_NUMBER = 4;
        private String cardType_ = "";
        public static final int CARD_DATA_FIELD_NUMBER = 5;
        private ByteString cardData_;
        public static final int CODE_ISSUER_NO_FIELD_NUMBER = 6;
        private String codeIssuerNo_;
        public static final int TRADE_RECORD_FIELD_NUMBER = 7;
        private ByteString tradeRecord_;
        public static final int SIGN_MODE_FIELD_NUMBER = 16;
        private int signMode_;
        public static final int CERT_SN_FIELD_NUMBER = 17;
        private String certSn_;
        public static final int CARD_ISSUER_NO_FIELD_NUMBER = 18;
        private String cardIssuerNo_;
        public static final int CARD_BIZ_TYPE_FIELD_NUMBER = 19;
        private int cardBizType_;
        public static final int CA_KEY_IDX_FIELD_NUMBER = 20;
        private int caKeyIdx_;
        public static final int USER_ACCOUNT_TYPE_FIELD_NUMBER = 21;
        private String userAccountType_;
        private static final IBusCloudSDKProto.AlipayTradeInfo DEFAULT_INSTANCE = new IBusCloudSDKProto.AlipayTradeInfo();
        private static volatile Parser<AlipayTradeInfo> PARSER;

        private AlipayTradeInfo() {
            this.cardData_ = ByteString.EMPTY;
            this.codeIssuerNo_ = "";
            this.tradeRecord_ = ByteString.EMPTY;
            this.certSn_ = "";
            this.cardIssuerNo_ = "";
            this.userAccountType_ = "";
        }

        public int getTypeValue() {
            return this.type_;
        }

        public IBusCloudSDKProto.AlipayTradeInfo.CodeType getType() {
            IBusCloudSDKProto.AlipayTradeInfo.CodeType result = IBusCloudSDKProto.AlipayTradeInfo.CodeType.forNumber(this.type_);
            return result == null ? IBusCloudSDKProto.AlipayTradeInfo.CodeType.UNRECOGNIZED : result;
        }

        private void setTypeValue(int value) {
            this.type_ = value;
        }

        private void setType(IBusCloudSDKProto.AlipayTradeInfo.CodeType value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.type_ = value.getNumber();
            }
        }

        private void clearType() {
            this.type_ = 0;
        }

        public String getUserId() {
            return this.userId_;
        }

        public ByteString getUserIdBytes() {
            return ByteString.copyFromUtf8(this.userId_);
        }

        private void setUserId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.userId_ = value;
            }
        }

        private void clearUserId() {
            this.userId_ = getDefaultInstance().getUserId();
        }

        private void setUserIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.userId_ = value.toStringUtf8();
            }
        }

        public String getCardNo() {
            return this.cardNo_;
        }

        public ByteString getCardNoBytes() {
            return ByteString.copyFromUtf8(this.cardNo_);
        }

        private void setCardNo(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.cardNo_ = value;
            }
        }

        private void clearCardNo() {
            this.cardNo_ = getDefaultInstance().getCardNo();
        }

        private void setCardNoBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.cardNo_ = value.toStringUtf8();
            }
        }

        public String getCardType() {
            return this.cardType_;
        }

        public ByteString getCardTypeBytes() {
            return ByteString.copyFromUtf8(this.cardType_);
        }

        private void setCardType(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.cardType_ = value;
            }
        }

        private void clearCardType() {
            this.cardType_ = getDefaultInstance().getCardType();
        }

        private void setCardTypeBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.cardType_ = value.toStringUtf8();
            }
        }

        public ByteString getCardData() {
            return this.cardData_;
        }

        private void setCardData(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.cardData_ = value;
            }
        }

        private void clearCardData() {
            this.cardData_ = getDefaultInstance().getCardData();
        }

        public String getCodeIssuerNo() {
            return this.codeIssuerNo_;
        }

        public ByteString getCodeIssuerNoBytes() {
            return ByteString.copyFromUtf8(this.codeIssuerNo_);
        }

        private void setCodeIssuerNo(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.codeIssuerNo_ = value;
            }
        }

        private void clearCodeIssuerNo() {
            this.codeIssuerNo_ = getDefaultInstance().getCodeIssuerNo();
        }

        private void setCodeIssuerNoBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.codeIssuerNo_ = value.toStringUtf8();
            }
        }

        public ByteString getTradeRecord() {
            return this.tradeRecord_;
        }

        private void setTradeRecord(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.tradeRecord_ = value;
            }
        }

        private void clearTradeRecord() {
            this.tradeRecord_ = getDefaultInstance().getTradeRecord();
        }

        public int getSignMode() {
            return this.signMode_;
        }

        private void setSignMode(int value) {
            this.signMode_ = value;
        }

        private void clearSignMode() {
            this.signMode_ = 0;
        }

        public String getCertSn() {
            return this.certSn_;
        }

        public ByteString getCertSnBytes() {
            return ByteString.copyFromUtf8(this.certSn_);
        }

        private void setCertSn(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.certSn_ = value;
            }
        }

        private void clearCertSn() {
            this.certSn_ = getDefaultInstance().getCertSn();
        }

        private void setCertSnBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.certSn_ = value.toStringUtf8();
            }
        }

        public String getCardIssuerNo() {
            return this.cardIssuerNo_;
        }

        public ByteString getCardIssuerNoBytes() {
            return ByteString.copyFromUtf8(this.cardIssuerNo_);
        }

        private void setCardIssuerNo(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.cardIssuerNo_ = value;
            }
        }

        private void clearCardIssuerNo() {
            this.cardIssuerNo_ = getDefaultInstance().getCardIssuerNo();
        }

        private void setCardIssuerNoBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.cardIssuerNo_ = value.toStringUtf8();
            }
        }

        public int getCardBizType() {
            return this.cardBizType_;
        }

        private void setCardBizType(int value) {
            this.cardBizType_ = value;
        }

        private void clearCardBizType() {
            this.cardBizType_ = 0;
        }

        public int getCaKeyIdx() {
            return this.caKeyIdx_;
        }

        private void setCaKeyIdx(int value) {
            this.caKeyIdx_ = value;
        }

        private void clearCaKeyIdx() {
            this.caKeyIdx_ = 0;
        }

        public String getUserAccountType() {
            return this.userAccountType_;
        }

        public ByteString getUserAccountTypeBytes() {
            return ByteString.copyFromUtf8(this.userAccountType_);
        }

        private void setUserAccountType(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.userAccountType_ = value;
            }
        }

        private void clearUserAccountType() {
            this.userAccountType_ = getDefaultInstance().getUserAccountType();
        }

        private void setUserAccountTypeBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.userAccountType_ = value.toStringUtf8();
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.type_ != IBusCloudSDKProto.AlipayTradeInfo.CodeType.ALIPAY_RAW.getNumber()) {
                output.writeEnum(1, this.type_);
            }

            if (!this.userId_.isEmpty()) {
                output.writeString(2, this.getUserId());
            }

            if (!this.cardNo_.isEmpty()) {
                output.writeString(3, this.getCardNo());
            }

            if (!this.cardType_.isEmpty()) {
                output.writeString(4, this.getCardType());
            }

            if (!this.cardData_.isEmpty()) {
                output.writeBytes(5, this.cardData_);
            }

            if (!this.codeIssuerNo_.isEmpty()) {
                output.writeString(6, this.getCodeIssuerNo());
            }

            if (!this.tradeRecord_.isEmpty()) {
                output.writeBytes(7, this.tradeRecord_);
            }

            if (this.signMode_ != 0) {
                output.writeInt32(16, this.signMode_);
            }

            if (!this.certSn_.isEmpty()) {
                output.writeString(17, this.getCertSn());
            }

            if (!this.cardIssuerNo_.isEmpty()) {
                output.writeString(18, this.getCardIssuerNo());
            }

            if (this.cardBizType_ != 0) {
                output.writeInt32(19, this.cardBizType_);
            }

            if (this.caKeyIdx_ != 0) {
                output.writeInt32(20, this.caKeyIdx_);
            }

            if (!this.userAccountType_.isEmpty()) {
                output.writeString(21, this.getUserAccountType());
            }

            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            } else {
                size = 0;
                if (this.type_ != IBusCloudSDKProto.AlipayTradeInfo.CodeType.ALIPAY_RAW.getNumber()) {
                    size += CodedOutputStream.computeEnumSize(1, this.type_);
                }

                if (!this.userId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(2, this.getUserId());
                }

                if (!this.cardNo_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(3, this.getCardNo());
                }

                if (!this.cardType_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(4, this.getCardType());
                }

                if (!this.cardData_.isEmpty()) {
                    size += CodedOutputStream.computeBytesSize(5, this.cardData_);
                }

                if (!this.codeIssuerNo_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(6, this.getCodeIssuerNo());
                }

                if (!this.tradeRecord_.isEmpty()) {
                    size += CodedOutputStream.computeBytesSize(7, this.tradeRecord_);
                }

                if (this.signMode_ != 0) {
                    size += CodedOutputStream.computeInt32Size(16, this.signMode_);
                }

                if (!this.certSn_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(17, this.getCertSn());
                }

                if (!this.cardIssuerNo_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(18, this.getCardIssuerNo());
                }

                if (this.cardBizType_ != 0) {
                    size += CodedOutputStream.computeInt32Size(19, this.cardBizType_);
                }

                if (this.caKeyIdx_ != 0) {
                    size += CodedOutputStream.computeInt32Size(20, this.caKeyIdx_);
                }

                if (!this.userAccountType_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(21, this.getUserAccountType());
                }

                size += this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }
        }

        public static IBusCloudSDKProto.AlipayTradeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.AlipayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.AlipayTradeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.AlipayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.AlipayTradeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.AlipayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.AlipayTradeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.AlipayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.AlipayTradeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.AlipayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.AlipayTradeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.AlipayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.AlipayTradeInfo parseFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.AlipayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.AlipayTradeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.AlipayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.AlipayTradeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.AlipayTradeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.AlipayTradeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.AlipayTradeInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.AlipayTradeInfo parseFrom(CodedInputStream input) throws IOException {
            return (IBusCloudSDKProto.AlipayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.AlipayTradeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.AlipayTradeInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.AlipayTradeInfo.Builder newBuilder() {
            return (IBusCloudSDKProto.AlipayTradeInfo.Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static IBusCloudSDKProto.AlipayTradeInfo.Builder newBuilder(IBusCloudSDKProto.AlipayTradeInfo prototype) {
            return (IBusCloudSDKProto.AlipayTradeInfo.Builder) DEFAULT_INSTANCE.createBuilder(prototype);
        }

        protected final Object dynamicMethod(MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new IBusCloudSDKProto.AlipayTradeInfo();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new IBusCloudSDKProto.AlipayTradeInfo.Builder();
                case VISIT:
                    Visitor visitor = (Visitor) arg0;
                    IBusCloudSDKProto.AlipayTradeInfo other = (IBusCloudSDKProto.AlipayTradeInfo) arg1;
                    this.type_ = visitor.visitInt(this.type_ != 0, this.type_, other.type_ != 0, other.type_);
                    this.userId_ = visitor.visitString(!this.userId_.isEmpty(), this.userId_, !other.userId_.isEmpty(), other.userId_);
                    this.cardNo_ = visitor.visitString(!this.cardNo_.isEmpty(), this.cardNo_, !other.cardNo_.isEmpty(), other.cardNo_);
                    this.cardType_ = visitor.visitString(!this.cardType_.isEmpty(), this.cardType_, !other.cardType_.isEmpty(), other.cardType_);
                    this.cardData_ = visitor.visitByteString(this.cardData_ != ByteString.EMPTY, this.cardData_, other.cardData_ != ByteString.EMPTY, other.cardData_);
                    this.codeIssuerNo_ = visitor.visitString(!this.codeIssuerNo_.isEmpty(), this.codeIssuerNo_, !other.codeIssuerNo_.isEmpty(), other.codeIssuerNo_);
                    this.tradeRecord_ = visitor.visitByteString(this.tradeRecord_ != ByteString.EMPTY, this.tradeRecord_, other.tradeRecord_ != ByteString.EMPTY, other.tradeRecord_);
                    this.signMode_ = visitor.visitInt(this.signMode_ != 0, this.signMode_, other.signMode_ != 0, other.signMode_);
                    this.certSn_ = visitor.visitString(!this.certSn_.isEmpty(), this.certSn_, !other.certSn_.isEmpty(), other.certSn_);
                    this.cardIssuerNo_ = visitor.visitString(!this.cardIssuerNo_.isEmpty(), this.cardIssuerNo_, !other.cardIssuerNo_.isEmpty(), other.cardIssuerNo_);
                    this.cardBizType_ = visitor.visitInt(this.cardBizType_ != 0, this.cardBizType_, other.cardBizType_ != 0, other.cardBizType_);
                    this.caKeyIdx_ = visitor.visitInt(this.caKeyIdx_ != 0, this.caKeyIdx_, other.caKeyIdx_ != 0, other.caKeyIdx_);
                    this.userAccountType_ = visitor.visitString(!this.userAccountType_.isEmpty(), this.userAccountType_, !other.userAccountType_.isEmpty(), other.userAccountType_);
                    if (visitor == MergeFromVisitor.INSTANCE) {
                        ;
                    }

                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream input = (CodedInputStream) arg0;
                    ExtensionRegistryLite extensionRegistry = (ExtensionRegistryLite) arg1;
                    if (extensionRegistry == null) {
                        throw new NullPointerException();
                    } else {
                        try {
                            boolean done = false;

                            while (!done) {
                                int tag = input.readTag();
                                String s;
                                switch (tag) {
                                    case 0:
                                        done = true;
                                        break;
                                    case 8:
                                        int rawValue = input.readEnum();
                                        this.type_ = rawValue;
                                        break;
                                    case 18:
                                        s = input.readStringRequireUtf8();
                                        this.userId_ = s;
                                        break;
                                    case 26:
                                        s = input.readStringRequireUtf8();
                                        this.cardNo_ = s;
                                        break;
                                    case 34:
                                        s = input.readStringRequireUtf8();
                                        this.cardType_ = s;
                                        break;
                                    case 42:
                                        this.cardData_ = input.readBytes();
                                        break;
                                    case 50:
                                        s = input.readStringRequireUtf8();
                                        this.codeIssuerNo_ = s;
                                        break;
                                    case 58:
                                        this.tradeRecord_ = input.readBytes();
                                        break;
                                    case 128:
                                        this.signMode_ = input.readInt32();
                                        break;
                                    case 138:
                                        s = input.readStringRequireUtf8();
                                        this.certSn_ = s;
                                        break;
                                    case 146:
                                        s = input.readStringRequireUtf8();
                                        this.cardIssuerNo_ = s;
                                        break;
                                    case 152:
                                        this.cardBizType_ = input.readInt32();
                                        break;
                                    case 160:
                                        this.caKeyIdx_ = input.readInt32();
                                        break;
                                    case 170:
                                        s = input.readStringRequireUtf8();
                                        this.userAccountType_ = s;
                                        break;
                                    default:
                                        if (!this.parseUnknownField(tag, input)) {
                                            done = true;
                                        }
                                }
                            }
                        } catch (InvalidProtocolBufferException var16) {
                            throw new RuntimeException(var16.setUnfinishedMessage(this));
                        } catch (IOException var17) {
                            throw new RuntimeException((new InvalidProtocolBufferException(var17.getMessage())).setUnfinishedMessage(this));
                        } finally {
                            ;
                        }
                    }
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    if (PARSER == null) {
                        Class var4 = IBusCloudSDKProto.AlipayTradeInfo.class;
                        synchronized (IBusCloudSDKProto.AlipayTradeInfo.class) {
                            if (PARSER == null) {
                                PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }

                    return PARSER;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static IBusCloudSDKProto.AlipayTradeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AlipayTradeInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        static {
            DEFAULT_INSTANCE.makeImmutable();
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AlipayTradeInfo, Builder> implements IBusCloudSDKProto.AlipayTradeInfoOrBuilder {
            private Builder() {
                super(IBusCloudSDKProto.AlipayTradeInfo.DEFAULT_INSTANCE);
            }

            public int getTypeValue() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getTypeValue();
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setTypeValue(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setTypeValue(value);
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.CodeType getType() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getType();
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setType(IBusCloudSDKProto.AlipayTradeInfo.CodeType value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setType(value);
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder clearType() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).clearType();
                return this;
            }

            public String getUserId() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getUserId();
            }

            public ByteString getUserIdBytes() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getUserIdBytes();
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setUserId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setUserId(value);
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder clearUserId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).clearUserId();
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setUserIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setUserIdBytes(value);
                return this;
            }

            public String getCardNo() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getCardNo();
            }

            public ByteString getCardNoBytes() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getCardNoBytes();
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setCardNo(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setCardNo(value);
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder clearCardNo() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).clearCardNo();
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setCardNoBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setCardNoBytes(value);
                return this;
            }

            public String getCardType() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getCardType();
            }

            public ByteString getCardTypeBytes() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getCardTypeBytes();
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setCardType(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setCardType(value);
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder clearCardType() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).clearCardType();
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setCardTypeBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setCardTypeBytes(value);
                return this;
            }

            public ByteString getCardData() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getCardData();
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setCardData(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setCardData(value);
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder clearCardData() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).clearCardData();
                return this;
            }

            public String getCodeIssuerNo() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getCodeIssuerNo();
            }

            public ByteString getCodeIssuerNoBytes() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getCodeIssuerNoBytes();
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setCodeIssuerNo(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setCodeIssuerNo(value);
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder clearCodeIssuerNo() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).clearCodeIssuerNo();
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setCodeIssuerNoBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setCodeIssuerNoBytes(value);
                return this;
            }

            public ByteString getTradeRecord() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getTradeRecord();
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setTradeRecord(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setTradeRecord(value);
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder clearTradeRecord() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).clearTradeRecord();
                return this;
            }

            public int getSignMode() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getSignMode();
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setSignMode(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setSignMode(value);
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder clearSignMode() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).clearSignMode();
                return this;
            }

            public String getCertSn() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getCertSn();
            }

            public ByteString getCertSnBytes() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getCertSnBytes();
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setCertSn(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setCertSn(value);
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder clearCertSn() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).clearCertSn();
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setCertSnBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setCertSnBytes(value);
                return this;
            }

            public String getCardIssuerNo() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getCardIssuerNo();
            }

            public ByteString getCardIssuerNoBytes() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getCardIssuerNoBytes();
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setCardIssuerNo(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setCardIssuerNo(value);
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder clearCardIssuerNo() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).clearCardIssuerNo();
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setCardIssuerNoBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setCardIssuerNoBytes(value);
                return this;
            }

            public int getCardBizType() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getCardBizType();
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setCardBizType(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setCardBizType(value);
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder clearCardBizType() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).clearCardBizType();
                return this;
            }

            public int getCaKeyIdx() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getCaKeyIdx();
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setCaKeyIdx(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setCaKeyIdx(value);
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder clearCaKeyIdx() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).clearCaKeyIdx();
                return this;
            }

            public String getUserAccountType() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getUserAccountType();
            }

            public ByteString getUserAccountTypeBytes() {
                return ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).getUserAccountTypeBytes();
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setUserAccountType(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setUserAccountType(value);
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder clearUserAccountType() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).clearUserAccountType();
                return this;
            }

            public IBusCloudSDKProto.AlipayTradeInfo.Builder setUserAccountTypeBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.AlipayTradeInfo) this.instance).setUserAccountTypeBytes(value);
                return this;
            }
        }

        public static enum CodeType implements EnumLite {
            ALIPAY_RAW(0),
            ALIPAY_VCARD(1),
            ALIPAY_MOT(2),
            UNRECOGNIZED(-1);

            public static final int ALIPAY_RAW_VALUE = 0;
            public static final int ALIPAY_VCARD_VALUE = 1;
            public static final int ALIPAY_MOT_VALUE = 2;
            private static final EnumLiteMap<CodeType> internalValueMap = new EnumLiteMap<CodeType>() {
                public IBusCloudSDKProto.AlipayTradeInfo.CodeType findValueByNumber(int number) {
                    return IBusCloudSDKProto.AlipayTradeInfo.CodeType.forNumber(number);
                }
            };
            private final int value;

            public final int getNumber() {
                if (this == UNRECOGNIZED) {
                    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                } else {
                    return this.value;
                }
            }

            /**
             * @deprecated
             */
            @Deprecated
            public static IBusCloudSDKProto.AlipayTradeInfo.CodeType valueOf(int value) {
                return forNumber(value);
            }

            public static IBusCloudSDKProto.AlipayTradeInfo.CodeType forNumber(int value) {
                switch (value) {
                    case 0:
                        return ALIPAY_RAW;
                    case 1:
                        return ALIPAY_VCARD;
                    case 2:
                        return ALIPAY_MOT;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<CodeType> internalGetValueMap() {
                return internalValueMap;
            }

            private CodeType(int value) {
                this.value = value;
            }
        }
    }

    public interface AlipayTradeInfoOrBuilder extends MessageLiteOrBuilder {
        int getTypeValue();

        IBusCloudSDKProto.AlipayTradeInfo.CodeType getType();

        String getUserId();

        ByteString getUserIdBytes();

        String getCardNo();

        ByteString getCardNoBytes();

        String getCardType();

        ByteString getCardTypeBytes();

        ByteString getCardData();

        String getCodeIssuerNo();

        ByteString getCodeIssuerNoBytes();

        ByteString getTradeRecord();

        int getSignMode();

        String getCertSn();

        ByteString getCertSnBytes();

        String getCardIssuerNo();

        ByteString getCardIssuerNoBytes();

        int getCardBizType();

        int getCaKeyIdx();

        String getUserAccountType();

        ByteString getUserAccountTypeBytes();
    }

    public static final class DownloadCardTypes extends GeneratedMessageLite<DownloadCardTypes, DownloadCardTypes.Builder> implements IBusCloudSDKProto.DownloadCardTypesOrBuilder {
        public static final int TYPELISTS_FIELD_NUMBER = 1;
        private ProtobufList<CardTypeList> typelists_ = emptyProtobufList();
        public static final int METAINFO_LIST_FIELD_NUMBER = 2;
        private ProtobufList<MetaInfo> metainfoList_ = emptyProtobufList();
        private static final IBusCloudSDKProto.DownloadCardTypes DEFAULT_INSTANCE = new IBusCloudSDKProto.DownloadCardTypes();
        private static volatile Parser<DownloadCardTypes> PARSER;

        private DownloadCardTypes() {
        }

        public List<CardTypeList> getTypelistsList() {
            return this.typelists_;
        }

        public List<? extends CardTypeListOrBuilder> getTypelistsOrBuilderList() {
            return this.typelists_;
        }

        public int getTypelistsCount() {
            return this.typelists_.size();
        }

        public IBusCloudSDKProto.CardTypeList getTypelists(int index) {
            return (IBusCloudSDKProto.CardTypeList) this.typelists_.get(index);
        }

        public IBusCloudSDKProto.CardTypeListOrBuilder getTypelistsOrBuilder(int index) {
            return (IBusCloudSDKProto.CardTypeListOrBuilder) this.typelists_.get(index);
        }

        private void ensureTypelistsIsMutable() {
            if (!this.typelists_.isModifiable()) {
                this.typelists_ = GeneratedMessageLite.mutableCopy(this.typelists_);
            }

        }

        private void setTypelists(int index, IBusCloudSDKProto.CardTypeList value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureTypelistsIsMutable();
                this.typelists_.set(index, value);
            }
        }

        private void setTypelists(int index, IBusCloudSDKProto.CardTypeList.Builder builderForValue) {
            this.ensureTypelistsIsMutable();
            this.typelists_.set(index, builderForValue.build());
        }

        private void addTypelists(IBusCloudSDKProto.CardTypeList value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureTypelistsIsMutable();
                this.typelists_.add(value);
            }
        }

        private void addTypelists(int index, IBusCloudSDKProto.CardTypeList value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureTypelistsIsMutable();
                this.typelists_.add(index, value);
            }
        }

        private void addTypelists(IBusCloudSDKProto.CardTypeList.Builder builderForValue) {
            this.ensureTypelistsIsMutable();
            this.typelists_.add(builderForValue.build());
        }

        private void addTypelists(int index, IBusCloudSDKProto.CardTypeList.Builder builderForValue) {
            this.ensureTypelistsIsMutable();
            this.typelists_.add(index, builderForValue.build());
        }

        private void addAllTypelists(Iterable<? extends CardTypeList> values) {
            this.ensureTypelistsIsMutable();
            AbstractMessageLite.addAll(values, this.typelists_);
        }

        private void clearTypelists() {
            this.typelists_ = emptyProtobufList();
        }

        private void removeTypelists(int index) {
            this.ensureTypelistsIsMutable();
            this.typelists_.remove(index);
        }

        public List<MetaInfo> getMetainfoListList() {
            return this.metainfoList_;
        }

        public List<? extends MetaInfoOrBuilder> getMetainfoListOrBuilderList() {
            return this.metainfoList_;
        }

        public int getMetainfoListCount() {
            return this.metainfoList_.size();
        }

        public IBusCloudSDKProto.MetaInfo getMetainfoList(int index) {
            return (IBusCloudSDKProto.MetaInfo) this.metainfoList_.get(index);
        }

        public IBusCloudSDKProto.MetaInfoOrBuilder getMetainfoListOrBuilder(int index) {
            return (IBusCloudSDKProto.MetaInfoOrBuilder) this.metainfoList_.get(index);
        }

        private void ensureMetainfoListIsMutable() {
            if (!this.metainfoList_.isModifiable()) {
                this.metainfoList_ = GeneratedMessageLite.mutableCopy(this.metainfoList_);
            }

        }

        private void setMetainfoList(int index, IBusCloudSDKProto.MetaInfo value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureMetainfoListIsMutable();
                this.metainfoList_.set(index, value);
            }
        }

        private void setMetainfoList(int index, IBusCloudSDKProto.MetaInfo.Builder builderForValue) {
            this.ensureMetainfoListIsMutable();
            this.metainfoList_.set(index, builderForValue.build());
        }

        private void addMetainfoList(IBusCloudSDKProto.MetaInfo value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureMetainfoListIsMutable();
                this.metainfoList_.add(value);
            }
        }

        private void addMetainfoList(int index, IBusCloudSDKProto.MetaInfo value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureMetainfoListIsMutable();
                this.metainfoList_.add(index, value);
            }
        }

        private void addMetainfoList(IBusCloudSDKProto.MetaInfo.Builder builderForValue) {
            this.ensureMetainfoListIsMutable();
            this.metainfoList_.add(builderForValue.build());
        }

        private void addMetainfoList(int index, IBusCloudSDKProto.MetaInfo.Builder builderForValue) {
            this.ensureMetainfoListIsMutable();
            this.metainfoList_.add(index, builderForValue.build());
        }

        private void addAllMetainfoList(Iterable<? extends MetaInfo> values) {
            this.ensureMetainfoListIsMutable();
            AbstractMessageLite.addAll(values, this.metainfoList_);
        }

        private void clearMetainfoList() {
            this.metainfoList_ = emptyProtobufList();
        }

        private void removeMetainfoList(int index) {
            this.ensureMetainfoListIsMutable();
            this.metainfoList_.remove(index);
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            int i;
            for (i = 0; i < this.typelists_.size(); ++i) {
                output.writeMessage(1, (MessageLite) this.typelists_.get(i));
            }

            for (i = 0; i < this.metainfoList_.size(); ++i) {
                output.writeMessage(2, (MessageLite) this.metainfoList_.get(i));
            }

            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            } else {
                size = 0;

                int i;
                for (i = 0; i < this.typelists_.size(); ++i) {
                    size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.typelists_.get(i));
                }

                for (i = 0; i < this.metainfoList_.size(); ++i) {
                    size += CodedOutputStream.computeMessageSize(2, (MessageLite) this.metainfoList_.get(i));
                }

                size += this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }
        }

        public static IBusCloudSDKProto.DownloadCardTypes parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.DownloadCardTypes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.DownloadCardTypes parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.DownloadCardTypes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.DownloadCardTypes parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.DownloadCardTypes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.DownloadCardTypes parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.DownloadCardTypes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.DownloadCardTypes parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.DownloadCardTypes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.DownloadCardTypes parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.DownloadCardTypes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.DownloadCardTypes parseFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.DownloadCardTypes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.DownloadCardTypes parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.DownloadCardTypes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.DownloadCardTypes parseDelimitedFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.DownloadCardTypes) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.DownloadCardTypes parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.DownloadCardTypes) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.DownloadCardTypes parseFrom(CodedInputStream input) throws IOException {
            return (IBusCloudSDKProto.DownloadCardTypes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.DownloadCardTypes parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.DownloadCardTypes) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.DownloadCardTypes.Builder newBuilder() {
            return (IBusCloudSDKProto.DownloadCardTypes.Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static IBusCloudSDKProto.DownloadCardTypes.Builder newBuilder(IBusCloudSDKProto.DownloadCardTypes prototype) {
            return (IBusCloudSDKProto.DownloadCardTypes.Builder) DEFAULT_INSTANCE.createBuilder(prototype);
        }

        protected final Object dynamicMethod(MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new IBusCloudSDKProto.DownloadCardTypes();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.typelists_.makeImmutable();
                    this.metainfoList_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new IBusCloudSDKProto.DownloadCardTypes.Builder();
                case VISIT:
                    Visitor visitor = (Visitor) arg0;
                    IBusCloudSDKProto.DownloadCardTypes other = (IBusCloudSDKProto.DownloadCardTypes) arg1;
                    this.typelists_ = visitor.visitList(this.typelists_, other.typelists_);
                    this.metainfoList_ = visitor.visitList(this.metainfoList_, other.metainfoList_);
                    if (visitor == MergeFromVisitor.INSTANCE) {
                        ;
                    }

                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream input = (CodedInputStream) arg0;
                    ExtensionRegistryLite extensionRegistry = (ExtensionRegistryLite) arg1;
                    if (extensionRegistry == null) {
                        throw new NullPointerException();
                    } else {
                        try {
                            boolean done = false;

                            while (!done) {
                                int tag = input.readTag();
                                switch (tag) {
                                    case 0:
                                        done = true;
                                        break;
                                    case 10:
                                        if (!this.typelists_.isModifiable()) {
                                            this.typelists_ = GeneratedMessageLite.mutableCopy(this.typelists_);
                                        }

                                        this.typelists_.add(input.readMessage(IBusCloudSDKProto.CardTypeList.parser(), extensionRegistry));
                                        break;
                                    case 18:
                                        if (!this.metainfoList_.isModifiable()) {
                                            this.metainfoList_ = GeneratedMessageLite.mutableCopy(this.metainfoList_);
                                        }

                                        this.metainfoList_.add(input.readMessage(IBusCloudSDKProto.MetaInfo.parser(), extensionRegistry));
                                        break;
                                    default:
                                        if (!this.parseUnknownField(tag, input)) {
                                            done = true;
                                        }
                                }
                            }
                        } catch (InvalidProtocolBufferException var15) {
                            throw new RuntimeException(var15.setUnfinishedMessage(this));
                        } catch (IOException var16) {
                            throw new RuntimeException((new InvalidProtocolBufferException(var16.getMessage())).setUnfinishedMessage(this));
                        } finally {
                            ;
                        }
                    }
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    if (PARSER == null) {
                        Class var4 = IBusCloudSDKProto.DownloadCardTypes.class;
                        synchronized (IBusCloudSDKProto.DownloadCardTypes.class) {
                            if (PARSER == null) {
                                PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }

                    return PARSER;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static IBusCloudSDKProto.DownloadCardTypes getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DownloadCardTypes> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        static {
            DEFAULT_INSTANCE.makeImmutable();
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DownloadCardTypes, Builder> implements IBusCloudSDKProto.DownloadCardTypesOrBuilder {
            private Builder() {
                super(IBusCloudSDKProto.DownloadCardTypes.DEFAULT_INSTANCE);
            }

            public List<CardTypeList> getTypelistsList() {
                return Collections.unmodifiableList(((IBusCloudSDKProto.DownloadCardTypes) this.instance).getTypelistsList());
            }

            public int getTypelistsCount() {
                return ((IBusCloudSDKProto.DownloadCardTypes) this.instance).getTypelistsCount();
            }

            public IBusCloudSDKProto.CardTypeList getTypelists(int index) {
                return ((IBusCloudSDKProto.DownloadCardTypes) this.instance).getTypelists(index);
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder setTypelists(int index, IBusCloudSDKProto.CardTypeList value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).setTypelists(index, value);
                return this;
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder setTypelists(int index, IBusCloudSDKProto.CardTypeList.Builder builderForValue) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).setTypelists(index, builderForValue);
                return this;
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder addTypelists(IBusCloudSDKProto.CardTypeList value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).addTypelists(value);
                return this;
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder addTypelists(int index, IBusCloudSDKProto.CardTypeList value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).addTypelists(index, value);
                return this;
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder addTypelists(IBusCloudSDKProto.CardTypeList.Builder builderForValue) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).addTypelists(builderForValue);
                return this;
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder addTypelists(int index, IBusCloudSDKProto.CardTypeList.Builder builderForValue) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).addTypelists(index, builderForValue);
                return this;
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder addAllTypelists(Iterable<? extends CardTypeList> values) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).addAllTypelists(values);
                return this;
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder clearTypelists() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).clearTypelists();
                return this;
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder removeTypelists(int index) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).removeTypelists(index);
                return this;
            }

            public List<MetaInfo> getMetainfoListList() {
                return Collections.unmodifiableList(((IBusCloudSDKProto.DownloadCardTypes) this.instance).getMetainfoListList());
            }

            public int getMetainfoListCount() {
                return ((IBusCloudSDKProto.DownloadCardTypes) this.instance).getMetainfoListCount();
            }

            public IBusCloudSDKProto.MetaInfo getMetainfoList(int index) {
                return ((IBusCloudSDKProto.DownloadCardTypes) this.instance).getMetainfoList(index);
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder setMetainfoList(int index, IBusCloudSDKProto.MetaInfo value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).setMetainfoList(index, value);
                return this;
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder setMetainfoList(int index, IBusCloudSDKProto.MetaInfo.Builder builderForValue) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).setMetainfoList(index, builderForValue);
                return this;
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder addMetainfoList(IBusCloudSDKProto.MetaInfo value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).addMetainfoList(value);
                return this;
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder addMetainfoList(int index, IBusCloudSDKProto.MetaInfo value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).addMetainfoList(index, value);
                return this;
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder addMetainfoList(IBusCloudSDKProto.MetaInfo.Builder builderForValue) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).addMetainfoList(builderForValue);
                return this;
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder addMetainfoList(int index, IBusCloudSDKProto.MetaInfo.Builder builderForValue) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).addMetainfoList(index, builderForValue);
                return this;
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder addAllMetainfoList(Iterable<? extends MetaInfo> values) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).addAllMetainfoList(values);
                return this;
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder clearMetainfoList() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).clearMetainfoList();
                return this;
            }

            public IBusCloudSDKProto.DownloadCardTypes.Builder removeMetainfoList(int index) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadCardTypes) this.instance).removeMetainfoList(index);
                return this;
            }
        }
    }

    public interface DownloadCardTypesOrBuilder extends MessageLiteOrBuilder {
        List<CardTypeList> getTypelistsList();

        IBusCloudSDKProto.CardTypeList getTypelists(int var1);

        int getTypelistsCount();

        List<MetaInfo> getMetainfoListList();

        IBusCloudSDKProto.MetaInfo getMetainfoList(int var1);

        int getMetainfoListCount();
    }

    public static final class DownloadKeyInfo extends GeneratedMessageLite<DownloadKeyInfo, DownloadKeyInfo.Builder> implements IBusCloudSDKProto.DownloadKeyInfoOrBuilder {
        public static final int KEYS_FIELD_NUMBER = 1;
        private ProtobufList<KeyInfo> keys_ = emptyProtobufList();
        private static final IBusCloudSDKProto.DownloadKeyInfo DEFAULT_INSTANCE = new IBusCloudSDKProto.DownloadKeyInfo();
        private static volatile Parser<DownloadKeyInfo> PARSER;

        private DownloadKeyInfo() {
        }

        public List<KeyInfo> getKeysList() {
            return this.keys_;
        }

        public List<? extends KeyInfoOrBuilder> getKeysOrBuilderList() {
            return this.keys_;
        }

        public int getKeysCount() {
            return this.keys_.size();
        }

        public IBusCloudSDKProto.KeyInfo getKeys(int index) {
            return (IBusCloudSDKProto.KeyInfo) this.keys_.get(index);
        }

        public IBusCloudSDKProto.KeyInfoOrBuilder getKeysOrBuilder(int index) {
            return (IBusCloudSDKProto.KeyInfoOrBuilder) this.keys_.get(index);
        }

        private void ensureKeysIsMutable() {
            if (!this.keys_.isModifiable()) {
                this.keys_ = GeneratedMessageLite.mutableCopy(this.keys_);
            }

        }

        private void setKeys(int index, IBusCloudSDKProto.KeyInfo value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureKeysIsMutable();
                this.keys_.set(index, value);
            }
        }

        private void setKeys(int index, IBusCloudSDKProto.KeyInfo.Builder builderForValue) {
            this.ensureKeysIsMutable();
            this.keys_.set(index, builderForValue.build());
        }

        private void addKeys(IBusCloudSDKProto.KeyInfo value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureKeysIsMutable();
                this.keys_.add(value);
            }
        }

        private void addKeys(int index, IBusCloudSDKProto.KeyInfo value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.ensureKeysIsMutable();
                this.keys_.add(index, value);
            }
        }

        private void addKeys(IBusCloudSDKProto.KeyInfo.Builder builderForValue) {
            this.ensureKeysIsMutable();
            this.keys_.add(builderForValue.build());
        }

        private void addKeys(int index, IBusCloudSDKProto.KeyInfo.Builder builderForValue) {
            this.ensureKeysIsMutable();
            this.keys_.add(index, builderForValue.build());
        }

        private void addAllKeys(Iterable<? extends KeyInfo> values) {
            this.ensureKeysIsMutable();
            AbstractMessageLite.addAll(values, this.keys_);
        }

        private void clearKeys() {
            this.keys_ = emptyProtobufList();
        }

        private void removeKeys(int index) {
            this.ensureKeysIsMutable();
            this.keys_.remove(index);
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            for (int i = 0; i < this.keys_.size(); ++i) {
                output.writeMessage(1, (MessageLite) this.keys_.get(i));
            }

            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            } else {
                size = 0;

                for (int i = 0; i < this.keys_.size(); ++i) {
                    size += CodedOutputStream.computeMessageSize(1, (MessageLite) this.keys_.get(i));
                }

                size += this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }
        }

        public static IBusCloudSDKProto.DownloadKeyInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.DownloadKeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.DownloadKeyInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.DownloadKeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.DownloadKeyInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.DownloadKeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.DownloadKeyInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.DownloadKeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.DownloadKeyInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.DownloadKeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.DownloadKeyInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.DownloadKeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.DownloadKeyInfo parseFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.DownloadKeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.DownloadKeyInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.DownloadKeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.DownloadKeyInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.DownloadKeyInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.DownloadKeyInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.DownloadKeyInfo) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.DownloadKeyInfo parseFrom(CodedInputStream input) throws IOException {
            return (IBusCloudSDKProto.DownloadKeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.DownloadKeyInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.DownloadKeyInfo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.DownloadKeyInfo.Builder newBuilder() {
            return (IBusCloudSDKProto.DownloadKeyInfo.Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static IBusCloudSDKProto.DownloadKeyInfo.Builder newBuilder(IBusCloudSDKProto.DownloadKeyInfo prototype) {
            return (IBusCloudSDKProto.DownloadKeyInfo.Builder) DEFAULT_INSTANCE.createBuilder(prototype);
        }

        protected final Object dynamicMethod(MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new IBusCloudSDKProto.DownloadKeyInfo();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    this.keys_.makeImmutable();
                    return null;
                case NEW_BUILDER:
                    return new IBusCloudSDKProto.DownloadKeyInfo.Builder();
                case VISIT:
                    Visitor visitor = (Visitor) arg0;
                    IBusCloudSDKProto.DownloadKeyInfo other = (IBusCloudSDKProto.DownloadKeyInfo) arg1;
                    this.keys_ = visitor.visitList(this.keys_, other.keys_);
                    if (visitor == MergeFromVisitor.INSTANCE) {
                        ;
                    }

                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream input = (CodedInputStream) arg0;
                    ExtensionRegistryLite extensionRegistry = (ExtensionRegistryLite) arg1;
                    if (extensionRegistry == null) {
                        throw new NullPointerException();
                    } else {
                        try {
                            boolean done = false;

                            while (!done) {
                                int tag = input.readTag();
                                switch (tag) {
                                    case 0:
                                        done = true;
                                        break;
                                    case 10:
                                        if (!this.keys_.isModifiable()) {
                                            this.keys_ = GeneratedMessageLite.mutableCopy(this.keys_);
                                        }

                                        this.keys_.add(input.readMessage(IBusCloudSDKProto.KeyInfo.parser(), extensionRegistry));
                                        break;
                                    default:
                                        if (!this.parseUnknownField(tag, input)) {
                                            done = true;
                                        }
                                }
                            }
                        } catch (InvalidProtocolBufferException var15) {
                            throw new RuntimeException(var15.setUnfinishedMessage(this));
                        } catch (IOException var16) {
                            throw new RuntimeException((new InvalidProtocolBufferException(var16.getMessage())).setUnfinishedMessage(this));
                        } finally {
                            ;
                        }
                    }
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    if (PARSER == null) {
                        Class var4 = IBusCloudSDKProto.DownloadKeyInfo.class;
                        synchronized (IBusCloudSDKProto.DownloadKeyInfo.class) {
                            if (PARSER == null) {
                                PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }

                    return PARSER;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static IBusCloudSDKProto.DownloadKeyInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DownloadKeyInfo> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        static {
            DEFAULT_INSTANCE.makeImmutable();
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DownloadKeyInfo, Builder> implements IBusCloudSDKProto.DownloadKeyInfoOrBuilder {
            private Builder() {
                super(IBusCloudSDKProto.DownloadKeyInfo.DEFAULT_INSTANCE);
            }

            public List<KeyInfo> getKeysList() {
                return Collections.unmodifiableList(((IBusCloudSDKProto.DownloadKeyInfo) this.instance).getKeysList());
            }

            public int getKeysCount() {
                return ((IBusCloudSDKProto.DownloadKeyInfo) this.instance).getKeysCount();
            }

            public IBusCloudSDKProto.KeyInfo getKeys(int index) {
                return ((IBusCloudSDKProto.DownloadKeyInfo) this.instance).getKeys(index);
            }

            public IBusCloudSDKProto.DownloadKeyInfo.Builder setKeys(int index, IBusCloudSDKProto.KeyInfo value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadKeyInfo) this.instance).setKeys(index, value);
                return this;
            }

            public IBusCloudSDKProto.DownloadKeyInfo.Builder setKeys(int index, IBusCloudSDKProto.KeyInfo.Builder builderForValue) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadKeyInfo) this.instance).setKeys(index, builderForValue);
                return this;
            }

            public IBusCloudSDKProto.DownloadKeyInfo.Builder addKeys(IBusCloudSDKProto.KeyInfo value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadKeyInfo) this.instance).addKeys(value);
                return this;
            }

            public IBusCloudSDKProto.DownloadKeyInfo.Builder addKeys(int index, IBusCloudSDKProto.KeyInfo value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadKeyInfo) this.instance).addKeys(index, value);
                return this;
            }

            public IBusCloudSDKProto.DownloadKeyInfo.Builder addKeys(IBusCloudSDKProto.KeyInfo.Builder builderForValue) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadKeyInfo) this.instance).addKeys(builderForValue);
                return this;
            }

            public IBusCloudSDKProto.DownloadKeyInfo.Builder addKeys(int index, IBusCloudSDKProto.KeyInfo.Builder builderForValue) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadKeyInfo) this.instance).addKeys(index, builderForValue);
                return this;
            }

            public IBusCloudSDKProto.DownloadKeyInfo.Builder addAllKeys(Iterable<? extends KeyInfo> values) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadKeyInfo) this.instance).addAllKeys(values);
                return this;
            }

            public IBusCloudSDKProto.DownloadKeyInfo.Builder clearKeys() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadKeyInfo) this.instance).clearKeys();
                return this;
            }

            public IBusCloudSDKProto.DownloadKeyInfo.Builder removeKeys(int index) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.DownloadKeyInfo) this.instance).removeKeys(index);
                return this;
            }
        }
    }

    public interface DownloadKeyInfoOrBuilder extends MessageLiteOrBuilder {
        List<KeyInfo> getKeysList();

        IBusCloudSDKProto.KeyInfo getKeys(int var1);

        int getKeysCount();
    }

    public static final class UploadMessage extends GeneratedMessageLite<UploadMessage, UploadMessage.Builder> implements IBusCloudSDKProto.UploadMessageOrBuilder {
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int VERSION_FIELD_NUMBER = 2;
        private int version_;
        public static final int POS_ID_FIELD_NUMBER = 3;
        private String posId_ = "";
        public static final int BUS_ID_FIELD_NUMBER = 4;
        private String busId_ = "";
        public static final int ROUTE_ID_FIELD_NUMBER = 5;
        private String routeId_ = "";
        public static final int CITY_ID_FIELD_NUMBER = 6;
        private String cityId_ = "";
        public static final int TICKET_PRICE_FIELD_NUMBER = 7;
        private int ticketPrice_;
        public static final int COST_FIELD_NUMBER = 8;
        private int cost_;
        public static final int TIME_STAMP_FIELD_NUMBER = 9;
        private int timeStamp_;
        public static final int TICKET_TYPE_FIELD_NUMBER = 10;
        private int ticketType_;
        public static final int LONGITUDE_FIELD_NUMBER = 16;
        private double longitude_;
        public static final int LATITUDE_FIELD_NUMBER = 17;
        private double latitude_;
        public static final int DRIVER_ID_FIELD_NUMBER = 18;
        private String driverId_ = "";
        public static final int ATTENDANCE_TIME_FIELD_NUMBER = 19;
        private int attendanceTime_;
        public static final int COMPANY_ID_FIELD_NUMBER = 20;
        private String companyId_ = "";
        public static final int UPDOWN_FLAG_FIELD_NUMBER = 21;
        private int updownFlag_;
        public static final int FLEET_CODE_FIELD_NUMBER = 22;
        private String fleetCode_ = "";
        public static final int DEPARTMENT_ID_FIELD_NUMBER = 23;
        private String departmentId_ = "";
        public static final int POS_SERIAL_NO_FIELD_NUMBER = 11;
        private int posSerialNo_;
        public static final int ALIPAY_TRADE_FIELD_NUMBER = 12;
        private IBusCloudSDKProto.AlipayTradeInfo alipayTrade_;
        public static final int UNIONPAY_TRADE_FIELD_NUMBER = 14;
        private IBusCloudSDKProto.UnionpayTradeInfo unionpayTrade_;
        public static final int TRANSPORTPAY_TRADE_FIELD_NUMBER = 15;
        private IBusCloudSDKProto.TransportPayTradeInfo transportpayTrade_;
        public static final int ZJRC_TRADE_FIELD_NUMBER = 24;
        private IBusCloudSDKProto.ZjrcScppTradeInfo zjrcTrade_;
        public static final int ERROR_CODE_FIELD_NUMBER = 30;
        private int errorCode_;
        public static final int ERROR_MSG_FIELD_NUMBER = 31;
        private String errorMsg_ = "";
        public static final int UNIQUE_RECORD_FIELD_NUMBER = 13;
        private String uniqueRecord_ = "";
        private static final IBusCloudSDKProto.UploadMessage DEFAULT_INSTANCE = new IBusCloudSDKProto.UploadMessage();
        private static volatile Parser<UploadMessage> PARSER;

        private UploadMessage() {
        }

        public int getTypeValue() {
            return this.type_;
        }

        public IBusCloudSDKProto.UploadMessage.MessageType getType() {
            IBusCloudSDKProto.UploadMessage.MessageType result = IBusCloudSDKProto.UploadMessage.MessageType.forNumber(this.type_);
            return result == null ? IBusCloudSDKProto.UploadMessage.MessageType.UNRECOGNIZED : result;
        }

        private void setTypeValue(int value) {
            this.type_ = value;
        }

        private void setType(IBusCloudSDKProto.UploadMessage.MessageType value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.type_ = value.getNumber();
            }
        }

        private void clearType() {
            this.type_ = 0;
        }

        public int getVersion() {
            return this.version_;
        }

        private void setVersion(int value) {
            this.version_ = value;
        }

        private void clearVersion() {
            this.version_ = 0;
        }

        public String getPosId() {
            return this.posId_;
        }

        public ByteString getPosIdBytes() {
            return ByteString.copyFromUtf8(this.posId_);
        }

        private void setPosId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.posId_ = value;
            }
        }

        private void clearPosId() {
            this.posId_ = getDefaultInstance().getPosId();
        }

        private void setPosIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.posId_ = value.toStringUtf8();
            }
        }

        public String getBusId() {
            return this.busId_;
        }

        public ByteString getBusIdBytes() {
            return ByteString.copyFromUtf8(this.busId_);
        }

        private void setBusId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.busId_ = value;
            }
        }

        private void clearBusId() {
            this.busId_ = getDefaultInstance().getBusId();
        }

        private void setBusIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.busId_ = value.toStringUtf8();
            }
        }

        public String getRouteId() {
            return this.routeId_;
        }

        public ByteString getRouteIdBytes() {
            return ByteString.copyFromUtf8(this.routeId_);
        }

        private void setRouteId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.routeId_ = value;
            }
        }

        private void clearRouteId() {
            this.routeId_ = getDefaultInstance().getRouteId();
        }

        private void setRouteIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.routeId_ = value.toStringUtf8();
            }
        }

        public String getCityId() {
            return this.cityId_;
        }

        public ByteString getCityIdBytes() {
            return ByteString.copyFromUtf8(this.cityId_);
        }

        private void setCityId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.cityId_ = value;
            }
        }

        private void clearCityId() {
            this.cityId_ = getDefaultInstance().getCityId();
        }

        private void setCityIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.cityId_ = value.toStringUtf8();
            }
        }

        public int getTicketPrice() {
            return this.ticketPrice_;
        }

        private void setTicketPrice(int value) {
            this.ticketPrice_ = value;
        }

        private void clearTicketPrice() {
            this.ticketPrice_ = 0;
        }

        public int getCost() {
            return this.cost_;
        }

        private void setCost(int value) {
            this.cost_ = value;
        }

        private void clearCost() {
            this.cost_ = 0;
        }

        public int getTimeStamp() {
            return this.timeStamp_;
        }

        private void setTimeStamp(int value) {
            this.timeStamp_ = value;
        }

        private void clearTimeStamp() {
            this.timeStamp_ = 0;
        }

        public int getTicketType() {
            return this.ticketType_;
        }

        private void setTicketType(int value) {
            this.ticketType_ = value;
        }

        private void clearTicketType() {
            this.ticketType_ = 0;
        }

        public double getLongitude() {
            return this.longitude_;
        }

        private void setLongitude(double value) {
            this.longitude_ = value;
        }

        private void clearLongitude() {
            this.longitude_ = 0.0D;
        }

        public double getLatitude() {
            return this.latitude_;
        }

        private void setLatitude(double value) {
            this.latitude_ = value;
        }

        private void clearLatitude() {
            this.latitude_ = 0.0D;
        }

        public String getDriverId() {
            return this.driverId_;
        }

        public ByteString getDriverIdBytes() {
            return ByteString.copyFromUtf8(this.driverId_);
        }

        private void setDriverId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.driverId_ = value;
            }
        }

        private void clearDriverId() {
            this.driverId_ = getDefaultInstance().getDriverId();
        }

        private void setDriverIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.driverId_ = value.toStringUtf8();
            }
        }

        public int getAttendanceTime() {
            return this.attendanceTime_;
        }

        private void setAttendanceTime(int value) {
            this.attendanceTime_ = value;
        }

        private void clearAttendanceTime() {
            this.attendanceTime_ = 0;
        }

        public String getCompanyId() {
            return this.companyId_;
        }

        public ByteString getCompanyIdBytes() {
            return ByteString.copyFromUtf8(this.companyId_);
        }

        private void setCompanyId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.companyId_ = value;
            }
        }

        private void clearCompanyId() {
            this.companyId_ = getDefaultInstance().getCompanyId();
        }

        private void setCompanyIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.companyId_ = value.toStringUtf8();
            }
        }

        public int getUpdownFlag() {
            return this.updownFlag_;
        }

        private void setUpdownFlag(int value) {
            this.updownFlag_ = value;
        }

        private void clearUpdownFlag() {
            this.updownFlag_ = 0;
        }

        public String getFleetCode() {
            return this.fleetCode_;
        }

        public ByteString getFleetCodeBytes() {
            return ByteString.copyFromUtf8(this.fleetCode_);
        }

        private void setFleetCode(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.fleetCode_ = value;
            }
        }

        private void clearFleetCode() {
            this.fleetCode_ = getDefaultInstance().getFleetCode();
        }

        private void setFleetCodeBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.fleetCode_ = value.toStringUtf8();
            }
        }

        public String getDepartmentId() {
            return this.departmentId_;
        }

        public ByteString getDepartmentIdBytes() {
            return ByteString.copyFromUtf8(this.departmentId_);
        }

        private void setDepartmentId(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.departmentId_ = value;
            }
        }

        private void clearDepartmentId() {
            this.departmentId_ = getDefaultInstance().getDepartmentId();
        }

        private void setDepartmentIdBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.departmentId_ = value.toStringUtf8();
            }
        }

        public int getPosSerialNo() {
            return this.posSerialNo_;
        }

        private void setPosSerialNo(int value) {
            this.posSerialNo_ = value;
        }

        private void clearPosSerialNo() {
            this.posSerialNo_ = 0;
        }

        public boolean hasAlipayTrade() {
            return this.alipayTrade_ != null;
        }

        public IBusCloudSDKProto.AlipayTradeInfo getAlipayTrade() {
            return this.alipayTrade_ == null ? IBusCloudSDKProto.AlipayTradeInfo.getDefaultInstance() : this.alipayTrade_;
        }

        private void setAlipayTrade(IBusCloudSDKProto.AlipayTradeInfo value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.alipayTrade_ = value;
            }
        }

        private void setAlipayTrade(IBusCloudSDKProto.AlipayTradeInfo.Builder builderForValue) {
            this.alipayTrade_ = (IBusCloudSDKProto.AlipayTradeInfo) builderForValue.build();
        }

        private void mergeAlipayTrade(IBusCloudSDKProto.AlipayTradeInfo value) {
            if (this.alipayTrade_ != null && this.alipayTrade_ != IBusCloudSDKProto.AlipayTradeInfo.getDefaultInstance()) {
                this.alipayTrade_ = (IBusCloudSDKProto.AlipayTradeInfo) ((IBusCloudSDKProto.AlipayTradeInfo.Builder) IBusCloudSDKProto.AlipayTradeInfo.newBuilder(this.alipayTrade_).mergeFrom(value)).buildPartial();
            } else {
                this.alipayTrade_ = value;
            }

        }

        private void clearAlipayTrade() {
            this.alipayTrade_ = null;
        }

        public boolean hasUnionpayTrade() {
            return this.unionpayTrade_ != null;
        }

        public IBusCloudSDKProto.UnionpayTradeInfo getUnionpayTrade() {
            return this.unionpayTrade_ == null ? IBusCloudSDKProto.UnionpayTradeInfo.getDefaultInstance() : this.unionpayTrade_;
        }

        private void setUnionpayTrade(IBusCloudSDKProto.UnionpayTradeInfo value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.unionpayTrade_ = value;
            }
        }

        private void setUnionpayTrade(IBusCloudSDKProto.UnionpayTradeInfo.Builder builderForValue) {
            this.unionpayTrade_ = (IBusCloudSDKProto.UnionpayTradeInfo) builderForValue.build();
        }

        private void mergeUnionpayTrade(IBusCloudSDKProto.UnionpayTradeInfo value) {
            if (this.unionpayTrade_ != null && this.unionpayTrade_ != IBusCloudSDKProto.UnionpayTradeInfo.getDefaultInstance()) {
                this.unionpayTrade_ = (IBusCloudSDKProto.UnionpayTradeInfo) ((IBusCloudSDKProto.UnionpayTradeInfo.Builder) IBusCloudSDKProto.UnionpayTradeInfo.newBuilder(this.unionpayTrade_).mergeFrom(value)).buildPartial();
            } else {
                this.unionpayTrade_ = value;
            }

        }

        private void clearUnionpayTrade() {
            this.unionpayTrade_ = null;
        }

        public boolean hasTransportpayTrade() {
            return this.transportpayTrade_ != null;
        }

        public IBusCloudSDKProto.TransportPayTradeInfo getTransportpayTrade() {
            return this.transportpayTrade_ == null ? IBusCloudSDKProto.TransportPayTradeInfo.getDefaultInstance() : this.transportpayTrade_;
        }

        private void setTransportpayTrade(IBusCloudSDKProto.TransportPayTradeInfo value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.transportpayTrade_ = value;
            }
        }

        private void setTransportpayTrade(IBusCloudSDKProto.TransportPayTradeInfo.Builder builderForValue) {
            this.transportpayTrade_ = (IBusCloudSDKProto.TransportPayTradeInfo) builderForValue.build();
        }

        private void mergeTransportpayTrade(IBusCloudSDKProto.TransportPayTradeInfo value) {
            if (this.transportpayTrade_ != null && this.transportpayTrade_ != IBusCloudSDKProto.TransportPayTradeInfo.getDefaultInstance()) {
                this.transportpayTrade_ = (IBusCloudSDKProto.TransportPayTradeInfo) ((IBusCloudSDKProto.TransportPayTradeInfo.Builder) IBusCloudSDKProto.TransportPayTradeInfo.newBuilder(this.transportpayTrade_).mergeFrom(value)).buildPartial();
            } else {
                this.transportpayTrade_ = value;
            }

        }

        private void clearTransportpayTrade() {
            this.transportpayTrade_ = null;
        }

        public boolean hasZjrcTrade() {
            return this.zjrcTrade_ != null;
        }

        public IBusCloudSDKProto.ZjrcScppTradeInfo getZjrcTrade() {
            return this.zjrcTrade_ == null ? IBusCloudSDKProto.ZjrcScppTradeInfo.getDefaultInstance() : this.zjrcTrade_;
        }

        private void setZjrcTrade(IBusCloudSDKProto.ZjrcScppTradeInfo value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.zjrcTrade_ = value;
            }
        }

        private void setZjrcTrade(IBusCloudSDKProto.ZjrcScppTradeInfo.Builder builderForValue) {
            this.zjrcTrade_ = (IBusCloudSDKProto.ZjrcScppTradeInfo) builderForValue.build();
        }

        private void mergeZjrcTrade(IBusCloudSDKProto.ZjrcScppTradeInfo value) {
            if (this.zjrcTrade_ != null && this.zjrcTrade_ != IBusCloudSDKProto.ZjrcScppTradeInfo.getDefaultInstance()) {
                this.zjrcTrade_ = (IBusCloudSDKProto.ZjrcScppTradeInfo) ((IBusCloudSDKProto.ZjrcScppTradeInfo.Builder) IBusCloudSDKProto.ZjrcScppTradeInfo.newBuilder(this.zjrcTrade_).mergeFrom(value)).buildPartial();
            } else {
                this.zjrcTrade_ = value;
            }

        }

        private void clearZjrcTrade() {
            this.zjrcTrade_ = null;
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        private void setErrorCode(int value) {
            this.errorCode_ = value;
        }

        private void clearErrorCode() {
            this.errorCode_ = 0;
        }

        public String getErrorMsg() {
            return this.errorMsg_;
        }

        public ByteString getErrorMsgBytes() {
            return ByteString.copyFromUtf8(this.errorMsg_);
        }

        private void setErrorMsg(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.errorMsg_ = value;
            }
        }

        private void clearErrorMsg() {
            this.errorMsg_ = getDefaultInstance().getErrorMsg();
        }

        private void setErrorMsgBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.errorMsg_ = value.toStringUtf8();
            }
        }

        public String getUniqueRecord() {
            return this.uniqueRecord_;
        }

        public ByteString getUniqueRecordBytes() {
            return ByteString.copyFromUtf8(this.uniqueRecord_);
        }

        private void setUniqueRecord(String value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                this.uniqueRecord_ = value;
            }
        }

        private void clearUniqueRecord() {
            this.uniqueRecord_ = getDefaultInstance().getUniqueRecord();
        }

        private void setUniqueRecordBytes(ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            } else {
                checkByteStringIsUtf8(value);
                this.uniqueRecord_ = value.toStringUtf8();
            }
        }

        public void writeTo(CodedOutputStream output) throws IOException {
            if (this.type_ != IBusCloudSDKProto.UploadMessage.MessageType.ALIPAY.getNumber()) {
                output.writeEnum(1, this.type_);
            }

            if (this.version_ != 0) {
                output.writeInt32(2, this.version_);
            }

            if (!this.posId_.isEmpty()) {
                output.writeString(3, this.getPosId());
            }

            if (!this.busId_.isEmpty()) {
                output.writeString(4, this.getBusId());
            }

            if (!this.routeId_.isEmpty()) {
                output.writeString(5, this.getRouteId());
            }

            if (!this.cityId_.isEmpty()) {
                output.writeString(6, this.getCityId());
            }

            if (this.ticketPrice_ != 0) {
                output.writeInt32(7, this.ticketPrice_);
            }

            if (this.cost_ != 0) {
                output.writeInt32(8, this.cost_);
            }

            if (this.timeStamp_ != 0) {
                output.writeInt32(9, this.timeStamp_);
            }

            if (this.ticketType_ != 0) {
                output.writeInt32(10, this.ticketType_);
            }

            if (this.posSerialNo_ != 0) {
                output.writeInt32(11, this.posSerialNo_);
            }

            if (this.alipayTrade_ != null) {
                output.writeMessage(12, this.getAlipayTrade());
            }

            if (!this.uniqueRecord_.isEmpty()) {
                output.writeString(13, this.getUniqueRecord());
            }

            if (this.unionpayTrade_ != null) {
                output.writeMessage(14, this.getUnionpayTrade());
            }

            if (this.transportpayTrade_ != null) {
                output.writeMessage(15, this.getTransportpayTrade());
            }

            if (this.longitude_ != 0.0D) {
                output.writeDouble(16, this.longitude_);
            }

            if (this.latitude_ != 0.0D) {
                output.writeDouble(17, this.latitude_);
            }

            if (!this.driverId_.isEmpty()) {
                output.writeString(18, this.getDriverId());
            }

            if (this.attendanceTime_ != 0) {
                output.writeInt32(19, this.attendanceTime_);
            }

            if (!this.companyId_.isEmpty()) {
                output.writeString(20, this.getCompanyId());
            }

            if (this.updownFlag_ != 0) {
                output.writeInt32(21, this.updownFlag_);
            }

            if (!this.fleetCode_.isEmpty()) {
                output.writeString(22, this.getFleetCode());
            }

            if (!this.departmentId_.isEmpty()) {
                output.writeString(23, this.getDepartmentId());
            }

            if (this.zjrcTrade_ != null) {
                output.writeMessage(24, this.getZjrcTrade());
            }

            if (this.errorCode_ != 0) {
                output.writeInt32(30, this.errorCode_);
            }

            if (!this.errorMsg_.isEmpty()) {
                output.writeString(31, this.getErrorMsg());
            }

            this.unknownFields.writeTo(output);
        }

        public int getSerializedSize() {
            int size = this.memoizedSerializedSize;
            if (size != -1) {
                return size;
            } else {
                size = 0;
                if (this.type_ != IBusCloudSDKProto.UploadMessage.MessageType.ALIPAY.getNumber()) {
                    size += CodedOutputStream.computeEnumSize(1, this.type_);
                }

                if (this.version_ != 0) {
                    size += CodedOutputStream.computeInt32Size(2, this.version_);
                }

                if (!this.posId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(3, this.getPosId());
                }

                if (!this.busId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(4, this.getBusId());
                }

                if (!this.routeId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(5, this.getRouteId());
                }

                if (!this.cityId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(6, this.getCityId());
                }

                if (this.ticketPrice_ != 0) {
                    size += CodedOutputStream.computeInt32Size(7, this.ticketPrice_);
                }

                if (this.cost_ != 0) {
                    size += CodedOutputStream.computeInt32Size(8, this.cost_);
                }

                if (this.timeStamp_ != 0) {
                    size += CodedOutputStream.computeInt32Size(9, this.timeStamp_);
                }

                if (this.ticketType_ != 0) {
                    size += CodedOutputStream.computeInt32Size(10, this.ticketType_);
                }

                if (this.posSerialNo_ != 0) {
                    size += CodedOutputStream.computeInt32Size(11, this.posSerialNo_);
                }

                if (this.alipayTrade_ != null) {
                    size += CodedOutputStream.computeMessageSize(12, this.getAlipayTrade());
                }

                if (!this.uniqueRecord_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(13, this.getUniqueRecord());
                }

                if (this.unionpayTrade_ != null) {
                    size += CodedOutputStream.computeMessageSize(14, this.getUnionpayTrade());
                }

                if (this.transportpayTrade_ != null) {
                    size += CodedOutputStream.computeMessageSize(15, this.getTransportpayTrade());
                }

                if (this.longitude_ != 0.0D) {
                    size += CodedOutputStream.computeDoubleSize(16, this.longitude_);
                }

                if (this.latitude_ != 0.0D) {
                    size += CodedOutputStream.computeDoubleSize(17, this.latitude_);
                }

                if (!this.driverId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(18, this.getDriverId());
                }

                if (this.attendanceTime_ != 0) {
                    size += CodedOutputStream.computeInt32Size(19, this.attendanceTime_);
                }

                if (!this.companyId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(20, this.getCompanyId());
                }

                if (this.updownFlag_ != 0) {
                    size += CodedOutputStream.computeInt32Size(21, this.updownFlag_);
                }

                if (!this.fleetCode_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(22, this.getFleetCode());
                }

                if (!this.departmentId_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(23, this.getDepartmentId());
                }

                if (this.zjrcTrade_ != null) {
                    size += CodedOutputStream.computeMessageSize(24, this.getZjrcTrade());
                }

                if (this.errorCode_ != 0) {
                    size += CodedOutputStream.computeInt32Size(30, this.errorCode_);
                }

                if (!this.errorMsg_.isEmpty()) {
                    size += CodedOutputStream.computeStringSize(31, this.getErrorMsg());
                }

                size += this.unknownFields.getSerializedSize();
                this.memoizedSerializedSize = size;
                return size;
            }
        }

        public static IBusCloudSDKProto.UploadMessage parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.UploadMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.UploadMessage parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.UploadMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.UploadMessage parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.UploadMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.UploadMessage parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.UploadMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.UploadMessage parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.UploadMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static IBusCloudSDKProto.UploadMessage parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (IBusCloudSDKProto.UploadMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static IBusCloudSDKProto.UploadMessage parseFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.UploadMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.UploadMessage parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.UploadMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.UploadMessage parseDelimitedFrom(InputStream input) throws IOException {
            return (IBusCloudSDKProto.UploadMessage) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.UploadMessage parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.UploadMessage) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.UploadMessage parseFrom(CodedInputStream input) throws IOException {
            return (IBusCloudSDKProto.UploadMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static IBusCloudSDKProto.UploadMessage parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IBusCloudSDKProto.UploadMessage) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static IBusCloudSDKProto.UploadMessage.Builder newBuilder() {
            return (IBusCloudSDKProto.UploadMessage.Builder) DEFAULT_INSTANCE.createBuilder();
        }

        public static IBusCloudSDKProto.UploadMessage.Builder newBuilder(IBusCloudSDKProto.UploadMessage prototype) {
            return (IBusCloudSDKProto.UploadMessage.Builder) DEFAULT_INSTANCE.createBuilder(prototype);
        }

        protected final Object dynamicMethod(MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new IBusCloudSDKProto.UploadMessage();
                case IS_INITIALIZED:
                    return DEFAULT_INSTANCE;
                case MAKE_IMMUTABLE:
                    return null;
                case NEW_BUILDER:
                    return new IBusCloudSDKProto.UploadMessage.Builder();
                case VISIT:
                    Visitor visitor = (Visitor) arg0;
                    IBusCloudSDKProto.UploadMessage other = (IBusCloudSDKProto.UploadMessage) arg1;
                    this.type_ = visitor.visitInt(this.type_ != 0, this.type_, other.type_ != 0, other.type_);
                    this.version_ = visitor.visitInt(this.version_ != 0, this.version_, other.version_ != 0, other.version_);
                    this.posId_ = visitor.visitString(!this.posId_.isEmpty(), this.posId_, !other.posId_.isEmpty(), other.posId_);
                    this.busId_ = visitor.visitString(!this.busId_.isEmpty(), this.busId_, !other.busId_.isEmpty(), other.busId_);
                    this.routeId_ = visitor.visitString(!this.routeId_.isEmpty(), this.routeId_, !other.routeId_.isEmpty(), other.routeId_);
                    this.cityId_ = visitor.visitString(!this.cityId_.isEmpty(), this.cityId_, !other.cityId_.isEmpty(), other.cityId_);
                    this.ticketPrice_ = visitor.visitInt(this.ticketPrice_ != 0, this.ticketPrice_, other.ticketPrice_ != 0, other.ticketPrice_);
                    this.cost_ = visitor.visitInt(this.cost_ != 0, this.cost_, other.cost_ != 0, other.cost_);
                    this.timeStamp_ = visitor.visitInt(this.timeStamp_ != 0, this.timeStamp_, other.timeStamp_ != 0, other.timeStamp_);
                    this.ticketType_ = visitor.visitInt(this.ticketType_ != 0, this.ticketType_, other.ticketType_ != 0, other.ticketType_);
                    this.longitude_ = visitor.visitDouble(this.longitude_ != 0.0D, this.longitude_, other.longitude_ != 0.0D, other.longitude_);
                    this.latitude_ = visitor.visitDouble(this.latitude_ != 0.0D, this.latitude_, other.latitude_ != 0.0D, other.latitude_);
                    this.driverId_ = visitor.visitString(!this.driverId_.isEmpty(), this.driverId_, !other.driverId_.isEmpty(), other.driverId_);
                    this.attendanceTime_ = visitor.visitInt(this.attendanceTime_ != 0, this.attendanceTime_, other.attendanceTime_ != 0, other.attendanceTime_);
                    this.companyId_ = visitor.visitString(!this.companyId_.isEmpty(), this.companyId_, !other.companyId_.isEmpty(), other.companyId_);
                    this.updownFlag_ = visitor.visitInt(this.updownFlag_ != 0, this.updownFlag_, other.updownFlag_ != 0, other.updownFlag_);
                    this.fleetCode_ = visitor.visitString(!this.fleetCode_.isEmpty(), this.fleetCode_, !other.fleetCode_.isEmpty(), other.fleetCode_);
                    this.departmentId_ = visitor.visitString(!this.departmentId_.isEmpty(), this.departmentId_, !other.departmentId_.isEmpty(), other.departmentId_);
                    this.posSerialNo_ = visitor.visitInt(this.posSerialNo_ != 0, this.posSerialNo_, other.posSerialNo_ != 0, other.posSerialNo_);
                    this.alipayTrade_ = (IBusCloudSDKProto.AlipayTradeInfo) visitor.visitMessage(this.alipayTrade_, other.alipayTrade_);
                    this.unionpayTrade_ = (IBusCloudSDKProto.UnionpayTradeInfo) visitor.visitMessage(this.unionpayTrade_, other.unionpayTrade_);
                    this.transportpayTrade_ = (IBusCloudSDKProto.TransportPayTradeInfo) visitor.visitMessage(this.transportpayTrade_, other.transportpayTrade_);
                    this.zjrcTrade_ = (IBusCloudSDKProto.ZjrcScppTradeInfo) visitor.visitMessage(this.zjrcTrade_, other.zjrcTrade_);
                    this.errorCode_ = visitor.visitInt(this.errorCode_ != 0, this.errorCode_, other.errorCode_ != 0, other.errorCode_);
                    this.errorMsg_ = visitor.visitString(!this.errorMsg_.isEmpty(), this.errorMsg_, !other.errorMsg_.isEmpty(), other.errorMsg_);
                    this.uniqueRecord_ = visitor.visitString(!this.uniqueRecord_.isEmpty(), this.uniqueRecord_, !other.uniqueRecord_.isEmpty(), other.uniqueRecord_);
                    if (visitor == MergeFromVisitor.INSTANCE) {
                        ;
                    }

                    return this;
                case MERGE_FROM_STREAM:
                    CodedInputStream input = (CodedInputStream) arg0;
                    ExtensionRegistryLite extensionRegistry = (ExtensionRegistryLite) arg1;
                    if (extensionRegistry == null) {
                        throw new NullPointerException();
                    } else {
                        try {
                            boolean done = false;

                            while (!done) {
                                int tag = input.readTag();
                                String s;
                                switch (tag) {
                                    case 0:
                                        done = true;
                                        break;
                                    case 8:
                                        int rawValue = input.readEnum();
                                        this.type_ = rawValue;
                                        break;
                                    case 16:
                                        this.version_ = input.readInt32();
                                        break;
                                    case 26:
                                        s = input.readStringRequireUtf8();
                                        this.posId_ = s;
                                        break;
                                    case 34:
                                        s = input.readStringRequireUtf8();
                                        this.busId_ = s;
                                        break;
                                    case 42:
                                        s = input.readStringRequireUtf8();
                                        this.routeId_ = s;
                                        break;
                                    case 50:
                                        s = input.readStringRequireUtf8();
                                        this.cityId_ = s;
                                        break;
                                    case 56:
                                        this.ticketPrice_ = input.readInt32();
                                        break;
                                    case 64:
                                        this.cost_ = input.readInt32();
                                        break;
                                    case 72:
                                        this.timeStamp_ = input.readInt32();
                                        break;
                                    case 80:
                                        this.ticketType_ = input.readInt32();
                                        break;
                                    case 88:
                                        this.posSerialNo_ = input.readInt32();
                                        break;
                                    case 98:
                                        IBusCloudSDKProto.AlipayTradeInfo.Builder subBuilder = null;
                                        if (this.alipayTrade_ != null) {
                                            subBuilder = (IBusCloudSDKProto.AlipayTradeInfo.Builder) this.alipayTrade_.toBuilder();
                                        }

                                        this.alipayTrade_ = (IBusCloudSDKProto.AlipayTradeInfo) input.readMessage(IBusCloudSDKProto.AlipayTradeInfo.parser(), extensionRegistry);
                                        if (subBuilder != null) {
                                            subBuilder.mergeFrom(this.alipayTrade_);
                                            this.alipayTrade_ = (IBusCloudSDKProto.AlipayTradeInfo) subBuilder.buildPartial();
                                        }
                                        break;
                                    case 106:
                                        s = input.readStringRequireUtf8();
                                        this.uniqueRecord_ = s;
                                        break;
                                    case 114:
                                        IBusCloudSDKProto.UnionpayTradeInfo.Builder subBuilder1 = null;
                                        if (this.unionpayTrade_ != null) {
                                            subBuilder1 = (IBusCloudSDKProto.UnionpayTradeInfo.Builder) this.unionpayTrade_.toBuilder();
                                        }

                                        this.unionpayTrade_ = (IBusCloudSDKProto.UnionpayTradeInfo) input.readMessage(IBusCloudSDKProto.UnionpayTradeInfo.parser(), extensionRegistry);
                                        if (subBuilder1 != null) {
                                            subBuilder1.mergeFrom(this.unionpayTrade_);
                                            this.unionpayTrade_ = (IBusCloudSDKProto.UnionpayTradeInfo) subBuilder1.buildPartial();
                                        }
                                        break;
                                    case 122:
                                        IBusCloudSDKProto.TransportPayTradeInfo.Builder subBuilder2 = null;
                                        if (this.transportpayTrade_ != null) {
                                            subBuilder2 = (IBusCloudSDKProto.TransportPayTradeInfo.Builder) this.transportpayTrade_.toBuilder();
                                        }

                                        this.transportpayTrade_ = (IBusCloudSDKProto.TransportPayTradeInfo) input.readMessage(IBusCloudSDKProto.TransportPayTradeInfo.parser(), extensionRegistry);
                                        if (subBuilder2 != null) {
                                            subBuilder2.mergeFrom(this.transportpayTrade_);
                                            this.transportpayTrade_ = (IBusCloudSDKProto.TransportPayTradeInfo) subBuilder2.buildPartial();
                                        }
                                        break;
                                    case 129:
                                        this.longitude_ = input.readDouble();
                                        break;
                                    case 137:
                                        this.latitude_ = input.readDouble();
                                        break;
                                    case 146:
                                        s = input.readStringRequireUtf8();
                                        this.driverId_ = s;
                                        break;
                                    case 152:
                                        this.attendanceTime_ = input.readInt32();
                                        break;
                                    case 162:
                                        s = input.readStringRequireUtf8();
                                        this.companyId_ = s;
                                        break;
                                    case 168:
                                        this.updownFlag_ = input.readInt32();
                                        break;
                                    case 178:
                                        s = input.readStringRequireUtf8();
                                        this.fleetCode_ = s;
                                        break;
                                    case 186:
                                        s = input.readStringRequireUtf8();
                                        this.departmentId_ = s;
                                        break;
                                    case 194:
                                        IBusCloudSDKProto.ZjrcScppTradeInfo.Builder subBuilder3 = null;
                                        if (this.zjrcTrade_ != null) {
                                            subBuilder3 = (IBusCloudSDKProto.ZjrcScppTradeInfo.Builder) this.zjrcTrade_.toBuilder();
                                        }

                                        this.zjrcTrade_ = (IBusCloudSDKProto.ZjrcScppTradeInfo) input.readMessage(IBusCloudSDKProto.ZjrcScppTradeInfo.parser(), extensionRegistry);
                                        if (subBuilder3 != null) {
                                            subBuilder3.mergeFrom(this.zjrcTrade_);
                                            this.zjrcTrade_ = (IBusCloudSDKProto.ZjrcScppTradeInfo) subBuilder3.buildPartial();
                                        }
                                        break;
                                    case 240:
                                        this.errorCode_ = input.readInt32();
                                        break;
                                    case 250:
                                        s = input.readStringRequireUtf8();
                                        this.errorMsg_ = s;
                                        break;
                                    default:
                                        if (!this.parseUnknownField(tag, input)) {
                                            done = true;
                                        }
                                }
                            }
                        } catch (InvalidProtocolBufferException var16) {
                            throw new RuntimeException(var16.setUnfinishedMessage(this));
                        } catch (IOException var17) {
                            throw new RuntimeException((new InvalidProtocolBufferException(var17.getMessage())).setUnfinishedMessage(this));
                        } finally {
                            ;
                        }
                    }
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    if (PARSER == null) {
                        Class var4 = IBusCloudSDKProto.UploadMessage.class;
                        synchronized (IBusCloudSDKProto.UploadMessage.class) {
                            if (PARSER == null) {
                                PARSER = new DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                            }
                        }
                    }

                    return PARSER;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static IBusCloudSDKProto.UploadMessage getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UploadMessage> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        static {
            DEFAULT_INSTANCE.makeImmutable();
        }

        public static final class Builder extends GeneratedMessageLite.Builder<UploadMessage, Builder> implements IBusCloudSDKProto.UploadMessageOrBuilder {
            private Builder() {
                super(IBusCloudSDKProto.UploadMessage.DEFAULT_INSTANCE);
            }

            public int getTypeValue() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getTypeValue();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setTypeValue(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setTypeValue(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.MessageType getType() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getType();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setType(IBusCloudSDKProto.UploadMessage.MessageType value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setType(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearType() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearType();
                return this;
            }

            public int getVersion() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getVersion();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setVersion(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setVersion(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearVersion() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearVersion();
                return this;
            }

            public String getPosId() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getPosId();
            }

            public ByteString getPosIdBytes() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getPosIdBytes();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setPosId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setPosId(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearPosId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearPosId();
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder setPosIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setPosIdBytes(value);
                return this;
            }

            public String getBusId() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getBusId();
            }

            public ByteString getBusIdBytes() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getBusIdBytes();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setBusId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setBusId(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearBusId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearBusId();
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder setBusIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setBusIdBytes(value);
                return this;
            }

            public String getRouteId() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getRouteId();
            }

            public ByteString getRouteIdBytes() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getRouteIdBytes();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setRouteId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setRouteId(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearRouteId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearRouteId();
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder setRouteIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setRouteIdBytes(value);
                return this;
            }

            public String getCityId() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getCityId();
            }

            public ByteString getCityIdBytes() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getCityIdBytes();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setCityId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setCityId(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearCityId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearCityId();
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder setCityIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setCityIdBytes(value);
                return this;
            }

            public int getTicketPrice() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getTicketPrice();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setTicketPrice(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setTicketPrice(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearTicketPrice() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearTicketPrice();
                return this;
            }

            public int getCost() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getCost();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setCost(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setCost(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearCost() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearCost();
                return this;
            }

            public int getTimeStamp() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getTimeStamp();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setTimeStamp(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setTimeStamp(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearTimeStamp() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearTimeStamp();
                return this;
            }

            public int getTicketType() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getTicketType();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setTicketType(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setTicketType(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearTicketType() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearTicketType();
                return this;
            }

            public double getLongitude() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getLongitude();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setLongitude(double value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setLongitude(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearLongitude() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearLongitude();
                return this;
            }

            public double getLatitude() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getLatitude();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setLatitude(double value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setLatitude(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearLatitude() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearLatitude();
                return this;
            }

            public String getDriverId() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getDriverId();
            }

            public ByteString getDriverIdBytes() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getDriverIdBytes();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setDriverId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setDriverId(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearDriverId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearDriverId();
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder setDriverIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setDriverIdBytes(value);
                return this;
            }

            public int getAttendanceTime() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getAttendanceTime();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setAttendanceTime(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setAttendanceTime(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearAttendanceTime() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearAttendanceTime();
                return this;
            }

            public String getCompanyId() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getCompanyId();
            }

            public ByteString getCompanyIdBytes() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getCompanyIdBytes();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setCompanyId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setCompanyId(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearCompanyId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearCompanyId();
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder setCompanyIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setCompanyIdBytes(value);
                return this;
            }

            public int getUpdownFlag() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getUpdownFlag();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setUpdownFlag(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setUpdownFlag(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearUpdownFlag() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearUpdownFlag();
                return this;
            }

            public String getFleetCode() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getFleetCode();
            }

            public ByteString getFleetCodeBytes() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getFleetCodeBytes();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setFleetCode(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setFleetCode(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearFleetCode() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearFleetCode();
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder setFleetCodeBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setFleetCodeBytes(value);
                return this;
            }

            public String getDepartmentId() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getDepartmentId();
            }

            public ByteString getDepartmentIdBytes() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getDepartmentIdBytes();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setDepartmentId(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setDepartmentId(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearDepartmentId() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearDepartmentId();
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder setDepartmentIdBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setDepartmentIdBytes(value);
                return this;
            }

            public int getPosSerialNo() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getPosSerialNo();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setPosSerialNo(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setPosSerialNo(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearPosSerialNo() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearPosSerialNo();
                return this;
            }

            public boolean hasAlipayTrade() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).hasAlipayTrade();
            }

            public IBusCloudSDKProto.AlipayTradeInfo getAlipayTrade() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getAlipayTrade();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setAlipayTrade(IBusCloudSDKProto.AlipayTradeInfo value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setAlipayTrade(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder setAlipayTrade(IBusCloudSDKProto.AlipayTradeInfo.Builder builderForValue) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setAlipayTrade(builderForValue);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder mergeAlipayTrade(IBusCloudSDKProto.AlipayTradeInfo value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).mergeAlipayTrade(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearAlipayTrade() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearAlipayTrade();
                return this;
            }

            public boolean hasUnionpayTrade() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).hasUnionpayTrade();
            }

            public IBusCloudSDKProto.UnionpayTradeInfo getUnionpayTrade() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getUnionpayTrade();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setUnionpayTrade(IBusCloudSDKProto.UnionpayTradeInfo value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setUnionpayTrade(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder setUnionpayTrade(IBusCloudSDKProto.UnionpayTradeInfo.Builder builderForValue) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setUnionpayTrade(builderForValue);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder mergeUnionpayTrade(IBusCloudSDKProto.UnionpayTradeInfo value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).mergeUnionpayTrade(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearUnionpayTrade() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearUnionpayTrade();
                return this;
            }

            public boolean hasTransportpayTrade() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).hasTransportpayTrade();
            }

            public IBusCloudSDKProto.TransportPayTradeInfo getTransportpayTrade() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getTransportpayTrade();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setTransportpayTrade(IBusCloudSDKProto.TransportPayTradeInfo value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setTransportpayTrade(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder setTransportpayTrade(IBusCloudSDKProto.TransportPayTradeInfo.Builder builderForValue) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setTransportpayTrade(builderForValue);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder mergeTransportpayTrade(IBusCloudSDKProto.TransportPayTradeInfo value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).mergeTransportpayTrade(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearTransportpayTrade() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearTransportpayTrade();
                return this;
            }

            public boolean hasZjrcTrade() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).hasZjrcTrade();
            }

            public IBusCloudSDKProto.ZjrcScppTradeInfo getZjrcTrade() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getZjrcTrade();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setZjrcTrade(IBusCloudSDKProto.ZjrcScppTradeInfo value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setZjrcTrade(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder setZjrcTrade(IBusCloudSDKProto.ZjrcScppTradeInfo.Builder builderForValue) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setZjrcTrade(builderForValue);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder mergeZjrcTrade(IBusCloudSDKProto.ZjrcScppTradeInfo value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).mergeZjrcTrade(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearZjrcTrade() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearZjrcTrade();
                return this;
            }

            public int getErrorCode() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getErrorCode();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setErrorCode(int value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setErrorCode(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearErrorCode() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearErrorCode();
                return this;
            }

            public String getErrorMsg() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getErrorMsg();
            }

            public ByteString getErrorMsgBytes() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getErrorMsgBytes();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setErrorMsg(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setErrorMsg(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearErrorMsg() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearErrorMsg();
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder setErrorMsgBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setErrorMsgBytes(value);
                return this;
            }

            public String getUniqueRecord() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getUniqueRecord();
            }

            public ByteString getUniqueRecordBytes() {
                return ((IBusCloudSDKProto.UploadMessage) this.instance).getUniqueRecordBytes();
            }

            public IBusCloudSDKProto.UploadMessage.Builder setUniqueRecord(String value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setUniqueRecord(value);
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder clearUniqueRecord() {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).clearUniqueRecord();
                return this;
            }

            public IBusCloudSDKProto.UploadMessage.Builder setUniqueRecordBytes(ByteString value) {
                this.copyOnWrite();
                ((IBusCloudSDKProto.UploadMessage) this.instance).setUniqueRecordBytes(value);
                return this;
            }
        }

        public static enum MessageType implements EnumLite {
            ALIPAY(0),
            CUSTOMIZED_BUS(1),
            UNIONPAY(2),
            TRANSPORTPAY(5),
            ZJRC_SCPP(6),
            ERROR_MESSAGE(999),
            UNRECOGNIZED(-1);

            public static final int ALIPAY_VALUE = 0;
            public static final int CUSTOMIZED_BUS_VALUE = 1;
            public static final int UNIONPAY_VALUE = 2;
            public static final int TRANSPORTPAY_VALUE = 5;
            public static final int ZJRC_SCPP_VALUE = 6;
            public static final int ERROR_MESSAGE_VALUE = 999;
            private static final EnumLiteMap<MessageType> internalValueMap = new EnumLiteMap<MessageType>() {
                public IBusCloudSDKProto.UploadMessage.MessageType findValueByNumber(int number) {
                    return IBusCloudSDKProto.UploadMessage.MessageType.forNumber(number);
                }
            };
            private final int value;

            public final int getNumber() {
                if (this == UNRECOGNIZED) {
                    throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
                } else {
                    return this.value;
                }
            }

            /**
             * @deprecated
             */
            @Deprecated
            public static IBusCloudSDKProto.UploadMessage.MessageType valueOf(int value) {
                return forNumber(value);
            }

            public static IBusCloudSDKProto.UploadMessage.MessageType forNumber(int value) {
                switch (value) {
                    case 0:
                        return ALIPAY;
                    case 1:
                        return CUSTOMIZED_BUS;
                    case 2:
                        return UNIONPAY;
                    case 5:
                        return TRANSPORTPAY;
                    case 6:
                        return ZJRC_SCPP;
                    case 999:
                        return ERROR_MESSAGE;
                    default:
                        return null;
                }
            }

            public static EnumLiteMap<MessageType> internalGetValueMap() {
                return internalValueMap;
            }

            private MessageType(int value) {
                this.value = value;
            }
        }
    }

    public interface UploadMessageOrBuilder extends MessageLiteOrBuilder {
        int getTypeValue();

        IBusCloudSDKProto.UploadMessage.MessageType getType();

        int getVersion();

        String getPosId();

        ByteString getPosIdBytes();

        String getBusId();

        ByteString getBusIdBytes();

        String getRouteId();

        ByteString getRouteIdBytes();

        String getCityId();

        ByteString getCityIdBytes();

        int getTicketPrice();

        int getCost();

        int getTimeStamp();

        int getTicketType();

        double getLongitude();

        double getLatitude();

        String getDriverId();

        ByteString getDriverIdBytes();

        int getAttendanceTime();

        String getCompanyId();

        ByteString getCompanyIdBytes();

        int getUpdownFlag();

        String getFleetCode();

        ByteString getFleetCodeBytes();

        String getDepartmentId();

        ByteString getDepartmentIdBytes();

        int getPosSerialNo();

        boolean hasAlipayTrade();

        IBusCloudSDKProto.AlipayTradeInfo getAlipayTrade();

        boolean hasUnionpayTrade();

        IBusCloudSDKProto.UnionpayTradeInfo getUnionpayTrade();

        boolean hasTransportpayTrade();

        IBusCloudSDKProto.TransportPayTradeInfo getTransportpayTrade();

        boolean hasZjrcTrade();

        IBusCloudSDKProto.ZjrcScppTradeInfo getZjrcTrade();

        int getErrorCode();

        String getErrorMsg();

        ByteString getErrorMsgBytes();

        String getUniqueRecord();

        ByteString getUniqueRecordBytes();
    }

}
