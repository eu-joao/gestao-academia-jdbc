# Minimundo — Sistema de Gestão de Academia (v3)

> Versão resumida para referência rápida. O documento completo é `Minimundo_DAW2_v3.docx`.

## Problema

Redes de academias não têm sistema centralizado para:
- Controle financeiro integrado entre unidades
- Acompanhamento de inadimplência
- Controle de acesso físico (catraca) vinculado ao status de pagamento

## Domínio

### Rede de Unidades
Múltiplas unidades físicas com base de dados central compartilhada. Cada unidade tem nome, endereço e CNPJ.

### Alunos
Cadastro centralizado (nome, CPF, telefone, e-mail, status). **Não vinculados a uma unidade fixa** — a unidade fica no contrato. Apenas modalidade presencial. Status ativo/inativo.

### Planos
5 tipos fixos: **diário, mensal, trimestral, semestral, anual**. Descontos progressivos para planos mais longos. Valor fixo por plano — sem customização por contrato.

### Contratos
Vínculo formal aluno ↔ academia. Contém: plano escolhido, unidade de origem, data início, data término (calculada pelo plano), status. Apenas 1 ativo por aluno. Renovação = novo contrato.

### Cobranças
Geradas automaticamente ao criar o contrato. Campos: data de vencimento, valor, data de pagamento, forma de pagamento, status (pendente/pago/atrasado). Status atualizado automaticamente.

### Controle de Acesso (Catraca)
- Liberado: contrato ativo + sem cobranças atrasadas
- Bloqueado: contrato cancelado/inativo OU cobrança atrasada (após carência de 2 dias)

### Notificações WhatsApp
Automáticas, sem intervenção manual. Disparadas em: vencimento próximo e cobrança atrasada.
