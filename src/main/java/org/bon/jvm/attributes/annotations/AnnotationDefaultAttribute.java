package org.bon.jvm.attributes.annotations;

import org.bon.jvm.attributes.Attribute;
import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 11/10/2019
 * Time: 21.30
 */

public class AnnotationDefaultAttribute<T> extends Attribute {

    private Annotation.Element<T> element;

    public Annotation.Element<T> getElement() {
        return element;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }

    public static AnnotationDefaultAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        AnnotationDefaultAttribute a = new AnnotationDefaultAttribute();
        a.constPool = constPool;
        a.nameIndex = nameIndex;
        a.length = length;

        a.element = Annotation.Element.from(in, constPool, false);
        return a;
    }
}
