package com.timmciver.bytebuffer;

import java.io.IOException;

public abstract class ByteBuffer {
	
	private int size;
	
	/**
	 * @param size
	 */
	public ByteBuffer(int size) {
		this.size = size;
	}

	/**
	 * Default implementation simply calls fill method to copy all data into an
	 * allocated array. Override in subclasses for different behavior.
	 * @return a byte array for the data represented by this ByteBuffer
	 */
	public byte[] array() throws IOException {
		byte[] data = new byte[size()];
		fill(data, 0, 0, data.length);
		return data;
	}
	
	/**
	 * @return the number of bytes in this ByteBuffer
	 */
	public final int size() {
		return size;
	}
	
	/**
	 * Copies some or all of this ByteBuffer's data into byte array buf.  This method can,
	 * of course, be called directly by client code but it exists primarily for efficient
	 * reading of a ByteBuffer's data. Clients should prefer to use the array() method.
	 * @param buf the byte array to which data will be written
	 * @param bufOffset the start offset where data will be written
	 * @param srcOffset the start offset of this ByteBuffer's data that will be written.
	 * This value should be zero to write this ByteBuffer's data from the beginning.
	 * @param length the number of bytes to be written.
	 */
	protected abstract void fill(byte[] buf, int bufOffset, int srcOffset, int length) throws IOException;
}
