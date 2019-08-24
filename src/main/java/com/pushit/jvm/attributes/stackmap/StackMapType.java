package com.pushit.jvm.attributes.stackmap;

import java.nio.ByteBuffer;

/**
 * Tommi
 * Date: 24/08/2019
 * Time: 22.22
 */


public class StackMapType {

             /*
                 Bogus 0
                 Integer 1
                 Float 2
                 Double 3
                 Long 4
                 Null 5
                 InitObject 6
                 Object 7
                 NewObject 8
             */

    private int type;
    private int index;

    public StackMapType(ByteBuffer byteBuffer) {
        this.type = byteBuffer.get();

        if (type == 7 || type == 8) {
            index = byteBuffer.getShort();
        }
    }

    public int getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }
}