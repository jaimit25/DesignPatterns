
#!/bin/bash

# Function to delete class files recursively
function delete_class_files() {
  local directory=$1
  for file in "$directory"/*; do
    if [[ -d $file ]]; then
      delete_class_files "$file" # Recursively delete class files in subdirectories
    elif [[ $file == *.class ]]; then
      echo "Deleting: $file"
      rm "$file"
    fi
  done
}

# Delete class files
current_directory=$(pwd)
delete_class_files "$current_directory"

