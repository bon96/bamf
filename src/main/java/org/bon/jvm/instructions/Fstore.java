package org.bon.jvm.instructions;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Fstore extends Instruction {

    private float f;

    public Fstore(float f) {
        this.f = f;
    }

    @Override
    public String getName() {
        return "Fstore";
    }
}