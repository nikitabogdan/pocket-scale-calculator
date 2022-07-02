package types

import constants.ButtonIndexes
import constants.MAJOR_TO_DORIAN_TRANSPOSE_SHIFT
import constants.MAJOR_TO_LOCRIAN_TRANSPOSE_SHIFT
import constants.MAJOR_TO_LYDIAN_TRANSPOSE_SHIFT
import constants.MAJOR_TO_MINOR_TRANSPOSE_SHIFT
import constants.MAJOR_TO_MIXOLYDIAN_TRANSPOSE_SHIFT
import constants.MAJOR_TO_PHRYGIAN_TRANSPOSE_SHIFT
import constants.MINOR_TO_BLUES_DORIAN_TRANSPOSE_SHIFT
import constants.MINOR_TO_LYDIAN_TRANSPOSE_SHIFT
import constants.MINOR_TO_MAJOR_TRANSPOSE_SHIFT
import constants.ScaleNames
import methods.getListOfOutOfScaleIndexesForBothOctaves
import methods.getListOfRootKeyIndexesForBothOctaves
import methods.transpose

enum class Scales(
    val scaleName: String,
    val rootKeyIndexes: List<Int>,
    val outOfScaleKeyIndexes: List<Int>,
    val transposeDiagram: IntArray
) {
    MINOR_NATURAL_MAJOR(
        ScaleNames.MAJOR_NATURAL,
        ButtonIndexes.BT07.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT04.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram.transpose(MINOR_TO_MAJOR_TRANSPOSE_SHIFT)
    ),
    MINOR_NATURAL_MINOR(
        ScaleNames.MINOR_NATURAL,
        ButtonIndexes.BT05.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT04.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram
    ),
    MINOR_HARMONIC_MAJOR(
        ScaleNames.MAJOR_HARMONIC,
        ButtonIndexes.BT07.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT05.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram.transpose(MINOR_TO_MAJOR_TRANSPOSE_SHIFT)
    ),
    MINOR_HARMONIC_MINOR(
        ScaleNames.MINOR_HARMONIC,
        ButtonIndexes.BT05.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT03.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram
    ),
    MINOR_PENTATONIC_MAJOR(
        ScaleNames.MAJOR_PENTATONIC,
        ButtonIndexes.BT07.getListOfRootKeyIndexesForBothOctaves(),
        intArrayOf(
            ButtonIndexes.BT02,
            ButtonIndexes.BT04,
            ButtonIndexes.BT06
        ).getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram.transpose(MINOR_TO_MAJOR_TRANSPOSE_SHIFT)
    ),
    MINOR_PENTATONIC_MINOR(
        ScaleNames.MINOR_PENTATONIC,
        ButtonIndexes.BT05.getListOfRootKeyIndexesForBothOctaves(),
        intArrayOf(
            ButtonIndexes.BT02,
            ButtonIndexes.BT04,
            ButtonIndexes.BT06
        ).getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram
    ),
    MINOR_BLUES(
        ScaleNames.BLUES,
        ButtonIndexes.BT08.getListOfRootKeyIndexesForBothOctaves(),
        intArrayOf(
            ButtonIndexes.BT01,
            ButtonIndexes.BT06
        ).getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram.transpose(MINOR_TO_BLUES_DORIAN_TRANSPOSE_SHIFT)
    ),
    MINOR_DORIAN(
        ScaleNames.DORIAN,
        ButtonIndexes.BT08.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT04.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram.transpose(MINOR_TO_BLUES_DORIAN_TRANSPOSE_SHIFT)
    ),
    MINOR_LYDIAN(
        ScaleNames.LYDIAN,
        ButtonIndexes.BT02.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT04.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MINOR.transposeDiagram.transpose(MINOR_TO_LYDIAN_TRANSPOSE_SHIFT)
    ),
    MAJOR_NATURAL_MAJOR(
        ScaleNames.MAJOR_NATURAL,
        ButtonIndexes.BT05.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT03.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram
    ),
    MAJOR_PENTATONIC_MAJOR(
        ScaleNames.MAJOR_PENTATONIC,
        ButtonIndexes.BT05.getListOfRootKeyIndexesForBothOctaves(),
        intArrayOf(
            ButtonIndexes.BT03,
            ButtonIndexes.BT04,
            ButtonIndexes.BT08
        ).getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram
    ),
    MAJOR_NATURAL_MINOR(
        ScaleNames.MINOR_NATURAL,
        ButtonIndexes.BT02.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT03.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram.transpose(MAJOR_TO_MINOR_TRANSPOSE_SHIFT)
    ),
    MAJOR_PENTATONIC_MINOR(
        ScaleNames.MINOR_PENTATONIC,
        ButtonIndexes.BT02.getListOfRootKeyIndexesForBothOctaves(),
        intArrayOf(
            ButtonIndexes.BT03,
            ButtonIndexes.BT04,
            ButtonIndexes.BT08
        ).getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram.transpose(MAJOR_TO_MINOR_TRANSPOSE_SHIFT)
    ),
    MAJOR_LYDIAN(
        ScaleNames.LYDIAN,
        ButtonIndexes.BT08.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT03.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram.transpose(MAJOR_TO_LYDIAN_TRANSPOSE_SHIFT)
    ),
    MAJOR_MIXOLYDIAN(
        ScaleNames.MIXOLYDIAN,
        ButtonIndexes.BT01.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT03.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram.transpose(MAJOR_TO_MIXOLYDIAN_TRANSPOSE_SHIFT)
    ),
    MAJOR_LOCRIAN(
        ScaleNames.LOCRIAN,
        ButtonIndexes.BT04.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT03.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram.transpose(MAJOR_TO_LOCRIAN_TRANSPOSE_SHIFT)
    ),
    MAJOR_DORIAN(
        ScaleNames.DORIAN,
        ButtonIndexes.BT06.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT03.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram.transpose(MAJOR_TO_DORIAN_TRANSPOSE_SHIFT)
    ),
    MAJOR_PHRYGIAN(
        ScaleNames.PHRYGIAN,
        ButtonIndexes.BT07.getListOfRootKeyIndexesForBothOctaves(),
        ButtonIndexes.BT03.getListOfOutOfScaleIndexesForBothOctaves(),
        POScales.MAJOR.transposeDiagram.transpose(MAJOR_TO_PHRYGIAN_TRANSPOSE_SHIFT)
    )
}
