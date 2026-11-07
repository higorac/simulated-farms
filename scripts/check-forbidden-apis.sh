#!/usr/bin/env bash
# SPDX-License-Identifier: LGPL-3.0-only
#
# EN: Fails if production code uses APIs forbidden by SECURITY.md (network, process execution,
#     native code, dynamic code loading). Runs in CI on every push and pull request.
# PT-BR: Falha se o código de produção usar APIs proibidas pelo SECURITY.md (rede, execução de
#     processos, código nativo, carregamento dinâmico de código). Roda no CI em todo push e pull request.
#
# Usage / Uso: scripts/check-forbidden-apis.sh [repository root]

set -euo pipefail

root="${1:-$(cd "$(dirname "$0")/.." && pwd)}"

patterns=(
  'java\.net\.'
  'HttpClient'
  '\bSocket\b'
  'ServerSocket'
  'ProcessBuilder'
  'Runtime\.getRuntime\(\)\.exec'
  'System\.load(Library)?\('
  'URLClassLoader'
  'defineClass\('
  'ScriptEngine'
)

regex="$(IFS='|'; echo "${patterns[*]}")"

mapfile -t sources < <(find "$root" -path '*/src/main/*' -name '*.java' -not -path '*/build/*' | sort)

if [ "${#sources[@]}" -eq 0 ]; then
  echo "No production sources found / Nenhum código de produção encontrado."
  exit 0
fi

if matches="$(grep -HnE "$regex" "${sources[@]}")"; then
  echo "Forbidden APIs found (see SECURITY.md) / APIs proibidas encontradas (veja o SECURITY.md):"
  echo "$matches"
  exit 1
fi

echo "OK: ${#sources[@]} production files checked, no forbidden APIs / nenhuma API proibida."
