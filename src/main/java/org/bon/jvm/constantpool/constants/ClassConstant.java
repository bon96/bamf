package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.1
 */

public class ClassConstant extends Constant {

    private ConstPool constPool;
    private int nameIndex;

    public String getName() {
        return constPool.get(nameIndex).toString();
    }

    public int getNameIndex() {
        return nameIndex;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {
        out.writeByte(Constant.CLASS);
        out.writeShort(nameIndex);
    }

    @Override
    public String toString() {
        return getName();
    }

    public static ClassConstant from(DataInputStream in, ConstPool constPool) throws IOException {
        ClassConstant c = new ClassConstant();
        c.constPool = constPool;
        c.nameIndex = in.readUnsignedShort();
        return c;
    }
}
