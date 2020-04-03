#!/bin/sh
docker build . -t vibroad-service
echo
echo
echo "To run the docker container execute:"
echo "    $ docker run -p 8080:8080 vibroad-service"
