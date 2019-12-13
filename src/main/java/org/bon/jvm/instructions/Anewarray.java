package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.types.ArrayInstruction;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Anewarray extends Instruction implements ArrayInstruction {

    private int index;

    public Anewarray(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Anewarray";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Anewarray(in.readUnsignedShort());
    }
}
