# akira

An FRC Robot written in Java using WPILib, for OakvilleDynamics FRC Team 8719.

| CI Job       | Status                                                                                                                                                                                |
| ------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Code Quality | [![Qodana](https://github.com/garrettsummerfi3ld/akira/actions/workflows/code_quality.yml/badge.svg)](https://github.com/garrettsummerfi3ld/akira/actions/workflows/code_quality.yml) |
| Build        | [![Compile](https://github.com/garrettsummerfi3ld/akira/actions/workflows/gradle.yml/badge.svg)](https://github.com/garrettsummerfi3ld/akira/actions/workflows/gradle.yml)            |

## Deploying code to robot

Requirements:

* [WPILib Suite (2022)](https://github.com/wpilibsuite/allwpilib/releases/tag/v2022.4.1)
* Internet Connection (for library updates)

Steps:

**NOTE: This will remove all previous code on the robot, make sure you have a backup if needed.**

1. Download repository 
    * Click on the green Code button > Download ZIP > Extract `.zip` file to you preferred directory, or,
    * In a terminal/command prompt with [Git](https://git-scm.com/) installed: `git clone https://github.com/garrettsummerfi3ld/akira.git`
2. Open WPILib Visual Studio Code (VSCode)
3. Connect computer to Robot via Wi-Fi radio or USB
4. Open folder > Browse to downloaded repository
5. Ctrl+Shift+P (Windows/Linux) / Command(⌘)+Shift+P (macOS) > WPILib: Deploy Robot Code
    * You can also use Shift+F5 as a shortcut to deploy
6. Wait until all build tasks succeed from Gradle
