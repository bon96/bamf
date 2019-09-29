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

public class Ifeq extends Instruction implements BranchInstruction {

    private int offset;

    public Ifeq(int offset) {
        this.offset = offset;
    }

    @Override
    public String getName() {
        return "Ifeq";
    }

    @Override
    public int getTargetIndex() {
        return offset;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Ifeq(in.readUnsignedShort());
    }
}
