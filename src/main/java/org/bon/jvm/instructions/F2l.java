package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class F2l extends Instruction {

    @Override
    public String getName() {
        return "F2l";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        F2l i = new F2l();
        return i;
    }
}
