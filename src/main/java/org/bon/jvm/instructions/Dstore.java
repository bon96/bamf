package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Dstore extends Instruction {

    private double d;

    public Dstore(double d) {
        this.d = d;
    }

    @Override
    public String getName() {
        return "Dstore";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        Dstore i = new Dstore(420);
        return i;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, double d) throws IOException {
        Dstore i = new Dstore(d);
        return i;
    }

}
