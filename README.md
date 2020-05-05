> Desafio Final da Aceleração Java Online da Codenation

# Central de Erros - Back-end (API)

Desenvolvimento de uma API REST para centralização de registros de logs de aplicações.

*Aplicação desenvolvida seguindo as diretrizes propostas no projeto prático da Aceleração*

## Tecnologia

- [Java](https://www.oracle.com/technetwork/java/javase/downloads/index.html) ```1.8```
- [Spring Boot](https://spring.io/projects/spring-boot) ```2.2.6.RELEASE```
- [Maven](https://maven.apache.org/) ```3.5.1```

## Instalação

A aplicação foi configurada pra ser executada com o Maven, portanto será necessário a instalação dessa ferramenta. 

> Instalando o Maven: [https://maven.apache.org/install.html](https://maven.apache.org/install.html).

### Clonando o repositório:

```bash
$ git clone https://github.com/gustavoaos/codenation.git
```

### Compilando e empacotando a aplicação

```bash
$ cd log-viewer
$ mvn compile
$ mvn package
```

### Executando a aplicação

```bash
$ cd log-viewer
$ mvn spring-boot:run
```

> A aplicação estará disponível em ```http://localhost:8080/```.

## Endpoints

Após executar a aplicação, você pode acessar a documentação da API, contendo os endpoints implementados, no endereço ```http://localhost:8080/swagger-ui.html```.

