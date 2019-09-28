package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Getstatic extends Instruction {

    private int index;

    public Getstatic(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Getstatic";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Getstatic(in.readUnsignedShort());
    }
}
