package org.bon.jvm.attributes;

import org.bon.Cast;
import org.bon.jvm.Method;
import org.bon.jvm.attributes.annotations.AnnotationDefaultAttribute;
import org.bon.jvm.attributes.annotations.RuntimeInvisibleAnnotationsAttribute;
import org.bon.jvm.attributes.annotations.RuntimeInvisibleParameterAnnotationsAttribute;
import org.bon.jvm.attributes.annotations.RuntimeInvisibleTypeAnnotationsAttribute;
import org.bon.jvm.attributes.annotations.RuntimeVisibleAnnotationsAttribute;
import org.bon.jvm.attributes.annotations.RuntimeVisibleParameterAnnotationsAttribute;
import org.bon.jvm.attributes.annotations.RuntimeVisibleTypeAnnotationsAttribute;
import org.bon.jvm.attributes.stackmap.StackMapTableAttribute;
import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7
 */

public abstract class Attribute implements Cast {

    public abstract void writeTo(DataOutputStream out, ConstPool constPool) throws IOException;

    public static Attribute from(DataInputStream in, ConstPool constPool) throws IOException {
        return from(in, constPool, null);
    }

    public static Attribute from(DataInputStream in, ConstPool constPool, Method method) throws IOException {
        int nameIndex = in.readUnsignedShort();
        int length = in.readInt();
        String attrName = constPool.get(nameIndex).toString();

        switch (attrName) {
            case "ConstantValue": //45.3 1.02
                return ConstantValueAttribute.from(in, constPool, length);

            case "Code": //45.3 1.02
                return CodeAttribute.from(in, constPool, method, length);

            case "Exceptions": //45.3 1.0.2
                return ExceptionsAttribute.from(in, constPool, length);

            case "InnerClasses": //45.3 1.1
                return InnerClassesAttribute.from(in, constPool, length);

            case "EnclosingMethod": // 49.0 5.0
                return EnclosingMethodAttribute.from(in, constPool, length);

            case "Synthetic": //45.3 1.1
                return SyntheticAttribute.from(in, constPool, length);

            case "Signature": //49.0 5.0
                return SignatureAttribute.from(in, constPool, length);

            case "SourceFile": //45.3 1.0.2
                return SourceFileAttribute.from(in, constPool, length);

            case "SourceDebugExtension": //49.0 5.0
                return SourceDebugExtensionAttribute.from(in, constPool, length);

            case "LineNumberTable": //45.3 1.0.2
                return LineNumberTableAttribute.from(in, constPool, length);

            case "LocalVariableTable": //45.3 1.0.2
                return LocalVariableTableAttribute.from(in, constPool, length);

            case "LocalVariableTypeTable": //49.0 5.0
                return LocalVariableTypeTableAttribute.from(in, constPool, length);

            case "Deprecated": //45.3 1.1
                return DeprecatedAttribute.from(in, constPool, length);

            case "StackMapTable": //50 6
                return StackMapTableAttribute.from(in, constPool, length);

            case "BootstrapMethods": //51.0 7
                return BootstrapMethodsAttribute.from(in, constPool, length);

            case "MethodParameters": //52 8
                return MethodParametersAttribute.from(in, constPool, length);

            case "AnnotationDefault": //49.0 5.0
                return AnnotationDefaultAttribute.from(in, constPool, length);

            case "RuntimeVisibleAnnotations": //49.0 5.0
                return RuntimeVisibleAnnotationsAttribute.from(in, constPool, length);

            case "RuntimeInvisibleAnnotations": //49 5.0
                return RuntimeInvisibleAnnotationsAttribute.from(in, constPool, length);

            case "RuntimeVisibleParameterAnnotations": //49.0 5.0
                return RuntimeVisibleParameterAnnotationsAttribute.from(in, constPool, length);

            case "RuntimeInvisibleParameterAnnotations": //49.0 5.0
                return RuntimeInvisibleParameterAnnotationsAttribute.from(in, constPool, length);

            case "RuntimeVisibleTypeAnnotations": //52.0 8
                return RuntimeVisibleTypeAnnotationsAttribute.from(in, constPool, length);

            case "RuntimeInvisibleTypeAnnotations": //52.0 8
                return RuntimeInvisibleTypeAnnotationsAttribute.from(in, constPool, length);

            case "Module": //53.0 9
                return ModuleAttribute.from(in, constPool, length);

            case "ModulePackages": //53.0 9
                return ModulePackagesAttribute.from(in, constPool, length);

            case "ModuleMainClass": //53.0 9
                return ModuleMainClassAttribute.from(in, constPool, length);

            case "NestHost": //55.0 11
                return NestHostAttribute.from(in, constPool, length);

            case "NestMembers": //55.0 11
                return NestMembersAttribute.from(in, constPool, length);

            default:
                in.skipBytes(length);
                System.err.println("Skipping unknown attribute " + attrName + " (" + length + ")");
                return null;
        }
    }
}
