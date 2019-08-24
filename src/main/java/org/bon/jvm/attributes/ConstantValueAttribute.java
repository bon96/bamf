package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.Constant;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.2
 */

public class ConstantValueAttribute extends Attribute {

    private int constantValueIndex;

    public ConstantValueAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);
        this.constantValueIndex = byteBuffer.getShort();
    }

    public Constant getConst() {
        return constPool.get(constantValueIndex);
    }

    public int getConstantValueIndex() {
        return constantValueIndex;
    }
}
