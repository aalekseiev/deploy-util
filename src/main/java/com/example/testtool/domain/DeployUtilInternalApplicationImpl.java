package com.example.testtool.domain;

import org.springframework.stereotype.Component;

import com.example.testtool.domain.deployable.DeployableArtifact;
import com.example.testtool.domain.server.ContainerServer;

@Component
public final class DeployUtilInternalApplicationImpl implements DeployUtilInternalApplication {

	private final DeployableArtifact artifact;

	public DeployUtilInternalApplicationImpl(
               DeployableArtifact artifact
           ) {
		super();
		this.artifact = artifact;
	}

	@Override
	public void deploy(ContainerServer server) throws Exception {
		server.deploy(artifact);
	}
	
	@Override
	public void undeploy(ContainerServer server) throws Exception {
		server.undeploy(artifact.id());
	}

	@Override
	public String status(ContainerServer server) throws Exception {
		return server.status(artifact.id());
	}

	@Override
	public void start(ContainerServer server) throws Exception {
		server.start(artifact.id());
	}
	
	@Override
	public void stop(ContainerServer server) throws Exception {
		server.stop(artifact.id());
	}

	@Override
	public Object name() {
		return artifact.id().wrappedId();
	}
}
