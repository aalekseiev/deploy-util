package com.example.testtool.domain;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class DefaultHttpEndpoint implements HttpEndpoint {
	
	/* "http://example.com" */
	@Override
	public void put(String address) throws IOException {
		
		URL url = new URL(address);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("PUT");
		
		con.setRequestProperty("Content-Type", "multipart/form-data");
		int responseCode = con.getResponseCode();
		
		System.out.println(responseCode);
		
	}
	
}
