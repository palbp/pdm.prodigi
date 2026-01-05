# Perguntas 3.3

1. A seguinte afirmação é verdadeira ou falsa? 
_State hoisting_ consiste em elevar o estado de apresentação para um composable mais acima na árvore da composição, separando UI de comportamento; o restante (estado de aplicação) é empurrado para fora da UI e comunicado via eventos.

2. A seguinte afirmação é verdadeira ou falsa?
Leituras de `State<T>` registam que partes da composição dependência dos dados hospedados escritas em `MutableState<T>` desencadeiam a recomposição das partes que leram esse estado.

3. Relativamente à primitiva `remember { ... }`, qual a afirmação correta?
    - Não preserva o valor da expressão lambda entre recomposições; o valor é sempre recalculado.
    - O valor da expressão lambda é preservado enquanto a Activity existir, independentemente do que acontece à composição.
    - Preserva o valor da expressão lambda mesmo na presença de reconfigurações.
    - Mantém o valor da expressão lambda enquanto o composable se mantiver na composição; quando sai da composição, por exemplo porque ocorreu uma reconfiguração, o valor perde-se.

4. Qual a interpretação correta para a expressão `remember { mutableStateOf("Some String") }`?
    - O tipo da expressão é `MutableState<Int>`
    - É criada uma nova instância de `MutableState` a cada recomposição
    - Mantém a mesma instância de `MutableState` entre recomposições sempre com o mesmo valor inicial "Some String"
    - Mantém a mesma instância de `MutableState` entre recomposições; o valor pode mudar

