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

public class Athrow extends Instruction {

    @Override
    public void execute(MethodContext context, Stack stack) {

    }

    @Override
    public String getName() {
        return "Athrow";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Athrow();
    }
}
