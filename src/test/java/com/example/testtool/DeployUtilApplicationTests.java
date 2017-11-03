package com.example.testtool;

import org.junit.Test;

public class DeployUtilApplicationTests {
	
	@Test
    public void test() {
        DeployUtilApplication.main(new String[] {
        		"--serverUrl=http://localhost:8080",
        		"--command=deploy",
                "--spring.config.location=/home/kseniia/workspace_test/deploy-util/src/test/resources/config.yml",
                // Override any other environment properties according to your needs
        });
    }

	
	
}
