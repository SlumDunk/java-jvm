package com.slam.dunk.day03.classloader.service;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Author: zerongliu
 * @Date: 3/31/20 21:08
 * @Description:
 */
public interface IDemoEncryptService {
    void encrypt(InputStream src, OutputStream des) throws Exception;

    byte[] decrypt(InputStream src) throws Exception;
}
