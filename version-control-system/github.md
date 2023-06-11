# GitHub
- [Table of Contents](#table-of-contents)

# Connect VSCode to GitHub
Pre-requisites
1. Ensure that Git is installed on your computer.\
  a. Check from Source control view in VS Code. If you have yet to install Git, it will prompt you to download. 
2. Ensure you have your user.name and user.email configured.\
  a. $ git config --global user.name "John Doe"\
  b. $ git config --global user.email johndoe@example.com
3. Ensure you've installed the following extensions on vscode: \
   a. GitHub Pull Requests and Issues\
   b. GitHub Repositories\
   c. GitHub Codespaces

1. To accessing GitHub through SSH. First generate an SSH key pair; then add the public key to GitHub.\
    a. Generate key pair, github prefers the "Ed25519 algorithm". Go to Git Bash\
    b. $ ssh-keygen -t ed25519 -C "your_email@example.com"\
    c. Locate the hidden .ssh folder and copy the contents in the id_ed25519.pub file (~/.ssh/id_ed25519.pub)
2. In the upper-right corner of GitHub page, click your profile photo, then click Settings.
3. In the "Access" section of the sidebar, click SSH and GPG keys.
4. Click New SSH key or Add SSH key.
5. In the "Title" field, add a descriptive label for the new key. For example, if you're using a personal laptop, you might call this key "Personal laptop".
6. Select the type of key, either authentication or signing. For more information about commit signing, see "About commit signature verification."
7. In the "Key" field, paste your public key.
8. Click Add SSH key.

https://itsfoss.com/vs-code-github/
