package com.vzb.prj.util;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import org.apache.log4j.Logger;



/**
 * @author ssullivan
 *
 */
public class CipherData {

    private static String key = "1212321212921242";    						    
	private static Logger logger = Logger.getLogger(CipherData.class);
    private static CryptDES cryptdes ;

 
	public static String encrypt(String in) throws Exception {

		logger.debug("values are " + in);

		String result = null;		
		
		String delimiter = ":encrypt:"; 
		String data = in;
		

			init();
			byte abyte1[] = data.getBytes("UTF8");
			byte abyte3[] = cryptdes.encrypt(abyte1);
			result = ByteUtils.toHexString(abyte3);

		
		logger.info("data is = " + result);
		
		return result;		
		
	}
	/**
	 * This method takes in the key variable and translates it into an xml message.  Please add any additional
	 * changes to the key object to this structure below.
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String key) throws Exception {
		String result = null;

		if (key == null) {
			return result;
		}
		
		init();
		byte abyte1[] = ByteUtils.fromHexString(key);
		byte abyte3[] = cryptdes.decrypt(abyte1);
		String decryptStr = new String(abyte3, "UTF8");						
		result = decryptStr;

		return result;		
	}
	

	// static block below to setup the encryption
	private static void init() {
	
		byte abyte0[] = ByteUtils.fromHexString(key);
		if(cryptdes!=null)
			cryptdes.setKey(abyte0);
		else
		{
			try
			{
				cryptdes = new CryptDES();
				cryptdes.setKey(abyte0);
			}
			catch(Exception ex)
			{
				logger.error("Exception happened: " + ex.getMessage());				
			}
		}
	}

	public static String generateHtmlkey(String psr, 
			 String contactName, 
			 String templateName, 
			 String htmlKey, 
			 String toAddress,
			 String districtCode) throws Exception {

		//logger.debug("values are " + psr + " " + contactName + " " + templateName + " " + htmlKey);
	    String c4key = "1111777799993322";    						    
	    String C4DELIMITER = ":EnC:";
	    CryptDES c4Cryptdes = new CryptDES();
	    
		if (psr==null) {
		logger.error("encrypt: Psr is null, param 1");
		return null;
		}
		if (contactName==null) {
		logger.error("encrypt: ContactName is null, param 2");
		return null;
		}
		if (templateName==null) {
		logger.error("encrypt: TemplateName is null, param 3");
		return null;
		}
		if (htmlKey==null) {
		logger.error("encrypt: HtmlKey is null, param 4");
		return null;
		}
		if (toAddress==null) {
		logger.error("encrypt: ToAddress is null, param 5");
		return null;
		}
		if (districtCode==null) {
		logger.error("encrypt: districtCode is null, param 6");
		return null;
		}
		
		String result = null;		
		
		String data = psr + C4DELIMITER + contactName + C4DELIMITER 
		 + templateName + C4DELIMITER + htmlKey + C4DELIMITER 
		 + toAddress + C4DELIMITER + districtCode;
		
		try {
			
			byte abyte0[] = ByteUtils.fromHexString(c4key);
			c4Cryptdes.setKey(abyte0);

			byte abyte1[] = data.getBytes("UTF8");
			byte abyte3[] = c4Cryptdes.encrypt(abyte1);
			result = ByteUtils.toHexString(abyte3);
		
		} catch (UnsupportedEncodingException ue) {
		logger.error("encrypt: Caught UnSupportedEncoding Exception ");
		} catch (GeneralSecurityException gse) {
		logger.error("encrypt: Caught GeneralSecurityException Exception " + gse.getMessage());
		} catch (Exception e) {
		logger.error("encrypt: Caught general exception " + e.getMessage());			
		}
		
		//logger.info("data is = " + result);

		return result;		

	}	
	
	public static void main(String [] args) {
        
		String mypwd = null;
		String encrypMypwd = null;
		String decryptMypwd = null;
		try{
			mypwd = "smb2011";
			encrypMypwd = CipherData.encrypt(mypwd);
			
			logger.debug("Encrypt : " + encrypMypwd);
			
			decryptMypwd = CipherData.decrypt(encrypMypwd);
			
			logger.debug("Decrypt : " + decryptMypwd);
			
			 
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
}
