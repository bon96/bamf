package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Instanceof extends Instruction {

    private int index;

    public Instanceof(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Instanceof";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Instanceof(in.readUnsignedShort());
    }
}
