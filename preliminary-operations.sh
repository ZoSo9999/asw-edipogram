echo "Creazione delle immagini docker:"
docker compose -f docker-compose.yml build
echo "Immagini docker create."
echo "Creazione dei volumi"
docker volume create --name=enigmi
docker volume create --name=connessioni
docker volume create --name=enigmi-seguiti
echo "Volumi creati"
