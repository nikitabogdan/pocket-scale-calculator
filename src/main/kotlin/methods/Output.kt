package methods

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
import constants.Placeholders.BT01
import constants.Placeholders.BT02
import constants.Placeholders.BT03
import constants.Placeholders.BT04
import constants.Placeholders.BT05
import constants.Placeholders.BT06
import constants.Placeholders.BT07
import constants.Placeholders.BT08
import constants.Placeholders.BT09
import constants.Placeholders.BT10
import constants.Placeholders.BT11
import constants.Placeholders.BT12
import constants.Placeholders.BT13
import constants.Placeholders.BT14
import constants.Placeholders.BT15
import constants.Placeholders.BT16
import constants.Placeholders.MODEL
import constants.Placeholders.PO_SCALE
import constants.Placeholders.SAMPLE_KEY
import constants.Placeholders.SCALE_NAME
import constants.ROOT_KEY_SURROUND_DEFINITION
import constants.WINDOW_WIDTH
import types.Scales

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
    println("    – ${Scales.MINOR_BLUES.scaleName}")
    println("    – ${Scales.MINOR_DORIAN.scaleName}")
    println("    – ${Scales.MINOR_LYDIAN.scaleName}")
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
        "@@@@   $MODEL       *#OO°#°oO          @#   @@@@\n" +
        "@@@@          ...................     °°   @@@@\n" +
        "@@@@   #################################   @@@@\n" +
        "@@@@   @@  $PO_SCALE ##   @@@@\n" +
        "@@@@   ## $SCALE_NAME ##   @@@@\n" +
        "@@@@  .## $SAMPLE_KEY ##   @@@@\n" +
        "@@@@  .##                             ##   @@@@\n" +
        "@@@@.  ##  $ROOT_KEY_SURROUND_DEFINITION: root; $OUT_OF_SCALE_KEY_DEFINITION: out of scale ##  .@@@@\n" +
        "@@@@*  *o°#########################Ooo*o  *@@@@\n" +
        "@@@@.       ..''''''''''''''''''''        .@@@@\n" +
        "@@@O   .*** °'.ooo.  .ooo.  #°@##o #°@@Oo  @@@@\n" +
        "@@@O  .@*°@o °@*.#@  @O O#  @*@@°# @#@@°@  @@@@\n" +
        "@@@O   'ooO'  'OoO°  'OoO°  o*oo@* o**o#*  @@@@\n" +
        "@@@O                                 ,_.   @@@@\n" +
        "@@@O                                @O.@#  @@@@\n" +
        "@@@@   $BT01  $BT02  $BT03  $BT04   'OoO*  @@@@\n" +
        "@@@@                                 °°'   O@@@\n" +
        "@@@O                                 ,o.   O@@@\n" +
        "@@@@                                @O.@#  @@@@\n" +
        "@@@O   $BT05  $BT06  $BT07  $BT08   'OoO*  @@@@\n" +
        "@@@@                                 °'    @@@@\n" +
        "@@@O                                 oo*.  O@@@\n" +
        "@@@@                                @O.@#  @@@@\n" +
        "@@@O   $BT09  $BT10  $BT11  $BT12   'OoO*  @@@@\n" +
        "@@@@                                  °°   @@@@\n" +
        "@@@O                                 ,o.   @@@@\n" +
        "@@@@                                @O.@#  @@@@\n" +
        "@@@@   $BT13  $BT14  $BT15  $BT16   'OoO*  @@@@\n" +
        "@@@@                                       @@@@\n" +
        "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
        "                                               "

fun PocketScaleCalculator.printCalculations(transposedNotes: Array<String>) {
    println(
        this.prepareCalculationsDraft()
            .replace(MODEL, this.poModel.displayName)
            .replace(PO_SCALE, this.convertDeviceScalePlaceholder())
            .replace(SCALE_NAME, this.convertScaleNamePlaceholder())
            .replace(SAMPLE_KEY, this.convertSampleKeyPlaceholder())
            .replace(BT01, transposedNotes[ButtonIndexes.BT01])
            .replace(BT02, transposedNotes[ButtonIndexes.BT02])
            .replace(BT03, transposedNotes[ButtonIndexes.BT03])
            .replace(BT04, transposedNotes[ButtonIndexes.BT04])
            .replace(BT05, transposedNotes[ButtonIndexes.BT05])
            .replace(BT06, transposedNotes[ButtonIndexes.BT06])
            .replace(BT07, transposedNotes[ButtonIndexes.BT07])
            .replace(BT08, transposedNotes[ButtonIndexes.BT08])
            .replace(BT09, transposedNotes[ButtonIndexes.BT01.octaveDown()])
            .replace(BT10, transposedNotes[ButtonIndexes.BT02.octaveDown()])
            .replace(BT11, transposedNotes[ButtonIndexes.BT03.octaveDown()])
            .replace(BT12, transposedNotes[ButtonIndexes.BT04.octaveDown()])
            .replace(BT13, transposedNotes[ButtonIndexes.BT05.octaveDown()])
            .replace(BT14, transposedNotes[ButtonIndexes.BT06.octaveDown()])
            .replace(BT15, transposedNotes[ButtonIndexes.BT07.octaveDown()])
            .replace(BT16, transposedNotes[ButtonIndexes.BT08.octaveDown()])
    )
}
