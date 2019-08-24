package com.pushit.jvm.constantpool.constants;

import com.pushit.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

public class ConstantModule extends Constant {

    private ConstPool constPool;
    private int nameIndex;

    public ConstantModule(ByteBuffer byteBuffer, ConstPool constPool) {
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
