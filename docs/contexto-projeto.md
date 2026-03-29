# Contexto do Projeto — Sistema de Gestão de Academia

## Identificação

- **Disciplina:** Desenvolvimento de Aplicações Web II (DAW2)
- **Instituição:** Instituto Federal de Educação, Ciência e Tecnologia da Paraíba (IFPB) — Campus Esperança
- **Curso:** Análise e Desenvolvimento de Sistemas
- **Grupo:** Samuel Cláudio Duarte Lima, João Augusto Silva de Araújo, Arley Andrey Alves Pereira, Miguel Rodrigo da Silva Normando

## Stack Tecnológica

- **Linguagem:** Java
- **Build:** Maven
- **Paradigma:** Orientação a Objetos (OO)
- **Banco de dados:** relacional (estrutura de pastas e framework a definir pelo professor)
- **Repositório:** GitHub (já criado)

> A estrutura de diretórios do projeto será definida pelo professor. Não alterar a organização técnica até orientação formal.

## Objetivo do Sistema

Plataforma centralizada de **controle financeiro e de acesso físico** para uma rede de academias de ginástica. O sistema integra gestão de cobranças/mensalidades com controle de catraca por unidade.

**Fora do escopo:** controle de treinos, agendamentos, cadastro de funcionários, modalidades online ou consultoria.

## Entidades Principais

| Entidade   | Atributos principais                                                                 |
|------------|--------------------------------------------------------------------------------------|
| Unidade    | id, nome, endereço, CNPJ, telefone                                                   |
| Aluno      | id, nome, CPF, telefone, e-mail, status (ativo/inativo)                              |
| Plano      | id, tipo, valor, duração em dias, percentual de desconto, descrição                  |
| Contrato   | id, aluno, unidade, plano, data de início, data de término, status (ativo/cancelado) |
| Cobrança   | id, contrato, data de vencimento, valor, data de pagamento, forma de pagamento, status |

## Regras de Negócio Críticas

1. **Planos predefinidos:** diário, mensal, trimestral, semestral, anual. Não podem ser criados por unidade nem ter valor alterado por contrato.
2. **Desconto progressivo:** planos mais longos têm desconto embutido, aplicado automaticamente.
3. **Aluno não vinculado a unidade fixa:** a unidade fica no `Contrato`, não no `Aluno`. Isso permite frequentar unidades diferentes ao longo do tempo e preserva o histórico.
4. **Contrato único ativo:** um aluno não pode ter mais de um contrato ativo simultaneamente.
5. **Renovação = novo contrato:** nunca modifica o contrato existente; cria um novo, preservando histórico.
6. **Cancelamento de contrato:** inativa automaticamente o aluno e bloqueia o acesso na catraca.
7. **Carência de 2 dias:** após vencimento da cobrança, o acesso permanece liberado por até 2 dias antes do bloqueio automático.
8. **Geração automática de cobranças:** ao criar o contrato, o sistema gera todas as cobranças do período.
9. **Notificações via WhatsApp:** disparadas automaticamente para vencimento próximo e cobrança atrasada.
10. **Acesso na catraca:** liberado somente com contrato ativo + sem cobranças atrasadas (respeitando carência).

## Estado Atual do Projeto

- [x] Minimundo v3 finalizado (`Minimundo_DAW2_v3.docx`)
- [x] Modelo conceitual (MER/DER) construído no draw.io
- [x] Repositório GitHub criado
- [ ] Estrutura técnica do projeto (aguardando orientação do professor)
- [ ] Modelo lógico / físico
- [ ] Implementação

## Decisões de Modelagem Já Tomadas

- **Sem N:N explícito:** o modelo conceitual não possui relacionamentos N:N. A entidade `Visita` (log de presença) foi considerada e **rejeitada** — rastreamento de frequência é fora do escopo.
- **Sem FK no conceitual:** chaves estrangeiras pertencem ao modelo lógico/físico, não ao MER.
- **Notação de cardinalidade (min, max):** posicionada no lado oposto à entidade descrita.
- **Unidade no Contrato:** decisão arquitetural central — resolve acesso multi-unidade e preserva histórico naturalmente.
