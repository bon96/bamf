package org.bon.jvm.constantpool.constants;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.4
 */

public class IntegerConstant extends Constant {

    private int value;

    public IntegerConstant(ByteBuffer byteBuffer) {
        value = byteBuffer.getInt();
    }

    public int getValue() {
        return value;
    }
}
