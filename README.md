# Calculadora MVC

Este repositório contém o código-fonte de uma calculadora simples desenvolvida como um projeto de aprendizado com foco na implementação da arquitetura de software **MVC (Model-View-Controller)**. A principal intenção deste projeto foi aplicar e consolidar os conceitos dessa arquitetura, garantindo uma separação clara entre lógica de negócio, apresentação e controle.

## Sobre a Calculadora

A calculadora é capaz de realizar operações matemáticas básicas, como:
- Adição (+)
- Subtração (-)
- Multiplicação (*)
- Divisão (/)

Ela também utiliza uma biblioteca externa para avaliar expressões matemáticas, permitindo a entrada de cálculos mais complexos, como "(3 + 5) * 2".

https://github.com/user-attachments/assets/9d8c074b-d174-42f6-9473-1966fdfdae69



## Estrutura do Projeto

O projeto foi desenvolvido utilizando a arquitetura MVC, com os seguintes componentes principais:

### **Model**
- Responsável por lidar com a lógica de negócio e o processamento das expressões matemáticas.
- Classe principal: `Calculadora`
- Exemplo de funcionalidade: avaliação de uma expressão matemática e tratamento de erros como entradas inválidas.

### **View**
- Cuida da interface com o usuário (UI).
- Exibe o resultado das operações e recebe as entradas do usuário.

### **Controller**
- Atua como intermediário entre a `View` e o `Model`.
- Recebe a entrada do usuário da `View`, aciona o `Model` para processar a informação e retorna os resultados para a `View`.
- Classe principal: `MainCalcController`

## Tecnologias e Ferramentas

- **Linguagem**: Kotlin
- **Plataforma**: Android
- **Biblioteca utilizada**: [EvalEx](https://github.com/uklimaschewski/EvalEx) para avaliação de expressões matemáticas.

## Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/RaphaelNNS/CalculadoraMVC.git
   ```

2. Abra o projeto no Android Studio.

3. Conecte um dispositivo Android ou utilize um emulador.

4. Execute o aplicativo clicando em "Run".

## Lições Aprendidas

Durante o desenvolvimento deste projeto, os principais aprendizados foram:
- **Implementação prática da arquitetura MVC**, garantindo separação de responsabilidades e um código mais organizado e fácil de manter.
- Manipulação de eventos na interface gráfica do Android.
- Utilização de bibliotecas externas para resolver problemas específicos (no caso, avaliação de expressões matemáticas).
- Tratamento de erros e melhoria na experiência do usuário.

## Melhorias Futuras

- Adicionar suporte para operações matemáticas mais avançadas (exemplo: potências e raízes).
- Implementar testes unitários para garantir a estabilidade do código.

## Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma _issue_ ou enviar um _pull request_ com sugestões e melhorias.

## Autor

[Raphael Nunes]  
Desenvolvedor e entusiasta de boas práticas de arquitetura de software.

