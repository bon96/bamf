package org.bon.jvm.attributes;

import org.bon.Cast;
import org.bon.jvm.attributes.stackmap.StackMapTableAttribute;
import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7
 */

public abstract class Attribute implements Cast {

    protected ConstPool constPool;
    protected int nameIndex;
    protected int length;

    public String getName() {
        return constPool.get(nameIndex).toString();
    }

    public int getLength() {
        return length;
    }

    public int getAttributeNameIndex() {
        return nameIndex;
    }

    public static Attribute from(DataInputStream in, ConstPool constPool) throws IOException {
        int nameIndex = in.readUnsignedShort();
        int length = in.readInt();
        String attrName = constPool.get(nameIndex).toString();

        switch (attrName) {
            case "ConstantValue": //45.3 1.02
                return ConstantValueAttribute.from(in, constPool, nameIndex, length);

            case "Code": //45.3 1.02
                return CodeAttribute.from(in, constPool, nameIndex, length);

            case "Exceptions": //45.3 1.0.2
                return ExceptionsAttribute.from(in, constPool, nameIndex, length);

            case "InnerClasses": //45.3 1.1
                return InnerClassesAttribute.from(in, constPool, nameIndex, length);

            case "EnclosingMethod": // 49.0 5.0
                return EnclosingMethodAttribute.from(in, constPool, nameIndex, length);

            case "Synthetic": //45.3 1.1
                return SyntheticAttribute.from(in, constPool, nameIndex, length);

            case "Signature": //49.0 5.0
                return SignatureAttribute.from(in, constPool, nameIndex, length);

            case "SourceFile": //45.3 1.0.2
                return SourceFileAttribute.from(in, constPool, nameIndex, length);

            case "SourceDebugExtension": //49.0 5.0
                return SourceDebugExtensionAttribute.from(in, constPool, nameIndex, length);

            case "LineNumberTable": //45.3 1.0.2
                return LineNumberTableAttribute.from(in, constPool, nameIndex, length);

            case "LocalVariableTable": //45.3 1.0.2
                return LocalVariableTableAttribute.from(in, constPool, nameIndex, length);

            case "LocalVariableTypeTable": //49.0 5.0
                return LocalVariableTypeTableAttribute.from(in, constPool, nameIndex, length);

            case "Deprecated": //45.3 1.1
                return DeprecatedAttribute.from(in, constPool, nameIndex, length);

            case "StackMapTable": //50 6
                return StackMapTableAttribute.from(in, constPool, nameIndex, length);

            case "BootstrapMethods": //51.0 7
                return BootstrapMethodsAttribute.from(in, constPool, nameIndex, length);

            case "MethodParameters": //52 8
                return MethodParametersAttribute.from(in, constPool, nameIndex, length);

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
                return new SkipAttribute(in, constPool, nameIndex, length);
        }
    }
}
