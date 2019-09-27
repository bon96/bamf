package org.bon.jvm.Instructions;

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
}
