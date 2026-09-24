# Week 3 — Merge Conflicts

**Goal:** make conflicts routine — meet them three times in the katas, then
once for real, together, because everyone edits the same file on purpose.

## Git katas (solo, ~50 min)

| # | Kata | Folder | What it teaches |
|---|------|--------|-----------------|
| 1 | Merge Conflict | `merge-conflict` | intentional conflict, manual resolution |
| 2 | Merge Conflict (repeat) | `merge-conflict` | conflicts are not scary |
| 3 | Basic Stashing | `basic-stashing` | stash, switch context, pop |
| 4 | Basic Revert | `basic-revert` | undo a commit safely, no history rewrite |

## Kotlin Koans (solo, ~2 hrs)

Finish **Collections** (five, in order): Fold and reduce · Associate ·
All Any and other predicates · Getting used to new style · Compound tasks

Then start **Classes** (two): Data classes · Extension functions

Branch: `koans/<username>/wk3`. Same commit-per-task + PR pattern.

## Apply exercise (this repo) — the shared-file week

1. Branch: `git switch -c week3/<username>`
2. Edit `docs/TeamNotes.md`: add your entry under **Week 2 observations**
   (a short paragraph on your takeaways so far).
3. Push and open a PR **early in the week** — don't wait for others.

**Conflicts are guaranteed** because everyone touches the same file. Resolve
them like this:

```bash
git fetch origin
git rebase origin/main          # or merge; either is fine, be consistent
# fix the <<<<<<< ======= >>>>>>> markers in your editor
git add docs/TeamNotes.md
git rebase --continue           # or git commit to conclude the merge
```

Do **not** edit other people's entries to resolve a conflict — keep their
text, keep your text, arrange both. In the Friday sync we walk through every
conflicted PR as a group before merging.

## Done when

- [ ] 4 katas complete (3 of them conflict resolutions)
- [ ] 7 koans committed, PR open in the fork
- [ ] Your TeamNotes PR is conflict-free and merged
- [ ] You can explain: conflict markers, your resolution strategy, when to stash
