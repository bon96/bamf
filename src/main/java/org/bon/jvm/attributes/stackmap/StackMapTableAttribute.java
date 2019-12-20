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

    private List<StackMapFrame> frames;

    public StackMapTableAttribute() {
        frames = new ArrayList<>();
    }

    public StackMapTableAttribute(List<StackMapFrame> frames) {
        this.frames = frames;
    }

    public List<StackMapFrame> getFrames() {
        return frames;
    }

    public void setFrames(List<StackMapFrame> frames) {
        this.frames = frames;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static StackMapTableAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        StackMapTableAttribute a = new StackMapTableAttribute();
        int entries = in.readUnsignedShort();
        for (int i = 0; i < entries; i++) {
            a.frames.add(StackMapFrame.from(in));
        }
        return a;
    }

}
