Create a new repository on the command line

touch README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/KoksharovFE/java.git
git push -u origin master


Push an existing repository from the command line

git remote add origin https://github.com/KoksharovFE/java.git
git push -u origin master



To quickly see the documentation for a class or method at caret, press Ctrl+Q (View | Quick Documentation).
Ctrl+E choose subwindow
To navigate to the declaration of a class, method or variable used somewhere in the code, position the caret at the usage and press Ctrl+B (Navigate | Declaration). You can also click the mouse on usages with the Ctrl key pressed to jump to declarations.
You can easily rename your classes, methods and variables with automatic correction of all places where they are used.
To try it, place the caret at the symbol you want to rename, and press Shift+F6 (Refactor | Rename). Type the new name in the popup window that appears, or select one of the suggested names, and press Enter.
You may easily override methods of the base class by pressing Ctrl+O (Code | Override Methods).
To implement methods of the interfaces that the current class implements (or of the abstract base class), use Ctrl+I (Code | Implement Methods).
press Ctrl+Shift+Space: The SmartType code completion greatly helps to find methods and variables that are suitable in the current context
