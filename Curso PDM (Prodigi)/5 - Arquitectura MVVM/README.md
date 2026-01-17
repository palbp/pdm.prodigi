# 5 - Arquitectura MVVM (Model - View - ViewModel)

### Objetivos da Secção

- Compreender o padrão MVVM: papéis de View, ViewModel e Model
    - Dependências admissíveis (View → VM → Model);
    - Fluxo de dados em sentido inverso (Model → VM → View) com desacoplamento entre camadas.   
- Justificar porque a Activity não é adequada para fazer o papel de ViewModel
- Explicar o papel da classe ViewModel no modelo de programação Android
    - Descrever o seu ciclo de vida e comportamento face a mudanças de configuração (ex.: rotações de ecrã);
    - Explicar o papel do ViewModel na preservação do estado da UI;
    - Explicar o papel do ViewModel na gestão de operações assíncronas (ex.: acessos à rede);
- Desenhar UIs reativas com Jetpack Compose e MVVM
    -	Descrever o papel dos state holders `State<T>` e `MutableState<T>` na ligação entre View e ViewModel;

### Materiais
- Vídeo: [View Model](https://youtu.be/9vYmkeg72vg?si=NmT3coX858JG-Mul)
- Slides usados no vídeo: [View Model.pdf](/slides/PDM_09_View_Model.pdf)
- [Perguntas 5.1](Quiz_5_1.md)
- [Desafio de codificação 4](/challenges/challenge_4/)
