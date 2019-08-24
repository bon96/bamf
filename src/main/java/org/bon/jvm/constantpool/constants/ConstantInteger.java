package org.bon.jvm.constantpool.constants;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.4
 */

public class ConstantInteger extends Constant {

    private int value;

    public ConstantInteger(ByteBuffer byteBuffer) {
        this.value = byteBuffer.getInt();
    }

    public int getValue() {
        return value;
    }
}
