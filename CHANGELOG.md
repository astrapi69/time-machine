## Change log
----------------------

Version 2.5-SNAPSHOT
-------------

ADDED:

- new test class for Period

CHANGED:

- removed deprecated methods from all classes
- increase of code coverage

Version 2.4
-------------

ADDED:

- new class DateExtensions for convert Date objects to the new java.time.* classes
- new class XMLGregorianCalendarExtensions for convert Date objects to the new java.time.* classes

CHANGED:

- update of gradle to new version 8.0.1
- update of gradle-plugin dependency 'com.diffplug.spotless:spotless-plugin-gradle' in version 6.15.0
- update of com.github.ben-manes.versions.gradle.plugin to new version 0.46.0
- update of test dependency vintage-time to new version 5.4
- update of test dependency meanbean to new version 3.0.0-M9
- update of test dependency junit-jupiter (junit 5) to new version 5.9.2

Version 2.3
-------------

ADDED:

- new method for convert LocalDate to legacy Date
- new method for convert LocalDateTime with a ZoneId to an OffsetDateTime
- new method for convert LocalDateTime with a ZoneOffset to an OffsetDateTime
- new method for convert OffsetDateTime to a Timestamp
- new method for convert LocalDateTime to a Timestamp
- new method for convert Date with a ZoneId to an OffsetDateTime
- new method for convert Date with a ZoneOffset to an OffsetDateTime

CHANGED:

- update of gradle-plugin dependency 'com.diffplug.spotless:spotless-plugin-gradle' in version 6.11.0

Version 2.2
-------------

ADDED:

- new class Period that consists of a start and an end Instant object that represents a time range

CHANGED:

- update of gradle to new version 7.5.1
- update of gradle-plugin dependency 'com.diffplug.spotless:spotless-plugin-gradle' in version 6.10.0
- removed dependency 'org.threeten:threeten-extra'
- update of test dependency junit-jupiter (junit 5) to new version 5.9.0
- removed classes ConvertTimestampExtensions and DateExtensions and moved methods to the appropriate
  convert classes
- moved all classes that convert Dates and related classes to package 'io.github.astrapi69.time.convert'

Version 2.1
-------------

ADDED:

- new module-info.java file with definition of required modules and packages to export

CHANGED:

- update of gradle to new version 6.9.0
- rename of package enums to enumtype

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
- new class ConvertTimestampExtensions that provides methods for convert new java-time api object to
  Timestamp
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
