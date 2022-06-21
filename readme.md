Pocket Scale Calculator v.0.6

This console app is a helper tool for calculating scales for [Teenage Engineering Pocket Operator](https://teenage.engineering/products/po) PO-33/PO-133 & PO-35/PO-137* series.
It was inspired by [https://punkyv4n.me/po-33-scale-app](https://punkyv4n.me/po-33-scale-app/), but I wanted to make a desktop console version with pocket operator vibes, so here we are.

<img width="733" alt="terminal profile icon" src="https://user-images.githubusercontent.com/107914638/174764479-71575b0c-8d04-44ac-a7aa-f6825d45ce23.png">

Dependencies: Prior to run this application you need to install [java](https://www.java.com/en/download/help/download_options.html) to your computer.

Executable jar (pocket-scale-calculator-0.6.jar) is already compiled and could be found at the root of the project. However, if you need to compile a new jar please build the project and run `./gradlew jar` command. New jar will be saved to the build/libs directory.

To run application please use `java -jar %pocket-scale-calc.jar file location%` from your terminal (for example: `java -jar /Users/bilbo_bogdans/Git/pocket-scale-calculator/build/libs/pocket-scale-calculator-0.6.jar`).
MacOS users also might set their terminal profile to have a shortcut for the app (please check 'pocket-scale-calculator example.terminal' file at the root of the project) with specific window resolution & settings set. To use shared profile you need to fix jar file location for the CommandString key, first.
Also, you can use additional arguments for starting the app with specific options:
1. root key note (default is A)
2. scale (default is Minor)
3. snap off hanger(y/n) (default is n)
4. PO model UI(33/35) (default is 33)

For example, starting the app with ' f majp y 35' arguments will start app with F Major Pentatonic setting, missing hanger option and PO-35 model UI. Please make sure you separate arguments with space button.

Currently supported scales are:
* Minor (Natural, Harmonic & Pentatonic)
* Major (Natural, Harmonic & Pentatonic)
* Blues
* Dorian
* Lydian

Have fun!

I will appreciate any defects/issues found during your app experience, please contact me to fix it.

_*PO-33/PO-137 scaling functionality is yet limited to Minor scale set on the device itself._
