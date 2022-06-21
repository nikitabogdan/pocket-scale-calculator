fun getRootKey(args: Array<String>) =
    try { args[0].uppercase() } catch (error: ArrayIndexOutOfBoundsException) { DEFAULT_ROOT_KEY }

fun getScale(args: Array<String>): Scales {
    return try {
        if (args[1].lowercase().indexOf(MAJOR_SHORTCUT) > -1) {
                if (args[1].lowercase().indexOf(HARMONIC_SHORTCUT) > -1) {
                    Scales.HARMONIC_MAJOR
                } else if (args[1].lowercase().indexOf(PENTATONIC_SHORTCUT) > -1) {
                    Scales.PENTATONIC_MAJOR
                } else {
                    Scales.NATURAL_MAJOR
                }
        } else if (args[1].lowercase().indexOf(BLUES_SHORTCUT) > -1) { Scales.BLUES }
        else if (args[1].lowercase().indexOf(DORIAN_SHORTCUT) > -1) { Scales.DORIAN }
        else if (args[1].lowercase().indexOf(LYDIAN_SHORTCUT) > -1) { Scales.LYDIAN }
        else {
                if (args[1].lowercase().indexOf(HARMONIC_SHORTCUT) > -1) {
                    Scales.HARMONIC_MINOR
                } else if (args[1].lowercase().indexOf(PENTATONIC_SHORTCUT) > -1) {
                    Scales.PENTATONIC_MINOR
                } else {
                    Scales.NATURAL_MINOR
                }
        }
    } catch (error: ArrayIndexOutOfBoundsException) { Scales.NATURAL_MINOR }
}

fun getSnapOffHangerOption(args: Array<String>) = try {
    args[2].lowercase().indexOf(YES_SHORTCUT) > -1
} catch (error: ArrayIndexOutOfBoundsException) { false }

fun getPOModelOption(args: Array<String>) = try {
    if (args[3].lowercase().indexOf(PocketOperators.PO_35.modelIndex) > -1) {
        PocketOperators.PO_35
    }
    else {
        PocketOperators.PO_33
    }
} catch (error: ArrayIndexOutOfBoundsException) { PocketOperators.PO_33 }

fun String.dropOctave() = if (this.last().isDigit()) this.dropLast(1) else this

fun Array<Int>.transposeDiagram(semitones: Int) = Array(size){16}
    .also { this.forEach { element -> it[this.indexOf(element)] = element + semitones } }

fun String.transposeOctave(semitones: Int): Int {
    var octave = if (this.last().isDigit()) this.last().digitToInt() else 2
    when (notes.indexOf(dropOctave().uppercase()) + semitones) {
        in 12..23 -> octave++
        // in 0..11 -> octave
        in -12..-1 -> octave--
        in -24..-13 -> octave -= 2
        in -36..-25 -> octave -= 3
    }

    return octave
}

fun Int.transposeNote(withOctave: Boolean = true) =
    "${notes[(notes.indexOf(rootKey.dropOctave().uppercase()) + this).mod(12)]}${
        if (withOctave) rootKey.transposeOctave(this) else ""
    }"

fun Int.prepareNoteUI(root: Boolean = false, outOfScale: Boolean = false): String {
    val fillRoot = if (root) ROOT_KEY_DEFINITION else REGULAR_NOTE_DEFINITION
    val printNote = if (outOfScale) OUT_OF_SCALE_KEY_DEFINITION else this.transposeNote()
    val wrappedNote = "${fillRoot.first()}$printNote${fillRoot.last()}"
    return when (printNote.length) {
        1 -> " $wrappedNote "
        2 -> " $wrappedNote"
        3 -> wrappedNote
        else -> {
            throw IllegalArgumentException("Inconsistent note $printNote length")
        }
    }
}

fun String.addCharsToFullLine(expectedLength: Int) =
    if (this.length < expectedLength) " ".repeat(expectedLength - this.length) + this else this

fun getDeviceScale() = (if (poModel == PocketOperators.PO_33) {
    ""
} else {
    "PO-35 Scale: Minor"
}).addCharsToFullLine(PO_SCALE_PLACEHOLDER.length)

fun getScaleName() = "${rootKey.dropOctave()} ${scale.scaleName}".addCharsToFullLine(SCALE_NAME_PLACEHOLDER.length)

fun getSampleKey() = "Sample key: ${
    when (scale) {
        Scales.NATURAL_MINOR, Scales.HARMONIC_MINOR, Scales.PENTATONIC_MINOR -> rootKey
        Scales.NATURAL_MAJOR, Scales.HARMONIC_MAJOR, Scales.PENTATONIC_MAJOR -> MINOR_TO_MAJOR_TRANSPOSE_SHIFT
            .transposeNote(true)
        Scales.BLUES, Scales.DORIAN -> MINOR_TO_BLUES_DORIAN_TRANSPOSE_SHIFT.transposeNote(true)
        Scales.LYDIAN -> MINOR_TO_LYDIAN_TRANSPOSE_SHIFT.transposeNote(true)
    }
}".addCharsToFullLine(SAMPLE_KEY_PLACEHOLDER.length)

fun prepareTransposedNotesArray() =
    Array(16) { "" }.also {
        scale.transposeDiagram.forEach { element ->
            it[scale.transposeDiagram.indexOf(element)] =
                if (scale.transposeDiagram.indexOf(element) in scale.outOfScaleKeyIndexes) {
                    element.prepareNoteUI(outOfScale = true)
                } else if (scale.transposeDiagram.indexOf(element) in scale.rootKeyIndexes) {
                    element.prepareNoteUI(root = true)
                } else {
                    element.prepareNoteUI()
                }
        }
    }
