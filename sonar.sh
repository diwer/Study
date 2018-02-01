#!/usr/bin/env bash
mvn sonar:sonar \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=c5c31ab76bef2c995ea55793291af55625b619ee
