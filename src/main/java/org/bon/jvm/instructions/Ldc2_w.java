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

    private ConstPool constPool;
    private int index;

    public Ldc2_w(int index) {
        this.index = index;
    }

    public Ldc2_w(ConstPool constPool, int index) {
        this.constPool = constPool;
        this.index = index;
    }

    @Override
    public String getName() {
        return "Ldc2_w";
    }

    @Override
    public Object getValue() {
        return constPool.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ldc2_w ldc2_w = (Ldc2_w) o;
        return index == ldc2_w.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Ldc2_w(constPool, in.readUnsignedShort());
    }
}
