Dessign patterns aplicados:

**Strategy**: Aplicado na pasta Schedule.
Descrição  do problema: A classe possuia dois IFS que determinavam o seu funcionamento (Um para criar uma agenda semanal e outro para uma agenda mensal).  

Solução: Padrão Strategy. Criada a interface, e duas classes para os funcionamentos, consegui eliminar o problema dos dois IFS. Eles agora, tem a função de setar qual estratégia será aplicada.  

**Command**: Aplicado na pasta Menu.  
Descrição  do problema: A classe Menu recebia um input (int - id) para selecionar qual função da classe Funções seria chamada. Isso era feito através de diversos IFS.  

Solução: Com a aplicação do padrão Command, os ifs foram eliminados. A chamada da função escolhida, agora é gerenciada pela Classe FunctionsHandler.  

**Smells Simples**:  
Código duplicado em classes Hourly e Salaried (Filhas de Employee) - Solucionado criando um método na classe Employee, com o código comum nas duas classes.  
Código duplicados em algumas funções.  

**Outras alterações**:  
Alguns trechos de código foram refeitos ou simplificados.  
ex: Classe UndoRedo.  
