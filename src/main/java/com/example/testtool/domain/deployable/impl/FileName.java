package com.example.testtool.domain.deployable.impl;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

public final class FileName {

	private String filename;

	public FileName(String filename) {
		super();
		this.filename = filename;
	}
	
	public FileName(File file) {
		super();
		this.filename = file.getName();
	}
	
	public String baseName() {
		return FilenameUtils.getBaseName(filename);
	}
	
	public String filename() {
		return filename;
	}

}
