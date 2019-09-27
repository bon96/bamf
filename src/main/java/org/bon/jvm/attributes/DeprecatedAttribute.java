package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.15
 */

public class DeprecatedAttribute extends Attribute {

    public static DeprecatedAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) {
        DeprecatedAttribute a = new DeprecatedAttribute();
        a.nameIndex = nameIndex;
        a.length = length;
        return a;
    }
}
