package org.bon.api;

/**
 * Tommi
 * Date: 14/09/2019
 * Time: 1.18
 */

public class Method {

    private Class aClass;
    private org.bon.jvm.Method method;

    public Method(Class aClass, org.bon.jvm.Method method) {
        this.aClass = aClass;
        this.method = method;
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

    public org.bon.jvm.Method getJVM() {
        return method;
    }
}
