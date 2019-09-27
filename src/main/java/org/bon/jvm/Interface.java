package org.bon.jvm;

import org.bon.jvm.constantpool.constants.ClassConstant;

public class Interface {

    private ClassConstant classConstant;

    public Interface() {
    }


    public static Interface from(ClassConstant c) {
        Interface i = new Interface();
        i.classConstant = c;
        return i;
    }
}
