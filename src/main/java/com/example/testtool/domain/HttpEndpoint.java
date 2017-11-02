package com.example.testtool.domain;

public interface HttpEndpoint {

	void put(String url, String username, char[] secret) throws Exception;

}