package org.bon.jvm.instructions;

import org.bon.jvm.constantpool.ConstPool;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Tommi
 * Date: 26/09/2019
 * Time: 20.20
 */

public class Instructions {
    public static int AALOAD = 0x32;
    public static int AASTORE = 0x53;
    public static int ACONST_NULL = 0x01;
    public static int ALOAD = 0x19;
    public static int ALOAD_0 = 0x2a;
    public static int ALOAD_1 = 0x2b;
    public static int ALOAD_2 = 0x2c;
    public static int ALOAD_3 = 0x2d;
    public static int ANEWARRAY = 0xbd;
    public static int ARETURN = 0xb0;
    public static int ARRAYLENGTH = 0xbe;
    public static int ASTORE = 0x3a;
    public static int ASTORE_0 = 0x4b;
    public static int ASTORE_1 = 0x4c;
    public static int ASTORE_2 = 0x4d;
    public static int ASTORE_3 = 0x4e;
    public static int ATHROW = 0xbf;
    public static int BALOAD = 0x33;
    public static int BASTORE = 0x54;
    public static int BIPUSH = 0x10;
    public static int CALOAD = 0x34;
    public static int CASTORE = 0x55;
    public static int CHECKCAST = 0xc0;
    public static int D2F = 0x90;
    public static int D2I = 0x8e;
    public static int D2L = 0x8f;
    public static int DADD = 0x63;
    public static int DALOAD = 0x31;
    public static int DASTORE = 0x52;
    public static int DCMPG = 0x98;
    public static int DCMPL = 0x97;
    public static int DCONST_0 = 0x0e;
    public static int DCONST_1 = 0x0f;
    public static int DDIV = 0x6f;
    public static int DLOAD = 0x18;
    public static int DLOAD_0 = 0x26;
    public static int DLOAD_1 = 0x27;
    public static int DLOAD_2 = 0x28;
    public static int DLOAD_3 = 0x29;
    public static int DMUL = 0x6b;
    public static int DNEG = 0x77;
    public static int DREM = 0x73;
    public static int DRETURN = 0xaf;
    public static int DSTORE = 0x39;
    public static int DSTORE_0 = 0x47;
    public static int DSTORE_1 = 0x48;
    public static int DSTORE_2 = 0x49;
    public static int DSTORE_3 = 0x4a;
    public static int DSUB = 0x67;
    public static int DUP = 0x59;
    public static int DUP_X1 = 0x5a;
    public static int DUP_X2 = 0x5b;
    public static int DUP2 = 0x5c;
    public static int DUP2_X1 = 0x5d;
    public static int DUP2_X2 = 0x5e;
    public static int F2D = 0x8d;
    public static int F2I = 0x8b;
    public static int F2L = 0x8c;
    public static int FADD = 0x62;
    public static int FALOAD = 0x30;
    public static int FASTORE = 0x51;
    public static int FCMPG = 0x96;
    public static int FCMPL = 0x95;
    public static int FCONST_0 = 0x0b;
    public static int FCONST_1 = 0x0c;
    public static int FCONST_2 = 0x0d;
    public static int FDIV = 0x6e;
    public static int FLOAD = 0x17;
    public static int FLOAD_0 = 0x22;
    public static int FLOAD_1 = 0x23;
    public static int FLOAD_2 = 0x24;
    public static int FLOAD_3 = 0x25;
    public static int FMUL = 0x6a;
    public static int FNEG = 0x76;
    public static int FREM = 0x72;
    public static int FRETURN = 0xae;
    public static int FSTORE = 0x38;
    public static int FSTORE_0 = 0x43;
    public static int FSTORE_1 = 0x44;
    public static int FSTORE_2 = 0x45;
    public static int FSTORE_3 = 0x46;
    public static int FSUB = 0x66;
    public static int GETFIELD = 0xb4;
    public static int GETSTATIC = 0xb2;
    public static int GOTO = 0xa7;
    public static int GOTO_W = 0xc8;
    public static int I2B = 0x91;
    public static int I2C = 0x92;
    public static int I2D = 0x87;
    public static int I2F = 0x86;
    public static int I2L = 0x85;
    public static int I2S = 0x93;
    public static int IADD = 0x60;
    public static int IALOAD = 0x2e;
    public static int IAND = 0x7e;
    public static int IASTORE = 0x4f;
    public static int ICONST_M1 = 0x02;
    public static int ICONST_0 = 0x03;
    public static int ICONST_1 = 0x04;
    public static int ICONST_2 = 0x05;
    public static int ICONST_3 = 0x06;
    public static int ICONST_4 = 0x07;
    public static int ICONST_5 = 0x08;
    public static int IDIV = 0x6c;
    public static int IF_ACMPEQ = 0xa5;
    public static int IF_ACMPNE = 0xa6;
    public static int IF_ICMPEQ = 0x9f;
    public static int IF_ICMPGE = 0xa2;
    public static int IF_ICMPGT = 0xa3;
    public static int IF_ICMPLE = 0xa4;
    public static int IF_ICMPLT = 0xa1;
    public static int IF_ICMPNE = 0xa0;
    public static int IFEQ = 0x99;
    public static int IFGE = 0x9c;
    public static int IFGT = 0x9d;
    public static int IFLE = 0x9e;
    public static int IFLT = 0x9b;
    public static int IFNE = 0x9a;
    public static int IFNONNULL = 0xc7;
    public static int IFNULL = 0xc6;
    public static int IINC = 0x84;
    public static int ILOAD = 0x15;
    public static int ILOAD_0 = 0x1a;
    public static int ILOAD_1 = 0x1b;
    public static int ILOAD_2 = 0x1c;
    public static int ILOAD_3 = 0x1d;
    public static int IMUL = 0x68;
    public static int INEG = 0x74;
    public static int INSTANCEOF = 0xc1;
    public static int INVOKEDYNAMIC = 0xba;
    public static int INVOKEINTERFACE = 0xb9;
    public static int INVOKESPECIAL = 0xb7;
    public static int INVOKESTATIC = 0xb8;
    public static int INVOKEVIRTUAL = 0xb6;
    public static int IOR = 0x80;
    public static int IREM = 0x70;
    public static int IRETURN = 0xac;
    public static int ISHL = 0x78;
    public static int ISHR = 0x7a;
    public static int ISTORE = 0x36;
    public static int ISTORE_0 = 0x3b;
    public static int ISTORE_1 = 0x3c;
    public static int ISTORE_2 = 0x3d;
    public static int ISTORE_3 = 0x3e;
    public static int ISUB = 0x64;
    public static int IUSHR = 0x7c;
    public static int IXOR = 0x82;
    public static int JSR = 0xa8;
    public static int JSR_W = 0xc9;
    public static int L2D = 0x8a;
    public static int L2F = 0x89;
    public static int L2I = 0x88;
    public static int LADD = 0x61;
    public static int LALOAD = 0x2f;
    public static int LAND = 0x7f;
    public static int LASTORE = 0x50;
    public static int LCMP = 0x94;
    public static int LCONST_0 = 0x09;
    public static int LCONST_1 = 0x0a;
    public static int LDC = 0x12;
    public static int LDC_W = 0x13;
    public static int LDC2_W = 0x14;
    public static int LDIV = 0x6d;
    public static int LLOAD = 0x16;
    public static int LLOAD_0 = 0x1e;
    public static int LLOAD_1 = 0x1f;
    public static int LLOAD_2 = 0x20;
    public static int LLOAD_3 = 0x21;
    public static int LMUL = 0x69;
    public static int LNEG = 0x75;
    public static int LOR = 0x81;
    public static int LREM = 0x71;
    public static int LRETURN = 0xad;
    public static int LSHL = 0x79;
    public static int LSHR = 0x7b;
    public static int LSTORE = 0x37;
    public static int LSTORE_0 = 0x3f;
    public static int LSTORE_1 = 0x40;
    public static int LSTORE_2 = 0x41;
    public static int LSTORE_3 = 0x42;
    public static int LSUB = 0x65;
    public static int LUSHR = 0x7d;
    public static int LXOR = 0x83;
    public static int MONITORENTER = 0xc2;
    public static int MONITOREXIT = 0xc3;
    public static int MULTIANEWARRAY = 0xc5;
    public static int NEW = 0xbb;
    public static int NEWARRAY = 0xbc;
    public static int NOP = 0x00;
    public static int POP = 0x57;
    public static int POP2 = 0x58;
    public static int PUTFIELD = 0xb5;
    public static int PUTSTATIC = 0xb3;
    public static int RET = 0xa9;
    public static int RETURN = 0xb1;
    public static int SALOAD = 0x35;
    public static int SASTORE = 0x56;
    public static int SIPUSH = 0x11;
    public static int SWAP = 0x5f;
    public static int LOOKUPSWITCH = 0xab;
    public static int TABLESWITCH = 0xaa;
    public static int WIDE = 0xc4;


