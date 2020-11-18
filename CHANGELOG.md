## Change log
----------------------

Version 1.2-SNAPSHOT
-------------

ADDED:
 
- new build system gradle
- new enum DatePattern that holds several date patterns
- new class ConvertTimestampExtensions that provides methods for convert new java-time api object to Timestamp
- added new test-dependency junit-jupiter (junit 5) in version 5.7.0

CHANGED:

- changed project nature from maven to gradle nature
- removed lombok dependency
- removed all lombok dependent imports
- extracted project properties to gradle.properties
- extracted project gradle plugin versions to buildscript.ext area in gradle.properties
- remove of test-dependency testng 
- update of com.github.ben-manes.versions.gradle.plugin to new version 0.36.0

Version 1.1
-------------

ADDED:
 
- new methods for compute several states of an Interval created

CHANGED:

- update of threeten-extra dependency version to 1.5.0
- update of javadoc. Added graphical scenarios for better understanding the methods

Version 1
-------------

ADDED:
 
- this changelog file
- created PULL_REQUEST_TEMPLATE.md file
- created CODE_OF_CONDUCT.md file
- created CONTRIBUTING.md file
- provide package.html for the javadoc of packages

CHANGED:

- update of parent version
- update of documentation of README.md 
- unit tests extended for improve code coverage


