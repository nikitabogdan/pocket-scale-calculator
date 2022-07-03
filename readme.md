### I heard you like Pocket Operators, so I made Pocket Scale Calculator for your Pocket Operator.

This console app is a helper tool for calculating scales
for [Teenage Engineering Pocket Operator](https://teenage.engineering/products/po) PO-33/133 & PO-35/137* series.
It was inspired by [https://punkyv4n.me/po-33-scale-app](https://punkyv4n.me/po-33-scale-app/), but I wanted to make an
ancient-looking desktop console version with pocket operator vibes, so here we are.

<img width="733" alt="terminal profile icon" src="https://user-images.githubusercontent.com/107914638/174764479-71575b0c-8d04-44ac-a7aa-f6825d45ce23.png">

## v0.8.1

* Added shortcuts for faster accessing scales.

## v0.8

* Added pocket operator scale app argument & option (Major / Minor)
* Added support for po-35/137 Major scales: Major (Natural & Pentatonic) / Minor (Natural & Pentatonic) / Dorian /
  Lydian / Mixolydian / Locrian / Phrygian
* Added support for additional Minor scales: Mixolydian / Locrian / Phrygian
* Added 'scales'/'list' keywords & section for showing full list of supported scales

## v0.7

* Added args tests
* Fixed minor arg-related defects

## v0.6

* Added support for additional Minor scales: Major Pentatonic / Minor Pentatonic / Dorian / Lydian / Blues
* Added snap-off hanger app argument & option
* Added pocket operator model app argument & option
* Added 'description' keyword & section
* Added 'about' keyword & section
* Added 'support' keyword & section

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

Also, you can use additional arguments for starting the app with specific options:

1. root key note (default is A)
2. scale (default is Minor)
3. snap off hanger(y/n) (default is n)
4. PO model UI(33/35) (default is 33)
5. PO scale(major*/minor) (default is Minor, option is applicable for PO-35/137 models only)

For example, starting the app with 'f majpe y 35 maj' arguments will start app with F Major Pentatonic setting, missing
hanger option, PO-35 model UI and Major PO-35 device scale setting. Please make sure you separate arguments with space
button.

Have fun with your POs and never miss the right scale:-)

_*PO-35/137 scaling functionality is yet limited to Major and Minor scales set on the device itself._