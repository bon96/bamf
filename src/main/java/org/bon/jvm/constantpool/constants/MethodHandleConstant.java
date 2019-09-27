package org.bon.jvm.constantpool.constants;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.8
 */

public class MethodHandleConstant extends Constant {

    private ConstPool constPool;
    private int referenceKind;
    private int referenceIndex;

    public static MethodHandleConstant from(DataInputStream in, ConstPool constPool) throws IOException {
        MethodHandleConstant c = new MethodHandleConstant();
        c.constPool = constPool;
        c.referenceKind = in.readUnsignedByte();
        c.referenceIndex = in.readUnsignedShort();
        return c;
    }

    public int getReferenceKind() {
        return referenceKind;
    }

    public Constant getReference() {
        return constPool.get(referenceIndex);
    }

    public int getReferenceIndex() {
        return referenceIndex;
    }
}
