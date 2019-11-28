package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.2
 */

public class InterfaceMethodRefConstant extends Constant implements MethodConstant {

    private ConstPool constPool;
    private int classIndex;
    private int nameAndTypeIndex;

    @Override
    public ClassConstant getConstClass() {
        return constPool.get(classIndex).cast();
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
    public void writeTo(DataOutputStream out) throws IOException {
        out.writeByte(Constant.INTERFACE_METHOD_REF);
        out.writeShort(classIndex);
        out.writeShort(nameAndTypeIndex);
    }

    public static InterfaceMethodRefConstant from(DataInputStream in, ConstPool constPool) throws IOException {
        InterfaceMethodRefConstant c = new InterfaceMethodRefConstant();
        c.constPool = constPool;
        c.classIndex = in.readUnsignedShort();
        c.nameAndTypeIndex = in.readUnsignedShort();
        return c;
    }
}
