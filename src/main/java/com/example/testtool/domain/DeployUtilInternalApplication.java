package com.example.testtool.domain;

import com.example.testtool.domain.server.ContainerServer;

public interface DeployUtilInternalApplication {

	void deploy(ContainerServer server) throws Exception;

	void undeploy(ContainerServer server) throws Exception;

	String status(ContainerServer server) throws Exception;

	void start(ContainerServer server) throws Exception;

	void stop(ContainerServer server) throws Exception;

	Object name();

}