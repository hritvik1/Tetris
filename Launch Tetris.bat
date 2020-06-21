:: Written By ~Hritvik~
@echo off
set PROGRAM = Tetris
if not "%1" == "max" start /MAX cmd /c %0 max & exit/b
echo Compiling Tetris Game By Hritvik.....
javac Tetris.java
timeout /t 3 /nobreak>nul
echo Game Compiled Successfully..
echo Creating Directories For Save Game Files....
md C:\Games\Tetris\Saves
timeout /t 2 /nobreak>nul
echo Directories Created Successfully!!!
echo Launching Game In.....
timeout /t 5 /nobreak
java Tetris
pause