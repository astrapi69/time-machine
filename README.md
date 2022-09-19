# Overview

<div style="text-align: center">

[![Java CI with Gradle](https://github.com/astrapi69/time-machine/actions/workflows/gradle.yml/badge.svg)](https://github.com/astrapi69/time-machine/actions/workflows/gradle.yml)
[![Coverage Status](https://codecov.io/gh/astrapi69/time-machine/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/time-machine)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/time-machine.svg?style=flat)](https://github.com/astrapi69/time-machine/issues)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/time-machine/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/time-machine)
[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/time-machine.svg)](http://www.javadoc.io/doc/io.github.astrapi69/time-machine)
[![MIT license](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

</div>

Project that provides utility classes for create, convert and compute date objects from the new java-time api

If you like this project put a ⭐ and donate

## Note

No animals were harmed in the making of this library.

# Donations

If you like this library, please consider a donation through
paypal: <a href="https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=B37J9DZF6G9ZC" target="_blank">
<img src="https://www.paypalobjects.com/en_US/GB/i/btn/btn_donateCC_LG.gif" alt="PayPal this" title="PayPal – The safer, easier way to pay online!" border="0" />
</a>

or over bitcoin or bitcoin-cash with:

36JxRRDfRazLNqUV6NsywCw1q7TK38ukpC

or over ether with:

0x588Aa02De98B1Ef70afeDC3ec5290130a3E5e273

or over flattr:
<a href="https://flattr.com/submit/auto?user_id=astrapi69&url=https://github.com/astrapi69/time-machine" target="_blank">
<img src="http://api.flattr.com/button/flattr-badge-large.png" alt="Flattr this" title="Flattr this" border="0" />
</a>

## License

The source code comes under the liberal MIT License, making time-machine great for all types of applications.

## Maven dependency

Maven dependency is now on sonatype. Check
out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~io.github.astrapi69~time-machine~~~) for
latest snapshots and releases.

Add the following maven dependency to your project `pom.xml` if you want to import the core functionality of
time-machine:

Than you can add the dependency to your dependencies:

    <properties>
            ...
        <!-- TIME-MACHINE version -->
        <time-machine.version>2.3</time-machine.version>
            ...
    </properties>
            ...
        <dependencies>
            ...
            <!-- TIME-MACHINE DEPENDENCY -->
            <dependency>
                <groupId>io.github.astrapi69</groupId>
                <artifactId>time-machine</artifactId>
                <version>${time-machine.version}</version>
            </dependency>
            ...
        </dependencies>

## gradle dependency

You can first define the version in the ext section and add than the following gradle dependency to your
project `build.gradle` if you want to import the core functionality of time-machine:

define version in file gradle.properties

```
timeMachineVersion=2.3
```

or in build.gradle ext area

```
ext {
            ...
    timeMachineVersion = "2.3"
            ...
}
```

and than add the dependency to the dependencies area

```
dependencies {
            ...
    implementation("io.github.astrapi69:time-machine:$timeMachineVersion")
            ...
}
```

## Semantic Versioning

The versions of time-machine are maintained with the Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning you can visit
the [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

## Want to Help and improve it? ###

The source code for time-machine are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/time-machine/fork](https://github.com/astrapi69/time-machine/fork)

To share your changes, [submit a pull request](https://github.com/astrapi69/time-machine/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developers

Do not hesitate to contact the time-machine developers with your questions, concerns, comments, bug reports, or feature
requests.

- Feature requests, questions and bug reports can be reported at
  the [issues page](https://github.com/astrapi69/time-machine/issues).

## Similar projects

* [threeten-extra](https://github.com/ThreeTen/threeten-extra) Provides additional date-time classes that complement
  those in JDK 8

## Credits

|**Nexus Sonatype repositories**|
|     :---:      |
|[![sonatype repository](https://img.shields.io/nexus/r/https/oss.sonatype.org/io.github.astrapi69/time-machine.svg?style=for-the-badge)](https://oss.sonatype.org/index.html#nexus-search;gav~io.github.astrapi69~time-machine~~~)|
|Special thanks to [sonatype repository](https://www.sonatype.com) for providing a free maven repository service for open source projects|
|     <img width=1000/>     |

|**javadoc.io**|
|     :---:      |
|[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/time-machine.svg)](http://www.javadoc.io/doc/io.github.astrapi69/time-machine)|
|Special thanks to [javadoc.io](http://www.javadoc.io) for providing a free javadoc documentation for open source projects|
|     <img width=1000/>     |
