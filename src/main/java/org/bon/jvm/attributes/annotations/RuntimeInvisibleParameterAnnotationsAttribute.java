package org.bon.jvm.attributes.annotations;

/**
 * Tommi
 * Date: 13/12/2019
 * Time: 22.16
 */

import org.bon.jvm.attributes.Attribute;
import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.19
 */

//TODO finish RuntimeInvisibleParameterAnnotationsAttribute
public class RuntimeInvisibleParameterAnnotationsAttribute extends Attribute {

    private List<List<Annotation>> parameters = new ArrayList<>();

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }

    public static RuntimeInvisibleParameterAnnotationsAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        RuntimeInvisibleParameterAnnotationsAttribute a = new RuntimeInvisibleParameterAnnotationsAttribute();
        a.constPool = constPool;
        a.nameIndex = nameIndex;
        a.length = length;

        int parametersCount = in.readUnsignedByte();
        for (int i = 0; i < parametersCount; i++) {
            List<Annotation> annotations = new ArrayList<>();
            int annotationsCount = in.readUnsignedShort();
            for (int j = 0; j < annotationsCount; j++) {
                annotations.add(Annotation.from(in, constPool));
            }
            a.parameters.add(annotations);
        }
        return a;
    }
}
