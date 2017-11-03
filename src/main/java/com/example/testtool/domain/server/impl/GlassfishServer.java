package com.example.testtool.domain.server.impl;

import com.example.testtool.domain.deployable.ArtifactId;
import com.example.testtool.domain.deployable.DeployableArtifact;
import com.example.testtool.domain.server.ContainerServer;

/**
 * This class exists just to show that other implementations of ContainerServer may exist.
 * */
public final class GlassfishServer implements ContainerServer {

	@Override
	public void deploy(DeployableArtifact artifact) throws Exception {
		System.out.println("Dummy message");
	}

	@Override
	public String status(ArtifactId artifactId) {
		return "";
	}

	@Override
	public void start(ArtifactId artifactId) {
		System.out.println("Dummy message");
	}

	@Override
	public void undeploy(ArtifactId artifactId) {
		System.out.println("Dummy message");
	}

	@Override
	public void stop(ArtifactId artifactId) throws Exception {
		
	}

}
