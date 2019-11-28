package org.bon.jvm;

import org.bon.jvm.attributes.Attribute;
import org.bon.jvm.attributes.Attributes;
import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Field {

    private ConstPool constPool;
    private int accessFlags;
    private int nameIndex;
    private int descriptorIndex;

    private List<Attribute> attributes = new ArrayList<>();

    public Attributes getAttributes() {
        return new Attributes(attributes);
    }

    public int getAccessFlags() {
        return accessFlags;
    }

    public String getName() {
        return constPool.get(nameIndex).toString();
    }

    public String getDescriptor() {
        return constPool.get(descriptorIndex).toString();
    }

    public boolean isAccPublic() {
        return (accessFlags & 0x0001) != 0;
    }

    public boolean isAccPrivate() {
        return (accessFlags & 0x0002) != 0;
    }

    public boolean isAccProtected() {
        return (accessFlags & 0x0004) != 0;
    }

    public boolean isAccStatic() {
        return (accessFlags & 0x0008) != 0;
    }

    public boolean isAccFinal() {
        return (accessFlags & 0x0010) != 0;
    }

    public boolean isAccVolatile() {
        return (accessFlags & 0x0040) != 0;
    }

    public boolean isAccTransient() {
        return (accessFlags & 0x0080) != 0;
    }

    public boolean isAccSynthetic() {
        return (accessFlags & 0x1000) != 0;
    }

    public boolean isAccEnum() {
        return (accessFlags & 0x4000) != 0;
    }


    public void writeTo(DataOutputStream out) throws IOException {
        out.writeShort(accessFlags);
        out.writeShort(nameIndex);
        out.writeShort(descriptorIndex);

        out.writeShort(attributes.size());
        for (Attribute attr : attributes) {
            attr.writeTo(out);
        }
    }

    public static Field from(DataInputStream in, ConstPool constPool) throws IOException {
        Field field = new Field();

        field.constPool = constPool;
        field.accessFlags = in.readUnsignedShort();
        field.nameIndex = in.readUnsignedShort();
        field.descriptorIndex = in.readUnsignedShort();

        int attributesCount = in.readUnsignedShort();
        for (int i = 0; i < attributesCount; i++) {
            field.attributes.add(Attribute.from(in, constPool));
        }
        return field;
    }


}
