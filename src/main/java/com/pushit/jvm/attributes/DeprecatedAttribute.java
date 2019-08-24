package com.pushit.jvm.attributes;

import com.pushit.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.15
 */

public class DeprecatedAttribute extends Attribute {

    public DeprecatedAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);
    }
}
