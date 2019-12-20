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
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static NestHostAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        return new NestHostAttribute((ClassConstant) constPool.get(in.readUnsignedShort()));
    }
}
