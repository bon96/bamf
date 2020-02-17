package org.bon.jvm.execution;

import org.bon.jvm.util.Type;

/**
 * Tommi
 * Date: 26/12/2019
 * Time: 19.45
 */

public class FieldRef extends ValueRef {

    private String targetClass;
    private String target;
    private Type type;

    public FieldRef(String targetClass, String target, Type type) {
        this.targetClass = targetClass;
        this.target = target;
        this.type = type;
    }

    public String getTargetClass() {
        return targetClass;
    }

    public String getTarget() {
        return target;
    }

    public Type getType() {
        return type;
    }
}
