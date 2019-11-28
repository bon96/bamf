package org.bon.jvm;

import org.bon.jvm.constantpool.ConstPool;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 06/11/2019
 * Time: 3.42
 */

public class ShallowClassFile {

    private int magic;
    private int minorVersion;
    private int majorVersion;

    private byte[] rest;

    private ConstPool constPool;

    public ConstPool getConstPool() {
        return constPool;
    }

    public byte[] writeToBytes() throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(bos);

        out.writeInt(magic);
        out.writeShort(minorVersion);
        out.writeShort(majorVersion);

        constPool.writeTo(out);

        out.write(rest);

        return bos.toByteArray();
    }

    public static ShallowClassFile from(DataInputStream in) throws IOException {
        ShallowClassFile classFile = new ShallowClassFile();

        classFile.magic = in.readInt();

        classFile.minorVersion = in.readUnsignedShort();
        classFile.majorVersion = in.readUnsignedShort();

        int constPoolSize = in.readUnsignedShort();

        classFile.constPool = ConstPool.from(in, constPoolSize);

        classFile.rest = in.readAllBytes();
        return classFile;
    }
}
