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
        for (int i = 0; i < constPoolSize-1; i++) {
            int tag = byteBuffer.get();
            switch (tag) {
                case Constant.FIELDREF:
                    constants.add(new ConstantFieldRef(byteBuffer, this));
                    break;

                case Constant.METHODREF:
                    constants.add(new ConstantMethodRef(byteBuffer, this));
                    break;

                case Constant.CLASS:
                    constants.add(new ConstantClass(byteBuffer, this));
                    break;

                case Constant.INTERFACEMETHODREF:
                    constants.add(new ConstantInterfaceMethodRef(byteBuffer, this));
                    break;

                case Constant.STRING:
                    constants.add(new ConstantString(byteBuffer, this));
                    break;

                case Constant.UTF8:
                    constants.add(new ConstantUtf8(byteBuffer));
                    break;

                case Constant.NAME_AND_TYPE:
                    constants.add(new ConstantNameAndType(byteBuffer, this));
                    break;

                case Constant.INTEGER:
                    constants.add(new ConstantInteger(byteBuffer));
                    break;

                case Constant.FLOAT:
                    constants.add(new ConstantFloat(byteBuffer));
                    break;

                case Constant.DOUBLE:
                    constants.add(new ConstantDouble(byteBuffer));
                    constants.add(null);
                    i++;
                    break;

                case Constant.LONG:
                    constants.add(new ConstantLong(byteBuffer));
                    constants.add(null);
                    i++;
                    break;

                case Constant.METHOD_HANDLE:
                    constants.add(new ConstantMethodHandle(byteBuffer, this));
                    break;

                case Constant.METHOD_TYPE:
                    constants.add(new ConstantMethodType(byteBuffer, this));
                    break;

                case Constant.DYNAMIC:
                    constants.add(new ConstantDynamic(byteBuffer, this));
                    break;

                case Constant.INVOKE_DYNAMIC:
                    constants.add(new ConstantInvokeDynamic(byteBuffer, this));
                    break;

                default:
                    throw new RuntimeException("Unknown const tag " + tag + " at " + i + "/" + constPoolSize);
            }
        }
    }

    /**
     *
     * @param index of constant in the constant pool
     * @return index-1 from the constant list which represents the constant pool.
     */

    public Constant get(int index) {
        return getConstants().get(index-1);
    }

    public List<Constant> getConstants() {
        return constants;
    }
}
