package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.ValueConstant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.2
 */

public class ConstantValueAttribute extends Attribute {

    private ValueConstant valueConstant;

    public ConstantValueAttribute(ValueConstant valueConstant) {
        this.valueConstant = valueConstant;
    }

    public ValueConstant getValueConstant() {
        return valueConstant;
    }

    public void setValueConstant(ValueConstant valueConstant) {
        this.valueConstant = valueConstant;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static ConstantValueAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        return new ConstantValueAttribute(constPool.get(in.readUnsignedShort()).cast());
    }
}
