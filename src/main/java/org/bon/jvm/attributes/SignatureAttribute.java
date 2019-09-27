package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.9
 */

public class SignatureAttribute extends Attribute {

    private int signatureIndex;

    public static SignatureAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        SignatureAttribute a = new SignatureAttribute();
        a.nameIndex = nameIndex;
        a.length = length;
        a.signatureIndex = in.readUnsignedShort();
        return a;
    }

    public String getSignature() {
        return constPool.get(signatureIndex).toString();
    }

    public int getSignatureIndex() {
        return signatureIndex;
    }
}
