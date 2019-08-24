package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.10
 */

public class SourceFileAttribute extends Attribute {

    private int sourceFileIndex;

    public SourceFileAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);
        sourceFileIndex = byteBuffer.getShort();
    }

    /**
     * The string referenced by the sourcefile_index item will be interpreted
     * as indicating the name of the source file from which this class file was compiled.
     * It will not be interpreted as indicating the name of a directory containing the file or an absolute path
     * name for the file; such platform-specific additional information must be supplied by the run-time
     * interpreter or development tool at the time the file name is actually used.
     */

    public String getSourceFileName() {
        return constPool.get(sourceFileIndex).toString();
    }

    public int getSourceFileIndex() {
        return sourceFileIndex;
    }
}
