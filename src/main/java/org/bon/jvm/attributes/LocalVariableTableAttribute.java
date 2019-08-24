package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.13
 */

public class LocalVariableTableAttribute extends Attribute {

    private List<LocalVariable> localVariables = new ArrayList<>();

    public LocalVariableTableAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);

        int tableLength = byteBuffer.getShort();
        for (int i = 0; i < tableLength; i++) {
            localVariables.add(new LocalVariable(byteBuffer, constPool));
        }
    }

    public List<LocalVariable> getLocalVariables() {
        return localVariables;
    }

    public static class LocalVariable {

        private ConstPool constPool;
        private int startPc;
        private int length;
        private int nameIndex;
        private int descriptorIndex;
        private int index;

        //TODO finish getters
        public LocalVariable(ByteBuffer byteBuffer, ConstPool constPool) {
            this.constPool = constPool;
            this.startPc = byteBuffer.getShort();
            this.length = byteBuffer.getShort();
            this.nameIndex = byteBuffer.getShort();
            this.descriptorIndex = byteBuffer.getShort();
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

        public int getDescriptorIndex() {
            return descriptorIndex;
        }

        public int getIndex() {
            return index;
        }
    }
}
