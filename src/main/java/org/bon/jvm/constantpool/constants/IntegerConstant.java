package org.bon.jvm.constantpool.constants;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.4
 */

public class IntegerConstant extends Constant implements ValueConstant<Integer> {

    private int value;

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {
        out.writeByte(Constant.INTEGER);
        out.writeInt(value);
    }

    public static IntegerConstant from(DataInputStream in) throws IOException {
        IntegerConstant c = new IntegerConstant();
        c.value = in.readInt();
        return c;
    }
}
