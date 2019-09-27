package org.bon.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 18.41
 */

public class InsClassGenerator {

    public static String opcodes = "aaload 32\n" +
            "aastore 53\n" +
            "aconst_null 01\n" +
            "aload 19\n" +
            "aload_0 2a\n" +
            "aload_1 2b\n" +
            "aload_2 2c\n" +
            "aload_3 2d\n" +
            "anewarray bd\n" +
            "areturn b0\n" +
            "arraylength be\n" +
            "astore 3a\n" +
            "astore_0 4b\n" +
            "astore_1 4c\n" +
            "astore_2 4d\n" +
            "astore_3 4e\n" +
            "athrow bf\n" +
            "baload 33\n" +
            "bastore 54\n" +
            "bipush 10\n" +
            "caload 34\n" +
            "castore 55\n" +
            "checkcast c0\n" +
            "d2f 90\n" +
            "d2i 8e\n" +
            "d2l 8f\n" +
            "dadd 63\n" +
            "daload 31\n" +
            "dastore 52\n" +
            "dcmpg 98\n" +
            "dcmpl 97\n" +
            "dconst_0 0e\n" +
            "dconst_1 0f\n" +
            "ddiv 6f\n" +
            "dload 18\n" +
            "dload_0 26\n" +
            "dload_1 27\n" +
            "dload_2 28\n" +
            "dload_3 29\n" +
            "dmul 6b\n" +
            "dneg 77\n" +
            "drem 73\n" +
            "dreturn af\n" +
            "dstore 39\n" +
            "dstore_0 47\n" +
            "dstore_1 48\n" +
            "dstore_2 49\n" +
            "dstore_3 4a\n" +
            "dsub 67\n" +
            "dup 59\n" +
            "dup_x1 5a\n" +
            "dup_x2 5b\n" +
            "dup2 5c\n" +
            "dup2_x1 5d\n" +
            "dup2_x2 5e\n" +
            "f2d 8d\n" +
            "f2i 8b\n" +
            "f2l 8c\n" +
            "fadd 62\n" +
            "faload 30\n" +
            "fastore 51\n" +
            "fcmpg 96\n" +
            "fcmpl 95\n" +
            "fconst_0 0b\n" +
            "fconst_1 0c\n" +
            "fconst_2 0d\n" +
            "fdiv 6e\n" +
            "fload 17\n" +
            "fload_0 22\n" +
            "fload_1 23\n" +
            "fload_2 24\n" +
            "fload_3 25\n" +
            "fmul 6a\n" +
            "fneg 76\n" +
            "frem 72\n" +
            "freturn ae\n" +
            "fstore 38\n" +
            "fstore_0 43\n" +
            "fstore_1 44\n" +
            "fstore_2 45\n" +
            "fstore_3 46\n" +
            "fsub 66\n" +
            "getfield b4\n" +
            "getstatic b2\n" +
            "goto a7\n" +
            "goto_w c8\n" +
            "i2b 91\n" +
            "i2c 92\n" +
            "i2d 87\n" +
            "i2f 86\n" +
            "i2l 85\n" +
            "i2s 93\n" +
            "iadd 60\n" +
            "iaload 2e\n" +
            "iand 7e\n" +
            "iastore 4f\n" +
            "iconst_m1 02\n" +
            "iconst_0 03\n" +
            "iconst_1 04\n" +
            "iconst_2 05\n" +
            "iconst_3 06\n" +
            "iconst_4 07\n" +
            "iconst_5 08\n" +
            "idiv 6c\n" +
            "if_acmpeq a5\n" +
            "if_acmpne a6\n" +
            "if_icmpeq 9f\n" +
            "if_icmpge a2\n" +
            "if_icmpgt a3\n" +
            "if_icmple a4\n" +
            "if_icmplt a1\n" +
            "if_icmpne a0\n" +
            "ifeq 99\n" +
            "ifge 9c\n" +
            "ifgt 9d\n" +
            "ifle 9e\n" +
            "iflt 9b\n" +
            "ifne 9a\n" +
            "ifnonnull c7\n" +
            "ifnull c6\n" +
            "iinc 84\n" +
            "iload 15\n" +
            "iload_0 1a\n" +
            "iload_1 1b\n" +
            "iload_2 1c\n" +
            "iload_3 1d\n" +
            "imul 68\n" +
            "ineg 74\n" +
            "instanceof c1\n" +
            "invokedynamic ba\n" +
            "invokeinterface b9\n" +
            "invokespecial b7\n" +
            "invokestatic b8\n" +
            "invokevirtual b6\n" +
            "ior 80\n" +
            "irem 70\n" +
            "ireturn ac\n" +
            "ishl 78\n" +
            "ishr 7a\n" +
            "istore 36\n" +
            "istore_0 3b\n" +
            "istore_1 3c\n" +
            "istore_2 3d\n" +
            "istore_3 3e\n" +
            "isub 64\n" +
            "iushr 7c\n" +
            "ixor 82\n" +
            "jsr a8\n" +
            "jsr_w c9\n" +
            "l2d 8a\n" +
            "l2f 89\n" +
            "l2i 88\n" +
            "ladd 61\n" +
            "laload 2f\n" +
            "land 7f\n" +
            "lastore 50\n" +
            "lcmp 94\n" +
            "lconst_0 09\n" +
            "lconst_1 0a\n" +
            "ldc 12\n" +
            "ldc_w 13\n" +
            "ldc2_w 14\n" +
            "ldiv 6d\n" +
            "lload 16\n" +
            "lload_0 1e\n" +
            "lload_1 1f\n" +
            "lload_2 20\n" +
            "lload_3 21\n" +
            "lmul 69\n" +
            "lneg 75\n" +
            "lor 81\n" +
            "lrem 71\n" +
            "lreturn ad\n" +
            "lshl 79\n" +
            "lshr 7b\n" +
            "lstore 37\n" +
            "lstore_0 3f\n" +
            "lstore_1 40\n" +
            "lstore_2 41\n" +
            "lstore_3 42\n" +
            "lsub 65\n" +
            "lushr 7d\n" +
            "lxor 83\n" +
            "monitorenter c2\n" +
            "monitorexit c3\n" +
            "multianewarray c5\n" +
            "new bb\n" +
            "newarray bc\n" +
            "nop 00\n" +
            "pop 57\n" +
            "pop2 58\n" +
            "putfield b5\n" +
            "putstatic b3\n" +
            "ret a9\n" +
            "return b1\n" +
            "saload 35\n" +
            "sastore 56\n" +
            "sipush 11\n" +
            "swap 5f\n" +
            "lookupswitch ab\n" +
            "tableswitch aa\n" +
            "wide c4";


