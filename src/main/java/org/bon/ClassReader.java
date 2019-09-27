package org.bon;

import org.bon.api.ClassGroup;
import org.bon.jvm.ClassFile;
import org.bon.jvm.attributes.SignatureAttribute;

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
        for (ClassFile cf : classGroup.getClassFiles()) {
            if (cf.getAttributes().hasType(SignatureAttribute.class)) {
                System.out.println(cf.getAttributes().ofType(SignatureAttribute.class).getSignature());
            }
        }
    }

    public static void main2(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("./181/w.class");
        ClassFile classFile = new ClassFile(inputStream.readAllBytes());
    }

}
