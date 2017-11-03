package com.example.testtool.domain;

import com.example.testtool.domain.configuration.ToolConfiguration;
import com.example.testtool.domain.deployable.DeployableArtifact;
import com.example.testtool.domain.server.ContainerServer;

public class DeployUtilInternalApplication {

	private final ToolConfiguration config;

	private final DeployableArtifact artifact;

	public DeployUtilInternalApplication(
			   ToolConfiguration config,
               DeployableArtifact artifact/*,
               String command*/
           ) {
		super();
		this.config = config;
		this.artifact = artifact;
	}

	public void deploy(ContainerServer server) throws Exception {
		server.deploy(artifact, config);
	}
	
	public void undeploy(ContainerServer server) throws Exception {
		server.undeploy(artifact.id());
	}

	public String status(ContainerServer server) throws Exception {
		return server.status(artifact.id());
	}

	public void start(ContainerServer server) throws Exception {
		server.start(artifact.id());
	}
	
	public void stop(ContainerServer server) throws Exception {
		server.stop(artifact.id());
	}

	public Object name() {
		return artifact.id().wrappedId();
	}
}
