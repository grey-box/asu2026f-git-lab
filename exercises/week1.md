# Week 1 — The Commit Cycle

**Goal:** get comfortable with the everyday loop: clone, branch, edit, add,
commit, push, open a PR. Everything here uses an independent file — nothing
you do blocks anyone else.

## Git katas (solo, ~40 min, any time Mon–Thu)

Run these from your local clone of `eficode-academy/git-katas`. Each kata
lives in its own folder; enter it and run:

- bash/macOS/Linux: `source setup.sh`
- Windows PowerShell: `.\setup.ps1`

| # | Kata | Folder | What it teaches |
|---|------|--------|-----------------|
| 1 | Configure Git | `configure-git` | name, email, editor setup |
| 2 | Basic Commits | `basic-commits` | add, commit, status, log |
| 3 | Basic Staging | `basic-staging` | the staging area, diff, unstaging |

These are a self-check more than a lesson — if one feels routine, move on.

## Kotlin Koans (solo, ~1 hr)

In your branch of `grey-box/kotlin-koans` (`koans/<username>/wk1`), complete
the **Introduction** section, six tasks:

Lambdas · Default arguments · Named arguments · Nullable types · Nothing
type · String templates

One commit per solved task. Verify with `./gradlew :Introduction-Lambdas:test`
(swap in the section name of whatever you're testing) or run the whole suite
with `./gradlew test`. Push and open a PR **into `master` of the koans fork**
when the week's set is done — it will be reviewed, not merged.

## Apply exercise (this repo)

1. Create a branch: `git switch -c week1/<username>`
2. Add a file `students/<username>.md` containing: your name, your background
   (major, languages you know), and one fun fact.
3. Commit with a meaningful message, push, and open a PR into `main`.
4. In the Friday sync we review everyone's PRs and merge them together.

## Done when

- [ ] 3 katas complete
- [ ] 6 koans committed and PR open in the koans fork
- [ ] PR open here with your `students/<username>.md`
- [ ] You can do `git status` → `git add` → `git commit` → `git push` from memory
- [ ] You can explain: staging area, commit, branch
