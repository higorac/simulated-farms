# Roadmap

**English** · [Português](#português)

Each phase starts only when the previous phase's criterion passes in an automated test. Phases have no
dates.

| Phase | Goal | Criterion to move on |
| --- | --- | --- |
| **0 · Foundation** (current) | Multi-module Gradle repository (core, daemon, mod, adapters/api), agents, CI | Empty mod and daemon build and run on NeoForge 1.21.1 |
| 1 · MVP | One inferium farm measured by the Farm Recorder, output to a chest; daemon with on/off switch and terminal monitor | Offline production matches production measured in game |
| 2 · Chains | Converters between essence tiers, multi-step graph, buffers and bottlenecks | Chain up to supremium simulated end to end |
| 3 · Robustness | FE energy, lock file, daemon checkpoints, changed-farm detection and recalibration | Zero duplication or loss in sync tests |
| 4 · Integrations | AE2 as a storage node, Storage Drawers, Mekanism; fluids and chemicals | Items inserted through the AE2 API in an automated test |
| 5 · Community | Stable adapter API, docs, contribution guide, first open source release | An external adapter works without changing core |

## Phase 0 tasks

- [x] F0-00 Repository, LGPL-3.0 license, README, SECURITY, CONTRIBUTING, agent team
- [x] F0-01a Gradle skeleton for the pure-Java modules (`core`, `daemon`) and CI
- [ ] F0-01b `mod` module with ModDevGradle on NeoForge 1.21.1
- [ ] F0-01c `adapters/api` module
- [ ] F0-02 Gradle dependency verification enabled
- [ ] F0-03 Release workflow with SHA-256 checksums

## Later

Dedicated server and multiplayer; local web dashboard and notifications; other Minecraft versions;
Fabric.

---

## Português

[English](#roadmap) · **Português**

Cada fase só começa quando o critério da fase anterior passa num teste automatizado. As fases não têm
datas.

| Fase | Objetivo | Critério para avançar |
| --- | --- | --- |
| **0 · Fundação** (atual) | Repositório Gradle multi-módulo (core, daemon, mod, adapters/api), agentes, CI | Mod e daemon vazios compilam e rodam no NeoForge 1.21.1 |
| 1 · MVP | Uma farm de inferium medida pelo Registrador de Farm, saída num baú; daemon com interruptor e monitor no terminal | Produção offline bate com a produção medida no jogo |
| 2 · Cadeias | Conversores entre tiers de essência, grafo com várias etapas, buffers e gargalos | Cadeia até o supremium simulada de ponta a ponta |
| 3 · Robustez | Energia FE, arquivo de trava, checkpoints do daemon, detecção de farm alterada e recalibração | Zero duplicação ou perda nos testes de sincronização |
| 4 · Integrações | AE2 como nó de armazenamento, Storage Drawers, Mekanism; fluidos e químicos | Itens inseridos pela API do AE2 em teste automatizado |
| 5 · Comunidade | API de adaptadores estável, documentação, guia de contribuição, primeiro release open source | Um adaptador externo funciona sem mudar o core |

## Tarefas da Fase 0

- [x] F0-00 Repositório, licença LGPL-3.0, README, SECURITY, CONTRIBUTING, equipe de agentes
- [x] F0-01a Esqueleto Gradle dos módulos em Java puro (`core`, `daemon`) e CI
- [ ] F0-01b Módulo `mod` com ModDevGradle no NeoForge 1.21.1
- [ ] F0-01c Módulo `adapters/api`
- [ ] F0-02 Verificação de dependências do Gradle ativada
- [ ] F0-03 Workflow de release com checksums SHA-256

## Depois

Servidor dedicado e multiplayer; painel web local e notificações; outras versões do Minecraft; Fabric.
