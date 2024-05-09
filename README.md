# Microservice_Cadastro

Este é um microservice com dois serviços: user e email. Quando um usuário é criado, um email é enviado para o usuário por meio do serviço de email.

## Tecnologias Utilizadas

- **RabbitMQ:** Usado como message broker para comunicação assíncrona entre os serviços.
- **MailTrap:** Utilizado para gravar os emails enviados para os usuários durante os testes.
- **CloudAMQP:** Usado como message broker para gerenciar as filas e verificar os estados.

## Banco de Dados

- **PostgreSQL:** Utilizado como banco de dados para armazenar os dados do microservice.

## Como Executar

1. Clone este repositório.
2. Certifique-se de ter RabbitMQ, MailTrap e PostgreSQL configurados e em execução.
3. Configure as variáveis de ambiente necessárias.
4. Execute o microservice.

## Contribuição

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões, sinta-se à vontade para abrir uma issue ou enviar um pull request.

