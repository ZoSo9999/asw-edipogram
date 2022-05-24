echo "Stopping and removing Docker Containers"
echo "No volumes will be removed! Persistence mantained"
docker compose down
echo "Immagini rimaste:"
docker images