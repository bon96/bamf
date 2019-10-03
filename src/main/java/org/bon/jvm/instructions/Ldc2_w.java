package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.types.ConstInstruction;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Ldc2_w extends Instruction implements ConstInstruction {

    private Object object;

    public Ldc2_w(Object object) {
        this.object = object;
    }

    @Override
    public String getName() {
        return "Ldc2_w";
    }

    @Override
    public Object getValue() {
        return object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ldc2_w ldc2_w = (Ldc2_w) o;
        return object.equals(ldc2_w.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(object);
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Ldc2_w(constPool.get(in.readUnsignedShort()));
    }
}
