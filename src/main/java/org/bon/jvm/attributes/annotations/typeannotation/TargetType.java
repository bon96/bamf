package org.bon.jvm.attributes.annotations.typeannotation;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tommi
 * Date: 14/12/2019
 * Time: 3.08
 */

//TODO meaningful methods for handling of types
public class TargetType {

    public static TargetType from(DataInputStream in, ConstPool constPool) throws IOException {
        int type = in.readUnsignedByte();

        switch (type) {
            case 0x00:
            case 0x01:
                return TypeParameter.from(in);
            case 0x10:
                return SuperType.from(in);
            case 0x11:
            case 0x12:
                return TypeParameterBound.from(in);
            case 0x13:
            case 0x14:
            case 0x15:
                return Empty.from(in);
            case 0x16:
                return FormalParameter.from(in);
            case 0x17:
                return Throws.from(in);
            case 0x40:
            case 0x41:
                return Localvar.from(in);
            case 0x42:
                return Catch.from(in);
            case 0x43:
            case 0x44:
            case 0x45:
            case 0x46:
                return Offset.from(in);
            case 0x47:
            case 0x48:
            case 0x49:
            case 0x4A:
            case 0x4B:
                return TypeArgument.from(in);

            default:
                throw new IOException("Unknown target type " + type);
        }
    }

    public static class TypeParameter extends TargetType {

        private int index;

        public TypeParameter(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public static TypeParameter from(DataInputStream in) throws IOException {
            return new TypeParameter(in.readUnsignedByte());
        }
    }

    public static class SuperType extends TargetType {

        private int index;

        public SuperType(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public static SuperType from(DataInputStream in) throws IOException {
            return new SuperType(in.readUnsignedShort());
        }
    }

    public static class TypeParameterBound extends TargetType {

        private int index;
        private int boundIndex;

        public TypeParameterBound(int index, int boundIndex) {
            this.index = index;
            this.boundIndex = boundIndex;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getBoundIndex() {
            return boundIndex;
        }

        public void setBoundIndex(int boundIndex) {
            this.boundIndex = boundIndex;
        }

        public static TypeParameterBound from(DataInputStream in) throws IOException {
            return new TypeParameterBound(in.readUnsignedByte(), in.readUnsignedByte());
        }
    }

    public static class Empty extends TargetType {
        public static Empty from(DataInputStream in) throws IOException {
            return new Empty();
        }
    }

    public static class FormalParameter extends TargetType {

        private int index;

        public FormalParameter(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public static FormalParameter from(DataInputStream in) throws IOException {
            return new FormalParameter(in.readUnsignedByte());
        }
    }

    public static class Throws extends TargetType {

        private int index;

        public Throws(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public static Throws from(DataInputStream in) throws IOException {
            return new Throws(in.readUnsignedShort());
        }
    }

    public static class Localvar extends TargetType {

        private List<Entry> entries;

        public Localvar() {
            entries = new ArrayList<>();
        }

        public Localvar(List<Entry> entries) {
            this.entries = entries;
        }

        public List<Entry> getEntries() {
            return entries;
        }

        public void setEntries(List<Entry> entries) {
            this.entries = entries;
        }

        public static Localvar from(DataInputStream in) throws IOException {
            Localvar target = new Localvar();

            int tableLength = in.readUnsignedShort();
            for (int i = 0; i < tableLength; i++) {
                target.entries.add(Entry.from(in));
            }
            return target;
        }

        public static class Entry extends TargetType {

            private int startPc;
            private int length;
            private int index;

            public Entry(int startPc, int length, int index) {
                this.startPc = startPc;
                this.length = length;
                this.index = index;
            }

            public int getStartPc() {
                return startPc;
            }

            public void setStartPc(int startPc) {
                this.startPc = startPc;
            }

            public int getLength() {
                return length;
            }

            public void setLength(int length) {
                this.length = length;
            }

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

            public static Entry from(DataInputStream in) throws IOException {
                return new Entry(in.readUnsignedShort(), in.readUnsignedShort(), in.readUnsignedShort());
            }
        }
    }

    public static class Catch extends TargetType {

        private int index;

        public Catch(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public static Catch from(DataInputStream in) throws IOException {
            return new Catch(in.readUnsignedShort());
        }
    }

    public static class Offset extends TargetType {

        private int offset;

        public Offset(int offset) {
            this.offset = offset;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public static Offset from(DataInputStream in) throws IOException {
            return new Offset(in.readUnsignedShort());
        }
    }

    public static class TypeArgument extends TargetType {

        private int offset;
        private int index;

        public TypeArgument(int offset, int index) {
            this.offset = offset;
            this.index = index;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public static TypeArgument from(DataInputStream in) throws IOException {
            return new TypeArgument(in.readUnsignedShort(), in.readUnsignedByte());
        }
    }

}
