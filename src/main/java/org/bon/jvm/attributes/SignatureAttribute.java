package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.9
 */

public class SignatureAttribute extends Attribute {

    private String signature;

    public SignatureAttribute(String signature) {
        this.signature = signature;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static SignatureAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        return new SignatureAttribute(constPool.get(in.readUnsignedShort()).toString());
    }
}
