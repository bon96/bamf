package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
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

    private List<BootstrapMethod> methods = new ArrayList<>();

    public List<BootstrapMethod> getMethods() {
        return methods;
    }

    public static BootstrapMethodsAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        BootstrapMethodsAttribute a = new BootstrapMethodsAttribute();
        a.nameIndex = nameIndex;
        a.length = length;

        int methodsCount = in.readUnsignedShort();
        for (int i = 0; i < methodsCount; i++) {
            a.methods.add(BootstrapMethod.from(in, constPool));
        }
        return a;
    }

    public static class BootstrapMethod {

        private ConstPool constPool;
        private int methodRefIndex;
        private List<Integer> arguments = new ArrayList<>();

        public int getMethodRefIndex() {
            return methodRefIndex;
        }

        public List<Integer> getArguments() {
            return arguments;
        }

        //TODO finish getters
        public static BootstrapMethod from(DataInputStream in, ConstPool constPool) throws IOException {
            BootstrapMethod b = new BootstrapMethod();
            b.methodRefIndex = in.readUnsignedShort();

            int argsCount = in.readUnsignedShort();
            for (int i = 0; i < argsCount; i++) {
                b.arguments.add(in.readUnsignedShort());
            }
            return b;
        }
    }


}
