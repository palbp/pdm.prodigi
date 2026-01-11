# Desafio 4 

### Enunciado

Pretende-se continuar a construção da aplicação Jogo do Galo, desta feita adoptando a arquitetura MVVM (Model-View-ViewModel). O benefício imediato desta transformação é passaremos a ter estado preservado perante mudanças de configuração (p. ex., rotação do ecrã),simplesmente porque o ViewModel sobrevive a essas mudanças.

O enfoque está na criação de um ViewModel para o ecrã Jogo, que será responsável por manter o estado do jogo (tabuleiro, jogador atual, estado da partida) e expor operações para interagir com esse estado (realizar jogada, reiniciar jogo). A UI do ecrã Jogo será alterada para ser completamente stateless, recebendo o estado do jogo e expondo eventos através de callbacks.

Objetivo pedagógico: familiarização com a arquitectura padrão de aplicaçãoes Android com Jetpack Compose, nomeadamente o padrão MVVM e state hoisting. 

Guião: [guide.md](guide.md)  
Solução (tag): [challenge_4_solution](https://github.com/palbp/pdm.prodigi/tree/challenge_4_solution/challenges/solution)

Acerca da solução apresentada, ela inclui:
- Layouts alternativos para o ecrã Jogo para as duas orientações do dispositivo, portrait (orientação vertical) e landscape (orientação horizontal)

#### Requisitos (o que deve ficar a funcionar):
- Ecrã Jogo 
  - O estado atual do jogo é preservado quando existe mudança de configuração (ex.: rotação do ecrã);

- Arquitetura da solução
	- A solução inclui um ViewModel para o ecrã de jogo;
  - Nesse ecrã, os composables são stateless: recebem dados e emitem eventos; decisões tratadas no âmbito do ViewModel, que encaminha as acções realzadas na UI para os elementos de domínio;

- Modelo de domínio permanece inalterado face ao desafio anterior:
  - A lógica do jogo deve estar separada da UI;
  - A representação do estado do jogo deve ser imutável;
  - Operacões sobre o estado do jogo devem produzir novas instâncias (sem mutações);
  - A lógica do jogo deve ser testável, independentemente da UI.


#### Validação (checklist)
- Estado é preservado na rotação do ecrã; 
- ViewModel implementado para o ecrã Jogo;
- Composables do ecrã Jogo são stateless;
- Lógica do jogo permanece separada da UI,