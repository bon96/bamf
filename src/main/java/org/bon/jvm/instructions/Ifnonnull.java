package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.types.BranchInstruction;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Ifnonnull extends Instruction implements BranchInstruction {

    private int offset;

    public Ifnonnull(int offset) {
        this.offset = offset;
    }

    @Override
    public String getName() {
        return "Ifnonnull";
    }

    @Override
    public int getTargetIndex() {
        return offset;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Ifnonnull(in.readUnsignedShort());
    }
}
