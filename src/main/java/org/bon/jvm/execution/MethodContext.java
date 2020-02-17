package org.bon.jvm.execution;

import org.bon.jvm.Method;
import org.bon.jvm.attributes.CodeAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Tommi
 * Date: 25/12/2019
 * Time: 22.54
 */

public class MethodContext {

    private List<Object> locals;

    public MethodContext(Method method) {
        if (method.getAttributes().hasType(CodeAttribute.class)) {
            locals = new ArrayList<>(method.getAttributes().ofType(CodeAttribute.class).getMaxLocals());
        }
    }

    public List<Object> getLocals() {
        return locals;
    }

    public <T> T getLocal(int index, Class<T> type) {
        return type.cast(getLocal(index));
    }

    public Object getLocal(int index) {
        return getLocals().get(index);
    }

    public void setLocal(int index, Object element) {
        getLocals().set(index, element);
    }
}
