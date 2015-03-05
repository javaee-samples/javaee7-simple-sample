A simple Java EE 7 Sample
=========================

This is a trivial Java EE 7 sample.

. Download WildFly 8.2 from
  http://download.jboss.org/wildfly/8.2.0.Final/wildfly-8.2.0.Final.zip
  and unzip.
. Start WildFly as: `./bin/standalone.sh`
. Deploy application WAR to WildFly: `mvn wildfly:deploy`
. Install to local Maven repository: `mvn install`
.. repo in '~/.m2/repository'
. Deploy SNAPSHOT version to local Nexus
.. Only binary: `mvn deploy`
.. Binary, including javadoc and sources jars: `mvn deploy -P release`
. Perform RELEASE : `mvn release:prepare release:perform`
.. versions changes and tag are committed to github
.. all tests run
.. WAR is deployed to Wildfly
.. deployment to local Nexus including WAR, javadoc and sources
. Alternatively to deploy RELEASE version (e.g. 2.0) to Nexus without GitHub integration
.. `mvn versions:set -DnewVersion=2.0`
.. `mvn deploy -P release`

