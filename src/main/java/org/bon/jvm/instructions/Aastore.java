package org.bon.jvm.instructions;

import org.bon.jvm.execution.MethodContext;
import org.bon.jvm.execution.Stack;
import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.types.ArrayInstruction;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Aastore extends Instruction implements ArrayInstruction {

    @Override
    public void execute(MethodContext context, Stack stack) {
        Object[] array = stack.pop(Object[].class);
        Integer index = stack.pop(Integer.class);
        Object value = stack.pop();

        array[index] = value;
    }

    @Override
    public String getName() {
        return "Aastore";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Aastore();
    }
}
