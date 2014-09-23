package com.timmciver.bytebuffer;

import java.io.IOException;

public class ByteBufferSlice extends ByteBuffer {
	
	private ByteBuffer buffer;
	private int offset;

	/**
	 * Creates a view into the given ByteBuffer beginning at offset and with size size.
	 * @param byteBuffer
	 * @param offset
	 * @param size
	 */
	public ByteBufferSlice(ByteBuffer byteBuffer, int offset, int size) {
		super(size);
		this.offset = offset;
		this.buffer = byteBuffer;
	}
	
	/**
	 * Creates a view into the given ByteBuffer beginning at offset and extending
	 * to the end of the given ByteBuffer.
	 * @param byteBuffer
	 * @param offset
	 */
	public ByteBufferSlice(ByteBuffer byteBuffer, int offset) {
		this(byteBuffer, offset, byteBuffer.size() - offset);
	}

	@Override
	protected void fill(byte[] buf, int bufOffset, int srcOffset, int length) throws IOException {
		
		if (length > size()) {
			throw new IllegalArgumentException("Attempting to fill data array with more data than this ByteBuffer holds.");
		}
		
		buffer.fill(buf, bufOffset, srcOffset + offset, length);
	}

}
