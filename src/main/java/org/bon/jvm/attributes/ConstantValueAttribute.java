package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.Constant;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.2
 */

public class ConstantValueAttribute extends Attribute {

    private int constantValueIndex;

    public static ConstantValueAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        ConstantValueAttribute a = new ConstantValueAttribute();
        a.constPool = constPool;
        a.nameIndex = nameIndex;
        a.length = length;

        a.constantValueIndex = in.readUnsignedShort();
        return a;
    }

    public Constant getConst() {
        return constPool.get(constantValueIndex);
    }

    public int getConstantValueIndex() {
        return constantValueIndex;
    }
}
