package org.bon.jvm.attributes;

/**
 * Tommi
 * Date: 13/12/2019
 * Time: 22.17
 */

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.PackageConstant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.26
 */

public class ModulePackagesAttribute extends Attribute {

    private List<PackageConstant> packages = new ArrayList<>();

    public List<PackageConstant> getPackages() {
        return packages;
    }

    @Override
    public void writeTo(DataOutputStream out) throws IOException {

    }

    public static ModulePackagesAttribute from(DataInputStream in, ConstPool constPool, int nameIndex, int length) throws IOException {
        ModulePackagesAttribute a = new ModulePackagesAttribute();
        a.constPool = constPool;
        a.nameIndex = nameIndex;
        a.length = length;

        int packageCount = in.readUnsignedShort();
        for (int i = 0; i < packageCount; i++) {
            a.packages.add((PackageConstant) constPool.get(in.readUnsignedShort()));
        }
        return a;
    }
}
