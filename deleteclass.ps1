# Function to delete class files recursively
function Delete-ClassFiles {
    param (
        [Parameter(Mandatory=$true)]
        [string]$directory
    )

    $files = Get-ChildItem -Path $directory

    foreach ($file in $files) {
        if ($file.PSIsContainer) {
            Delete-ClassFiles -directory $file.FullName # Recursively delete class files in subdirectories
        }
        elseif ($file.Extension -eq ".class") {
            Write-Host "Deleting: $($file.FullName)"
            Remove-Item -Path $file.FullName -Force
        }
    }
}

# Delete class files
$current_directory = Get-Location
Delete-ClassFiles -directory $current_directory
