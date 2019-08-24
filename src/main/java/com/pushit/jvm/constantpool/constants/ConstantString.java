package com.pushit.jvm.constantpool.constants;

import com.pushit.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.3
 */

public class ConstantString extends Constant {

    private ConstPool constPool;
    private int stringIndex;

    public ConstantString(ByteBuffer byteBuffer, ConstPool constPool) {
        this.constPool = constPool;
        this.stringIndex = byteBuffer.getShort();
    }

    @Override
    public String toString() {
        return constPool.get(stringIndex).toString();
    }

    public int getStringIndex() {
        return stringIndex;
    }
}
