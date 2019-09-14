package org.bon.jvm;


import org.bon.jvm.attributes.Attribute;
import org.bon.jvm.attributes.Attributes;
import org.bon.jvm.attributes.SourceFileAttribute;
import org.bon.jvm.constantpool.ConstPool;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html
 */

public class ClassFile {

    private int magic;
    private int minorVersion;
    private int majorVersion;
    private int constPoolSize;
    private int accessFlags;
    private int thisClassIndex;
    private int superClassIndex;

    private List<Interface> interfaces = new ArrayList<>();
    private List<Field> fields = new ArrayList<>();
    private List<Method> methods = new ArrayList<>();
    private List<Attribute> attributes = new ArrayList<>();

    private ConstPool constPool;

    public ClassFile(byte[] classBytes) {
        ByteBuffer byteBuf = ByteBuffer.wrap(classBytes);

        magic = byteBuf.getInt();
        minorVersion = byteBuf.getShort();
        majorVersion = byteBuf.getShort();
        constPoolSize = byteBuf.getShort();

        constPool = new ConstPool(byteBuf, constPoolSize);

        accessFlags = byteBuf.getShort();
        thisClassIndex = byteBuf.getShort();
        superClassIndex = byteBuf.getShort();

        int interfacesCount = byteBuf.getShort();
        for (int i = 0; i < interfacesCount; i++) {
            interfaces.add(new Interface(constPool.get(byteBuf.getShort()).cast()));
        }

        int fieldCount = byteBuf.getShort();
        for (int i = 0; i < fieldCount; i++) {
            fields.add(new Field(byteBuf, constPool));
        }

        int methodCount = byteBuf.getShort();
        for (int i = 0; i < methodCount; i++) {
            methods.add(new Method(byteBuf, constPool));
        }

        int attributeCount = byteBuf.getShort();
        for (int i = 0; i < attributeCount; i++) {
            attributes.add(Attribute.from(byteBuf, constPool));
        }
    }

    public String getSuperName() {
        return constPool.get(superClassIndex).toString();
    }

    public int getMinorVersion() {
        return minorVersion;
    }

    public int getMajorVersion() {
        return majorVersion;
    }

    public int getConstPoolSize() {
        return constPoolSize;
    }

    public boolean verifyMagic() {
        return magic == 0xCAFEBABE;
    }

    public List<Interface> getInterfaces() {
        return interfaces;
    }

    public List<Field> getFields() {
        return fields;
    }

    public List<Method> getMethods() {
        return methods;
    }

    public Attributes getAttributes() {
        return new Attributes(attributes);
    }

    public String getName() {
        return getAttributes().ofType(SourceFileAttribute.class).getSourceFileName();
    }

    public boolean isAccPublic() {
        return (accessFlags & 0x0001) != 0;
    }

    public boolean isAccFinal() {
        return (accessFlags & 0x0010) != 0;
    }

    public boolean isAccAbstract() {
        return (accessFlags & 0x0400) != 0;
    }

    public boolean isAccAnnotation() {
        return (accessFlags & 0x2000) != 0;
    }

    public boolean isAccEnum() {
        return (accessFlags & 0x4000) != 0;
    }

    public boolean isAccModule() {
        return (accessFlags & 0x8000) != 0;
    }

    /**
     * The ACC_SUPER flag indicates which of two alternative semantics
     * is to be expressed by the invokespecial instruction (§invokespecial)
     * if it appears in this class or interface.
     * Compilers to the instruction set of the Java Virtual Machine should set the ACC_SUPER flag.
     * In Java SE 8 and above,
     * the Java Virtual Machine considers the ACC_SUPER flag to be set in every class file,
     * regardless of the actual value of the flag in the class file and the version of the class file.
     * <p>
     * The ACC_SUPER flag exists for backward compatibility
     * with code compiled by older compilers for the Java programming language.
     * In JDK releases prior to 1.0.2,
     * the compiler generated access_flags in which the flag now representing ACC_SUPER had no assigned meaning,
     * and Oracle's Java Virtual Machine implementation ignored the flag if it was set.
     *
     * @return true if access flag super is enabled.
     */

    @Deprecated
    public boolean isAccSuper() {
        return (accessFlags & 0x0020) != 0;
    }


    /**
     * If the ACC_INTERFACE flag is not set, this class file defines a class, not an interface or module.
     * <p>
     * If the ACC_INTERFACE flag is set, the ACC_ABSTRACT flag must also be set,
     * and the ACC_FINAL, ACC_SUPER, ACC_ENUM, and ACC_MODULE flags set must not be set.
     * <p>
     * If the ACC_INTERFACE flag is not set,
     * any of the other flags in Table 4.1-B may be set except ACC_ANNOTATION and ACC_MODULE.
     * However, such a class file must not have both its ACC_FINAL and ACC_ABSTRACT flags set (JLS §8.1.1.2).
     *
     * @return true if ClassFile is an interface.
     */

    public boolean isAccInterface() {
        return (accessFlags & 0x0200) != 0;
    }

    /**
     * The ACC_SYNTHETIC flag indicates that this class or interface was generated by a compiler
     * and does not appear in source code.
     *
     * @return true if ClassFile is a class or an interface generated by a compiler.
     */

    public boolean isAccSynthetic() {
        return (accessFlags & 0x1000) != 0;
    }
}
