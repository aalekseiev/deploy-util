package com.example.testtool;

import org.junit.Test;

public class DeployUtilApplicationTests {
	
	@Test
    public void testDeploy() {
        DeployUtilApplication.main(new String[] {
        		"--serverUrl=http://localhost:8080",
        		"--command=deploy",
                "--spring.config.location=/home/kseniia/workspace_test/deploy-util/src/test/resources/config.yml",
        });
    }
	
	@Test
    public void testFullCycle() {
        DeployUtilApplication.main(new String[] {
        		"--serverUrl=http://localhost:8080",
        		"--command=deploy",
                "--spring.config.location=/home/kseniia/workspace_test/deploy-util/src/test/resources/config.yml",
        });
        
        DeployUtilApplication.main(new String[] {
        		"--serverUrl=http://localhost:8080",
        		"--command=stop",
                "--spring.config.location=/home/kseniia/workspace_test/deploy-util/src/test/resources/config.yml",
        });
        
        DeployUtilApplication.main(new String[] {
        		"--serverUrl=http://localhost:8080",
        		"--command=status",
                "--spring.config.location=/home/kseniia/workspace_test/deploy-util/src/test/resources/config.yml",
        });
        
        DeployUtilApplication.main(new String[] {
        		"--serverUrl=http://localhost:8080",
        		"--command=start",
                "--spring.config.location=/home/kseniia/workspace_test/deploy-util/src/test/resources/config.yml",
        });
        
        DeployUtilApplication.main(new String[] {
        		"--serverUrl=http://localhost:8080",
        		"--command=status",
                "--spring.config.location=/home/kseniia/workspace_test/deploy-util/src/test/resources/config.yml",
        });
        
        DeployUtilApplication.main(new String[] {
        		"--serverUrl=http://localhost:8080",
        		"--command=undeploy",
                "--spring.config.location=/home/kseniia/workspace_test/deploy-util/src/test/resources/config.yml",
        });
    }

	
	
}
