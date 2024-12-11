# Seja bem-vindo ao Projeto Leilão!
Este projeto implementa uma API para gerenciamento de leilões, dispositivos, veículos, clientes e instituições financeiras. Utiliza o framework Micronaut para criação de APIs.

## Estrutura do Projeto

### Camadas Principais

> [!NOTE]
> __Controller:__<br>
>Expõe os endpoints para interação com os usuários ou sistemas externos. É responsável por receber as requisições, processar os dados básicos e chamar as camadas de serviço.


> [!NOTE]
> __Service:__<br>
Implementa as regras de negócio e lógica da aplicação. Trata os dados recebidos dos controllers e delega operações de persistência para a camada de repositório.


> [!NOTE]
> __Repository:__<br>
Realiza as operações de persistência no banco de dados. Fornece uma interface para interagir com os dados de maneira eficiente e segura.

> [!NOTE]
> __Enums:__<br>
>Define valores constantes e categóricos usados no sistema, como estados, tipos e categorias, promovendo consistência.

## Configuração do Ambiente Local
```
1. Clonar o Repositório<br>
https://github.com/BozzanoO/LeilaoNadalete.git

2. Executar o Projeto<br>
  Em um terminal execute mvn clean e em seguida mvn mn:run

A API estará disponível em: http://localhost:8080

Para teste, e como recomendação para criação do projeto,
utilize o Swagger em: http://localhost:8080/swagger-ui#/
```
Agradecimentos ao professor Nadadelete, que nos instruiu para a criação do projeto.
