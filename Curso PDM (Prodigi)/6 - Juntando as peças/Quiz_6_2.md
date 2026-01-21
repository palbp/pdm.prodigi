# Perguntas 6.2

1. A seguinte afirmação é verdadeira ou falsa?
No exemplo apresentado, a resolução de dependências é feita segundo o padrão Service Locator, usando a classe JokeOfDayApplication (subclasse de Application) como peça globalmente acessível.

2. Acerca das dependências entre as peças do exemplo, indique quais as afirmações que são verdadeiras (pode selecionar mais do que uma):
    - A MainActivity depende do Composable JokeOfDayScreen.
    - A MainActivity depende da abstração JokeService.
    - A MainActivity depende do view model JokeOfDayScreenViewModel.
    - O Composable JokeOfDayScreen depende do view model JokeOfDayScreenViewModel.
    - O Composable JokeOfDayScreen depende da abstração JokeService.
    - O view model JokeOfDayScreenViewModel depende da abstração JokeService.

3. No exemplo, onde é implementada a máquina de estados do ecrã?
    - Nos composables individuais (IdleView, LoadingView, etc.).
    - Na MainActivity.
    - No ViewModel do ecrã.
    - No serviço JokeService.

4. Acerca da utilização da função lazy nas dependências produzidas pela instância de JokeOfDayApplication, indique quais as afirmações que são verdadeiras (pode selecionar mais do que uma):
    - O primeiro acesso à propriedade jokeService (p.ex., ao criar o ViewModel) desencadeia a criação da instância concreta do serviço.
    - Cada acesso a jokeService cria uma nova instância de IcanhazDadJokes.
    - Se a propriedade jokeService não for acedida numa execução, nem IcanhazDadJokes nem o respetivo HttpClient chegam a ser instanciados.
    - Todas as instâncias são criadas no arranque da aplicação, independentemente de quando são acedidas as propriedades que as publicam.
