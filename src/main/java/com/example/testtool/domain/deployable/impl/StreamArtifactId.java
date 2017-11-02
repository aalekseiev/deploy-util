package com.example.testtool.domain.deployable.impl;

import com.example.testtool.domain.deployable.ArtifactId;

public class StreamArtifactId implements ArtifactId {

	private final String id;

	public StreamArtifactId(String string) {
		this.id = string;
	}

	@Override
	public Object wrappedId() {
		return id;
	}

}
