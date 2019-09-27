package org.bon.jvm.instructions;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Aload extends Instruction {

    private int index;

    public Aload(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Aload";
    }

}