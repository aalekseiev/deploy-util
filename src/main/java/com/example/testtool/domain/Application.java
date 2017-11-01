package com.example.testtool.domain;

public class Application {

	private final Configuration config;

	private final Artifact artifact;

	public Application(Configuration config, Artifact artifact) {
		super();
		this.config = config;
		this.artifact = artifact;
	}

	public void deploy(ContainerServer server) {
		server.deploy(artifact);
	}
}
