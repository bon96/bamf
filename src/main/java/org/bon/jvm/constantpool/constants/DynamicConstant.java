package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.10
 */

public class DynamicConstant extends Constant {

    private ConstPool constPool;
    private int bootstrapMethodAttrIndex;
    private int nameAndTypeIndex;

    public DynamicConstant(ByteBuffer byteBuffer, ConstPool constPool) {
        this.constPool = constPool;
        bootstrapMethodAttrIndex = byteBuffer.getShort();
        nameAndTypeIndex = byteBuffer.getShort();
    }

    //TODO finish bootstrapMethod array retrieval from constant pool

    public NameAndTypeConstant getNameAndType() {
        return constPool.get(nameAndTypeIndex).cast();
    }

    public int getBootstrapMethodAttrIndex() {
        return bootstrapMethodAttrIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }
}
