package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.6
 */

public class NameAndTypeConstant extends Constant {

    private ConstPool constPool;
    private int nameIndex;
    private int descriptorIndex;

    public NameAndTypeConstant(ByteBuffer byteBuffer, ConstPool constPool) {
        this.constPool = constPool;
        nameIndex = byteBuffer.getShort();
        descriptorIndex = byteBuffer.getShort();
    }

    public String getName() {
        return constPool.get(nameIndex).toString();
    }

    public String getDescriptor() {
        return constPool.get(descriptorIndex).toString();
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }
}