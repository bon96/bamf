package org.bon.api;

import org.bon.api.containers.Instructions;
import org.bon.jvm.attributes.CodeAttribute;

/**
 * Tommi
 * Date: 21/12/2019
 * Time: 18.30
 */

public class Exception {

    private Method method;
    private CodeAttribute.Exception exception;

    public Exception(CodeAttribute.Exception exception, Method method) {
        this.method = method;
        this.exception = exception;
    }

    public Instructions getActive() {
        Instructions instructions = new Instructions();

        int offset = getJVM().getStart();
        while (offset <= getJVM().getEnd()) {
            instructions.add(method.getInstructions().getAtOffset(offset));
        }
        return instructions;
    }


    public CodeAttribute.Exception getJVM() {
        return exception;
    }

    public Method getMethod() {
        return method;
    }
}
