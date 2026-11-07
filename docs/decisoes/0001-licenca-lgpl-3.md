# 0001 — License: LGPL-3.0 / Licença: LGPL-3.0

**Status:** accepted / aceita · **Date / Data:** 2026-11-07

## EN

**Context.** The mod runs inside the player's game and the daemon runs as a process on their computer.
Players must be able to check that the code does only what it says, including in forks and modified
versions.

**Decision.** License the project under the GNU LGPL v3.0 only (`LGPL-3.0-only`). Ship `COPYING.LESSER`
and `COPYING` (GPL v3.0, which the LGPL builds on). Every new source file starts with
`// SPDX-License-Identifier: LGPL-3.0-only`.

**Why.** Anyone who distributes a modified version of the mod must also publish its source, so
modified builds stay auditable. Adapters and modpacks can still link against the mod's API.

**Note.** The license makes the code reviewable; it does not stop someone from publishing a malicious
jar elsewhere. That risk is handled by the rules in `SECURITY.md`: releases only from public CI, with
SHA-256 checksums.

**Discarded.** MIT (simpler, but modified versions could close their source); GPL-3.0 (stronger, but
makes linking by other mods harder).

## PT-BR

**Contexto.** O mod roda dentro do jogo do jogador e o daemon roda como processo no computador dele. O
jogador precisa conseguir conferir que o código faz só o que diz, inclusive em forks e versões
modificadas.

**Decisão.** Licenciar o projeto somente sob a GNU LGPL v3.0 (`LGPL-3.0-only`). Distribuir
`COPYING.LESSER` e `COPYING` (GPL v3.0, que a LGPL complementa). Todo arquivo de código novo começa com
`// SPDX-License-Identifier: LGPL-3.0-only`.

**Por quê.** Quem distribuir uma versão modificada do mod precisa publicar o código também, então builds
modificados continuam auditáveis. Adaptadores e modpacks continuam podendo usar a API do mod.

**Observação.** A licença torna o código revisável; ela não impede alguém de publicar um jar malicioso em
outro lugar. Esse risco é tratado pelas regras do `SECURITY.md`: releases só pelo CI público, com
checksums SHA-256.

**Descartadas.** MIT (mais simples, mas versões modificadas poderiam fechar o código); GPL-3.0 (mais
forte, mas dificulta o uso por outros mods).
