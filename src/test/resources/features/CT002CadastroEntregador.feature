# language: pt

Funcionalidade: EU002 - Cadastro de entregador no sistema
        Como entregador
        Eu quero realizar meu cadastro no app buger-eats
        Para que eu possa receber pedidos de entregas pelo app

  Contexto: Acesso a tela de cadastro do sistema
    Dado que eu acesse a tela de cadastro

  Cenário: CT001 - Cadastro com sucesso
    Quando informo os campos obrigatórios
    E seleciono o metodo de entrega
   	E insiro a foto da cnh
    E seleciono a opção cadastrar
    Então o sistema apresenta mensagem cadastro realizado com sucesso
  
   
  Cenário: CT002: Validar campos obrigatórios
    Quando seleciono a opção cadastrar
    Então o sistem exibe os campos que devem ser preenchidos
  
  Cenário: CT007: Cadastro com cpf invalido
    Quando eu informar um cpf invalido 
    E seleciono a opção cadastrar
    Então o sistema exibe a mensagem "Oops! CPF inválido"
    
    Cenário: CT009: Cadastro informando mais de um método de entrega
    Quando eu informar mais de um método de entrega 
    E seleciono a opção cadastrar
    Então o sistema exibe a mensagem "Oops! Selecione apenas um método de entrega"
  