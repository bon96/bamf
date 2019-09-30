package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.14
 */

public class LocalVariableTypeTableAttribute extends Attribute {

    private List<LocalVariableType> localVariableTypes = new ArrayList<>();

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }

    public static LocalVariableTypeTableAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        LocalVariableTypeTableAttribute a = new LocalVariableTypeTableAttribute();
        a.constPool = constPool;
        a.nameIndex = nameIndex;
        a.length = length;

        int tableLength = in.readUnsignedShort();
        for (int i = 0; i < tableLength; i++) {
            a.localVariableTypes.add(LocalVariableType.from(in, constPool));
        }
        return a;
    }

    public static class LocalVariableType {

        private ConstPool constPool;
        private int startPc;
        private int length;
        private int nameIndex;
        private int signatureIndex;
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

        public int getSignatureIndex() {
            return signatureIndex;
        }

        public int getIndex() {
            return index;
        }

        //TODO finish getters
        public static LocalVariableType from(DataInputStream in, ConstPool constPool) throws IOException {
            LocalVariableType lv = new LocalVariableType();
            lv.constPool = constPool;
            lv.startPc = in.readUnsignedShort();
            lv.length = in.readUnsignedShort();
            lv.nameIndex = in.readUnsignedShort();
            lv.signatureIndex = in.readUnsignedShort();
            lv.index = in.readUnsignedShort();
            return lv;
        }
    }
}
