package methods


import PocketScaleCalculator
import constants.ARAB_SHORTCUT
import constants.ArgsOrder
import constants.BLUES_SHORTCUT
import constants.DORIAN_SHORTCUT
import constants.HARMONIC_SHORTCUT
import constants.LOCRIAN_SHORTCUT
import constants.LYDIAN_SHORTCUT
import constants.MAJOR_SHORTCUT
import constants.MINOR_SHORTCUT
import constants.MIXOLYDIAN_SHORTCUT
import constants.Notes
import constants.PENTATONIC_SHORTCUT
import constants.PHRYGIAN_SHORTCUT
import constants.YES_SHORTCUT
import types.POScales
import types.PocketOperators
import types.Scales

fun PocketScaleCalculator.getTonic(args: Array<String>) = this.also {
    this.tonic = try {
        args[ArgsOrder.TONIC_OR_COMMAND_NAME].uppercase()
    } catch (ignored: ArrayIndexOutOfBoundsException) {
        Notes.A
    }
}

fun PocketScaleCalculator.getScale(args: Array<String>) = this.also {
    this.scale = when (this.poScale) {
        POScales.MINOR -> searchForMinorScales(args)
        POScales.MAJOR -> searchForMajorScales(args)
        POScales.BLUES -> Scales.BLUES_BLUES
        POScales.ARAB -> Scales.ARAB
    }
}

fun String.contains(argument: String): Boolean = this.lowercase().indexOf(argument) > -1

fun searchForMajorScales(args: Array<String>): Scales {
    return try {
        if (args[ArgsOrder.SCALE].contains(MINOR_SHORTCUT)) {
            if (args[ArgsOrder.SCALE].contains(PENTATONIC_SHORTCUT)) {
                Scales.MAJOR_PENTATONIC_MINOR
            } else {
                Scales.MAJOR_NATURAL_MINOR
            }
        } else if (args[ArgsOrder.SCALE].contains(PHRYGIAN_SHORTCUT)) {
            Scales.MAJOR_PHRYGIAN
        } else if (args[ArgsOrder.SCALE].contains(DORIAN_SHORTCUT)) {
            Scales.MAJOR_DORIAN
        } else if (args[ArgsOrder.SCALE].contains(LYDIAN_SHORTCUT)) {
            Scales.MAJOR_LYDIAN
        } else if (args[ArgsOrder.SCALE].contains(MIXOLYDIAN_SHORTCUT)) {
            Scales.MAJOR_MIXOLYDIAN
        } else if (args[ArgsOrder.SCALE].contains(LOCRIAN_SHORTCUT)) {
            Scales.MAJOR_LOCRIAN
        } else {
            if (args[ArgsOrder.SCALE].contains(PENTATONIC_SHORTCUT)) {
                Scales.MAJOR_PENTATONIC_MAJOR
            } else {
                Scales.MAJOR_NATURAL_MAJOR
            }
        }
    } catch (ignored: IndexOutOfBoundsException) {
        Scales.MAJOR_NATURAL_MAJOR
    }
}


fun searchForMinorScales(args: Array<String>): Scales {
    return try {
        if (args[ArgsOrder.SCALE].contains(MAJOR_SHORTCUT)) {
            if (args[ArgsOrder.SCALE].contains(HARMONIC_SHORTCUT)) {
                Scales.MINOR_HARMONIC_MAJOR
            } else if (args[ArgsOrder.SCALE].contains(PENTATONIC_SHORTCUT)) {
                Scales.MINOR_PENTATONIC_MAJOR
            } else {
                Scales.MINOR_NATURAL_MAJOR
            }
        } else if (args[ArgsOrder.SCALE].contains(BLUES_SHORTCUT)) {
            Scales.MINOR_BLUES
        } else if (args[ArgsOrder.SCALE].contains(DORIAN_SHORTCUT)) {
            Scales.MINOR_DORIAN
        } else if (args[ArgsOrder.SCALE].contains(LYDIAN_SHORTCUT)) {
            Scales.MINOR_LYDIAN
        } else if (args[ArgsOrder.SCALE].contains(MIXOLYDIAN_SHORTCUT)) {
            Scales.MINOR_MIXOLYDIAN
        } else if (args[ArgsOrder.SCALE].contains(LOCRIAN_SHORTCUT)) {
            Scales.MINOR_LOCRIAN
        } else if (args[ArgsOrder.SCALE].contains(PHRYGIAN_SHORTCUT)) {
            Scales.MINOR_PHRYGIAN
        } else {
            if (args[ArgsOrder.SCALE].contains(HARMONIC_SHORTCUT)) {
                Scales.MINOR_HARMONIC_MINOR
            } else if (args[ArgsOrder.SCALE].contains(PENTATONIC_SHORTCUT)) {
                Scales.MINOR_PENTATONIC_MINOR
            } else {
                Scales.MINOR_NATURAL_MINOR
            }
        }
    } catch (ignored: IndexOutOfBoundsException) {
        Scales.MINOR_NATURAL_MINOR
    }
}

fun PocketScaleCalculator.getSnapOffHangerOption(args: Array<String>) = this.also {
    this.snapOffHanger = try {
        args[ArgsOrder.SNAP_OFF_HANGER].contains(YES_SHORTCUT)
    } catch (ignored: ArrayIndexOutOfBoundsException) {
        false
    }
}

fun PocketScaleCalculator.getPOModelOption(args: Array<String>) = this.also {
    this.poModel = try {
        if (args[ArgsOrder.PO_MODEL].contains(PocketOperators.PO_128.model)) {
            PocketOperators.PO_128
        } else if (
            args[ArgsOrder.PO_MODEL].contains(PocketOperators.PO_35.model)) {
            PocketOperators.PO_35
        } else {
            PocketOperators.PO_33
        }
    } catch (ignored: ArrayIndexOutOfBoundsException) {
        PocketOperators.PO_33
    }
}

fun PocketScaleCalculator.getPOScaleOption(args: Array<String>) = this.also {
    this.poScale = try {
        if (this.poModel == PocketOperators.PO_33 || this.poModel == PocketOperators.PO_128) {
            POScales.MINOR
        } else {
            if (args[ArgsOrder.PO_SCALE].contains(MAJOR_SHORTCUT)) {
                POScales.MAJOR
            } else if (args[ArgsOrder.PO_SCALE].contains(BLUES_SHORTCUT)) {
                POScales.BLUES
            } else if (args[ArgsOrder.PO_SCALE].contains(ARAB_SHORTCUT)) {
                POScales.ARAB
            } else {
                POScales.MINOR
            }
        }
    } catch (ignored: ArrayIndexOutOfBoundsException) {
        POScales.MINOR
    }
}

