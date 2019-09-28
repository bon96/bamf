package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class I2d extends Instruction {

    @Override
    public String getName() {
        return "I2d";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        I2d i = new I2d();
        return i;
    }
}
