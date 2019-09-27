package org.bon.jvm.instructions;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Dstore extends Instruction {

    private double d;

    public Dstore(double d) {
        this.d = d;
    }

    @Override
    public String getName() {
        return "Dstore";
    }

}