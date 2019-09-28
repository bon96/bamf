package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Istore extends Instruction {

    private int i;

    public Istore(int i) {
        this.i = i;
    }

    @Override
    public String getName() {
        return "Istore";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        Istore ins = new Istore(420);
        return ins;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, int i) throws IOException {
        Istore ins = new Istore(i);
        return ins;
    }

}
