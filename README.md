# deploy-util
Test task for artifacts deployment to servlet container

<h1>Prerequisites</h1>
In order to run this software you have JDK 1.8 to be installed.

To build the project from sources please run:
<pre>
./gradlew build -x test
</pre>

To run 
<pre>
java -jar ./deploy-util-0.0.1-SNAPSHOT.jar \
    --username tomcat \
    --password s3cret \
    --config /home/user/config.yml \
    --artifact /home/user/sample.war
</pre>

java -jar ./deploy-util-0.0.1-SNAPSHOT.jar --spring.config.location=/home/kseniia/workspace_test/deploy-util/src/test/resources/config.yml
