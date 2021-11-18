Matt Palmer's code assessment for brightSpark Labs
--------------------------------------------------

Hello.

This is my submission. I chose Java as the language of choice using IntelliJ as my IDE. This is a Maven project and
requires some dependencies which IntelliJ can load for you.

You will need to create a JAR file to execute. You can do this in IntelliJ by going to 'File' - 'Project Structure' -
'Artifacts'. Click the plus button to the right of the left-hand menu. Click JAR and 'From module with dependencies'.
Click on the folder icon alongside the 'Main Class' field and select 'Main' from the list. Under 'Directory for
META-INF/MANIFEST.MF', ensure that the directory structure is written as:

{your_dir}\brightSPARK_top_points\src\main\target. Click 'OK' then click 'Apply'.

To build the jar file, go to 'Build', 'Build Artifacts' and select 'brightSPARK_top_points_jar'.
You will find the JAR file in the out\artifacts\brightSPARK_top_points_jar folder.

In terminal, go this directory. To execute it, type
java - jar brightSPARK_top_points.jar brightspark_csv

I have written the code to match the assessment criteria
* Code style is neat and readable and is accompanied by commenting
* Unit tests are also provided
* I've separated components out of main to keep the code simple and readable
* Various edge cases are handled (for example, incomplete or broken data)
* There is error logging (output is in default.log)
* Deployment should simply involve cloning the repository to a folder on your computer and opening it with IntelliJ

Thanks for your time!

Matt