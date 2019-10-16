package org.bon.jvm.instructions;

import org.bon.api.Method;
import org.bon.api.util.MethodDescriptor;
import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.InterfaceMethodRefConstant;
import org.bon.jvm.instructions.types.InvokeInstruction;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Invokeinterface extends Instruction implements InvokeInstruction {

    private String target;
    private String targetClass;
    private MethodDescriptor targetDescriptor;

    public Invokeinterface(Method method) {
        target = method.getName();
        targetClass = method.getOwner().getName();
        targetDescriptor = method.getDescriptor();
    }

    public Invokeinterface(InterfaceMethodRefConstant methodRef) {
        target = methodRef.getNameAndType().getName();
        targetClass = methodRef.getConstClass().getName();
        targetDescriptor = new MethodDescriptor(methodRef.getNameAndType().getDescriptor());
    }

    @Override
    public String getName() {
        return "Invokeinterface";
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
        Invokeinterface invoke = (Invokeinterface) o;
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
        in.skipBytes(1); //invokeinterface always has one extra zero byte
        InterfaceMethodRefConstant methodRef = constPool.get(index).cast();
        return new Invokeinterface(methodRef);
    }
}
