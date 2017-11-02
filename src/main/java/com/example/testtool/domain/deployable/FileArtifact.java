package com.example.testtool.domain.deployable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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
	
}
