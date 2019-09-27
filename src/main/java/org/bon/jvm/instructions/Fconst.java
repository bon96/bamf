package org.bon.jvm.instructions;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Fconst extends Instruction {

    private float f;

    public Fconst(float f) {
        this.f = f;
    }

    @Override
    public String getName() {
        return "Fconst";
    }

}