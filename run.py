import tkinter as tk
from tkinter import messagebox
from tkinter.simpledialog import askstring

import subprocess
import os
import re


def run_script(script_path):
    try:
        subprocess.run(["bash", script_path], check=True)
        messagebox.showinfo("Message", f"Running {script_path}")
    except subprocess.CalledProcessError:
        messagebox.showerror("Error", f"Error executing {script_path}")


def run_compile():
    project_name = askstring("Compile Script", "Enter project name:")
    if project_name:
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
    else:
        messagebox.showinfo("Message", "deleteclass.sh canceled.")


def run_h_gen():
    project_name = askstring("Hierarchy Generation Script", "Enter project name:")
    if project_name:
        script_path = "./h_gen.sh"
        run_script(script_path)


def run_psh():
    message = askstring("Push Script", "Enter commit message:")
    if message:
        script_path = "./psh.sh"
        subprocess.run(["bash", script_path, message], check=True)
        messagebox.showinfo("Message", f"Running psh.sh with commit message: {message}")
    else:
        messagebox.showwarning("Warning", "Invalid commit message!")


def run_details():
    script_path = "./details.sh"
    run_script(script_path)


def open_github():
    subprocess.run(["open", "https://github.com/jaimit25/DesignPatterns"])
    messagebox.showinfo("Message", "Opening GitHub DesignPatterns repository")


def find_main_function():
    java_files = [f for f in os.listdir(".") if f.endswith(".java")]
    main_functions = []
    for java_file in java_files:
        with open(java_file, "r") as file:
            content = file.read()
            matches = re.findall(r"public\s+static\s+void\s+main\s*\(", content)
            if matches:
                main_functions.append(java_file)
    if main_functions:
        messagebox.showinfo("Main Function Found", f"Main function found in: {', '.join(main_functions)}")
    else:
        messagebox.showinfo("Main Function Not Found", "No main function found in any Java file.")


# Create the main window
window = tk.Tk()
window.title("Script Runner")
window.geometry("400x400")
window.configure(bg="#212121")

# Define colors for the buttons
button_bg = "#bf0f70"
button_fg = "black"

# Create the menu buttons
compile_btn = tk.Button(window, text="Run compile.sh", command=run_compile, bg=button_bg, fg=button_fg)
compile_btn.pack(pady=10, padx=20, fill="x")

deleteclass_btn = tk.Button(window, text="Run deleteclass.sh", command=run_deleteclass, bg=button_bg, fg=button_fg)
deleteclass_btn.pack(pady=10, padx=20, fill="x")

h_gen_btn = tk.Button(window, text="Run h_gen.sh", command=run_h_gen, bg=button_bg, fg=button_fg)
h_gen_btn.pack(pady=10, padx=20, fill="x")

psh_btn = tk.Button(window, text="Run psh.sh", command=run_psh, bg=button_bg, fg=button_fg)
psh_btn.pack(pady=10, padx=20, fill="x")

details_btn = tk.Button(window, text="Run details.sh", command=run_details, bg=button_bg, fg=button_fg)
details_btn.pack(pady=10, padx=20, fill="x")

github_btn = tk.Button(window, text="Open GitHub DesignPatterns", command=open_github, bg=button_bg, fg=button_fg)
github_btn.pack(pady=10, padx=20, fill="x")

main_func_btn = tk.Button(window, text="Find Main Function", command=find_main_function, bg=button_bg, fg=button_fg)
main_func_btn.pack(pady=10, padx=20, fill="x")

exit_btn = tk.Button(window, text="Exit", command=window.quit, bg="#E53935", fg="black")
exit_btn.pack(pady=10, padx=20, fill="x")

# Start the main event loop
window.mainloop()



# import tkinter as tk
# from tkinter import messagebox
# import subprocess

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
#     else:
#         messagebox.showinfo("Message", "deleteclass.sh canceled.")

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

# # Create the main window
# window = tk.Tk()
# window.title("Script Runner")
# window.geometry("400x300")

# # Create the menu buttons
# compile_btn = tk.Button(window, text="Run compile.sh", command=run_compile)
# compile_btn.pack(pady=10)

# deleteclass_btn = tk.Button(window, text="Run deleteclass.sh", command=run_deleteclass)
# deleteclass_btn.pack(pady=10)

# h_gen_btn = tk.Button(window, text="Run h_gen.sh", command=run_h_gen)
# h_gen_btn.pack(pady=10)

# psh_btn = tk.Button(window, text="Run psh.sh", command=run_psh)
# psh_btn.pack(pady=10)

# details_btn = tk.Button(window, text="Run details.sh", command=run_details)
# details_btn.pack(pady=10)

# github_btn = tk.Button(window, text="Open GitHub DesignPatterns", command=open_github)
# github_btn.pack(pady=10)

# # Start the main event loop
# window.mainloop()
