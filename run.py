import tkinter as tk
from tkinter import messagebox
import subprocess
import os
import re

window_width = 0.145  # Set the initial width of the window as a percentage of the screen width
window_height = 0.5  # Set the initial height of the window as a percentage of the screen height

def run_script(script_path):
    try:
        subprocess.run(["bash", script_path], check=True)
        messagebox.showinfo("Message", f"Running {script_path}")
    except subprocess.CalledProcessError:
        messagebox.showerror("Error", f"Error executing {script_path}")


def run_compile():
    script_path = "./compile.sh"
    run_script(script_path)


def run_deleteclass():
    confirmation = messagebox.askyesno(
        "Confirmation",
        "Are you sure you want to run deleteclass.sh?\nThis action is dangerous and will delete every class file.",
    )
    if confirmation:
        script_path = "./deleteclass.sh"
        run_script(script_path)


def run_h_gen():
    script_path = "./h_gen.sh"
    run_script(script_path)


def run_psh():
    message = "Enter commit message:"
    script_path = "./psh.sh"
    subprocess.run(["bash", script_path, message], check=True)
    messagebox.showinfo("Message", f"Running psh.sh with commit message: {message}")


def run_details():
    script_path = "./details.sh"
    run_script(script_path)


def open_github():
    subprocess.run(["open", "https://github.com/jaimit25/DesignPatterns"])
    messagebox.showinfo("Message", "Opening GitHub DesignPatterns repository")


def find_main_function():
    project_folders = [f for f in os.listdir(".") if os.path.isdir(f)]

    main_class_files = []
    for project_folder in project_folders:
        project_path = os.path.join(".", project_folder)
        java_files = [f for f in os.listdir(project_path) if f.endswith(".java")]
        for java_file in java_files:
            with open(os.path.join(project_path, java_file), "r") as file:
                content = file.read()
                if re.search(r"public\s+static\s+void\s+main\s*\(", content):
                    main_class_files.append(os.path.join(project_path, java_file))

    if main_class_files:
        create_run_buttons(main_class_files)
    else:
        messagebox.showinfo("Main Class Files Not Found", "No main class files found.")


def create_run_buttons(main_class_files):
    window = tk.Toplevel()
    window.title("Run Main Class")
    window_width_px = int(window_width * window.winfo_screenwidth())
    window_height_px = int(window_height * window.winfo_screenheight())
    window.geometry(f"{window_width_px}x{window_height_px}")
    window.configure(bg="black")


    for i, class_file in enumerate(main_class_files):
        class_name = os.path.splitext(os.path.basename(class_file))[0]
        btn_text = f"Run {class_name}"
        btn_command = lambda file=class_file: run_java_file(file)
        btn = tk.Button(window, text=btn_text, command=btn_command)
        btn.pack(pady=10)


def run_java_file(file_path):
    root_path = os.getcwd()  # Get the current working directory
    clean_path = os.path.normpath(os.path.join(root_path, file_path))
    print(clean_path)
    script_path = "java"
    subprocess.Popen([script_path, clean_path])


def run_add_package():
    script_path = "./add_package.sh"
    run_script(script_path)


# Create the main window
window = tk.Tk()
window.title("Script Runner")
window_width_px = int(window_width * window.winfo_screenwidth())
window_height_px = int(window_height * window.winfo_screenheight())
window.geometry(f"{window_width_px}x{window_height_px}")
window.configure(bg="black")

# Define colors for the buttons
button_bg = "#bf0f70"
button_fg = "black"

# Create the menu buttons
compile_btn = tk.Button(window, text="Compile Code", command=run_compile, bg=button_bg, fg=button_fg)
compile_btn.pack(pady=10, padx=20, fill="x")

deleteclass_btn = tk.Button(window, text="Delete Class Files", command=run_deleteclass, bg=button_bg, fg=button_fg)
deleteclass_btn.pack(pady=10, padx=20, fill="x")

h_gen_btn = tk.Button(window, text="Package Contents", command=run_h_gen, bg=button_bg, fg=button_fg)
h_gen_btn.pack(pady=10, padx=20, fill="x")

psh_btn = tk.Button(window, text="Git push", command=run_psh, bg=button_bg, fg=button_fg)
psh_btn.pack(pady=10, padx=20, fill="x")

details_btn = tk.Button(window, text="Generate Info", command=run_details, bg=button_bg, fg=button_fg)
details_btn.pack(pady=10, padx=20, fill="x")

github_btn = tk.Button(window, text="Open GitHub Repository", command=open_github, bg=button_bg, fg=button_fg)
github_btn.pack(pady=10, padx=20, fill="x")

main_func_btn = tk.Button(window, text="Run Code", command=find_main_function, bg=button_bg, fg=button_fg)
main_func_btn.pack(pady=10, padx=20, fill="x")

add_package_btn = tk.Button(window, text="Add Package", command=run_add_package, bg=button_bg, fg=button_fg)
add_package_btn.pack(pady=10, padx=20, fill="x")

