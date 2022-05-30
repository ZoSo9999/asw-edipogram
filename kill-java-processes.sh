#!/bin/bash

echo Halting all running java processes  

#pkill -f 'java'
taskkill /F /IM java
