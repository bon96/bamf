package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Dup2_x2 extends Instruction {

    @Override
    public String getName() {
        return "Dup2_x2";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        Dup2_x2 i = new Dup2_x2();
        return i;
    }
}
