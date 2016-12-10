#!/bin/bash

users=`ls /home/`

for user in $users
do
    folders=`ls -a /home/$user/`

    for folder in $folders
    do
        if [ -d /home/$user/$folder ]
        then
            case $folder in
            '.config')
                configFoolders=`ls /home/$user/.config/`
                for subFolder in $configFoolders
                do
                    if [ -d /home/$user/$folder/$subFolder ]
                    then
                        case $subFolder in
                        'dconf')
                            for file in $subFolder
                            do
                                echo $file
                                if [ -f /home/$user/$folder/$subFolder/$file ]
                                then
                                    echo $file
                                fi
                            done
                    esac
                    fi
                done
            esac
        fi
    done

done

