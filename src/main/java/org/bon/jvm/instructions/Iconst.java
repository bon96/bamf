package org.bon.jvm.instructions;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Iconst extends Instruction {

    private int i;

    public Iconst(int i) {
        this.i = i;
    }

    @Override
    public String getName() {
        return "Iconst";
    }

}