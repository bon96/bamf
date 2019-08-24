package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * Used to skip unsupported or invalid attributes
 */

public class SkipAttribute extends Attribute {

    public SkipAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);
        System.out.println("Skipping " + getName() + " " + getLength());
        byteBuffer.position(byteBuffer.position() + getLength());
    }
}
