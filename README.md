# git food-ordering-system




## Visualizando el diagrama de relaciones de servicios
1. Instalar *graphviz* desde [**Acá**](https://graphviz.org/download/source/)
2. Ejecutar el siguiente comando pero antes recuerda modificar el parámetro "-Dincludes=<groupId>*:*":
   > mvn com.github.ferstl:depgraph-maven-plugin:aggregate -DcreateImage=true -DreduceEdges=false -Dscope=compile "-Dincludes=com.kathesama.demo*:*"

Se debería ver algo como esto:

![Diagrama de relaciones de servicios](./target/dependency-graph.png)