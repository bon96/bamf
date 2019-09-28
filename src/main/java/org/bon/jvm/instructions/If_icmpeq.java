package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class If_icmpeq extends Instruction {

    private int offset;

    public If_icmpeq(int offset) {
        this.offset = offset;
    }

    @Override
    public String getName() {
        return "If_icmpeq";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new If_icmpeq(in.readUnsignedShort());
    }
}
