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

The remaining five of the **Collections** core, in order: Fold and reduce ·
Associate · All Any and other predicates · Getting used to new style ·
Compound tasks

(The core set is thirteen tasks total — eight in week 2, these five now.
`Sequences` and the Builders/Conventions/Generics sections are intentionally
out of scope for this course.)

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
git merge origin/main            # resolve, then `git commit` to conclude the merge
# fix the <<<<<<< ======= >>>>>>> markers in your editor
git add docs/TeamNotes.md
git commit
```

(Rebase — `git rebase origin/main` / `git rebase --continue` — is an equally
valid style; we teach it after the course. Merge is what week 2 covered, so
lead with it.)

Do **not** edit other people's entries to resolve a conflict — keep their
text, keep your text, arrange both. In the Friday sync we walk through every
conflicted PR as a group before merging.

## Done when

- [ ] 4 katas complete (2 of them conflict resolutions)
- [ ] 7 koans committed, PR open in the fork
- [ ] Your TeamNotes PR has its conflicts resolved and merged
- [ ] You can explain: conflict markers, your resolution strategy, when to stash
