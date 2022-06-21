
enum class PocketOperators(val modelIndex: String, val displayName: String) {
    PO_33("33", "K.O./"),
    PO_35("35", "speak")
}

enum class Scales(
    val scaleName: String,
    val rootKeyIndexes: List<Int>,
    val outOfScaleKeyIndexes: List<Int>,
    val transposeDiagram: Array<Int>
) {
    NATURAL_MAJOR("Major (Natural)",
        listOf(6, 6 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        listOf(3, 3 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        TransposeDiagrams.po33Major),
    NATURAL_MINOR("Minor (Natural)",
        listOf(4, 4 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        listOf(3, 3 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        TransposeDiagrams.po33Minor),
    HARMONIC_MAJOR("Major (Harmonic)",
        listOf(6, 6 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        listOf(4, 4 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        TransposeDiagrams.po33Major),
    HARMONIC_MINOR("Minor (Harmonic)",
        listOf(4, 4 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        listOf(2, 2 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        TransposeDiagrams.po33Minor),
    PENTATONIC_MAJOR("Major (Pentatonic)",
        listOf(6, 6 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        listOf(1, 1 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN, 3, 3 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN, 5, 5 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        TransposeDiagrams.po33Major),
    PENTATONIC_MINOR("Minor (Pentatonic)",
        listOf(4, 4 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        listOf(1, 1 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN, 3, 3 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN, 5, 5 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        TransposeDiagrams.po33Minor),
    BLUES(
        "Blues",
        listOf(7, 7 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        listOf(0, 0 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN, 5, 5 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        TransposeDiagrams.po33BluesDorian
    ),
    DORIAN(
        "Dorian",
        listOf(7, 7 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        listOf(3, 3 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        TransposeDiagrams.po33BluesDorian
    ),
    LYDIAN(
        "Lydian",
        listOf(1, 1 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        listOf(3, 3 + PO_BUTTONS_NUMBER_TO_OCTAVE_DOWN),
        TransposeDiagrams.po33Lydian
    )
}