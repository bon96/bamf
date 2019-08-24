package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.9
 */

public class ConstantMethodType extends Constant {

    private ConstPool constPool;
    private int descriptorIndex;

    public ConstantMethodType(ByteBuffer byteBuffer, ConstPool constPool) {
        this.constPool = constPool;
        descriptorIndex = byteBuffer.getShort();
    }

    public String getDescriptor() {
        return constPool.get(descriptorIndex).toString();
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }
}
