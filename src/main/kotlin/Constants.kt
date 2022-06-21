
val notes: Array<String> = arrayOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")

object TransposeDiagrams {
    val po33Minor = arrayOf(7, 8, 10, 11, 0, 2, 3, 5, -5, -4, -2, -1, -12, -10, -9, -7)
    val po33Major = po33Minor.transposeDiagram(MINOR_TO_MAJOR_TRANSPOSE_SHIFT)
    val po33BluesDorian = po33Minor.transposeDiagram(MINOR_TO_BLUES_DORIAN_TRANSPOSE_SHIFT)
    val po33Lydian = po33Minor.transposeDiagram(MINOR_TO_LYDIAN_TRANSPOSE_SHIFT)
    // val po35Major = arrayOf(7, 9, 10, 11, 0, 2, 4, 5, -5, -3, -2, -1, -12, -10, -8, -7)
}

const val MINOR_TO_MAJOR_TRANSPOSE_SHIFT = -3
const val MINOR_TO_BLUES_DORIAN_TRANSPOSE_SHIFT = -5
const val MINOR_TO_LYDIAN_TRANSPOSE_SHIFT = -8

const val APP_VERSION = "0.6"

const val HARMONIC_SHORTCUT = "h"
const val PENTATONIC_SHORTCUT = "p"
const val MAJOR_SHORTCUT = "ma"
const val BLUES_SHORTCUT = "b"
const val DORIAN_SHORTCUT = "d"
const val LYDIAN_SHORTCUT = "l"
const val YES_SHORTCUT = "y"

const val ROOT_KEY_DEFINITION = "[]"
const val REGULAR_NOTE_DEFINITION = "  "
const val OUT_OF_SCALE_KEY_DEFINITION = "--"

const val DEVICE_PLACEHOLDER = "%PON%"
const val PO_SCALE_PLACEHOLDER = "DISPLAY_PLACEHOLDER_LINE1%"
const val SCALE_NAME_PLACEHOLDER = "%DISPLAY_PLACEHOLDER_LINE2%"
const val SAMPLE_KEY_PLACEHOLDER = "%DISPLAY_PLACEHOLDER_LINE3%"
const val BUTTON_1_PLACEHOLDER = "%B01%"
const val BUTTON_2_PLACEHOLDER = "%B02%"
const val BUTTON_3_PLACEHOLDER = "%B03%"
const val BUTTON_4_PLACEHOLDER = "%B04%"
const val BUTTON_5_PLACEHOLDER = "%B05%"
const val BUTTON_6_PLACEHOLDER = "%B06%"
const val BUTTON_7_PLACEHOLDER = "%B07%"
const val BUTTON_8_PLACEHOLDER = "%B08%"
const val BUTTON_9_PLACEHOLDER = "%B09%"
const val BUTTON_10_PLACEHOLDER = "%B10%"
const val BUTTON_11_PLACEHOLDER = "%B11%"
const val BUTTON_12_PLACEHOLDER = "%B12%"
const val BUTTON_13_PLACEHOLDER = "%B13%"
const val BUTTON_14_PLACEHOLDER = "%B14%"
const val BUTTON_15_PLACEHOLDER = "%B15%"
const val BUTTON_16_PLACEHOLDER = "%B16%"
const val PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN = 8
const val DEFAULT_ROOT_KEY = "A"
val DEFAULT_SCALE = Scales.NATURAL_MINOR