package org.bon.jvm.instructions;

import org.bon.api.Method;
import org.bon.jvm.execution.MethodContext;
import org.bon.jvm.execution.Stack;
import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.MethodConstant;
import org.bon.jvm.instructions.types.InvokeInstruction;
import org.bon.jvm.util.MethodDescriptor;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Invokedynamic extends Instruction implements InvokeInstruction {

    private String target;
    private String targetClass;
    private MethodDescriptor targetDescriptor;

    //TODO get bootstrap method

    public Invokedynamic(Method method) {
        target = method.getName();
        targetClass = method.getOwner().getName();
        targetDescriptor = method.getDescriptor();
    }

    public Invokedynamic(MethodConstant constant) {
        target = constant.getNameAndType().getName();
        targetDescriptor = new MethodDescriptor(constant.getNameAndType().getDescriptor());
    }

    @Override
    public void execute(MethodContext context, Stack stack) {

    }

    @Override
    public String getName() {
        return "Invokedynamic";
    }

    @Override
    public String getTargetClass() {
        return targetClass;
    }

    @Override
    public String getTarget() {
        return target;
    }

    @Override
    public MethodDescriptor getTargetDescriptor() {
        return targetDescriptor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invokedynamic invoke = (Invokedynamic) o;
        return Objects.equals(getTargetClass(), invoke.getTargetClass()) &&
                Objects.equals(getTarget(), invoke.getTarget())
                && Objects.equals(getTargetDescriptor(), invoke.getTargetDescriptor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTargetClass(), getTarget(), getTargetDescriptor());
    }

    @Override
    public String toString() {
        return getName() + " " + getTargetClass() + "." + getTarget() + getTargetDescriptor();
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        int index = in.readUnsignedShort();
        in.skipBytes(2); //invokedynamic always has two extra zero bytes
        MethodConstant constant = constPool.get(index).cast();
        return new Invokedynamic(constant);
    }
}
