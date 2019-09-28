package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Fneg extends Instruction {

    @Override
    public String getName() {
        return "Fneg";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        Fneg i = new Fneg();
        return i;
    }
}
