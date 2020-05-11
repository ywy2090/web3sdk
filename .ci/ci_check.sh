#!/bin/bash

set -e

curl -LO https://raw.githubusercontent.com/FISCO-BCOS/FISCO-BCOS/release-2.5.0/tools/build_chain.sh && chmod u+x build_chain.sh
curl -s https://raw.githubusercontent.com/FISCO-BCOS/FISCO-BCOS/release-2.5.0/tools/ci/download_bin.sh | bash -s -- -m -b release-2.5.0
echo "127.0.0.1:4 agency1 1,2,3" > ipconf

# bash build_chain.sh -h

# Non SM node test
bash build_chain.sh -e bin/fisco-bcos -f ipconf -p 30300,20200,8545
bash nodes/127.0.0.1/start_all.sh
./nodes/127.0.0.1/fisco-bcos -v

mkdir -p src/integration-test/resources/
cp nodes/127.0.0.1/sdk/* src/integration-test/resources/
cp src/test/resources/applicationContext-sample.xml src/integration-test/resources/applicationContext.xml
cp src/test/resources/log4j.properties src/integration-test/resources/
bash gradlew verifyGoogleJavaFormat
bash gradlew build
bash gradlew test
bash gradlew integrationTest