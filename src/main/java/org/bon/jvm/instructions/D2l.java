package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.types.ConversionInstruction;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class D2l extends Instruction implements ConversionInstruction {

    @Override
    public String getName() {
        return "D2l";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new D2l();
    }
}
