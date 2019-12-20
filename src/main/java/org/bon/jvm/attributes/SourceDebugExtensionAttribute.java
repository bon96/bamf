package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.11
 */

public class SourceDebugExtensionAttribute extends Attribute {

    private String debugInfo;

    public SourceDebugExtensionAttribute(String debugInfo) {
        this.debugInfo = debugInfo;
    }

    public String getDebugInfo() {
        return debugInfo;
    }

    public void setDebugInfo(String debugInfo) {
        this.debugInfo = debugInfo;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static SourceDebugExtensionAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        char[] chars = new char[length];

        for (int i = 0; i < length; i++) {
            int b = in.readUnsignedByte();

            if ((b & 0x80) == 0) {
                chars[i] = (char) (b & 0x7F);
            } else if ((b & 0xE0) == 0xC0) {
                chars[i] = (char) (((b & 0x1F) << 6) + (in.readUnsignedByte() & 0x3F));
            } else {
                chars[i] = (char) (((b & 0xF) << 12) + ((in.readUnsignedByte() & 0x3F) << 6) + (in.readUnsignedByte() & 0x3F));
            }
        }

        return new SourceDebugExtensionAttribute(new String(chars, 0, chars.length));
    }
}
