# Descrição
Aplicação Fullstack (back e frontend) para geração e consumo de mensagens via Websocket .

## Frontend
Aplicação ReactJs.

### Dependências

* Verificar o package.json

### Instalação

* A comunicação entre o front e o backend é configurada via variáveis de ambiente (.env na raíz do projeto front)

```bash
npx npm install 
npx npm run dev
```

## Backend
Aplicação Spring Boot.

### Dependências

* Verificar o pom.xml

### Instalação

* A aplicação está configurada para rodar na porta default (8080)
* Foi configurado um scheduler para gerar mensagens de 10 em 10 segundos


## Funcionalidades implementadas

* Geração de mensagens, via Websocket, de forma agendada pelo backend
* Consumo e exibição, concatenada, de mensagens recuperadas do backend, via Websocket, pelo frontend

## Sobre

- Author - [Alexandre Paixão]

## Licença

GNU GPL