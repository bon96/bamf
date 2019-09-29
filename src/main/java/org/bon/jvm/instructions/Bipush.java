package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.types.ConstInstruction;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Bipush extends Instruction implements ConstInstruction<Byte> {

    private byte b;

    public Bipush(byte b) {
        this.b = b;
    }

    @Override
    public String getName() {
        return "Bipush";
    }

    @Override
    public Byte getValue() {
        return b;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Bipush(in.readByte());
    }
}
