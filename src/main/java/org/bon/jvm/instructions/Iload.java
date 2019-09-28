package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Iload extends Instruction {

    private int index;

    public Iload(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Iload";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        Iload i = new Iload(420);
        return i;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, int index) throws IOException {
        Iload i = new Iload(index);
        return i;
    }

}
