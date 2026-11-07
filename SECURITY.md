# Security Policy / Política de Segurança

**English** · [Português](#português)

Simulated Farms runs inside your game and as a process on your computer, so it must be easy to audit.
The source is open under the LGPL v3.0, and the rules below keep it simple to check that the code does
only what it says.

## Reporting a vulnerability or malicious code

- **Do not open a public issue** for a vulnerability or for suspected malicious code.
- Use GitHub's private reporting: **Security → Report a vulnerability** on this repository.
- Include: affected file or release, what the code does, how to reproduce, and the checksum of the jar
  if it is about a downloaded file.
- Fake or modified jars published outside this repository's Releases page are not ours. Report them
  the same way so we can warn users.

## Safety rules the code follows

Every pull request is checked against these rules. A change that breaks one is rejected.

1. **No network access.** The mod and the daemon do not open sockets or make HTTP requests. Any future
   feature that needs the network (for example, phone notifications) must be opt-in, off by default,
   documented, and reviewed on its own.
2. **Limited file access.** The daemon reads and writes only inside `<world>/simulated-farms/`. It never
   opens region files or `level.dat`. Only the mod changes inventories, through the game's own APIs, with
   the game open.
3. **No hidden code.** No obfuscation, no downloading or loading code at runtime, no `Runtime.exec` or
   `ProcessBuilder`, no native libraries. What you read in this repository is what runs.
4. **Few, pinned dependencies.** Every dependency has a fixed version and a reason recorded in
   `docs/decisoes/`. Gradle dependency verification will be enabled in Phase 0.
5. **Reproducible releases.** Releases are built only by GitHub Actions from a tagged commit, and each
   release lists the SHA-256 checksum of its files.
6. **Same rules for adapters.** Community adapters follow every rule above and get the same review.

## How to check a release yourself

1. Download the jar only from this repository's Releases page.
2. Compare its SHA-256 with the one listed in the release (`sha256sum <file>` on Linux,
   `Get-FileHash <file>` in PowerShell).
3. Or build it yourself from the same tag: `./gradlew build`.

## Supported versions

The project is pre-alpha. Only the latest commit on `main` receives fixes.

---

## Português

[English](#security-policy--política-de-segurança) · **Português**

O Simulated Farms roda dentro do seu jogo e como um processo no seu computador, então precisa ser fácil
de auditar. O código é aberto sob a LGPL v3.0, e as regras abaixo facilitam conferir que ele faz só o
que diz.

## Como denunciar uma vulnerabilidade ou código malicioso

- **Não abra uma issue pública** para vulnerabilidades ou suspeita de código malicioso.
- Use a denúncia privada do GitHub: **Security → Report a vulnerability** neste repositório.
- Inclua: arquivo ou release afetado, o que o código faz, como reproduzir e o checksum do jar, se for
  sobre um arquivo baixado.
- Jars falsos ou modificados publicados fora da página de Releases deste repositório não são nossos.
  Denuncie do mesmo jeito para avisarmos os usuários.

## Regras de segurança que o código segue

Todo pull request é conferido contra estas regras. Uma mudança que quebra alguma é recusada.

1. **Sem acesso à rede.** O mod e o daemon não abrem sockets nem fazem requisições HTTP. Qualquer
   recurso futuro que precise de rede (por exemplo, notificações no celular) deve ser opcional,
   desligado por padrão, documentado e revisado separadamente.
2. **Acesso a arquivos limitado.** O daemon só lê e grava dentro de `<mundo>/simulated-farms/`. Ele nunca
   abre os arquivos de região nem o `level.dat`. Só o mod altera inventários, pelas APIs do próprio jogo,
   com o jogo aberto.
3. **Nenhum código escondido.** Sem ofuscação, sem baixar ou carregar código em tempo de execução, sem
   `Runtime.exec` ou `ProcessBuilder`, sem bibliotecas nativas. O que você lê neste repositório é o que
   roda.
4. **Poucas dependências, com versão fixa.** Cada dependência tem versão fixa e um motivo registrado em
   `docs/decisoes/`. A verificação de dependências do Gradle será ativada na Fase 0.
5. **Releases reproduzíveis.** Os releases são gerados apenas pelo GitHub Actions a partir de um commit
   com tag, e cada release lista o checksum SHA-256 dos seus arquivos.
6. **Mesmas regras para adaptadores.** Adaptadores da comunidade seguem todas as regras acima e passam
   pela mesma revisão.

## Como conferir um release você mesmo

1. Baixe o jar somente da página de Releases deste repositório.
2. Compare o SHA-256 dele com o listado no release (`sha256sum <arquivo>` no Linux,
   `Get-FileHash <arquivo>` no PowerShell).
3. Ou gere o jar você mesmo a partir da mesma tag: `./gradlew build`.

## Versões com suporte

O projeto está em pré-alfa. Só o commit mais recente da branch `main` recebe correções.
