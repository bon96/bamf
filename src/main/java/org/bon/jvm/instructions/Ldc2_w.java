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

public class Ldc2_w extends Instruction implements ConstInstruction {

    private int index;

    public Ldc2_w(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Ldc2_w";
    }

    @Override
    public Object getValue() {
        throw new UnsupportedOperationException("not yet implemented");
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Ldc2_w(in.readUnsignedShort());
    }
}
