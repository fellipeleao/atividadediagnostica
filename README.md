# Usuario

## GET /api/usuarios

Exibe Lista com Todos os usuários do sistema.

#### Response 200

```json
[
    {
        "id": 1,
        "nome": "Teste",
        "cpf": "399.234.848-23",
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
        "cpf": "399.234.848-23",
        "email": "testePost@gmail.comX",
        "dataCadastro": "2020-02-18T14:48:15-03:00"
    }
]
```

## GET /api/usuario/{id}

Exibe informação de um único usuário. O id do usuário deve ser informado na URL.

### Response 200

## POST /api/usuario

Cadastra um usuário no sistema.

### Response 201

## PUT /api/usuario

Atualiza um usuário.

### Response 200

#Ponto

