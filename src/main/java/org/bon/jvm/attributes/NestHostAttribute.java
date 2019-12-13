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
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.28
 */

public class NestHostAttribute extends Attribute {

    private ClassConstant hostClass;

    private NestHostAttribute() {
    }

    public NestHostAttribute(ClassConstant hostClass) {
        this.hostClass = hostClass;
    }

    public ClassConstant getHostClass() {
        return hostClass;
    }

    public void setHostClass(ClassConstant hostClass) {
        this.hostClass = hostClass;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }

    public static NestHostAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        NestHostAttribute a = new NestHostAttribute();
        a.constPool = constPool;
        a.nameIndex = nameIndex;
        a.length = length;

        a.hostClass = (ClassConstant) constPool.get(in.readUnsignedShort());
        return a;
    }
}
