package com.example.testtool.domain.deployable.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.example.testtool.domain.deployable.DeployableArtifact;

public class ExistingFileArtifact implements DeployableArtifact {

	private final File file;

	public ExistingFileArtifact(File file) {
		super();
		this.file = file;
	}

	@Override
	public InputStream stream() throws Exception {
		return new FileInputStream(file);
	}
	
}
