while [ $# -gt 0 ]; do
  case "$1" in
    --config=*)
      config="${1#*=}"
      ;;
    --username=*)
      username="${1#*=}"
      ;;
    --password=*)
      password="${1#*=}"
      ;;
    --serverUrl=*)
      serverUrl="${1#*=}"
      ;;
    --command=*)
      command="${1#*=}"
      ;;
    --artifact=*)
      artifact="${1#*=}"
      ;;
    *)
      printf "*****************************************\n"
      printf "* Error: Invalid argument. ${1}\n"
      printf "*****************************************\n"
      exit 1
  esac
  shift
done


./gradlew build -x test

if [ ! -v command ]; then
  printf "Error: \"command\" parameter is required. Possible values: deploy, undeploy, status, start, stop\n"
  exit 1
fi

if [ -v username ]; then
    USERNAME="--username=${username}"
    echo "$USERNAME"
fi

if [ -v password ]; then
    PASSWORD="--password=${password}"
    echo "$PASSWORD"
fi

if [ -v serverUrl ]; then
    SERVER_URL="--serverUrl=${serverUrl}"
    echo "$SERVER_URL"
fi

if [ -v artifact ]; then
    ARTIFACT="--artifact=${artifact}"
    echo "$ARTIFACT"
fi

if [ -v config ]; then
    CONFIG="--spring.config.location=${config}"
    echo "$CONFIG"
fi

java -jar ./build/libs/deploy-util-0.0.1-SNAPSHOT.jar \
    --command=${command} \
    ${USERNAME} \
    ${PASSWORD} \
    ${SERVER_URL} \
    ${CONFIG} \
    ${ARTIFACT}
