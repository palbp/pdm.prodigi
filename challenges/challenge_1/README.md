# Desafio 1 

### Enunciado

Pretende-se iniciar a construção da aplicação Jogo do Galo, a ser desenvolvida nos desafios de codificação colocados durante o curso.
Neste desafio a aplicação é composta por 3 ecrãs, cada um implementado numa Activity distinta:

- Ecrã Inicial, que contém dois botões: "Iniciar Jogo" e "Sobre";
- Ecrã Sobre, ecrã com informação acerca do(s) autor(es) da aplicação;
- Ecrã de Jogo, ecrã para o jogo.

Nesta fase o enfoque está na criação da base que define a navegação e a observabilidade da aplicação. Em fases posteriores os ecrãs receberão as funcionalidades, aspecto e experiência de utilização pretendidos.

Objetivo pedagógico: observar as consequências da navegação entre activities no seu ciclo de vida através de logging nos callbacks correspondentes.

Guião: [guide.md](guide.md)  
Solução (tag): [challenge_1_solution]https://github.com/palbp/pdm.prodigi/tree/challenge_1_solution/challenges/solution)

### Requisitos

#### Requisitos funcionais dos ecrãs e navegação

- Ecrã Inicial é a _launcher activity_
  - Inicial → Jogo: botão Iniciar Jogo abre o ecrã Jogo.
  - Inicial → Sobre: botão Sobre abre o ecrã Sobre.
- Sobre (Back): Back regressa ao Ecrã Inicial. 
- Jogo (Back): Back do sistema regressa ao Inicial.
- O aspecto de cada ecrã é minimalista, apenas com os elementos necessários para a navegação e texto que identifique o ecrã (ex.: título "Ecrã Inicial", "Ecrã Sobre", "Ecrã Jogo").

#### Requisitos de Observabilidade (logging a incluir)

- Registar os callbacks de ciclo de vida referidos no [vídeo](https://youtu.be/2DGGvxAqNj4?si=e56jqy-4NglYU2X_) em todas as Activities
- Garantir que os logs permitem inferir a ordem de eventos durante a navegação e transições entre ecrãs.
- Utilizar tags de logging distintas para cada Activity (ex.: "MainActivity", "AboutActivity", "GameActivity").

#### Validação (checklist)

- Ecrã Inicial com dois botões (Iniciar Jogo / Sobre).
- Ecrãs Sobre e Jogo como placeholders em Compose.
- Back em Sobre retorna ao Inicial; Back em Jogo retorna ao Inicial.
- Logging completo de callbacks em todas as Activities, com identificador de instância.
- Logs evidenciam a ordem dos callbacks e o comportamento do back stack durante a navegação entre ecrãs.
