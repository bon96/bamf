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

public class Invokeinterface extends Instruction implements InvokeInstruction {

    private int index;

    public Invokeinterface(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Invokeinterface";
    }

    @Override
    public int getMethodRefIndex() {
        return index;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        int index = in.readUnsignedShort();
        in.skipBytes(1); //invokeinterface always has one extra zero byte
        return new Invokeinterface(index);
    }
}
