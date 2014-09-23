package com.timmciver.bytebuffer;

import java.io.IOException;
import java.io.InputStream;

/**
 * A ByteBuffer backed by an InputStream.  It is assumed that the data beings at the
 * current read position of this InputStream.
 */
public class InputStreamBackedByteBuffer extends ByteBuffer {
	
	private InputStream stream;

	/**
	 * @param stream the InputStream to serve as this ByteBuffer's data source
	 * @param length
	 */
	public InputStreamBackedByteBuffer(InputStream stream, int length) {
		super(length);
		this.stream = stream;
	}

	public void fill(byte[] buf, int bufOffset, int srcOffset, int length) throws IOException {
		
		// reset the InputStream
		stream.reset();

		// move ahead by srcOffset bytes
		stream.skip(srcOffset);
		
		// read the stream data into the buffer
		stream.read(buf, bufOffset, length);
	}
}
