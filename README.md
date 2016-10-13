Docker image builder for Simplicit&eacute;&reg;
===============================================

This is a Docker&reg; image for Simplicit&eacute;&reg; sandboxes.

Prerequisites
-------------

Have a Java JDK, Apache Maven and Docker installed.

Get the Simplicit&eacute;&reg; `x.y` sandbox template from our GIT repository
(see [simplicite.io website](http://www.simplicite.io) for details on how to get access to this repository)
and copy the `<Simplicit&eacute;&reg; x.y sandbox template location>/app` in this folder as `webapps/ROOT`.

Build image
-----------

Build the Tomcat package using Maven with:

	mvn package

Then build the docker image with:

	sudo docker build -t <image name and tag, e.g. simplicite/sandbox:x.y> .

Run image
---------

Run the image with:

	sudo docker run -it --rm -p 8080:8080 <image name and tag, e.g. simplicite/sandbox:x.y>

Then you can connect on `http://localhost:8080`
