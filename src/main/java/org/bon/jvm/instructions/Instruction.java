package org.bon.jvm.instructions;

import org.bon.Cast;
import org.bon.jvm.Method;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 18.26
 */

public abstract class Instruction implements Cast {

    private Method owner;
    private int offset;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Method getOwner() {
        return owner;
    }

    void setOwner(Method owner) {
        this.owner = owner;
    }

    public abstract String getName();
}
