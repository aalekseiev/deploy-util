package com.example.testtool.domain.configuration;

public final class FileConfiguration implements ToolConfiguration {

	private final String filename;

	public FileConfiguration(String filename) {
		super();
		this.filename = filename;
	}

	@Override
	public String toString() {
		return "FileConfiguration [filename=" + filename + "]";
	}

}
