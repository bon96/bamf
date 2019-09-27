package org.bon.jvm.attributes.annotations;

import org.bon.jvm.attributes.Attribute;
import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.16
 */

public class RuntimeVisibleAnnotationsAttribute extends Attribute {

    private List<Annotation> annotations = new ArrayList<>();

    public RuntimeVisibleAnnotationsAttribute(DataInputStream in, ConstPool constPool) {
    }
}
