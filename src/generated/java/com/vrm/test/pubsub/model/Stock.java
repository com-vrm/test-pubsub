/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.vrm.test.pubsub.model;

import org.apache.avro.io.Encoder;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

import java.io.IOException;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Stock extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -5875751858458304206L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Stock\",\"namespace\":\"com.vrm.test.pubsub.model\",\"fields\":[{\"name\":\"symbol\",\"type\":\"string\"},{\"name\":\"price\",\"type\":\"double\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Stock> ENCODER =
      new BinaryMessageEncoder<Stock>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Stock> DECODER =
      new BinaryMessageDecoder<Stock>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Stock> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Stock> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Stock>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Stock to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Stock from a ByteBuffer. */
  public static Stock fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence symbol;
  @Deprecated public double price;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Stock() {}

  /**
   * All-args constructor.
   * @param symbol The new value for symbol
   * @param price The new value for price
   */
  public Stock(java.lang.CharSequence symbol, java.lang.Double price) {
    this.symbol = symbol;
    this.price = price;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return symbol;
    case 1: return price;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: symbol = (java.lang.CharSequence)value$; break;
    case 1: price = (java.lang.Double)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'symbol' field.
   * @return The value of the 'symbol' field.
   */
  public java.lang.CharSequence getSymbol() {
    return symbol;
  }

  /**
   * Sets the value of the 'symbol' field.
   * @param value the value to set.
   */
  public void setSymbol(java.lang.CharSequence value) {
    this.symbol = value;
  }

  /**
   * Gets the value of the 'price' field.
   * @return The value of the 'price' field.
   */
  public java.lang.Double getPrice() {
    return price;
  }

  /**
   * Sets the value of the 'price' field.
   * @param value the value to set.
   */
  public void setPrice(java.lang.Double value) {
    this.price = value;
  }

  /**
   * Creates a new Stock RecordBuilder.
   * @return A new Stock RecordBuilder
   */
  public static com.vrm.test.pubsub.model.Stock.Builder newBuilder() {
    return new com.vrm.test.pubsub.model.Stock.Builder();
  }

  /**
   * Creates a new Stock RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Stock RecordBuilder
   */
  public static com.vrm.test.pubsub.model.Stock.Builder newBuilder(com.vrm.test.pubsub.model.Stock.Builder other) {
    return new com.vrm.test.pubsub.model.Stock.Builder(other);
  }

  /**
   * Creates a new Stock RecordBuilder by copying an existing Stock instance.
   * @param other The existing instance to copy.
   * @return A new Stock RecordBuilder
   */
  public static com.vrm.test.pubsub.model.Stock.Builder newBuilder(com.vrm.test.pubsub.model.Stock other) {
    return new com.vrm.test.pubsub.model.Stock.Builder(other);
  }

  /**
   * RecordBuilder for Stock instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Stock>
    implements org.apache.avro.data.RecordBuilder<Stock> {

    private java.lang.CharSequence symbol;
    private double price;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.vrm.test.pubsub.model.Stock.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.symbol)) {
        this.symbol = data().deepCopy(fields()[0].schema(), other.symbol);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.price)) {
        this.price = data().deepCopy(fields()[1].schema(), other.price);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Stock instance
     * @param other The existing instance to copy.
     */
    private Builder(com.vrm.test.pubsub.model.Stock other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.symbol)) {
        this.symbol = data().deepCopy(fields()[0].schema(), other.symbol);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.price)) {
        this.price = data().deepCopy(fields()[1].schema(), other.price);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'symbol' field.
      * @return The value.
      */
    public java.lang.CharSequence getSymbol() {
      return symbol;
    }

    /**
      * Sets the value of the 'symbol' field.
      * @param value The value of 'symbol'.
      * @return This builder.
      */
    public com.vrm.test.pubsub.model.Stock.Builder setSymbol(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.symbol = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'symbol' field has been set.
      * @return True if the 'symbol' field has been set, false otherwise.
      */
    public boolean hasSymbol() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'symbol' field.
      * @return This builder.
      */
    public com.vrm.test.pubsub.model.Stock.Builder clearSymbol() {
      symbol = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'price' field.
      * @return The value.
      */
    public java.lang.Double getPrice() {
      return price;
    }

    /**
      * Sets the value of the 'price' field.
      * @param value The value of 'price'.
      * @return This builder.
      */
    public com.vrm.test.pubsub.model.Stock.Builder setPrice(double value) {
      validate(fields()[1], value);
      this.price = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'price' field has been set.
      * @return True if the 'price' field has been set, false otherwise.
      */
    public boolean hasPrice() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'price' field.
      * @return This builder.
      */
    public com.vrm.test.pubsub.model.Stock.Builder clearPrice() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Stock build() {
      try {
        Stock record = new Stock();
        record.symbol = fieldSetFlags()[0] ? this.symbol : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.price = fieldSetFlags()[1] ? this.price : (java.lang.Double) defaultValue(fields()[1]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Stock>
    WRITER$ = (org.apache.avro.io.DatumWriter<Stock>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Stock>
    READER$ = (org.apache.avro.io.DatumReader<Stock>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override
  public void customEncode(Encoder out) throws IOException {
    out.writeString(getSymbol());
    out.writeDouble(getPrice());
  }
}
