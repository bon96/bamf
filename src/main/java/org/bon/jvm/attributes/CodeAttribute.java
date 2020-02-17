package org.bon.jvm.attributes;

import org.bon.jvm.Method;
import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.Instruction;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.3
 */

public class CodeAttribute extends Attribute {

    private int maxStack;
    private int maxLocals;

    private List<Exception> exceptions = new ArrayList<>();
    private List<Attribute> attributes = new ArrayList<>();
    private List<Instruction> instructions;

    public int getMaxStack() {
        return maxStack;
    }

    public void setMaxStack(int maxStack) {
        this.maxStack = maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public void setMaxLocals(int maxLocals) {
        this.maxLocals = maxLocals;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public List<Exception> getExceptions() {
        return exceptions;
    }

    public void setExceptions(List<Exception> exceptions) {
        this.exceptions = exceptions;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static CodeAttribute from(DataInputStream in, ConstPool constPool, Method method, int length) throws IOException {
        CodeAttribute a = new CodeAttribute();

        a.maxStack = in.readUnsignedShort();
        a.maxLocals = in.readUnsignedShort();

        a.instructions = Instruction.instructionsFrom(in, constPool, method);

        int exceptionsCount = in.readUnsignedShort();
        for (int i = 0; i < exceptionsCount; i++) {
            a.exceptions.add(Exception.from(in));
        }

        int attributesCount = in.readUnsignedShort();
        for (int i = 0; i < attributesCount; i++) {
            a.attributes.add(Attribute.from(in, constPool));
        }
        return a;
    }

    public static class Exception {

        private int start;
        private int end;
        private int handler;
        private int catchType;

        public Exception(int start, int end, int handler, int catchType) {
            this.start = start;
            this.end = end;
            this.handler = handler;
            this.catchType = catchType;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getHandler() {
            return handler;
        }

        public void setHandler(int handler) {
            this.handler = handler;
        }

        public int getCatchType() {
            return catchType;
        }

        public void setCatchType(int catchType) {
            this.catchType = catchType;
        }

        public static Exception from(DataInputStream in) throws IOException {
            return new Exception(in.readUnsignedShort(), in.readUnsignedShort(), in.readUnsignedShort(),
                    in.readUnsignedShort());
        }
    }
}
