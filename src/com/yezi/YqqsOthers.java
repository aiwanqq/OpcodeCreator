package com.yezi;

public class YqqsOthers implements YqqsHookCode {
    private int baseAddr;
    private int signAddr;
    private int getEnergyAddr;
    private int getSkillCDAddr;
    private int materailDisAddr1;
    private int materailDisAddr2;
    private int hasMaterailAddr;
    private int forgAddr;
    private int weaponStationAddr1;
    private int weaponStationAddr2;
    private int seedAddr1;
    private int seedAddr2;
    private int addMaterailAddr1;
    private int addMaterailAddr2;
    private int itemDataAddMaterialAddr;
    private int addMaterailAddr3;
    private int uploadAddr;

    private int addSeedAddr1;
    private int addSeedAddr2;
    private int itemDataGet_dataAddr;
    private int addSeedAddr3;
    private int addSeedAddr4;
    private int addSeedAddr5;
    private int itemDataAddSeedAddr;

    private int addWeaponTimesAddr1;
    private int addWeaponTimesAddr2;
    private int statisticDataAddObtainTimesAddr;

    private int addWeaponTimesAddr3;
    private int addWeaponTimesAddr4;
    private int postManAddr;

    private int getHertAddr;
    private int getHertAddr2;
    private int roomLevel9Addr;
    private int unlockRoomLevelAddr1;
    private int unlockRoomLevelAddr2;
    private int playerSaveDataSet_room_levelAddress;

    public void setBaseAddr(int baseAddr) {
        this.baseAddr = baseAddr;
    }

    public void setSignAddr(int signAddr) {
        this.signAddr = signAddr;
    }

    public void setGetEnergyAddr(int getEnergyAddr) {
        this.getEnergyAddr = getEnergyAddr;
    }

    public void setGetSkillCDAddr(int getSkillCDAddr) {
        this.getSkillCDAddr = getSkillCDAddr;
    }

    public void setMaterailDisAddr1(int materailDisAddr1) {
        this.materailDisAddr1 = materailDisAddr1;
    }

    public void setMaterailDisAddr2(int materailDisAddr2) {
        this.materailDisAddr2 = materailDisAddr2;
    }

    public void setHasMaterailAddr(int hasMaterailAddr) {
        this.hasMaterailAddr = hasMaterailAddr;
    }

    public void setForgAddr(int forgAddr) {
        this.forgAddr = forgAddr;
    }

    public void setWeaponStationAddr1(int weaponStationAddr1) {
        this.weaponStationAddr1 = weaponStationAddr1;
    }

    public void setWeaponStationAddr2(int weaponStationAddr2) {
        this.weaponStationAddr2 = weaponStationAddr2;
    }

    public void setSeedAddr1(int seedAddr1) {
        this.seedAddr1 = seedAddr1;
    }

    public void setSeedAddr2(int seedAddr2) {
        this.seedAddr2 = seedAddr2;
    }

    public void setAddMaterailAddr1(int addMaterailAddr1) {
        this.addMaterailAddr1 = addMaterailAddr1;
        this.setAddMaterailAddr2(addMaterailAddr1+4);
        this.setAddMaterailAddr3(addMaterailAddr1+8);
    }

    public void setAddMaterailAddr2(int addMaterailAddr2) {
        this.addMaterailAddr2 = addMaterailAddr2;
    }

    public void setAddMaterailAddr3(int addMaterailAddr3) {
        this.addMaterailAddr3 = addMaterailAddr3;
    }

    public void setUploadAddr(int uploadAddr) {
        this.uploadAddr = uploadAddr;
    }

    public void setAddSeedAddr1(int addSeedAddr1) {
        this.addSeedAddr1 = addSeedAddr1;
    }

    public void setAddSeedAddr2(int addSeedAddr2) {
        this.addSeedAddr2 = addSeedAddr2;
    }

    public void setAddSeedAddr3(int addSeedAddr3) {
        this.addSeedAddr3 = addSeedAddr3;
    }

    public void setAddSeedAddr4(int addSeedAddr4) {
        this.addSeedAddr4 = addSeedAddr4;
    }

    public void setAddSeedAddr5(int addSeedAddr5) {
        this.addSeedAddr5 = addSeedAddr5;
    }

    public void setAddWeaponTimesAddr1(int addWeaponTimesAddr1) {
        this.addWeaponTimesAddr1 = addWeaponTimesAddr1;
        this.setAddWeaponTimesAddr2(addWeaponTimesAddr1+4);
        this.setAddWeaponTimesAddr3(addWeaponTimesAddr1+8);
    }

    public void setAddWeaponTimesAddr2(int addWeaponTimesAddr2) {
        this.addWeaponTimesAddr2 = addWeaponTimesAddr2;
    }

    public void setAddWeaponTimesAddr3(int addWeaponTimesAddr3) {
        this.addWeaponTimesAddr3 = addWeaponTimesAddr3;
    }

    public void setAddWeaponTimesAddr4(int addWeaponTimesAddr4) {
        this.addWeaponTimesAddr4 = addWeaponTimesAddr4;
    }

    public void setPostManAddr(int postManAddr) {
        this.postManAddr = postManAddr;
    }

