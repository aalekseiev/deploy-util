package com.example.testtool.domain.server;

import com.example.testtool.domain.configuration.Configuration;
import com.example.testtool.domain.deployable.DeployableArtifact;

public final class TomcatContainerServer implements ContainerServer {

	/** http://localhost:8080/manager/text/deploy?path=/foo 
	 * HTTP PUT request
	 * */
	private final String adminEndpointUrl;

	public TomcatContainerServer(String adminEndpointUrl) {
		super();
		this.adminEndpointUrl = adminEndpointUrl;
	}

	@Override
	public void deploy(DeployableArtifact artifact, Configuration configuration) {
		// httpclient.put(url, artifact)
	}

}
