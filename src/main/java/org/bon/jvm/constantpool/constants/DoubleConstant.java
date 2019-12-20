package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoubleConstant that = (DoubleConstant) o;
        return Double.compare(that.getValue(), getValue()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {
        out.writeByte(Constant.DOUBLE);
        out.writeDouble(value);
    }

    public static DoubleConstant from(DataInputStream in) throws IOException {
        DoubleConstant c = new DoubleConstant();
        c.value = in.readDouble();
        return c;
    }
}
