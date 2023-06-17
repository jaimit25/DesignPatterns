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
            javac $file.FullName
        }
    }
}

function Run-PushScript {
    Compile-Files -directory ".\ducksimulationapp"
    
    Write-Host "Enter Message:"
    $mssg = Read-Host
    $dt = Get-Date
    Write-Host "$dt"
    
    if ([string]::IsNullOrEmpty($mssg)) {
        Write-Host "Message cannot be empty"
    }
    else {
        git add .
        git commit -m "$mssg | $dt"
        git push
        Write-Host "Pushed to DesignPatterns Repository 😊"
    }
}

Run-PushScript
