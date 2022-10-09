package methods

import PocketScaleCalculator
import constants.DEFAULT_OCTAVE
import constants.PO_BUTTONS_TO_OCTAVE_DOWN
import constants.PO_NOTES_BUTTONS_COUNT
import constants.notesOrder
import types.PocketOperators

fun IntArray.transpose(semitones: Int) = IntArray(size) { PO_NOTES_BUTTONS_COUNT }
    .also { this.forEach { element -> it[this.indexOf(element)] = element + semitones } }

fun Int.octaveDown() = this + PO_BUTTONS_TO_OCTAVE_DOWN

fun Int.getListOfTonicIndexesForBothOctaves() = listOf(this, this.octaveDown())

fun Int.getListOfOutOfScaleIndexesForBothOctaves() = listOf(this, this.octaveDown())

fun IntArray.getListOfOutOfScaleIndexesForBothOctaves(): List<Int> {
    var list: List<Int> = mutableListOf()
    this.forEach {
        list = list.plus(it).plus(it.octaveDown())
    }
    return list
}

@SuppressWarnings("MagicNumber")
fun String.transposeOctave(semitones: Int): Int {
    var octave = if (this.last().isDigit()) this.last().digitToInt() else DEFAULT_OCTAVE
    when (notesOrder.indexOf(dropOctave().uppercase()) + semitones) {
        in 12..23 -> octave++
        // in 0..11 -> octave
        in -12..-1 -> octave--
        in -24..-13 -> octave -= 2
        in -36..-25 -> octave -= 3
    }

    return octave
}

@SuppressWarnings("MagicNumber", "ComplexMethod")
fun PocketScaleCalculator.transposeNote(semitones: Int, withOctave: Boolean = true) =
    if (this.poModel != PocketOperators.PO_32)
        "${notesOrder[(notesOrder.indexOf(this.tonic.dropOctave().uppercase()) + semitones).mod(notesOrder.size)]}${
            if (withOctave) this.tonic.transposeOctave(semitones) else ""
        }" else when (semitones) {
        -15 -> "0"
        -14 -> "3"
        -13 -> "6"
        -12 -> "10"
        -11 -> "13"
        -10 -> "16"
        -9 -> "20"
        -8 -> "23"
        -7 -> "26"
        -6 -> "30"
        -5 -> "33"
        -4 -> "36"
        -3 -> "40"
        -2 -> "43"
        -1 -> "46"
        0 -> "50"
        1 -> "54"
        2 -> "57"
        3 -> "60"
        4 -> "64"
        5 -> "67"
        6 -> "70"
        7 -> "74"
        8 -> "77"
        9 -> "80"
        10 -> "84"
        11 -> "87"
        12 -> "90"
        13 -> "94"
        14 -> "97"
        15 -> "100"
        else -> "--"
    }

fun PocketScaleCalculator.transposeNotesGroup() =
    Array(PO_NOTES_BUTTONS_COUNT) { "" }.also {
        this.scale.transposeDiagram.forEach { element ->
            it[this.scale.transposeDiagram.indexOf(element)] =
                if (this.scale.transposeDiagram.indexOf(element) in this.scale.outOfScaleKeyIndexes) {
                    this.convertNotePlaceholder(semitones = element, outOfScale = true)
                } else if (this.scale.transposeDiagram.indexOf(element) in this.scale.tonicKeyIndexes) {
                    this.convertNotePlaceholder(semitones = element, tonic = true)
                } else {
                    this.convertNotePlaceholder(semitones = element)
                }
        }
    }
