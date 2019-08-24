package org.bon.jvm.constantpool.constants;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.4
 */

public class ConstantFloat extends Constant {

    private float value;

    public ConstantFloat(ByteBuffer byteBuffer) {
        value = byteBuffer.getFloat();
    }

    public float getValue() {
        return value;
    }
}
