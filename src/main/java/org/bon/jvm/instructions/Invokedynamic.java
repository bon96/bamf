package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.types.InvokeInstruction;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Invokedynamic extends Instruction implements InvokeInstruction {

    private int index;

    public Invokedynamic(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Invokedynamic";
    }

    @Override
    public int getMethodRefIndex() {
        return index;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        int index = in.readUnsignedShort();
        in.skipBytes(2); //invokedynamic always has two extra zero bytes
        return new Invokedynamic(index);
    }
}
