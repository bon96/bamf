package org.bon.jvm.attributes.stackmap;

import org.bon.jvm.attributes.Attribute;
import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.4
 */

public class StackMapTableAttribute extends Attribute {

    private List<StackMapFrame> frames = new ArrayList<>();

    public List<StackMapFrame> getFrames() {
        return frames;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }

    public static StackMapTableAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        StackMapTableAttribute a = new StackMapTableAttribute();
        int entries = in.readUnsignedShort();
        for (int i = 0; i < entries; i++) {
            a.frames.add(StackMapFrame.from(in));
        }
        return a;
    }

}
