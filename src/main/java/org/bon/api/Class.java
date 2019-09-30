package org.bon.api;

import org.bon.jvm.ClassFile;

import java.util.List;
import java.util.stream.Collectors;

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

    public int getMagic() {
        return getJVM().getMagic();
    }

    public String getSuperName() {
        return getJVM().getSuperName();
    }

    public int getMinorVersion() {
        return getJVM().getMinorVersion();
    }

    public int getMajorVersion() {
        return getJVM().getMajorVersion();
    }

    public String getName() {
        return getJVM().getName();
    }

    public int getAccessFlags() {
        return getJVM().getAccessFlags();
    }

    public Class getSuper() {
        ClassFile cf = getGroup().find(getJVM().getSuperName());
        return cf == null ? null : new Class(classGroup, cf);
    }

    public List<Method> getMethods() {
        return getJVM().getMethods().stream().map(m -> new Method(this, m)).collect(Collectors.toList());
    }

    public List<Field> getFields() {
        return getJVM().getFields().stream().map(f -> new Field(this, f)).collect(Collectors.toList());
    }

    public ClassGroup getGroup() {
        return classGroup;
    }

    public ClassFile getJVM() {
        return classFile;
    }
}
