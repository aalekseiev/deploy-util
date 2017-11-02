package com.example.testtool.domain.deployable.impl;

import java.io.InputStream;

import com.example.testtool.domain.deployable.ArtifactId;
import com.example.testtool.domain.deployable.DeployableArtifact;

public final class StreamArtifact implements DeployableArtifact {

	private final InputStream stream;
	
	public StreamArtifact(InputStream stream) {
		super();
		this.stream = stream;
	}

	@Override
	public InputStream stream() throws Exception {
		return stream;
	}

	@Override
	public ArtifactId id() {
		return new StreamArtifactId(stream.toString());
	}

}
