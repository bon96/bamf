package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.8
 */

public class SyntheticAttribute extends Attribute {

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }

    public static SyntheticAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) {
        SyntheticAttribute a = new SyntheticAttribute();
        a.nameIndex = nameIndex;
        a.length = length;
        return a;
    }
}
