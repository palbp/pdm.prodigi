# Desafio 5 

### Enunciado

Pretende-se implementar a aplicação Facto Inútil do Dia que obtém um facto aleatório a partir de uma web API e o apresenta ao utilizador. A aplicação deve ser construída usando a arquitetura MVVM, a biblioteca Ktor Client para comunicação HTTP, e Jetpack Compose para a UI.

#### Requisitos (o que deve ficar a funcionar):
A aplicação tem um único ecrã que:
  - Ao ser apresentado, mostra um facto aleatório obtido através de pedido HTTP;
  - Mostra ao utilizador que o facto está a ser obtido, por exemplo usando um indicador de progresso;
  - Disponibiliza a ação “Novo facto” (novo pedido HTTP);
  - Em caso de falha, mostra o ocorreu um erro e estado fornece a ação “Tentar novamente”;
  - Regista em log os eventos principais (início/sucesso/erro).

Notas:
- Use a API pública disponível em https://uselessfacts.jsph.pl/random.json?language=en para obter os factos aleatórios. Note que a API não produz factos em português.
  
Objetivo pedagógico: familiarização com a construção de aplicações Android completas que integram comunicação HTTP assíncrona com uma UI reativa, usando MVVM e Jetpack Compose.

Guião: [guide.md](guide.md)  
Solução (tag): [challenge_5_solution]()


#### Validação (checklist)
- Pedido HTTP realizado sem bloquear a Main thread; 
- UI mostra indicador de progresso enquanto espera pela resposta;
- Facto apresentado na UI quando o pedido é bem sucedido;
- Mensagem de erro apresentada na UI quando o pedido falha;
- Composables do ecrã Facto Inútil do Dia são stateless;
- ViewModel implementado para o ecrã Facto Inútil do Dia;
- Lógica de comunicação HTTP separada da UI e do ViewModel.