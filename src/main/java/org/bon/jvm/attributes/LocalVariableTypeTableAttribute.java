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

    private List<LocalVariableType> localVariableTypes;

    public LocalVariableTypeTableAttribute() {
        localVariableTypes = new ArrayList<>();
    }

    public LocalVariableTypeTableAttribute(List<LocalVariableType> localVariableTypes) {
        this.localVariableTypes = localVariableTypes;
    }

    public List<LocalVariableType> getLocalVariableTypes() {
        return localVariableTypes;
    }

    public void setLocalVariableTypes(List<LocalVariableType> localVariableTypes) {
        this.localVariableTypes = localVariableTypes;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static LocalVariableTypeTableAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        LocalVariableTypeTableAttribute a = new LocalVariableTypeTableAttribute();

        int tableLength = in.readUnsignedShort();
        for (int i = 0; i < tableLength; i++) {
            a.localVariableTypes.add(LocalVariableType.from(in, constPool));
        }
        return a;
    }

    public static class LocalVariableType {

        private int startPc;
        private int length;
        private String name;
        private String signature;
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

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public static LocalVariableType from(DataInputStream in, ConstPool constPool) throws IOException {
            LocalVariableType lv = new LocalVariableType();
            lv.startPc = in.readUnsignedShort();
            lv.length = in.readUnsignedShort();
            lv.name = constPool.get(in.readUnsignedShort()).toString();
            lv.signature = constPool.get(in.readUnsignedShort()).toString();
            lv.index = in.readUnsignedShort();
            return lv;
        }
    }
}
