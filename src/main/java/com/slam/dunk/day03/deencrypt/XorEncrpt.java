package com.slam.dunk.day03.deencrypt;

import java.io.*;

/**
 * @Author: zerongliu
 * @Date: 3/31/20 21:47
 * @Description:
 */
public class XorEncrpt {

    private void xor(InputStream in, OutputStream out) throws Exception {
        int ch;
        while (-1 != (ch = in.read())) {
            ch = ch ^ 0xff;
            out.write(ch);
        }
    }

    /**
     * encrypt file
     *
     * @param src
     * @param des
     * @throws Exception
     */
    public void encrypt(File src, File des) throws Exception {
        InputStream in = new FileInputStream(src);
        OutputStream out = new FileOutputStream(des);

        xor(in, out);

        in.close();
        out.close();
    }

    /**
     * decrypt file
     *
     * @param src
     * @return
     * @throws Exception
     */
    public byte[] decrypt(File src) throws Exception {
        InputStream in = new FileInputStream(src);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        xor(in, bos);
        byte[] data = bos.toByteArray();
        return data;
    }

}
