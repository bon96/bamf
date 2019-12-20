package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.10
 */

public class SourceFileAttribute extends Attribute {

    private String sourceFile;

    public SourceFileAttribute(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static SourceFileAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        return new SourceFileAttribute(constPool.get(in.readUnsignedShort()).toString());
    }
}
