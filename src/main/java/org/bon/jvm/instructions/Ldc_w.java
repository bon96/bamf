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

    private int index;

    public Ldc_w(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Ldc_w";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Ldc_w(in.readUnsignedShort());
    }
}
