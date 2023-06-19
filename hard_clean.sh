#remove all containers
docker ps -a | grep matrix_api | awk '{print $1}' | xargs docker stop
docker ps -a | grep matrix_api | awk '{print $1}' | xargs docker rm

#remove all images
docker images | grep matrix_api | awk '{print $3}' | xargs docker rmi
