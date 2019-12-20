package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.11
 */

public class ModuleConstant extends Constant {

    private ConstPool constPool;
    private int nameIndex;

    public String getName() {
        return constPool.get(nameIndex).toString();
    }

    public int getNameIndex() {
        return nameIndex;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {
        out.writeByte(Constant.MODULE);
        out.writeShort(nameIndex);
    }

    public static ModuleConstant from(DataInputStream in, ConstPool constPool) throws IOException {
        ModuleConstant c = new ModuleConstant();
        c.constPool = constPool;
        c.nameIndex = in.readUnsignedShort();
        return c;
    }
}
