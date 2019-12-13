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

    private List<ClassConstant> classes = new ArrayList<>();

    public List<ClassConstant> getClasses() {
        return classes;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }

    public static NestMembersAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        NestMembersAttribute a = new NestMembersAttribute();
        a.constPool = constPool;
        a.nameIndex = nameIndex;
        a.length = length;

        int classesCount = in.readUnsignedShort();
        for (int i = 0; i < classesCount; i++) {
            a.classes.add((ClassConstant) constPool.get(in.readUnsignedShort()));
        }
        return a;
    }
}
