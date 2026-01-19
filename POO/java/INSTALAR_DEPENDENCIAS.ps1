# INSTALAR_DEPENDENCIAS.ps1 - Script para instalar dependencias de TecmiNuevos

Write-Host "========================================" -ForegroundColor Cyan
Write-Host "  TECMINUEVOS - Instalador" -ForegroundColor Red
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# Verificar si existe Maven
if (!(Get-Command mvn -ErrorAction SilentlyContinue)) {
    Write-Host "Error: Maven no está instalado o no está en el PATH" -ForegroundColor Red
    Write-Host "Por favor instala Maven desde: https://maven.apache.org/" -ForegroundColor Yellow
    exit 1
}

Write-Host "Instalando dependencias del proyecto..." -ForegroundColor Green
Write-Host ""

# Limpiar el proyecto
Write-Host "Limpiando proyecto anterior..." -ForegroundColor Yellow
mvn clean

Write-Host ""
Write-Host "Descargando dependencias..." -ForegroundColor Yellow
mvn dependency:resolve

Write-Host ""
Write-Host "Compilando el proyecto..." -ForegroundColor Yellow
mvn compile

Write-Host ""
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "  Instalación completada exitosamente" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "Para ejecutar la aplicación, usa: .\EJECUTAR.ps1" -ForegroundColor Yellow
