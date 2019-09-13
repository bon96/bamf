package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * Tommi
 * Date: 13/09/2019
 * Time: 23.34
 */

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.24
 */

public class MethodParametersAttribute extends Attribute {

    private List<Parameter> parameters = new ArrayList<>();

    public MethodParametersAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);

        int parametersCount = byteBuffer.get();
        for (int i = 0; i < parametersCount; i++) {
            parameters.add(new Parameter(byteBuffer, constPool));
        }
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public static class Parameter {

        private int nameIndex;
        private int accessFlags;

        //TODO finish getters
        public Parameter(ByteBuffer byteBuffer, ConstPool constPool) {
            nameIndex = byteBuffer.getShort();
            accessFlags = byteBuffer.getShort();
        }

        public int getNameIndex() {
            return nameIndex;
        }

        public int getAccessFlags() {
            return accessFlags;
        }
    }

}
