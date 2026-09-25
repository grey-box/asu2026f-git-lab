# asu2026f-git-lab

Git and Kotlin Koans training exercises for the ASU2026F intern team.

## What this repo is for

This is the working repo for the Project Mesh ASU2026F cohort's Git + Kotlin
training track. Team members work through exercises on their own branches,
open pull requests, and get them reviewed — this repo is where PRs get
merged, unlike the koans fork where branches are reviewed but never merged.

## Contents

- **Git exercises** — from the [eficode git-katas](https://github.com/eficode-academy/git-katas) collection (run fully locally; no remote needed).
- **Kotlin Koans** — from [kotlin-koans-edu](https://github.com/Kotlin/kotlin-koans-edu), completed in the team fork [grey-box/kotlin-koans](https://github.com/grey-box/kotlin-koans). Solve them in Android Studio or any editor you like; verify with `./gradlew test` (no EduTools plugin needed).
- **`app/`** — a small Kotlin app used for the Week 4 feature exercise. Builds with `./gradlew build` from inside `app/`. Week 2's utility-function exercise (including its JUnit tests) also lives here, under `src/main/kotlin/utils/<username>/`.
- **`exercises/`** — the weekly apply-exercise instructions (weeks 1–4).
- **`students/`** — one intro file per student (Week 1 target).

## How to work here

1. Create a branch for your work, named `week<N>/<your-username>` (one branch per week's apply exercise):
   `git switch -c week1/<your-username>`
2. Do the exercise, commit as you go with meaningful messages.
3. Push and open a pull request into `main` — a PR template will guide you.
4. A lead (or a peer, later in the course) reviews; address feedback, then it merges.

Questions? Ask in the team channel — paste the exact command you ran and the
full error text (copy-paste, not a screenshot).
