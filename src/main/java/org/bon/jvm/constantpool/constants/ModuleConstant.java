package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

public class ModuleConstant extends Constant {

    private ConstPool constPool;
    private int nameIndex;

    public ModuleConstant(ByteBuffer byteBuffer, ConstPool constPool) {
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
