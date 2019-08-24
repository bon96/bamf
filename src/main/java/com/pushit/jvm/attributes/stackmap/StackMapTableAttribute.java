package com.pushit.jvm.attributes.stackmap;

import com.pushit.jvm.attributes.Attribute;
import com.pushit.jvm.attributes.stackmap.StackMapFrame;
import com.pushit.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.4
 */

public class StackMapTableAttribute extends Attribute {

    private List<StackMapFrame> frames = new ArrayList<>();

    public StackMapTableAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);

        int entries = byteBuffer.getShort();
        for (int i = 0; i < entries; i++) {
            frames.add(StackMapFrame.from(byteBuffer));
        }
    }

    public List<StackMapFrame> getFrames() {
        return frames;
    }

}
