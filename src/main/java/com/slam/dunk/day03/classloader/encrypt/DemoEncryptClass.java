package com.slam.dunk.day03.classloader.encrypt;

import com.slam.dunk.day03.classloader.service.DemoXorEncrpt;
import com.slam.dunk.day03.classloader.service.IDemoEncryptService;

import java.io.*;

/**
 * @Author: zerongliu
 * @Date: 3/31/20 21:10
 * @Description:
 */
public class DemoEncryptClass {
    public static void main(String[] args) throws Exception {
        InputStream in = DemoEncryptClass.class.getResourceAsStream("/App.class");
        String url = DemoEncryptClass.class.getResource("/").getFile();
        OutputStream out = new FileOutputStream(url+ "App.class");
        IDemoEncryptService demoEncryptUtil = new DemoXorEncrpt();
        demoEncryptUtil.encrypt(in, out);
        System.out.println("encrypt successfully");
    }
}