    public static Instruction from(DataInputStream in, ConstPool constPool) throws IOException {
        int opcode = in.readUnsignedByte();
        switch (opcode) {
            case 0x32:
                return Aaload.from(in, constPool);
            case 0x53:
                return Aastore.from(in, constPool);
            case 0x01:
                return Aconst_null.from(in, constPool);
            case 0x19:
                return Aload.from(in, constPool, false);
            case 0x2a:
                return Aload.from(in, constPool, 0);
            case 0x2b:
                return Aload.from(in, constPool, 1);
            case 0x2c:
                return Aload.from(in, constPool, 2);
            case 0x2d:
                return Aload.from(in, constPool, 3);
            case 0xbd:
                return Anewarray.from(in, constPool);
            case 0xb0:
                return Areturn.from(in, constPool);
            case 0xbe:
                return Arraylength.from(in, constPool);
            case 0x3a:
                return Astore.from(in, constPool, false);
            case 0x4b:
                return Astore.from(in, constPool, 0);
            case 0x4c:
                return Astore.from(in, constPool, 1);
            case 0x4d:
                return Astore.from(in, constPool, 2);
            case 0x4e:
                return Astore.from(in, constPool, 3);
            case 0xbf:
                return Athrow.from(in, constPool);
            case 0x33:
                return Baload.from(in, constPool);
            case 0x54:
                return Bastore.from(in, constPool);
            case 0x10:
                return Bipush.from(in, constPool);
            case 0x34:
                return Caload.from(in, constPool);
            case 0x55:
                return Castore.from(in, constPool);
            case 0xc0:
                return Checkcast.from(in, constPool);
            case 0x90:
                return D2f.from(in, constPool);
            case 0x8e:
                return D2i.from(in, constPool);
            case 0x8f:
                return D2l.from(in, constPool);
            case 0x63:
                return Dadd.from(in, constPool);
            case 0x31:
                return Daload.from(in, constPool);
            case 0x52:
                return Dastore.from(in, constPool);
            case 0x98:
                return Dcmpg.from(in, constPool);
            case 0x97:
                return Dcmpl.from(in, constPool);
            case 0x0e:
                return Dconst.from(in, constPool, 0);
            case 0x0f:
                return Dconst.from(in, constPool, 1);
            case 0x6f:
                return Ddiv.from(in, constPool);
            case 0x18:
                return Dload.from(in, constPool, false);
            case 0x26:
                return Dload.from(in, constPool, 0);
            case 0x27:
                return Dload.from(in, constPool, 1);
            case 0x28:
                return Dload.from(in, constPool, 2);
            case 0x29:
                return Dload.from(in, constPool, 3);
            case 0x6b:
                return Dmul.from(in, constPool);
            case 0x77:
                return Dneg.from(in, constPool);
            case 0x73:
                return Drem.from(in, constPool);
            case 0xaf:
                return Dreturn.from(in, constPool);
            case 0x39:
                return Dstore.from(in, constPool, false);
            case 0x47:
                return Dstore.from(in, constPool, 0);
            case 0x48:
                return Dstore.from(in, constPool, 1);
            case 0x49:
                return Dstore.from(in, constPool, 2);
            case 0x4a:
                return Dstore.from(in, constPool, 3);
            case 0x67:
                return Dsub.from(in, constPool);
            case 0x59:
                return Dup.from(in, constPool);
            case 0x5a:
                return Dup_x1.from(in, constPool);
            case 0x5b:
                return Dup_x2.from(in, constPool);
            case 0x5c:
                return Dup2.from(in, constPool);
            case 0x5d:
                return Dup2_x1.from(in, constPool);
            case 0x5e:
                return Dup2_x2.from(in, constPool);
            case 0x8d:
                return F2d.from(in, constPool);
            case 0x8b:
                return F2i.from(in, constPool);
            case 0x8c:
                return F2l.from(in, constPool);
            case 0x62:
                return Fadd.from(in, constPool);
            case 0x30:
                return Faload.from(in, constPool);
            case 0x51:
                return Fastore.from(in, constPool);
            case 0x96:
                return Fcmpg.from(in, constPool);
            case 0x95:
                return Fcmpl.from(in, constPool);
            case 0x0b:
                return Fconst.from(in, constPool, 0);
            case 0x0c:
                return Fconst.from(in, constPool, 1);
            case 0x0d:
                return Fconst.from(in, constPool, 2);
            case 0x6e:
                return Fdiv.from(in, constPool);
            case 0x17:
                return Fload.from(in, constPool, false);
            case 0x22:
                return Fload.from(in, constPool, 0);
            case 0x23:
                return Fload.from(in, constPool, 1);
            case 0x24:
                return Fload.from(in, constPool, 2);
            case 0x25:
                return Fload.from(in, constPool, 3);
            case 0x6a:
                return Fmul.from(in, constPool);
            case 0x76:
                return Fneg.from(in, constPool);
            case 0x72:
                return Frem.from(in, constPool);
            case 0xae:
                return Freturn.from(in, constPool);
            case 0x38:
                return Fstore.from(in, constPool, false);
            case 0x43:
                return Fstore.from(in, constPool, 0);
            case 0x44:
                return Fstore.from(in, constPool, 1);
            case 0x45:
                return Fstore.from(in, constPool, 2);
            case 0x46:
                return Fstore.from(in, constPool, 3);
            case 0x66:
                return Fsub.from(in, constPool);
            case 0xb4:
                return Getfield.from(in, constPool);
            case 0xb2:
                return Getstatic.from(in, constPool);
            case 0xa7:
                return Goto.from(in, constPool);
            case 0xc8:
                return Goto_w.from(in, constPool);
            case 0x91:
                return I2b.from(in, constPool);
            case 0x92:
                return I2c.from(in, constPool);
            case 0x87:
                return I2d.from(in, constPool);
            case 0x86:
                return I2f.from(in, constPool);
            case 0x85:
                return I2l.from(in, constPool);
            case 0x93:
                return I2s.from(in, constPool);
            case 0x60:
                return Iadd.from(in, constPool);
            case 0x2e:
                return Iaload.from(in, constPool);
            case 0x7e:
                return Iand.from(in, constPool);
            case 0x4f:
                return Iastore.from(in, constPool);
            case 0x02:
                return Iconst_m1.from(in, constPool);
            case 0x03:
                return Iconst.from(in, constPool, 0);
            case 0x04:
                return Iconst.from(in, constPool, 1);
            case 0x05:
                return Iconst.from(in, constPool, 2);
            case 0x06:
                return Iconst.from(in, constPool, 3);
            case 0x07:
                return Iconst.from(in, constPool, 4);
            case 0x08:
                return Iconst.from(in, constPool, 5);
            case 0x6c:
                return Idiv.from(in, constPool);
            case 0xa5:
                return If_acmpeq.from(in, constPool);
            case 0xa6:
                return If_acmpne.from(in, constPool);
            case 0x9f:
                return If_icmpeq.from(in, constPool);
            case 0xa2:
                return If_icmpge.from(in, constPool);
            case 0xa3:
                return If_icmpgt.from(in, constPool);
            case 0xa4:
                return If_icmple.from(in, constPool);
            case 0xa1:
                return If_icmplt.from(in, constPool);
            case 0xa0:
                return If_icmpne.from(in, constPool);
            case 0x99:
                return Ifeq.from(in, constPool);
            case 0x9c:
                return Ifge.from(in, constPool);
            case 0x9d:
                return Ifgt.from(in, constPool);
            case 0x9e:
                return Ifle.from(in, constPool);
            case 0x9b:
                return Iflt.from(in, constPool);
            case 0x9a:
                return Ifne.from(in, constPool);
            case 0xc7:
                return Ifnonnull.from(in, constPool);
            case 0xc6:
                return Ifnull.from(in, constPool);
            case 0x84:
                return Iinc.from(in, constPool);
            case 0x15:
                return Iload.from(in, constPool);
            case 0x1a:
                return Iload.from(in, constPool, 0);
            case 0x1b:
                return Iload.from(in, constPool, 1);
            case 0x1c:
                return Iload.from(in, constPool, 2);
            case 0x1d:
                return Iload.from(in, constPool, 3);
            case 0x68:
                return Imul.from(in, constPool);
            case 0x74:
                return Ineg.from(in, constPool);
            case 0xc1:
                return Instanceof.from(in, constPool);
            case 0xba:
                return Invokedynamic.from(in, constPool);
            case 0xb9:
                return Invokeinterface.from(in, constPool);
            case 0xb7:
                return Invokespecial.from(in, constPool);
            case 0xb8:
                return Invokestatic.from(in, constPool);
            case 0xb6:
                return Invokevirtual.from(in, constPool);
            case 0x80:
                return Ior.from(in, constPool);
            case 0x70:
                return Irem.from(in, constPool);
            case 0xac:
                return Ireturn.from(in, constPool);
            case 0x78:
                return Ishl.from(in, constPool);
            case 0x7a:
                return Ishr.from(in, constPool);
            case 0x36:
                return Istore.from(in, constPool);
            case 0x3b:
                return Istore.from(in, constPool, 0);
            case 0x3c:
                return Istore.from(in, constPool, 1);
            case 0x3d:
                return Istore.from(in, constPool, 2);
            case 0x3e:
                return Istore.from(in, constPool, 3);
            case 0x64:
                return Isub.from(in, constPool);
            case 0x7c:
                return Iushr.from(in, constPool);
            case 0x82:
                return Ixor.from(in, constPool);
            case 0xa8:
                return Jsr.from(in, constPool);
            case 0xc9:
                return Jsr_w.from(in, constPool);
            case 0x8a:
                return L2d.from(in, constPool);
            case 0x89:
                return L2f.from(in, constPool);
            case 0x88:
                return L2i.from(in, constPool);
            case 0x61:
                return Ladd.from(in, constPool);
            case 0x2f:
                return Laload.from(in, constPool);
            case 0x7f:
                return Land.from(in, constPool);
            case 0x50:
                return Lastore.from(in, constPool);
            case 0x94:
                return Lcmp.from(in, constPool);
            case 0x09:
                return Lconst.from(in, constPool, 0);
            case 0x0a:
                return Lconst.from(in, constPool, 1);
            case 0x12:
                return Ldc.from(in, constPool);
            case 0x13:
                return Ldc_w.from(in, constPool);
            case 0x14:
                return Ldc2_w.from(in, constPool);
            case 0x6d:
                return Ldiv.from(in, constPool);
            case 0x16:
                return Lload.from(in, constPool);
            case 0x1e:
                return Lload.from(in, constPool, 0);
            case 0x1f:
                return Lload.from(in, constPool, 1);
            case 0x20:
                return Lload.from(in, constPool, 2);
            case 0x21:
                return Lload.from(in, constPool, 3);
            case 0x69:
                return Lmul.from(in, constPool);
            case 0x75:
                return Lneg.from(in, constPool);
            case 0x81:
                return Lor.from(in, constPool);
            case 0x71:
                return Lrem.from(in, constPool);
            case 0xad:
                return Lreturn.from(in, constPool);
            case 0x79:
                return Lshl.from(in, constPool);
            case 0x7b:
                return Lshr.from(in, constPool);
            case 0x37:
                return Lstore.from(in, constPool);
            case 0x3f:
                return Lstore.from(in, constPool, 0);
            case 0x40:
                return Lstore.from(in, constPool, 1);
            case 0x41:
                return Lstore.from(in, constPool, 2);
            case 0x42:
                return Lstore.from(in, constPool, 3);
            case 0x65:
                return Lsub.from(in, constPool);
            case 0x7d:
                return Lushr.from(in, constPool);
            case 0x83:
                return Lxor.from(in, constPool);
            case 0xc2:
                return Monitorenter.from(in, constPool);
            case 0xc3:
                return Monitorexit.from(in, constPool);
            case 0xc5:
                return Multianewarray.from(in, constPool);
            case 0xbb:
                return New.from(in, constPool);
            case 0xbc:
                return Newarray.from(in, constPool);
            case 0x00:
                return Nop.from(in, constPool);
            case 0x57:
                return Pop.from(in, constPool);
            case 0x58:
                return Pop2.from(in, constPool);
            case 0xb5:
                return Putfield.from(in, constPool);
            case 0xb3:
                return Putstatic.from(in, constPool);
            case 0xa9:
                return Ret.from(in, constPool);
            case 0xb1:
                return Return.from(in, constPool);
            case 0x35:
                return Saload.from(in, constPool);
            case 0x56:
                return Sastore.from(in, constPool);
            case 0x11:
                return Sipush.from(in, constPool);
            case 0x5f:
                return Swap.from(in, constPool);
            case 0xab:
                return Lookupswitch.from(in, constPool);
            case 0xaa:
                return Tableswitch.from(in, constPool);
            case 0xc4:
                return Wide.from(in, constPool);
            default:
                throw new UnsupportedOperationException("Unsupported opcode " + opcode);
        }
    }
}
