#include <iostream>
#include <cstdlib>
#include <sys/stat.h>

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

int main() {
    int choice;
    bool running = true;

    while (running) {
        cout << "Menu:" << endl;
        cout << "1. Run compile.sh" << endl;
        cout << "2. Run deleteclass.sh" << endl;
        cout << "3. Run h_gen.sh" << endl;
        cout << "4. Run psh.sh" << endl;
        cout << "5. Run details.sh" << endl;
        cout << "6. Open GitHub DesignPatterns Repository" << endl;
        cout << "7. Exit" << endl;

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
            case 7:
                running = false;
                break;
            default:
                cout << "Invalid choice! Please try again." << endl;
        }

        cout << endl;
    }

    return 0;
}
