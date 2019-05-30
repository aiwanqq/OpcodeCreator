package com.yezi;

public class YqqsDebugLog implements YqqsHookCode{
    private int baseAddr;
    private int hookAddr;


    @Override
    public void printCmd() {
        AssembleUtil au = AssembleUtil.getInstance();
        int oldAddr = au.getBaseAddr();
        int tBaseAddr;
        au.setBaseAddr(this.baseAddr);
        au.start();
        au.move(4,0);
        au.move(5,1);
        au.move(6,2);
        au.move(7,3);
        tBaseAddr = au.getBaseAddr();
        au.setBaseAddr(tBaseAddr+4);
        au.printOneCommand("00 00 9F E7 #LDR    R0, [PC,R0]");
        au.printOneCommand("00 00 90 E5 #LDR    R0, [R0]");
        au.printOneCommand("B2 10 D0 E5 #LDRB   R1, [R0,#0xB2]");
        au.printOneCommand("01 00 11 E3 #TST    R1, #1");
        //0x14=20 每条指令4 往下跳5条指令。不算本身
        au.beq(au.getBaseAddr()+0x14,"");
        au.printOneCommand("60 10 90 E5 #LDR    R1, [R0,#0x60]");
        au.printOneCommand("00 00 51 E3 #CMP    R1, #0");
        au.bne(au.getBaseAddr()+8,"");
        au.bl(0x016C34B8,"il2cpp_runtime_class_init_0");
        au.moveValue(0,0);
        au.move(1,5);
        au.moveValue(2,0);
        au.bl(0x00D5D038,"Debug$$LogError");
        au.move(0,4);
        au.move(1,5);
        au.move(2,6);
        au.move(3,7);
        au.bl(0x0050DF48,"UIPlant$$CreateSeedItem");
        au.stop();

        //01C4DBF4 Class$UnityEngine.Debug
        int offset = 0x01C41094 - tBaseAddr - 0x0c;
        int oc = au.getBaseAddr() - tBaseAddr - 8;
        String t = String.format("%04X",oc);
        au.printOneCommand(t.substring(2,4)+" "+t.substring(0,2)+" 9F E5 #LDR    R0=#");

        t = String.format("%08X",offset);
        au.printOneCommand(t.substring(6,8)+" "+t.substring(4,6)+" "+t.substring(2,4)+" "+t.substring(0,2)+" #offset");
        au.setBaseAddr(oldAddr);
    }
}
