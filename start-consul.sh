#!/bin/bash

echo "Avvio Consul" 

docker run -d --hostname localhost --name asw-consul --publish 8500:8500 consul
