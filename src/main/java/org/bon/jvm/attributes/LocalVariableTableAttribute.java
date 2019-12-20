package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.13
 */

public class LocalVariableTableAttribute extends Attribute {

    private List<LocalVariable> localVariables;

    public LocalVariableTableAttribute() {
        localVariables = new ArrayList<>();
    }

    public LocalVariableTableAttribute(List<LocalVariable> localVariables) {
        this.localVariables = localVariables;
    }

    public List<LocalVariable> getLocalVariables() {
        return localVariables;
    }

    public void setLocalVariables(List<LocalVariable> localVariables) {
        this.localVariables = localVariables;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static LocalVariableTableAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        LocalVariableTableAttribute a = new LocalVariableTableAttribute();

        int tableLength = in.readUnsignedShort();
        for (int i = 0; i < tableLength; i++) {
            a.localVariables.add(LocalVariable.from(in, constPool));
        }
        return a;
    }

    public static class LocalVariable {

        private int startPc;
        private int length;
        private String name;
        private String descriptor;
        private int index;

        public int getStartPc() {
            return startPc;
        }

        public void setStartPc(int startPc) {
            this.startPc = startPc;
        }

        public int getLength() {
            return length;
        }

        public void setLength(int length) {
            this.length = length;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescriptor() {
            return descriptor;
        }

        public void setDescriptor(String descriptor) {
            this.descriptor = descriptor;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public static LocalVariable from(DataInputStream in, ConstPool constPool) throws IOException {
            LocalVariable lv = new LocalVariable();
            lv.startPc = in.readUnsignedShort();
            lv.length = in.readUnsignedShort();
            lv.name = constPool.get(in.readUnsignedShort()).toString();
            lv.descriptor = constPool.get(in.readUnsignedShort()).toString();
            lv.index = in.readUnsignedShort();
            return lv;
        }
    }
}
