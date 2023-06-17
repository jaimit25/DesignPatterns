
#!/bin/bash

bash deleteclass.sh
# Function to compile Java files recursively
function compile_files() {
  local directory=$1
  for file in "$directory"/*; do
    if [[ -d $file ]]; then
      compile_files "$file" # Recursively compile files in subdirectories
    elif [[ $file == *.java ]]; then
      echo "Compiling: $file"
      javac "$file"
    fi
  done
}

# Compile Java files
current_directory=$(pwd)
compile_files "$current_directory"


# java ducksimulationapp.DuckSimApp


