@echo off
REM ========================================
REM  TECMINUEVOS - Instalacion de Dependencias
REM ========================================

cd /d "%~dp0"

echo.
echo ========================================
echo   Instalando Dependencias
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

echo Descargando e instalando dependencias...
echo.

REM Instalar dependencias
mvn clean install

echo.
echo Dependencias instaladas correctamente.
echo.
pause
