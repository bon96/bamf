package org.bon.jvm.constantpool.constants;

import org.bon.jvm.attributes.BootstrapMethodsAttribute;
import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.util.MethodDescriptor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.10
 */

public class InvokeDynamicConstant extends Constant implements MethodConstant {
    private ConstPool constPool;
    private int bootstrapMethodAttrIndex;
    private int nameAndTypeIndex;

    public BootstrapMethodsAttribute.BootstrapMethod getBootstrapMethod() {
        return constPool.getClassFile().getAttributes().ofType(BootstrapMethodsAttribute.class).getMethods().get(bootstrapMethodAttrIndex);
    }

    @Override
    public ClassConstant getClassConstant() {
        return ((ClassMemberConstant) getBootstrapMethod().getMethodHandle().getReference()).getClassConstant();
    }

    @Override
    public String getName() {
        return getNameAndType().getName();
    }

    @Override
    public MethodDescriptor getDescriptor() {
        return new MethodDescriptor(getNameAndType().getDescriptor());
    }

    @Override
    public NameAndTypeConstant getNameAndType() {
        return constPool.get(nameAndTypeIndex).cast();
    }

    //TODO finish bootstrapMethod array retrieval from constant pool

    public int getBootstrapMethodAttrIndex() {
        return bootstrapMethodAttrIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {
        out.writeByte(Constant.INVOKE_DYNAMIC);
        out.writeShort(bootstrapMethodAttrIndex);
        out.writeShort(nameAndTypeIndex);
    }

    public static InvokeDynamicConstant from(DataInputStream in, ConstPool constPool) throws IOException {
        InvokeDynamicConstant c = new InvokeDynamicConstant();
        c.constPool = constPool;
        c.bootstrapMethodAttrIndex = in.readUnsignedShort();
        c.nameAndTypeIndex = in.readUnsignedShort();
        return c;
    }
}
