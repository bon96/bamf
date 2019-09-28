package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Ifnonnull extends Instruction {

    @Override
    public String getName() {
        return "Ifnonnull";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        Ifnonnull i = new Ifnonnull();
        return i;
    }
}
