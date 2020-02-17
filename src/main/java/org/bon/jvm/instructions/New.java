package org.bon.jvm.instructions;

import org.bon.jvm.execution.MethodContext;
import org.bon.jvm.execution.Stack;
import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class New extends Instruction {

    private int index;

    public New(int index) {
        this.index = index;
    }

    @Override
    public void execute(MethodContext context, Stack stack) {

    }

    @Override
    public String getName() {
        return "New";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new New(in.readUnsignedShort());
    }
}
