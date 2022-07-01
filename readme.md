### I heard you like Pocket Operators, so I made Pocket Scale Calculator for your Pocket Operator.

This console app is a helper tool for calculating scales
for [Teenage Engineering Pocket Operator](https://teenage.engineering/products/po) PO-33/133 & PO-35/137* series.
It was inspired by [https://punkyv4n.me/po-33-scale-app](https://punkyv4n.me/po-33-scale-app/), but I wanted to make an
ancient-looking desktop console version with pocket operator vibes, so here we are.

<img width="733" alt="terminal profile icon" src="https://user-images.githubusercontent.com/107914638/174764479-71575b0c-8d04-44ac-a7aa-f6825d45ce23.png">

## v.0.8 changelist:

* added poScale app argument & option(major/minor), applicable only PO-35 only.
* added support for po-35/137 Major scales: Major (Natural & Pentatonic) / Minor (Natural & Pentatonic) / Dorian /
  Lydian /Phrygian

## v.0.7 changelist:

* added args tests
* fixed minor arg-related defects

## Some useful info:

Current supported scales for PO-33/133 & PO-35/137 with Minor scale setting:

* Minor (Natural, Harmonic & Pentatonic)
* Major (Natural, Harmonic & Pentatonic)
* Blues
* Dorian
* Lydian

Current supported scales for PO-35/137 with Major scale setting:

* Major (Natural & Pentatonic)
* Minor (Natural & Pentatonic)
* Dorian
* Lydian
* Phrygian

Dependencies: Prior to run this application you need to
install [java](https://www.java.com/en/download/help/download_options.html) to your computer.

Executable jar (pocket-scale-calculator-0.8.jar) is already compiled and could be found at the root of the project.
However, if you need to compile a new jar please build the project and run `./gradlew test jar` command. New jar will
be saved to the build/libs directory.

To run application please run `java -jar %pocket-scale-calc.jar file location%` from your terminal (for
example: `java -jar /Users/bilbo_bogdans/Git/pocket-scale-calculator/build/libs/pocket-scale-calculator-0.8.jar`).
MacOS users also might set their terminal profile to have a shortcut for the app (please check 'pocket-scale-calculator
example.terminal' file at the root of the project) with specific window resolution & settings set. To use shared profile
you need to fix jar file location for the CommandString key, first.

Also, you can use additional arguments for starting the app with specific options:

1. root key note (default is A)
2. scale (default is Minor)
3. snap off hanger(y/n) (default is n)
4. PO model UI(33/35) (default is 33)
5. PO scale(major/minor) (default is Minor)

For example, starting the app with 'f majpe y 35 maj' arguments will start app with F Major Pentatonic setting, missing
hanger option, PO-35 model UI and Major PO-35 device scale setting. Please make sure you separate arguments with space
button.

Have fun with your POs and never miss the right scale:-)

_*PO-35/137 scaling functionality is yet limited to Major and Minor scales set on the device itself._