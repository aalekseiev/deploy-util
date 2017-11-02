package com.example.testtool.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class DefaultHttpEndpoint implements HttpEndpoint {
	
	@Override
	public void put(String address, String username, char[] secret, InputStream body) throws IOException, AuthenticationException {
	    CloseableHttpClient client = HttpClients.createDefault();
	    HttpPut httpPut = new HttpPut(address);
	 
	    UsernamePasswordCredentials creds
	      = new UsernamePasswordCredentials("tomcat", "s3cret");
	    httpPut.addHeader(new BasicScheme().authenticate(creds, httpPut, null));
	    
	    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
	    builder.addBinaryBody("file", body,
	      ContentType.APPLICATION_OCTET_STREAM, "file.ext");
	 
	    HttpEntity multipart = builder.build();
	    httpPut.setEntity(multipart);
	 
	    CloseableHttpResponse response = client.execute(httpPut);
	    assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
	    client.close();
	}
	
}
