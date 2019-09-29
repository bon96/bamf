package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Lload extends Instruction {

    private int index;

    public Lload(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Lload";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, boolean wide) throws IOException {
        if (wide) {
            return new Lload(in.readUnsignedShort());
        } else {
            return new Lload(in.readUnsignedByte());
        }
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, int index) throws IOException {
        return new Lload(index);
    }

}
