package com.yezi;

public class YqqsFileVerify implements YqqsHookCode {
    private int baseAddr;
    private int hookAddr;
    private int testPathConfGet_backup_path;
    private int fileExists;
    private int sDKManagerCheckSignatrue;

    public void setBaseAddr(int baseAddr) {
        this.baseAddr = baseAddr;
    }

    public void setHookAddr(int hookAddr) {
        this.hookAddr = hookAddr;
    }

    public void setTestPathConfGet_backup_path(int testPathConfGet_backup_path) {
        this.testPathConfGet_backup_path = testPathConfGet_backup_path;
    }

    public void setFileExists(int fileExists) {
        this.fileExists = fileExists;
    }

    public void setsDKManagerCheckSignatrue(int sDKManagerCheckSignatrue) {
        this.sDKManagerCheckSignatrue = sDKManagerCheckSignatrue;
    }

    @Override
    public void printCmd() {
        AssembleUtil au = AssembleUtil.getInstance();
        int oldAddr = au.getBaseAddr();
        au.setBaseAddr(this.baseAddr);
        au.println("#文件验证,防止so文件被盗用");
        au.hookMethod(this.hookAddr,"Hook BL SDKManager$$CheckSignatrue");
        au.start();
        au.move(5,0);
        au.moveValue(0,0);
        au.moveValue(1,0);
        au.bl(this.testPathConfGet_backup_path,"TestPathConf$$get_backup_path");
        au.move(1,0);
        au.moveValue(0,0);
        au.moveValue(2,0);
        au.bl(this.fileExists,"File$$Exists");
        au.printOneCommand("d"+ "00 00 50 E3 #CMP R0, #0");
        au.bne(au.getBaseAddr() + 0x10,"");
        au.move(0,5);
        au.moveValue(1,0);
        au.bl(this.sDKManagerCheckSignatrue,"SDKManager$$CheckSignatrue");
        au.stop();
        au.setBaseAddr(oldAddr);
    }
}
