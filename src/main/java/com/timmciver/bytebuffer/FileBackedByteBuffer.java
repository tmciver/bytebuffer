package com.timmciver.bytebuffer;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileBackedByteBuffer extends ByteBuffer {
	
	private File file;
	private int offset;

	/**
	 * @param file
	 * @param offset
	 * @param length
	 */
	public FileBackedByteBuffer(File file, int offset, int length) {
		super(length);
		this.file = file;
		this.offset = offset;
	}

	@Override
	protected void fill(byte[] buf, int bufOffset, int srcOffset, int length) throws IOException {
		
		RandomAccessFile in = null;
		try {
			in = new RandomAccessFile(file, "r");
			in.seek(offset + srcOffset);
			in.read(buf, bufOffset, length);
		} finally {
			in.close();
		}
	}
}
