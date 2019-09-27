package org.bon.jvm.instructions;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Fload extends Instruction {

    private int index;

    public Fload(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Fload";
    }

}