package com.example.testtool.domain.deployable;

public final class WarFileArtifact implements DeployableArtifact {

	private final String filename;

	public WarFileArtifact(String filename) {
		super();
		this.filename = filename;
	}

}
