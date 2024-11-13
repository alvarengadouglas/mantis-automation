#language: pt
#encoding: utf-8
@smoke
Funcionalidade: Checkout

  Contexto:
    Dado que acesso o ecommerce logado

  Cenario: Comprar produtos
    Quando adiciono "2" produtos ao carrinho
    E verifico os itens adicionados
    E concluo a etapa de checkout
    Entao a compra deve ser realizada com sucesso
