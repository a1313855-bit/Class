@echo off
chcp 65001 > nul
cd /d %~dp0

echo [1/2] Compile Java source files...
if not exist bin mkdir bin
javac -encoding UTF-8 -d bin src\com\codebyx\model\Member.java src\com\codebyx\dao\MemberDao.java src\com\codebyx\dao\impl\MemberDaoMemoryImpl.java src\com\codebyx\service\MemberService.java src\com\codebyx\app\MainApp.java

if errorlevel 1 (
    echo.
    echo Compile failed. Please check JDK 11 installation.
    pause
    exit /b 1
)

echo [2/2] Run application...
java -cp bin com.codebyx.app.MainApp
pause
