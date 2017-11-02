package com.example.testtool.domain.server.impl;

import com.example.testtool.domain.DefaultHttpEndpoint;
import com.example.testtool.domain.HttpEndpoint;
import com.example.testtool.domain.configuration.Configuration;
import com.example.testtool.domain.deployable.DeployableArtifact;
import com.example.testtool.domain.server.ContainerServer;

public final class TomcatContainerServer implements ContainerServer {

	private final String serverUrl;
	
	private final String username;
	
	private final char[] secret;
	
	private final HttpEndpoint httpEndpoint;
	
	private static final String CONTEXT_PUT = "/manager/text/deploy?path=/sample"; 

	public TomcatContainerServer(String serverUrl, String username, char[] sercret) {
		super();
		this.serverUrl = serverUrl;
		this.username = username;
		this.secret = sercret;
		this.httpEndpoint = new DefaultHttpEndpoint();
	}

	@Override
	public void deploy(DeployableArtifact artifact, Configuration configuration) throws Exception {
		this.httpEndpoint.put(serverUrl + CONTEXT_PUT, username, secret, artifact.stream());
	}

}