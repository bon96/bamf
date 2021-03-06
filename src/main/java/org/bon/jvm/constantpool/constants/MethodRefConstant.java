package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.util.MethodDescriptor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.2
 */

public class MethodRefConstant extends Constant implements MethodConstant {

    private ConstPool constPool;
    private int classIndex;
    private int nameAndTypeIndex;

    @Override
    public ClassConstant getClassConstant() {
        return constPool.get(classIndex).cast();
    }

    @Override
    public String getName() {
        return getNameAndType().getName();
    }

    @Override
    public MethodDescriptor getDescriptor() {
        return new MethodDescriptor(getNameAndType().getDescriptor());
    }

    @Override
    public NameAndTypeConstant getNameAndType() {
        return constPool.get(nameAndTypeIndex).cast();
    }

    public int getClassIndex() {
        return classIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {
        out.writeByte(Constant.METHOD_REF);
        out.writeShort(classIndex);
        out.writeShort(nameAndTypeIndex);
    }

    public static MethodRefConstant from(DataInputStream in, ConstPool constPool) throws IOException {
        MethodRefConstant c = new MethodRefConstant();
        c.constPool = constPool;
        c.classIndex = in.readUnsignedShort();
        c.nameAndTypeIndex = in.readUnsignedShort();
        return c;
    }
}
