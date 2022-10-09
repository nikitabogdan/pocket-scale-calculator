package methods

import PocketScaleCalculator
import constants.INCONSISTENT_TONIC_ERROR_MESSAGE
import constants.INDENT
import constants.OUT_OF_SCALE_KEY_DEFINITION
import constants.Placeholders.PO_SCALE
import constants.Placeholders.SAMPLE_KEY
import constants.Placeholders.SCALE_NAME
import constants.REGULAR_NOTE_SURROUND_DEFINITION
import constants.SAMPLE_KEY_TEXT
import constants.SCALE_KEY_TEXT
import constants.TONIC_KEY_PITCH_TEXT
import constants.TONIC_KEY_SURROUND_DEFINITION
import constants.preparePODeviceScaleText
import types.PocketOperators

fun String.dropOctave() = if (this.isNotEmpty()) {
    if (this.last().isDigit()) this.dropLast(1) else this
} else {
    throw IllegalArgumentException(INCONSISTENT_TONIC_ERROR_MESSAGE)
}

fun String.addCharsToFullLine(expectedLength: Int) =
    if (this.length < expectedLength) INDENT.repeat(expectedLength - this.length) + this else this

fun readUserInput(): String = readln().lowercase()

fun String.hasText(text: String): Boolean = this.indexOf(text) > -1

fun PocketScaleCalculator.convertNotePlaceholder(
    semitones: Int,
    tonic: Boolean = false,
    outOfScale: Boolean = false
): String {
    val fillTonic = if (tonic) TONIC_KEY_SURROUND_DEFINITION else REGULAR_NOTE_SURROUND_DEFINITION
    val printNote = if (outOfScale) OUT_OF_SCALE_KEY_DEFINITION else this.transposeNote(semitones)
    val wrappedNote = "${fillTonic.first()}$printNote${fillTonic.last()}"
    return when (printNote.length) {
        1 -> "$INDENT$wrappedNote$INDENT"
        2 -> "$INDENT$wrappedNote"
        else -> wrappedNote
    }
}

fun PocketScaleCalculator.convertDeviceScalePlaceholder() =
    preparePODeviceScaleText(poModel, poScale).addCharsToFullLine(PO_SCALE.length)

fun PocketScaleCalculator.convertScaleNamePlaceholder() =
    "${tonic.dropOctave()} ${scale.scaleName}".addCharsToFullLine(SCALE_NAME.length)

fun PocketScaleCalculator.convertSampleKeyPlaceholder() =
    (when (this.poModel) {
        PocketOperators.PO_32 -> TONIC_KEY_PITCH_TEXT
        PocketOperators.PO_128 -> SCALE_KEY_TEXT
        else -> SAMPLE_KEY_TEXT
    } + this.transposeNote(scale.transposeShift)).addCharsToFullLine(SAMPLE_KEY.length)

