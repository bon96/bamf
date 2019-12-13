package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.types.SwitchInstruction;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */


//TODO figure this shit out
public class Lookupswitch extends Instruction implements SwitchInstruction {

    @Override
    public String getName() {
        return "Lookupswitch";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, int offset) throws IOException {
        in.skipBytes(((4 - (offset % 4)) % 4));

        //defaultBytes
        int index = in.readInt();

        int length = in.readInt();

        for (int i = 0; i < length; i++) {
            //match-offset pairs
            in.readInt();
            in.readInt();
        }

        Lookupswitch i = new Lookupswitch();
        return i;
    }
}
