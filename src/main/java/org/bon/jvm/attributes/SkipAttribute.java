package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Used to skip unsupported or invalid attributes
 */

public class SkipAttribute extends Attribute {

    public SkipAttribute(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        this.nameIndex = nameIndex;
        this.length = length;
        System.out.println("Skipping " + getName() + " " + getLength());
        in.skipBytes(length - 6);
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }
}
