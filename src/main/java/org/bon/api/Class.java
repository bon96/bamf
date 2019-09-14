package org.bon.api;

import org.bon.jvm.ClassFile;

/**
 * Tommi
 * Date: 13/09/2019
 * Time: 23.46
 */

public class Class {

    private ClassGroup classGroup;
    private ClassFile classFile;

    public Class(ClassGroup classGroup, ClassFile classFile) {
        this.classGroup = classGroup;
        this.classFile = classFile;
    }

    public Class getSuper() {
        return new Class(classGroup, getGroup().find(getJVM().getSuperName()));
    }

    public ClassGroup getGroup() {
        return classGroup;
    }

    public ClassFile getJVM() {
        return classFile;
    }
}
