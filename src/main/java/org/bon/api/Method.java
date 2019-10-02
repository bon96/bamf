package org.bon.api;

import org.bon.api.util.MethodDescriptor;
import org.bon.jvm.attributes.CodeAttribute;
import org.bon.jvm.instructions.Instruction;

import java.util.ArrayList;
import java.util.List;

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

    public List<Instruction> getInstructions() {
        if (!getJVM().getAttributes().hasType(CodeAttribute.class)) {
            return new ArrayList<>();
        } else {
            return getJVM().getAttributes().ofType(CodeAttribute.class).getInstructions();
        }
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
}
