package com.timmciver.bytebuffer;

import java.io.IOException;

public class ByteBufferSum extends ByteBuffer {
	
	private ByteBuffer buf1;
	private ByteBuffer buf2;

	public ByteBufferSum(ByteBuffer byteBuffer1, ByteBuffer byteBuffer2) {
		super(byteBuffer1.size() + byteBuffer2.size());
		this.buf1 = byteBuffer1;
		this.buf2 = byteBuffer2;
	}

	@Override
	protected void fill(byte[] buf, int bufOffset, int srcOffset, int length) throws IOException {
		buf1.fill(buf, bufOffset, 0, buf1.size());
		buf2.fill(buf, bufOffset + buf1.size(), 0, buf2.size());
	}

}
