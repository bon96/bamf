package org.bon.api;

import org.bon.api.containers.Blocks;
import org.bon.api.containers.Exceptions;
import org.bon.api.containers.Instructions;
import org.bon.jvm.attributes.CodeAttribute;
import org.bon.jvm.attributes.annotations.Annotation;
import org.bon.jvm.attributes.annotations.RuntimeInvisibleAnnotationsAttribute;
import org.bon.jvm.attributes.annotations.RuntimeVisibleAnnotationsAttribute;
import org.bon.jvm.instructions.Instruction;
import org.bon.jvm.util.MethodDescriptor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public Blocks getBlocks() {
        Blocks blocks = new Blocks();

        Block current = new Block(blocks);
        for (Instruction instruction : getInstructions()) {
            if (instruction.isJumpTarget()) {
                if (!current.isEmpty()) {
                    blocks.add(current);
                }
                current = new Block(blocks);
            }
            current.add(instruction);
        }

        if (!current.isEmpty()) {
            blocks.add(current);
        }
        return blocks;
    }

    public Instructions getInstructions() {
        if (!getJVM().getAttributes().hasType(CodeAttribute.class)) {
            return new Instructions();
        } else {
            return new Instructions(getJVM().getAttributes().ofType(CodeAttribute.class).getInstructions());
        }
    }

    public Exceptions getExceptions() {
        if (!getJVM().getAttributes().hasType(CodeAttribute.class)) {
            return new Exceptions();
        } else {
            return getJVM().getAttributes().ofType(CodeAttribute.class).getExceptions()
                    .stream().map(e -> new Exception(e, this)).collect(Collectors.toCollection(Exceptions::new));
        }
    }

    public List<Annotation> getAnnotations() {
        List<Annotation> annotations = new ArrayList<>();
        if (getJVM().getAttributes().hasType(RuntimeVisibleAnnotationsAttribute.class)) {
            annotations.addAll(getJVM().getAttributes().ofType(RuntimeVisibleAnnotationsAttribute.class).getAnnotations());
        }

        if (getJVM().getAttributes().hasType(RuntimeInvisibleAnnotationsAttribute.class)) {
            annotations.addAll(getJVM().getAttributes().ofType(RuntimeInvisibleAnnotationsAttribute.class).getAnnotations());
        }

        return annotations;
    }

    public int getAccessFlags() {
        return getJVM().getAccessFlags();
    }

    public String getName() {
        return getJVM().getName();
    }

    public MethodDescriptor getDescriptor() {
        return new MethodDescriptor(getJVM().getDescriptor());
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

    public boolean isSynchroniced() {
        return getJVM().isAccSynchroniced();
    }

    public boolean isBridge() {
        return getJVM().isAccBridge();
    }

    public boolean hasVarArgs() {
        return getJVM().isAccVarArgs();
    }

    public boolean isNative() {
        return getJVM().isAccNative();
    }

    public boolean isAbstract() {
        return getJVM().isAccAbstract();
    }

    public boolean isStrict() {
        return getJVM().isAccStrict();
    }

    public boolean isSynthetic() {
        return getJVM().isAccSynthetic();
    }

    public org.bon.jvm.Method getJVM() {
        return method;
    }

    @Override
    public String toString() {
        return getOwner().getName() + "." + getName() + " " + getDescriptor();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (!(o instanceof Method)) {
            return false;
        }
        Method that = (Method) o;
        return getOwner().getName().equals(that.getOwner().getName()) && getName().equals(that.getName())
                && getDescriptor().equals(that.getDescriptor());
    }
}
