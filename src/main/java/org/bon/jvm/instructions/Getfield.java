package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.FieldRefConstant;
import org.bon.jvm.util.Type;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Getfield extends Instruction {

    private ConstPool constPool;
    private int index;

    public Getfield(int index) {
        this.index = index;
    }

    public Getfield(ConstPool constPool, int index) {
        this.constPool = constPool;
        this.index = index;
    }

    @Override
    public String getName() {
        return "Getfield";
    }

    public String getTarget() {
        return getTargetFieldRef().getNameAndType().getName();
    }

    public String getTargetClass() {
        return getTargetFieldRef().getClassConstant().getName();
    }

    public Type getTargetType() {
        return new Type(getTargetFieldRef().getNameAndType().getDescriptor());
    }

    private FieldRefConstant getTargetFieldRef() {
        return constPool.get(index).cast();
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Getfield(constPool, in.readUnsignedShort());
    }
}
