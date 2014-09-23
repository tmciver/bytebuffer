package com.timmciver.bytebuffer;

public final class ArrayBackedByteBuffer extends ByteBuffer {
	
	private byte[] data;

	public ArrayBackedByteBuffer(byte[] data) {
		super(data.length);
		this.data = data;
	}

	@Override
	public byte[] array() {
		return data;
	}

	@Override
	protected void fill(byte[] buf, int bufOffset, int srcOffset, int size) {
		System.arraycopy(data, srcOffset, buf, bufOffset, size);
	}
}
