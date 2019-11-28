package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

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

    @Override
    public ClassConstant getConstClass() {
        throw new UnsupportedOperationException("InvokeDynamic class retrieval is not yet supported");
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
    public void writeTo(DataOutputStream out) throws IOException {
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
