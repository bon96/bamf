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

public class Lconst extends Instruction implements ConstInstruction<Long> {

    private long l;

    public Lconst(long l) {
        this.l = l;
    }

    @Override
    public String getName() {
        return "Lconst";
    }

    @Override
    public Long getValue() {
        return l;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lconst lconst = (Lconst) o;
        return l == lconst.l;
    }

    @Override
    public int hashCode() {
        return Objects.hash(l);
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, long l) throws IOException {
        return new Lconst(l);
    }
}
