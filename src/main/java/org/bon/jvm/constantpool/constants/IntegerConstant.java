package org.bon.jvm.constantpool.constants;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.4
 */

public class IntegerConstant extends Constant {

    private int value;

    public int getValue() {
        return value;
    }

    public static IntegerConstant from(DataInputStream in) throws IOException {
        IntegerConstant c = new IntegerConstant();
        c.value = in.readInt();
        return c;
    }
}
