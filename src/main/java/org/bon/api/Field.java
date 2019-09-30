package org.bon.api;

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

    public Class getOwner() {
        return aClass;
    }

    public int getAccessFlags() {
        return getJVM().getAccessFlags();
    }

    public String getName() {
        return getJVM().getName();
    }

    public String getDescriptor() {
        return getJVM().getDescriptor();
    }

    public org.bon.jvm.Field getJVM() {
        return field;
    }
}
