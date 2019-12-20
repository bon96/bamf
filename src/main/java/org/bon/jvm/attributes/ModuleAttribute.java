package org.bon.jvm.attributes;

/**
 * Tommi
 * Date: 13/12/2019
 * Time: 22.17
 */

import org.bon.jvm.constantpool.ConstPool;
import org.bon.jvm.constantpool.constants.ClassConstant;
import org.bon.jvm.constantpool.constants.ModuleConstant;
import org.bon.jvm.constantpool.constants.PackageConstant;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.25
 */

public class ModuleAttribute extends Attribute {
    public static final int ACC_OPEN = 0x0020;
    public static final int ACC_SYNTHETIC = 0x1000;
    public static final int ACC_MANDATED = 0x8000;

    private String moduleName;
    private int flags;
    private String version;

    private List<Requires> requires = new ArrayList<>();
    private List<Exports> exports = new ArrayList<>();
    private List<Opens> opens = new ArrayList<>();
    private List<ClassConstant> uses = new ArrayList<>();
    private List<Provides> provides = new ArrayList<>();

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Requires> getRequires() {
        return requires;
    }

    public void setRequires(List<Requires> requires) {
        this.requires = requires;
    }

    public List<Exports> getExports() {
        return exports;
    }

    public void setExports(List<Exports> exports) {
        this.exports = exports;
    }

    public List<Opens> getOpens() {
        return opens;
    }

    public void setOpens(List<Opens> opens) {
        this.opens = opens;
    }

    public List<ClassConstant> getUses() {
        return uses;
    }

    public void setUses(List<ClassConstant> uses) {
        this.uses = uses;
    }

    public List<Provides> getProvides() {
        return provides;
    }

    public void setProvides(List<Provides> provides) {
        this.provides = provides;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }


    public static ModuleAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        ModuleAttribute a = new ModuleAttribute();

        a.moduleName = constPool.get(in.readUnsignedShort()).toString();
        a.flags = in.readUnsignedShort();

        int versionIndex = in.readUnsignedShort();
        if (versionIndex != 0) {
            a.version = constPool.get(versionIndex).toString();
        }

        int requiresCount = in.readUnsignedShort();
        for (int i = 0; i < requiresCount; i++) {
            a.requires.add(Requires.from(in, constPool));
        }

        int exportsCount = in.readUnsignedShort();
        for (int i = 0; i < exportsCount; i++) {
            a.exports.add(Exports.from(in, constPool));
        }

        int opensCount = in.readUnsignedShort();
        for (int i = 0; i < opensCount; i++) {
            a.opens.add(Opens.from(in, constPool));
        }

        int usesCount = in.readUnsignedShort();
        for (int i = 0; i < usesCount; i++) {
            a.uses.add(constPool.get(in.readUnsignedShort()).cast());
        }

        int providesCount = in.readUnsignedShort();
        for (int i = 0; i < providesCount; i++) {
            a.provides.add(Provides.from(in, constPool));
        }

        return a;
    }

    public static class Requires {
        public static final int ACC_TRANSITIVE = 0x0020;
        public static final int ACC_STATIC_PHASE = 0x0040;
        public static final int ACC_SYNTHETIC = 0x1000;
        public static final int ACC_MANDATED = 0x8000;

        private ModuleConstant module;
        private int flags;
        private String version;

        public ModuleConstant getModule() {
            return module;
        }

        public void setModule(ModuleConstant module) {
            this.module = module;
        }

        public int getFlags() {
            return flags;
        }

        public void setFlags(int flags) {
            this.flags = flags;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public static Requires from(DataInputStream in, ConstPool constPool) throws IOException {
            Requires requires = new Requires();

            requires.module = constPool.get(in.readUnsignedShort()).cast();
            requires.flags = in.readUnsignedShort();
            requires.version = constPool.get(in.readUnsignedShort()).toString();
            return requires;
        }
    }

    public static class Exports {
        public static final int ACC_SYNTHETIC = 0x1000;
        public static final int ACC_MANDATED = 0x8000;

        private PackageConstant packageEx;
        private int flags;
        private List<ModuleConstant> exportsTo = new ArrayList<>();

        public PackageConstant getPackageEx() {
            return packageEx;
        }

        public void setPackageEx(PackageConstant packageEx) {
            this.packageEx = packageEx;
        }

        public int getFlags() {
            return flags;
        }

        public void setFlags(int flags) {
            this.flags = flags;
        }

        public List<ModuleConstant> getExportsTo() {
            return exportsTo;
        }

        public void setExportsTo(List<ModuleConstant> exportsTo) {
            this.exportsTo = exportsTo;
        }

        public static Exports from(DataInputStream in, ConstPool constPool) throws IOException {
            Exports exports = new Exports();

            exports.packageEx = constPool.get(in.readUnsignedShort()).cast();
            exports.flags = in.readUnsignedShort();

            int exportsToCount = in.readUnsignedShort();
            for (int i = 0; i < exportsToCount; i++) {
                exports.exportsTo.add(constPool.get(in.readUnsignedShort()).cast());
            }
            return exports;
        }
    }

    public static class Opens {
        public static final int ACC_SYNTHETIC = 0x1000;
        public static final int ACC_MANDATED = 0x8000;

        private PackageConstant packageOp;
        private int flags;
        private List<ModuleConstant> opensTo = new ArrayList<>();

        public PackageConstant getPackageOp() {
            return packageOp;
        }

        public void setPackageOp(PackageConstant packageOp) {
            this.packageOp = packageOp;
        }

        public int getFlags() {
            return flags;
        }

        public void setFlags(int flags) {
            this.flags = flags;
        }

        public List<ModuleConstant> getOpensTo() {
            return opensTo;
        }

        public void setOpensTo(List<ModuleConstant> opensTo) {
            this.opensTo = opensTo;
        }

        public static Opens from(DataInputStream in, ConstPool constPool) throws IOException {
            Opens opens = new Opens();

            opens.packageOp = constPool.get(in.readUnsignedShort()).cast();
            opens.flags = in.readUnsignedShort();

            int opensToCount = in.readUnsignedShort();
            for (int i = 0; i < opensToCount; i++) {
                opens.opensTo.add(constPool.get(in.readUnsignedShort()).cast());
            }
            return opens;
        }
    }

    public static class Provides {

        private ClassConstant provides;
        private List<ClassConstant> providesWith = new ArrayList<>();

        public ClassConstant getProvides() {
            return provides;
        }

        public void setProvides(ClassConstant provides) {
            this.provides = provides;
        }

        public List<ClassConstant> getProvidesWith() {
            return providesWith;
        }

        public void setProvidesWith(List<ClassConstant> providesWith) {
            this.providesWith = providesWith;
        }

        public static Provides from(DataInputStream in, ConstPool constPool) throws IOException {
            Provides provides = new Provides();

            provides.provides = constPool.get(in.readUnsignedShort()).cast();

            int providesWithCount = in.readUnsignedShort();
            for (int i = 0; i < providesWithCount; i++) {
                provides.providesWith.add(constPool.get(in.readUnsignedShort()).cast());
            }

            return provides;
        }
    }

}
