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

    public ClassFile(byte[] classBytes) {
        ByteBuffer byteBuf = ByteBuffer.wrap(classBytes);

        this.magic = byteBuf.getInt();
        this.minorVersion = byteBuf.getShort();
        this.majorVersion = byteBuf.getShort();
        this.constPoolSize = byteBuf.getShort();

        ConstPool constPool = new ConstPool(byteBuf, constPoolSize);

        this.accessFlags = byteBuf.getShort();
        this.thisClassIndex = byteBuf.getShort();
        this.superClassIndex = byteBuf.getShort();

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

    /**
     * Declared public; may be accessed from outside its package.
     * @return true if access is public.
     */

    public boolean isAccPublic() {
        return (accessFlags & 0x0001) != 0;
    }


    /**
     * Declared final; no subclasses allowed.
     * @return true if ClassFile is final.
     */

    public boolean isAccFinal() {
        return (accessFlags & 0x0010) != 0;
    }


    /**
     * The ACC_SUPER flag indicates which of two alternative semantics
     * is to be expressed by the invokespecial instruction (§invokespecial)
     * if it appears in this class or interface.
     * Compilers to the instruction set of the Java Virtual Machine should set the ACC_SUPER flag.
     * In Java SE 8 and above,
     * the Java Virtual Machine considers the ACC_SUPER flag to be set in every class file,
     * regardless of the actual value of the flag in the class file and the version of the class file.
     *
     * The ACC_SUPER flag exists for backward compatibility
     * with code compiled by older compilers for the Java programming language.
     * In JDK releases prior to 1.0.2,
     * the compiler generated access_flags in which the flag now representing ACC_SUPER had no assigned meaning,
     * and Oracle's Java Virtual Machine implementation ignored the flag if it was set.
     * @return true if access flag super is enabled.
     */

    @Deprecated
    public boolean isAccSuper() {
        return (accessFlags & 0x0020) != 0;
    }


    /**
     * If the ACC_INTERFACE flag is not set, this class file defines a class, not an interface or module.
     *
     * If the ACC_INTERFACE flag is set, the ACC_ABSTRACT flag must also be set,
     * and the ACC_FINAL, ACC_SUPER, ACC_ENUM, and ACC_MODULE flags set must not be set.
     *
     * If the ACC_INTERFACE flag is not set,
     * any of the other flags in Table 4.1-B may be set except ACC_ANNOTATION and ACC_MODULE.
     * However, such a class file must not have both its ACC_FINAL and ACC_ABSTRACT flags set (JLS §8.1.1.2).
     * @return true if ClassFile is an interface.
     */

    public boolean isAccInterface() {
        return (accessFlags & 0x0200) != 0;
    }


    /**
     * Declared abstract; must not be instantiated.
     * @return true if ClassFile is abstract.
     */

    public boolean isAccAbstract() {
        return (accessFlags & 0x0400) != 0;
    }


    /**
     * The ACC_SYNTHETIC flag indicates that this class or interface was generated by a compiler
     * and does not appear in source code.
     * @return true if ClassFile is a class or an interface generated by a compiler.
     */

    public boolean isAccSynthetic() {
        return (accessFlags & 0x1000) != 0;
    }


    /**
     * An annotation type (JLS §9.6) must have its ACC_ANNOTATION flag set.
     * If the ACC_ANNOTATION flag is set, the ACC_INTERFACE flag must also be set.
     * @return true if ClassFile is an annotation.
     */

    public boolean isAccAnnotation() {
        return (accessFlags & 0x2000) != 0;
    }


    /**
     * The ACC_ENUM flag indicates that this class or its superclass is declared as an enumerated type (JLS §8.9).
     * @return true if ClassFile or its superclass is an enum.
     */

    public boolean isAccEnum() {
        return (accessFlags & 0x4000) != 0;
    }


    /**
     * The ACC_MODULE flag indicates that this class file defines a module,
     * not a class or interface. If the ACC_MODULE flag is set,
     * then special rules apply to the class file which are given at the end of this section.
     * If the ACC_MODULE flag is not set,
     * then the rules immediately below the current paragraph apply to the class file.
     * @return true if ClassFile is a module.
     */

    public boolean isAccModule() {
        return (accessFlags & 0x8000) != 0;
    }
}
