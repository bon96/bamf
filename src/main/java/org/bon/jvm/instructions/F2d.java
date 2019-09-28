package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class F2d extends Instruction {

    @Override
    public String getName() {
        return "F2d";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        F2d i = new F2d();
        return i;
    }
}
