#!/bin/bash
function psh(){


	# Process for Github - push
	rm h.html
	rm index.html
	rm custom.css
	bash deleteclass.sh
	rm run
	echo "Enter Message :"
	read mssg
	dt=$(date)
	echo "$dt"
	if [ -z "$mssg" ] 
	then  
		echo "message cannot be empty" 
	else 	
		git add .
		git commit -m"${mssg} | $dt "
		git push
		echo "Pushed to DesignPatterns Repository 😊" 
	fi 
}


psh