    public void setGetHertAddr(int getHertAddr) {
        this.getHertAddr = getHertAddr;
    }

    public void setGetHertAddr2(int getHertAddr2) {
        this.getHertAddr2 = getHertAddr2;
    }

    public void setRoomLevel9Addr(int roomLevel9Addr) {
        this.roomLevel9Addr = roomLevel9Addr;
    }

    public void setUnlockRoomLevelAddr1(int unlockRoomLevelAddr1) {
        this.unlockRoomLevelAddr1 = unlockRoomLevelAddr1;
        this.setUnlockRoomLevelAddr2(unlockRoomLevelAddr1+4);
        this.setRoomLevel9Addr(unlockRoomLevelAddr1+8);
    }

    public void setUnlockRoomLevelAddr2(int unlockRoomLevelAddr2) {
        this.unlockRoomLevelAddr2 = unlockRoomLevelAddr2;
    }

    public void setItemDataAddMaterialAddr(int itemDataAddMaterialAddr) {
        this.itemDataAddMaterialAddr = itemDataAddMaterialAddr;
    }

    public void setItemDataGet_dataAddr(int itemDataGet_dataAddr) {
        this.itemDataGet_dataAddr = itemDataGet_dataAddr;
    }

    public void setItemDataAddSeedAddr(int itemDataAddSeedAddr) {
        this.itemDataAddSeedAddr = itemDataAddSeedAddr;
    }

    public void setStatisticDataAddObtainTimesAddr(int statisticDataAddObtainTimesAddr) {
        this.statisticDataAddObtainTimesAddr = statisticDataAddObtainTimesAddr;
    }

    public void setPlayerSaveDataSet_room_levelAddress(int playerSaveDataSet_room_levelAddress) {
        this.playerSaveDataSet_room_levelAddress = playerSaveDataSet_room_levelAddress;
    }

    @Override
    public void printCmd() {
        AssembleUtil au = AssembleUtil.getInstance();
        int oldBase = au.getBaseAddr();
        au.setBaseAddr(this.baseAddr);
        au.println("#签名");
        au.moveValue(this.signAddr,0,1);
        au.println("#无限能量");
        au.moveValue(this.getEnergyAddr,0,149);
        au.println("#技能无CD");
        au.moveValue(this.getSkillCDAddr,0,1);
        au.println("#材料显示");
        au.bl(this.materailDisAddr1,this.materailDisAddr1+0x30,"");
        au.printOneCommand(this.materailDisAddr2,"1F 03 A0 E3");
        au.println("#材料数量判断");
        au.moveValue(this.hasMaterailAddr,0,1);
        au.println("#锻造台");
        au.moveValue(this.forgAddr,5,9);
        au.println("#设计台研发_新");
        au.bl(this.weaponStationAddr1,this.weaponStationAddr1+0x1B8,"");
        au.moveValue(this.weaponStationAddr2,0,1);
        au.println("#种子修改");
        au.printOneCommand(this.seedAddr1,"1F 23 A0 E3");
        au.moveValue(this.seedAddr2,0,1);
        au.println("#打开材料箱增加数量");
        au.printOneCommand(this.addMaterailAddr1,"FD 2C A0 E3");
        au.bl(this.addMaterailAddr2,this.itemDataAddMaterialAddr,"BL ItemData$$AddMaterial");
        au.printOneCommand(this.addMaterailAddr3,"FD 7C A0 E3");
        au.println("#存档上传解除限制");
        au.printOneCommand(this.uploadAddr,"89 00 00 EB");
        au.println("#增加种子 在地窖中点击战斗详情");
        au.moveValue(this.addSeedAddr1,5,2);
        au.bl(this.addSeedAddr2,this.itemDataGet_dataAddr,"BL ItemData$$get_data");
        au.printOneCommand(this.addSeedAddr3,"08 50 95 E5 #LDR R5, [R5,#0x8]");
        au.printOneCommand(this.addSeedAddr4,"FD 2C A0 E3 #mov r2,#64768");
        au.bl(this.addSeedAddr5,this.itemDataAddSeedAddr,"BL ItemData$$AddSeed");
        au.println("#增加武器获取次数  点击锻造他增加");
        au.moveValue(this.addWeaponTimesAddr1,2,8);
        au.bl(this.addWeaponTimesAddr2,this.statisticDataAddObtainTimesAddr,"BL StatisticData$$AddObtainTimes");
        au.moveValue(this.addWeaponTimesAddr3,5,8);
        au.moveValue(this.addWeaponTimesAddr4,8,1);
        au.println("#快递领宝石");
        au.printOneCommand(this.postManAddr,"0F 18 A0 E3 #MOV             R1, #0xF0000");
        au.println("#无敌");
        au.moveValue(this.getHertAddr,9,0);
        au.moveValue(this.getHertAddr2,9,0);
        au.println("#解锁房间所有物品");
        au.moveValue(this.roomLevel9Addr,5,9);
        au.println("#解锁房间所有物品 存档");
        au.moveValue(this.unlockRoomLevelAddr1,1,9);
        au.bl(this.unlockRoomLevelAddr2,this.playerSaveDataSet_room_levelAddress,"BL PlayerSaveData$$set_room_level");

        au.setBaseAddr(oldBase);
    }
}
