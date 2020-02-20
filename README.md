# Usuario

## GET /api/usuarios

Exibe Lista com Todos os usuários do sistema.

#### Response 200

```json
[
    {
        "id": 1,
        "nome": "Teste",
        "cpf": "490.234.888-23",
        "email": "testePost@gmail.comX",
        "dataCadastro": "2020-02-18T14:31:36-03:00"
    },
    {
        "id": 2,
        "nome": "Teste 1",
        "cpf": "123.456.789-10",
        "email": "teste@gmail.com",
        "dataCadastro": "2020-02-18T14:32:19-03:00"
    },
    {
        "id": 4,
        "nome": "TesteXYZ",
        "cpf": "490.001.123-23",
        "email": "testePost@gmail.comX",
        "dataCadastro": "2020-02-18T14:48:15-03:00"
    }
]
```

## GET /api/usuario/{id}

Exibe informação de um único usuário. O id do usuário deve ser informado na URL.

#### Response 200

```json
{
    "id": 1,
    "nome": "Teste",
    "cpf": "399.234.848-23",
    "email": "testePost@gmail.comX",
    "dataCadastro": "2020-02-18T14:31:36-03:00"
}
```

#### Response 404 (Usuário não Encontrado)

```json
{
    "timestamp": "2020-02-20T08:25:15.568+0000",
    "status": 404,
    "error": "Not Found",
    "message": "Usuário não encontrado - Verifique o parâmetro Id informado",
    "path": "/api/usuario/156"
}
```

## POST /api/usuario

Cadastra um usuário no sistema.

#### Request Body

```json
{
    "nome": "Teste",
    "cpf": "000.000.321-23",
    "email": "teste@gmail.com",
    "dataCadastro": "2020-02-18T14:31:36-03:00"
}
```

#### Response 201

```json
{
    "id": 16,
    "nome": "Teste",
    "cpf": "000.000.321-23",
    "email": "teste@gmail.com",
    "dataCadastro": "2020-02-18T17:31:36Z"
}
```

## PUT /api/usuario

Atualiza as informações de um usuário. Todas as informações serão atualizadas, exceto o ID e a data de cadastro.

#### Request Body

```json
{
    "id": 1,
    "nome": "Teste",
    "cpf": "000.000.321-23",
    "email": "teste@gmail.com"
}
```

#### Response 200

```json
{
    "id": 1,
    "nome": "Teste",
    "cpf": "000.000.321-23",
    "email": "teste@gmail.com",
    "dataCadastro": "2020-02-18T14:31:36-03:00"
}
```

# Ponto
