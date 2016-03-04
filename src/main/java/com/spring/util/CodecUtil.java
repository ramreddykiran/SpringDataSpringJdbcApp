package com.spring.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

public final class CodecUtil {
	
	private CodecUtil() {} // DON'T CALL ME!
	
	/**
	 * Decodes a String encoded in the following manner: String -> GZIP -> Base64 -> String
	 */
	public static String gzipDecode(String decodeString) throws IOException {
		
		// un-base64 to get gzip byte array
		byte[] gzipData = Base64.decodeBase64(decodeString);
		
		// ungzip json
		InputStream inputStream = new GZIPInputStream(new ByteArrayInputStream(gzipData));
		
		byte[] unzippedData = IOUtils.toByteArray(inputStream);
		inputStream.close();
		
		return IOUtils.toString(unzippedData, "UTF-8");
	}
	
	/**
	 * Encodes a String in the following manner: String -> GZIP -> Base64 -> String
	 */
	public static String gzipEncode(String encodeString) throws IOException {
		ByteArrayOutputStream gzipAsByteArrayOutputStream = new ByteArrayOutputStream();
		OutputStream gzipOut = new GZIPOutputStream(gzipAsByteArrayOutputStream);
		gzipOut.write(encodeString.getBytes());
		gzipOut.flush();
		gzipOut.close();
		byte[] getRequestBytes = Base64.encodeBase64(gzipAsByteArrayOutputStream.toByteArray());
		
		return IOUtils.toString(getRequestBytes);
	}
}
