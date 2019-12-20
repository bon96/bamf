package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.ClassConstant;
import org.bon.jvm.constantpool.constants.NameAndTypeConstant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.7
 */

public class EnclosingMethodAttribute extends Attribute {

    private ClassConstant classConstant;
    private NameAndTypeConstant nameAndTypeConstant;

    public EnclosingMethodAttribute(ClassConstant classConstant) {
        this.classConstant = classConstant;
    }

    public EnclosingMethodAttribute(ClassConstant classConstant, NameAndTypeConstant nameAndTypeConstant) {
        this.classConstant = classConstant;
        this.nameAndTypeConstant = nameAndTypeConstant;
    }

    public ClassConstant getClassConstant() {
        return classConstant;
    }

    public void setClassConstant(ClassConstant classConstant) {
        this.classConstant = classConstant;
    }

    public NameAndTypeConstant getNameAndTypeConstant() {
        return nameAndTypeConstant;
    }

    public void setNameAndTypeConstant(NameAndTypeConstant nameAndTypeConstant) {
        this.nameAndTypeConstant = nameAndTypeConstant;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    //TODO finish getters
    public static EnclosingMethodAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        int classIndex = in.readUnsignedShort();
        int methodIndex = in.readUnsignedShort();

        if (methodIndex != 0) {
            return new EnclosingMethodAttribute(constPool.get(classIndex).cast(),
                    constPool.get(methodIndex).cast());
        } else {
            return new EnclosingMethodAttribute(constPool.get(classIndex).cast());
        }
    }
}
