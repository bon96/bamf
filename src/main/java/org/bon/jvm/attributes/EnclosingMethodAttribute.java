package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.7
 */

public class EnclosingMethodAttribute extends Attribute {
    private int classIndex;
    private int methodIndex;

    public int getClassIndex() {
        return classIndex;
    }

    public int getMethodIndex() {
        return methodIndex;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }

    //TODO finish getters
    public static EnclosingMethodAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        EnclosingMethodAttribute a = new EnclosingMethodAttribute();
        a.constPool = constPool;
        a.nameIndex = nameIndex;
        a.length = length;
        a.classIndex = in.readUnsignedShort();
        a.methodIndex = in.readUnsignedShort();
        return a;
    }
}
