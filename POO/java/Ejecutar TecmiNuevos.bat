@echo off
REM ========================================
REM  TECMINUEVOS - Sistema de Ventas
REM ========================================

cd /d "%~dp0"

echo.
echo ========================================
echo   TECMINUEVOS - Sistema de Ventas
echo ========================================
echo.

REM Verificar si Maven está instalado
where mvn >nul 2>nul
if %errorlevel% neq 0 (
    echo [ERROR] Maven no esta instalado o no esta en el PATH
    echo Por favor instala Maven desde: https://maven.apache.org/
    echo.
    pause
    exit /b 1
)

REM Verificar si Java está instalado
where java >nul 2>nul
if %errorlevel% neq 0 (
    echo [ERROR] Java no esta instalado o no esta en el PATH
    echo Por favor instala Java 11 o superior
    echo.
    pause
    exit /b 1
)

echo Compilando y ejecutando la aplicacion...
echo.

REM Ejecutar la aplicación con Maven
mvn clean javafx:run

echo.
echo Aplicacion finalizada.
echo.
pause