exit_btn = tk.Button(window, text="Exit", command=window.quit, bg="#E53935", fg=button_fg)
exit_btn.pack(pady=10, padx=20, fill="x")


# Start the main event loop
window.mainloop()


# import tkinter as tk
# from tkinter import messagebox

# import subprocess
# import os
# import re


# def run_script(script_path):
#     try:
#         subprocess.run(["bash", script_path], check=True)
#         messagebox.showinfo("Message", f"Running {script_path}")
#     except subprocess.CalledProcessError:
#         messagebox.showerror("Error", f"Error executing {script_path}")


# def run_compile():
#     script_path = "./compile.sh"
#     run_script(script_path)


# def run_deleteclass():
#     confirmation = messagebox.askyesno(
#         "Confirmation",
#         "Are you sure you want to run deleteclass.sh?\nThis action is dangerous and will delete every class file.",
#     )
#     if confirmation:
#         script_path = "./deleteclass.sh"
#         run_script(script_path)


# def run_h_gen():
#     script_path = "./h_gen.sh"
#     run_script(script_path)


# def run_psh():
#     message = "Enter commit message:"
#     script_path = "./psh.sh"
#     subprocess.run(["bash", script_path, message], check=True)
#     messagebox.showinfo("Message", f"Running psh.sh with commit message: {message}")


# def run_details():
#     script_path = "./details.sh"
#     run_script(script_path)


# def open_github():
#     subprocess.run(["open", "https://github.com/jaimit25/DesignPatterns"])
#     messagebox.showinfo("Message", "Opening GitHub DesignPatterns repository")


# def find_main_function():
#     project_folders = [f for f in os.listdir(".") if os.path.isdir(f)]

#     main_class_files = []
#     for project_folder in project_folders:
#         project_path = os.path.join(".", project_folder)
#         java_files = [f for f in os.listdir(project_path) if f.endswith(".java")]
#         for java_file in java_files:
#             with open(os.path.join(project_path, java_file), "r") as file:
#                 content = file.read()
#                 if re.search(r"public\s+static\s+void\s+main\s*\(", content):
#                     main_class_files.append(os.path.join(project_path, java_file))

#     if main_class_files:
#         create_run_buttons(main_class_files)
#     else:
#         messagebox.showinfo("Main Class Files Not Found", "No main class files found.")


# def create_run_buttons(main_class_files):
#     window = tk.Toplevel()
#     window.title("Run Main Class")
#     window.geometry("400x300")

#     for i, class_file in enumerate(main_class_files):
#         class_name = os.path.splitext(os.path.basename(class_file))[0]
#         btn_text = f"Run {class_name}"
#         btn_command = lambda file=class_file: run_java_file(file)
#         btn = tk.Button(window, text=btn_text, command=btn_command)
#         btn.pack(pady=10)


# def run_java_file(file_path):
#     root_path = os.getcwd()  # Get the current working directory
#     clean_path = os.path.normpath(os.path.join(root_path, file_path))
#     print(clean_path)
#     script_path = "java"
#     subprocess.Popen([script_path, clean_path])


# # Create the main window
# window = tk.Tk()
# window.title("Script Runner")
# window.geometry("400x400")
# window.configure(bg="#212121")

# # Define colors for the buttons
# button_bg = "#bf0f70"
# button_fg = "black"

# # Create the menu buttons
# compile_btn = tk.Button(window, text="Compile Code", command=run_compile, bg=button_bg, fg=button_fg)
# compile_btn.pack(pady=10, padx=20, fill="x")

# deleteclass_btn = tk.Button(window, text="Delete Class Files", command=run_deleteclass, bg=button_bg, fg=button_fg)
# deleteclass_btn.pack(pady=10, padx=20, fill="x")

# h_gen_btn = tk.Button(window, text="Package Contents", command=run_h_gen, bg=button_bg, fg=button_fg)
# h_gen_btn.pack(pady=10, padx=20, fill="x")

# psh_btn = tk.Button(window, text="Git push", command=run_psh, bg=button_bg, fg=button_fg)
# psh_btn.pack(pady=10, padx=20, fill="x")

# details_btn = tk.Button(window, text="Generate Info", command=run_details, bg=button_bg, fg=button_fg)
# details_btn.pack(pady=10, padx=20, fill="x")

# github_btn = tk.Button(window, text="Open GitHub Repository", command=open_github, bg=button_bg, fg=button_fg)
# github_btn.pack(pady=10, padx=20, fill="x")

# main_func_btn = tk.Button(window, text="Run Code", command=find_main_function, bg=button_bg, fg=button_fg)
# main_func_btn.pack(pady=10, padx=20, fill="x")

# exit_btn = tk.Button(window, text="Exit", command=window.quit, bg="#E53935", fg=button_fg)
# exit_btn.pack(pady=10, padx=20, fill="x")


# # Start the main event loop
# window.mainloop()


