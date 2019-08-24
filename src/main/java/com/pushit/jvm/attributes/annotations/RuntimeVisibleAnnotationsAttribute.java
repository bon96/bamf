package com.pushit.jvm.attributes.annotations;

import com.pushit.jvm.attributes.Attribute;
import com.pushit.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.16
 */

public class RuntimeVisibleAnnotationsAttribute extends Attribute {

    private List<AnnotationAttr> annotations = new ArrayList<>();

    public RuntimeVisibleAnnotationsAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);
    }
}
