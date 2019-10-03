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

public class Ldc extends Instruction implements ConstInstruction {

    private Object object;

    public Ldc(Object object) {
        this.object = object;
    }

    @Override
    public String getName() {
        return "Ldc";
    }

    @Override
    public Object getValue() {
        return object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ldc ldc = (Ldc) o;
        return object.equals(ldc.object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(object);
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Ldc(constPool.get(in.readUnsignedByte()));
    }
}
