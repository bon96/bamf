package org.bon.jvm.constantpool.constants;

import org.bon.jvm.util.MethodDescriptor;

/**
 * Tommi
 * Date: 28/11/2019
 * Time: 22.41
 */

public interface MethodConstant extends ClassMemberConstant {

    String getName();

    MethodDescriptor getDescriptor();

    NameAndTypeConstant getNameAndType();
}
