# Environment Setup — Git + Kotlin (ASU2026F)

One-time setup so you can run Git katas locally and verify Kotlin Koans with
`./gradlew test`. Works on macOS, Windows, and Linux. Budget ~30–45 minutes.

**What you're installing:** a JDK (Java is what Gradle runs on), Git, and
GitHub access. Kotlin itself needs no separate install — the Gradle wrapper
in each repo downloads and manages it automatically.

---

## 1. Install a JDK

You need **JDK 17 or 21** (21 is what the team machines run; both work with
our Gradle 8.10.2 setup).

### macOS
```bash
brew install --cask temurin@21
```
(or download the `.pkg` from [adoptium.net](https://adoptium.net/temurin/releases/?version=21))

### Windows
Download and run the `.msi` from
[adoptium.net](https://adoptium.net/temurin/releases/?version=21) (choose
"Set JAVA_HOME" and "Add to PATH" options during install).

### Linux (Debian/Ubuntu)
```bash
sudo apt update && sudo apt install -y openjdk-21-jdk
```
(Fedora: `sudo dnf install java-21-openjdk-devel`)

### Verify
Close and reopen your terminal, then:
```bash
java -version
```
You should see something like `openjdk version "21.0.x"`. If the command is
not found on Windows, re-run the MSI and check "Add to PATH", or add
`C:\Program Files\Eclipse Adoptium\jdk-21.x.x-hotspot` to PATH manually.

---

## 2. Install Git and set your identity

### Install
- **macOS:** `brew install git` — or just `git --version`, which offers the
  Apple command-line tools.
- **Windows:** [git-scm.com/download/win](https://git-scm.com/download/win) —
  default options are fine.
- **Linux:** `sudo apt install git` (or your distro's package manager).

### Identity (everyone)
Set these to the **name and email you use on GitHub** — commits made with a
different email won't be attributed to you:
```bash
git config --global user.name "Your Name"
git config --global user.email "you@example.com"
git config --global init.defaultBranch main
```

### Line endings — set this ONCE, per OS
Repos here carry a `.gitattributes` that forces LF in the working tree, so
choose the *recommended* setting for your OS; the repo file overrides Git's
default for these repos either way:

- **macOS / Linux:**
  ```bash
  git config --global core.autocrlf input
  ```
- **Windows:**
  ```bash
  git config --global core.autocrlf true
  ```

### Verify
```bash
git --version
git config --global user.name
git config --global user.email
```

---

## 3. Authenticate with GitHub

You need this to **push** and **open PRs**. (Cloning the two course repos
works without auth — they're public.)

The course tasks use **SSH keys**: you create a key pair on your machine,
upload the *public* half to GitHub once, and GitHub then trusts your machine
with no passwords. The full walkthrough (with a diagram of how the key
exchange works) is in your **"Set up your OS for Git and Kotlin"** Notion
task — the short version:

```bash
ssh-keygen -t ed25519 -C "your GitHub email"   # accept defaults
cat ~/.ssh/id_ed25519.pub                       # copy this whole line
```

Add it at github.com → Settings → SSH and GPG keys → **New SSH key**, then:

```bash
ssh -T git@github.com
# → "Hi <your-username>! You've successfully authenticated."
```

Never share the private key file (`id_ed25519`, no `.pub` extension).

*Alternative:* if you prefer HTTPS, `gh auth login` (the
[GitHub CLI](https://cli.github.com/)) sets up credentials for you — either
works. Repos below are cloned over SSH to match the course tasks.

---

## 4. Clone the two course repos

```bash
mkdir -p ~/mesh && cd ~/mesh
git clone git@github.com:grey-box/kotlin-koans.git
git clone git@github.com:grey-box/asu2026f-git-lab.git
```

- **koans** = where you solve Kotlin Koans, on your own branch
  `koans/<username>/wkN`.
- **lab** = where weekly apply exercises live; branches `week<N>/<username>`
  here **do** get merged.

### Verify
```bash
ls ~/mesh/kotlin-koans/Introduction   # should list several .kt files
ls ~/mesh/asu2026f-git-lab/exercises  # week1.md … week4.md
```

Windows note: `~` doesn't expand in the default `cmd` prompt — use Git Bash
(installed with Git) or PowerShell, where `~` works.

---

## 5. Verify the toolchain: run the Koans tests

This is the real end-to-end check: Gradle will download itself, then Kotlin,
then compile and run the Koans test suite. First run downloads a few hundred
MB — be patient.

```bash
cd ~/mesh/kotlin-koans
./gradlew test
```

- **macOS/Linux:** use `./gradlew test` exactly as shown.
- **Windows (cmd):** `gradlew.bat test`
- **Windows (PowerShell):** `.\gradlew.bat test`

### Expected result
The koans start **unsolved**, so the run ends with:

```
BUILD FAILED
```

...plus a list of failing tests like `i_introduction._0HelloWorld`. That's
correct — it proves the toolchain works. (This follows the repo README:
you'll see `build failed` until you solve koans, one section at a time.)

As you solve koans through the course, the failure list shrinks; the target
at the end of each week is all of that week's koans passing.

### Also verify the lab repo builds
```bash
cd ~/mesh/asu2026f-git-lab/app
./gradlew build        # Windows: gradlew.bat build
```
This should end with `BUILD SUCCESSFUL` — the skeleton app has no failing
work in it.

If either command fails with `JAVA_HOME is not set` or `No Java runtime
present`, revisit step 1 (reinstall with the PATH/JAVA_HOME options, then
reopen your terminal). For anything else, post the output in the team
channel.

---

## Checklist (all four = done)

- [ ] `java -version` → 17 or 21
- [ ] `git config --global user.name` / `user.email` → your GitHub identity
- [ ] `ssh -T git@github.com` → "Hi <your-username>!"
- [ ] Both repos cloned under `~/mesh/`, and `./gradlew test` in koans fails
      *only* with unsolved-koan test failures (toolchain OK)

When you're done, tick your setup task on the Notion board and drop a ✅ in
the team channel.
