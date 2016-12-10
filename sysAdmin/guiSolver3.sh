#!/bin/bash

HOME=/home/
homeFolder=`ls $HOME`

for user in $homeFolder
do
    CONFIG=$HOME$user/.config/
    userConfigFiles=`ls -a $CONFIG`

    for confFiles in $userConfigFiles
    do
        case $confFiles in
        'compiz-1')
            echo $confFiles;; #Remove File;

        'dconf')
            dconfUserFile=`stat -c%s $CONFIG/dconf/user`
            minSizeAllowed=100

            if [ $dconfUserFile -lt $minSizeAllowed ]
            then
                echo $dconfUserFile
            fi;;
        *)
            #echo doNothing
        esac
    done


done

