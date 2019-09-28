package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.Instructions;

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

    private List<Integer> opcodes = new ArrayList<>();
    private List<Exception> exceptions = new ArrayList<>();
    private List<Attribute> attributes = new ArrayList<>();

    public int getMaxStack() {
        return maxStack;
    }

    public int getMaxLocals() {
        return maxLocals;
    }

    public List<Integer> getOpcodes() {
        return opcodes;
    }

    public List<Exception> getExceptions() {
        return exceptions;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }

    public static CodeAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        CodeAttribute a = new CodeAttribute();
        a.constPool = constPool;
        a.nameIndex = nameIndex;
        a.length = length;

        a.maxStack = in.readUnsignedShort();
        a.maxLocals = in.readUnsignedShort();

        int instructionCount = in.readInt();
        for (int i = 0; i < instructionCount; i++) {
            int offset = i;
            Instructions.from(in, constPool);
            //int opcode = in.readUnsignedByte();
            //a.opcodes.add(opcode);
        }

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

        public static Exception from(DataInputStream in) throws IOException {
            Exception e = new Exception();
            e.start = in.readUnsignedShort();
            e.end = in.readUnsignedShort();
            e.handler = in.readUnsignedShort();
            e.catchType = in.readUnsignedShort();
            return e;
        }
    }
}
