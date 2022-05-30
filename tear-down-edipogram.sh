echo "Removing docker images"
docker compose down -v && docker compose rm && docker image rm $(docker image ls | grep 'edipogram' | awk '{print $3}')
docker volume rm enigmi
docker volume rm connessioni
docker volume rm enigmi-seguiti
echo "Images removed succesfully"
echo "What's stil up:"
docker images
