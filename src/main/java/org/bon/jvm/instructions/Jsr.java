package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Jsr extends Instruction {

    private int offset;

    public Jsr(int offset) {
        this.offset = offset;
    }

    @Override
    public String getName() {
        return "Jsr";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Jsr(in.readUnsignedShort());
    }
}
