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

# Prompt the user to select the project or folder to compile
read -p "Enter the project or folder path to compile: " project_folder

# Navigate to the parent folder of the project
cd "$(dirname "$project_folder")" || exit

# Compile Java files
compile_files "$(basename "$project_folder")"

# java ducksimulationapp.DuckSimApp


