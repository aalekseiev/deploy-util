package com.example.testtool.domain.server.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.testtool.domain.deployable.ArtifactId;

public final class TomcatResponseParser {

	private final String appsListResponse;

	public TomcatResponseParser(String appsListResponse) {
		super();
		this.appsListResponse = appsListResponse;
	}

	public String applicationLine(ArtifactId artifactId) {
		String[] strings = appsListResponse.split("\n");
		List<String> list = Arrays.asList(strings).stream()
				.filter(s -> s.contains(String.valueOf(artifactId.wrappedId()))).collect(Collectors.toList());
		if (list.size() > 0) {
			return list.get(0);
		} else {
			return "APPLICATION_NOT_AVAILABLE";
		}
	}

}
