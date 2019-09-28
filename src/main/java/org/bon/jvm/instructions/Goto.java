package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Goto extends Instruction {

    private int offset;

    public Goto(int offset) {
        this.offset = offset;
    }

    @Override
    public String getName() {
        return "Goto";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Goto(in.readUnsignedShort());
    }
}
