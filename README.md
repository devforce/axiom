# Axiom
Axiom is a web-based suite of tools for learning, testing, and troubleshooting single sign-on solutions for Salesforce.com,
available at <https://trlhd-axiomsso-prod.herokuapp.com>. 
The tools include:

 * SAML Identity Provider & Tester
 * Token-Based Authentication
 * Self Authentication Service
 * OAuth Tester

## Deployment

The canonical instance of Axiom is running at <https://trlhd-axiomsso-prod.herokuapp.com>,
but you can easily create your own instance on Heroku, 
which is helpful for forks or other experimentation:

[![Deploy to Heroku](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy?template=https://github.com/devforce/axiom)

## Development

To install and run Axiom locally with Jetty Runner:

    git clone https://github.com/devforce/axiom
    cd axiom
    mvn clean install
    java $JAVA_OPTS -jar target/dependency/jetty-runner.jar target/*.war

Then go to `http://localhost:8080` in your browser.
