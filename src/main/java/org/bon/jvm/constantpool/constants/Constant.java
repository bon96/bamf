package org.bon.jvm.constantpool.constants;

import org.bon.Cast;

import java.io.DataOutputStream;
import java.io.IOException;

public abstract class Constant implements Cast {

    public static final int UTF8 = 1;                     // 45.3 1.0.2
    public static final int INTEGER = 3;                  // 45.3 1.0.2
    public static final int FLOAT = 4;                    // 45.3 1.0.2
    public static final int LONG = 5;                     // 45.3 1.0.2
    public static final int DOUBLE = 6;                   // 45.3 1.0.2
    public static final int CLASS = 7;                    // 45.3 1.0.2
    public static final int STRING = 8;                   // 45.3 1.0.2
    public static final int FIELD_REF = 9;                // 45.3 1.0.2
    public static final int METHOD_REF = 10;              // 45.3 1.0.2
    public static final int INTERFACE_METHOD_REF = 11;    // 45.3 1.0.2
    public static final int NAME_AND_TYPE = 12;           // 45.3 1.0.2
    public static final int METHOD_HANDLE = 15;           // 51.0 7
    public static final int METHOD_TYPE = 16;             // 51.0 7
    public static final int DYNAMIC = 17;                 // 55.0 11
    public static final int INVOKE_DYNAMIC = 18;          // 51.0 7
    public static final int MODULE = 19;                  // 53.0 9
    public static final int PACKAGE = 20;                 // 53.0 9

    public abstract void writeTo(DataOutputStream out) throws IOException;

}
