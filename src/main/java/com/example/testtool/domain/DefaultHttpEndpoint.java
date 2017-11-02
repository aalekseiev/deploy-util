package com.example.testtool.domain;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DefaultHttpEndpoint implements HttpEndpoint {

	@Override
	public void put(String address, String username, char[] s3cret, InputStream body)
			throws IOException, AuthenticationException {
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpPut httpPut = new HttpPut(address);

			UsernamePasswordCredentials creds = new UsernamePasswordCredentials(username, new String(s3cret));
			httpPut.addHeader(new BasicScheme().authenticate(creds, httpPut, null));

			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.addBinaryBody("file", body, ContentType.APPLICATION_OCTET_STREAM, "file.ext");

			HttpEntity multipart = builder.build();
			httpPut.setEntity(multipart);

			try (CloseableHttpResponse response = client.execute(httpPut)) {
				if (response.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed to execute put request. Context: " + address);
				}
			}
		}
	}

	@Override
	public String get(String address, String username, char[] s3cret)
			throws ClientProtocolException, IOException, AuthenticationException {
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpGet httpGet = new HttpGet(address);

			UsernamePasswordCredentials creds = new UsernamePasswordCredentials(username, new String(s3cret));
			httpGet.addHeader(new BasicScheme().authenticate(creds, httpGet, null));

			try (CloseableHttpResponse response = client.execute(httpGet)) {
				if (response.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed to execute get request. Context: " + address);
				}

				HttpEntity entity = response.getEntity();
				return EntityUtils.toString(entity, "UTF-8");
			}
		}
	}

	@Override
	public void post(String address, String username, char[] s3cret)
			throws AuthenticationException, ClientProtocolException, IOException {
		try (CloseableHttpClient client = HttpClients.createDefault()) {
			HttpPost httpPost = new HttpPost(address);

			UsernamePasswordCredentials creds = new UsernamePasswordCredentials(username, new String(s3cret));
			httpPost.addHeader(new BasicScheme().authenticate(creds, httpPost, null));

			try (CloseableHttpResponse response = client.execute(httpPost)) {
				if (response.getStatusLine().getStatusCode() != 200) {
					throw new RuntimeException("Failed to execute post request. Context: " + address);
				}

				HttpEntity entity = response.getEntity();
				String responseString = EntityUtils.toString(entity, "UTF-8");
				System.out.println(responseString);
			}
		}
	}

}
