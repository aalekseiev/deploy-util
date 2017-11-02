package com.example.testtool.domain.deployable.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.example.testtool.domain.deployable.ArtifactId;
import com.example.testtool.domain.deployable.DeployableArtifact;

public final class FileArtifact implements DeployableArtifact {

	private final String filename;

	public FileArtifact(String filename) {
		super();
		this.filename = filename;
	}

	@Override
	public InputStream stream() throws FileNotFoundException {
		return new FileInputStream(new File(filename));
	}

	@Override
	public ArtifactId id() {
		return new FileArtifactId(new FileName(filename).baseName());
	}
	
}
