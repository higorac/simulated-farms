# Contexto compartilhado — Simulated Farms

> Leitura obrigatória para todos os agentes antes de qualquer tarefa. Contém o contexto do projeto e o
> protocolo de trabalho da equipe.

## Contexto do projeto

### Identificadores

| Item | Valor |
| --- | --- |
| Nome | Simulated Farms |
| Repositório | `https://github.com/higorac/simulated-farms` |
| Mod id | `simulated_farms` |
| Pacote Java base | `io.github.higorac.simulatedfarms` |
| Pasta de dados no mundo | `<mundo>/simulated-farms/` |
| Licença | GNU LGPL v3.0 (`COPYING.LESSER` + `COPYING`) |

### O projeto

Simulated Farms é um mod para **NeoForge 1.21.1** (alvo principal: modpack **ATM10**) que mantém farms em cadeia
produzindo com o jogo fechado, sem servidor. Ele tem três partes:

| Parte | O que faz | Depende do Minecraft? |
| --- | --- | --- |
| `core` | Grafo da cadeia, motor de simulação por passos fixos, formato de snapshot e resultado | **Não** (Java 21 puro) |
| `mod` | Mede farms no jogo (Registrador de Farm), exporta snapshot ao fechar, aplica resultado ao abrir | Sim |
| `daemon` | Processo no terminal: simula enquanto ligado (interruptor), monitor ao vivo, checkpoints | **Não** |
| `adapters/*` | Um módulo por mod externo (Mystical Agriculture, AE2, Mekanism, Storage Drawers) | Sim |

### O ciclo

1. **Calibração:** o Registrador mede entrada e saída reais de cada nó (itens/min, FE/min).
2. **Fechar o mundo:** o mod grava `snapshot.json` e cria `simulated-farms.lock` em `<mundo>/simulated-farms/`.
3. **Daemon ligado:** lê o snapshot, simula em passos fixos, grava `result.json` em checkpoints.
   O tempo que conta é o tempo de execução do daemon (relógio monotônico), nunca o relógio do sistema.
4. **Abrir o mundo:** o mod confere a trava, lê o resultado e aplica as diferenças numa transação única.
5. **Volta ao jogo:** o mod volta a medir; farm alterada exige recalibração.

### Regras invioláveis

1. **Nenhum item surge do nada e nenhum some.** Toda mudança de estoque tem origem rastreável no grafo.
2. **O daemon nunca escreve no save do mundo** (region files, level.dat). Só lê e grava arquivos em `simulated-farms/`.
3. **Só o mod mexe em inventários**, sempre na thread principal do servidor, com o jogo aberto.
4. **O `core` não importa nada do Minecraft nem do NeoForge.** Se precisar, a abstração está errada.
5. **Determinismo:** mesmo snapshot + mesmo tempo simulado = mesmo resultado, byte a byte.
6. **Sem código copiado de outros mods.** Estude o comportamento e reimplemente (ver licenças abaixo).
7. **Segurança auditável.** Siga todas as regras do `SECURITY.md`: sem acesso à rede, acesso a arquivos
   limitado a `simulated-farms/`, sem ofuscação, sem carregar código em tempo de execução, sem
   `Runtime.exec`/`ProcessBuilder`, sem bibliotecas nativas, dependências com versão fixa e justificadas.

### Fora do escopo da v1

Multiplayer e servidor dedicado; simular redstone, entidades ou farms de mobs; autocrafting do AE2
(o AE2 entra só como nó de armazenamento); outras versões do Minecraft; Fabric.

### Stack

- Java 21, Gradle multi-módulo, NeoForge 1.21.1 com ModDevGradle no módulo `mod` e nos adaptadores.
- Testes: JUnit 5 em `core` e `daemon`; framework de GameTest do NeoForge em `mod` e `adapters`.
- Snapshot e resultado: JSON com campo `schemaVersion`. Itens serializados com os codecs do próprio jogo
  (data components inclusos); no `core`, a identidade do item é uma chave opaca.

### Licenças

O Simulated Farms é LGPL v3.0: qualquer versão modificada do mod precisa manter o código aberto, o que
permite à comunidade auditar o que roda no jogo. Todo arquivo de código novo começa com o cabeçalho
SPDX `// SPDX-License-Identifier: LGPL-3.0-only`.

AE2 (LGPL), Mekanism (MIT) e outros têm licenças próprias. Ler o código-fonte para entender é permitido;
copiar trechos para o Simulated Farms não, pois isso mistura licenças. Use apenas as APIs públicas.

### Commits

Conventional Commits, assunto em inglês com menos de 72 caracteres, corpo com parágrafos `EN:` e `PT-BR:`.
Um commit por mudança lógica.

## Protocolo de trabalho

### Donos de cada pasta

| Pasta | Dono | Quem mais pode alterar |
| --- | --- | --- |
| `core/` | engenheiro-simulacao | testador (só `src/test`) |
| `daemon/` | engenheiro-daemon | testador (só `src/test`) |
| `mod/` | especialista-neoforge | testador (`src/test`, `src/gametest`) |
| `adapters/api/` | especialista-integracoes | mudança exige aprovação do engenheiro-simulacao |
| `adapters/<mod>/` | especialista-integracoes | testador |
| `docs/mods/` | analista-de-mods | — |
| `docs/decisoes/`, `ROADMAP.md` | orquestrador | — |
| `README.md`, `CONTRIBUTING.md`, `docs/` (resto) | documentador | — |
| `SECURITY.md` | documentador | mudança exige parecer do revisor |
| Build da raiz (`settings.gradle`, `build.gradle`, `gradle/`), `.github/` | especialista-neoforge | mudança em CI ou dependências exige parecer do revisor |
| `CLAUDE.md`, `.claude/agents/` | orquestrador | só com pedido do usuário |

Um agente que precisa mudar algo fora da sua pasta **não muda**: devolve ao orquestrador um pedido descrevendo
a mudança.

### Formato de tarefa (orquestrador → agente)

```
TAREFA: <id curto, ex.: F1-03>
OBJETIVO: <uma frase com o resultado esperado>
CONTEXTO: <arquivos, fichas técnicas e decisões relevantes>
ENTRADAS: <o que já existe e pode ser usado>
CRITÉRIO DE PRONTO: <testes que precisam passar, comportamento observável>
FORA DO ESCOPO: <o que não fazer nesta tarefa>
```

### Formato de entrega (agente → orquestrador)

```
TAREFA: <id>
STATUS: concluída | bloqueada | parcial
O QUE MUDOU: <arquivos e resumo de uma linha cada>
COMO VERIFICAR: <comandos de teste e resultado esperado>
RISCOS OU DÚVIDAS: <o que o orquestrador precisa decidir>
PEDIDOS A OUTROS AGENTES: <mudanças fora da sua pasta, se houver>
```

### Definição de pronto (vale para toda tarefa de código)

- Compila e todos os testes do módulo passam (`./gradlew :<modulo>:test`).
- Testes novos cobrem o comportamento novo.
- Nenhuma das regras invioláveis foi quebrada.
- O revisor deu parecer "aprovado" (ou "aprovado com ressalvas" registradas).

### Fluxo de uma tarefa

1. Orquestrador cria a tarefa.
2. Se envolve mod externo e não há ficha em `docs/mods/`, o **analista-de-mods** faz a ficha primeiro.
3. O especialista dono da pasta implementa.
4. O **testador** valida e amplia os testes.
5. O **revisor** dá o parecer.
6. O orquestrador fecha a tarefa; o **documentador** atualiza a documentação se a mudança afeta usuários ou
   contribuidores.
