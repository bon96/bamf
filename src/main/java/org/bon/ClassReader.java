package org.bon;

import org.bon.api.ClassGroup;
import org.bon.jvm.ClassFile;
import org.bon.jvm.attributes.SignatureAttribute;

import java.util.jar.JarFile;


public class ClassReader {
    public static void main(String[] args) throws Exception {
        ClassGroup classGroup = ClassGroup.from(new JarFile("./181.jar"));
        for (ClassFile cf : classGroup.getClassFiles()) {
            if (cf.getAttributes().hasType(SignatureAttribute.class)) {
                System.out.println(cf.getAttributes().ofType(SignatureAttribute.class).getSignature());
            }
        }
    }
}
