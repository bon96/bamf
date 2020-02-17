package org.bon.api.containers;

import org.bon.jvm.instructions.Instruction;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Tommi
 * Date: 21/12/2019
 * Time: 18.06
 */

public class Instructions extends ArrayList<Instruction> {

    public Instructions() {
    }

    public Instructions(Collection<? extends Instruction> c) {
        super(c);
    }

    public Instruction getAtOffset(int offset) {
        for (Instruction instruction : this) {
            if (instruction.getOffset() == offset) {
                return instruction;
            }
        }
        return null;
    }
}
