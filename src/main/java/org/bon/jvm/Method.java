package org.bon.jvm;

import org.bon.jvm.attributes.Attribute;
import org.bon.jvm.attributes.Attributes;
import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class Method {

    private ConstPool constPool;
    private int accessFlags;
    private int nameIndex;
    private int descriptorIndex;

    private List<Attribute> attributes = new ArrayList<>();


    public Method(ByteBuffer byteBuffer, ConstPool constPool) {
        this.constPool = constPool;
        accessFlags = byteBuffer.getShort();
        nameIndex = byteBuffer.getShort();
        descriptorIndex = byteBuffer.getShort();

        int attributeCount = byteBuffer.getShort();
        for (int i = 0; i < attributeCount; i++) {
            attributes.add(Attribute.from(byteBuffer, constPool));
        }
    }

    public Attributes getAttributes() {
        return new Attributes(attributes);
    }

    public String getName() {
        return constPool.get(nameIndex).toString();
    }
}
