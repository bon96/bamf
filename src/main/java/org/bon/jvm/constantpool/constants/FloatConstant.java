package org.bon.jvm.constantpool.constants;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.4
 */

public class FloatConstant extends Constant implements ValueConstant<Float> {

    private float value;

    @Override
    public Float getValue() {
        return value;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {
        out.writeByte(Constant.FLOAT);
        out.writeFloat(value);
    }

    public static FloatConstant from(DataInputStream in) throws IOException {
        FloatConstant c = new FloatConstant();
        c.value = in.readFloat();
        return c;
    }
}
