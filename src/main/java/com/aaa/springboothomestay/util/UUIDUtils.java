package com.aaa.springboothomestay.util;

import java.util.UUID;

public class UUIDUtils {

    public static String ImgName(){
        UUID uuid = UUID.randomUUID();
        //System.out.println(uuid);
        return uuid.toString();
    }

    public static void main(String[] args) {
        System.out.println(UUIDUtils.ImgName());
    }
}
