### I heard you like Pocket Operators, so I made Pocket Scale Calculator for your Pocket Operator.

This console app is a helper tool for calculating scales & note positions
for [Teenage Engineering Pocket Operator](https://teenage.engineering/products/po) PO-32, PO-33/133, PO-35/137 & PO-128
series.
It was inspired by [https://punkyv4n.me/po-33-scale-app](https://punkyv4n.me/po-33-scale-app/), but I wanted to make an
ancient-looking desktop console version with pocket operator vibes and extend original app functionality with more
available settings and scales.

<img width="600" alt="terminal profile icon compact" src="https://raw.githubusercontent.com/nikitabogdan/pocket-scale-calculator/main/terminal%20profile%20icon%20compact.png">

## v0.93

* Reused correct tonic key definition across the app (root key -> tonic)
* Added support for po-32 Tonic model.

## v0.92

* Added support for po-128 Megaman model.

## v0.9

* Added missing scales for po-35/137 models (Blues & Arab)
* Modified & added tests to handle additional poScale argument
* Updated default terminal profile to fit snap-off hanger option & resized window.

## v0.8.2

* Reduced console window size to 41 chars (cut unused 3 chars space from the both sides).
* Reworked text output methods.

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

* Added init app arguments: tonic & scale
* Added support for basic Minor scales: Major Natural / Major Harmonic / Minor Natural / Minor Harmonic

## General info

Supported scales for PO-128, PO-33/133 & PO-35/137 with Minor scale setting:

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

PO-35/137 Blues & Arab scale settings are now supported as well.

To use app please type tonic key & desired scale (for example: F Blues) and press enter. Found scale name will appear on
the second line of the little ascii po display. The scale itself will be shown on the ascii pocket operator note
buttons. Sample key for the found scale will be shown on the third line of ascii po display. This is the sample note you
should load into your PO to use this scale. Play your melody using buttons with note keys and avoid using out of
scale buttons marked as --. Also, the first line of ascii pocket operator display is showing your current po scale
setting. To change this and other settings such as 'snap-off hanger' option and PO model, please use 'options' command
and follow menu tips.

If you would like to calculate scales for PO-32, the app will work in quite other way.
For selected tonic & scale it will show you a range of values (0..100), you might program your single sound bank in
sequence with pitch knob to get all possible notes in the selected scale. You will need to know the default note of the
sound bank loaded into your po and make sure this note is the same as your tonic note. Default pitch have the value
equals to 50. -12 semitones pitch have the value equals to 10, +7 semitones pitch have the value equals to 74 e.t.c.
It is handy to use 2 apps launched with the same tonic & scale, but with different models, for example: po-32 & po-35.
While pocket scale calc with po-35 model in use will show an actual scale and notes positions, another one with po-32
model will show pitch value you should set to your sound bank to get each note from the scale.

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

1. tonic note (default is A)
2. scale (default is Minor)
3. snap off hanger(y/n) (default is n)
4. PO model UI(32/33/35/128) (default is 33)
5. PO scale(major/minor/blues/arab) (default is Minor, option is applicable for PO-32 & PO-35/137 models only)

For example, starting the app with 'f majpe y 35 maj' arguments will start app with F Major Pentatonic setting, missing
hanger option, PO-35 model UI and Major PO-35 device scale setting. Please make sure you separate arguments with space
button.

## App commands

* "", "help", "tutorial", "description" - print help section
* "options", "preferences" - access options menu
* "scales", "list" - print full list of supported scales & shortcuts section
* "about", "info" - print additional app info section
* "exit", "quit", "off", "terminate" - exit app
