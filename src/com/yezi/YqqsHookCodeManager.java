package com.yezi;

import java.util.ArrayList;

public class YqqsHookCodeManager {
    private ArrayList<YqqsHookCode> codes = null;
    private static YqqsHookCodeManager manager = null;

    private YqqsHookCodeManager(){};

    public static YqqsHookCodeManager getInstance() {
        if (manager == null) {
            manager = new YqqsHookCodeManager();
        }
        return manager;
    }

    public ArrayList<YqqsHookCode> getCodes() {
        if (codes == null) {
            codes = new ArrayList<>();

            YqqsOthers yo = new YqqsOthers();
            codes.add(yo);

            //BL SDKManager$$CheckSignatrue
            yo.setSignAddr(0x00460D70);
            //RoleAttributePlayer$$get_energy
            yo.setGetEnergyAddr(0x00450340);
            //RoleAttributePlayer$$get_skill_ready 中  MOVGE R0, #1
            yo.setGetSkillCDAddr(0x0045191C);
            //ItemData$$GetMaterialCount
            yo.setMaterailDisAddr1(0x005B6EE4);
            yo.setMaterailDisAddr2(0x005B6F14);
            //ItemData$$HasEnough
            yo.setHasMaterailAddr(0x005BB5D4);
            //UIForge$$FlushType_5028944 中 BL StatisticData$$GetObtainTime
            yo.setForgAddr(0x004CBF54);
            //UIWeaponStation$$OnClick_Research
            yo.setWeaponStationAddr1(0x0052413C);
            //UIWeaponStation$$Flush 中 BL ItemData$$GetBluePrintStatus
            yo.setWeaponStationAddr2(0x00523D18);
            //UIPlant$$FlushSeeds 中 MOV R2, R0  BL UIPlant$$CreateSeedItem
            yo.setSeedAddr1(0x0050DB20);
            //UIPlant$$OnClick_Plant 中 BL ItemData$$ConsumeSeed
            yo.setSeedAddr2(0x0050E86C);

            //在 UIMaterialChest$$Flush 中  MOV R2, #0
            //在 UIMaterialChest$$Flush 中  BL ItemData$$GetMaterialCount
            yo.setAddMaterailAddr1(0x004D1340);

            //ItemData$$AddMaterial
            yo.setItemDataAddMaterialAddr(0x005BA194);

            //CloudSaveAgent._SaveGame_c__AnonStorey1$$__m__0
            //BNE             loc_3DD938
            //StringLiteral_8692  ; 上传失败:该存档不属于此账号
            yo.setUploadAddr(0x003DD70C);
            //UIWindowStatistics$$ShowWindow  #mov r5,#2
            yo.setAddSeedAddr1(0x00617F00);
            //UIWindowStatistics$$FlushPlant 中BL StatisticData$$get_data
            yo.setAddSeedAddr2(0x00619B40);
            //ItemData$$get_data
            yo.setItemDataGet_dataAddr(0x005B6CA4);
            //UIWindowStatistics$$FlushPlant 中 #LDR R5, [R5,#0xC]
            yo.setAddSeedAddr3(0x00619B54);
            //UIWindowStatistics$$FlushPlant 中 MOV R2, #0
            yo.setAddSeedAddr4(0x00619B6C);
            //UIWindowStatistics$$FlushPlant 中 BL StatisticData$$GetObtainTime
            yo.setAddSeedAddr5(0x00619B70);
            //ItemData$$AddSeed
            yo.setItemDataAddSeedAddr(0x005B9E3C);

            //UIForge$$FlushType_5028944 中
            // #BL StatisticData$$GetObtainTime 前一行 #MOV R2, #8
            yo.setAddWeaponTimesAddr1(0x004CBF4C);
            //StatisticData$$AddObtainTimes
            yo.setStatisticDataAddObtainTimesAddr(0x004699B0);
            //StatisticData$$AddObtainTimes 中 MOV R8, R3
            yo.setAddWeaponTimesAddr4(0x004699C0);

            //ObjectPostman$$GetReward 中 MOV R1, #0x1F4
            yo.setPostManAddr(0x005FF2E0);

            //RGController$$GetHurt  MOV  R9, R1
            yo.setGetHertAddr(0x006A494C);
            //RGController$$GetHurt ADDNE R9, R9, #1
            yo.setGetHertAddr2(0x006A49D8);

            //RoomObjectManager$$InitUnlockObjects
            //BL     PlayerSaveData$$get_room_level 上面一行
            //MOV   R1, #0
            yo.setUnlockRoomLevelAddr1(0x00457144);
            // PlayerSaveData$$set_room_level
            yo.setPlayerSaveDataSet_room_levelAddress(0x00378BF0);

            YqqsFileVerify yf = new YqqsFileVerify();
            //TestConf$$.ctor 基址
            yf.setBaseAddr(0x00610228);
            //BL SDKManager$$CheckSignatrue 在awake中
            yf.setHookAddr(0x00460D70);
            //TestPathConf$$get_backup_path
            yf.setTestPathConfGet_backup_path(0x006102CC);
            //File$$Exists
            yf.setFileExists(0x00D23700);
            //SDKManager$$CheckSignatrue
            yf.setsDKManagerCheckSignatrue(0x00460E1C);
            codes.add(yf);


            YqqsHookMac yh = new YqqsHookMac();

            //TestPathConf$$get_purchase_path
            yh.setBaseAddr(0x006104E0);
            //BL SdkManager$$getAndroidID 在get_mac中
            yh.setHookAddr(0x003E02B4);
            //SdkManager$$getAndroidID
            yh.setGetAndroidIDAddr(0x00460C08);
            //StringBuilder.ctor()
            yh.setStringBuilderCtorAddr(0x00FD3204);
            //StringBuilder.Append(int i)
            yh.setStringBuilderAppendIntAddr(0x00FD49B0);
            //StringBuilder$$ToString()
            yh.setStringBuilderToStringAddr(0x00FD38CC);
            //String$$Substring(int index,int length)
            yh.setStringSubstringAddr(0x00BC56D4);
            //String$$Replace(String s1,String s2)
            yh.setStringReplaceAddr(0x00BEA538);

            codes.add(yh);

            YqqsUnlockSkin ys = new YqqsUnlockSkin();
            //BL EventTrigger$$Test
            ys.setbLEventTriggerTestAddr(0x0167BB38);
            //基址 EventTrigger$$Test
            ys.setBaseAddr(0x0167BB74);
            //UIWindowPlutus$$CheckReward中 BL RGSaveManager$$PetUnLock
            ys.setHookAddr(0x004AF9B8);
            //RGSaveManager$$HeroSkinUnlock 中 BL RGSaveManager$$ConsumeGem
            ys.setHeroSkinUnlock_ConsumeGemAddr(0x004FBFC0);
            //RGSaveManager$$HeroSkinUnlock
            ys.setrGSaveManagerHeroSkinUnlock(0x004FBEC4);
            ////RGSaveManager$$PetUnLock 中 BL RGSaveManager$$ConsumeGem
            ys.setPetUnLock_ConsumeGemAddr(0x004FC2E0);
            //RGSaveManager$$PetUnLock
            ys.setrGSaveManagerPetUnLock(0x004FC290);

            codes.add(ys);


        }
        return codes;
    }
}
