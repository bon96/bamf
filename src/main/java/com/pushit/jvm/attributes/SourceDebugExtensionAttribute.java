package com.pushit.jvm.attributes;

import com.pushit.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.11
 */

public class SourceDebugExtensionAttribute extends Attribute {

    private String debugInfo;

    public SourceDebugExtensionAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);

        char[] chars = new char[getLength()];

        for (int i = 0; i < getLength(); i++) {
            byte b = byteBuffer.get();

            if ((b & 0x80) == 0) {
                chars[i] = (char) (b & 0x7F);
            } else if ((b & 0xE0) == 0xC0) {
                chars[i] = (char) (((b & 0x1F) << 6) + (byteBuffer.get() & 0x3F));
            } else {
                chars[i] = (char) (((b & 0xF) << 12) + ((byteBuffer.get() & 0x3F) << 6) + (byteBuffer.get() & 0x3F));
            }
        }
        this.debugInfo = new String(chars, 0, chars.length);
    }

    public String getDebugInfo() {
        return debugInfo;
    }
}
