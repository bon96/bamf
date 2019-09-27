package org.bon.jvm.constantpool.constants;


import java.io.DataInputStream;
import java.io.IOException;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4.7
 */

public class Utf8Constant extends Constant {

    private String string;

    @Override
    public String toString() {
        return string;
    }

    public static Utf8Constant from(DataInputStream in) throws IOException {
        Utf8Constant c = new Utf8Constant();
        int len = in.readUnsignedShort();
        byte[] bytearr = new byte[len];
        char[] chararr = new char[len];

        int char1, char2, char3;
        int count = 0;
        int chararr_count = 0;

        in.readNBytes(bytearr, 0, len);

        while (count < len) {
            char1 = (int) bytearr[count] & 0xff;
            if (char1 > 127) {
                break;
            }
            count++;
            chararr[chararr_count++] = (char) char1;
        }

        while (count < len) {
            char1 = (int) bytearr[count] & 0xff;
            switch (char1 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    count++;
                    chararr[chararr_count++] = (char) char1;
                    break;
                case 12:
                case 13:
                    count += 2;
                    char2 = (int) bytearr[count - 1];
                    chararr[chararr_count++] = (char) (
                            ((char1 & 0x1F) << 6) |
                                    (char2 & 0x3F));
                    break;
                case 14:
                    count += 3;
                    char2 = (int) bytearr[count - 2];
                    char3 = (int) bytearr[count - 1];

                    chararr[chararr_count++] = (char) (
                            ((char1 & 0x0F) << 12) |
                                    ((char2 & 0x3F) << 6) |
                                    ((char3 & 0x3F)));
                    break;
            }
        }
        c.string = new String(chararr, 0, chararr_count);
        return c;
    }
}
