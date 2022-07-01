package methods

import PocketScaleCalculator
import constants.INCONSISTENT_ROOT_KEY_ERROR_MESSAGE
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
import constants.prepareInconsistentNoteLengthErrorMessage
import constants.prepareScaleNameText
import types.MinorScales
import types.PO35Scales
import types.PocketOperators

fun String.dropOctave() = if (this.isNotEmpty()) {
    if (this.last().isDigit()) this.dropLast(1) else this
} else {
    throw IllegalArgumentException(INCONSISTENT_ROOT_KEY_ERROR_MESSAGE)
}

fun String.addCharsToFullLine(expectedLength: Int) =
    if (this.length < expectedLength) " ".repeat(expectedLength - this.length) + this else this

fun userInputHasText(text: String): Boolean = readln().lowercase().indexOf(text) > -1

@SuppressWarnings("MagicNumber")
fun PocketScaleCalculator.convertNotePlaceholder(
    semitones: Int, root: Boolean = false, outOfScale: Boolean = false
): String {
    val fillRoot = if (root) ROOT_KEY_SURROUND_DEFINITION else REGULAR_NOTE_SURROUND_DEFINITION
    val printNote = if (outOfScale) OUT_OF_SCALE_KEY_DEFINITION else this.transposeNote(semitones)
    val wrappedNote = "${fillRoot.first()}$printNote${fillRoot.last()}"
    return when (printNote.length) {
        1 -> " $wrappedNote "
        2 -> " $wrappedNote"
        3 -> wrappedNote
        else -> {
            throw IllegalArgumentException(prepareInconsistentNoteLengthErrorMessage(printNote))
        }
    }
}

fun PocketScaleCalculator.convertDeviceScalePlaceholder() =
    (if (poModel == PocketOperators.PO_33) "" else prepareScaleNameText(PO35Scales.MINOR))
        .addCharsToFullLine(PO_SCALE.length)

fun PocketScaleCalculator.convertScaleNamePlaceholder() = "${rootKey.dropOctave()} ${scale.scaleName}"
    .addCharsToFullLine(SCALE_NAME.length)

fun PocketScaleCalculator.convertSampleKeyPlaceholder() = "$SAMPLE_KEY_TEXT${
    when (scale) {
        MinorScales.NATURAL_MINOR, MinorScales.HARMONIC_MINOR, MinorScales.PENTATONIC_MINOR -> rootKey
        MinorScales.NATURAL_MAJOR, MinorScales.HARMONIC_MAJOR, MinorScales.PENTATONIC_MAJOR -> this
            .transposeNote(MINOR_TO_MAJOR_TRANSPOSE_SHIFT, true)
        MinorScales.BLUES, MinorScales.DORIAN -> this.transposeNote(MINOR_TO_BLUES_DORIAN_TRANSPOSE_SHIFT, true)
        MinorScales.LYDIAN -> this.transposeNote(MINOR_TO_LYDIAN_TRANSPOSE_SHIFT, true)
    }
}".addCharsToFullLine(SAMPLE_KEY.length)

