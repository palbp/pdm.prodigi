# Perguntas 4.1

1. A seguinte afirmação é verdadeira ou falsa?
Em Android, os callbacks de ciclo de vida (ex.: onCreate, onStart de Activity) e os handlers de eventos de UI (ex.: cliques em botões) são executados na Main thread.

2. A seguinte afirmação é verdadeira ou falsa?
É proibido realizar operações de I/O em handlers de eventos da UI independentemente de se tratar ou não de I/O bloqueante.

3. Em que dispatcher são executadas, por omissão, as corotinas lançadas usando o scope retornado por rememberCoroutineScope?
  - Dispatchers.IO
  - Dispatchers.Default
  - Dispatchers.Main
  - Um dispatcher interno não documentado

4. Das seguintes afirmações, indique quais são verdadeiras (pode selecionar mais do que uma)
  - Uma função suspend bloqueia a thread onde é executada até a operação completar.
  - Uma função suspend suspende a corrotina e liberta a thread para executar outras corrotinas.
  - Se uma operação só existe na forma bloqueante, não pode ser chamada numa corrotina executada no Main dispatcher.
  - Uma função suspend corre sempre em “background” e nunca pode executar na Main thread.

5.	Das seguintes afirmações, indique quais são verdadeiras (pode selecionar mais do que uma).  
  - Um scope estabelece relação entre tarefas; quando o scope termina, cancela as corrotinas ativas desse scope.
  - O cancelamento é cooperativo: as corrotinas a serem canceladas têm de participar.
  - O scope produzido por rememberCoroutineScope é cancelado quando a composição onde foi obtido é descartada.
  - O scope viewModelScope é cancelado quando o ViewModel é destruído.