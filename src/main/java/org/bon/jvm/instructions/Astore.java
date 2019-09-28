package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Astore extends Instruction {

    private int index;

    public Astore(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Astore";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        Astore i = new Astore(420);
        return i;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, int index) throws IOException {
        Astore i = new Astore(index);
        return i;
    }

}
