package org.bon.jvm.attributes;

import org.bon.Cast;
import org.bon.jvm.attributes.stackmap.StackMapTableAttribute;
import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;


public abstract class Attribute implements Cast {

    ConstPool constPool;

    private int attributeNameIndex;
    private int attributeLength;

    public Attribute(ByteBuffer byteBuffer, ConstPool constPool) {
        this.constPool = constPool;
        attributeNameIndex = byteBuffer.getShort();
        attributeLength = byteBuffer.getInt();
    }

    public String getName() {
        return constPool.get(attributeNameIndex).toString();
    }

    public int getLength() {
        return attributeLength;
    }

    public int getAttributeNameIndex() {
        return attributeNameIndex;
    }

    public static Attribute from(ByteBuffer byteBuffer, ConstPool constPool) {
        String attrName = constPool.get(byteBuffer.getShort(byteBuffer.position())).toString();

        switch (attrName) {
            case "ConstantValue": //45.3 1.02
                return new ConstantValueAttribute(byteBuffer, constPool);

            case "Code": //45.3 1.02
                return new CodeAttribute(byteBuffer, constPool);

            case "Exceptions": //45.3 1.0.2
                return new ExceptionsAttribute(byteBuffer, constPool);

            case "InnerClasses": //45.3 1.1
                return new InnerClassesAttribute(byteBuffer, constPool);

            case "EnclosingMethod": // 49.0 5.0
                return new EnclosingMethodAttribute(byteBuffer, constPool);

            case "Synthetic": //45.3 1.1
                return new SyntheticAttribute(byteBuffer, constPool);

            case "Signature": //49.0 5.0
                return new SignatureAttribute(byteBuffer, constPool);

            case "SourceFile": //45.3 1.0.2
                return new SourceFileAttribute(byteBuffer, constPool);

            case "SourceDebugExtension": //49.0 5.0
                return new SourceDebugExtensionAttribute(byteBuffer, constPool);

            case "LineNumberTable": //45.3 1.0.2
                return new LineNumberTableAttribute(byteBuffer, constPool);

            case "LocalVariableTable": //45.3 1.0.2
                return new LocalVariableTableAttribute(byteBuffer, constPool);

            case "LocalVariableTypeTable": //49.0 5.0
                return new LocalVariableTypeTableAttribute(byteBuffer, constPool);

            case "Deprecated": //45.3 1.1
                return new DeprecatedAttribute(byteBuffer, constPool);

            case "StackMapTable":
                return new StackMapTableAttribute(byteBuffer, constPool);
            //  return new SkipAttribute(byteBuffer, constPool);

            default:
                return new SkipAttribute(byteBuffer, constPool);
        }
    }
}
