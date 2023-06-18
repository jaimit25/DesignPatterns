#!/bin/bash

# Function to recursively generate file details in HTML format
generate_details() {
  local directory=$1
  local indent=$2
  local color=$3

  # Get folder name
  local folder_name=$(basename "$directory")

  # Start folder section with a unique class
  local folder_class=$(echo "$directory" | tr '/' '-')
  echo "${indent}<div class='folder $folder_class' style='color: $color;'>📁 $folder_name</div>"

  # Start file list section
  echo "${indent}<ul>"

  # List important files in the current folder
  local files=$(find "$directory" -maxdepth 1 \( ! -iname ".*" ! -name "index.html" \) -type f)
  for file in $files; do
    local file_name=$(basename "$file")
    local file_type=$(file -b "$file" | cut -d ' ' -f 1)
    echo "${indent}  <li class='file'>$file_name ($file_type)</li>"
  done

  # Recursively generate details for subfolders
  local subfolders=$(find "$directory" -maxdepth 1 \( ! -iname ".*" ! -name "index.html" \) -type d)
  local color_index=0
  for subfolder in $subfolders; do
    if [[ "$subfolder" != "$directory" ]]; then
      local subfolder_name=$(basename "$subfolder")
      local subfolder_color=$(get_folder_color $color_index)
      generate_details "$subfolder" "${indent}  " $subfolder_color
      color_index=$((color_index + 1))
    fi
  done

  # End file list section
  echo "${indent}</ul>"
}

# Function to get folder color based on index
get_folder_color() {
  local index=$1
  local colors=("#8ac249" "#ffce00" "#00bcd4" "#b85cc8" "#ff5252" "#ff9800" "#4caf50" "#e91e63" "#009688" "#ffc107")
  local color_index=$((index % ${#colors[@]}))
  echo "${colors[$color_index]}"
}

# Get current directory path
current_dir=$(pwd)

# Start writing details to the HTML file
cat <<EOF > index.html
<!DOCTYPE html>
<html>
<head>
  <title>Folder Details: $(basename "$current_dir")</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #000000;
      color: #e0e0e0;
      margin: 20px;
    }
    .folder {
      font-weight: bold;
      margin-top: 10px;
      padding-left: 10px;
    }
    .file {
      color: #bdbdbd;
    }
    ul {
      list-style-type: none;
      padding-left: 20px;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Folder Details: $(basename "$current_dir")</h1>
  <hr>
EOF

# Generate details recursively
generate_details "$current_dir" "  " "#8ac249" >> index.html

# End the HTML file
echo "</div>
</body>
</html>" >> index.html

echo "Details saved to index.html"
