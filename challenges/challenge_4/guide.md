# Guião

## Passos

1. Preparação
   - Garantir a existência de um composable raiz por ecrã (Inicial, Sobre, Jogo) e manter a navegação entre Activities já implementada nos desafios anteriores;
   - Garantir que no modelo de domínio existe um tipo de dados que representa o estado do jogo (tabuleiro, jogador atual, estado da partida);
   - Garantir que o modelo de domínio é imutável e que as operações sobre o estado do jogo produzem novas instâncias (sem mutações);
2. Introduzir o ViewModel do ecrã de Jogo
   - Criar a classe `GameViewModel` herdando de `ViewModel`;
   - Definir no ViewModel a propriedade `gameState` do `MutableState` para o estado do jogo, inicializada com o estado inicial do jogo;
3. Adaptar a Activity do ecrã Jogo para usar o ViewModel
   - Obter uma instância do ViewModel na Activity usando `viewModels<GameViewModel>()`;
   - Dentro da lambda passada a `setContent`, observar o estado do jogo a partir do ViewModel (usando `viewModel.gameState`) e passá-lo ao composable raiz do ecrã Jogo;
   - Implementar os callbacks do composable raiz para invocar as operações do ViewModel (realizar jogada, reiniciar jogo);
4. Verificar o funcionamento:
   - Executar a aplicação e jogar uma partida de Jogo do Galo;
   - Rodar o dispositivo (mudar orientação) e verificar que o estado do jogo é preservado.

## Dicas
- Para escolher o composable em função da orientação, pode usar `LocalConfiguration.current.orientation` dentro do composable raiz do ecrã Jogo.

