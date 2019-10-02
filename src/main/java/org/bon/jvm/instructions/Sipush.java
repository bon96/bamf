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

public class Sipush extends Instruction implements ConstInstruction<Short> {

    private int value;

    public Sipush(int value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return "Sipush";
    }

    @Override
    public Short getValue() {
        return (short) value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sipush sipush = (Sipush) o;
        return getValue() == sipush.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Sipush(in.readShort());
    }
}
