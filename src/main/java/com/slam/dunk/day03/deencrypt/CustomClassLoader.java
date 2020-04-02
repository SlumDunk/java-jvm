package com.slam.dunk.day03.deencrypt;

import java.io.File;

/**
 * @Author: zerongliu
 * @Date: 3/31/20 21:49
 * @Description:
 */
public class CustomClassLoader extends ClassLoader {
    private final String name;
    private String basePath;
    private final static String FILE_EXT = ".class";

    public CustomClassLoader(String name) {
        super();
        this.name = name;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    /**
     * load class data and decrypt
     *
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {
        int x = 0;
        byte[] data = null;
        XorEncrpt demoEncryptUtil = new XorEncrpt();
        // use x;
        int y = 1;
        try {
            String tempName = name.replaceAll("\\.", "/");
            data = demoEncryptUtil.decrypt(new File(basePath + tempName + FILE_EXT));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = this.loadClassData(name);
        return this.defineClass(name, data, 0, data.length);
    }
}
