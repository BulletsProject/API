package logic.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Date;

public class Tools {

	public static String md5(String value) throws NoSuchAlgorithmException {
		MessageDigest m = MessageDigest.getInstance("MD5");
	    byte[] data = value.getBytes(); 
	    m.update(data,0,data.length);
	    BigInteger i = new BigInteger(1,m.digest());		
		return i.toString(16).toLowerCase();		
	}
	
	public static long unixTimeStamp(Date date) {
		Timestamp currentTimestamp = new Timestamp(date.getTime());
		return currentTimestamp.getTime() / 1000L;
	}
	
}
