# Guião

## Passos

1. Consolidar ecrãs e navegação interna
   - Garantir a existência de um composable raiz por ecrã (Inicial, Sobre, Jogo) e manter a navegação entre Activities já implementada nos desafios anteriores;
2.	Modelo de domínio (primeira versão)
	- Definir as estruturas de dados necessárias à representação do jogo: tabuleiro 3×3, jogador atual e estado da partida 
   (em curso / vitória / empate);
   - As estruturas de dados são imutáveis (não é permitido o uso de var nas definições dos dados do jogo);
3. Apresentação do estado do jogo no ecrã Jogo
   - Definir o contrato de dados e eventos do ecrã Jogo, ou seja, os parâmetros do composable raiz do ecrã Jogo;
   - Implementar a visualização do tabuleiro 3×3 e da informação do jogo (vez do jogador, vitória, empate) conforme o recebido como parâmetro no composable raiz do ecrã Jogo;
   	- Apresentar o tabuleiro 3×3 (células quadradas; símbolo visível conforme o conteúdo)
	   - Exibir informação de estado: “Vez de: X/O”, “Vitória de X/O”, “Empate”
      - Desativar interação quando a partida terminar (vitória/empate)
      - Incluir ação Reiniciar (limpa o tabuleiro e repõe o jogador inicial)
      - Garantir que a UI gera eventos de click nas células do tabuleiro e no botão Reiniciar, propagando-os através dos callbacks definidos no contrato (i.e. parâmetros do composable raiz). As céluldas que não estão livres NÃO devem responder a cliques; (note que a lógica do jogo não é ainda implementada nesta fase)
   - Sugestões: Defina um composable para o tabuleiro (Board) e outro para as células (Cell); 
      - O composable Board recebe o estado do tabuleiro e um callback onCellTapped(position) para toque numa célula;
      - O composable Cell recebe o conteúdo (vazio/X/O) e um callback onClick().
4. Modelo de domínio (implementação das regras do jogo)
   - Implementar as operações do jogo: realizar jogada, avaliar vitória/empate, reiniciar jogo;
5.	Contrato de dados e eventos do Ecrã Jogo (state hoisting)
   - Cmposable raiz do ecrã Jogo é stateless: recebe dados imutáveis com o estado do jogo (tabuleiro, jogador atual) e expõe os eventos:
      - onCellTapped(position) para toque numa célula;
      - onReset() para reiniciar a partida.
   - Os composables filhos (ex.: Board, Cell) são também stateless: recebem dados, emitem eventos.
6.	Integração do modelo de domínio com a UI do ecrã Jogo
	- Manter o estado do jogo na Activity do ecrã Jogo (sem ViewModel e sem preservação em mudanças de configuração nesta fase);
   - Dica: Dentro da lambda passada a `setContent`, definir uma variável de estado (usando `remember` e `mutableStateOf`) para o estado do jogo, iniciando-a com o estado inicial. Passar o estado atual ao composable raiz do ecrã Jogo e implementar os callbacks para atualizar o estado conforme as jogadas realizadas;
7. Nesta fase o ecrã de jogo já deve estar funcional, permitindo jogar uma partida completa de Jogo do Galo;
8. Ações externas no Ecrã Sobre (intents implícitos)
   - Adicionar ação “Contactar por e-mail” que abre uma app de e-mail através de intent implícito (rascunho com destinatário/assunto/corpo);
   - Adicionar ação “Visitar página” que abre um URL no navegador através de intent implícito;
   - Prever fallback: se não existir nenhuma aplicação apta para realizar a acção pedida, apresentar mensagem informativa e registar em log;
   - Sugestão: usar `Intent.ACTION_SENDTO` para o e-mail e `Intent.ACTION_VIEW` para o URL; verificar se existe aplicação apta com `resolveActivity` antes de chamar `startActivity`.
9. Cuidados adicionais
   - Colocar textos em recursos de string
   - Fornecer contentDescription adequado em imagens/ícones/células
   - Garantir feedback visual para cliques
   - Observabilidade: Registar em log os eventos relevantes (ex.: início/fim de jogo, vitória/empate, ações no ecrã Sobre, falhas de intent).


## Dicas
- Mantenha o código organizado, colocando as activities e os composables em ficheiros distintos.
- Teste frequentemente, validando cada funcionalidade implementada. Idealmente isto é feito usando testes automáticos, mas testes manuais são aceitáveis nesta fase. Caso opte por testes manuais, documente os passos para reproduzir os testes.

