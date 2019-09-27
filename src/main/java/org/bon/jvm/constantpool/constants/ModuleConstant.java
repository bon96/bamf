package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

public class ModuleConstant extends Constant {

    private ConstPool constPool;
    private int nameIndex;

    public String getName() {
        return constPool.get(nameIndex).toString();
    }

    public int getNameIndex() {
        return nameIndex;
    }

    public static ModuleConstant from(DataInputStream in, ConstPool constPool) throws IOException {
        ModuleConstant c = new ModuleConstant();
        c.constPool = constPool;
        c.nameIndex = in.readUnsignedShort();
        return c;
    }
}
