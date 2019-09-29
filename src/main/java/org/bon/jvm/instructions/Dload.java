package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.types.LoadInstruction;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Dload extends Instruction implements LoadInstruction {

    private int index;

    public Dload(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Dload";
    }

    @Override
    public int getIndex() {
        return index;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, boolean wide) throws IOException {
        if (wide) {
            return new Dload(in.readUnsignedShort());
        } else {
            return new Dload(in.readUnsignedByte());
        }
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, int index) throws IOException {
        return new Dload(index);
    }

}
