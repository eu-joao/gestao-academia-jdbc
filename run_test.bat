@echo off
echo Iniciando execução em %date% %time% > execution_output.txt
call mvnw.cmd exec:java -Dexec.mainClass="br.edu.ifpb.es.daw.MainAlunoSave" >> execution_output.txt 2>&1
echo Execução finalizada em %date% %time% >> execution_output.txt
echo.
echo Saída capturada no arquivo 'execution_output.txt'
pause