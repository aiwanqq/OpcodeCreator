package com.yezi;

public class YqqsUnlockSkin implements YqqsHookCode {
    private int baseAddr;
    private int hookAddr;
    private int heroSkinUnlock_ConsumeGemAddr;
    private int rGSaveManagerHeroSkinUnlock;
    private int petUnLock_ConsumeGemAddr;
    private int rGSaveManagerPetUnLock;
    private int bLEventTriggerTestAddr;

    public void setBaseAddr(int baseAddr) {
        this.baseAddr = baseAddr;
    }

    public void setHookAddr(int hookAddr) {
        this.hookAddr = hookAddr;
    }

    public void setHeroSkinUnlock_ConsumeGemAddr(int heroSkinUnlock_ConsumeGemAddr) {
        this.heroSkinUnlock_ConsumeGemAddr = heroSkinUnlock_ConsumeGemAddr;
    }

    public void setrGSaveManagerHeroSkinUnlock(int rGSaveManagerHeroSkinUnlock) {
        this.rGSaveManagerHeroSkinUnlock = rGSaveManagerHeroSkinUnlock;
    }

    public void setPetUnLock_ConsumeGemAddr(int petUnLock_ConsumeGemAddr) {
        this.petUnLock_ConsumeGemAddr = petUnLock_ConsumeGemAddr;
    }

    public void setrGSaveManagerPetUnLock(int rGSaveManagerPetUnLock) {
        this.rGSaveManagerPetUnLock = rGSaveManagerPetUnLock;
    }

    public void setbLEventTriggerTestAddr(int bLEventTriggerTestAddr) {
        this.bLEventTriggerTestAddr = bLEventTriggerTestAddr;
    }

    @Override
    public void printCmd() {
        AssembleUtil au = AssembleUtil.getInstance();
        int oldBase = au.getBaseAddr();
        au.setBaseAddr(this.baseAddr);
        au.println("#干掉调用代码 BL EventTrigger$$Test");
        au.printOneCommand(this.bLEventTriggerTestAddr,"01 00 A0 E3 #MOV    R0, #1  #modify BL EventTrigger$$Test");
        au.println("#解锁人物和宠物皮肤");
        au.hookMethod(this.hookAddr,"Hook BL RGSaveManager$$HeroSkinUnlock");
        au.start();
        au.move(5,0);
        au.printOneCommand(this.heroSkinUnlock_ConsumeGemAddr,"01 00 A0 E3 #MOV    R0, #1  #modify BL RGSaveManager$$HeroSkinUnlock");
        int[] skinIndex = {7,5,6,6,4,
                6,6,6,5,8,
                4,5,3,2};
        for (int i = 0; i < skinIndex.length; i++) {
            for (int j = 1; j < skinIndex[i] + 1; j++) {
                au.move(0,5);
                au.moveValue(1,i);
                au.moveValue(2,j);
                au.bl(this.rGSaveManagerHeroSkinUnlock,"BL RGSaveManager$$HeroSkinUnlock");
            }
        }
        au.printOneCommand(this.petUnLock_ConsumeGemAddr,"01 00 A0 E3 #MOV    R0, #1  #modify BL RGSaveManager$$ConsumeGem");
        for (int i = 0; i < 11; i++) {
            au.move(0,5);
            au.moveValue(1,i);
            au.bl(this.rGSaveManagerPetUnLock,"RGSaveManager$$PetUnLock");
        }
        au.stop();
        au.setBaseAddr(oldBase);
    }
}
