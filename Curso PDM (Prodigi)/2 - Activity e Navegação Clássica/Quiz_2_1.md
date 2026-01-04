# Perguntas 2.1

1. Qual o callback que sinaliza que a Activity se tornou visível?  
    - onCreate
    - onStart
    - onStop
    - onDestroy

2. Uma reconfiguração (ex., mudança de orientação do ecrã, idioma ou tema) descarta a Activity atual e cria uma nova instância?   
  
3. Considere duas activities: A e B. Ao lançar B a partir de A, qual é a afirmação correta sobre a ordem entre onStart B e onStop A?
    - onStart B acontece sempre antes de onStop A  
    - onStop A acontece sempre antes de onStart B  
    - A ordem não é garantida
    - Acontecem em simultâneo

4. Considerem-se as activities A e B. Por omissão, relançar A a partir de B quando já existe uma instância de A na _user task_ implica:
    - Reutilizar sempre a instância existente
    - Trocar A e B de posição
    - Reutilizar a instância existente descartando todas as que se sobrepõem a ela
    - Criar uma nova instância de A

5. A seguinte afirmação é verdadeira ou falsa? 
Ao premir o botão Back na Activity visível (ou ao fazer o gesto correspondente), a Activity é removida do topo da _user task_ (sendo chamados onStop e onDestroy) e a anterior é recriada (sendo de novo chamado o seu onCreate)

6. A seguinte afirmação é verdadeira ou falsa?
Intents explícitos navegam entre Activities da mesma aplicação; Intents implícitos servem para interoperar com outras aplicações (ex.: browser, email).