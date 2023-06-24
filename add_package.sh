#!/bin/bash

# Get the absolute path of the current directory
current_directory=$(pwd)

# List all the folders in the current directory
folders=()
index=1
echo "Folders in the current directory:"
for folder in */; do
  folders+=("${folder%/}")  # Remove the trailing slash
  echo "$index. ${folder%/}"
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

# Navigate to the project folder
cd "$current_directory/$project_folder" || exit

# Find Java files in the project folder (including subfolders)
java_files=$(find . -type f -name "*.java")

# Check if Java files exist in the folder
if [ -z "$java_files" ]; then
  echo "No Java files found in the folder."
  exit 1
fi

# Determine the base package name based on the project folder
base_package=$(basename "$project_folder")

# Function to generate the package name based on the file's relative path
generate_package_name() {
  local file=$1
  local relative_path=${file#./}
  local subfolder=${relative_path%/*}
  local package_name="$base_package"

  if [ "$subfolder" != "." ]; then
    package_name+=".$(echo "$subfolder" | tr / .)"
  fi

  echo "$package_name"
}

# Add package line with the appropriate package name to each Java file
for file in $java_files; do
  temp_file="$file.tmp"
  echo "Adding package line to $file..."
  package_name=$(generate_package_name "$file")
  package_name=${package_name%.java}  # Remove the ".java" extension

  # Check if the file is in the project root folder
  if [ "$(dirname "$file")" == "." ]; then
    package_line="package $base_package;"
  else
    package_line="package $package_name;"
  fi

  echo "$package_line" > "$temp_file"
  tail -n +2 "$file" >> "$temp_file"
  mv "$temp_file" "$file"
done

echo "Package line added successfully to Java files in $project_folder."
