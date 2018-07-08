package com.junier.httpdemo.model;

import java.io.File;

public class ResponseHeaders {
	
	private int statusCode;
	
	private String englishStatusCode;
	
	private String contentType;
	
	private File file;
	
	private String redirectIp;

	public ResponseHeaders() {
		
	}

	public ResponseHeaders(int statusCode, String englishStatusCode, String contentType) {
		this.statusCode = statusCode;
		this.englishStatusCode = englishStatusCode;
		this.contentType = contentType;
	}
	
	public ResponseHeaders(int statusCode, String englishStatusCode, String contentType, String redirectIp) {
		this.statusCode = statusCode;
		this.englishStatusCode = englishStatusCode;
		this.contentType = contentType;
		this.redirectIp = redirectIp;
	}
	
	public ResponseHeaders(int statusCode, String englishStatusCode, String contentType, File file) {
		this.statusCode = statusCode;
		this.englishStatusCode = englishStatusCode;
		this.contentType = contentType;
		this.file = file;
	}
	
	public ResponseHeaders(int statusCode, String englishStatusCode, String contentType, File file, String redirectIp) {
		this.statusCode = statusCode;
		this.englishStatusCode = englishStatusCode;
		this.contentType = contentType;
		this.file = file;
		this.redirectIp = redirectIp;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public String getEnglishStatusCode() {
		return englishStatusCode;
	}

	public void setEnglishStatusCode(String englishStatusCode) {
		this.englishStatusCode = englishStatusCode;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getRedirectIp() {
		return redirectIp;
	}

	public void setRedirectIp(String redirectIp) {
		this.redirectIp = redirectIp;
	}
	
	
}
