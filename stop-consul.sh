#!/bin/bash

echo "Stop Consul"  

docker stop asw-consul 
docker rm asw-consul 
