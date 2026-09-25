# Week 2 — Branches and Merges

**Goal:** branch with intent, merge without fear (fast-forward and 3-way),
and start reviewing each other's code.

## Git katas (solo, ~45 min)

| # | Kata | Folder | What it teaches |
|---|------|--------|-----------------|
| 1 | Basic Branching | `basic-branching` | create, switch, list branches |
| 2 | Fast-Forward Merge | `ff-merge` | ff merge, deleting branches |
| 3 | 3-Way Merge | `3-way-merge` | merging diverged branches |

## Kotlin Koans (solo, ~2 hrs)

Complete the **Collections** core, eight tasks, in this order (they share a
`Shop` model and build on each other):

Introduction · Filter map · Sort · Sum · Max min · GroupBy · Partition ·
FlatMap

Branch: `koans/<username>/wk2`. One commit per task, verify per-task (e.g.
`./gradlew :Collections-Sort:test` — spaces in task names become underscores,
so "Filter map" is `Collections-Filter_map`), PR into `master` of the fork
when done.

## Apply exercise (this repo) — inside `app/`

1. Branch: `git switch -c week2/<username>`
2. You'll each be **assigned** (in the team channel) one collection-style
   function, e.g.: group-by, partition, fold, zip-with-index, dedupe-preserving-order.
3. Implement it in `app/src/main/kotlin/utils/<username>/Utils.kt` **with your
   own unit tests** in `app/src/test/kotlin/utils/<username>/` (JUnit,
   same style as the koans' tests — the `app/` build already has the
   dependency wired).
4. Run your tests: from `app/`, `./gradlew test` (your tests and everyone's
   run together; that's expected).
5. Open a PR. You'll be assigned one peer's PR to review — leave at least one
   constructive comment (something specific: naming, edge case, test gap).
   We're five, so reviews run as a cycle: each person reviews the *next*
   person's PR (wrapping around), which gives every PR exactly one reviewer.
6. PRs merge in the Friday sync.

## Done when

- [ ] 3 katas complete
- [ ] 8 koans committed, PR open in the fork
- [ ] `Utils.kt` + tests PR open here, tests pass under `./gradlew test`, and
      it merges clean
- [ ] ≥1 review comment left on a peer's PR
- [ ] You can explain: branch, merge, fast-forward vs 3-way merge
