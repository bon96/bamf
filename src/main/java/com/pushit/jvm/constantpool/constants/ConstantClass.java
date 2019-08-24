package com.pushit.jvm.constantpool.constants;

import com.pushit.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.1
 */

public class ConstantClass extends Constant {

    private ConstPool constPool;
    private int nameIndex;


    public ConstantClass(ByteBuffer byteBuffer, ConstPool constPool) {
        this.constPool = constPool;
        this.nameIndex = byteBuffer.getShort();
    }

    public String getName() {
        return constPool.get(nameIndex).toString();
    }

    public int getNameIndex() {
        return nameIndex;
    }
}
