package org.bon.jvm.attributes;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-4.html#jvms-4.7.12
 */

public class LineNumberTableAttribute extends Attribute {

    private List<LineNumber> lineNumbers;

    public LineNumberTableAttribute() {
        lineNumbers = new ArrayList<>();
    }

    public LineNumberTableAttribute(List<LineNumber> lineNumbers) {
        this.lineNumbers = lineNumbers;
    }

    public List<LineNumber> getLineNumbers() {
        return lineNumbers;
    }

    public void setLineNumbers(List<LineNumber> lineNumbers) {
        this.lineNumbers = lineNumbers;
    }

    @Override
    public void writeTo(DataOutputStream out, ConstPool constPool) throws IOException {

    }

    public static LineNumberTableAttribute from(DataInputStream in, ConstPool constPool, int length) throws IOException {
        LineNumberTableAttribute a = new LineNumberTableAttribute();

        int tableLength = in.readUnsignedShort();
        for (int i = 0; i < tableLength; i++) {
            a.lineNumbers.add(new LineNumber(in.readUnsignedShort(), in.readUnsignedShort()));
        }
        return a;
    }

    public static class LineNumber {
        private int startPc;
        private int lineNumber;

        public LineNumber(int startPc, int lineNumber) {
            this.startPc = startPc;
            this.lineNumber = lineNumber;
        }

        public int getStartPc() {
            return startPc;
        }

        public int getLineNumber() {
            return lineNumber;
        }

        @Override
        public String toString() {
            return "LineNumber{" +
                    "startPc=" + startPc +
                    ", lineNumber=" + lineNumber +
                    '}';
        }
    }
}
