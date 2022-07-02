package types

import constants.ButtonIndexes
import constants.ScaleNames
import constants.TransposeShifts.MAJOR_TO_DORIAN
import constants.TransposeShifts.MAJOR_TO_LOCRIAN
import constants.TransposeShifts.MAJOR_TO_LYDIAN
import constants.TransposeShifts.MAJOR_TO_MINOR
import constants.TransposeShifts.MAJOR_TO_MIXOLYDIAN
import constants.TransposeShifts.MAJOR_TO_PHRYGIAN
import constants.TransposeShifts.MINOR_TO_BLUES_DORIAN
import constants.TransposeShifts.MINOR_TO_LOCRIAN
import constants.TransposeShifts.MINOR_TO_LYDIAN
import constants.TransposeShifts.MINOR_TO_MAJOR
import constants.TransposeShifts.MINOR_TO_MIXOLYDIAN
import constants.TransposeShifts.MINOR_TO_PHRYGIAN
import constants.TransposeShifts.NO_TRANSPOSE
import methods.getListOfOutOfScaleIndexesForBothOctaves
import methods.getListOfRootKeyIndexesForBothOctaves
import methods.transpose

enum class Scales(
    val scaleName: String,
    val rootKeyIndexes: List<Int>,
    val outOfScaleKeyIndexes: List<Int>,
    val transposeDiagram: IntArray,
    val transposeShift: Int
) {
    MINOR_NATURAL_MAJOR(
        ScaleNames.MAJOR_NATURAL,
        ButtonIndexes.BT07.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT04.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram.transpose(MINOR_TO_MAJOR),
        MINOR_TO_MAJOR
    ),
    MINOR_NATURAL_MINOR(
        ScaleNames.MINOR_NATURAL,
        ButtonIndexes.BT05.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT04.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram,
        NO_TRANSPOSE
    ),
    MINOR_HARMONIC_MAJOR(
        ScaleNames.MAJOR_HARMONIC,
        ButtonIndexes.BT07.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT05.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram.transpose(MINOR_TO_MAJOR),
        MINOR_TO_MAJOR
    ),
    MINOR_HARMONIC_MINOR(
        ScaleNames.MINOR_HARMONIC,
        ButtonIndexes.BT05.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT03.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram,
        NO_TRANSPOSE
    ),
    MINOR_PENTATONIC_MAJOR(
        ScaleNames.MAJOR_PENTATONIC,
        ButtonIndexes.BT07.getListOfRootKeyIndexesForBothOctaves(),
        intArrayOf(
            ButtonIndexes.BT02,
            ButtonIndexes.BT04,
            ButtonIndexes.BT06
        ).getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram.transpose(MINOR_TO_MAJOR),
        MINOR_TO_MAJOR
    ),
    MINOR_PENTATONIC_MINOR(
        ScaleNames.MINOR_PENTATONIC,
        ButtonIndexes.BT05.getListOfRootKeyIndexesForBothOctaves(),
        intArrayOf(
            ButtonIndexes.BT02,
            ButtonIndexes.BT04,
            ButtonIndexes.BT06
        ).getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram,
        NO_TRANSPOSE
    ),
    MINOR_BLUES(
        ScaleNames.BLUES,
        ButtonIndexes.BT08.getListOfRootKeyIndexesForBothOctaves(),
        intArrayOf(
            ButtonIndexes.BT01,
            ButtonIndexes.BT06
        ).getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram.transpose(MINOR_TO_BLUES_DORIAN),
        MINOR_TO_BLUES_DORIAN
    ),
    MINOR_DORIAN(
        ScaleNames.DORIAN,
        ButtonIndexes.BT08.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT04.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram.transpose(MINOR_TO_BLUES_DORIAN),
        MINOR_TO_BLUES_DORIAN
    ),
    MINOR_LYDIAN(
        ScaleNames.LYDIAN,
        ButtonIndexes.BT02.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT04.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram.transpose(MINOR_TO_LYDIAN),
        MINOR_TO_LYDIAN
    ),
    MINOR_MIXOLYDIAN(
        ScaleNames.MIXOLYDIAN,
        ButtonIndexes.BT03.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT04.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram.transpose(MINOR_TO_MIXOLYDIAN),
        MINOR_TO_MIXOLYDIAN
    ),
    MINOR_LOCRIAN(
        ScaleNames.LOCRIAN,
        ButtonIndexes.BT06.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT04.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram.transpose(MINOR_TO_LOCRIAN),
        MINOR_TO_LOCRIAN
    ),
    MINOR_PHRYGIAN(
        ScaleNames.PHRYGIAN,
        ButtonIndexes.BT01.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT04.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram.transpose(MINOR_TO_PHRYGIAN),
        MINOR_TO_PHRYGIAN
    ),
    MAJOR_NATURAL_MAJOR(
        ScaleNames.MAJOR_NATURAL,
        ButtonIndexes.BT05.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT03.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram,
        NO_TRANSPOSE
    ),
    MAJOR_PENTATONIC_MAJOR(
        ScaleNames.MAJOR_PENTATONIC,
        ButtonIndexes.BT05.getListOfRootKeyIndexesForBothOctaves(),
        intArrayOf(
            ButtonIndexes.BT03,
            ButtonIndexes.BT04,
            ButtonIndexes.BT08
        ).getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram,
        NO_TRANSPOSE
    ),
    MAJOR_NATURAL_MINOR(
        ScaleNames.MINOR_NATURAL,
        ButtonIndexes.BT02.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT03.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram.transpose(MAJOR_TO_MINOR),
        MAJOR_TO_MINOR
    ),
    MAJOR_PENTATONIC_MINOR(
        ScaleNames.MINOR_PENTATONIC,
        ButtonIndexes.BT02.getListOfRootKeyIndexesForBothOctaves(),
        intArrayOf(
            ButtonIndexes.BT03,
            ButtonIndexes.BT04,
            ButtonIndexes.BT08
        ).getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram.transpose(MAJOR_TO_MINOR),
        MAJOR_TO_MINOR
    ),
    MAJOR_LYDIAN(
        ScaleNames.LYDIAN,
        ButtonIndexes.BT08.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT03.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram.transpose(MAJOR_TO_LYDIAN),
        MAJOR_TO_LYDIAN
    ),
    MAJOR_MIXOLYDIAN(
        ScaleNames.MIXOLYDIAN,
        ButtonIndexes.BT01.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT03.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram.transpose(MAJOR_TO_MIXOLYDIAN),
        MAJOR_TO_MIXOLYDIAN
    ),
    MAJOR_LOCRIAN(
        ScaleNames.LOCRIAN,
        ButtonIndexes.BT04.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT03.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram.transpose(MAJOR_TO_LOCRIAN),
        MAJOR_TO_MIXOLYDIAN
    ),
    MAJOR_DORIAN(
        ScaleNames.DORIAN,
        ButtonIndexes.BT06.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT03.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram.transpose(MAJOR_TO_DORIAN),
        MAJOR_TO_DORIAN
    ),
    MAJOR_PHRYGIAN(
        ScaleNames.PHRYGIAN,
        ButtonIndexes.BT07.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT03.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram.transpose(MAJOR_TO_PHRYGIAN),
        MAJOR_TO_PHRYGIAN
    )
}
