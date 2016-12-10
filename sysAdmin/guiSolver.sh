#!/bin/bash

userName=$(whoami)

userFile=/home/$userName/.config/dconf/user

fileSize=$(stat -c%s "$userFile")
minimumFileSize=100000

if [ $fileSize -lt $minimumFileSize ]
then
    echo $fileSize
else
    echo nothing to do here
fi

