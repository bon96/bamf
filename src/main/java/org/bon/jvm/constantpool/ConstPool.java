package org.bon.jvm.constantpool;

import org.bon.jvm.constantpool.constants.*;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4
 */


public class ConstPool {
    //TODO figure out what should we do about longs and doubles taking two spots in the list.
    //TODO Should there be null after longs and doubles or something else?

    private List<Constant> constants = new ArrayList<>();

    /**
     * @param index of constant in the constant pool
     * @return index-1 from the constant list which represents the constant pool.
     */

    public Constant get(int index) {
        return getConstants().get(index - 1);
    }

    public List<Constant> getConstants() {
        return constants;
    }

    public static ConstPool from(DataInputStream in, int size) throws IOException {
        ConstPool constPool = new ConstPool();

        for (int i = 0; i < size - 1; i++) {
            int tag = in.readUnsignedByte();
            System.out.println("Const=" + tag);
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
