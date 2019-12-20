package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.8
 */

public class MethodHandleConstant extends Constant {
    //FieldRef
    public static final int KIND_REF_GETFIELD = 1;
    public static final int KIND_REF_GETSTATIC = 2;
    public static final int KIND_REF_PUTFIELD = 3;
    public static final int KIND_REF_PUTSTATIC = 4;

    //MethodRef
    public static final int KIND_REF_INVOKEVIRTUAL = 5;
    public static final int KIND_REF_NEWINVOKESPECIAL = 8;

    //if class file version is less than 52.0 MethodRef else InterfaceMethodRef
    public static final int KIND_REF_INVOKESTATIC = 6;
    public static final int KIND_REF_INVOKESPECIAL = 7;

    //InterfaceMethodRef
    public static final int KIND_REF_INVOKEINTERFACE = 9;

    private ConstPool constPool;
    private int referenceKind;
    private int referenceIndex;

    public int getReferenceKind() {
        return referenceKind;
    }

    public Constant getReference() {
        return constPool.get(referenceIndex);
    }

    public int getReferenceIndex() {
        return referenceIndex;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {
        out.writeByte(Constant.METHOD_HANDLE);
        out.writeShort(referenceKind);
        out.writeShort(referenceIndex);
    }

    public static MethodHandleConstant from(DataInputStream in, ConstPool constPool) throws IOException {
        MethodHandleConstant c = new MethodHandleConstant();
        c.constPool = constPool;
        c.referenceKind = in.readUnsignedByte();
        c.referenceIndex = in.readUnsignedShort();
        return c;
    }
}
