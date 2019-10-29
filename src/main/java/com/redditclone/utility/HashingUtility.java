package com.redditclone.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingUtility {
	public static String getHashValue(String data) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		
		md.update(data.getBytes());
		
		byte byteData[] = md.digest();
		StringBuffer hexString = new StringBuffer();
		
		for (int i = 0 ; i < byteData.length; i++) {
			String hex = Integer.toHexString(0xff & byteData[i]);
			
			if (hex.length() == 1)
				hexString.append('0');
			hexString.append(hex);
		}
		return hexString.toString();
	}
}
