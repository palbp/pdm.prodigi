# Perguntas 3.2

1. A seguinte afirmação é verdadeira ou falsa? 
Um layout implementa a política de disposição: mede os filhos com restrições e posiciona-os no espaço disponível.

2. Numa `Row` com três filhos com pesos (modificador `weight`) 1 : 2 : 1, como é repartido o espaço horizontal disponível entre eles?
    - Depende apenas da altura dos elementos
    - 33% : 33% : 33%
    - 40% : 20% : 40%
    - 25% : 50% : 25%

3. Das seguintes afirmações, indique quais são verdadeiras (pode selecionar mais do que uma)
    - `Row` e `Column` dispõem no ecrã os seus filhos e compõem-nos todos, independentemente de ficarem ou não visíveis na área de ecrã disponível.
    - Para listas longas, recomenda-se o uso de `Row` ou `Column` por consumirem menos memória do que as suas variantes _lazy_.
    - `LazyRow` e `LazyColumn` compõem apenas os filhos que ficam visíveis na área de ecrã disponível (e alguns adjacentes). São por isso ideais para listas longas ou potencialmente infinitas.
    - `LazyRow` e `LazyColumn` exigem que se conheça o número de filhos em tempo de desenvolvimento.