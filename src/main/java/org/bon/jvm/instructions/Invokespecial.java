package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Invokespecial extends Instruction {

    private int index;

    public Invokespecial(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Invokespecial";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Invokespecial(in.readUnsignedShort());
    }
}
