package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.7
 */

public class EnclosingMethodAttribute extends Attribute {
    private int classIndex;
    private int methodIndex;

    //TODO finish getters
    public EnclosingMethodAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);
        this.classIndex = byteBuffer.getShort();
        this.methodIndex = byteBuffer.getShort();
    }

    public int getClassIndex() {
        return classIndex;
    }

    public int getMethodIndex() {
        return methodIndex;
    }
}
