package org.bon.jvm.instructions;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Astore extends Instruction {

    private int index;

    public Astore(int index) {
        this.index = index;
    }

    @Override
    public String getName() {
        return "Astore";
    }

}