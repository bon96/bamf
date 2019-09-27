package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.7
 */

public class EnclosingMethodAttribute extends Attribute {
    private int classIndex;
    private int methodIndex;

    //TODO finish getters
    public static EnclosingMethodAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        EnclosingMethodAttribute a = new EnclosingMethodAttribute();
        a.nameIndex = nameIndex;
        a.length = length;
        a.classIndex = in.readUnsignedShort();
        a.methodIndex = in.readUnsignedShort();
        return a;
    }

    public int getClassIndex() {
        return classIndex;
    }

    public int getMethodIndex() {
        return methodIndex;
    }
}
