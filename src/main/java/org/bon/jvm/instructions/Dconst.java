package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Dconst extends Instruction {

    private double d;

    public Dconst(double d) {
        this.d = d;
    }

    @Override
    public String getName() {
        return "Dconst";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, double d) throws IOException {
        return new Dconst(d);
    }

}
