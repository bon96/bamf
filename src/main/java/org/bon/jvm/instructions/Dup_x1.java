package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Dup_x1 extends Instruction {

    @Override
    public String getName() {
        return "Dup_x1";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        Dup_x1 i = new Dup_x1();
        return i;
    }
}
