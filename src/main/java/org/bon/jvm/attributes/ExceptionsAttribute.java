package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.ClassConstant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.5
 */

public class ExceptionsAttribute extends Attribute {

    private List<ClassConstant> exceptions = new ArrayList<>();

    public List<ClassConstant> getExceptions() {
        return exceptions;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }

    public static ExceptionsAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        ExceptionsAttribute a = new ExceptionsAttribute();
        a.constPool = constPool;
        a.nameIndex = nameIndex;
        a.length = length;

        int exceptionsCount = in.readUnsignedShort();
        for (int i = 0; i < exceptionsCount; i++) {
            a.exceptions.add(constPool.get(in.readUnsignedShort()).cast());
        }
        return a;
    }
}
