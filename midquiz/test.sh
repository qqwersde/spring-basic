#!/usr/bin/env bash

RED_COLOR="\033[31m"  #红
GREEN_COLOR='\033[32m' #绿
YELOW_COLOR='\033[33m' #黄
BLUE_COLOR='\033[34m'  #蓝
PINK='033[37m'      #粉红
RES='\033[0m'

echo -e "${RED_COLOR} hello world${RES}"
read -p "按任意键关闭" -n 1
