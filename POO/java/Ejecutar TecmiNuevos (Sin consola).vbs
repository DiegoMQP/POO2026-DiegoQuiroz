Set WshShell = CreateObject("WScript.Shell")
Set fso = CreateObject("Scripting.FileSystemObject")

' Obtener la ruta del script
scriptPath = fso.GetParentFolderName(WScript.ScriptFullName)

' Cambiar al directorio del proyecto
WshShell.CurrentDirectory = scriptPath

' Ejecutar el archivo .bat sin mostrar la ventana de consola
WshShell.Run """" & scriptPath & "\Ejecutar TecmiNuevos.bat""", 0, False

Set WshShell = Nothing
Set fso = Nothing
