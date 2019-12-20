package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.MethodHandleConstant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tommi
 * Date: 13/09/2019
 * Time: 23.15
 */

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.23
 */

public class BootstrapMethodsAttribute extends Attribute {

    private List<BootstrapMethod> methods;

    public BootstrapMethodsAttribute() {
        methods = new ArrayList<>();
    }

    public BootstrapMethodsAttribute(List<BootstrapMethod> methods) {
        this.methods = methods;
    }

    public List<BootstrapMethod> getMethods() {
        return methods;
    }

    public void setMethods(List<BootstrapMethod> methods) {
        this.methods = methods;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static BootstrapMethodsAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        BootstrapMethodsAttribute a = new BootstrapMethodsAttribute();

        int methodsCount = in.readUnsignedShort();
        for (int i = 0; i < methodsCount; i++) {
            a.methods.add(BootstrapMethod.from(in, constPool));
        }
        return a;
    }

    public static class BootstrapMethod {

        private MethodHandleConstant methodHandle;
        private List<Integer> arguments = new ArrayList<>();

        public MethodHandleConstant getMethodHandle() {
            return methodHandle;
        }

        public void setMethodHandle(MethodHandleConstant methodHandle) {
            this.methodHandle = methodHandle;
        }

        public List<Integer> getArguments() {
            return arguments;
        }

        public void setArguments(List<Integer> arguments) {
            this.arguments = arguments;
        }

        public void writeTo(DataOutputStream out) throws IOException {

        }

        //TODO finish getters
        public static BootstrapMethod from(DataInputStream in, ConstPool constPool) throws IOException {
            BootstrapMethod b = new BootstrapMethod();

            b.methodHandle = constPool.get(in.readUnsignedShort()).cast();

            int argsCount = in.readUnsignedShort();
            for (int i = 0; i < argsCount; i++) {
                b.arguments.add(in.readUnsignedShort());
            }
            return b;
        }
    }


}
