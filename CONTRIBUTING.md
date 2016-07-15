# How to contribute
We welcome contributions from the community and are pleased to have them.  Please follow this guide when logging issues or making code changes.

## Logging Issues
All issues should be created using the [new issue form](https://github.com/lob/lob-java/issues/new).  Clearly describe the issue including steps to reproduce if there are any.  Also, make sure to indicate the version of the wrapper that has the issue being reported.

## Patching Code
Code changes are welcome and should follow the guidelines below.

* Fork the repository on GitHub.
* Add tests for your new code ensuring that you have 100% code coverage (we can help you reach 100% but will not merge without it).
    * Run `mvn test` to make sure all tests are still passing. You can see the code coverage report under `target/site/jacoco/index.html`
* [Pull requests](http://help.github.com/send-pull-requests/) should be made to the [master branch](https://github.com/lob/lob-java/tree/master).
