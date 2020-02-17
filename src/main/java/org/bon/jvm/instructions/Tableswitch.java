package org.bon.jvm.instructions;

import org.bon.jvm.execution.MethodContext;
import org.bon.jvm.execution.Stack;
import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.instructions.types.SwitchInstruction;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.00
 */

//TODO idk what the fuck is going on here
public class Tableswitch extends Instruction implements SwitchInstruction {

    private int defaultIndex;
    private int low;
    private int high;
    private int length;
    private List<Integer> jumpOffsets = new ArrayList<>();


    @Override
    public void execute(MethodContext context, Stack stack) {

    }

    @Override
    public String getName() {
        return "Tableswitch";
    }

    public static Instruction from(DataInputStream in, ConstPool constPool, int offset) throws IOException {
        in.skipBytes(((4 - (offset % 4)) % 4));

        Tableswitch tableswitch = new Tableswitch();

        tableswitch.defaultIndex = in.readInt();
        tableswitch.low = in.readInt();
        tableswitch.high = in.readInt();
        tableswitch.length = tableswitch.high - tableswitch.low + 1;

        for (int i = 0; i < tableswitch.length; i++) {
            int jumpIndex = in.readInt();

            if (jumpIndex < tableswitch.low || jumpIndex > tableswitch.high) {
                tableswitch.jumpOffsets.add(tableswitch.defaultIndex + offset);
            }
            tableswitch.jumpOffsets.add(in.readInt());
        }

        return new Tableswitch();
    }
}
