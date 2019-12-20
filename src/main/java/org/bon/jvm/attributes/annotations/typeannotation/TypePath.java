package org.bon.jvm.attributes.annotations.typeannotation;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Tommi
 * Date: 14/12/2019
 * Time: 3.41
 */

public class TypePath {

    private List<Entry> path;

    public TypePath() {
        path = new ArrayList<>();
    }

    public TypePath(List<Entry> path) {
        this.path = path;
    }

    public List<Entry> getPath() {
        return path;
    }

    public void setPath(List<Entry> path) {
        this.path = path;
    }

    public static TypePath from(DataInputStream in) throws IOException {
        TypePath typePath = new TypePath();

        int pathLength = in.readUnsignedByte();
        for (int i = 0; i < pathLength; i++) {
            typePath.path.add(Entry.from(in));
        }
        return typePath;
    }

    public static class Entry {

        private int kind;
        private int index;

        public Entry(int kind, int index) {
            this.kind = kind;
            this.index = index;
        }

        public int getKind() {
            return kind;
        }

        public void setKind(int kind) {
            this.kind = kind;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public static Entry from(DataInputStream in) throws IOException {
            return new Entry(in.readUnsignedByte(), in.readUnsignedByte());
        }
    }


}
