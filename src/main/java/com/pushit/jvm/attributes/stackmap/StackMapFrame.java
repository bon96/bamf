package com.pushit.jvm.attributes.stackmap;

import java.nio.ByteBuffer;
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

    public StackMapFrame(int tag, List<StackMapType> locals) {
        this(tag, locals, new ArrayList<>());
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

    public List<StackMapType> getStackItems() {
        return stackItems;
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

    public static StackMapFrame from(ByteBuffer byteBuffer) {
        int b = byteBuffer.get() & 0xFF;

        //SAME_FRAME
        if (b <= 63) {
            return new StackMapFrame(b);
        }

        //SAME_LOCALS_1_STACK_ITEM_FRAME
        if (b <= 127) {
            int bcOffset = b - 127;
            List<StackMapType> locals = new ArrayList<>();
            locals.add(new StackMapType(byteBuffer));

            return new StackMapFrame(bcOffset, locals);
        }

        //SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED
        if (b == 247) {
            int bcOffset = byteBuffer.getShort();
            List<StackMapType> locals = new ArrayList<>();
            locals.add(new StackMapType(byteBuffer));

            return new StackMapFrame(bcOffset, locals);
        }

        //CHOP_FRAME
        if (b >= 248 && b <= 250) {
            return new StackMapFrame(byteBuffer.getShort());
        }

        //SAME_FRAME_EXTENDED
        if (b == 251) {
            return new StackMapFrame(byteBuffer.getShort());
        }

        //APPEND_FRAME
        if (b >= 252 && b <= 254) {
            int bcOffset = byteBuffer.getShort();
            List<StackMapType> locals = new ArrayList<>();

            for (int i = 0; i < b - 251; i++) {
                locals.add(new StackMapType(byteBuffer));
            }

            return new StackMapFrame(bcOffset, locals);
        }

        //FULL_FRAME
        if (b == 255) {
            int bcOffset = byteBuffer.getShort();
            int localsCount = byteBuffer.getShort();
            List<StackMapType> locals = new ArrayList<>();

            for (int i = 0; i < localsCount; i++) {
                locals.add(new StackMapType(byteBuffer));
            }

            int stackItemsCount = byteBuffer.getShort();
            List<StackMapType> stackItems = new ArrayList<>();

            for (int i = 0; i < stackItemsCount; i++) {
                stackItems.add(new StackMapType(byteBuffer));
            }

            return new StackMapFrame(bcOffset, locals, stackItems);
        }

        throw new RuntimeException("Unknown frame tag " + b);
    }
}
