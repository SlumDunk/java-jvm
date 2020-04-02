package com.slam.dunk.day03.classloader;

import com.slam.dunk.day03.classloader.service.DemoXorEncrpt;
import com.slam.dunk.day03.classloader.service.IDemoEncryptService;

import java.io.File;

/**
 * @Author: zerongliu
 * @Date: 3/31/20 21:11
 * @Description:
 */
public class DemoCustomClassLoader extends ClassLoader {
    private final static String FILE_EXT = ".class";
    private String name;


    public DemoCustomClassLoader(String name) {
        super();
        this.name = name;
    }


    private byte[] loadClassData(String name) {
        byte[] data = null;
        IDemoEncryptService demoEncryptUtil = new DemoXorEncrpt();
        try {
            data = demoEncryptUtil.decrypt(this.getClass().getResourceAsStream("/" + name + FILE_EXT));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

//    @Override
//    public Class<?> loadClass(String name) throws ClassNotFoundException {
//        if(name.indexOf("java.")<5&&name.indexOf("java.")>-1){
//            return super.loadClass(name);
//        }
//        byte[] data = this.loadClassData(name);
//        if (data == null){
//            return super.loadClass(name);
//        }
//        return this.defineClass(name,data,0,data.length);
//    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name.substring(name.lastIndexOf(".")+1));
        return this.defineClass(name, data, 0, data.length);
    }
}
