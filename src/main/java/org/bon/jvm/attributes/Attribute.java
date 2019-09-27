package org.bon.jvm.attributes;

import org.bon.Cast;
import org.bon.jvm.attributes.stackmap.StackMapTableAttribute;
import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7
 */

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

            case "StackMapTable": //50 6
                return new StackMapTableAttribute(byteBuffer, constPool);

            case "BootstrapMethods": //51.0 7
                return new BootstrapMethodsAttribute(byteBuffer, constPool);

            case "MethodParameters": //52 8
                return new MethodParametersAttribute(byteBuffer, constPool);

                /* TODO
                    RuntimeVisibleAnnotations	            49.0	5.0	§4.7.16
                    RuntimeInvisibleAnnotations	            49.0	5.0	§4.7.17
                    RuntimeVisibleParameterAnnotations	    49.0	5.0	§4.7.18
                    RuntimeInvisibleParameterAnnotations	49.0	5.0	§4.7.19
                    AnnotationDefault	                    49.0	5.0	§4.7.22
                    RuntimeVisibleTypeAnnotations	        52.0	8	§4.7.20
                    RuntimeInvisibleTypeAnnotations	        52.0	8	§4.7.21
                    Module                                  53.0	9	§4.7.25
                    ModulePackages                          53.0	9	§4.7.26
                    ModuleMainClass                         53.0	9	§4.7.27
                    NestHost                                55.0	11	§4.7.28
                    NestMembers                             55.0	11	§4.7.29
                 */


            default:
                return new SkipAttribute(byteBuffer, constPool);
        }
    }
}
