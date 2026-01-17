# Perguntas 6.1

1. A seguinte afirmação é verdadeira ou falsa?
 Em arquiteturas cliente–servidor, o servidor regula os acessos aos dados críticos (lógica de domínio no backend), sendo os dispositivos Android uma das possíveis interfaces do sistema.

2. Acerca da motivação para usar Web APIs, assinale as afirmações verdadeiras (pode selecionar mais do que uma):
    - Promovem independência tecnológica entre cliente e servidor.   
    - Permitem clientes heterogéneos (Android, iOS, Web, etc.).   
    - Obrigam a que cliente e servidor usem o mesmo stack tecnológico (ex. a mesma linguagem de programação e o mesmo conjunto de bibliotecas).  

3. Considere o exemplo apresentado no [vídeo]() acerca do contrato que representa o acesso à Web API usada para obter piadas. Das seguintes afirmações, indique quais são verdadeiras (pode selecionar mais do que uma)
    - A abstração `JokesService` modela o requisito de acesso e expõe as funções suspend necessárias.
    - A implementação concreta `IcanhazDadJokes` encapsula os detalhes de comunicação HTTP usando a biblioteca Ktor Client.
    - A função `fetchJoke` devolve um objeto do tipo `HttpResponse`.
    - A função `fetchJoke` é uma função bloqueante.

4. A seguinte afirmação é verdadeira ou falsa?
    Em Ktor Client, basta adicionar a dependência `ktor-client-core`. Feito isso é possível emitir pedidos HTTP e desserializar JSON através de `body<T>()`
