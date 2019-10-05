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

public class Iflt extends Instruction implements BranchInstruction {

    private int offset;
    private int target;

    public Iflt(int offset) {
        this.offset = offset;
    }

    @Override
    public String getName() {
        return "Iflt";
    }

    @Override
    public int getJumpOffset() {
        return offset;
    }

    @Override
    public int getJumpTarget() {
        return target;
    }

    @Override
    public void setJumpTarget(int target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return getName() + " " + target;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Iflt(in.readShort());
    }
}
