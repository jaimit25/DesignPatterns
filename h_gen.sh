#!/bin/bash

OUTPUT_FILE="h.html"
INDENTATION="&nbsp;&nbsp;&nbsp;&nbsp;"

read -p "Enter the project folder (first-level package) path: " PROJECT_FOLDER

generate_package_hierarchy() {
    local file=$1
    local package_name=$2
    local depth=$3

    if [[ -d $file ]]; then
        local sub_package_name="$package_name"
        if [[ $depth -gt 0 ]]; then
            sub_package_name+=".$(basename $file)"
        fi
        echo "$(get_indentation $depth)<i class='fas fa-folder'></i> <span class='folder'>📁 $sub_package_name/</span><br>" >> "$OUTPUT_FILE"

        while IFS= read -r -d '' sub_file; do
            generate_package_hierarchy "$sub_file" "$sub_package_name" $((depth + 1))
        done < <(find "$file" -mindepth 1 -maxdepth 1 -print0)
    elif [[ -f $file && $file == *.java ]]; then
        echo "$(get_indentation $depth)<i class='far fa-file-code'></i> <span class='file'>📄 $(basename $file) (file)</span><br>" >> "$OUTPUT_FILE"
        echo "$(get_indentation $depth)<i class='fas fa-boxes'></i> <span class='package'>package $package_name</span><br>" >> "$OUTPUT_FILE"
    fi
}


get_indentation() {
    local depth=$1
    local indentation=""
    for ((i = 0; i < depth; i++)); do
        indentation+="$INDENTATION"
    done
    echo -ne "$indentation"
}

# Download Bootstrap CSS and Font Awesome CSS
wget -q https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css -O bootstrap.min.css
wget -q https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css -O font-awesome.min.css

# Create custom CSS file
cat <<EOT >> custom.css
body {
    background-color: black;
    color: #FFFFFF;
    padding: 20px;
    line-height: 1.5;
}

h1 {
    color: #FFFFFF;
    margin-bottom: 20px;
}

.folder {
    color: red;
}

.file {
    color: yellow;
}

.package {
    color: #27AE60;
}
EOT

echo "<html>" > "$OUTPUT_FILE"
echo "<head>" >> "$OUTPUT_FILE"
echo "<link rel='stylesheet' href='bootstrap.min.css'>" >> "$OUTPUT_FILE"
echo "<link rel='stylesheet' href='font-awesome.min.css'>" >> "$OUTPUT_FILE"
echo "<link rel='stylesheet' href='custom.css'>" >> "$OUTPUT_FILE"
echo "</head>" >> "$OUTPUT_FILE"
echo "<body>" >> "$OUTPUT_FILE"

echo "<h1>Package Hierarchy</h1>" >> "$OUTPUT_FILE"

generate_package_hierarchy "$PROJECT_FOLDER" "$PROJECT_FOLDER" 0

echo "</body>" >> "$OUTPUT_FILE"
echo "</html>" >> "$OUTPUT_FILE"

echo "Package hierarchy generated successfully in $OUTPUT_FILE!"


# | - current folder 
# 	| - ducksimulationapp 
# 		| - ducksimAbstractClass
# 			| - fly.java
# 			| - quack.java
# 			| - ducksimImpl
# 				| - Mallardduck.java
# 				| - Modelduck.java
# 		| - Main.java
# 	.....More Projects....

# example (Output): 

# 	Enter Project for which You want to Generate Ouptut : ducksimulationapp

# 	___h.html (file)___
# 	package ducksimulationapp
# 		package ducksimAbstractClass
# 			package ducksimImpl
	