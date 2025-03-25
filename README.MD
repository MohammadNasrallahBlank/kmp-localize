# kmp-localize

Kotlin Multiplatform Library

### Run Sample App

 - JavaScript: `./gradlew :sample:composeApp:jsBrowserRun`

### Publish to MavenLocal

1) Run `./gradlew :localize:publishToMavenLocal`
2) Open `~/.m2/repository/io/blank/kmplocalize/"}`

### Publish to MavenCentral

1) Create a account and a namespace on Sonatype:
   https://central.sonatype.org/register/central-portal/#create-an-account
2) Add developer id, name, email and the project url to
   `/convention-plugins/src/main/kotlin/convention.publication.gradle.kts`
3) Generate a GPG key:
   https://getstream.io/blog/publishing-libraries-to-mavencentral-2021/#generating-a-gpg-key-pair
   ```
   gpg --full-gen-key
   gpg --keyserver keyserver.ubuntu.com --send-keys XXXXXXXX
   gpg --export-secret-key XXXXXXXX > XXXXXXXX.gpg
   ```
4) Add the secrets to `local.properties`:
   ```
   signing.keyId=XXXXXXXX
   signing.password=[key password]
   signing.secretKeyRingFile=../XXXXXXXX.gpg
   ossrhUsername=[Sonatype token_user]
   ossrhPassword=[Sonatype token_password]
   ```
5) Run `./gradlew :localize:publishAllPublicationsToSonatypeRepository`
