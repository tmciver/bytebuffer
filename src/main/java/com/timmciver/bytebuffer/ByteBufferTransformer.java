package com.timmciver.bytebuffer;

import java.io.IOException;


public interface ByteBufferTransformer {
	ByteBuffer transform(ByteBuffer byteBuffer) throws IOException;
}
