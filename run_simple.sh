#!/bin/bash

# Script simples para capturar saída do MainAlunoSave
echo "Iniciando execução em $(date)" > execution_output.txt
./mvnw exec:java -Dexec.mainClass="br.edu.ifpb.es.daw.MainAlunoSave" >> execution_output.txt 2>&1
echo "Execução finalizada em $(date)" >> execution_output.txt