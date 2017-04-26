#DemoTwine

The strings of this project are in a submodule in the following repository: https://github.com/dtvcfinc/demoStrings.

# How to set up

Install twine.

	$ gem install twine

Clone this repository.

	$ git clone https://github.com/dtvcfinc/demoTwine.git
  
Init submodule and update:

    $ git submodule init
    $ git submodule update
  
Generate a new .po translation.

	$ cd demoStrings
	$ twine generate-localization-file demo.ini spanish.po --lang es
  
Install Poedit, then open the *.po file with Poedit, translate some strings and save.

	$ sudo apt-get install poedit
 
Update the .ini with the new translations 

	$ twine generate-localization-file demo.ini spanish.po --lang es

Commit the changes in demo.ini and update the submodule

Compile and the strings should be there :)
