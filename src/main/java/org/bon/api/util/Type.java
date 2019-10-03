package org.bon.api.util;

import java.util.Objects;

/**
 * Tommi
 * Date: 30/09/2019
 * Time: 18.37
 */

public class Type {
    public static final Type VOID = new Type("V");
    public static final Type BOOLEAN = new Type("Z");
    public static final Type CHAR = new Type("C");
    public static final Type BYTE = new Type("B");
    public static final Type SHORT = new Type("S");
    public static final Type INT = new Type("I");
    public static final Type FLOAT = new Type("F");
    public static final Type LONG = new Type("J");
    public static final Type DOUBLE = new Type("D");
    public static final Type OBJECT = new Type("Ljava/lang/Object;");
    public static final Type STRING = new Type("Ljava/lang/String;");
    public static final Type CHARSQEUENCE = new Type("Ljava/lang/CharSequence;");
    public static final Type THROWABLE = new Type("Ljava/lang/Throwable;");
    public static final Type EXCEPTION = new Type("Ljava/lang/Exception;");

    private String type;
    private int dimensions;
    private boolean primitive;
    private String stripped;

    public Type(Object o, int dimensions) {
        this(o.getClass(), dimensions);
    }

    public Type(Object o) {
        this(o.getClass(), -1);
    }

    public Type(Class clazz, int dimensions) {
        this(clazz.getName(), dimensions);
    }

    public Type(Class clazz) {
        this(clazz.getName(), -1);
    }

    public Type(String type) {
        this(type, -1);
    }

    public Type(String type, int dimensions) {
        if (dimensions == -1) {
            this.dimensions = (int) type.chars().filter(i -> i == '[').count();
        } else {
            this.dimensions = dimensions;
        }


        stripped = type.replace("[", "").replace("L", "")
                .replace(";", "").replace(".", "/");


        if (stripped.length() == 1 && "VZCBSIFJD".contains(stripped)) {
            String fixed = "";
            fixed += "[".repeat(this.dimensions);
            fixed += stripped;
            this.type = fixed;
            this.primitive = true;
            return;
        }

        String fixed = "";

        fixed += "[".repeat(this.dimensions);
        fixed += "L";
        fixed += stripped;
        fixed += ";";

        this.type = fixed;
    }

    public String getStripped() {
        return stripped;
    }

    public int getDimensions() {
        return dimensions;
    }

    public Type array(int dimensions) {
        return new Type(type, dimensions);
    }

    public boolean isArray() {
        return getDimensions() > 0;
    }

    public boolean isPrimitive() {
        return primitive;
    }

    @Override
    public String toString() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o instanceof String) {
            return toString().equals(new Type((String) o).toString());
        }

        if (getClass() != o.getClass()) {
            return false;
        }

        Type type1 = (Type) o;
        return Objects.equals(toString(), type1.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(toString());
    }
}
