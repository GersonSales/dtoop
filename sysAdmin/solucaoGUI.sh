#!/bin/bash
# Existe um bug no ubuntu 16.04 que corrompe um arquivo do compiz, fazendo com que os menus nao sejam exibidos. Este script deve ser executado no servidor NFS para detectar e remover arquivos corrompido das contas.
# Pre-requisitos: 
#       Nenhum
# Versao:
# Versao 1.0 (Gerson Sales) em 30/11/2016

remocao(){
        log=/var/log/corrigirCompiz.log
        echo "Procurando e removendo arquivos ~/config/dconf/user corrompidos"
        echo -e "\n---\n$(date) - Arquivos corrompidos:\n" >> $log
        find /home/ -type f -size -8k -iname "user" | grep ".config/dconf/user" >> $log
        find /home/ -type f -size -8k -iname "user" | grep ".config/dconf/user" | xargs rm -r
}


#Imprime uma ajuda para utilizar o script
help(){
        echo -e  "Este script procura arquivos ~/config/dconf/user em cada conta e os remove. Desta forma, quando o usuario realizar login, novos arquivos user serao criados.\n\t-h | --help Exibe esta ajuda\n\t-r Realiza a remocao dos arquivos corrompidos."
}

case $1 in
        "--help" | "-h"):
                help;
                ;;
        "-r" ):
                remocao;
                ;;
        *)
                help
                ;;
esac
