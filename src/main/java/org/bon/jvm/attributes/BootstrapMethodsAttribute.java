package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;
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

    public BootstrapMethodsAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);

        int methodsCount = byteBuffer.getShort();
        for (int i = 0; i < methodsCount; i++) {
            methods.add(new BootstrapMethod(byteBuffer, constPool));
        }
    }

    public List<BootstrapMethod> getMethods() {
        return methods;
    }

    public static class BootstrapMethod {

        private ConstPool constPool;
        private int methodRefIndex;
        private List<Integer> arguments = new ArrayList<>();

        //TODO finish getters
        public BootstrapMethod(ByteBuffer byteBuffer, ConstPool constPool) {
            methodRefIndex = byteBuffer.getShort();
            int argsCount = byteBuffer.getShort();
            for (int i = 0; i < argsCount; i++) {
                arguments.add((int) byteBuffer.getShort());
            }
        }

        public int getMethodRefIndex() {
            return methodRefIndex;
        }

        public List<Integer> getArguments() {
            return arguments;
        }
    }


}
