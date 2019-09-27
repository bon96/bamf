package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.9
 */

public class MethodTypeConstant extends Constant {

    private ConstPool constPool;
    private int descriptorIndex;

    public String getDescriptor() {
        return constPool.get(descriptorIndex).toString();
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    public static MethodTypeConstant from(DataInputStream in, ConstPool constPool) throws IOException {
        MethodTypeConstant c = new MethodTypeConstant();
        c.constPool = constPool;
        c.descriptorIndex = in.readUnsignedShort();
        return c;
    }
}
