package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

public class D2f extends Instruction {

    @Override
    public String getName() {
        return "D2f";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        D2f i = new D2f();
        return i;
    }
}
