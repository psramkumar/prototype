package com.vzb.prj.util;

public class ByteUtils
{

    public ByteUtils()
    {
    }

    public static byte[] fromHexString(String s)
    {
        if((s.length() & 1) != 0)
            throw new IllegalArgumentException("Invalid hex string; \"" + s + "\" is of odd length.");
        String s2;
        try
        {
            byte abyte0[] = new byte[s.length() / 2];
            for(int i = 0; i < s.length(); i += 2)
            {
                String s1 = s.substring(i, i + 2);
                abyte0[i / 2] = (byte)Integer.parseInt(s1, 16);
            }

            return abyte0;
        }
        catch(NumberFormatException numberformatexception)
        {
            s2 = numberformatexception.toString() + "\n\"" + s + "\" is not a hexadecimal formatted string.";
        }
        throw new IllegalArgumentException(s2);
    }

    public static void main(String args[])
    {
        for(int i = 0; i < args.length; i++)
        {
            byte abyte0[] = args[i].getBytes();
            String s = toHexString(abyte0);
            System.out.println(args[i] + ": " + s);
        }

    }

    public static String toHexString(byte abyte0[])
    {
        char ac[] = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
            'a', 'b', 'c', 'd', 'e', 'f'
        };
        char ac1[] = new char[abyte0.length * 2];
        for(int l = 0; l < abyte0.length; l++)
        {
            int k = l * 2;
            int i = (0xf0 & abyte0[l]) >> 4;
            int j = 0xf & abyte0[l];
            ac1[k] = ac[i];
            ac1[k + 1] = ac[j];
        }

        return new String(ac1);
    }
}
