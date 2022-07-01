package types

import constants.ButtonIndexes
import constants.TransposeDiagrams
import methods.octaveDown

enum class MinorScales(
    val scaleName: String,
    val rootKeyIndexes: List<Int>,
    val outOfScaleKeyIndexes: List<Int>,
    val transposeDiagram: IntArray
) {
    NATURAL_MAJOR(
        "Major (Natural)",
        listOf(ButtonIndexes.BT07, ButtonIndexes.BT07.octaveDown()),
        listOf(ButtonIndexes.BT04, ButtonIndexes.BT04.octaveDown()),
        TransposeDiagrams.po33Major
    ),
    NATURAL_MINOR(
        "Minor (Natural)",
        listOf(ButtonIndexes.BT05, ButtonIndexes.BT05.octaveDown()),
        listOf(ButtonIndexes.BT04, ButtonIndexes.BT04.octaveDown()),
        TransposeDiagrams.po33Minor
    ),
    HARMONIC_MAJOR(
        "Major (Harmonic)",
        listOf(ButtonIndexes.BT07, ButtonIndexes.BT07.octaveDown()),
        listOf(ButtonIndexes.BT05, ButtonIndexes.BT05.octaveDown()),
        TransposeDiagrams.po33Major
    ),
    HARMONIC_MINOR(
        "Minor (Harmonic)",
        listOf(ButtonIndexes.BT05, ButtonIndexes.BT05.octaveDown()),
        listOf(ButtonIndexes.BT03, ButtonIndexes.BT03.octaveDown()),
        TransposeDiagrams.po33Minor
    ),
    PENTATONIC_MAJOR(
        "Major (Pentatonic)",
        listOf(ButtonIndexes.BT07, ButtonIndexes.BT07.octaveDown()),
        listOf(
            ButtonIndexes.BT02, ButtonIndexes.BT02.octaveDown(),
            ButtonIndexes.BT04, ButtonIndexes.BT04.octaveDown(),
            ButtonIndexes.BT06, ButtonIndexes.BT06.octaveDown()
        ),
        TransposeDiagrams.po33Major
    ),
    PENTATONIC_MINOR(
        "Minor (Pentatonic)",
        listOf(ButtonIndexes.BT05, ButtonIndexes.BT05.octaveDown()),
        listOf(
            ButtonIndexes.BT02, ButtonIndexes.BT02.octaveDown(),
            ButtonIndexes.BT04, ButtonIndexes.BT04.octaveDown(),
            ButtonIndexes.BT06, ButtonIndexes.BT06.octaveDown()
        ),
        TransposeDiagrams.po33Minor
    ),
    BLUES(
        "Blues",
        listOf(ButtonIndexes.BT08, ButtonIndexes.BT08.octaveDown()),
        listOf(
            ButtonIndexes.BT01, ButtonIndexes.BT01.octaveDown(),
            ButtonIndexes.BT06, ButtonIndexes.BT06.octaveDown()
        ),
        TransposeDiagrams.po33BluesDorian
    ),
    DORIAN(
        "Dorian",
        listOf(ButtonIndexes.BT08, ButtonIndexes.BT08.octaveDown()),
        listOf(ButtonIndexes.BT04, ButtonIndexes.BT04.octaveDown()),
        TransposeDiagrams.po33BluesDorian
    ),
    LYDIAN(
        "Lydian",
        listOf(ButtonIndexes.BT02, ButtonIndexes.BT02.octaveDown()),
        listOf(ButtonIndexes.BT04, ButtonIndexes.BT04.octaveDown()),
        TransposeDiagrams.po33Lydian
    )
}
