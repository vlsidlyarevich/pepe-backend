# Pepe chat backend
[![Build Status](https://travis-ci.com/vlsidlyarevich/pepe-backend.svg?branch=main)](https://travis-ci.com/vlsidlyarevich/pepe-backend)
![GitHub](https://img.shields.io/github/license/vlsidlyarevich/pepe-backend)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=vlsidlyarevich_pepe-backend&metric=alert_status)](https://sonarcloud.io/dashboard?id=vlsidlyarevich_pepe-backend)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=vlsidlyarevich_pepe-backend&metric=coverage)](https://sonarcloud.io/dashboard?id=vlsidlyarevich_pepe-backend)

Backend part of simple chat application for training purposes. 

<!-- PREREQUISITES -->


<!-- HOW TO RUN -->
## How to run
### Aerospike
To run aerospike cluster you need to init docker swarm mode:
```console
docker swarm init
```
And then:
```console
cd ./env/docker && docker stack deploy -c docker-compose.yml pepe
```


<!-- LICENSE -->
## License

Distributed under the MIT License. See `LICENSE` for more information.


<!-- CONTACT -->
## Contact

Sidlyarevich Vladislav - vlsidlyarevich@example.com

Project Link: [https://github.com/vlsidlyarevich/pepe-backend](https://github.com/vlsidlyarevich/pepe-backend)