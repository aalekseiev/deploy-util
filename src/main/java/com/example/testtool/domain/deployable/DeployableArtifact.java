package com.example.testtool.domain.deployable;

import java.io.InputStream;

public interface DeployableArtifact {

	ArtifactId id();
	
	InputStream stream() throws Exception;
	
}
