## Change log
----------------------

Version 2.1-SNAPSHOT
-------------

Version 2
-------------

ADDED:

- new date patterns added to the enum DatePatterns

CHANGED:

- update jdk from version 8 to 11

- update of gradle to new version 6.8.3
- update of threeten-extra dependency version to 1.6.0
- update of com.github.ben-manes.versions.gradle.plugin to new version 0.38.0
- removed test dependency silly-collections
- update of test dependency junit-jupiter (junit 5) to new version 5.7.1

Version 1.2
-------------

ADDED:

- new build system gradle
- new enum DatePattern that holds several date patterns
- new class ConvertTimestampExtensions that provides methods for convert new java-time api object to Timestamp
- new class DateExtensions for convert old legacy Date object to new java-time api object
- new class LocalDateTimeExtensions for convert new java-time api object to old legacy Date object
- new class LocalDateExtensions for convert new java-time LocalDate object to old new java.sql.Date
- new class ParseDateExtensions for parse a date String object to the new java-time api objects
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


