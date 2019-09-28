package org.bon.jvm;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.ClassConstant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Interface {

    private ConstPool constPool;
    private int classConstantIndex;

    public int getClassConstantIndex() {
        return classConstantIndex;
    }

    public ClassConstant getClassConstant() {
        return constPool.get(classConstantIndex).cast();
    }

    public void writeTo(DataOutputStream out) throws IOException {
        out.writeShort(classConstantIndex);
    }

    public static Interface from(DataInputStream in, ConstPool constPool) throws IOException {
        Interface i = new Interface();
        i.constPool = constPool;
        i.classConstantIndex = in.readShort();
        return i;
    }
}
