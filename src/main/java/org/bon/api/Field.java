package org.bon.api;

import org.bon.api.util.Type;
import org.bon.jvm.attributes.annotations.Annotation;
import org.bon.jvm.attributes.annotations.RuntimeInvisibleAnnotationsAttribute;
import org.bon.jvm.attributes.annotations.RuntimeVisibleAnnotationsAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Tommi
 * Date: 14/09/2019
 * Time: 1.21
 */

public class Field {

    private Class aClass;
    private org.bon.jvm.Field field;

    public Field(Class aClass, org.bon.jvm.Field field) {
        this.aClass = aClass;
        this.field = field;
    }

    public List<Annotation> getAnnotations() {
        List<Annotation> annotations = new ArrayList<>();
        if (getJVM().getAttributes().hasType(RuntimeVisibleAnnotationsAttribute.class)) {
            annotations.addAll(getJVM().getAttributes().ofType(RuntimeVisibleAnnotationsAttribute.class).getAnnotations());
        }

        if (getJVM().getAttributes().hasType(RuntimeInvisibleAnnotationsAttribute.class)) {
            annotations.addAll(getJVM().getAttributes().ofType(RuntimeVisibleAnnotationsAttribute.class).getAnnotations());
        }

        return annotations;
    }

    public Class getOwner() {
        return aClass;
    }

    public boolean isPublic() {
        return getJVM().isAccPublic();
    }

    public boolean isPrivate() {
        return getJVM().isAccPrivate();
    }

    public boolean isProtected() {
        return getJVM().isAccProtected();
    }

    public boolean isStatic() {
        return getJVM().isAccStatic();
    }

    public boolean isFinal() {
        return getJVM().isAccFinal();
    }

    public boolean isVolatile() {
        return getJVM().isAccVolatile();
    }

    public boolean isTransient() {
        return getJVM().isAccTransient();
    }

    public boolean isSynthetic() {
        return getJVM().isAccSynthetic();
    }

    public boolean isEnum() {
        return getJVM().isAccEnum();
    }

    public String getName() {
        return getJVM().getName();
    }

    public Type getType() {
        return new Type(getJVM().getDescriptor());
    }

    public org.bon.jvm.Field getJVM() {
        return field;
    }

    @Override
    public String toString() {
        return getOwner().getName() + "." + getName() + " " + getType();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (!(o instanceof Field)) {
            return false;
        }
        Field that = (Field) o;
        return getOwner().getName().equals(that.getOwner().getName()) && getName().equals(that.getName())
                && getType().equals(that.getType());
    }

}
