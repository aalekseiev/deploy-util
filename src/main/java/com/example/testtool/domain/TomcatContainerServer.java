package com.example.testtool.domain;

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
	public void deploy(Artifact artifact, Configuration configuration) {
		// httpclient.put(url, artifact)
	}

}
