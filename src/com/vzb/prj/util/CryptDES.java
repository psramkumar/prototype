package com.vzb.prj.util;

import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.Security;

import com.sun.crypto.provider.SunJCE;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptDES
{

    public CryptDES()
    {
    }

    public byte[] decrypt(byte abyte0[])
        throws GeneralSecurityException
    {
        Cipher cipher = init();
        cipher.init(2, key, ivSpec);
        byte abyte1[] = cipher.doFinal(abyte0);
        return unpad(abyte1);
    }

    public byte[] encrypt(byte abyte0[])
        throws GeneralSecurityException
    {
        Cipher cipher = init();
        cipher.init(1, key, ivSpec);
        byte abyte1[] = pad(abyte0);
        return cipher.doFinal(abyte1);
    }

    private Cipher init()
        throws GeneralSecurityException
    {
        Cipher cipher = Cipher.getInstance("DES/CBC/NoPadding");
        byte abyte0[] = new byte[8];
        params = AlgorithmParameters.getInstance("DES");
        ivSpec = new IvParameterSpec(abyte0);
        params.init(ivSpec);
        return cipher;
    }

    public static byte[] pad(byte abyte0[])
    {
        int i = abyte0.length % 8;
        int j = 8 - i;
        if(j == 0)
            j = 8;
        int k = abyte0.length + j;
        byte abyte1[] = new byte[k];
        System.arraycopy(abyte0, 0, abyte1, 0, abyte0.length);
        abyte1[k - 1] = (byte)i;
        return abyte1;
    }

    public void setKey(byte abyte0[])
    {
        key = new SecretKeySpec(abyte0, "DES");
    }

    public static byte[] unpad(byte abyte0[])
    {
        byte byte0 = abyte0[abyte0.length - 1];
        int i = 8 - byte0;
        if(i == 0)
            i = 8;
        int j = abyte0.length - i;
        byte abyte1[] = new byte[j];
        System.arraycopy(abyte0, 0, abyte1, 0, j);
        return abyte1;
    }

    private SecretKeySpec key;
    private AlgorithmParameters params;
    private IvParameterSpec ivSpec;
    public static final int BLOCK_SIZE = 8;

    static 
    {
        SunJCE sunjce = new SunJCE();
        Security.addProvider(sunjce);
    }
}
