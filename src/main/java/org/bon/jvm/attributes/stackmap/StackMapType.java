package org.bon.jvm.attributes.stackmap;

import java.io.DataInputStream;
import java.io.IOException;

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

    public int getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }

    public static StackMapType from(DataInputStream in) throws IOException {
        StackMapType a = new StackMapType();
        a.type = in.readUnsignedByte();
        if (a.type == 7 || a.type == 8) {
            a.index = in.readUnsignedShort();
        }
        return a;
    }
}