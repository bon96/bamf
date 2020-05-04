package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.execution.MethodContext;
import org.bon.jvm.execution.Stack;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Ret extends Instruction {

    private int index;

    public Ret(int index) {
        this.index = index;
    }

    @Override
    public void execute(MethodContext context, Stack stack) {

    }

    @Override
    public String getName() {
        return "Ret";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, boolean wide) throws IOException {
        if (wide) {
            return new Ret(in.readUnsignedShort());
        } else {
            return new Ret(in.readUnsignedByte());
        }
    }
}
