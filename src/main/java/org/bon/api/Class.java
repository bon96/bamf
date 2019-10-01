package org.bon.api;

import org.bon.api.util.Type;
import org.bon.jvm.ClassFile;

import java.util.List;
import java.util.Objects;
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

    public Type getType() {
        return new Type(getName());
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

    @Override
    public String toString() {
        return getName();
    }

    public boolean isPublic() {
        return getJVM().isAccPublic();
    }

    public boolean isFinal() {
        return getJVM().isAccFinal();
    }

    public boolean isAbstract() {
        return getJVM().isAccAbstract();
    }

    public boolean isAnnotation() {
        return getJVM().isAccAnnotation();
    }

    public boolean isEnum() {
        return getJVM().isAccEnum();
    }

    public boolean isModule() {
        return getJVM().isAccModule();
    }

    public boolean isInterface() {
        return getJVM().isAccInterface();
    }

    public boolean isSynthetic() {
        return getJVM().isAccSynthetic();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (!(o instanceof Class)) {
            return false;
        }
        Class that = (Class) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(classFile);
    }
}
