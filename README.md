# SealNote Plus

[![MIT licensed](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE.txt)

SealNote Plus is a simple notes/notepad application which focuses on security and
simplicity. Your notes are password protected using 256-bit AES encryption.
Keep sensitive information always available without compromising security!

* Password protection (256-bit AES encryption)
* Color code your notes
* Password expires after configurable timeout
* Protect content from screenshots, window switcher and other non-secure
  displays
* Multi-column layout with number of columns optimized for your screen size.
* Simple and easy to use UI/UX
* No ads ever!

Advantage of encrypting notes
-----------------------------

* Keep private information such as credit cards, bank account and passwords
  in a single place
* Notes are encrypted locally so no one else can access them, unless they
  have the password.
* Since encryption is done at storage level, if you ever lose your phone, you won't lose your
  notes to thieves.

Frequently Asked Questions (FAQ)
--------------------------------

#### Why not use XYZ app with application lock?

Application locks prevents user from opening application, but does not secure
the storage. Hence adversary can simply access the storage file directly and
read the content.

#### If someone connects phone to computer and copies/read the data file storingall the notes, can't they read everything?

They can't. No one can, regardless how they access the data file (unless they
have your secret password). The application uses a technique called encryption.
Encryption uses your password to convert notes to unreadable form which makes
no sense to anyone even computer. This can be converted back to readable text
only using exact same password.

#### I forgot my password. How do I recover my notes?

You can't. Your password is not stored anywhere but in your brain. If you lose
your password, you will lose all your notes. Storing password locally or on
server is a security hole which should be avoided.

#### I can't take screenshots from app or I see blank screenshot in application switcher. What's wrong?

You probably have enabled "Secure Window" feature in SealNote Plus settings.
Disable it to be able to take screenshots or show window content in application
switcher.

History
--------------------------------

This project is a fork of the original SealNote codebase, which is no longer maintained. That app is still available on Play Store, but has serious bugs, for example backup is broken on Android 8+.

SealNote Plus is currently not published on Play Store, but will be in future, after necessary improvements have been made.

Contributing
--------------------------------

Contributions are much appreciated. Please go through this section to
understand how and what to contribute.

If you need ideas for contribution, please check currently [open
issues](https://github.com/hawknetwork/sealnote-plus/issues). If you want to propose a
new feature, please open a new issue. A good feature can be something which
improves some workflow or security for a user.

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
Guide](https://google.github.io/styleguide/javaguide.html) with following
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
