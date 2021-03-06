package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.execution.MethodContext;
import org.bon.jvm.execution.Stack;
import org.bon.jvm.instructions.types.ConstInstruction;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Dconst extends Instruction implements ConstInstruction<Double> {

    private double d;

    public Dconst(double d) {
        this.d = d;
    }

    @Override
    public void execute(MethodContext context, Stack stack) {

    }

    @Override
    public String getName() {
        return "Dconst";
    }

    @Override
    public Double getValue() {
        return d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dconst dconst = (Dconst) o;
        return Double.compare(dconst.d, d) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(d);
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, double d) throws IOException {
        return new Dconst(d);
    }
}
