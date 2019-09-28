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

    private List<LocalVariable> localVariables = new ArrayList<>();

    public List<LocalVariable> getLocalVariables() {
        return localVariables;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }

    public static LocalVariableTableAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        LocalVariableTableAttribute a = new LocalVariableTableAttribute();
        a.nameIndex = nameIndex;
        a.length = length;

        int tableLength = in.readUnsignedShort();
        for (int i = 0; i < tableLength; i++) {
            a.localVariables.add(LocalVariable.from(in, constPool));
        }
        return a;
    }

    public static class LocalVariable {

        private ConstPool constPool;
        private int startPc;
        private int length;
        private int nameIndex;
        private int descriptorIndex;
        private int index;

        public int getStartPc() {
            return startPc;
        }

        public int getLength() {
            return length;
        }

        public int getNameIndex() {
            return nameIndex;
        }

        public int getDescriptorIndex() {
            return descriptorIndex;
        }

        public int getIndex() {
            return index;
        }

        //TODO finish getters
        public static LocalVariable from(DataInputStream in, ConstPool constPool) throws IOException {
            LocalVariable lv = new LocalVariable();
            lv.constPool = constPool;
            lv.startPc = in.readUnsignedShort();
            lv.length = in.readUnsignedShort();
            lv.nameIndex = in.readUnsignedShort();
            lv.descriptorIndex = in.readUnsignedShort();
            lv.index = in.readUnsignedShort();
            return lv;
        }
    }
}
