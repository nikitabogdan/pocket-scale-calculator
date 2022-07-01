package helpers

import PocketScaleCalculator
import constants.PO_BUTTONS_TO_OCTAVE_DOWN
import constants.PO_NOTES_BUTTONS_COUNT
import constants.notesOrder

fun IntArray.transpose(semitones: Int) = IntArray(size) { PO_NOTES_BUTTONS_COUNT }
    .also { this.forEach { element -> it[this.indexOf(element)] = element + semitones } }

fun Int.octaveDown() = this + PO_BUTTONS_TO_OCTAVE_DOWN

@SuppressWarnings("MagicNumber")
fun String.transposeOctave(semitones: Int): Int {
    var octave = if (this.last().isDigit()) this.last().digitToInt() else 2
    when (notesOrder.indexOf(dropOctave().uppercase()) + semitones) {
        in 12..23 -> octave++
        // in 0..11 -> octave
        in -12..-1 -> octave--
        in -24..-13 -> octave -= 2
        in -36..-25 -> octave -= 3
    }

    return octave
}

fun PocketScaleCalculator.transposeNote(semitones: Int, withOctave: Boolean = true) =
    "${notesOrder[(notesOrder.indexOf(this.rootKey.dropOctave().uppercase()) + semitones).mod(notesOrder.size)]}${
        if (withOctave) this.rootKey.transposeOctave(semitones) else ""
    }"

fun PocketScaleCalculator.transposeNotesGroup() =
    Array(PO_NOTES_BUTTONS_COUNT) { "" }.also {
        this.scale.transposeDiagram.forEach { element ->
            it[this.scale.transposeDiagram.indexOf(element)] =
                if (this.scale.transposeDiagram.indexOf(element) in this.scale.outOfScaleKeyIndexes) {
                    this.convertNotePlaceholder(semitones = element, outOfScale = true)
                } else if (this.scale.transposeDiagram.indexOf(element) in this.scale.rootKeyIndexes) {
                    this.convertNotePlaceholder(semitones = element, root = true)
                } else {
                    this.convertNotePlaceholder(semitones = element)
                }
        }
    }
