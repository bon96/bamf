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
        this.constPool = constPool;
        this.nameIndex = nameIndex;
        this.length = length;
        System.err.println("Skipping unknown attribute " + getName() + " " + getLength());
        in.skipBytes(length);
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }
}
