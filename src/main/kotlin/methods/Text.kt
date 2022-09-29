package methods

import PocketScaleCalculator
import constants.INCONSISTENT_ROOT_KEY_ERROR_MESSAGE
import constants.INDENT
import constants.OUT_OF_SCALE_KEY_DEFINITION
import constants.Placeholders.PO_SCALE
import constants.Placeholders.SAMPLE_KEY
import constants.Placeholders.SCALE_NAME
import constants.REGULAR_NOTE_SURROUND_DEFINITION
import constants.ROOT_KEY_SURROUND_DEFINITION
import constants.SAMPLE_KEY_TEXT
import constants.SCALE_KEY_TEXT
import constants.preparePODeviceScaleText
import types.PocketOperators

fun String.dropOctave() = if (this.isNotEmpty()) {
    if (this.last().isDigit()) this.dropLast(1) else this
} else {
    throw IllegalArgumentException(INCONSISTENT_ROOT_KEY_ERROR_MESSAGE)
}

fun String.addCharsToFullLine(expectedLength: Int) =
    if (this.length < expectedLength) INDENT.repeat(expectedLength - this.length) + this else this

fun readUserInput(): String = readln().lowercase()

fun String.hasText(text: String): Boolean = this.indexOf(text) > -1

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

fun PocketScaleCalculator.convertScaleNamePlaceholder() =
    "${rootKey.dropOctave()} ${scale.scaleName}".addCharsToFullLine(SCALE_NAME.length)

fun PocketScaleCalculator.convertSampleKeyPlaceholder() =
    ((if (this.poModel == PocketOperators.PO_128) SCALE_KEY_TEXT else SAMPLE_KEY_TEXT) +
            this.transposeNote(scale.transposeShift)).addCharsToFullLine(SAMPLE_KEY.length)

