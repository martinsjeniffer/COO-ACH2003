# COO-ACH2003

Repositório contendo os códigos da disciplina Computação Orientada a Objetos, ministrado pelo professor Flavio Luiz Coutinho, na Escola de Artes, Ciências e Humanidades (EACH) da Universidade de São Paulo.

Essa disciplina contou com dois exercícios programa, um implementando o jogo [Pong!](https://github.com/martinsjeniffer/COO-ACH2003#pong) e outro com um [gerenciador de salas de reunião](https://github.com/martinsjeniffer/COO-ACH2003#gerenciador-de-salas-para-o-marcador-de-reuni%C3%B5es).

## Pong!

![img](https://github.com/martinsjeniffer/COO-ACH2003/blob/master/EP1_2021/printPong.png)

Foram implementadas as seguintes classes:

- [Ball](https://github.com/martinsjeniffer/COO-ACH2003/blob/master/EP1_2021/src/Ball.java)
- [Player](https://github.com/martinsjeniffer/COO-ACH2003/blob/master/EP1_2021/src/Ball.java)
- [Score](https://github.com/martinsjeniffer/COO-ACH2003/blob/master/EP1_2021/src/Score.java)

### Requisitos

- `java -version`:
    ```bash
        openjdk version "11.0.11" 2021-04-20
        OpenJDK Runtime Environment (build 11.0.11+9-post-Debian-1)
        OpenJDK 64-Bit Server VM (build 11.0.11+9-post-Debian-1,mixedmode, sharing)
    ```
- `make --version`: 
    ```bash
        GNU Make 4.3
        Compilado para x86_64-pc-linux-gnu
        Copyright (C) 1988-2020 Free Software Foundation,Inc.
    ```
- `gradle -version`
    ```bash
      ------------------------------------------------------------
      Gradle 4.4.1
      ------------------------------------------------------------
      
      Build time:   2012-12-21 00:00:00 UTC
      Revision: none
      
      Groovy: 2.4.17
      Ant: Apache Ant(TM) version 1.10.7 compiledon October 24 2019
      JVM: 11.0.11 (Debian 11.0.11+9-post-Debian-1)
      OS: Linux 5.10.0-6-amd64 amd64
    ```
    

### Funcionamento

- Para executar usando Makefile:
  ```bash
    make
  ```
  
  
 ## Gerenciador de Salas para o Marcador de Reuniões
 
 [Link do relatório contendo mais detalhes da implementação](https://github.com/martinsjeniffer/COO-ACH2003/blob/master/EP2_2021/relatorio.md).
 
Um dos participantes, responsável pela organização dareunião, indica em qual período ele gostaria de marcar a reunião (por exemplo, entre10 e 20 de abril);
ele determina também a lista de participantes identificados pelosseus endereços eletrônicos.
A seguir, cada um dos participantes indica os horáriosde disponibilidade dentro do período determinado pelo organizador.
O organizadorentão visualiza a sobreposição dos horários de todos os participantes e escolhe umhorário para a reun
 
 ### Requisitos
 
 - `java -version`:
    ```bash
        openjdk version "11.0.11" 2021-04-20
        OpenJDK Runtime Environment (build 11.0.11+9-post-Debian-1)
        OpenJDK 64-Bit Server VM (build 11.0.11+9-post-Debian-1,mixedmode, sharing)
    ```
    
 ### Funcionamento 
 
- Para compilar:
    ```bash
        make
    ```

- Para executar:
    ```bash
        java <arquivo_main_contendo_implementacao>
    ```
  
 ### Diagrama UML
 ![img](https://github.com/martinsjeniffer/COO-ACH2003/blob/master/EP2_2021/diagrama_UML.png)
