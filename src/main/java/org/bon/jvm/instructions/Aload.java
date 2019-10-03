package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.types.LoadInstruction;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Aload extends Instruction implements LoadInstruction {

    private int index;

    public Aload(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Aload";
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aload aload = (Aload) o;
        return getIndex() == aload.getIndex();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIndex());
    }

    @Override
    public String toString() {
        return getName() + " " + index;
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, boolean wide) throws IOException {
        if (wide) {
            return new Aload(in.readUnsignedShort());
        } else {
            return new Aload(in.readUnsignedByte());
        }
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, int index) throws IOException {
        return new Aload(index);
    }
}
