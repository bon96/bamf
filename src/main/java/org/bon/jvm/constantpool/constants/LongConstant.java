package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.5
 */

public class LongConstant extends Constant implements ValueConstant<Long> {

    private long value;

    @Override
    public Long getValue() {
        return value;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {
        out.writeByte(Constant.LONG);
        out.writeLong(value);
    }

    public static LongConstant from(DataInputStream in) throws IOException {
        LongConstant c = new LongConstant();
        c.value = in.readLong();
        return c;
    }
}
