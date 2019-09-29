package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.types.ConstInstruction;

import java.io.DataInputStream;
import java.io.IOException;

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
    public String getName() {
        return "Fconst";
    }

    @Override
    public Float getValue() {
        return f;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, float f) throws IOException {
        return new Fconst(f);
    }
}
