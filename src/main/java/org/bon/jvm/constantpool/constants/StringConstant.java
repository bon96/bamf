package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.3
 */

public class StringConstant extends Constant implements ValueConstant<String> {

    private ConstPool constPool;
    private int stringIndex;

    @Override
    public String toString() {
        return constPool.get(stringIndex).toString();
    }

    public int getStringIndex() {
        return stringIndex;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {
        out.writeByte(Constant.STRING);
        out.writeShort(stringIndex);
    }

    @Override
    public String getValue() {
        return toString();
    }

    public static StringConstant from(DataInputStream in, ConstPool constPool) throws IOException {
        StringConstant c = new StringConstant();
        c.constPool = constPool;
        c.stringIndex = in.readUnsignedShort();
        return c;
    }
}
