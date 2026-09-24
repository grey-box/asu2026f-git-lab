# Week 4 — Undo, Clean History, Wrap-Up

**Goal:** finish like a professional — fix mistakes properly (amend, revert,
bisect), keep history clean, run a real PR to merge on the `app/` skeleton,
and look back at the month.

## Git katas (solo, ~40 min)

| # | Kata | Folder | What it teaches |
|---|------|--------|-----------------|
| 1 | Amend | `amend` | fix the last commit without a new one |
| 2 | Bisect | `bisect` | binary-search history to find the commit that broke something |
| 3 | Merge Conflict (final) | `merge-conflict` | confidence check — routine now |

## Kotlin Koans (solo, ~1.5 hrs)

Finish **Classes** (three): Smart casts · Sealed classes · Rename on import

Then **Properties** (two): Lazy property · Properties

Branch: `koans/<username>/wk4`. This completes the assigned 24 — Builders,
Conventions and Generics remain as self-serve stretch material.

## Apply exercise (this repo)

1. Branch: `git switch -c week4/<username>`
2. You'll each be **assigned** one small feature for the `app/` skeleton
   (five features, one per intern, in independent files; details in the team
   channel).
3. Requirements:
   - Clean commit history — no "fix typo" commits; amend before pushing
   - PR filled out per the template, including how you tested
   - Approve/review at least one peer's PR
4. After all features merge: verify the app builds — `./gradlew build` in
   `app/`.

### Bonus: bisect hunt

A regression is planted somewhere in `app/`'s history on branch
`bisect-hunt`. `git switch bisect-hunt`, observe the failing behavior, then
use `git bisect` to find the first bad commit. First to find it (with the
commit hash + one-line justification) wins bragging rights.

## Retrospective (Friday sync)

- Which Git skills feel natural now?
- What still feels uncertain?
- Where would each of these show up in a real project?

## Done when

- [ ] 3 katas complete
- [ ] 5 koans committed, PR open in the fork — assigned 24 complete
- [ ] Feature PR merged with clean history
- [ ] `app/` builds after all features merge
- [ ] Retrospective done
