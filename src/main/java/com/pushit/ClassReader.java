package com.pushit;

import com.pushit.api.ClassGroup;
import com.pushit.jvm.ClassFile;
import com.pushit.jvm.Method;
import com.pushit.jvm.attributes.*;
import com.pushit.jvm.attributes.Attribute;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.jar.JarFile;


public class ClassReader {

    private ByteBuffer byteBuf;

    public ClassReader(byte[] bytes) {
        this.byteBuf = ByteBuffer.wrap(bytes);
    }

    public ClassReader(InputStream is) throws IOException {
        this.byteBuf = ByteBuffer.wrap(is.readAllBytes());
    }

    public static void main(String[] args) throws Exception {
        ClassGroup classGroup = ClassGroup.from(new JarFile("./181.jar"));
        for (ClassFile cf : classGroup.getClasses()) {
            if (!cf.getName().equals("en.java")) {
                continue;
            }

            for (Method method : cf.getMethods()) {
                for (Attribute attribute : method.getAttributes().list()) {
                    if (attribute instanceof CodeAttribute) {
                        for (Attribute attribute1 : ((CodeAttribute) attribute).getAttributes()) {
                            System.out.println(attribute1.getName());
                        }
                    }
                }
            }
        }
    }

    public static void main2(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("./181/w.class");
        ClassFile classFile = new ClassFile(inputStream.readAllBytes());
    }

}
