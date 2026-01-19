# EJECUTAR.ps1 - Script para ejecutar TecmiNuevos

Write-Host "========================================" -ForegroundColor Cyan
Write-Host "  TECMINUEVOS - Sistema de Ventas" -ForegroundColor Red
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# Verificar si existe Maven
if (!(Get-Command mvn -ErrorAction SilentlyContinue)) {
    Write-Host "Error: Maven no está instalado o no está en el PATH" -ForegroundColor Red
    Write-Host "Por favor instala Maven desde: https://maven.apache.org/" -ForegroundColor Yellow
    exit 1
}

# Verificar si existe Java
if (!(Get-Command java -ErrorAction SilentlyContinue)) {
    Write-Host "Error: Java no está instalado o no está en el PATH" -ForegroundColor Red
    Write-Host "Por favor instala Java 11 o superior" -ForegroundColor Yellow
    exit 1
}

Write-Host "Compilando y ejecutando la aplicación..." -ForegroundColor Green
Write-Host ""

# Cambiar al directorio del script
Set-Location $PSScriptRoot

# Ejecutar la aplicación con Maven
mvn clean javafx:run

Write-Host ""
Write-Host "Aplicación finalizada." -ForegroundColor Cyan
