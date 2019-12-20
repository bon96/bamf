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

    public AnnotationDefaultAttribute(Annotation.Element<T> element) {
        this.element = element;
    }

    public Annotation.Element<T> getElement() {
        return element;
    }

    public void setElement(Annotation.Element<T> element) {
        this.element = element;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static AnnotationDefaultAttribute<?> from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        return new AnnotationDefaultAttribute<>(Annotation.Element.from(in, constPool, false));
    }
}
