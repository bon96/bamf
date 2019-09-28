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

    public Field() {
    }


    public Attributes getAttributes() {
        return new Attributes(attributes);
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
