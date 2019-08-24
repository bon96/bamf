package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.6
 */

public class InnerClassesAttribute extends Attribute {

    private List<InnerClass> innerClasses = new ArrayList<>();

    public InnerClassesAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);

        int classCount = byteBuffer.getShort();
        for (int i = 0; i < classCount; i++) {
            innerClasses.add(new InnerClass(byteBuffer, constPool));
        }
    }

    public static class InnerClass {
        private ConstPool constPool;
        private int innerClassInfoIndex;
        private int outerClassInfoIndex;
        private int innerNameIndex;
        private int innerClassAccessFlags;

        //TODO finish getters
        public InnerClass(ByteBuffer byteBuffer, ConstPool constPool) {
            this.constPool = constPool;
            this.innerClassInfoIndex = byteBuffer.getShort();
            this.outerClassInfoIndex = byteBuffer.getShort();
            this.innerNameIndex = byteBuffer.getShort();
            this.innerClassAccessFlags = byteBuffer.getShort();
        }

        public int getInnerClassInfoIndex() {
            return innerClassInfoIndex;
        }

        public int getOuterClassInfoIndex() {
            return outerClassInfoIndex;
        }

        public int getInnerNameIndex() {
            return innerNameIndex;
        }

        public int getInnerClassAccessFlags() {
            return innerClassAccessFlags;
        }
    }
}
