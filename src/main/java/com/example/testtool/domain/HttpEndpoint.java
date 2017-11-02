package com.example.testtool.domain;

import java.io.InputStream;

public interface HttpEndpoint {

	void put(String url, String username, char[] secret, InputStream body) throws Exception;

	String get(String url, String username, char[] secret) throws Exception;

	void post(String url, String username, char[] s3cret) throws Exception;

}