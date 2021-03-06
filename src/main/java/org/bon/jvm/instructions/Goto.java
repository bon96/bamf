package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.execution.MethodContext;
import org.bon.jvm.execution.Stack;
import org.bon.jvm.instructions.types.JumpInstruction;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Goto extends Instruction implements JumpInstruction {

    private int jumpOffset;
    private int jumpTarget;

    public Goto(int jumpOffset) {
        this.jumpOffset = jumpOffset;
    }

    public int getJumpOffset() {
        return jumpOffset;
    }

    public int getJumpTarget() {
        return jumpTarget;
    }

    public void setJumpTarget(int targetOffset) {
        this.jumpTarget = targetOffset;
    }

    @Override
    public void execute(MethodContext context, Stack stack) {

    }

    @Override
    public String getName() {
        return "Goto";
    }

    @Override
    public String toString() {
        return getName() + " " + jumpTarget;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Goto(in.readShort());
    }
}
