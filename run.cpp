#include <iostream>
#include <cstdlib>
#include <sys/stat.h>
#include <dirent.h>
#include <fstream> // Add this line for ifstream
#include <vector>
#include <string>
#include <regex>

using namespace std;

bool hasExecutePermission(const char* filePath) {
    struct stat fileStat;
    if (stat(filePath, &fileStat) == 0) {
        if (fileStat.st_mode & S_IXUSR) {
            return true;
        }
    }
    return false;
}

vector<string> find_main_classes() {
    vector<string> mainClassFiles;

    DIR* dir;
    struct dirent* entry;

    dir = opendir(".");
    if (dir != NULL) {
        while ((entry = readdir(dir)) != NULL) {
            if (entry->d_type == DT_REG && string(entry->d_name).substr(string(entry->d_name).find_last_of(".") + 1) == "java") {
                ifstream file(entry->d_name);
                if (file.is_open()) {
                    string line;
                    while (getline(file, line)) {
                        if (regex_search(line, regex(R"(public\s+static\s+void\s+main\s*\()"))) {
                            mainClassFiles.push_back(entry->d_name);
                            break;
                        }
                    }
                    file.close();
                }
            }
        }
        closedir(dir);
    }

    return mainClassFiles;
}

void run_java_main(const string& javaFile) {
    string command = "java " + javaFile;
    system(command.c_str());
}

void create_run_buttons(const vector<string>& mainClassFiles) {
    int index = 1;
    cout << "Select a Java file to run:" << endl;
    for (const string& file : mainClassFiles) {
        cout << index << ". " << file << endl;
        index++;
    }
    cout << "Enter your choice (1-" << mainClassFiles.size() << "): ";

    int choice;
    cin >> choice;

    if (choice >= 1 && choice <= mainClassFiles.size()) {
        string selectedFile = mainClassFiles[choice - 1];
        run_java_main(selectedFile);
    } else {
        cout << "Invalid choice! Please try again." << endl;
    }
}

void run_add_package() {
    const char* scriptPath = "./add_package.sh";
    if (hasExecutePermission(scriptPath)) {
        system(scriptPath);
    } else {
        cout << "Permission denied to execute " << scriptPath << endl;
    }
}

int main() {
    int choice;
    bool running = true;

    while (running) {
        cout << "Menu:" << endl;
        cout << "1. Compile Specific Project-Folder" << endl;
        cout << "2. Delete all Class Files" << endl;
        cout << "3. Run generate a package hierarchy for Specific Folder" << endl;
        cout << "4. Push to Github" << endl;
        cout << "5. Generate Overall Project Details" << endl;
        cout << "6. Open GitHub DesignPatterns Repository" << endl;
        cout << "7. Add package Names to Files in Specific Folder" << endl;
        cout << "8. Find and Run Java Files with 'main' Method" << endl;
        cout << "9. Exit" << endl;

        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
            case 1: {
                const char* scriptPath = "./compile.sh";
                if (hasExecutePermission(scriptPath)) {
                    system(scriptPath);
                } else {
                    cout << "Permission denied to execute " << scriptPath << endl;
                }
                break;
            }
            case 2: {
                const char* scriptPath = "./deleteclass.sh";
                if (hasExecutePermission(scriptPath)) {
                    system(scriptPath);
                } else {
                    cout << "Permission denied to execute " << scriptPath << endl;
                }
                break;
            }
            case 3: {
                const char* scriptPath = "./h_gen.sh";
                if (hasExecutePermission(scriptPath)) {
                    system(scriptPath);
                } else {
                    cout << "Permission denied to execute " << scriptPath << endl;
                }
                break;
            }
            case 4: {
                const char* scriptPath = "./psh.sh";
                if (hasExecutePermission(scriptPath)) {
                    system(scriptPath);
                } else {
                    cout << "Permission denied to execute " << scriptPath << endl;
                }
                break;
            }
            case 5: {
                const char* scriptPath = "./details.sh";
                if (hasExecutePermission(scriptPath)) {
                    system(scriptPath);
                } else {
                    cout << "Permission denied to execute " << scriptPath << endl;
                }
                break;
            }
            case 6: {
                const char* url = "https://github.com/jaimit25/DesignPatterns";
                string command = "open " + string(url);
                system(command.c_str());
                break;
            }
            case 7: {
                run_add_package();
                break;
            }
            case 8: {
                vector<string> mainClassFiles = find_main_classes();
                if (!mainClassFiles.empty()) {
                    create_run_buttons(mainClassFiles);
                } else {
                    cout << "No main class files found." << endl;
                }
                break;
            }
            case 9:
                running = false;
                break;
            default:
                cout << "Invalid choice! Please try again." << endl;
        }

        cout << endl;
    }

    return 0;
}




// #include <iostream>
// #include <cstdlib>
// #include <sys/stat.h>

// using namespace std;

// bool hasExecutePermission(const char* filePath) {
//     struct stat fileStat;
//     if (stat(filePath, &fileStat) == 0) {
//         if (fileStat.st_mode & S_IXUSR) {
//             return true;
//         }
//     }
//     return false;
// }

// int main() {
//     int choice;
//     bool running = true;

//     while (running) {
//         cout << "Menu:" << endl;
//         cout << "1. Run compile.sh" << endl;
//         cout << "2. Run deleteclass.sh" << endl;
//         cout << "3. Run h_gen.sh" << endl;
//         cout << "4. Run psh.sh" << endl;
//         cout << "5. Run details.sh" << endl;
//         cout << "6. Open GitHub DesignPatterns Repository" << endl;
//         cout << "7. Exit" << endl;

//         cout << "Enter your choice: ";
//         cin >> choice;

//         switch (choice) {
//             case 1: {
//                 const char* scriptPath = "./compile.sh";
//                 if (hasExecutePermission(scriptPath)) {
//                     system(scriptPath);
//                 } else {
//                     cout << "Permission denied to execute " << scriptPath << endl;
//                 }
//                 break;
//             }
//             case 2: {
//                 const char* scriptPath = "./deleteclass.sh";
//                 if (hasExecutePermission(scriptPath)) {
//                     system(scriptPath);
//                 } else {
//                     cout << "Permission denied to execute " << scriptPath << endl;
//                 }
//                 break;
//             }
//             case 3: {
//                 const char* scriptPath = "./h_gen.sh";
//                 if (hasExecutePermission(scriptPath)) {
//                     system(scriptPath);
//                 } else {
//                     cout << "Permission denied to execute " << scriptPath << endl;
//                 }
//                 break;
//             }
//             case 4: {
//                 const char* scriptPath = "./psh.sh";
//                 if (hasExecutePermission(scriptPath)) {
//                     system(scriptPath);
//                 } else {
//                     cout << "Permission denied to execute " << scriptPath << endl;
//                 }
//                 break;
//             }
//             case 5: {
//                 const char* scriptPath = "./details.sh";
//                 if (hasExecutePermission(scriptPath)) {
//                     system(scriptPath);
//                 } else {
//                     cout << "Permission denied to execute " << scriptPath << endl;
//                 }
//                 break;
//             }
//             case 6: {
//                 const char* url = "https://github.com/jaimit25/DesignPatterns";
//                 string command = "open " + string(url);
//                 system(command.c_str());
//                 break;
//             }
//             case 7:
//                 running = false;
//                 break;
//             default:
//                 cout << "Invalid choice! Please try again." << endl;
//         }

//         cout << endl;
//     }

//     return 0;
// }
