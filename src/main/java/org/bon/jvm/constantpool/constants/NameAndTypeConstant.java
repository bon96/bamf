package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.6
 */

public class NameAndTypeConstant extends Constant {

    private ConstPool constPool;
    private int nameIndex;
    private int descriptorIndex;

    public String getName() {
        return constPool.get(nameIndex).toString();
    }

    public String getDescriptor() {
        return constPool.get(descriptorIndex).toString();
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public int getDescriptorIndex() {
        return descriptorIndex;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {
        out.writeByte(Constant.NAME_AND_TYPE);
        out.writeShort(nameIndex);
        out.writeShort(descriptorIndex);
    }

    public static NameAndTypeConstant from(DataInputStream in, ConstPool constPool) throws IOException {
        NameAndTypeConstant c = new NameAndTypeConstant();
        c.constPool = constPool;
        c.nameIndex = in.readUnsignedShort();
        c.descriptorIndex = in.readUnsignedShort();
        return c;
    }
}
