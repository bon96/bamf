package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.3
 */

public class StringConstant extends Constant {

    private ConstPool constPool;
    private int stringIndex;

    public StringConstant(ByteBuffer byteBuffer, ConstPool constPool) {
        this.constPool = constPool;
        stringIndex = byteBuffer.getShort();
    }

    @Override
    public String toString() {
        return constPool.get(stringIndex).toString();
    }

    public int getStringIndex() {
        return stringIndex;
    }
}
