# Guião

## Passos

1. Criar um composable raiz para cada ecrã: Inicial, Sobre, Jogo.
1. No composable do Ecrã Inicial:
   - Adicionar um título (ex.: "Jogo do Galo").
   - Adicionar uma imagem alusiva ao jogo do galo (use um recurso `drawable`).
   - Adicionar dois botões: "Iniciar Jogo" e "Sobre".
   - Coloque todos os textos usados na UI em recursos de strings.
   - *Sugestão:* use uma `Column` para organizar os elementos verticalmente.
   - Certifique-se que o composable raiz recebe como parâmetros as funções a serem chamadas quando os botões são premidos.
1. Na Activity do Ecrã Inicial, definir o conteúdo com o composable criado, passando as funções que iniciam as Activities Jogo e Sobre a serem chamadas quando os botões são premidos. A navegação para os ecrãs é realizada usando `startActivity`.
1. No composable do Ecrã Sobre:
   - Adicionar uma barra de navegação com um botão de voltar e um título (ex.: "Sobre"). Sugestão: use `Scaffold` com uma `topBar`. 
   - Adicionar texto com informação acerca dos autores (ex.: nome, email, redes sociais, etc.).
   - Certifique-se que o composable raiz recebe como parâmetro a função de clique para o botão de voltar.
1. Na Activity do Ecrã Sobre, definir o conteúdo com o composable criado, passando a função de clique que chama `finish()` para voltar ao ecrã anterior.
1. No composable do Ecrã Jogo:
   - Adicionar um título (ex.: "Jogo do Galo").
   - Adicionar um tabuleiro 3x3 estático (pode usar uma `Column` com três `Rows`, cada uma contendo três células representando as casas do tabuleiro).
   - Acrescente um botão de voltar na barra de navegação.
   - *Sugestão:* use um `Scaffold` com uma `topBar` para o título.
1. Na Activity do Ecrã Jogo, definir o conteúdo com o composable criado, passando a função de clique que chama `finish()` para voltar ao ecrã anterior.

## Dicas
- Mantenha o código organizado, colocando as activities e os composables em ficheiros distintos.
- A inclusão de imagens pode ser feita colocando os ficheiros na pasta `res/drawable` e referenciando-os no código com `R.drawable.nome_da_imagem`. Um catálogo de ícones está disponível em [Material Icons](https://material.io/resources/icons).
- Em alternativa à inclusão manual, os ícones do Material Design podem ser incluídos adicionando a dependência `implementation "androidx.compose.material:material-icons-core:<version>"` no ficheiro `build.gradle` do módulo, ou a dependência `implementation "androidx.compose.material:material-icons-extended:<version>"` para ícones adicionais. O uso é feito com `Icons.Default.<IconName>` ou `Icons.Outlined.<IconName>`, etc., dependendo do estilo pretendido.
