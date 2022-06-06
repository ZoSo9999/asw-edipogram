echo "Rimozione delle immagini Docker"
docker compose down -v && docker compose rm && docker image rm $(docker image ls | grep 'edipogram' | awk '{print $3}')
docker volume rm enigmi
docker volume rm connessioni
docker volume rm enigmi-seguiti
echo "Immagini rimosse con successo"
echo "Immagini rimaste:"
docker images
