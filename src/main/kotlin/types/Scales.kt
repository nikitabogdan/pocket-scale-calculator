package types

import constants.ButtonIndexes
import constants.TransposeDiagrams
import methods.octaveDown

enum class Scales(
    val scaleName: String,
    val rootKeyIndexes: List<Int>,
    val outOfScaleKeyIndexes: List<Int>,
    val transposeDiagram: IntArray,
    val poScale: POScales
) {
    MINOR_NATURAL_MAJOR(
        "Major (Natural)",
        listOf(ButtonIndexes.BT07, ButtonIndexes.BT07.octaveDown()),
        listOf(ButtonIndexes.BT04, ButtonIndexes.BT04.octaveDown()),
        TransposeDiagrams.po33Major,
        POScales.MINOR
    ),
    MINOR_NATURAL_MINOR(
        "Minor (Natural)",
        listOf(ButtonIndexes.BT05, ButtonIndexes.BT05.octaveDown()),
        listOf(ButtonIndexes.BT04, ButtonIndexes.BT04.octaveDown()),
        TransposeDiagrams.po33Minor,
        POScales.MINOR
    ),
    MINOR_HARMONIC_MAJOR(
        "Major (Harmonic)",
        listOf(ButtonIndexes.BT07, ButtonIndexes.BT07.octaveDown()),
        listOf(ButtonIndexes.BT05, ButtonIndexes.BT05.octaveDown()),
        TransposeDiagrams.po33Major,
        POScales.MINOR
    ),
    MINOR_HARMONIC_MINOR(
        "Minor (Harmonic)",
        listOf(ButtonIndexes.BT05, ButtonIndexes.BT05.octaveDown()),
        listOf(ButtonIndexes.BT03, ButtonIndexes.BT03.octaveDown()),
        TransposeDiagrams.po33Minor,
        POScales.MINOR
    ),
    MINOR_PENTATONIC_MAJOR(
        "Major (Pentatonic)",
        listOf(ButtonIndexes.BT07, ButtonIndexes.BT07.octaveDown()),
        listOf(
            ButtonIndexes.BT02, ButtonIndexes.BT02.octaveDown(),
            ButtonIndexes.BT04, ButtonIndexes.BT04.octaveDown(),
            ButtonIndexes.BT06, ButtonIndexes.BT06.octaveDown()
        ),
        TransposeDiagrams.po33Major,
        POScales.MINOR

    ),
    MINOR_PENTATONIC_MINOR(
        "Minor (Pentatonic)",
        listOf(ButtonIndexes.BT05, ButtonIndexes.BT05.octaveDown()),
        listOf(
            ButtonIndexes.BT02, ButtonIndexes.BT02.octaveDown(),
            ButtonIndexes.BT04, ButtonIndexes.BT04.octaveDown(),
            ButtonIndexes.BT06, ButtonIndexes.BT06.octaveDown()
        ),
        TransposeDiagrams.po33Minor,
        POScales.MINOR
    ),
    MINOR_BLUES(
        "Blues",
        listOf(ButtonIndexes.BT08, ButtonIndexes.BT08.octaveDown()),
        listOf(
            ButtonIndexes.BT01, ButtonIndexes.BT01.octaveDown(),
            ButtonIndexes.BT06, ButtonIndexes.BT06.octaveDown()
        ),
        TransposeDiagrams.po33BluesDorian,
        POScales.MINOR
    ),
    MINOR_DORIAN(
        "Dorian",
        listOf(ButtonIndexes.BT08, ButtonIndexes.BT08.octaveDown()),
        listOf(ButtonIndexes.BT04, ButtonIndexes.BT04.octaveDown()),
        TransposeDiagrams.po33BluesDorian,
        POScales.MINOR
    ),
    MINOR_LYDIAN(
        "Lydian",
        listOf(ButtonIndexes.BT02, ButtonIndexes.BT02.octaveDown()),
        listOf(ButtonIndexes.BT04, ButtonIndexes.BT04.octaveDown()),
        TransposeDiagrams.po33Lydian,
        POScales.MINOR
    ),
    MAJOR_NATURAL_MAJOR(
        "Major (Natural)",
        listOf(ButtonIndexes.BT05, ButtonIndexes.BT05.octaveDown()),
        listOf(ButtonIndexes.BT03, ButtonIndexes.BT03.octaveDown()),
        TransposeDiagrams.po35Major,
        POScales.MAJOR
    ),
    MAJOR_PENTATONIC_MAJOR(
        "Major (Pentatonic)",
        listOf(ButtonIndexes.BT05, ButtonIndexes.BT05.octaveDown()),
        listOf(
            ButtonIndexes.BT03, ButtonIndexes.BT03.octaveDown(),
            ButtonIndexes.BT04, ButtonIndexes.BT04.octaveDown(),
            ButtonIndexes.BT08, ButtonIndexes.BT08.octaveDown()
        ),
        TransposeDiagrams.po35Major,
        POScales.MAJOR
    ),
    MAJOR_NATURAL_MINOR(
        "Minor (Natural)",
        listOf(ButtonIndexes.BT02, ButtonIndexes.BT02.octaveDown()),
        listOf(ButtonIndexes.BT03, ButtonIndexes.BT03.octaveDown()),
        TransposeDiagrams.po35MinorPhrygian,
        POScales.MAJOR
    ),
    MAJOR_PENTATONIC_MINOR(
        "Minor (Pentatonic)",
        listOf(ButtonIndexes.BT02, ButtonIndexes.BT02.octaveDown()),
        listOf(
            ButtonIndexes.BT03, ButtonIndexes.BT03.octaveDown(),
            ButtonIndexes.BT04, ButtonIndexes.BT04.octaveDown(),
            ButtonIndexes.BT08, ButtonIndexes.BT08.octaveDown()
        ),
        TransposeDiagrams.po35MinorPhrygian,
        POScales.MAJOR
    ),
    MAJOR_LYDIAN(
        "Lydian",
        listOf(ButtonIndexes.BT08, ButtonIndexes.BT08.octaveDown()),
        listOf(ButtonIndexes.BT03, ButtonIndexes.BT03.octaveDown()),
        TransposeDiagrams.po35Lydian,
        POScales.MAJOR
    ),
    MAJOR_DORIAN(
        "Dorian",
        listOf(ButtonIndexes.BT06, ButtonIndexes.BT06.octaveDown()),
        listOf(ButtonIndexes.BT03, ButtonIndexes.BT03.octaveDown()),
        TransposeDiagrams.po35Dorian,
        POScales.MAJOR
    ),
    MAJOR_PHRYGIAN(
        "Phrygian",
        listOf(ButtonIndexes.BT02, ButtonIndexes.BT02.octaveDown()),
        listOf(ButtonIndexes.BT04, ButtonIndexes.BT04.octaveDown()),
        TransposeDiagrams.po35MinorPhrygian,
        POScales.MAJOR
    )
}
