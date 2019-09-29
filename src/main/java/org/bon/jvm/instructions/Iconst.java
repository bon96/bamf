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

public class Iconst extends Instruction implements ConstInstruction<Integer> {

    private int i;

    public Iconst(int i) {
        this.i = i;
    }

    @Override
    public String getName() {
        return "Iconst";
    }

    @Override
    public Integer getValue() {
        return i;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, int i) throws IOException {
        return new Iconst(i);
    }
}
