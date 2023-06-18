


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

# List all the folders in the current directory
folders=()
index=1
echo "Folders in the current directory:"
for folder in */; do
  folders+=("$folder")
  echo "$index. $folder"
  ((index++))
done

# Prompt the user to select the project folder
read -p "Enter the number of the project folder: " folder_number

# Validate the folder number
if ((folder_number < 1 || folder_number > index-1)); then
  echo "Invalid folder number. Exiting..."
  exit 1
fi

# Get the selected project folder
project_folder="${folders[$((folder_number-1))]}"
echo "Selected folder: $project_folder"

# Navigate to the parent folder of the project
cd "$(dirname "$project_folder")" || exit

# Prompt the user to select the project or folder to compile
# read -p "Enter the project or folder path to compile: " project_folder

# Navigate to the parent folder of the project
# cd "$(dirname "$project_folder")" || exit

# Compile Java files
compile_files "$(basename "$project_folder")"

# java ducksimulationapp.DuckSimApp





# #!/bin/bash

# bash deleteclass.sh

# # Function to compile Java files recursively
# function compile_files() {
#   local directory=$1
#   for file in "$directory"/*; do
#     if [[ -d $file ]]; then
#       compile_files "$file" # Recursively compile files in subdirectories
#     elif [[ $file == *.java ]]; then
#       echo "Compiling: $file"
#       javac "$file"
#     fi
#   done
# }

# # Prompt the user to select the project or folder to compile
# read -p "Enter the project or folder path to compile: " project_folder

# # Navigate to the parent folder of the project
# cd "$(dirname "$project_folder")" || exit

# # Compile Java files
# compile_files "$(basename "$project_folder")"

# # java ducksimulationapp.DuckSimApp


