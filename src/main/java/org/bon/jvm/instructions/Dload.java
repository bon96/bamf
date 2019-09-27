package org.bon.jvm.instructions;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Dload extends Instruction {

    private int index;

    public Dload(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Dload";
    }

}