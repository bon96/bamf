package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Bipush extends Instruction {

    @Override
    public String getName() {
        return "Bipush";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        Bipush i = new Bipush();
        return i;
    }
}
