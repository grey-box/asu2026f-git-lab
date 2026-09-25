# Environment Setup — Git + Kotlin (ASU2026F)

One-time setup so you can run Git katas locally and verify Kotlin Koans with
the Gradle wrapper. This guide matches your Notion task **"Set up your OS
for Git and Kotlin"** — use the two together; the Notion task has the fuller
explanations (how the Gradle wrapper works, and how SSH key exchange works).

Budget ~30–45 minutes.

**What you're installing:** a JDK (Java is what Gradle runs on) and Git.
You do **not** install Kotlin or Gradle — the Gradle wrapper (`gradlew`) in
each repo downloads the exact versions the project needs on first run.

---

## 0. Your terminal

- **Mac:** the Terminal app — you're done.
- **Windows:** use **WSL2/Ubuntu**, not native Windows. All course commands
  are written for a Linux-style terminal, and WSL2 gives you the same
  environment as everyone else. Full instructions in the Notion task; short
  version: open PowerShell **as Administrator** → `wsl --install` → restart;
  from then on work in the **Ubuntu** terminal and keep code in `~` (not
  `/mnt/c/...` — the Windows drive, much slower for builds).
- **Linux:** any terminal.

Everything below is identical on macOS and Ubuntu/WSL2.

## 1. Install a JDK (21)

macOS:
```bash
brew install --cask temurin@21   # Homebrew first if needed: https://brew.sh
```
Ubuntu / WSL2:
```bash
sudo apt update && sudo apt install -y openjdk-21-jdk
```

Verify:
```bash
java -version
```
You should see `openjdk version "21.0.x"`. If you get "command not found",
stop and ask in the team channel before continuing.

## 2. Install Git and set your identity

```bash
git --version    # macOS: if missing, accept macOS's install prompt
                 # Ubuntu/WSL2: sudo apt install git
```

Set these to the **name and email you use on GitHub** — commits made with a
different email won't be attributed to you:
```bash
git config --global user.name "Your Name"
git config --global user.email "you@example.com"
git config --global init.defaultBranch main
git config --global core.autocrlf input
```
(`input` is the right autocrlf setting on macOS/Ubuntu; the repos also carry
a `.gitattributes` that pins line endings either way.)

Verify:
```bash
git config --global user.name
git config --global user.email
```

## 3. Authenticate with GitHub (SSH keys)

Full walkthrough is in the Notion task; short version:

```bash
ssh-keygen -t ed25519 -C "your GitHub email"   # Enter to accept defaults
cat ~/.ssh/id_ed25519.pub                       # copy this whole line
```

Add it at github.com → Settings → SSH and GPG keys → **New SSH key**, then:

```bash
ssh -T git@github.com
# → "Hi <your-username>! You've successfully authenticated."
```

(First time, it asks to confirm a fingerprint — type `yes`.) The private
key file (`id_ed25519`, no `.pub` extension) never leaves your machine.

## 4. Clone the two course repos

```bash
mkdir -p ~/mesh && cd ~/mesh
git clone git@github.com:grey-box/kotlin-koans.git
git clone git@github.com:grey-box/asu2026f-git-lab.git
git clone https://github.com/eficode-academy/git-katas.git   # public, no auth needed
```

- **koans** = where you solve Kotlin Koans, on your own branch
  `koans/<username>/wkN`.
- **lab** = where weekly apply exercises live; branches `week<N>/<username>`
  here **do** get merged.
- **git-katas** = the drill collection for the weekly kata exercises; run
  locally only, never pushed anywhere.

## 5. Verify the toolchain

```bash
cd ~/mesh/kotlin-koans
./gradlew --version
```
The first run downloads Gradle — a few minutes. **Don't cancel it.**

Success = it prints `Gradle 8.10.2` and a JVM line showing your Java
version. This is the pass criterion in your Notion task.

### Deeper check (recommended once): run the Koans test suite

```bash
./gradlew test
```
The koans start **unsolved**, so this ends in `BUILD FAILED` with a list of
failing tests like `i_introduction._0HelloWorld`. That is the *correct*
result — it proves compilation and the test runner work. As you solve each
week's koans, the failure list shrinks; the target at each week's end is
that week's sections passing.

### Lab repo sanity check
```bash
cd ~/mesh/asu2026f-git-lab/app
./gradlew build
```
Ends in `BUILD SUCCESSFUL` — nothing in the skeleton is broken.

If `gradlew` complains about Java (`JAVA_HOME is not set`, `No Java runtime
present`), revisit step 1 and reopen your terminal. For anything else, post
the exact command you ran and the full error text (copy-paste, not a
screenshot) in the team channel.

---

## Checklist (all five = done)

- [ ] `java -version` → 21.x
- [ ] `git config --global user.name` / `user.email` → your GitHub identity
- [ ] `ssh -T git@github.com` → "Hi <your-username>!"
- [ ] All three repos cloned under `~/mesh/`
- [ ] `./gradlew --version` in koans → `Gradle 8.10.2` + Java 21

When you're done, set your setup task on the Notion board to `Done` and drop
a ✅ in the team channel.
