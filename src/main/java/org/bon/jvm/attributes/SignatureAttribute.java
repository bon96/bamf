package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.9
 */

public class SignatureAttribute extends Attribute {

    private int signatureIndex;

    public SignatureAttribute(ByteBuffer byteBuffer, ConstPool constPool) {
        super(byteBuffer, constPool);
        this.signatureIndex = byteBuffer.getShort();
    }

    public String getSignature() {
        return constPool.get(signatureIndex).toString();
    }

    public int getSignatureIndex() {
        return signatureIndex;
    }
}
