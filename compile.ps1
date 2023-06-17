# Execute deleteclass.ps1 script
Start-Process -FilePath "powershell" -ArgumentList "-ExecutionPolicy Bypass -File deleteclass.ps1" -Wait

# Function to compile Java files recursively
function Compile-Files {
    param (
        [Parameter(Mandatory=$true)]
        [string]$directory
    )
    
    $files = Get-ChildItem -Path $directory
    
    foreach ($file in $files) {
        if ($file.PSIsContainer) {
            Compile-Files -directory $file.FullName # Recursively compile files in subdirectories
        }
        elseif ($file.Extension -eq ".java") {
            Write-Host "Compiling: $($file.FullName)"
            Start-Process -FilePath "javac" -ArgumentList "$($file.FullName)" -Wait
        }
    }
}

# Compile Java files
$current_directory = Get-Location
Compile-Files -directory $current_directory

# Execute Java program
Start-Process -FilePath "java" -ArgumentList "ducksimulationapp.DuckSimApp" -Wait
