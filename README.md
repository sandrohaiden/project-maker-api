project-maker-api

## Instruções

*Obs: Durante o desenvolvimento utilizei o Java 8, MySQL 8 e Intellij IDEA

Tendo o Java 8, o Eclipse IDE 2019‑06, o Maven e o MySQL devidamente instalados, importe este projeto como um projeto maven, baixe as dependências (caso os downloads não iniciem automaticamente, o comando mvn install deverá ser executado atráves de terminal/prompt).
Crie o banco de dados "project_maker" no MySQL e no arquivo src/main/resources/application.properties informe corretamente o usuário, senha, endereço e porta do servidor do banco de dados (Atualmente o usuário e senha são respectivamente root e root, endereço está definido como localhost e a porta definida com a padrão do MySQL ). Execute o projeto a partir da própria IDE Eclipse.

## Rotas Configuradas na API
```js
(get) /api/projetos
(put, delete) /api/projetos/:id
```