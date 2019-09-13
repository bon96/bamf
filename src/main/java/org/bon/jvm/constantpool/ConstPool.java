package org.bon.jvm.constantpool;

import org.bon.jvm.constantpool.constants.*;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.4
 */


public class ConstPool {


    //TODO figure out what should we do about longs and doubles taking two spots in the list.
    //TODO Should there be null after longs and doubles or something else?


    private List<Constant> constants = new ArrayList<>();

    public ConstPool(ByteBuffer byteBuffer, int constPoolSize) {
        for (int i = 0; i < constPoolSize - 1; i++) {
            int tag = byteBuffer.get();
            switch (tag) {
                case Constant.FIELD_REF:
                    constants.add(new FieldRefConstant(byteBuffer, this));
                    break;

                case Constant.METHOD_REF:
                    constants.add(new MethodRefConstant(byteBuffer, this));
                    break;

                case Constant.CLASS:
                    constants.add(new ClassConstant(byteBuffer, this));
                    break;

                case Constant.INTERFACE_METHOD_REF:
                    constants.add(new InterfaceMethodRefConstant(byteBuffer, this));
                    break;

                case Constant.STRING:
                    constants.add(new StringConstant(byteBuffer, this));
                    break;

                case Constant.UTF8:
                    constants.add(new Utf8Constant(byteBuffer));
                    break;

                case Constant.NAME_AND_TYPE:
                    constants.add(new NameAndTypeConstant(byteBuffer, this));
                    break;

                case Constant.INTEGER:
                    constants.add(new IntegerConstant(byteBuffer));
                    break;

                case Constant.FLOAT:
                    constants.add(new FloatConstant(byteBuffer));
                    break;

                case Constant.DOUBLE:
                    constants.add(new DoubleConstant(byteBuffer));
                    constants.add(null);
                    i++;
                    break;

                case Constant.LONG:
                    constants.add(new LongConstant(byteBuffer));
                    constants.add(null);
                    i++;
                    break;

                case Constant.METHOD_HANDLE:
                    constants.add(new MethodHandleConstant(byteBuffer, this));
                    break;

                case Constant.METHOD_TYPE:
                    constants.add(new MethodTypeConstant(byteBuffer, this));
                    break;

                case Constant.DYNAMIC:
                    constants.add(new DynamicConstant(byteBuffer, this));
                    break;

                case Constant.INVOKE_DYNAMIC:
                    constants.add(new InvokeDynamicConstant(byteBuffer, this));
                    break;

                case Constant.MODULE:
                    constants.add(new ModuleConstant(byteBuffer, this));
                    break;

                case Constant.PACKAGE:
                    constants.add(new PackageConstant(byteBuffer, this));
                    break;

                default:
                    throw new RuntimeException("Unknown const tag " + tag + " at " + i + "/" + constPoolSize);
            }
        }
    }

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
}
