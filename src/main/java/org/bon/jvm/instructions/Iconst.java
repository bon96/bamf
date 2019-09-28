package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Iconst extends Instruction {

    private int i;

    public Iconst(int i) {
        this.i = i;
    }

    @Override
    public String getName() {
        return "Iconst";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, int i) throws IOException {
        Iconst ins = new Iconst(i);
        return ins;
    }

}
