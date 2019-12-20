package org.bon.jvm.attributes.annotations;

import org.bon.jvm.attributes.Attribute;
import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tommi
 * Date: 11/10/2019
 * Time: 21.20
 */

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.17
 */

public class RuntimeInvisibleAnnotationsAttribute extends Attribute {

    private List<Annotation> annotations;

    public RuntimeInvisibleAnnotationsAttribute() {
        annotations = new ArrayList<>();
    }

    public RuntimeInvisibleAnnotationsAttribute(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static RuntimeInvisibleAnnotationsAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        RuntimeInvisibleAnnotationsAttribute a = new RuntimeInvisibleAnnotationsAttribute();

        int annotationsCount = in.readUnsignedShort();
        for (int i = 0; i < annotationsCount; i++) {
            a.annotations.add(Annotation.from(in, constPool));
        }
        return a;
    }
}
