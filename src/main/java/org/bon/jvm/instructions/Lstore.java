package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Lstore extends Instruction {

    private long l;

    public Lstore(long l) {
        this.l = l;
    }

    @Override
    public String getName() {
        return "Lstore";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        Lstore i = new Lstore(420);
        return i;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, long l) throws IOException {
        Lstore i = new Lstore(l);
        return i;
    }

}
