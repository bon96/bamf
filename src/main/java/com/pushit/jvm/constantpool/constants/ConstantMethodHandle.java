package com.pushit.jvm.constantpool.constants;

import com.pushit.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.8
 */

public class ConstantMethodHandle extends Constant {

    private ConstPool constPool;
    private int referenceKind;
    private int referenceIndex;

    public ConstantMethodHandle(ByteBuffer byteBuffer, ConstPool constPool) {
        this.constPool = constPool;
        this.referenceKind = byteBuffer.get();
        this.referenceIndex = byteBuffer.getShort();
    }

    public int getReferenceKind() {
        return referenceKind;
    }

    public Constant getReference() {
        return constPool.get(referenceIndex);
    }

    public int getReferenceIndex() {
        return referenceIndex;
    }
}
