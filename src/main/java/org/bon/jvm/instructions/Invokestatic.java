package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Invokestatic extends Instruction {

    private int index;

    public Invokestatic(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Invokestatic";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Invokestatic(in.readUnsignedShort());
    }
}
