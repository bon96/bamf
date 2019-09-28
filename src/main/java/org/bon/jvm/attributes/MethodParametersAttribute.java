package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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

    public List<Parameter> getParameters() {
        return parameters;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }

    public static MethodParametersAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        MethodParametersAttribute a = new MethodParametersAttribute();
        a.nameIndex = nameIndex;
        a.length = length;

        int parametersCount = in.readUnsignedByte();
        for (int i = 0; i < parametersCount; i++) {
            a.parameters.add(Parameter.from(in, constPool));
        }
        return a;
    }

    public static class Parameter {

        private int nameIndex;
        private int accessFlags;

        public int getNameIndex() {
            return nameIndex;
        }

        public int getAccessFlags() {
            return accessFlags;
        }

        //TODO finish getters
        public static Parameter from(DataInputStream in, ConstPool constPool) throws IOException {
            Parameter p = new Parameter();
            p.nameIndex = in.readUnsignedShort();
            p.accessFlags = in.readUnsignedShort();
            return p;
        }
    }

}
