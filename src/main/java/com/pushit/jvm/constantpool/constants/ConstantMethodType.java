package com.pushit.jvm.constantpool.constants;

import com.pushit.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.9
 */

public class ConstantMethodType extends Constant {

    private ConstPool constPool;
    private int descriptorIndex;

    public ConstantMethodType(ByteBuffer byteBuffer, ConstPool constPool) {
        this.constPool = constPool;
        this.descriptorIndex = byteBuffer.getShort();
    }

    public String getDescriptor() {
        return constPool.get(descriptorIndex).toString();
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }
}
