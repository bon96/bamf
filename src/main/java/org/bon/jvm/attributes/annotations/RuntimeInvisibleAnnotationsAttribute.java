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

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }

    public static RuntimeInvisibleAnnotationsAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        RuntimeInvisibleAnnotationsAttribute a = new RuntimeInvisibleAnnotationsAttribute();
        a.constPool = constPool;
        a.nameIndex = nameIndex;
        a.length = length;

        List<Annotation> annotations = new ArrayList<>();
        int annotationsCount = in.readUnsignedShort();
        for (int i = 0; i < annotationsCount; i++) {
            annotations.add(Annotation.from(in, constPool));
        }
        a.annotations = annotations;
        return a;
    }
}
