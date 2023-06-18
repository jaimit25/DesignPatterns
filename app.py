import os
import json

def process_directory(path):
    data = {
        "name": os.path.basename(os.path.abspath(path)),
        "folders": [],
        "files": []
    }

    for entry in os.scandir(path):
        if entry.is_dir() and not entry.name.startswith(('.', '_')):
            folder = process_directory(entry.path)
            if folder:
                data["folders"].append(folder)
        elif entry.is_file() and not entry.name.startswith('.'):
            if entry.name.endswith(('.txt', '.json', '.py', '.java')):
                with open(entry.path, 'r') as file:
                    content = file.read()
                    file_data = {
                        "filename": entry.name,
                        "content": content,
                        "path": entry.path
                    }
                    data["files"].append(file_data)

    return data

def create_html(data):
    def recursive_html(data):
        html = ""
        if data["folders"]:
            html += "<ul>"
            for folder in data["folders"]:
                html += f'<li><span class="folder">{folder["name"]}</span>{recursive_html(folder)}</li>'
            html += "</ul>"
        if data["files"]:
            html += "<ul>"
            for file in data["files"]:
                html += f'<li><span class="file">{file["filename"]}</span></li>'
            html += "</ul>"
        return html

    html_template = f"""
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8">
        <title>Folder Structure</title>
        <style>
            body {{
                background-color: #222;
                color: #fff;
                font-size: 16px;
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }}
            
            .navbar {{
                background-color: #333;
                padding: 10px;
            }}
            
            .sidebar-toggle {{
                background-color: transparent;
                color: #fff;
                border: none;
                font-size: 20px;
                cursor: pointer;
                margin-right: 10px;
            }}
            
            .current-folder {{
                color: #fff;
            }}
            
            .sidebar {{
                background-color: #333;
                color: #fff;
                width: 250px;
                position: fixed;
                top: 0;
                left: -250px;
                height: 100%;
                overflow-y: auto;
                transition: left 0.3s;
                padding: 20px;
            }}
            
            .main-section {{
                margin-left: 250px;
                padding: 20px;
            }}
            
            ul {{
                list-style: none;
                padding: 0;
                margin: 0;
            }}
            
            .folder {{
                color: #fff;
                cursor: pointer;
            }}
            
            .file {{
                color: #fff;
                cursor: pointer;
                margin-left: 10px;
            }}
            
            .file-content {{
                white-space: pre-wrap;
            }}
        </style>
        <script>
            function toggleSidebar() {{
                var sidebar = document.getElementById('sidebar');
                var mainSection = document.getElementById('main-section');
                if (sidebar.style.left === '-250px') {{
                    sidebar.style.left = '0';
                    mainSection.style.marginLeft = '250px';
                }} else {{
                    sidebar.style.left = '-250px';
                    mainSection.style.marginLeft = '0';
                }}
            }}
            
            function loadFileContent(path) {{
                fetch('/load_file', {{
                    method: 'POST',
                    headers: {{
                        'Content-Type': 'application/json'
                    }},
                    body: JSON.stringify({{
                        'path': path
                    }})
                }})
                .then(response => response.text())
                .then(content => {{
                    var fileContent = document.getElementById('file-content');
                    fileContent.innerHTML = content;
                }})
                .catch(error => {{
                    console.error('Error:', error);
                }});
            }}
        </script>
    </head>
    <body>
        <div class="navbar">
            <button class="sidebar-toggle" onclick="toggleSidebar()">☰</button>
            <span class="current-folder">{data['name']}</span>
        </div>
        <div id="sidebar" class="sidebar">
            {recursive_html(data)}
        </div>
        <div id="main-section" class="main-section">
            <div id="file-content"></div>
        </div>
    </body>
    </html>
    """

    with open("index.html", "w") as html_file:
        html_file.write(html_template)

if __name__ == "__main__":
    current_directory = os.getcwd()
    data = process_directory(current_directory)
    create_html(data)
