package org.bon.jvm.constantpool;

import org.bon.jvm.ClassFile;
import org.bon.jvm.constantpool.constants.ClassConstant;
import org.bon.jvm.constantpool.constants.Constant;
import org.bon.jvm.constantpool.constants.DoubleConstant;
import org.bon.jvm.constantpool.constants.DynamicConstant;
import org.bon.jvm.constantpool.constants.FieldRefConstant;
import org.bon.jvm.constantpool.constants.FloatConstant;
import org.bon.jvm.constantpool.constants.IntegerConstant;
import org.bon.jvm.constantpool.constants.InterfaceMethodRefConstant;
import org.bon.jvm.constantpool.constants.InvokeDynamicConstant;
import org.bon.jvm.constantpool.constants.LongConstant;
import org.bon.jvm.constantpool.constants.MethodHandleConstant;
import org.bon.jvm.constantpool.constants.MethodRefConstant;
import org.bon.jvm.constantpool.constants.MethodTypeConstant;
import org.bon.jvm.constantpool.constants.ModuleConstant;
import org.bon.jvm.constantpool.constants.NameAndTypeConstant;
import org.bon.jvm.constantpool.constants.PackageConstant;
import org.bon.jvm.constantpool.constants.StringConstant;
import org.bon.jvm.constantpool.constants.Utf8Constant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4
 */

public class ConstPool {

    private ClassFile classFile;

    //TODO is there a better way to handle doubles and longs taking 2 spots than adding a null?
    private List<Constant> constants = new ArrayList<>();

    public ConstPool(ClassFile classFile) {
        this.classFile = classFile;
    }


    public void add(Constant constant) {
        constants.add(constant);

        //doubles and longs take 2 spots in the constant pool
        if (constant instanceof DoubleConstant || constant instanceof LongConstant) {
            constants.add(null);
        }
    }

    /**
     * @param index of constant in the constant pool
     * @return index-1 from the constant list which represents the constant pool.
     */

    public Constant get(int index) {
        return getConstants().get(index - 1);
    }

    public <T extends Constant> T get(int index, Class<T> castTo) {
        return get(index).cast();
    }

    public List<Constant> getConstants() {
        return constants;
    }

    public ClassFile getClassFile() {
        return classFile;
    }

    public int size() {
        return constants.size();
    }

    public ConstPool writeTo(DataOutputStream out) throws IOException {
        out.writeShort(size());

        //rebuild constant pool from modified constants
        ConstPool constPool = new ConstPool(classFile);

        for (Constant constant : getConstants()) {
            if (constant != null) {
                constant.writeTo(out, constPool);
            }
        }

        return constPool;
    }

    public static ConstPool from(DataInputStream in, int size, ClassFile classFile) throws IOException {
        ConstPool constPool = new ConstPool(classFile);

        for (int i = 0; i < size - 1; i++) {
            int tag = in.readByte();
            switch (tag) {
                case Constant.FIELD_REF:
                    constPool.constants.add(FieldRefConstant.from(in, constPool));
                    break;

                case Constant.METHOD_REF:
                    constPool.constants.add(MethodRefConstant.from(in, constPool));
                    break;

                case Constant.CLASS:
                    constPool.constants.add(ClassConstant.from(in, constPool));
                    break;

                case Constant.INTERFACE_METHOD_REF:
                    constPool.constants.add(InterfaceMethodRefConstant.from(in, constPool));
                    break;

                case Constant.STRING:
                    constPool.constants.add(StringConstant.from(in, constPool));
                    break;

                case Constant.UTF8:
                    constPool.constants.add(Utf8Constant.from(in));
                    break;

                case Constant.NAME_AND_TYPE:
                    constPool.constants.add(NameAndTypeConstant.from(in, constPool));
                    break;

                case Constant.INTEGER:
                    constPool.constants.add(IntegerConstant.from(in));
                    break;

                case Constant.FLOAT:
                    constPool.constants.add(FloatConstant.from(in));
                    break;

                case Constant.DOUBLE:
                    constPool.constants.add(DoubleConstant.from(in));
                    constPool.constants.add(null);
                    i++;
                    break;

                case Constant.LONG:
                    constPool.constants.add(LongConstant.from(in));
                    constPool.constants.add(null);
                    i++;
                    break;

                case Constant.METHOD_HANDLE:
                    constPool.constants.add(MethodHandleConstant.from(in, constPool));
                    break;

                case Constant.METHOD_TYPE:
                    constPool.constants.add(MethodTypeConstant.from(in, constPool));
                    break;

                case Constant.DYNAMIC:
                    constPool.constants.add(DynamicConstant.from(in, constPool));
                    break;

                case Constant.INVOKE_DYNAMIC:
                    constPool.constants.add(InvokeDynamicConstant.from(in, constPool));
                    break;

                case Constant.MODULE:
                    constPool.constants.add(ModuleConstant.from(in, constPool));
                    break;

                case Constant.PACKAGE:
                    constPool.constants.add(PackageConstant.from(in, constPool));
                    break;

                default:
                    throw new RuntimeException("Unknown const tag " + tag + " at " + i + "/" + size);
            }
        }
        return constPool;
    }
}
