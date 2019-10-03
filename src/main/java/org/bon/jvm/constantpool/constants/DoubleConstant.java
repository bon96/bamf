package org.bon.jvm.constantpool.constants;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.5
 */


public class DoubleConstant extends Constant implements ValueConstant<Double> {

    private double value;

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {
        out.writeByte(Constant.DOUBLE);
        out.writeDouble(value);
    }

    public static DoubleConstant from(DataInputStream in) throws IOException {
        DoubleConstant c = new DoubleConstant();
        c.value = in.readDouble();
        return c;
    }
}
