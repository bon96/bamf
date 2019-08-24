package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.ConstantClass;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.5
 */

public class ExceptionsAttribute extends Attribute {

    private List<ConstantClass> exceptions = new ArrayList<>();

    public ExceptionsAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);

        int exceptionsCount = byteBuffer.getShort();
        for (int i = 0; i < exceptionsCount; i++) {
            exceptions.add(constPool.get(byteBuffer.getShort()).cast());
        }
    }

    public List<ConstantClass> getExceptions() {
        return exceptions;
    }
}
