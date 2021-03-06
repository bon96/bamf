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

    public boolean isAccSynchroniced() {
        return (accessFlags & 0x0020) != 0;
    }

    public boolean isAccBridge() {
        return (accessFlags & 0x0040) != 0;
    }

    public boolean isAccVarArgs() {
        return (accessFlags & 0x0080) != 0;
    }

    public boolean isAccNative() {
        return (accessFlags & 0x0100) != 0;
    }

    public boolean isAccAbstract() {
        return (accessFlags & 0x0400) != 0;
    }

    public boolean isAccStrict() {
        return (accessFlags & 0x0800) != 0;
    }

    public boolean isAccSynthetic() {
        return (accessFlags & 0x1000) != 0;
    }

    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {
        out.writeShort(accessFlags);
        out.writeShort(nameIndex);
        out.writeShort(descriptorIndex);

        out.writeShort(attributes.size());
        for (Attribute attr : attributes) {
            attr.writeTo(out, constPool);
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
