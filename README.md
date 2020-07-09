# SealNote Plus

[![MIT licensed](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE.txt)

**PLEASE NOTE THAT WE ARE NOT CURRENTLY ACCEPTING PRs, UNTIL SOME INITIAL REFACTORING WORK IS COMPLETE.**

SealNote Plus is a simple note-taking application developed with both security and simplicity in mind. Your notes are password-protected using 256-bit AES encryption.
Store sensitive information easily without compromising security!

* Password protection (256-bit AES encryption)
* Color-coded notes
* Passwords expire after a configurable timeout
* Your notes are protected from screenshots, the application switcher and other non-secure
  displays
* Simple and easy to use UI
* Multi-column layout
* No ads ever!

Advantages of encrypting notes
-----------------------------

* Keep private information such as credit cards, bank account information and passwords
  in a single place
* Notes are encrypted locally so no one else can access them, unless they
  have the password
* Since encryption is done at the storage level, if you ever lose your phone, you won't lose your
  notes to thieves

Frequently Asked Questions (FAQ)
--------------------------------

#### Why shouldn't I use XYZ app with an application lock?

An application lock prevents users from opening application, but does not secure
any of your data. Any malicious person can access the data stored behind an application lock.

#### Can someone else connect my phone to a computer and copy/read my notes?

No, they can't. No one can, regardless of how they access the data file (unless they
have your password). The application uses a technique called encryption.
Encryption uses your password to convert notes into an unreadable form which makes
no sense to anyone even computer. This can later be decrypted back into readable text
only by using the exact same password the file was encrypted with.

#### I forgot my password. How do I recover my notes?

You can't. Your password is not stored anywhere but in your brain (or preferably written down). If you lose
your password, you will lose all your notes. Storing a password on your device or on a remote
server may allow someone else to find and steal it, giving them full access to your notes.

#### I can't take screenshots in the app. What's wrong?

You probably have enabled the "Secure Window" feature in the SealNote Plus settings.
Disable it if you would like to take screenshots or show window content in the application
switcher.

History
--------------------------------

This project is a fork of the original SealNote codebase, which is no longer maintained. That app is still available on Play Store and F-Droid, but it has serious bugs and is no longer being updated.

SealNote Plus is currently not published on Play Store, but will be in the future, after necessary improvements have been made.

Contributing
--------------------------------

Contributions are much appreciated. Please go through this section to
understand how and what to contribute.

If you need ideas for contribution, please check currently [open
issues](https://github.com/hawknetwork/sealnote-plus/issues). If you want to propose a
new feature, please open a new issue. A good feature can be something which
improves the workflow or security for a user.

### Tools of trade

* Java 1.7+
* Android API Level 19+

### How to submit a pull request

1. Clone sealnote-plus: `git clone https://github.com/hawknetwork/sealnote-plus.git && cd sealnote-plus`
2. Verify that build succeeds: `./gradlew assembleDebug`
3. Create a topic branch: `git checkout -b feature`
4. Make your changes.
5. Fork sealnote-plus on GitHub.
6. Add your fork as remote: `git remote add <YOUR-USER> https://github.com/<YOUR-USER>/sealnote-plus.git`
7. Push to your fork: `git push -u <YOUR-USER> HEAD`
8. Open a pull request against **master** branch describing your changes.

### Style Guide

The project follows [Google's Java Style
Guide](https://google.github.io/styleguide/javaguide.html) with the following
exceptions:

* 4 spaces indentation instead of 2.
* Horizontal alignment is recommended if it makes code more readable.

If you see any violation, feel free to submit a patch.

### Commit guidelines

There is no strict guideline on commit messages. However, whenever possible,
follow [Git-book's](https://git-scm.com/book/ch5-2.html#Commit-Guidelines)
 guidelines.

### Documentation updates

We value documentation and believe in continuous improvement. All the documents
can be considered living documents, unless stated otherwise. Please follow the
general contribution guidelines when submitting a patch for documents.

Contact
-------

Please raise an issue on GitHub if you find any bugs.
