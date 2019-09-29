package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

//TODO idk what the fuck is going on here
public class Tableswitch extends Instruction {

    @Override
    public String getName() {
        return "Tableswitch";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, int offset) throws IOException {
        in.skipBytes(((4 - (offset % 4)) % 4));

        //defaultBytes
        int index = in.readInt();

        int low = in.readInt();
        int high = in.readInt();
        int length = high - low + 1;

        for (int i = 0; i < length; i++) {
            //jump offsets
            in.readInt();
        }

        return new Tableswitch();
    }
}
