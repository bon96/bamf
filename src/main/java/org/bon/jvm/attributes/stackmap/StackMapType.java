package org.bon.jvm.attributes.stackmap;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 24/08/2019
 * Time: 22.22
 */


public class StackMapType {

    //types Bogus 0 Integer 1 Float 2 Double 3 Long 4 Null 5 InitObject 6 Object 7 NewObject 8
    private int type;
    private int index;

    public StackMapType(int index) {
        this.index = index;
    }

    public StackMapType(int type, int index) {
        this.type = type;
        this.index = index;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static StackMapType from(DataInputStream in) throws IOException {
        int type = in.readUnsignedByte();

        if (type == 7 || type == 8) {
            int index = in.readUnsignedShort();
            return new StackMapType(type, index);
        } else {
            return new StackMapType(type);
        }
    }
}