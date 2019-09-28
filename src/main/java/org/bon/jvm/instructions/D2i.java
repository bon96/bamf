package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class D2i extends Instruction {

    @Override
    public String getName() {
        return "D2i";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        D2i i = new D2i();
        return i;
    }
}
