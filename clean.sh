#remove all containers
docker ps -a | grep matrix_api_container | awk '{print $1}' | xargs docker stop
docker ps -a | grep matrix_api_container | awk '{print $1}' | xargs docker rm
docker images | grep matrix_api_container | awk '{print $3}' | xargs docker rmi
