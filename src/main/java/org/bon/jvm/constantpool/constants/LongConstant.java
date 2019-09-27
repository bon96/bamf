package org.bon.jvm.constantpool.constants;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.5
 */

public class LongConstant extends Constant {

    private long value;

    public long getValue() {
        return value;
    }

    public static LongConstant from(DataInputStream in) throws IOException {
        LongConstant c = new LongConstant();
        c.value = in.readLong();
        return c;
    }
}
