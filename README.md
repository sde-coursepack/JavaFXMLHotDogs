# JavaFXMLHotDogs

This is a silly little app designed to show a few JavaFX things:

1) An app with multiple scenes, as well as Scene Switching
2) Showing movement of information between Controllers when switching scenes
3) Storing data in a database
4) Three-layer architectural design



## Java and JFX version information

First, you need to install JavaFX. Specifically, for this app, I am using Java 17.0.9 and JavaFX 17.0.9, but this app should work with any *later* version.

### Java 17.0.9

https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html

### JavaFX

Can be downloaded here: https://gluonhq.com/products/javafx/

Make sure to select 17.0.9 LTS from the Version dropdown

When install JavaFX, note where it is installed. Specifically, you can follow the install instructions here:

https://openjfx.io/openjfx-docs/#install-javafx 

Specifically, it is highly recommended to set an environment variable called "PATH_TO_FX", as the VM arguments shown below use that.

## To Run

Run HotDogVotesApplication with the following **VM Arguments**

**Mac/Linux**
--module-path $PATH_TO_FX --add-modules javafx.controls,javafx.fxml

**Windows**
--module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml

