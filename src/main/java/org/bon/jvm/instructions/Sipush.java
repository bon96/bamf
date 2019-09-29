package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Sipush extends Instruction {

    private int value;

    public Sipush(int value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return "Sipush";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Sipush(in.readShort());
    }
}
