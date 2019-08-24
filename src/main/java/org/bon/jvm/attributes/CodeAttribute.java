package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

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

        maxStack = byteBuffer.getShort();
        maxLocals = byteBuffer.getShort();

        int instructionCount = byteBuffer.getInt();
        for (int i = 0; i < instructionCount; i++) {
            instructions.add(byteBuffer.get());
        }

        int exceptionsCount = byteBuffer.getShort();
        for (int i = 0; i < exceptionsCount; i++) {
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
            start = byteBuffer.getShort();
            end = byteBuffer.getShort();
            handler = byteBuffer.getShort();
            catchType = byteBuffer.getShort();
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
