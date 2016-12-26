#!/bin/bash

getUserLogin() {
    userLogin=""
    until [ "$userLogin" = $(whoami) ]
    do
        userLogin=$(dialog --no-cancel --title "$title" --inputbox "Digite seu login LCC:" 10 35 --stdout)
    done

    echo $userLogin
}

getUserEmail() {
    userEmail=""
    until [[ $userEmail == *"home"* ]]
    do
        userEmail=$(dialog --no-cancel --title "$title" --inputbox "Digite seu email institucional:" 10 35 --stdout)
    done

    echo $userEmail
}

getUserApproval() {
    text="    O sistema de cadastro de email serve para realizar a vinculação entre sua conta-laboratório e sua conta-email.\
    \n\n    Para que tal vinculação seja efetuada com sucesso se torna necessária sua colaboração.\
    \n\n\nDeseja continuar?"

    dialog --title "$title" --yesno "$text" 20 35
    return  $?

}

persistUserData() {
    while true
    do
        userLogin=$(getUserLogin)
        userEmail=$(getUserEmail)
        dialog --title "$title" --yesno "Login: $userLogin\nEmail: $userEmail\n\n\nconfirma?" 10 50
        if [ $? -eq 0 ]
        then
            echo "login=$userLogin" > $directory
            echo "email=$userEmail" >> $directory
            break
        fi

    done

}

homeUser=/home/"$(whoami)"
directory="$homeUser"/login_email

findResult=$(find /home/ -type f -size -8k 2>/dev/null | grep "login_email")

if [ $? -eq 1 ]
then
    touch $directory
    echo "login=$(whoami)" > $directory
    echo "email=" >> $directory
fi

emailField=$(grep "email=" "$directory")

while [ ${#emailField} -lt 7 ]
do
    title="Sistema de cadastro de email"

    if getUserApproval;
    then
        persistUserData
        emailField=$(grep "email=" "$directory")
    else
        exit 1
    fi

done
