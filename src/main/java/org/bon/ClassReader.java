package org.bon;

import org.bon.api.ClassGroup;
import org.bon.jvm.ClassFile;
import org.bon.jvm.Method;
import org.bon.jvm.attributes.Attribute;
import org.bon.jvm.attributes.CodeAttribute;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.jar.JarFile;


public class ClassReader {

    private ByteBuffer byteBuf;

    public ClassReader(byte[] bytes) {
        byteBuf = ByteBuffer.wrap(bytes);
    }

    public ClassReader(InputStream is) throws IOException {
        byteBuf = ByteBuffer.wrap(is.readAllBytes());
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
