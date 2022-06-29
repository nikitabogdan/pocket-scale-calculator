package ui

import PocketScaleCalculator
import constants.APP_VERSION
import constants.ButtonIndexes
import constants.DOUBLE_INDENT
import constants.HEADER_ABOUT
import constants.HEADER_DESCRIPTION
import constants.HEADER_ERROR
import constants.HEADER_FILLER_SIGN
import constants.HEADER_SUPPORT
import constants.INDENT
import constants.OUT_OF_SCALE_KEY_DEFINITION
import constants.Placeholders.BT01_PH
import constants.Placeholders.BT02_PH
import constants.Placeholders.BT03_PH
import constants.Placeholders.BT04_PH
import constants.Placeholders.BT05_PH
import constants.Placeholders.BT06_PH
import constants.Placeholders.BT07_PH
import constants.Placeholders.BT08_PH
import constants.Placeholders.BT09_PH
import constants.Placeholders.BT10_PH
import constants.Placeholders.BT11_PH
import constants.Placeholders.BT12_PH
import constants.Placeholders.BT13_PH
import constants.Placeholders.BT14_PH
import constants.Placeholders.BT15_PH
import constants.Placeholders.BT16_PH
import constants.Placeholders.MODEL_PLACEHOLDER
import constants.Placeholders.PO_SCALE_PLACEHOLDER
import constants.Placeholders.SAMPLE_KEY_PLACEHOLDER
import constants.Placeholders.SCALE_NAME_PLACEHOLDER
import constants.ROOT_KEY_SURROUND_DEFINITION
import constants.WINDOW_WIDTH
import helpers.convertDeviceScalePlaceholder
import helpers.convertSampleKeyPlaceholder
import helpers.convertScaleNamePlaceholder
import types.MinorScales

fun printHeader(text: String = "") {
    if (text.isEmpty()) {
        println(
            "\n$DOUBLE_INDENT${HEADER_FILLER_SIGN.repeat(WINDOW_WIDTH - (DOUBLE_INDENT.length * 2))}$DOUBLE_INDENT\n"
        )
    } else {
        if (text.length.mod(2) == 0) {
            val dividerLength = (WINDOW_WIDTH - (DOUBLE_INDENT.length * 2) - (INDENT.length * 2) - text.length) / 2
            println(
                "\n$DOUBLE_INDENT${HEADER_FILLER_SIGN.repeat(dividerLength + 1)}$INDENT$text" +
                        "$INDENT${HEADER_FILLER_SIGN.repeat(dividerLength)}$DOUBLE_INDENT\n"
            )
        } else {
            val dividerLength =
                (WINDOW_WIDTH - (DOUBLE_INDENT.length * 2) - (INDENT.length * 2) - (text.length + 1)) / 2
            println(
                "\n$DOUBLE_INDENT${HEADER_FILLER_SIGN.repeat(dividerLength + 1)}$INDENT$text" +
                        "$INDENT${HEADER_FILLER_SIGN.repeat(dividerLength + 1)}$DOUBLE_INDENT\n"
            )
        }
    }
}

fun printFooter() {
    printHeader()
}

fun printInputMessage(message: String) {
    print(message)
}

fun printErrorMessage(errorMessage: String) {
    printHeader(HEADER_ERROR)
    println(errorMessage)
    printFooter()
}

fun printDescription() {
    printHeader(HEADER_DESCRIPTION)
    println("  Type something like 'd# maj' for D# Major or")
    println("'G5 MinH' for Harmonic G Minor or 'a# map' for")
    println("for Pentatonic A# Major, or F#3 B for F# Blues")
    println("and press enter. Please make sure you separate")
    println("root key & scale with space key, which is used")
    println("to split input arguments. You could see found")
    println("scale on the ASCII-PO display and sample key to")
    println("record into your PO to use this scale. Notes ")
    println("with [] brackets are root notes for your scale.")
    println("Empty -- notes are outside of calculated scale.")
    println("")
    println("  Currently supported scales are: ")
    println("    – Minor (Natural, Harmonic & Pentatonic)")
    println("    – Major (Natural, Harmonic & Pentatonic)")
    println("    – ${MinorScales.BLUES.scaleName}")
    println("    – ${MinorScales.DORIAN.scaleName}")
    println("    – ${MinorScales.LYDIAN.scaleName}")
    println("Should work the same with PO-35 / PO-137 models")
    println("with Minor scale picked on the device.")
    println("")
    println("  Additional commands: ")
    println("  'options' - set 'snap off hanger' & PO model")
    println("  'info' - more info/about section")
    println("  'off' - exit app")
    println("")
    println("To start app with specific default scale and ")
    println("options please use following arguments list ")
    println("next to the 'java -jar %file loc%' run command:")
    println("1:root note, 2:scale, 3:snap off hanger (y/n),")
    println("4:PO model (33/35). For example: F MajP Y 35")
    println("will start app with F Major Pentatonic setting,")
    println("missing hanger option and PO-35 model UI.")
    printFooter()
}

fun printAbout() {
    printHeader(HEADER_ABOUT)
    println("  Pocket Scale Calculator. App version: $APP_VERSION")
    println("For Teenage Engineering PO-33 / PO-133 and, ")
    println("partially, PO-35 / PO-137 series (Minor only)")
    println("https://teenage.engineering/products/po")
    println("Inspired by www.punkyv4n.me/po-33-scale-app")
    println("Dev: Nikita Bogdan  Email: nikita.bogdan@me.com")
    println("github.com/nikitabogdan/pocket-scale-calculator")
    printFooter()
}

