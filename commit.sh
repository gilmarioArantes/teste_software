#!/bin/bash
atividade_redmine=34779

echo "----------Adicionando as alterações ao controle de versão----------"

git add -A

echo "----------Commitando as alterações:----------"

git commit -m "#$atividade_redmine Atualizando o repositório."

echo "----------Enviando as alterações para o repositório remoto:----------"

git push

