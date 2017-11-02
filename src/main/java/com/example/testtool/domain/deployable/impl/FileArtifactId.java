package com.example.testtool.domain.deployable.impl;

import com.example.testtool.domain.deployable.ArtifactId;

public class FileArtifactId implements ArtifactId {

	private String id;

	public FileArtifactId(String id) {
		super();
		this.id = id;
	}

	@Override
	public Object wrappedId() {
		return id;
	}

}
