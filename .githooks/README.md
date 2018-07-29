# Configure Git hooks

To configure the new .githooks repository, you have to change the git configuration (Git 2.9 or greater) :
```
$ git config core.hooksPath .githooks
```

You will also need to disable the auto-conversion to CRLF
```
$ git config core.autocrlf false
```