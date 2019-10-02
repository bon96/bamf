package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.types.ConstInstruction;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Bipush extends Instruction implements ConstInstruction<Byte> {

    private byte b;

    public Bipush(byte b) {
        this.b = b;
    }

    @Override
    public String getName() {
        return "Bipush";
    }

    @Override
    public Byte getValue() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bipush bipush = (Bipush) o;
        return b == bipush.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(b);
    }

    @Override
    public String toString() {
        return getName() + " " + b;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Bipush(in.readByte());
    }
}
