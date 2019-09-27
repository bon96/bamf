package org.bon.jvm.instructions;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Lstore extends Instruction {

    private long l;

    public Lstore(long l) {
        this.l = l;
    }

    @Override
    public String getName() {
        return "Lstore";
    }

}