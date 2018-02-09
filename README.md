# Codeship SBT Docker

A sample [Scala](https://www.scala-lang.org/) application, which is released as a [Docker](https://www.docker.com/) image, using [SBT](https://www.scala-sbt.org/) in [Codeship](https://codeship.com/) pipeline.

## Prerequisites

* Install [Docker](https://docs.docker.com/install/)
* Install [jet](https://documentation.codeship.com/pro/jet-cli/installation/)

## Running locally

Put your AWS environment variables in `aws.env`:

    AWS_REGION=us-east-1
    AWS_ACCESS_KEY_ID=??? 
    AWS_SECRET_ACCESS_KEY=??? 

Setup a Codeship project and download [codeship.aes](https://documentation.codeship.com/pro/builds-and-configuration/environment-variables/#downloading-your-aes-key) to the project root directory.

Encrypt the file using `jet encrypt`: 

    jet encrypt aws.env aws.env.encrypted

Run all pipeline steps using `jet`:

    jet steps

**NOTE:** Make sure that `aws.env` and `codeship.aes` are included in `.gitignore` in your target project.
