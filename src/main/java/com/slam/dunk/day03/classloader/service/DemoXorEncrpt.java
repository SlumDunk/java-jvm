package com.slam.dunk.day03.classloader.service;

import java.io.*;

/**
 * @Author: zerongliu
 * @Date: 3/31/20 21:08
 * @Description:
 */
public class DemoXorEncrpt implements IDemoEncryptService {
    private void xor(InputStream in, OutputStream out) throws Exception {
        int ch;
        while (-1 != (ch = in.read())) {
            ch = ch ^ 0xff;
            out.write(ch);
        }
    }

    @Override
    public void encrypt(InputStream in, OutputStream out) throws Exception {
        xor(in, out);

        in.close();
        out.close();
    }

    @Override
    public byte[] decrypt(InputStream in) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        xor(in, bos);
        byte[] data = bos.toByteArray();
        ;
        return data;
    }
}
