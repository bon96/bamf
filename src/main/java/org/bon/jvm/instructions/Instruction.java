package org.bon.jvm.instructions;

import org.bon.Cast;
import org.bon.api.Method;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 18.26
 */

public abstract class Instruction implements Cast {

    private Method owner;

    public Method getOwner() {
        return owner;
    }

    public void setOwner(Method owner) {
        this.owner = owner;
    }

    public abstract String getName();
}
