### I heard you like Pocket Operators, so I made Pocket Scale Calculator for your Pocket Operator.

This console app is a helper tool for calculating scales
for [Teenage Engineering Pocket Operator](https://teenage.engineering/products/po) PO-33/133 & PO-35/137* series.
It was inspired by [https://punkyv4n.me/po-33-scale-app](https://punkyv4n.me/po-33-scale-app/), but I wanted to make an
ancient-looking desktop console version with pocket operator vibes, so here we are.

<img width="733" alt="terminal profile icon" src="https://user-images.githubusercontent.com/107914638/174764479-71575b0c-8d04-44ac-a7aa-f6825d45ce23.png">

## v0.8.1

* Added shortcuts for faster accessing scales.
* Added proper app tutorial text.

## v0.8

* Added pocket operator scale app argument & option (Major / Minor)
* Added showing current po scale option on the first line of ascii-display
* Added support for po-35/137 Major scales: Major (Natural & Pentatonic) / Minor (Natural & Pentatonic) / Dorian /
  Lydian / Mixolydian / Locrian / Phrygian
* Added support for additional Minor scales: Mixolydian / Locrian / Phrygian
* Added 'scales' command & section for showing full list of supported scales

## v0.7

* Added args tests
* Fixed minor arg-related defects
* Added 'exit' command & section

## v0.6

* Added support for additional Minor scales: Major Pentatonic / Minor Pentatonic / Dorian / Lydian / Blues
* Added 'description' command & section
* Added 'about' command & section
* Added 'support' command & section
* Added 'options' command & section
* Added snap-off hanger app argument & option
* Added pocket operator model app argument & option

## v0.5.1

* Fixed defect from [https://punkyv4n.me/po-33-scale-app](https://punkyv4n.me/po-33-scale-app/) origin: showing wrong
  out of scale notes indexes for Major Harmonic.

## v0.5

* Added init app arguments: root key & scale
* Added support for basic Minor scales: Major Natural / Major Harmonic / Minor Natural / Minor Harmonic

## General info

Supported scales for PO-33/133 & PO-35/137 with Minor scale setting:

* Minor (Natural, Harmonic & Pentatonic)
* Major (Natural, Harmonic & Pentatonic)
* Blues
* Dorian
* Lydian
* Mixolydian
* Locrian
* Phrygian

Supported scales for PO-35/137 with Major scale setting:

* Major (Natural & Pentatonic)
* Minor (Natural & Pentatonic)
* Dorian
* Lydian
* Mixolydian
* Locrian
* Phrygian

To use app please type root key & desired scale (for example: F Blues) and press enter. Found scale name will appear on
the second line of the little ascii po display. The scale itself will be shown on the ascii pocket operator note
buttons. Sample key for the found scale will be shown on the third line of ascii po display. This is the sample note you
should load into your PO to use this scale. Start your melody from the root note marked as [] and avoid using out of
scale notes marked as --. Also, the first line of ascii pocket operator display is showing your current po scale
setting. To change this and other settings such as 'snap-off hanger' option and PO model, please use 'options' command
and follow menu tips.

That's it, have fun with your POs and never miss the right scale:-)

## Dependencies

Prior to run this application you need to
install [java](https://www.java.com/en/download/help/download_options.html) to your computer.

## Run

Executable jar (pocket-scale-calculator.jar) is already compiled and could be found at the root of the project.
However, if you need to compile a new jar please build the project and run `./gradlew test jar` command. New jar will
be saved to the build/libs directory.

To start application please run `java -jar %pocket-scale-calc.jar file location%` from your terminal (for
example: `java -jar /Users/bilbo_bogdans/Git/pocket-scale-calculator/build/libs/pocket-scale-calculator.jar`).
MacOS users also might set their terminal profile to have a shortcut for the app (please check 'pocket-scale-calculator
example.terminal' file at the root of the project) with specific window resolution & settings set. To use shared profile
you need to fix jar file location for the CommandString key, first.

## Run with arguments

You can use additional arguments for starting the app with specific options:

1. root key note (default is A)
2. scale (default is Minor)
3. snap off hanger(y/n) (default is n)
4. PO model UI(33/35) (default is 33)
5. PO scale(major*/minor) (default is Minor, *option is applicable for PO-35/137 models only)

For example, starting the app with 'f majpe y 35 maj' arguments will start app with F Major Pentatonic setting, missing
hanger option, PO-35 model UI and Major PO-35 device scale setting. Please make sure you separate arguments with space
button.

## App commands

* "", "help", "tutorial", "description" - print help section
* "options", "preferences" - access options menu
* "scales", "list" - print full list of supported scales & shortcuts section
* "about", "info" - print additional app info section
* "donate", "support" - print support development section
* "exit", "quit", "off", "terminate" - exit app

_*PO-35/137 scaling functionality is yet limited to Major and Minor scales set on the device itself._