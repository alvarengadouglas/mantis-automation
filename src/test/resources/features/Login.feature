#language: pt
#encoding: utf-8
@smoke
Funcionalidade: Login

  Cenario: Login com sucesso
    Dado que acesso a tela de login
    Quando realizo o login
    Entao sou direcionado para a tela de produtos
    E vou para o carrinho