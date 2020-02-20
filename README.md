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

## POST /api/ponto/entrada

Insere um registro de ponto de entrada para determinado usuário.

#### Request Body

```json
{
    "usuario": {
		"id": 1
	}
}
```

#### Response 200

```json
{
    "id": 18,
    "dataPonto": "2020-02-20T05:36:16.832-03:00",
    "tipoPonto": "entrada",
    "usuario": {
        "id": 4,
        "nome": "TesteXYZ",
        "cpf": "399.234.848-23",
        "email": "testePost@gmail.comX",
        "dataCadastro": "2020-02-18T14:48:15-03:00"
    }
}
```

## POST /api/ponto/saida

Insere um registro de ponto de saída para determinado usuário.

#### Request Body

```json
{
    "usuario": {
		"id": 1
	}
}
```

#### Response 200

```json
{
    "id": 19,
    "dataPonto": "2020-02-20T05:36:55.382-03:00",
    "tipoPonto": "saida",
    "usuario": {
        "id": 4,
        "nome": "TesteXYZ",
        "cpf": "399.234.848-23",
        "email": "testePost@gmail.comX",
        "dataCadastro": "2020-02-18T14:48:15-03:00"
    }
}
```

## GET /api/ponto/listagem/{idUsuario}

Lista todos os registros de ponto de um determinado usuário (Mostra todas as entradas e saídas) e exibe a quantidade total de horas trabalhadas.

#### Response 200

```json
{
    "listagemPontos": [
        {
            "id": 19,
            "dataPonto": "2020-02-20T05:36:55-03:00",
            "tipoPonto": "saida",
            "usuario": {
                "id": 4,
                "nome": "TesteXYZ",
                "cpf": "123.334.848-23",
                "email": "testePost@gmail.comX",
                "dataCadastro": "2020-02-18T14:48:15-03:00"
            }
        },
        {
            "id": 18,
            "dataPonto": "2020-02-20T05:36:17-03:00",
            "tipoPonto": "entrada",
            "usuario": {
                "id": 4,
                "nome": "TesteXYZ",
                "cpf": "123.999.848-23",
                "email": "testePost@gmail.comX",
                "dataCadastro": "2020-02-18T14:48:15-03:00"
            }
        },
        {
            "id": 17,
            "dataPonto": "2020-02-20T01:00:00-03:00",
            "tipoPonto": "saida",
            "usuario": {
                "id": 4,
                "nome": "TesteXYZ",
                "cpf": "999.999.848-23",
                "email": "testePost@gmail.comX",
                "dataCadastro": "2020-02-18T14:48:15-03:00"
            }
        },
        {
            "id": 15,
            "dataPonto": "2020-02-20T00:55:00-03:00",
            "tipoPonto": "entrada",
            "usuario": {
                "id": 4,
                "nome": "TesteXYZ",
                "cpf": "999.999.848-23",
                "email": "testePost@gmail.comX",
                "dataCadastro": "2020-02-18T14:48:15-03:00"
            }
        },
        {
            "id": 14,
            "dataPonto": "2020-02-20T00:45:00-03:00",
            "tipoPonto": "saida",
            "usuario": {
                "id": 4,
                "nome": "TesteXYZ",
                "cpf": "999.234.848-23",
                "email": "testePost@gmail.comX",
                "dataCadastro": "2020-02-18T14:48:15-03:00"
            }
        },
        {
            "id": 13,
            "dataPonto": "2020-02-20T00:40:00-03:00",
            "tipoPonto": "entrada",
            "usuario": {
                "id": 4,
                "nome": "TesteXYZ",
                "cpf": "999.999.999-23",
                "email": "testePost@gmail.comX",
                "dataCadastro": "2020-02-18T14:48:15-03:00"
            }
        }
    ],
    "totalHorasTrabalhadas": 0
}
```
