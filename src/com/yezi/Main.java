package com.yezi;


public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        for (YqqsHookCode code: YqqsHookCodeManager.getInstance().getCodes()){
            code.printCmd();
        }

        createEnableProper();

    }


    private void createEnableProper() {
        AssembleUtil au = AssembleUtil.getInstance();
        System.out.println();System.out.println();System.out.println();System.out.println();
        for (int i = 0; i < au.getIndex(); i++) {
            System.out.println("e"+i+"=1");
        }
    }


}
