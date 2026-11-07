# Contributing / Como contribuir

**English** · [Português](#português)

Thanks for helping. Simulated Farms is pre-alpha, so the structure still changes often. Open an issue to
discuss larger changes before writing code.

## Setup

- Java 21 (Temurin or any OpenJDK 21).
- Build and test: `./gradlew build`.
- Pure-Java modules (`core`, `daemon`) build without Minecraft. The `mod` and `adapters` modules need
  access to the NeoForge Maven repository.

## Ground rules

1. Follow every rule in [SECURITY.md](SECURITY.md). Reviews check them first.
2. **No item is created or lost.** Every stock change must be traceable in the farm graph.
3. `core` never imports Minecraft or NeoForge classes.
4. **No code copied from other mods.** Read their source to understand behavior, then write your own.
   Use only their public APIs. This protects the project's license.
5. Every change comes with tests.

## Commits

- Use [Conventional Commits](https://www.conventionalcommits.org/): `feat:`, `fix:`, `docs:`, `test:`,
  `build:`, `chore:`, `refactor:`.
- Subject line in English, under 72 characters.
- Body with two paragraphs: `EN:` and `PT-BR:`, explaining what changed and why.

## Pull requests

- One topic per pull request.
- Fill in the pull request template, including the security checklist.
- CI must pass. A maintainer review is required before merge.

## License of contributions

By contributing, you agree that your contribution is licensed under the GNU LGPL v3.0, the same license
as the project.

## AI agents

The repository includes a team of Claude Code agents (`CLAUDE.md` and `.claude/agents/`). Humans and
agents follow the same rules and the same review.

---

## Português

[English](#contributing--como-contribuir) · **Português**

Obrigado por ajudar. O Simulated Farms está em pré-alfa, então a estrutura ainda muda com frequência.
Abra uma issue para discutir mudanças maiores antes de escrever código.

## Ambiente

- Java 21 (Temurin ou qualquer OpenJDK 21).
- Build e testes: `./gradlew build`.
- Os módulos em Java puro (`core`, `daemon`) compilam sem o Minecraft. Os módulos `mod` e `adapters`
  precisam de acesso ao repositório Maven do NeoForge.

## Regras básicas

1. Siga todas as regras do [SECURITY.md](SECURITY.md). A revisão confere essas regras primeiro.
2. **Nenhum item é criado ou perdido.** Toda mudança de estoque precisa ser rastreável no grafo das farms.
3. O `core` nunca importa classes do Minecraft ou do NeoForge.
4. **Nenhum código copiado de outros mods.** Leia o código deles para entender o comportamento e escreva
   o seu. Use apenas as APIs públicas. Isso protege a licença do projeto.
5. Toda mudança vem acompanhada de testes.

## Commits

- Use [Conventional Commits](https://www.conventionalcommits.org/pt-br/): `feat:`, `fix:`, `docs:`,
  `test:`, `build:`, `chore:`, `refactor:`.
- Linha de assunto em inglês, com menos de 72 caracteres.
- Corpo com dois parágrafos: `EN:` e `PT-BR:`, explicando o que mudou e por quê.

## Pull requests

- Um assunto por pull request.
- Preencha o template de pull request, incluindo o checklist de segurança.
- O CI precisa passar. A revisão de um mantenedor é obrigatória antes do merge.

## Licença das contribuições

Ao contribuir, você concorda que sua contribuição é licenciada sob a GNU LGPL v3.0, a mesma licença do
projeto.

## Agentes de IA

O repositório inclui uma equipe de agentes do Claude Code (`CLAUDE.md` e `.claude/agents/`). Pessoas e
agentes seguem as mesmas regras e passam pela mesma revisão.
