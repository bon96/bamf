package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.util.Type;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.2
 */

public class FieldRefConstant extends Constant implements ClassMemberConstant {

    private ConstPool constPool;
    private int classIndex;
    private int nameAndTypeIndex;

    @Override
    public ClassConstant getClassConstant() {
        return constPool.get(classIndex).cast();
    }

    public String getName() {
        return getNameAndType().getName();
    }

    public Type getType() {
        return new Type(getNameAndType().getDescriptor());
    }

    public NameAndTypeConstant getNameAndType() {
        return constPool.get(nameAndTypeIndex).cast();
    }

    public int getClassIndex() {
        return classIndex;
    }

    public int getNameAndTypeIndex() {
        return nameAndTypeIndex;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {
        out.writeByte(Constant.FIELD_REF);
        out.writeShort(classIndex);
        out.writeShort(nameAndTypeIndex);
    }


    public static FieldRefConstant from(DataInputStream in, ConstPool constPool) throws IOException {
        FieldRefConstant c = new FieldRefConstant();
        c.constPool = constPool;
        c.classIndex = in.readUnsignedShort();
        c.nameAndTypeIndex = in.readUnsignedShort();
        return c;
    }
}
