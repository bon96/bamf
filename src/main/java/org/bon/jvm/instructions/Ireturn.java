package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.types.ReturnInstruction;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Ireturn extends Instruction implements ReturnInstruction {

    @Override
    public String getName() {
        return "Ireturn";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Ireturn();
    }
}
