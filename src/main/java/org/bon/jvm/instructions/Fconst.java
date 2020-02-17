package org.bon.jvm.instructions;

import org.bon.jvm.execution.MethodContext;
import org.bon.jvm.execution.Stack;
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

public class Fconst extends Instruction implements ConstInstruction<Float> {

    private float f;

    public Fconst(float f) {
        this.f = f;
    }

    @Override
    public void execute(MethodContext context, Stack stack) {

    }

    @Override
    public String getName() {
        return "Fconst";
    }

    @Override
    public Float getValue() {
        return f;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fconst fconst = (Fconst) o;
        return Float.compare(fconst.f, f) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(f);
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, float f) throws IOException {
        return new Fconst(f);
    }
}
