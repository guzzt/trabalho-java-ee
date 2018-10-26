
# Projeto RAD - Trabalho WEB

Trabalho de web avançado utilizando jpaa.

## TODO

 - [ ] Criar um template, layout design.
 - [ ] Modificar sistema de login e criar cargos.
 - [ ] Criar classes do diagrama
 - [ ] Criar telas.

## Como importar o projeto.

 1. **Instalar o Git** tutorial : http://clubedosgeeks.com.br/programacao/desenvolver-com-git-em-eclipse
 2. **Importar um projeto** do git utilizando o link do repo.
 3. **Realizar os passos do Atenção.**

## Atenção

**Ao clonar o repositorio você deve:**

 1. Utilizar a versão correta do seu SQL Connector no **pom.xml**
	recomendo utilizar 8.0.12 para evitar o trabalho de alterar a versão.
```
<dependency>
	<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
	<version>[SUA VERSÃO AQUI]</version>
</dependency>
```
 2. Criar o seu **persistence.xml** em src/main/resources/META-INF/persistence.xml
	O codigo utiliza como PU a variavel **radPU**
```
<persistence-unit name="radPU" transaction-type="RESOURCE_LOCAL">
<property name="javax.persistence.jdbc.password" value="[SUA SENHA AQUI]" />
```

```
