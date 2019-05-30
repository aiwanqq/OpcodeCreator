package com.yezi;

public class AssembleUtil {
    private static AssembleUtil assembleUtil = null;
    private int baseAddr = 0;
    private int index = 0;

    private AssembleUtil(){}

    public static AssembleUtil getInstance() {
        if (assembleUtil == null) {
            assembleUtil = new AssembleUtil();
        }

        return assembleUtil;
    }

    public void println(String line) {
        System.out.println(line);
    }

    public int getBaseAddr() {
        return baseAddr;
    }

    public void setBaseAddr(int baseAddr) {
        this.baseAddr = baseAddr;
    }

    public int getIndex() {
        return index;
    }

    public void printOneCommand(int addr,String cmd) {
        println("d"+this.index+"="+cmd);
        println("a"+ index + "=0x" + String.format("%08X",addr));
        this.index++;
    }

    public void printOneCommand(String cmd) {
        println("d"+this.index+"="+cmd);
        println("a"+ index + "=0x" + String.format("%08X",this.baseAddr));
        this.index++;
        this.baseAddr += 4;
    }

    private String getRegHexName(int reg) {
        return String.format("%01X",reg);
    }

    public void move(int dest,int src) {
        printOneCommand("0"+getRegHexName(src)+" "+getRegHexName(dest)+"0 A0 E1 #MOV    R"+dest+", R"+src);
    }

    public void move(int addr,int dest,int src) {
        printOneCommand(addr, "0"+getRegHexName(src)+" "+getRegHexName(dest)+"0 A0 E1 #MOV    R"+dest+", R"+src);
    }

    private String calcJmpOpcode(int dest,int src) {
        int opcode;
        String sop;
        opcode = (dest-src)/4-2;
        sop = String.format("%08X",opcode);
        return sop;
    }

    public void hookMethod(int addr,String name) {
        String sop = calcJmpOpcode(this.baseAddr,addr);
        printOneCommand(addr,sop.substring(6,8) +" "+ sop.substring(4,6)+" "+ sop.substring(2,4)+" "+ "EB #"+name);
    }

    public void start() {
        printOneCommand("F0 4D 2D E9 #STMFD           SP!, {R4-R8,R10,R11,LR}");
    }

    public void stop() {
        printOneCommand("F0 8D BD E8 #LDMFD           SP!, {R4-R8,R10,R11,PC}");
    }

    public void sub0x100(int dest,int src,int value) {
        printOneCommand(get2HexValue(value) +getRegHexName(dest)+"B 4"+getRegHexName(src)+" E2  #SUB R"+dest+", R"+src+", #"+value*0x400);
    }

    public void bl(int addr,String name) {
        String sop;
        sop = calcJmpOpcode(addr,this.baseAddr);
        printOneCommand(sop.substring(6,8) +" "+ sop.substring(4,6)+" "+ sop.substring(2,4)+" "+ "EB #" + name);
    }

    public void bl(int src,int dest,String name) {
        String sop;
        sop = calcJmpOpcode(dest,src);
        printOneCommand(src,sop.substring(6,8) +" "+ sop.substring(4,6)+" "+ sop.substring(2,4)+" "+ "EB #" + name);
    }

    public void bne(int addr,String name) {
        String sop;
        sop = calcJmpOpcode(addr,this.baseAddr);
        printOneCommand(sop.substring(6,8) +" "+ sop.substring(4,6)+" "+ sop.substring(2,4)+" "+ "1A #" + name);
    }

    public void beq(int addr,String name) {
        String sop;
        sop = calcJmpOpcode(addr,this.baseAddr);
        printOneCommand(sop.substring(6,8) +" "+ sop.substring(4,6)+" "+ sop.substring(2,4)+" "+ "0A #" + name);
    }

    private String get2HexValue(int value) {
        return String.format("%02X",value);
    }

    public void addLess0x100(int dest,int src,int value) {
        printOneCommand(get2HexValue(value)+" "+getRegHexName(dest)+"0 8"+getRegHexName(src)+" E2  #ADD R"+dest+", R"+src+", #"+value);
    }

    public void moveValue(int reg,int value) {
        printOneCommand(String.format("%02X",value) +" "+getRegHexName(reg)+"0 A0 E3 #MOV    R"+getRegHexName(reg)+", #"+ String.format("%02d",value));
    }

    public void moveValue(int addr, int reg,int value) {
        printOneCommand(addr,String.format("%02X",value) +" "+getRegHexName(reg)+"0 A0 E3 #MOV    R"+getRegHexName(reg)+", #"+ String.format("%02d",value));
    }
}
