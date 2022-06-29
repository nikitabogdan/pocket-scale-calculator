package constants

import helpers.transpose
import types.Notes

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

const val PO_BUTTONS_TO_OCTAVE_DOWN = 8
const val PO_NOTES_BUTTONS_COUNT = 16

@SuppressWarnings("MagicNumber")
object TransposeDiagrams {
    val po33Minor = intArrayOf(7, 8, 10, 11, 0, 2, 3, 5, -5, -4, -2, -1, -12, -10, -9, -7)
    val po33Major = po33Minor.transpose(MINOR_TO_MAJOR_TRANSPOSE_SHIFT)
    val po33BluesDorian = po33Minor.transpose(MINOR_TO_BLUES_DORIAN_TRANSPOSE_SHIFT)
    val po33Lydian = po33Minor.transpose(MINOR_TO_LYDIAN_TRANSPOSE_SHIFT)
    // val po35Major = arrayOf(7, 9, 10, 11, 0, 2, 4, 5, -5, -3, -2, -1, -12, -10, -8, -7)
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
    const val BT09 = 8
    const val BT10 = 9
    const val BT11 = 10
    const val BT12 = 11
    const val BT13 = 12
    const val BT14 = 13
    const val BT15 = 14
    const val BT16 = 15
}

