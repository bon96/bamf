package org.bon.api.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tommi
 * Date: 01/10/2019
 * Time: 21.31
 */

public class MethodDescriptor {
    private static Pattern paramRetPattern = Pattern.compile("\\((.*)\\)(.*)");
    private static Pattern paramsPattern = Pattern.compile("(\\[*(?:B|C|Z|S|I|J|F|D|(?:L[^;]*;)))");

    private final List<Type> arguments;
    private final Type returnValue;

    public MethodDescriptor(String str) {
        Matcher m = paramRetPattern.matcher(str);
        if (!m.find()) {
            throw new IllegalArgumentException("Signature has no arguments");
        } else {
            String args = m.group(1);
            String ret = m.group(2);
            m = paramsPattern.matcher(args);
            this.arguments = new ArrayList<>();

            while (m.find()) {
                String arg = m.group(1);
                this.arguments.add(new Type(arg));
            }

            this.returnValue = new Type(ret);
        }
    }

    public List<Type> getArguments() {
        return arguments;
    }

    public Type getReturn() {
        return returnValue;
    }

    public boolean isVoid() {
        return returnValue.equals(Type.VOID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MethodDescriptor methodDescriptor = (MethodDescriptor) o;

        return Objects.equals(arguments, methodDescriptor.arguments) &&
                Objects.equals(returnValue, methodDescriptor.returnValue);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("(");

        for (Type type : getArguments()) {
            s.append(type.toString());
        }

        s.append(")").append(getReturn().toString());
        return s.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(arguments, returnValue);
    }
}
