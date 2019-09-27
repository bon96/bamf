package org.bon.jvm.constantpool.constants;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.4
 */

public class FloatConstant extends Constant {

    private float value;

    public float getValue() {
        return value;
    }

    public static FloatConstant from(DataInputStream in) throws IOException {
        FloatConstant c = new FloatConstant();
        c.value = in.readFloat();
        return c;
    }
}
