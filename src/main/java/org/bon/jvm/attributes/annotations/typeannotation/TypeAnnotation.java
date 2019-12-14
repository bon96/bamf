package org.bon.jvm.attributes.annotations.typeannotation;

import org.bon.jvm.attributes.annotations.Annotation;
import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tommi
 * Date: 14/12/2019
 * Time: 3.53
 */

public class TypeAnnotation {

    private TargetType targetInfo;
    private TypePath targetPath;
    private String type;
    private List<Annotation.Element> elements = new ArrayList<>();

    public TargetType getTargetInfo() {
        return targetInfo;
    }

    public TypePath getTargetPath() {
        return targetPath;
    }

    public String getType() {
        return type;
    }

    public List<Annotation.Element> getElements() {
        return elements;
    }

    public static TypeAnnotation from(DataInputStream in, ConstPool constPool) throws IOException {
        TypeAnnotation a = new TypeAnnotation();

        a.targetInfo = TargetType.from(in, constPool);
        a.targetPath = TypePath.from(in);
        a.type = constPool.get(in.readUnsignedShort()).toString();

        int elementCount = in.readUnsignedShort();
        for (int i = 0; i < elementCount; i++) {
            a.elements.add(Annotation.Element.from(in, constPool));
        }
        return a;
    }
}
