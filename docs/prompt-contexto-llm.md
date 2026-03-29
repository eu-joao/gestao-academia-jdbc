# Prompt de Contexto para Novas Conversas com LLM

Cole este bloco no início de qualquer conversa nova sobre o projeto para dar contexto ao modelo.

---

## BLOCO DE CONTEXTO — COLAR NO INÍCIO DA CONVERSA

```
Estou trabalhando em um projeto acadêmico para a disciplina de Desenvolvimento de Aplicações Web II (DAW2) no IFPB Campus Esperança. O grupo tem 4 pessoas. A stack é Java + Maven + banco de dados relacional + OO.

O sistema é uma plataforma de controle financeiro e de acesso físico para uma rede de academias de ginástica. Está fora do escopo: treinos, agendamentos, funcionários, modalidades online.

Entidades: Unidade, Aluno, Plano, Contrato, Cobrança.

Decisões de modelagem já tomadas:
- Aluno NÃO tem unidade fixa; a unidade fica no Contrato (permite multi-unidade e preserva histórico)
- Renovação cria novo Contrato (nunca modifica o existente)
- Cancelamento de contrato inativa o aluno automaticamente
- 5 planos predefinidos (diário, mensal, trimestral, semestral, anual); sem customização por contrato
- Carência de 2 dias após vencimento antes do bloqueio na catraca
- Cobranças geradas automaticamente ao criar o contrato
- Sem relacionamentos N:N no modelo conceitual
- FK pertencem ao modelo lógico/físico, não ao MER

Estado atual:
- Minimundo v3 finalizado
- Modelo conceitual (MER) pronto no draw.io
- Repositório GitHub criado
- Estrutura técnica do projeto ainda aguarda orientação do professor

[DESCREVA AQUI O QUE VOCÊ PRECISA NESTA CONVERSA]
```

---

## Dicas de Uso

- Substitua `[DESCREVA AQUI...]` pela tarefa específica da sessão.
- Para sessões de modelagem lógica, mencione que o MER está pronto e peça para partir daí.
- Para sessões de código Java, informe o que o professor já orientou sobre estrutura de pastas e framework antes de pedir implementação.
- Se tiver dúvidas de regra de negócio, referencie o arquivo `minimundo-resumo.md` ou o documento completo `Minimundo_DAW2_v3.docx`.
