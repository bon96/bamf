package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.8
 */

public class SyntheticAttribute extends Attribute {

    public SyntheticAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);
    }
}
