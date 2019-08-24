package org.bon.jvm;

import org.bon.jvm.attributes.Attribute;
import org.bon.jvm.attributes.Attributes;
import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class Field {

    private ConstPool constPool;
    private int accessFlags;
    private int nameIndex;
    private int descriptorIndex;

    private List<Attribute> attributes = new ArrayList<>();

    public Field(ByteBuffer byteBuffer, ConstPool constPool) {
        this.constPool = constPool;
        this.accessFlags = byteBuffer.getShort();
        this.nameIndex = byteBuffer.getShort();
        this.descriptorIndex = byteBuffer.getShort();

        int attributesCount = byteBuffer.getShort();
        for (int i = 0; i < attributesCount; i++) {
            attributes.add(Attribute.from(byteBuffer, constPool));
        }
    }


    public Attributes getAttributes() {
        return new Attributes(attributes);
    }
}