# Simulated Farms

**English** · [Português](#português)

Keep your Minecraft farm chains producing while the game is closed, without running a server.

> **Status: pre-alpha (Phase 0 — Foundation).** Nothing is playable yet. This repository holds the
> project scope, architecture, agent team and build skeleton. See [ROADMAP.md](ROADMAP.md).

## The problem

A farm only produces while its chunk is loaded. Keeping farms running with the game closed means
keeping a server on, which costs a lot of RAM and CPU or money.

## The idea

Simulated Farms does not load chunks. It simulates only the *information* about your farms:
production rates, conversions between items, storage space and energy.

1. **Calibrate in game.** A Farm Recorder block measures the real input and output of each farm.
2. **Close the world.** The mod writes a snapshot of your farm chain to `<world>/simulated-farms/`.
3. **Run the daemon.** A lightweight terminal process simulates the whole chain *only while it is
   running*. It is the on/off switch of your base, with a live monitor of production and bottlenecks.
4. **Open the world.** The mod applies the result: items in chests or storage networks, inputs and
   energy consumed.

Unlike mods that recompute single blocks when a chunk reloads, Simulated Farms simulates whole
**chains** of modded farms, such as essence tiers in Mystical Agriculture.

## Architecture

| Module | What it does | Depends on Minecraft? |
| --- | --- | --- |
| `core` | Farm chain graph, fixed-step simulation engine, snapshot and result formats | No (pure Java 21) |
| `daemon` | Terminal process: on/off switch, live monitor, checkpoints | No |
| `mod` | Measures farms, exports the snapshot, applies the result (NeoForge 1.21.1) | Yes |
| `adapters/*` | One module per external mod (Mystical Agriculture, AE2, Mekanism, Storage Drawers) | Yes |

The `mod` and `adapters` modules are created in Phase 0 by the project's agent team.

**Target:** NeoForge 1.21.1, with the ATM10 modpack as the main reference. Single player first.

## Security and license

Simulated Farms is licensed under the **GNU LGPL v3.0** ([COPYING.LESSER](COPYING.LESSER), which
builds on the GNU GPL v3.0 in [COPYING](COPYING)). Any modified version of the mod must keep its
source open. Releases are built only by public CI from tagged source, with checksums, so anyone can
check that a jar matches the code. See [SECURITY.md](SECURITY.md) for the safety rules the code follows
and how to report malicious code.

## Contributing

Read [CONTRIBUTING.md](CONTRIBUTING.md). The most valuable contributions will be **adapters** for other
mods, through a small and stable adapter API.

---

## Português

[English](#simulated-farms) · **Português**

Mantenha suas cadeias de farms do Minecraft produzindo com o jogo fechado, sem rodar um servidor.

> **Status: pré-alfa (Fase 0 — Fundação).** Ainda não há nada jogável. Este repositório contém o
> escopo, a arquitetura, a equipe de agentes e o esqueleto do build. Veja o [ROADMAP.md](ROADMAP.md).

## O problema

Uma farm só produz enquanto a chunk dela está carregada. Manter farms rodando com o jogo fechado
exige um servidor ligado, que consome muita RAM e CPU ou custa dinheiro.

## A ideia

O Simulated Farms não carrega chunks. Ele simula só as *informações* das suas farms: taxas de
produção, conversões entre itens, espaço de armazenamento e energia.

1. **Calibre no jogo.** Um bloco Registrador de Farm mede a entrada e a saída reais de cada farm.
2. **Feche o mundo.** O mod grava um snapshot da cadeia em `<mundo>/simulated-farms/`.
3. **Ligue o daemon.** Um processo leve no terminal simula a cadeia inteira *somente enquanto estiver
   ligado*. Ele é o interruptor da sua base, com monitor ao vivo de produção e gargalos.
4. **Abra o mundo.** O mod aplica o resultado: itens nos baús ou nas redes de armazenamento, insumos e
   energia consumidos.

Diferente de mods que recalculam blocos isolados quando a chunk recarrega, o Simulated Farms simula
**cadeias** inteiras de farms modded, como os tiers de essência do Mystical Agriculture.

## Arquitetura

| Módulo | O que faz | Depende do Minecraft? |
| --- | --- | --- |
| `core` | Grafo da cadeia, motor de simulação por passos fixos, formatos de snapshot e resultado | Não (Java 21 puro) |
| `daemon` | Processo no terminal: interruptor, monitor ao vivo, checkpoints | Não |
| `mod` | Mede as farms, exporta o snapshot, aplica o resultado (NeoForge 1.21.1) | Sim |
| `adapters/*` | Um módulo por mod externo (Mystical Agriculture, AE2, Mekanism, Storage Drawers) | Sim |

Os módulos `mod` e `adapters` serão criados na Fase 0 pela equipe de agentes do projeto.

**Alvo:** NeoForge 1.21.1, com o modpack ATM10 como referência principal. Single player primeiro.

## Segurança e licença

O Simulated Farms usa a licença **GNU LGPL v3.0** ([COPYING.LESSER](COPYING.LESSER), que complementa
a GNU GPL v3.0 em [COPYING](COPYING)). Qualquer versão modificada do mod precisa manter o código aberto.
Os releases são gerados apenas pelo CI público a partir do código marcado com tag, com checksums, para
que qualquer pessoa confira que o jar corresponde ao código. Veja o [SECURITY.md](SECURITY.md) para as
regras de segurança do código e como denunciar código malicioso.

## Como contribuir

Leia o [CONTRIBUTING.md](CONTRIBUTING.md). As contribuições mais valiosas serão **adaptadores** para
outros mods, através de uma API de adaptadores pequena e estável.
