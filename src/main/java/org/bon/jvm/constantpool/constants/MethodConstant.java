package org.bon.jvm.constantpool.constants;

/**
 * Tommi
 * Date: 28/11/2019
 * Time: 22.41
 */

public interface MethodConstant {

    ClassConstant getConstClass();

    NameAndTypeConstant getNameAndType();
}
