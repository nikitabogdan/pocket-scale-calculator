package constants

import PocketScaleCalculator
import types.POScales
import types.PocketOperators
import types.Scales

const val APP_VERSION = "0.9"
const val ARGS_SEPARATOR = " "

object ArgsOrder {
    const val ROOT_KEY_OR_COMMAND_NAME = 0
    const val SCALE = 1
    const val SNAP_OFF_HANGER = 2
    const val PO_MODEL = 3
    const val PO_SCALE = 4
}

object ExitCodes {
    const val SUCCESS = 0
}

val helpKeywordsList = listOf("", "help", "tutorial", "description")
val exitKeywordsList = listOf("exit", "quit", "off", "terminate")
val optionsKeywordsList = listOf("options", "preferences")
val scalesKeywordsList = listOf("scales", "list")
val supportKeywordsList = listOf("donate", "support")
val aboutKeywordsList = listOf("about", "info")

const val HARMONIC_SHORTCUT = "h"
const val PENTATONIC_SHORTCUT = "pe"
const val MAJOR_SHORTCUT = "ma"
const val MINOR_SHORTCUT = "min"
const val BLUES_SHORTCUT = "bl"
const val ARAB_SHORTCUT = "ar"
const val DORIAN_SHORTCUT = "d"
const val LYDIAN_SHORTCUT = "ly"
const val PHRYGIAN_SHORTCUT = "ph"
const val MIXOLYDIAN_SHORTCUT = "mix"
const val LOCRIAN_SHORTCUT = "lo"
const val YES_SHORTCUT = "y"

const val WINDOW_WIDTH = 41
const val HEADER_FILLER_SIGN = "@"
const val INDENT = " "
const val DOUBLE_INDENT = "  "
const val ROOT_KEY_SURROUND_DEFINITION = "[]"
const val REGULAR_NOTE_SURROUND_DEFINITION = "  "
const val OUT_OF_SCALE_KEY_DEFINITION = "--"
const val DEFAULT_OCTAVE = 3

const val HEADER_ON = "ON"
const val HEADER_OFF = "OFF"
const val HEADER_OK = "OK"
const val HEADER_ERROR = "ERROR"
const val HEADER_DESCRIPTION = "DESCRIPTION"
const val HEADER_OPTIONS = "OPTIONS"
const val HEADER_SUPPORT = "SUPPORT"
const val HEADER_ABOUT = "ABOUT"
const val HEADER_SCALES = "SUPPORTED SCALES"

const val SAMPLE_KEY_TEXT = "Sample key: "
const val SCALE_KEY_TEXT = "Scale key: "
const val DEFAULT_INPUT_MESSAGE = "Input scale or press enter for help: "
const val SNAP_OFF_HANGER_OPTION_MESSAGE = "Snap off hanger? (y/n): "
const val PO_MODEL_OPTION_MESSAGE = "Pocket operator model? (128/33/35): "
const val PO_SCALE_OPTION_MESSAGE = "PO scale? (major/minor/blues/arab): "

val DESCRIPTION_MESSAGE_TEXT =
    "  Type something like 'd# maj' for D# Major or 'G5 MinH' for Harmonic G Minor or 'a# map' for " +
            "Pentatonic A# Major, or F#3 B for F# Blues and press enter. Please make sure you separate " +
            "root key & scale with space key, which is used to split input arguments. You could see found " +
            "scale on the ASCII-PO display and sample key to record into your PO to use this scale. Notes " +
            "with [] brackets are root notes for your scale. Empty -- notes are outside of calculated scale. " +
            "Supported scales are: Minor (Natural, Harmonic & Pentatonic), " +
            "Major (Natural, Harmonic & Pentatonic), ${Scales.MINOR_BLUES.scaleName}, " +
            "${Scales.MINOR_DORIAN.scaleName} and lots of others. \nAdditional commands:\n" +
            "'options' – set snap off hanger, PO model & PO scale (applicable for PO-35 only) settings; " +
            "'scales' – get full list of supported scales; " +
            "'info' – more info/about section; 'off' – exit app;\n\n" +
            "To start app with specific default scale and options please use following arguments list: " +
            "1:root note, 2:scale, 3:snap off hanger (y/n), 4:PO model (33/35+. For example: F MajP Y 35 " +
            "will start app with F Major Pentatonic setting, missing hanger option and PO-35 model UI. "