    public static String opcodes2 =
            "Aaload\n" +

                    "Aastore\n" +

                    "Aconst_null\n" +

                    "Aload\n" +

                    "Aload\n" +

                    "Aload\n" +

                    "Aload\n" +

                    "Aload\n" +

                    "Anewarray\n" +

                    "Areturn\n" +

                    "Arraylength\n" +

                    "Astore\n" +

                    "Astore\n" +

                    "Astore\n" +

                    "Astore\n" +

                    "Astore\n" +

                    "Athrow\n" +

                    "Baload\n" +

                    "Bastore\n" +

                    "Bipush\n" +

                    "Caload\n" +

                    "Castore\n" +

                    "Checkcast\n" +

                    "D2f\n" +

                    "D2i\n" +

                    "D2l\n" +

                    "Dadd\n" +

                    "Daload\n" +

                    "Dastore\n" +

                    "Dcmpg\n" +

                    "Dcmpl\n" +

                    "Dconst\n" +

                    "Dconst\n" +

                    "Ddiv\n" +

                    "Dload\n" +

                    "Dload\n" +

                    "Dload\n" +

                    "Dload\n" +

                    "Dload\n" +

                    "Dmul\n" +

                    "Dneg\n" +

                    "Drem\n" +

                    "Dreturn\n" +

                    "Dstore\n" +

                    "Dstore\n" +

                    "Dstore\n" +

                    "Dstore\n" +

                    "Dstore\n" +

                    "Dsub\n" +

                    "Dup\n" +

                    "Dup_x1\n" +

                    "Dup_x2\n" +

                    "Dup2\n" +

                    "Dup2_x1\n" +

                    "Dup2_x2\n" +

                    "F2d\n" +

                    "F2i\n" +

                    "F2l\n" +

                    "Fadd\n" +

                    "Faload\n" +

                    "Fastore\n" +

                    "Fcmpg\n" +

                    "Fcmpl\n" +

                    "Fconst\n" +

                    "Fconst\n" +

                    "Fconst\n" +

                    "Fdiv\n" +

                    "Fload\n" +

                    "Fload\n" +

                    "Fload\n" +

                    "Fload\n" +

                    "Fload\n" +

                    "Fmul\n" +

                    "Fneg\n" +

                    "Frem\n" +

                    "Freturn\n" +

                    "Fstore\n" +

                    "Fstore\n" +

