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
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.29
 */

public class NestMembersAttribute extends Attribute {

    private List<ClassConstant> classes;

    public NestMembersAttribute() {
        classes = new ArrayList<>();
    }

    public NestMembersAttribute(List<ClassConstant> classes) {
        this.classes = classes;
    }


    public List<ClassConstant> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassConstant> classes) {
        this.classes = classes;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static NestMembersAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        NestMembersAttribute a = new NestMembersAttribute();

        int classesCount = in.readUnsignedShort();
        for (int i = 0; i < classesCount; i++) {
            a.classes.add((ClassConstant) constPool.get(in.readUnsignedShort()));
        }
        return a;
    }
}
