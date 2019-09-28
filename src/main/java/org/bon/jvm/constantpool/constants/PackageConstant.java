package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class PackageConstant extends Constant {

    private ConstPool constPool;
    private int nameIndex;

    public String getName() {
        return constPool.get(nameIndex).toString();
    }

    public int getNameIndex() {
        return nameIndex;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {
        out.writeByte(Constant.PACKAGE);
        out.writeShort(nameIndex);
    }

    public static PackageConstant from(DataInputStream in, ConstPool constPool) throws IOException {
        PackageConstant c = new PackageConstant();
        c.constPool = constPool;
        c.nameIndex = in.readUnsignedShort();
        return c;
    }
}
