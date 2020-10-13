#!/usr/bin/env sh
java -jar -Duser.timezone=GMT+08 /app.jar > /err/apperr.log 2>&1&
tail -f /dev/null