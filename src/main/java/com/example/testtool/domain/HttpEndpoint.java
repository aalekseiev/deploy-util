package com.example.testtool.domain;

import java.io.InputStream;

public interface HttpEndpoint {

	void put(String url, String username, char[] secret, InputStream body) throws Exception;

}