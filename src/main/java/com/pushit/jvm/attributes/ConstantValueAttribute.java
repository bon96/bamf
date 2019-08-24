package com.pushit.jvm.attributes;

import com.pushit.jvm.constantpool.ConstPool;
import com.pushit.jvm.constantpool.constants.Constant;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.2
 */

public class ConstantValueAttribute extends Attribute {

    private int constantValueIndex;

    public ConstantValueAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);
        this.constantValueIndex = byteBuffer.getShort();
    }

    public Constant getConst() {
        return constPool.get(constantValueIndex);
    }

    public int getConstantValueIndex() {
        return constantValueIndex;
    }
}
