@echo off
 
title GIT auto push
color 3
echo current directory is：%cd%
echo;

echo local branch push remote master branch：git pull origin master
git pull origin master
echo;

echo start adding modification:git add .
git add .
echo;
 
git commit -m "update"
echo;
 
 
echo push the modification to remote master branch:git push origin master
git push origin master
echo;
 
 

 
echo process complete!
echo;
 
pause