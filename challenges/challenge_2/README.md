# Desafio 2 

### Enunciado

Pretende-se continuar a construção da aplicação Jogo do Galo, a ser desenvolvida nos desafios de codificação colocados durante o curso.
Neste desafio vamos implementar estrutura visual dos ecrãs. Lembra-se que a aplicação contém três ecrãs:

- Ecrã Inicial, que contém uma imagem alusiva ao jogo do galo e dois botões: "Iniciar Jogo" e "Sobre";
- Ecrã Sobre, ecrã com informação acerca do(s) autor(es) da aplicação; já não será apenas um placeholder;
- Ecrã de Jogo, ecrã para o jogo do galo, um tabuleiro 3x3 onde serão realizadas as jogadas; também já não será apenas um placeholder.

Nesta fase o enfoque está na definição da estrutura e do aspecto geral da UI. Está para já fora de âmbito implementar as interacções com a UI ou a lógica do jogo.

Objetivo pedagógico: familizarização com a construção de UIs usando Jetpack Compose. 

Guião: [guide.md](guide.md)  
Solução (tag): [challenge_2_solution](https://github.com/palbp/pdm.prodigi/tree/challenge_2_solution/challenges/solution)

Notas acerca da solução apresentada: 
- A solução apresentada inclui alguns elementos adicionais, nomeadamente:
  - Para que o aspecto geral da UI seja mais apelativo, foram feitas alterações ao tema por omissão, nomeadamente cores e tipo de letra.
  - Estão presentes testes automáticos elementares para os composables criados.
  - O ícone da aplicação foi alterado para um ícone alusivo ao jogo do galo.
  - São usados os ícones do Material Design para os botões de navegação. Veja o guião para mais detalhes acerca da inclusão de imagens e ícones.

#### Validação (checklist)

- Três composables raiz, um por ecrã, com a estrutura pretendida.
- Ecrã Inicial com título, imagem e dois botões visíveis.
- Ecrã Sobre com informação acerca dos autores (ex. nome, email, redes sociais, etc.) e barra de navegação com botão de voltar.
- Ecrã Jogo com tabuleiro 3×3 estático.
- Navegação entre ecrãs funcional e de acordo com o desafio anterior.