package methods

import PocketScaleCalculator
import constants.INCONSISTENT_ROOT_KEY_ERROR_MESSAGE
import constants.INDENT
import constants.MAJOR_TO_DORIAN_TRANSPOSE_SHIFT
import constants.MAJOR_TO_LOCRIAN_TRANSPOSE_SHIFT
import constants.MAJOR_TO_LYDIAN_TRANSPOSE_SHIFT
import constants.MAJOR_TO_MINOR_TRANSPOSE_SHIFT
import constants.MAJOR_TO_MIXOLYDIAN_TRANSPOSE_SHIFT
import constants.MAJOR_TO_PHRYGIAN_TRANSPOSE_SHIFT
import constants.MINOR_TO_BLUES_DORIAN_TRANSPOSE_SHIFT
import constants.MINOR_TO_LYDIAN_TRANSPOSE_SHIFT
import constants.MINOR_TO_MAJOR_TRANSPOSE_SHIFT
import constants.OUT_OF_SCALE_KEY_DEFINITION
import constants.Placeholders.PO_SCALE
import constants.Placeholders.SAMPLE_KEY
import constants.Placeholders.SCALE_NAME
import constants.REGULAR_NOTE_SURROUND_DEFINITION
import constants.ROOT_KEY_SURROUND_DEFINITION
import constants.SAMPLE_KEY_TEXT
import constants.preparePODeviceScaleText
import types.Scales

fun String.dropOctave() = if (this.isNotEmpty()) {
    if (this.last().isDigit()) this.dropLast(1) else this
} else {
    throw IllegalArgumentException(INCONSISTENT_ROOT_KEY_ERROR_MESSAGE)
}

fun String.addCharsToFullLine(expectedLength: Int) =
    if (this.length < expectedLength) INDENT.repeat(expectedLength - this.length) + this else this

fun userInputHasText(text: String): Boolean = readln().lowercase().indexOf(text) > -1

fun PocketScaleCalculator.convertNotePlaceholder(
    semitones: Int, root: Boolean = false, outOfScale: Boolean = false
): String {
    val fillRoot = if (root) ROOT_KEY_SURROUND_DEFINITION else REGULAR_NOTE_SURROUND_DEFINITION
    val printNote = if (outOfScale) OUT_OF_SCALE_KEY_DEFINITION else this.transposeNote(semitones)
    val wrappedNote = "${fillRoot.first()}$printNote${fillRoot.last()}"
    return when (printNote.length) {
        1 -> "$INDENT$wrappedNote$INDENT"
        2 -> "$INDENT$wrappedNote"
        else -> wrappedNote
    }
}

fun PocketScaleCalculator.convertDeviceScalePlaceholder() =
    preparePODeviceScaleText(poModel, poScale).addCharsToFullLine(PO_SCALE.length)

fun PocketScaleCalculator.convertScaleNamePlaceholder() = "${rootKey.dropOctave()} ${scale.scaleName}"
    .addCharsToFullLine(SCALE_NAME.length)

fun PocketScaleCalculator.convertSampleKeyPlaceholder() = "$SAMPLE_KEY_TEXT${
    when (scale) {
        Scales.MINOR_NATURAL_MINOR, Scales.MINOR_HARMONIC_MINOR, Scales.MINOR_PENTATONIC_MINOR -> rootKey
        Scales.MINOR_NATURAL_MAJOR, Scales.MINOR_HARMONIC_MAJOR, Scales.MINOR_PENTATONIC_MAJOR -> this
            .transposeNote(MINOR_TO_MAJOR_TRANSPOSE_SHIFT)
        Scales.MINOR_BLUES, Scales.MINOR_DORIAN -> this.transposeNote(MINOR_TO_BLUES_DORIAN_TRANSPOSE_SHIFT)
        Scales.MINOR_LYDIAN -> this.transposeNote(MINOR_TO_LYDIAN_TRANSPOSE_SHIFT)
        Scales.MAJOR_NATURAL_MAJOR, Scales.MAJOR_PENTATONIC_MAJOR -> rootKey
        Scales.MAJOR_NATURAL_MINOR, Scales.MAJOR_PENTATONIC_MINOR -> this.transposeNote(MAJOR_TO_MINOR_TRANSPOSE_SHIFT)
        Scales.MAJOR_PHRYGIAN -> this.transposeNote(MAJOR_TO_PHRYGIAN_TRANSPOSE_SHIFT)
        Scales.MAJOR_LYDIAN -> this.transposeNote(MAJOR_TO_LYDIAN_TRANSPOSE_SHIFT)
        Scales.MAJOR_MIXOLYDIAN -> this.transposeNote(MAJOR_TO_MIXOLYDIAN_TRANSPOSE_SHIFT)
        Scales.MAJOR_LOCRIAN -> this.transposeNote(MAJOR_TO_LOCRIAN_TRANSPOSE_SHIFT)
        Scales.MAJOR_DORIAN -> this.transposeNote(MAJOR_TO_DORIAN_TRANSPOSE_SHIFT)
    }
}".addCharsToFullLine(SAMPLE_KEY.length)

