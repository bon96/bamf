package com.pushit.jvm.constantpool.constants;

import com.pushit.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.10
 */

public class ConstantInvokeDynamic extends Constant {
    private ConstPool constPool;
    private int bootstrapMethodAttrIndex;
    private int nameAndTypeIndex;

    public ConstantInvokeDynamic(ByteBuffer byteBuffer, ConstPool constPool) {
        this.constPool = constPool;
        this.bootstrapMethodAttrIndex = byteBuffer.getShort();
        this.nameAndTypeIndex = byteBuffer.getShort();
    }

    //TODO finish bootstrapMethod array retrieval from constant pool

    public ConstantNameAndType getNameAndType() {
        return constPool.get(nameAndTypeIndex).cast();
    }

    public int getBootstrapMethodAttrIndex() {
        return bootstrapMethodAttrIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }
}
