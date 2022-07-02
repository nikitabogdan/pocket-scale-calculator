package constants

import types.POScales
import types.PocketOperators

const val APP_VERSION = "0.8"
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
    // const val BAD_ARGUMENTS = 1
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
const val BLUES_SHORTCUT = "b"
const val DORIAN_SHORTCUT = "d"
const val LYDIAN_SHORTCUT = "ly"
const val PHRYGIAN_SHORTCUT = "ph"
const val MIXOLYDIAN_SHORTCUT = "mix"
const val LOCRIAN_SHORTCUT = "lo"
const val YES_SHORTCUT = "y"

const val WINDOW_WIDTH = 47
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
const val HEADER_SCALES = "SCALES"

const val SAMPLE_KEY_TEXT = "Sample key: "
const val DEFAULT_INPUT_MESSAGE = "Input scale or press enter for help: "
const val SNAP_OFF_HANGER_OPTION_MESSAGE = "Snap off hanger? (y/n): "
const val PO_MODEL_OPTION_MESSAGE = "Pocket operator model? (33/35): "
const val PO_SCALE_OPTION_MESSAGE = "Pocket operator scale? (major/minor): "

fun preparePODeviceScaleText(poModel: PocketOperators, scale: POScales) =
    "PO-${poModel.modelIndex} Scale: ${scale.scaleName}"

fun prepareUnrecognisedInputErrorMessage(rootKey: String) = "Input [$rootKey] is unrecognised, please try again"
const val INCONSISTENT_ROOT_KEY_ERROR_MESSAGE = "Unable to drop octave for empty root key"
