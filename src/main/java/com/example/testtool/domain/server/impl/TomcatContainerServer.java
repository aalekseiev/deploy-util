package com.example.testtool.domain.server.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.testtool.domain.DefaultHttpEndpoint;
import com.example.testtool.domain.HttpEndpoint;
import com.example.testtool.domain.deployable.ArtifactId;
import com.example.testtool.domain.deployable.DeployableArtifact;
import com.example.testtool.domain.server.ContainerServer;

@Component
public final class TomcatContainerServer implements ContainerServer {

	private static final String CONTEXT_DEPLOY = "/manager/text/deploy?path=/sample";
	
	private static final String CONTEXT_UNDEPLOY = "/manager/text/undeploy?path=/";

	private static final String CONTEXT_START = "/manager/text/start?path=/";
	
	private static final String CONTEXT_STOP = "/manager/text/stop?path=/";

	private static final String CONTEXT_LIST = "/manager/text/list";

	private final String serverUrl;
	
	private final String username;
	
	private final char[] s3cret;
	
	private final HttpEndpoint httpEndpoint;
	
	@Autowired
	public TomcatContainerServer(
			    @Value("${serverUrl}") String serverUrl,
			    @Value("${username}") String username,
			    @Value("${password}") char[] sercret
		   ) {
		super();
		this.serverUrl = serverUrl;
		this.username = username;
		this.s3cret = sercret;
		this.httpEndpoint = new DefaultHttpEndpoint();
	}

	@Override
	public void deploy(DeployableArtifact artifact) throws Exception {
		this.httpEndpoint.put(serverUrl + CONTEXT_DEPLOY, username, s3cret, artifact.stream());
	}

	@Override
	public String status(ArtifactId artifactId) throws Exception {
		String text = this.httpEndpoint.get(serverUrl + CONTEXT_LIST, username, s3cret);
		return new TomcatResponseParser(text).applicationLine(artifactId);
	}

	@Override
	public void start(ArtifactId artifactId) throws Exception {
		this.httpEndpoint.get(serverUrl + CONTEXT_START + artifactId.wrappedId(), username, s3cret);
	}
	
	@Override
	public void stop(ArtifactId artifactId) throws Exception {
		this.httpEndpoint.get(serverUrl + CONTEXT_STOP + artifactId.wrappedId(), username, s3cret);
	}

	@Override
	public void undeploy(ArtifactId artifactId) throws Exception {
		this.httpEndpoint.get(serverUrl + CONTEXT_UNDEPLOY + artifactId.wrappedId(), username, s3cret);
	}

}