val SCALES_MESSAGE_TEXT =
    "  Minor:\n" +
            "  – ${Scales.MINOR_NATURAL_MINOR.scaleName} [shortcut: ${MINOR_SHORTCUT}]\n" +
            "  – ${Scales.MINOR_HARMONIC_MINOR.scaleName} [shortcut: $MINOR_SHORTCUT$HARMONIC_SHORTCUT]\n" +
            "  – ${Scales.MINOR_PENTATONIC_MINOR.scaleName} [shortcut: $MINOR_SHORTCUT$PENTATONIC_SHORTCUT]\n" +
            "  – ${Scales.MINOR_NATURAL_MAJOR.scaleName} [shortcut: $MAJOR_SHORTCUT]\n" +
            "  – ${Scales.MINOR_HARMONIC_MAJOR.scaleName} [shortcut: $MAJOR_SHORTCUT$HARMONIC_SHORTCUT]\n" +
            "  – ${Scales.MINOR_PENTATONIC_MAJOR.scaleName} [shortcut: $MAJOR_SHORTCUT$PENTATONIC_SHORTCUT]\n" +
            "  – ${Scales.MINOR_BLUES.scaleName} [shortcut: $BLUES_SHORTCUT]\n" +
            "  – ${Scales.MINOR_DORIAN.scaleName} [shortcut: $DORIAN_SHORTCUT]\n" +
            "  – ${Scales.MINOR_LYDIAN.scaleName} [shortcut: $LYDIAN_SHORTCUT]\n" +
            "  – ${Scales.MINOR_MIXOLYDIAN.scaleName} [shortcut: $MIXOLYDIAN_SHORTCUT]\n" +
            "  – ${Scales.MINOR_LOCRIAN.scaleName} [shortcut: $LOCRIAN_SHORTCUT]\n" +
            "  – ${Scales.MINOR_PHRYGIAN.scaleName} [shortcut: $PHRYGIAN_SHORTCUT]\n\n" +
            "  Major*:\n" +
            "  – ${Scales.MAJOR_NATURAL_MAJOR.scaleName} [shortcut: ${MAJOR_SHORTCUT}]\n" +
            "  – ${Scales.MAJOR_PENTATONIC_MAJOR.scaleName} [shortcut: $MAJOR_SHORTCUT$PENTATONIC_SHORTCUT]\n" +
            "  – ${Scales.MAJOR_NATURAL_MINOR.scaleName} [shortcut: ${MINOR_SHORTCUT}]\n" +
            "  – ${Scales.MAJOR_PENTATONIC_MINOR.scaleName} [shortcut: $MAJOR_SHORTCUT$PENTATONIC_SHORTCUT]\n" +
            "  – ${Scales.MAJOR_DORIAN.scaleName} [shortcut: $DORIAN_SHORTCUT]\n" +
            "  – ${Scales.MAJOR_LYDIAN.scaleName} [shortcut: $LYDIAN_SHORTCUT]\n" +
            "  – ${Scales.MAJOR_MIXOLYDIAN.scaleName} [shortcut: $MIXOLYDIAN_SHORTCUT]\n" +
            "  – ${Scales.MAJOR_LOCRIAN.scaleName} [shortcut: $LOCRIAN_SHORTCUT]\n" +
            "  – ${Scales.MAJOR_PHRYGIAN.scaleName} [shortcut: $PHRYGIAN_SHORTCUT]\n\n" +
            "  Blues*:\n" +
            "  – ${Scales.BLUES_BLUES.scaleName} [shortcut: ${BLUES_SHORTCUT}]\n\n" +
            "  Arab*:\n" +
            "  – ${Scales.ARAB.scaleName} [shortcut: ${ARAB_SHORTCUT}]\n\n" +
            "* applicable for PO-35/137 series only"

const val ABOUT_MESSAGE_TEXT =
    "  Pocket Scale Calculator. Version: $APP_VERSION \n For Teenage Engineering PO-33 / PO-133 and, " +
            "PO-35 / PO-137 series https://teenage.engineering/products/po " +
            "Inspired by https://punkyv4n.me/po-33-scale-app \nDev: Nikita Bogdan \nEmail: nikita.bogdan@me.com \n" +
            "Github: nikitabogdan/pocket-scale-calculator"

