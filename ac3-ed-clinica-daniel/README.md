# Avaliação Continuada 03 - Prática 📎

## 🚨 Orientações para a avaliação: 🚨
- Verifique se não há **erros de compilação** no projeto antes de enviá-lo. Erros de compilação resultarão em **desconto na nota**. 
- O projeto possui testes automatizados para ajuda-los a acompanhar a resolucão, para rodar os testes, clique com botão direito no nome do projeto, e em "Run All Tests".
- **Não** é necessário criar **classes** novas
- **Não** é necessário criar **métodos** novos, nem alterar a assinatura (nome a argumentos), já deixamos as assinaturas pronta, ou seja, basta preencher o corpo dos métodos 🙂
- Leia com atenção para entender quais classes já estão completas, e quais necessitam preenchimento de código, para ajudar, usamos os emojis:
  - ✅ = Código completo, não é necessário alterar
  - ⚠️ = Código incompleto, necessário preencher os métodos, completar apenas o corpo (conteúdo).
  - Recomendamos terminar a leitura antes da codificação.
  
---
# 🐾 Contexto: programa para Clínica Veterinaria 
Foi desenvolvido um programa em Java para uma Clínica Veterinaria. Esse programa conta com uma equipe de Gestão da Clínica, por armazenar informações essenciais para o funcionamento da clinica.

### Recursos do Hospital:
Um dos papeis da Gestão é fazer controle dos recursos que a clínica possui  (recurso pode ser um Veterinario Cirurgião, Aparelho de Raio X, Enfermeiro, etc)
- Para isso, foi criada uma classe `GestaoClinica` que utiliza `List<Recurso>` como meio de armazenamento, por questões de desempenho.
- Ocasionalmente, há necessidade de diminuir os recursos da clinica, como em um período com menos atendimentos, e depois volta ao normal. A diminuição de recursos da clinica dessa forma é uma operação que pode ser desfeita e cada operação desfeita também pode ser refeita
- Para isso, foi criado na classe `GestaoClinica` 2 atributos do tipo `PilhaObj<Integer>`, sendo `pilhaDesfazer` e `pilhaRefazer`

### Filas da Clínica Veterinaria
Além do controle de Gestão, a clínica organiza os pets em 2 filas, uma fila de pet prioritários e uma fila de pets não prioritários. Em um determinado momento, vários veterinarios plantonistas chamam os próximos pets a serem atendidos.
- Para isso, foi criada uma classe `Atendimento` que possui 2 atributos do tipo `FilaObj<Pet>`, sendo `filaNormal` e `filaPrioritaria`
---
# 🛠️ Implementação: código

## ✅ Classes `FilaObj` e `PilhaObj`: completas conforme vimos em aula
## ✅ Classe `Recurso`: essa classe já está completa no projeto, não é necessário alterar nada
- Atributos encapsulados:
  - `id`, inteiro
  - `nome`, String (nome do recurso)
  - `quantidade`, int (quantidade disponível do recurso)
- Construtor cheio que inicializa os atributos
- Getters e setters
- toString

### Classe `Pet`: essa classe já está completa no projeto, não é necessário alterar nada
### ✅ Encapsulamento:
- Atributos:
  - `id`, inteiro
  - `nome`, String (nome do pet)
  - `raca` String (raça do pet)
  - `motivo`, String (motivo do atendimento)
- Construtor cheio que inicializa os atributos
- Getters e setters
- toString

## Classe `GestaoClinica`: classe incompleta, os atributos e as assinaturas dos métodos já foram criados, necessário completar apenas o corpo dos métodos
### ✅ Encapsulamento: 
- Atributos: 
  - `lista` - List de Recurso
  - `pilhaDesfazer` – PilhaObj de Integer
  - `pilhaRefazer` – PilhaObj de Integer
- Construtor: instancia a lista, a `pilhaDesfazer` e a `pilhaRefazer`
  
### ⚠️ Método `salvar`:
- Recebe um objeto Recurso e adiciona na lista

### ⚠️ Método `diminuiRecurso`
- Recebe a quantidade a diminuir
- Percorre a lista de recursos e subtrai o `valorDiminuicao` do atributo `quantidade` de cada recurso da lista (por exemplo: se o argumento for 10, a quantidade de cada recurso deve ser o valor antigo da quantidade menos 10)
- Como essa operação pode ser desfeita, empilha o valor da diminuição na `pilhaDesfazer`

### ⚠️ Método `aumentaRecurso` 
- Recebe a quantidade a aumentar
- Percorre a lista de recursos e soma o `valorAumento` ao atributo `quantidade` de cada recurso da lista (por exemplo: se o argumento for 10, a quantidade de cada recurso deve ser o valor antigo da quantidade mais 10) 

### ⚠️ Método `desfazer` 
- Não recebe argumentos
- Se a `pilhaDesfazer` estiver vazia, lança exceção `IllegalStateException`
- Se a `pilhaDesfazer` não estiver vazia, desempilha um valor e faz o "inverso do diminuiRecurso", ou seja, chama o método `aumentaRecurso` com a quantidade desempilhada
- Como a operação pode ser refeita, empilha a quantidade desempilhada na `pilhaRefazer`

### ⚠️ Método `refazer` 
- Não recebe argumentos
- Se a `pilhaRefazer` estiver vazia, lança exceção `IllegalStateException`
- Se a `pilhaRefazer` não estiver vazia, desempilha um valor e "refaz o diminuiRecurso", ou seja, chama o método `diminuiRecurso` passando esse valor desempilhado

## Classe `Atendimento`: classe incompleta, os atributos e as assinaturas dos métodos já foram criados, necessário completar apenas o corpo dos métodos
### ✅ Encapsulamento: 
- Atributos:
  - `filaPrioritaria` – FilaObj de Pet
  - `filaNormal` – FilaObj de Pet
- Construtor:  não recebe argumentos
  - Instância as filas
  
### ⚠️ Método `triagem`
- Recebe um objeto `Pet` como argumento
- Se o pet for prioritario, insere-o na `filaPrioritaria` (**um pet é prioritario quando o atributo `motivo` for igual a "Envenenamento" ou "Hemorragia"**)
- Se o pet não for prioritario, insere-o na `filaNormal`

### ⚠️ Método `atender`
- Recebe a quantidade de pets a serem chamados
- Retorna um vetor com os pets que devem ser atendidos
- Se as filas estão vazias, lança `IllegalStateException`
- Se a quantidade de pets a serem chamados for menor ou igual a zero ou maior do que o tamanho das filas, lança `IllegalArgumentException`
- Cria um vetor auxiliar de Pet com o tamanho igual a `qtdPetChamado` recebida como argumento
- Tira a quantidade de pets desejada das filas, tirando primeiro os pets da `filaPrioritaria`, e coloca cada pet no vetor auxiliar
- Retorna o vetor auxiliar