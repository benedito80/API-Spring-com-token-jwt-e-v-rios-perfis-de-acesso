# API Spring com token jwt e vários perfis de acesso

Olá, todos bem?

Estou aqui compartilhando mais este pequeno projeto. Onde pude implementa-lo depois de muita pesquisa e estudo pela internet e com pequenos ajustes... consegui de fato chegar a meu objetivo que era proteger minha aplicação utilizando um token jwt e dando a aplicação uma segurança ainda maior. Ou seja, protegendo algumas rotas... onde apenas usuários com um certo perfil poderia utiliza-la.

A API permite o CRUD de usuário para utilização do sistema. Sendo que algumas rotas são bem seguras. Na qual algumas delas tem funcionalidades bem especifica somente para um ou alguns perfis.

Espero ajudar a muitos que sem dúvida alguma buscam o mesmo conhecimento... e de certa forma compartilhar a minha forma de resolver o problema e ter chegado a uma solução. Confesso que não foi nada fácil, pois temos muito material na web, mas demostrando apenas a solução de termos um token ou com as roles. Mas ambos, digo, token e roles juntos não é muito comum encontrarmos.



## Cadastrando um usuário
```
http://localhost:8081/signup

  {
    "username": "maria",
    "password":"123456",
    "roles": "user"
  }
  
* Rota livre para acesso, já que estamos apenas em ambiente de estudo. Em produção de fato não poderia...
```

## Gerando um token:
```
http://localhost:8081/token/generate-token

{
    "username": "val",
    "password": "123456"
}

* Rota livre para usuário poder se autenticar no sistema...
```

## Buscando todos os usuários
```
localhost:8081/users

* Apenas admin ou manager pode realizar essa consulta
* Um token é obrigatório
```

## Buscando um usuário
```
localhost:8081/users/1

* A busca é permitida apenas para id do próprio usuário. Se passar outro id vai receber um "Status: 403 Forbidden"
* Um token desse usuário passado como id é obrigatorio.
```

## Admin pode deletar usuários, desde que não seja o seu ou um usuário  de maior hierarquia(manager)
```
localhost:8081/user/admin/1

* observe na url que o id 1 vai ser deletado, conforme regra autorize...
* Apenas usuário admin pode exclui nessa especifica rota
```

## Manager pode excluir qualquer usuário, inclusive o seu
```
localhost:8081/user/manager/1

* observe na url que o id 1 vai ser deletado.
* Apenas usuário manager pode exclui nessa especifica rota
```

Vamos codar!!!
Abraço!!!


