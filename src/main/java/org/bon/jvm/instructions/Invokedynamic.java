package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Invokedynamic extends Instruction {

    private int index;

    public Invokedynamic(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Invokedynamic";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        int index = in.readUnsignedShort();
        in.skipBytes(2); //invokedynamic always has two extra zero bytes
        return new Invokedynamic(index);
    }
}
