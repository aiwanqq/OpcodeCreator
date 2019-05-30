package com.yezi;

public class YqqsHookMac implements YqqsHookCode {

    private int baseAddr;
    private int getAndroidIDAddr;
    private int stringBuilderCtorAddr;
    private int stringBuilderAppendIntAddr;
    private int stringBuilderToStringAddr;
    private int stringSubstringAddr;
    private int stringReplaceAddr;
    private int hookAddr;

    public void setBaseAddr(int baseAddr) {
        this.baseAddr = baseAddr;
    }

    public void setGetAndroidIDAddr(int getAndroidIDAddr) {
        this.getAndroidIDAddr = getAndroidIDAddr;
    }

    public void setStringBuilderCtorAddr(int stringBuilderCtorAddr) {
        this.stringBuilderCtorAddr = stringBuilderCtorAddr;
    }

    public void setStringBuilderAppendIntAddr(int stringBuilderAppendIntAddr) {
        this.stringBuilderAppendIntAddr = stringBuilderAppendIntAddr;
    }

    public void setStringBuilderToStringAddr(int stringBuilderToStringAddr) {
        this.stringBuilderToStringAddr = stringBuilderToStringAddr;
    }

    public void setStringSubstringAddr(int stringSubstringAddr) {
        this.stringSubstringAddr = stringSubstringAddr;
    }

    public void setStringReplaceAddr(int stringReplaceAddr) {
        this.stringReplaceAddr = stringReplaceAddr;
    }

    public void setHookAddr(int hookAddr) {
        this.hookAddr = hookAddr;
    }

    @Override
    public void printCmd() {
        AssembleUtil au = AssembleUtil.getInstance();

        int oldAddr = au.getBaseAddr();
        au.setBaseAddr(this.baseAddr);
        au.println("#序列号修改");
        au.hookMethod(this.hookAddr,"BL SdkManager$$getAndroidID");
        au.start();
        au.sub0x100(13,13,1);
        au.bl(this.getAndroidIDAddr,"BL SdkManager$$getAndroidID");
        au.move(4,0);
        au.addLess0x100(0,13,8);
        au.move(6,0);
        au.bl(this.stringBuilderCtorAddr,"StringBuilder.ctor()");
        au.move(0,6);
        au.move(1,13);
        au.printOneCommand("A1 10 A0 E1  #LSR R1, R1, #0x1");
        au.bl(this.stringBuilderAppendIntAddr,"BL StringBuilder.Append(int i)");
        au.move(1,4);
        au.printOneCommand("A1 10 A0 E1  #LSR R1, R1, #0x1");
        au.bl(this.stringBuilderAppendIntAddr,"BL StringBuilder.Append(int i)");
        au.bl(this.stringBuilderToStringAddr,"BL StringBuilder$$ToString()");
        au.moveValue(1,0);
        au.moveValue(2,16);
        au.bl(this.stringSubstringAddr,"BL String$$Substring(int index,int length)");
        au.move(2,0);
        au.move(0,4);
        au.move(1,4);
        au.bl(this.stringReplaceAddr,"BL String$$Replace(String s1,String s2)");
        au.printOneCommand("01 DB 8D E2 #Add SP, SP, #0x400");
        au.stop();

        au.setBaseAddr(oldAddr);
    }
}
