package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Dload extends Instruction {

    private int index;

    public Dload(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Dload";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        Dload i = new Dload(420);
        return i;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, int index) throws IOException {
        Dload i = new Dload(index);
        return i;
    }

}
