package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.FieldRefConstant;
import org.bon.jvm.execution.FieldRef;
import org.bon.jvm.execution.MethodContext;
import org.bon.jvm.execution.Stack;
import org.bon.jvm.util.Type;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Getstatic extends Instruction {

    private ConstPool constPool;
    private int index;

    public Getstatic(int index) {
        this.index = index;
    }

    public Getstatic(ConstPool constPool, int index) {
        this.constPool = constPool;
        this.index = index;
    }

    @Override
    public void execute(MethodContext context, Stack stack) {
        stack.push(new FieldRef(getTargetClass(), getTarget(), getTargetType()));
    }

    @Override
    public String getName() {
        return "Getstatic";
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

    @Override
    public String toString() {
        return getName() + " " + getTargetType() + " " + getTargetClass() + "." + getTarget();
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Getstatic(constPool, in.readUnsignedShort());
    }
}
