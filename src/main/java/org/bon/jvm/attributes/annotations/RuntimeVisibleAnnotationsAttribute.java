package org.bon.jvm.attributes.annotations;

import org.bon.jvm.attributes.Attribute;
import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.16
 */

public class RuntimeVisibleAnnotationsAttribute extends Attribute {

    private List<Annotation> annotations;

    public RuntimeVisibleAnnotationsAttribute() {
        annotations = new ArrayList<>();
    }

    public RuntimeVisibleAnnotationsAttribute(List<Annotation> annotations) {
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

    public static RuntimeVisibleAnnotationsAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        RuntimeVisibleAnnotationsAttribute a = new RuntimeVisibleAnnotationsAttribute();

        List<Annotation> annotations = new ArrayList<>();
        int annotationsCount = in.readUnsignedShort();
        for (int i = 0; i < annotationsCount; i++) {
            annotations.add(Annotation.from(in, constPool));
        }
        a.annotations = annotations;
        return a;
    }
}
