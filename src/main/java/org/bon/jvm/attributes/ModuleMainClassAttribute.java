package org.bon.jvm.attributes;

/**
 * Tommi
 * Date: 13/12/2019
 * Time: 22.18
 */

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.ClassConstant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.27
 */

public class ModuleMainClassAttribute extends Attribute {

    private ClassConstant mainClass;

    private ModuleMainClassAttribute() {
    }

    public ModuleMainClassAttribute(ClassConstant mainClass) {
        this.mainClass = mainClass;
    }

    public ClassConstant getMainClass() {
        return mainClass;
    }

    public void setMainClass(ClassConstant mainClass) {
        this.mainClass = mainClass;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }

    public static ModuleMainClassAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        ModuleMainClassAttribute a = new ModuleMainClassAttribute();
        a.constPool = constPool;
        a.nameIndex = nameIndex;
        a.length = length;

        a.mainClass = (ClassConstant) constPool.get(in.readUnsignedShort());
        return a;
    }

}
