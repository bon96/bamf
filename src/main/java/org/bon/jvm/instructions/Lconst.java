package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Lconst extends Instruction {

    private long l;

    public Lconst(long l) {
        this.l = l;
    }

    @Override
    public String getName() {
        return "Lconst";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {

    }

}