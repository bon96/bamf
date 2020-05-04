package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.Constant;
import org.bon.jvm.constantpool.constants.ValueConstant;
import org.bon.jvm.execution.MethodContext;
import org.bon.jvm.execution.Stack;
import org.bon.jvm.instructions.types.LdcInstruction;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Ldc extends Instruction implements LdcInstruction {

    private Object object;

    public Ldc(Object object) {
        this.object = object;
    }

    @Override
    public void execute(MethodContext context, Stack stack) {

    }

    @Override
    public String getName() {
        return "Ldc";
    }

    @Override
    public Object getValue() {
        return object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ldc ldc = (Ldc) o;
        return object.equals(ldc.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(object);
    }

    @Override
    public String toString() {
        return getName() + " " + getValue();
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        Constant constant = constPool.get(in.readUnsignedByte());
        if (constant instanceof ValueConstant) {
            return new Ldc(((ValueConstant) constant).getValue());
        } else {
            return new Ldc(constant);
        }
    }
}
