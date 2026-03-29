# Sistema de Gestão de Academia — DAW2 / IFPB Campus Esperança

Projeto acadêmico da disciplina Desenvolvimento de Aplicações Web II. Grupo de 4 pessoas. Stack: Java + Maven + banco de dados relacional + OO.

## O que o sistema faz

Plataforma centralizada de controle financeiro e de acesso físico para uma rede de academias de ginástica.

**Fora do escopo:** treinos, agendamentos, funcionários, modalidades online ou consultoria.

## Entidades e atributos

| Entidade  | Atributos                                                                              |
|-----------|----------------------------------------------------------------------------------------|
| Unidade   | id, nome, endereço, CNPJ, telefone                                                     |
| Aluno     | id, nome, CPF, telefone, e-mail, status (ativo/inativo)                                |
| Plano     | id, tipo, valor, duração em dias, percentual de desconto, descrição                    |
| Contrato  | id, aluno, unidade, plano, data início, data término, status (ativo/cancelado)         |
| Cobrança  | id, contrato, data vencimento, valor, data pagamento, forma de pagamento, status       |

## Regras de negócio

- Planos predefinidos: diário, mensal, trimestral, semestral, anual — sem customização por contrato
- Descontos progressivos para planos mais longos, aplicados automaticamente
- Aluno não tem unidade fixa; a unidade fica no Contrato (permite multi-unidade e preserva histórico)
- Um aluno só pode ter um contrato ativo por vez
- Renovação = novo contrato; nunca modifica o existente
- Cancelamento de contrato inativa o aluno automaticamente e bloqueia a catraca
- Carência de 2 dias após vencimento da cobrança antes do bloqueio automático na catraca
- Cobranças geradas automaticamente ao criar o contrato para todo o período
- Notificações via WhatsApp automáticas: vencimento próximo e cobrança atrasada

## Decisões de modelagem

- Sem relacionamentos N:N no modelo conceitual
- FK pertencem ao modelo lógico/físico, não ao MER
- Entidade `Visita` (log de presença) foi considerada e rejeitada — fora do escopo
- Notação de cardinalidade (min, max) posicionada no lado oposto à entidade descrita

## Estado atual

- [x] Minimundo v3 finalizado
- [x] Modelo conceitual (MER/DER) no draw.io
- [x] Repositório GitHub criado
- [ ] Estrutura técnica do projeto (aguardando orientação do professor)
- [ ] Modelo lógico / físico
- [ ] Implementação
