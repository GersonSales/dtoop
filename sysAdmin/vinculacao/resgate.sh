#!/bin/bash

find /home/ -type f -size -3k  2>/dev/null| grep ".login_email" | xargs cat
