package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.6
 */

public class InnerClassesAttribute extends Attribute {

    private List<InnerClass> innerClasses;

    public InnerClassesAttribute() {
        innerClasses = new ArrayList<>();
    }

    public InnerClassesAttribute(List<InnerClass> innerClasses) {
        this.innerClasses = innerClasses;
    }

    public List<InnerClass> getInnerClasses() {
        return innerClasses;
    }

    public void setInnerClasses(List<InnerClass> innerClasses) {
        this.innerClasses = innerClasses;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static InnerClassesAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        InnerClassesAttribute a = new InnerClassesAttribute();

        int classCount = in.readUnsignedShort();
        for (int i = 0; i < classCount; i++) {
            a.innerClasses.add(InnerClass.from(in, constPool));
        }
        return a;
    }

    public static class InnerClass {

        private int innerClassInfoIndex;
        private int outerClassInfoIndex;
        private int innerNameIndex;
        private int innerClassAccessFlags;

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

        //TODO edit to use Constants
        public static InnerClass from(DataInputStream in, ConstPool constPool) throws IOException {
            InnerClass c = new InnerClass();
            c.innerClassInfoIndex = in.readUnsignedShort();
            c.outerClassInfoIndex = in.readUnsignedShort();
            c.innerNameIndex = in.readUnsignedShort();
            c.innerClassAccessFlags = in.readUnsignedShort();
            return c;
        }
    }
}
