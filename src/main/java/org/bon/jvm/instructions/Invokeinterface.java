package org.bon.jvm.instructions;

import org.bon.api.util.MethodDescriptor;
import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.MethodRefConstant;
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

    private ConstPool constPool;
    private int index;

    public Invokeinterface(int index) {
        this.index = index;
    }

    public Invokeinterface(ConstPool constPool, int index) {
        this.constPool = constPool;
        this.index = index;
    }

    @Override
    public String getName() {
        return "Invokeinterface";
    }

    @Override
    public int getMethodRefIndex() {
        return index;
    }

    @Override
    public String getTargetClass() {
        return getMethodRef().getConstClass().getName();
    }

    @Override
    public String getTarget() {
        return getMethodRef().getNameAndType().getName();
    }

    @Override
    public MethodDescriptor getTargetDescriptor() {
        return new MethodDescriptor(getMethodRef().getNameAndType().getDescriptor());
    }

    private MethodRefConstant getMethodRef() {
        return constPool.get(getMethodRefIndex()).cast();
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
        return new Invokeinterface(constPool, index);
    }
}
