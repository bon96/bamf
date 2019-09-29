package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.types.StoreInstruction;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Istore extends Instruction implements StoreInstruction {

    private int index;

    public Istore(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Istore";
    }

    @Override
    public int getIndex() {
        return index;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, boolean wide) throws IOException {
        if (wide) {
            return new Istore(in.readUnsignedShort());
        } else {
            return new Istore(in.readUnsignedByte());
        }
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, int index) throws IOException {
        return new Istore(index);
    }
}
