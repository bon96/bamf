package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class Ifnull extends Instruction {

    @Override
    public String getName() {
        return "Ifnull";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        Ifnull i = new Ifnull();
        return i;
    }
}
