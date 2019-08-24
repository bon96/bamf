package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.1
 */

public class ConstantClass extends Constant {

    private ConstPool constPool;
    private int nameIndex;


    public ConstantClass(ByteBuffer byteBuffer, ConstPool constPool) {
        this.constPool = constPool;
        nameIndex = byteBuffer.getShort();
    }

    public String getName() {
        return constPool.get(nameIndex).toString();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
