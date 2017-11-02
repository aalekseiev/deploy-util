package com.example.testtool.domain.server.impl;

import com.example.testtool.domain.DefaultHttpEndpoint;
import com.example.testtool.domain.HttpEndpoint;
import com.example.testtool.domain.configuration.Configuration;
import com.example.testtool.domain.deployable.ArtifactId;
import com.example.testtool.domain.deployable.DeployableArtifact;
import com.example.testtool.domain.server.ContainerServer;

public final class TomcatContainerServer implements ContainerServer {

	private final String serverUrl;
	
	private final String username;
	
	private final char[] s3cret;
	
	private final HttpEndpoint httpEndpoint;
	
	private static final String CONTEXT_PUT = "/manager/text/deploy?path=/sample"; 

	public TomcatContainerServer(String serverUrl, String username, char[] sercret) {
		super();
		this.serverUrl = serverUrl;
		this.username = username;
		this.s3cret = sercret;
		this.httpEndpoint = new DefaultHttpEndpoint();
	}

	@Override
	public void deploy(DeployableArtifact artifact, Configuration configuration) throws Exception {
		this.httpEndpoint.put(serverUrl + CONTEXT_PUT, username, s3cret, artifact.stream());
	}

	@Override
	public String status(ArtifactId artifactId) throws Exception {
		String text = this.httpEndpoint.get(serverUrl + "/manager/text/list", username, s3cret);
		return new TomcatResponseParser(text).applicationLine(artifactId);
	}

	@Override
	public void start(ArtifactId artifactId) throws Exception {
		String text = this.httpEndpoint.get("/manager/text/start?path=/" + artifactId.wrappedId(), username, s3cret);
		System.out.println(text);
	}

	@Override
	public void undeploy(ArtifactId artifactId) throws Exception {
		this.httpEndpoint.get(serverUrl + "/manager/text/undeploy?path=/" + artifactId.wrappedId(), username, s3cret);
	}

}
