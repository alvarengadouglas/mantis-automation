<h1 align="center">Automação Web</h1>
<p align="center">
  <a href="https://unform.dev">
    <img src="https://miro.medium.com/v2/resize:fit:880/1*jewS_HV_lCyYL86P3XKicQ.png" alt="Rest-Assured" width="500"/>
  </a>
</p>

<p align="center">Selenium automatiza navegadores. É isso! 🚀</p>

## Tecnologias
<div align="center">

Esse projeto foi construído com as seguintes tecnologias.

[![Java](https://img.shields.io/badge/Java-8.x.x-blue?style=for-the-badge&logo=Java&color=red)](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)<space><space>
[![Cucumber](https://img.shields.io/badge/Cucumber-7.5.0-blue?style=for-the-badge&logo=cucumber&color=greenm)](https://cucumber.io/)<space><space>
[![Cucumber](https://img.shields.io/badge/Selenium-3.12.0-blue?style=for-the-badge&logo=selenium&color=greenm)](https://www.selenium.dev/)<space><space>


</div>

## Sobre o projeto

Esse é um projeto básico de testes de E2E com Selenium e Cucumber integrado a um pipeline de CI do GitHub Actions.
A arquitetura é baseada nos seguintes padrões e boas práticas:

- Page Object Model (POM): A separação dos elementos da página (Element Maps) e das ações da página (Page Classes) melhora a organização e manutenção do código.

- Cucumber com BDD: Os arquivos .feature descrevem cenários de teste em uma linguagem comum, facilitando a compreensão entre stakeholders. As Step Definitions implementam os passos dos cenários, conectando-os com as ações das páginas.

- Configuração Centralizada: Arquivos de configuração (cucumber.properties e tests.properties) centralizam variáveis e configurações, permitindo ajustes fáceis para diferentes ambientes.



Ao rodar o pipeline você terá as seguintes etapas:
- Checkout do código fonte.
- Configuração do ambiente (Java+Chrome).
- Execução dos tests.
- Disponibilização do relatório como artefato no GitHub.


## Stacks documentation:
- [Maven](https://maven.apache.org/ "Maven")
- [JUnit](https://junit.org/junit4/ "JUnit")
- [PageFactory](https://github.com/SeleniumHQ/selenium/wiki/PageFactory "PageFactory")
- [PageObject (pattern)](https://martinfowler.com/bliki/PageObject.html "PageObject")
- [Extent Report](https://extentreports.com/docs/versions/5/java/index.html "ExtentReport") 

## Arquitetura:

```
├── README.md
├── pom.xml
└── src
    └── test
        ├── java
        │   ├── pages
        │   │   ├── CartPage.java
        │   │   ├── CartPageElementMap.java
        │   │   ├── CheckoutPageElementMap.java
        │   │   ├── CheckoutPage.java
        │   │   ├── CommonPage.java
        │   │   ├── CommonPageElementMap.java
        │   │   ├── InventoryPage.java
        │   │   ├── InventoryPageElementMap.java
        │   │   ├── LoginPage.java
        │   │   └── LoginPageElementMap.java
        │   ├── steps
        │   │   ├── CartSteps.java
        │   │   ├── CheckoutSteps.java
        │   │   ├── CommonSteps.java
        │   │   ├── InventorySteps.java
        │   │   └── LoginSteps.java
        │   ├── tests
        │   │   └── RunTest.java
        │   └── util
        │       ├── TestRule.java
        │       └── Utils.java
        └── resources
            ├── features
            │   ├── Checkout.feature
            │   └── Login.feature
            │   
            ├── cucumber.properties
            └── tests.properties
```



### Arquitetura - Interação com elementos da página
Para interagir com elementos da página, conforme o padrão Page Objects, criamos uma classe de Page para cada página ou grupo de páginas do sistema. Abaixo detalhes da implementação e exemplos:
- PageFactory: responsável pela inicialização dos elementos na página
- TestRule: responsável por gerenciar a execução do ciclo de vida do teste.
- Utils: responsável por armazenar funções úteis para criação e execução dos testes.


------------


### Descrição dos Diretórios

#### README.md
Arquivo de documentação do projeto. Aqui você pode incluir informações gerais sobre o projeto, instruções de configuração, execução de testes e qualquer outra orientação útil para desenvolvedores e testers que utilizem o projeto.

#### pom.xml
Arquivo de configuração do Maven. Contém as dependências necessárias para o projeto, como Selenium, Cucumber, e JUnit. Também define configurações específicas para o projeto, como a versão do Java e plugins de construção e testes.

#### src/test
Este diretório contém toda a estrutura de testes, incluindo classes Java, recursos como arquivos .feature do Cucumber e arquivos de configuração.

### Estrutura de Testes (src/test/java)

#### pages
Este pacote contém a implementação do padrão Page Object Model (POM). Cada página da aplicação é representada por duas classes:

- #### Page Classes
    CartPage.java, CheckoutPage.java, InventoryPage.java, LoginPage.java, etc. 
Essas classes contêm os métodos e ações que podem ser executados nas páginas correspondentes, como cliques, preenchimento de formulários e validações.

- #### Element Map Classes
    CartPageElementMap.java, CheckoutPageElementMap.java, CommonPageElementMap.java, etc. Essas classes são utilizadas para definir os localizadores (elementos) das páginas. A separação dos localizadores dos métodos facilita a manutenção, pois mudanças nos elementos da página podem ser feitas apenas nas classes de Element Map.

#### steps
Este pacote contém as classes de Step Definitions do Cucumber:

CartSteps.java, CheckoutSteps.java, InventorySteps.java, LoginSteps.java, CommonSteps.java, etc. Cada uma dessas classes corresponde a uma funcionalidade ou área específica do sistema.
Essas classes implementam os steps(passos) definidos nos arquivos .feature, conectando-os com os métodos das classes de Page Object para realizar as ações nos testes.

#### tests
Este pacote contém o arquivo principal para executar os testes RunTest.java. <br>
Esta é a classe de execução dos testes, normalmente configurada com anotações do Cucumber e do JUnit para definir o runner que encontra os arquivos .feature, executa as Step Definitions e gera relatórios. Ele pode ser configurado para incluir tags específicas ou caminhos para diferentes arquivos de features.

#### util
Este pacote contém classes utilitárias, que auxiliam nos testes fornecendo funções reutilizáveis e regras.

- #### TestRule.java
  - Define regras que devem ser aplicadas em todos os testes, como configurações de ambiente, configurações antes e depois dos testes, e captura de evidências.

- #### Utils.java
  - Contém métodos auxiliares e utilitários para tarefas comuns, como formatação de dados, manipulação de strings, entre outros.

### Estrutura de Recursos (src/test/resources)

#### features
Este diretório armazena os arquivos .feature do Cucumber, que contêm os cenários de teste escritos em Gherkin.

Checkout.feature, Login.feature: Cada arquivo .feature contém cenários específicos para a funcionalidade que representa (checkout, login, etc.). Esses cenários definem os passos em linguagem natural (Gherkin), que são mapeados para as classes de Step Definitions.
cucumber.properties
Arquivo de configuração para o Cucumber, que pode conter configurações de execução, como caminho dos arquivos de features, opções de relatório e outras configurações específicas para o framework.

#### tests.properties
Arquivo de configuração específico para os testes. Esse arquivo pode incluir propriedades de ambiente, URLs, variáveis de autenticação e outras informações que variam conforme o ambiente (produção, teste, homologação).

## Rodando local:
Para rodar local você vai precisar ter configurado:
- Java
- Maven

Rode o seguinte comando no terminal:
`mvn clean test`

Ao rodar será gerado um report HTML no destino target/Reports/nome-da-feature.feature.html, ao abrir esse relatório no navegador sempre utilize o caminho absoluto, pois em alguns casos o server localhost de algumas IDEs/editores de textos pode não funcionar.<br>
Exemplo: <br>

    file:///Users/uauario-do-seu-computador/path-ate-arquivo/Login.feature.html
