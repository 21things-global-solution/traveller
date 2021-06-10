# Traveller

Repositório criado para a Global Solution 2021 da FIAP, que integra os entregáveis de **Enterprise Application Development** e **Digital Business Enablement**.

## Cenário

O cenário escolhido para essa entrega foi: **Book de Reserva de Hotéis**.

## Modelo

O MER (Modelo Entidade-Relacionamento) pode ser encontrado [aqui](Relational.png).

## Integrantes

Os integrantes podem ser visualizado [aqui](INTEGRANTES.txt).

## Rodando o projeto

Para executar o projeto:

- Clone este repositório;
- Configure o servidor `JBoss Wildfly 23.x` (para visualizar a versão web);
- Execute `mvn clean package` na raiz do projeto;
- Adicione `traveller.war` (dentro da pasta `target`) no servidor;
- Execute o arquivo `StoreData.java` para popular a base de dados;
- Execute o servidor e vá ao seguinte endereço: `http://127.0.0.1:8080/traveller/login.xhtml`;
- Você já conseguirá ver o projeto rodando :smile:
