package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.execution.MethodContext;
import org.bon.jvm.execution.Stack;
import org.bon.jvm.instructions.types.ConversionInstruction;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class F2d extends Instruction implements ConversionInstruction {

    @Override
    public void execute(MethodContext context, Stack stack) {

    }

    @Override
    public String getName() {
        return "F2d";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new F2d();
    }
}
