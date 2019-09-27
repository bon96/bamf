package org.bon.jvm.attributes.stackmap;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tommi
 * Date: 24/08/2019
 * Time: 22.22
 */

public class StackMapFrame {

    private int tag;
    private List<StackMapType> locals;
    private List<StackMapType> stackItems;


    public StackMapFrame(int tag) {
        this(tag, new ArrayList<>(), new ArrayList<>());
    }

    public StackMapFrame(int tag, List<StackMapType> locals, List<StackMapType> stackItems) {
        this.tag = tag;
        this.locals = locals;
        this.stackItems = stackItems;
    }

    public int getTag() {
        return tag;
    }

    public List<StackMapType> getLocals() {
        return locals;
    }

        /*
            SAME_FRAME 0-63
            SAME_LOCALS_1_STACK_ITEM_FRAME 64-127
            SAME_LOCALS_1_STACK_ITEM_EXTENDED 247
            CHOP_FRAME 248-250
            SAME_FRAME_EXTENDED = 251
            APPEND_FRAME 252-254
            FULL_FRAME 255
         */

    public List<StackMapType> getStackItems() {
        return stackItems;
    }

    public static StackMapFrame from(DataInputStream in) throws IOException {
        int b = in.readUnsignedByte();

        //SAME_FRAME
        if (b <= 63) {
            return new StackMapFrame(b);
        }

        //SAME_LOCALS_1_STACK_ITEM_FRAME
        if (b <= 127) {
            int bcOffset = b - 127;
            List<StackMapType> stackItems = new ArrayList<>();
            stackItems.add(StackMapType.from(in));

            return new StackMapFrame(bcOffset, new ArrayList<>(), stackItems);
        }

        //SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED
        if (b == 247) {
            int bcOffset = in.readUnsignedShort();
            List<StackMapType> stackItems = new ArrayList<>();
            stackItems.add(StackMapType.from(in));

            return new StackMapFrame(bcOffset, new ArrayList<>(), stackItems);
        }

        //CHOP_FRAME
        if (b >= 248 && b <= 250) {
            return new StackMapFrame(in.readUnsignedShort());
        }

        //SAME_FRAME_EXTENDED
        if (b == 251) {
            return new StackMapFrame(in.readUnsignedShort());
        }

        //APPEND_FRAME
        if (b >= 252 && b <= 254) {
            int bcOffset = in.readUnsignedShort();
            List<StackMapType> locals = new ArrayList<>();

            for (int i = 0; i < b - 251; i++) {
                locals.add(StackMapType.from(in));
            }

            return new StackMapFrame(bcOffset, locals, new ArrayList<>());
        }

        //FULL_FRAME
        if (b == 255) {
            int bcOffset = in.readUnsignedShort();
            int localsCount = in.readUnsignedShort();
            List<StackMapType> locals = new ArrayList<>();

            for (int i = 0; i < localsCount; i++) {
                locals.add(StackMapType.from(in));
            }

            int stackItemsCount = in.readUnsignedShort();
            List<StackMapType> stackItems = new ArrayList<>();

            for (int i = 0; i < stackItemsCount; i++) {
                stackItems.add(StackMapType.from(in));
            }

            return new StackMapFrame(bcOffset, locals, stackItems);
        }

        throw new RuntimeException("Unknown frame tag " + b);
    }
}
