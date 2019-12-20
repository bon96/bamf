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

    private List<Parameter> parameters;

    public MethodParametersAttribute() {
        parameters = new ArrayList<>();
    }

    public MethodParametersAttribute(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }


    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static MethodParametersAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        MethodParametersAttribute a = new MethodParametersAttribute();

        int parametersCount = in.readUnsignedByte();
        for (int i = 0; i < parametersCount; i++) {
            a.parameters.add(Parameter.from(in, constPool));
        }
        return a;
    }

    public static class Parameter {

        private String name;
        private int accessFlags;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAccessFlags() {
            return accessFlags;
        }


        public void setAccessFlags(int accessFlags) {
            this.accessFlags = accessFlags;
        }

        public static Parameter from(DataInputStream in, ConstPool constPool) throws IOException {
            Parameter p = new Parameter();
            p.name = constPool.get(in.readUnsignedShort()).toString();
            p.accessFlags = in.readUnsignedShort();
            return p;
        }
    }

}