fun printSupport() {
    printHeader(HEADER_SUPPORT)
    println("If you enjoyed Pocket Scale Calculator, you can")
    println("support development of the next app versions.")
    println("Donations could be accepted to the following ")
    println("xrp address: rD8aqf3YcxYZ3Lzv9vuoqeTfmgb4e7TdXm")
    printFooter()
}

fun PocketScaleCalculator.prepareCalculationsDraft() = if (this.snapOffHanger) {
    "                                               \n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
} else {
    "                                               \n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
            "@@@@POCKET@@°                      °@@@@@@@@@@@\n" +
            "@@SCALE@@@@   .@@@@@@@@@@@@@@@@@@.   @@@@@@@@@@\n" +
            "@@@@@CALC@@   .@@@@@@@@@@@@@@@@@#.   @@@@@@@@@@\n" +
            "@@@@@@@@@@@@.    pocket operator   .@@@@@@@@@@@\n" +
            "@@@@@@@@@@@@O**o*  *****o***  ***o#@@@@@@@@@@@@\n"

} +
        "@@@@                °#  O°o*          oo   @@@@\n" +
        "@@@@   $MODEL_PLACEHOLDER       *#OO°#°oO          @#   @@@@\n" +
        "@@@@          ...................     °°   @@@@\n" +
        "@@@@   #################################   @@@@\n" +
        "@@@@   @@  $PO_SCALE_PLACEHOLDER ##   @@@@\n" +
        "@@@@   ## $SCALE_NAME_PLACEHOLDER ##   @@@@\n" +
        "@@@@  .## $SAMPLE_KEY_PLACEHOLDER ##   @@@@\n" +
        "@@@@  .##                             ##   @@@@\n" +
        "@@@@.  ##  $ROOT_KEY_SURROUND_DEFINITION: root; $OUT_OF_SCALE_KEY_DEFINITION: out of scale ##  .@@@@\n" +
        "@@@@*  *o°#########################Ooo*o  *@@@@\n" +
        "@@@@.       ..''''''''''''''''''''        .@@@@\n" +
        "@@@O   .*** °'.ooo.  .ooo.  #°@##o #°@@Oo  @@@@\n" +
        "@@@O  .@*°@o °@*.#@  @O O#  @*@@°# @#@@°@  @@@@\n" +
        "@@@O   'ooO'  'OoO°  'OoO°  o*oo@* o**o#*  @@@@\n" +
        "@@@O                                 ,_.   @@@@\n" +
        "@@@O                                @O.@#  @@@@\n" +
        "@@@@   $BT01_PH  $BT02_PH  $BT03_PH  $BT04_PH   'OoO*  @@@@\n" +
        "@@@@                                 °°'   O@@@\n" +
        "@@@O                                 ,o.   O@@@\n" +
        "@@@@                                @O.@#  @@@@\n" +
        "@@@O   $BT05_PH  $BT06_PH  $BT07_PH  $BT08_PH   'OoO*  @@@@\n" +
        "@@@@                                 °'    @@@@\n" +
        "@@@O                                 oo*.  O@@@\n" +
        "@@@@                                @O.@#  @@@@\n" +
        "@@@O   $BT09_PH  $BT10_PH  $BT11_PH  $BT12_PH   'OoO*  @@@@\n" +
        "@@@@                                  °°   @@@@\n" +
        "@@@O                                 ,o.   @@@@\n" +
        "@@@@                                @O.@#  @@@@\n" +
        "@@@@   $BT13_PH  $BT14_PH  $BT15_PH  $BT16_PH   'OoO*  @@@@\n" +
        "@@@@                                       @@@@\n" +
        "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
        "                                               "

fun PocketScaleCalculator.printCalculations(transposedNotes: Array<String>) {
    println(
        this.prepareCalculationsDraft()
            .replace(MODEL_PLACEHOLDER, this.poModel.displayName)
            .replace(PO_SCALE_PLACEHOLDER, this.convertDeviceScalePlaceholder())
            .replace(SCALE_NAME_PLACEHOLDER, this.convertScaleNamePlaceholder())
            .replace(SAMPLE_KEY_PLACEHOLDER, this.convertSampleKeyPlaceholder())
            .replace(BT01_PH, transposedNotes[ButtonIndexes.BT01])
            .replace(BT02_PH, transposedNotes[ButtonIndexes.BT02])
            .replace(BT03_PH, transposedNotes[ButtonIndexes.BT03])
            .replace(BT04_PH, transposedNotes[ButtonIndexes.BT04])
            .replace(BT05_PH, transposedNotes[ButtonIndexes.BT05])
            .replace(BT06_PH, transposedNotes[ButtonIndexes.BT06])
            .replace(BT07_PH, transposedNotes[ButtonIndexes.BT07])
            .replace(BT08_PH, transposedNotes[ButtonIndexes.BT08])
            .replace(BT09_PH, transposedNotes[ButtonIndexes.BT09])
            .replace(BT10_PH, transposedNotes[ButtonIndexes.BT10])
            .replace(BT11_PH, transposedNotes[ButtonIndexes.BT11])
            .replace(BT12_PH, transposedNotes[ButtonIndexes.BT12])
            .replace(BT13_PH, transposedNotes[ButtonIndexes.BT13])
            .replace(BT14_PH, transposedNotes[ButtonIndexes.BT14])
            .replace(BT15_PH, transposedNotes[ButtonIndexes.BT15])
            .replace(BT16_PH, transposedNotes[ButtonIndexes.BT16])
    )
}
