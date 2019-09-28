package org.bon.jvm;

import org.bon.jvm.attributes.Attribute;
import org.bon.jvm.attributes.Attributes;
import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Method {

    private ConstPool constPool;
    private int accessFlags;
    private int nameIndex;
    private int descriptorIndex;

    private List<Attribute> attributes = new ArrayList<>();


    public Method() {
    }

    public Attributes getAttributes() {
        return new Attributes(attributes);
    }

    public String getName() {
        return constPool.get(nameIndex).toString();
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

    public static Method from(DataInputStream in, ConstPool constPool) throws IOException {
        Method method = new Method();

        method.constPool = constPool;
        method.accessFlags = in.readUnsignedShort();
        method.nameIndex = in.readUnsignedShort();
        method.descriptorIndex = in.readUnsignedShort();

        int attributeCount = in.readUnsignedShort();
        for (int i = 0; i < attributeCount; i++) {
            method.attributes.add(Attribute.from(in, constPool));
        }

        return method;
    }
}
