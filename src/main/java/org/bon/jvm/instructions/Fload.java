package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Fload extends Instruction {

    private int index;

    public Fload(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Fload";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        Fload i = new Fload(420);
        return i;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, int index) throws IOException {
        Fload i = new Fload(index);
        return i;
    }

}
