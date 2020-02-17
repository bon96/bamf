package org.bon.jvm.execution;

import org.bon.jvm.Method;
import org.bon.jvm.attributes.CodeAttribute;
import org.bon.jvm.instructions.Instruction;

/**
 * Tommi
 * Date: 25/12/2019
 * Time: 18.41
 */

public class Stack {

    java.util.Stack<Object> stack;

    public void execute(Method method) {
        if (method.getAttributes().hasType(CodeAttribute.class)) {
            MethodContext context = new MethodContext(method);
            for (Instruction ins : method.getAttributes().ofType(CodeAttribute.class).getInstructions()) {
                ins.execute(context, this);
            }
        }
    }

    public Object push(Object o) {
        return stack.push(o);
    }

    public <T> T pop(Class<T> type) {
        return type.cast(stack.pop());
    }

    public Object pop() {
        return stack.pop();
    }

    public <T> T peek(Class<T> type) {
        return type.cast(stack.peek());
    }

    public Object peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.empty();
    }
}
