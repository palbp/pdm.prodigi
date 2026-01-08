# Desafio 3 

### Enunciado

Pretende-se continuar a construção da aplicação Jogo do Galo, evoluindo para uma versão quase completa.
Nesta fase é implementada a lógica do jogo e realizada a gestão de estado necessária à experiência pretendida (minimalista), sem uso de ViewModel e sem preservação de estado perante mudanças de configuração (p. ex., rotação).

O enfoque está na materialização do domínio na UI com Jetpack Compose e no uso de intents implícitos (e-mail/URL) no ecrã Sobre.

Objetivo pedagógico: familiarização com a construção de UIs reativas e gestão de estado local em Compose (sem ViewModel), articulando domínio simples e integração com intents implícitos.

Guião: [guide.md](guide.md)
Solução (tag): [challenge_3_solution](https://github.com/palbp/pdm.prodigi/tree/challenge_3_solution/challenges/solution)

Acerca da solução apresentada, ela inclui:
- Testes automáticos para a lógica do jogo (modelo de domínio);
- Testes automáticos para a UI do ecrã Jogo;


#### Requisitos (o que deve ficar a funcionar):
- Ecrã Jogo 
  - Tabuleiro 3×3 interativo: tocar numa célula vazia marca “X” ou “O” consoante o jogador atual;
	- Alternância de jogador após jogada válida;
	- Deteção de vitória ou de empate;
  - Bloqueio de novas jogadas após o jogo terminar (o tabuleiro é desabilitado);
  - Reiniciar a partida (limpa tabuleiro e reabilita-o, repondo a vez no jogador inicial); 
	- Estado local hospedado na Activity do ecrã Jogo (sem preservação em rotação nesta fase);
	- Use mensagens simples na UI, por exemplo, “Vez de: X/O”, “Vitória de X/O”, “Empate”.

- Ecrã Sobre
	- Ação “Contactar por e-mail” que com intent implícito abre app de e-mail (rascunho com destinatário/assunto/corpo);
	- Ação “Visitar página pessoal” que com intent implícito abre o URL da página pessoal (ou perfil de rede social) no browser;
  - Fallback: se não existir nenhuma aplicação apta para realizar as acções pretendidas, apresentar mensagem informativa (e registar em log).

- Arquitetura da UI
	- Composables filhos stateless: recebem dados e emitem eventos; decisões tratadas no composable raiz/Activity (state hoisting).

- Modelo de domínio
  - A lógica do jogo deve estar separada da UI;
  - A representação do estado do jogo deve ser imutável;
  - Operacões sobre o estado do jogo devem produzir novas instâncias (sem mutações);
  - A lógica do jogo deve ser testável, independentemente da UI.


#### Validação (checklist)
- Tabuleiro 3×3 marca “X”/“O” apenas em células vazias;
- Alternância correta do jogador após jogada válida;
- Vitória e empate detetados corretamente;
- Bloqueio de jogadas após fim de jogo + ação Reiniciar funcional;
- Estado não é preservado na rotação do ecrã; 
- “Contactar por e-mail” e “Visitar página” via intents implícitos com fallback informativo;
