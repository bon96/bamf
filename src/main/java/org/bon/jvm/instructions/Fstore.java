package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Fstore extends Instruction {

    private float f;

    public Fstore(float f) {
        this.f = f;
    }

    @Override
    public String getName() {
        return "Fstore";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, boolean wide) throws IOException {
        if (wide) {
            return new Fstore(in.readUnsignedShort());
        } else {
            return new Fstore(in.readUnsignedByte());
        }
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, float f) throws IOException {
        Fstore i = new Fstore(f);
        return i;
    }
}
