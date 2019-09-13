package org.bon.jvm.constantpool.constants;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.5
 */

public class LongConstant extends Constant {

    private long value;

    public LongConstant(ByteBuffer byteBuffer) {
        value = byteBuffer.getLong();
    }

    public long getValue() {
        return value;
    }
}
