package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Ldc_w extends Instruction {

    @Override
    public String getName() {
        return "Ldc_w";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        Ldc_w i = new Ldc_w();
        return i;
    }
}
