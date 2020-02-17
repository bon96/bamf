package org.bon.jvm.instructions;

import org.bon.jvm.execution.MethodContext;
import org.bon.jvm.execution.Stack;
import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

//TODO figure out getters
public class Iinc extends Instruction {

    private int index;
    private int constant;

    public Iinc(int index, int constant) {
        this.index = index;
        this.constant = constant;
    }

    @Override
    public void execute(MethodContext context, Stack stack) {

    }

    @Override
    public String getName() {
        return "Iinc";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, boolean wide) throws IOException {
        if (wide) {
            return new Iinc(in.readUnsignedShort(), in.readShort());
        } else {
            return new Iinc(in.readUnsignedByte(), in.readByte());
        }
    }
}
