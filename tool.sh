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
      printf "***************************\n"
      printf "* Error: Invalid argument.*\n"
      printf "***************************\n"
      exit 1
  esac
  shift
done


./gradlew build -x test

if [ -v username ]; then
    USERNAME="--username=${username}"
fi

echo "$USERNAME"

if [ -v password ]; then
    PASSWORD="--password=${password}"
fi

echo "$PASSWORD"

if [ -v serverUrl ]; then
    SERVER_URL="--serverUrl=${serverUrl}"
fi

echo "$SERVER_URL"

if [ -v artifact ]; then
    ARTIFACT="--artifact=${artifact}"
fi

echo "$ARTIFACT"

if [ -v config ]; then
    CONFIG="--spring.config.location=${config}"
fi

echo "$CONFIG"

java -jar ./build/libs/deploy-util-0.0.1-SNAPSHOT.jar \
    --command=${command} \
    ${USERNAME} \
    ${PASSWORD} \
    ${SERVER_URL} \
    ${CONFIG} \
    ${ARTIFACT}
