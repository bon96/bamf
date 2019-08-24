package com.pushit.jvm.attributes;

import com.pushit.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.3
 */

public class CodeAttribute extends Attribute {

    private int maxStack;
    private int maxLocals;

    private List<Byte> instructions = new ArrayList<>();
    private List<Exception> exceptions = new ArrayList<>();
    private List<Attribute> attributes = new ArrayList<>();


    public CodeAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);

        this.maxStack = byteBuffer.getShort();
        this.maxLocals = byteBuffer.getShort();

        int codeLength = byteBuffer.getInt();
        for (int i = 0; i < codeLength; i++) {
            instructions.add(byteBuffer.get());
        }

        int exceptionsLength = byteBuffer.getShort();
        for (int i = 0; i < exceptionsLength; i++) {
            exceptions.add(new Exception(byteBuffer));
        }

        int attributesCount = byteBuffer.getShort();
        for (int i = 0; i < attributesCount; i++) {
            attributes.add(Attribute.from(byteBuffer, constPool));
        }
    }

    public int getMaxStack() {
        return maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public List<Byte> getInstructions() {
        return instructions;
    }

    public List<Exception> getExceptions() {
        return exceptions;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public static class Exception {

        private int start;
        private int end;
        private int handler;
        private int catchType;

        public Exception(ByteBuffer byteBuffer) {
            this.start = byteBuffer.getShort();
            this.end = byteBuffer.getShort();
            this.handler = byteBuffer.getShort();
            this.catchType = byteBuffer.getShort();
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getHandler() {
            return handler;
        }

        public int getCatchType() {
            return catchType;
        }
    }
}
