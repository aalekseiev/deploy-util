package com.example.testtool.domain.deployable;

import java.io.InputStream;

public interface DeployableArtifact {

	InputStream stream() throws Exception;
	
}
