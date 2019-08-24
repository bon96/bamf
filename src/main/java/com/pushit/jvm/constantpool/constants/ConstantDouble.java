package com.pushit.jvm.constantpool.constants;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.5
 */


public class ConstantDouble extends Constant {

    private double value;

    public ConstantDouble(ByteBuffer byteBuffer) {
        this.value = byteBuffer.getDouble();
    }

    public double getValue() {
        return value;
    }
}