                    "Fstore\n" +

                    "Fstore\n" +

                    "Fstore\n" +

                    "Fsub\n" +

                    "Getfield\n" +

                    "Getstatic\n" +

                    "Goto\n" +

                    "Goto_w\n" +

                    "I2b\n" +

                    "I2c\n" +

                    "I2d\n" +

                    "I2f\n" +

                    "I2l\n" +

                    "I2s\n" +

                    "Iadd\n" +

                    "Iaload\n" +

                    "Iand\n" +

                    "Iastore\n" +

                    "Iconst_m1\n" +

                    "Iconst\n" +

                    "Iconst\n" +

                    "Iconst\n" +

                    "Iconst\n" +

                    "Iconst\n" +

                    "Iconst\n" +

                    "Idiv\n" +

                    "If_acmpeq\n" +

                    "If_acmpne\n" +

                    "If_icmpeq\n" +

                    "If_icmpge\n" +

                    "If_icmpgt\n" +

                    "If_icmple\n" +

                    "If_icmplt\n" +

                    "If_icmpne\n" +

                    "Ifeq\n" +

                    "Ifge\n" +

                    "Ifgt\n" +

                    "Ifle\n" +

                    "Iflt\n" +

                    "Ifne\n" +

                    "Ifnonnull\n" +

                    "Ifnull\n" +

                    "Iinc\n" +

                    "Iload\n" +

                    "Iload\n" +

                    "Iload\n" +

                    "Iload\n" +

                    "Iload\n" +

                    "Imul\n" +

                    "Ineg\n" +

                    "Instanceof\n" +

                    "Invokedynamic\n" +

                    "Invokeinterface\n" +

                    "Invokespecial\n" +

                    "Invokestatic\n" +

                    "Invokevirtual\n" +

                    "Ior\n" +

                    "Irem\n" +

                    "Ireturn\n" +

                    "Ishl\n" +

                    "Ishr\n" +

                    "Istore\n" +

                    "Istore\n" +

                    "Istore\n" +

                    "Istore\n" +

                    "Istore\n" +

                    "Isub\n" +

                    "Iushr\n" +

                    "Ixor\n" +

                    "Jsr\n" +

                    "Jsr_w\n" +

                    "L2d\n" +

                    "L2f\n" +

                    "L2i\n" +

                    "Ladd\n" +

                    "Laload\n" +

                    "Land\n" +

                    "Lastore\n" +

                    "Lcmp\n" +

                    "Lconst\n" +

                    "Lconst\n" +

                    "Ldc\n" +

                    "Ldc_w\n" +

                    "Ldc2_w\n" +

                    "Ldiv\n" +

                    "Lload\n" +

                    "Lload\n" +

                    "Lload\n" +

                    "Lload\n" +

                    "Lload\n" +

                    "Lmul\n" +

                    "Lneg\n" +

                    "Lor\n" +

                    "Lrem\n" +

                    "Lreturn\n" +

                    "Lshl\n" +

                    "Lshr\n" +

                    "Lstore\n" +

                    "Lstore\n" +

                    "Lstore\n" +

                    "Lstore\n" +

                    "Lstore\n" +

                    "Lsub\n" +

                    "Lushr\n" +

                    "Lxor\n" +

                    "Monitorenter\n" +

                    "Monitorexit\n" +

                    "Multianewarray\n" +

                    "New\n" +

                    "Newarray\n" +

                    "Nop\n" +

                    "Pop\n" +

                    "Pop2\n" +

                    "Putfield\n" +

                    "Putstatic\n" +

                    "Ret\n" +

                    "Return\n" +

                    "Saload\n" +

                    "Sastore\n" +

                    "Sipush\n" +

                    "Swap\n" +
                    "Lookupswitch\n" +
                    "Tableswitch\n" +
                    "Wide";


    public static void main(String[] args) throws Exception {
        for (String s : opcodes2.split("\n")) {
            File file = new File("./src/main/java/org/bon/jvm/Instructions/" + s + ".java");
            FileWriter fw = new FileWriter(file, true);
            FileReader fr = new FileReader(file);


            int i = 0;
            int read;
            int last = 0;
            while ((read = fr.read()) != -1) {
                if (((char) read) == '}') {
                    last = i;
                }
                i++;
            }

            fw.append("" +
                    "@Override" +
                    "public String getName() {" +
                    "    return \"" + s + "\";" +
                    "}");

            fw.close();
            // System.out.println("public static int " + name.toUpperCase() + " = " + "0x" + opcode + ";");
        }
        //System.out.println(opcodes);
    }
}
