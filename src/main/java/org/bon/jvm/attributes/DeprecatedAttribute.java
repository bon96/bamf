package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.15
 */

public class DeprecatedAttribute extends Attribute {

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static DeprecatedAttribute from(DataInputStream in, ConstPool constPool, int length) {
        return new DeprecatedAttribute();
    }
}
