package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.2
 */

public class ConstantMethodRef extends Constant {

    private ConstPool constPool;
    private int classIndex;
    private int nameAndTypeIndex;

    public ConstantMethodRef(ByteBuffer byteBuffer, ConstPool constPool) {
        this.constPool = constPool;
        this.classIndex = byteBuffer.getShort();
        this.nameAndTypeIndex = byteBuffer.getShort();
    }

    public ConstantClass getConstClass() {
        return constPool.get(classIndex).cast();
    }

    public ConstantNameAndType getNameAndType() {
        return constPool.get(nameAndTypeIndex).cast();
    }

    public int getClassIndex() {
        return classIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }
}
