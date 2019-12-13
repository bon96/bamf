package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.12
 */

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
