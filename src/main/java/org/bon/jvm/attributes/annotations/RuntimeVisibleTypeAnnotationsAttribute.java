package org.bon.jvm.attributes.annotations;

/**
 * Tommi
 * Date: 13/12/2019
 * Time: 22.17
 */

import org.bon.jvm.attributes.Attribute;
import org.bon.jvm.attributes.annotations.typeannotation.TypeAnnotation;
import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.20
 */


public class RuntimeVisibleTypeAnnotationsAttribute extends Attribute {

    private List<TypeAnnotation> annotations = new ArrayList<>();

    public List<TypeAnnotation> getAnnotations() {
        return annotations;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }

    public static RuntimeVisibleTypeAnnotationsAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        RuntimeVisibleTypeAnnotationsAttribute a = new RuntimeVisibleTypeAnnotationsAttribute();
        a.nameIndex = nameIndex;
        a.length = length;

        int annotationsCount = in.readUnsignedShort();
        for (int i = 0; i < annotationsCount; i++) {
            a.annotations.add(TypeAnnotation.from(in, constPool));
        }
        return a;
    }
}
