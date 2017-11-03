
./gradlew build -x test

java -jar ./build/libs/deploy-util-0.0.1-SNAPSHOT.jar \
    --command=deploy \
    --username=tomcat \
    --password=s3cret \
    --serverUrl=http://localhost:8080 \
    --spring.config.location=/home/kseniia/workspace_test/deploy-util/src/test/resources/config.yml \
    --artifact=/home/kseniia/workspace_test/deploy-util/src/test/resources/sample.war

java -jar ./build/libs/deploy-util-0.0.1-SNAPSHOT.jar \
    --command=undeploy \
    --username=tomcat \
    --password=s3cret \
    --serverUrl=http://localhost:8080 \
    --spring.config.location=/home/kseniia/workspace_test/deploy-util/src/test/resources/config.yml \
    --artifact=/home/kseniia/workspace_test/deploy-util/src/test/resources/sample.war