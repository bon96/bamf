package org.bon.jvm.instructions;

import org.bon.jvm.execution.MethodContext;
import org.bon.jvm.execution.Stack;
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

public class Putstatic extends Instruction {

    private ConstPool constPool;
    private int index;

    public Putstatic(int index) {
        this.index = index;
    }

    public Putstatic(ConstPool constPool, int index) {
        this.constPool = constPool;
        this.index = index;
    }

    public FieldRefConstant getFieldRef() {
        return constPool.get(index).cast();
    }

    public String getTargetClass() {
        return getFieldRef().getClassConstant().getName();
    }

    public String getTarget() {
        return getFieldRef().getNameAndType().getName();
    }

    public Type getType() {
        return new Type(getFieldRef().getNameAndType().getDescriptor());
    }

    @Override
    public void execute(MethodContext context, Stack stack) {

    }

    @Override
    public String getName() {
        return "Putstatic";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        return new Putstatic(constPool, in.readUnsignedShort());
    }
}
