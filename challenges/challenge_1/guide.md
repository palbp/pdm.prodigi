# Guião

## Passos

1. Criar o projeto com suporte Compose e definir o Ecrã Inicial como LAUNCHER. Se necessário, revisite os vídeos relativos ao [ambiente de trabalho](https://youtu.be/phng-2MpWX0?si=0XeGiBGvjcmrzFDn) e à [anatomia de aplicações Android](https://youtu.be/mnXACtlAuM8?si=NljsMSoSaCnfOFfm).
1. Adicionar as Activities "Sobre" e "Jogo" ao projeto. Use nomes apropriados (AboutActivity, GameActivity). Os nomes dos símbolos usados no código devem ser claros, coerentes e em inglês.
1. Definir o conteúdo de cada Activity (Inicial, Sobre, Jogo) especificando o conteúdo de setContent.
1. Definir o conteúdo da `MainActivity` em Compose, usando o seguinte excerto de código como ponto de partida. Note-se que os botões ainda não promovem a navegação entre ecrãs (TODO):
   ```kotlin
   Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
       Column(
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally,
           modifier = Modifier.fillMaxSize().padding(paddingValues = innerPadding)
       ) {
           Button(onClick = { TODO() }) { Text(text = "Sobre") }
           Button(onClick = { TODO() }) { Text(text = "Jogar") }
       }
   }
   ```
1. Defina o conteúdo dos outros dois ecrãs para que indiquem "Ecrã Sobre" e "Ecrã Jogo", respetivamente. Use um `Scaffold` com um `Text` contendo o texto apropriado, baseando-se no exemplo acima. A ideia é ter nesta fase um placeholder simples para cada ecrã contendo apenas o texto que o identifica.
1. Navegação: ligar os botões do Inicial às Activities Jogo e Sobre (navegação explícita por intents). A navegação faz-se através da chamada a `startActivity` passando o intent. Neste caso, o intent é explícito, ou seja, indica diretamente a Activity destino. A criação do intent explícito faz-se assim:
   ```kotlin
   val intent = Intent(this, AboutActivity::class.java)
   startActivity(intent)
   ```
1. Preparar logging por Activity:
   - Registar os callbacks de ciclo de vida referidos no [vídeo](https://youtu.be/2DGGvxAqNj4?si=e56jqy-4NglYU2X_) em todas as Activities.
   - Garantir que os logs permitem inferir a ordem de eventos durante a navegação e transições entre ecrãs.
   - Utilizar tags de logging distintas para cada Activity (ex.: "MainActivity", "AboutActivity", "GameActivity").
   - Dicas: o nome do tipo da Activity pode ser obtido com `javaClass.simpleName` e o identificador da instância com `hashCode()`.
1. Executar cenários de navegação e observar logs:
   - Inicial → Jogo → Back → Inicial.
   - Inicial → Sobre → Back → Inicial.
   - Repetir "Sobre" várias vezes para confirmar múltiplas instâncias no back stack e o seu fecho correto.
1. Reconfiguração: rodar o dispositivo em Sobre e Jogo e observar recriação (novo identificador) e sequência de callbacks.
1. Anotar conclusões e, se necessário, revisitar o [vídeo relativo ao ciclo de vida da Activity](https://youtu.be/2DGGvxAqNj4?si=e56jqy-4NglYU2X_).

## Logging em Android

Use `Log.v(tag, mensagem)` para registar mensagens:

- `Log` é a classe do Android usada para logging.
- `v` indica o nível de log (verbose), útil para detalhe durante o desenvolvimento.
- `tag` é uma string curta que identifica a origem da mensagem (por exemplo, o nome da Activity).
- `mensagem` é uma string com o texto que descreve o evento a registar.
