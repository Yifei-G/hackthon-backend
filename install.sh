bash releaseGradleLock.sh
docker-compose up --build -d
docker logs matrix_api_container -f