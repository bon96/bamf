package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.util.MethodDescriptor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.9
 */

public class MethodTypeConstant extends Constant {

    private ConstPool constPool;
    private int descriptorIndex;

    public MethodDescriptor getDescriptor() {
        return new MethodDescriptor(constPool.get(descriptorIndex).toString());
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {
        out.writeByte(Constant.METHOD_TYPE);
        out.writeShort(descriptorIndex);
    }

    public static MethodTypeConstant from(DataInputStream in, ConstPool constPool) throws IOException {
        MethodTypeConstant c = new MethodTypeConstant();
        c.constPool = constPool;
        c.descriptorIndex = in.readUnsignedShort();
        return c;
    }
}
