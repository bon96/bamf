package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.14
 */

public class LocalVariableTypeTableAttribute extends Attribute {

    private List<LocalVariableType> localVariableTypes = new ArrayList<>();

    public LocalVariableTypeTableAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);

        int tableLength = byteBuffer.getShort();
        for (int i = 0; i < tableLength; i++) {
            localVariableTypes.add(new LocalVariableType(byteBuffer, constPool));
        }
    }

    public static class LocalVariableType {

        private ConstPool constPool;
        private int startPc;
        private int length;
        private int nameIndex;
        private int signatureIndex;
        private int index;

        //TODO finish getters
        public LocalVariableType(ByteBuffer byteBuffer, ConstPool constPool) {
            this.constPool = constPool;
            this.startPc = byteBuffer.getShort();
            this.length = byteBuffer.getShort();
            this.nameIndex = byteBuffer.getShort();
            this.signatureIndex = byteBuffer.getShort();
            this.index = byteBuffer.getShort();
        }

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
    }
}