const val SUPPORT_MESSAGE_TEXT =
    "If you enjoyed Pocket Scale Calculator, you can support development of the next app versions. " +
            "Donations could be accepted to the following xrp address: rD8aqf3YcxYZ3Lzv9vuoqeTfmgb4e7TdXm"

fun PocketScaleCalculator.replaceModelPlaceholder() = when (this.poModel) {
    PocketOperators.PO_35 ->
        "@                °#  O°o*          oo   @\n" +
                "@   speak       *#OO°#°oO          @#   @\n"
    PocketOperators.PO_33 ->
        "@                °#  O°o*          oo   @\n" +
                "@   K.O./       *#OO°#°oO          @#   @\n"
    PocketOperators.PO_128 ->
        "@    °#  O°o*     MEGAMAN        ,@On   @\n" +
                "@   *#OO°#°oO    []ッnマン       J@#L   @\n"

}

fun PocketScaleCalculator.prepareCalculationsDraft() = if (this.snapOffHanger) {
    "                                         \n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
} else {
    "                                         \n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
            "@@POCKET@°                      °@@@@@@@@\n" +
            "@@SCALE@   .@@@@@@@@@@@@@@@@@@.   @@@@@@@\n" +
            "@@@CALC@   .@@@@@@@@@@@@@@@@@#.   @@@@@@@\n" +
            "@@@@@@@@@.    pocket operator   .@@@@@@@@\n" +
            "@@@@@@@@@O**o*  *****o***  ***o#@@@@@@@@@\n"
} + this.replaceModelPlaceholder() +
        "@          ...................     °°   @\n" +
        "@   #################################   @\n" +
        "@   ##  ${Placeholders.PO_SCALE} ##   @\n" +
        "@   ## ${Placeholders.SCALE_NAME} ##   @\n" +
        "@  .## ${Placeholders.SAMPLE_KEY} ##   @\n" +
        "@  .##                             ##   @\n" +
        "@.  ##  ${ROOT_KEY_SURROUND_DEFINITION}: root; ${OUT_OF_SCALE_KEY_DEFINITION}: out of scale ##  .@\n" +
        "@*  *o°#########################Ooo*o  *@\n" +
        "@.       ..''''''''''''''''''''        .@\n" +
        "@   .*** °'.ooo.  .ooo.  #°@##o #°@@Oo  @\n" +
        "@  .@*°@o °@*.#@  @O O#  @*@@°# @#@@°@  @\n" +
        "@   'ooO'  'OoO°  'OoO°  o*oo@* o**o#*  @\n" +
        "@                                 ,_.   @\n" +
        "@                                @O.@#  @\n" +
        "@   ${Placeholders.BT01}  ${Placeholders.BT02}  ${Placeholders.BT03}  ${Placeholders.BT04}   'OoO*  @\n" +
        "@                                 °°'   @\n" +
        "@                                 ,o.   @\n" +
        "@                                @O.@#  @\n" +
        "@   ${Placeholders.BT05}  ${Placeholders.BT06}  ${Placeholders.BT07}  ${Placeholders.BT08}   'OoO*  @\n" +
        "@                                 °'    @\n" +
        "@                                 oo*.  @\n" +
        "@                                @O.@#  @\n" +
        "@   ${Placeholders.BT09}  ${Placeholders.BT10}  ${Placeholders.BT11}  ${Placeholders.BT12}   'OoO*  @\n" +
        "@                                  °°   @\n" +
        "@                                 ,o.   @\n" +
        "@                                @O.@#  @\n" +
        "@   ${Placeholders.BT13}  ${Placeholders.BT14}  ${Placeholders.BT15}  ${Placeholders.BT16}   'OoO*  @\n" +
        "@                                       @\n" +
        "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
        "                                         "


fun preparePODeviceScaleText(poModel: PocketOperators, scale: POScales) =
    "PO-${poModel.model} Scale: ${scale.scaleName}"

fun prepareUnrecognisedInputErrorMessage(rootKey: String) = "Input [$rootKey] is unrecognised, please try again"
const val INCONSISTENT_ROOT_KEY_ERROR_MESSAGE = "Unable to drop octave for empty root key"
