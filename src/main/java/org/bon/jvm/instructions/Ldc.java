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

public class Ldc extends Instruction implements ConstInstruction {

    private ConstPool constPool;
    private int index;

    public Ldc(int index) {
        this.index = index;
    }

    public Ldc(ConstPool constPool, int index) {
        this.constPool = constPool;
        this.index = index;
    }

    @Override
    public String getName() {
        return "Ldc";
    }

    @Override
    public Object getValue() {
        return constPool.get(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ldc ldc = (Ldc) o;
        return index == ldc.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index);
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Ldc(constPool, in.readUnsignedByte());
    }
}
