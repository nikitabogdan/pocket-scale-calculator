package constants

import methods.transpose

object Notes {
    const val C = "C"
    const val C_SHARP = "C#"
    const val D = "D"
    const val D_SHARP = "D#"
    const val E = "E"
    const val F = "F"
    const val F_SHARP = "F#"
    const val G = "G"
    const val G_SHARP = "G#"
    const val A = "A"
    const val A_SHARP = "A#"
    const val B = "B"
}

val notesOrder: Array<String> = arrayOf(
    Notes.C,
    Notes.C_SHARP,
    Notes.D,
    Notes.D_SHARP,
    Notes.E,
    Notes.F,
    Notes.F_SHARP,
    Notes.G,
    Notes.G_SHARP,
    Notes.A,
    Notes.A_SHARP,
    Notes.B
)

const val MINOR_TO_MAJOR_TRANSPOSE_SHIFT = -3
const val MINOR_TO_BLUES_DORIAN_TRANSPOSE_SHIFT = -5
const val MINOR_TO_LYDIAN_TRANSPOSE_SHIFT = -8

const val MAJOR_TO_MINOR_PHRYGIAN_TRANSPOSE_SHIFT = -9
const val MAJOR_TO_LYDIAN_TRANSPOSE_SHIFT = -5
const val MAJOR_TO_DORIAN_TRANSPOSE_SHIFT = -2

const val PO_BUTTONS_TO_OCTAVE_DOWN = 8
const val PO_NOTES_BUTTONS_COUNT = 16

@SuppressWarnings("MagicNumber")
object TransposeDiagrams {
    val po33Minor = intArrayOf(7, 8, 10, 11, 0, 2, 3, 5, -5, -4, -2, -1, -12, -10, -9, -7)
    val po33Major = po33Minor.transpose(MINOR_TO_MAJOR_TRANSPOSE_SHIFT)
    val po33BluesDorian = po33Minor.transpose(MINOR_TO_BLUES_DORIAN_TRANSPOSE_SHIFT)
    val po33Lydian = po33Minor.transpose(MINOR_TO_LYDIAN_TRANSPOSE_SHIFT)

    val po35Major = intArrayOf(7, 9, 10, 11, 0, 2, 4, 5, -5, -3, -2, -1, -12, -10, -8, -7)
    val po35MinorPhrygian = po35Major.transpose(MAJOR_TO_MINOR_PHRYGIAN_TRANSPOSE_SHIFT)
    val po35Lydian = po35Major.transpose(MAJOR_TO_LYDIAN_TRANSPOSE_SHIFT)
    val po35Dorian = po35Major.transpose(MAJOR_TO_DORIAN_TRANSPOSE_SHIFT)
}

object ButtonIndexes {
    const val BT01 = 0
    const val BT02 = 1
    const val BT03 = 2
    const val BT04 = 3
    const val BT05 = 4
    const val BT06 = 5
    const val BT07 = 6
    const val BT08 = 7
}

object Placeholders {
    const val MODEL = "%PON%"
    const val PO_SCALE = "DISPLAY_PLACEHOLDER_LINE1%"
    const val SCALE_NAME = "%DISPLAY_PLACEHOLDER_LINE2%"
    const val SAMPLE_KEY = "%DISPLAY_PLACEHOLDER_LINE3%"
    const val BT01 = "%B01%"
    const val BT02 = "%B02%"
    const val BT03 = "%B03%"
    const val BT04 = "%B04%"
    const val BT05 = "%B05%"
    const val BT06 = "%B06%"
    const val BT07 = "%B07%"
    const val BT08 = "%B08%"
    const val BT09 = "%B09%"
    const val BT10 = "%B10%"
    const val BT11 = "%B11%"
    const val BT12 = "%B12%"
    const val BT13 = "%B13%"
    const val BT14 = "%B14%"
    const val BT15 = "%B15%"
    const val BT16 = "%B16%"
}


