package methods


import PocketScaleCalculator
import constants.ArgsOrder
import constants.BLUES_SHORTCUT
import constants.DORIAN_SHORTCUT
import constants.HARMONIC_SHORTCUT
import constants.LYDIAN_SHORTCUT
import constants.MAJOR_SHORTCUT
import constants.Notes
import constants.PENTATONIC_SHORTCUT
import constants.PHRYGIAN_SHORTCUT
import constants.YES_SHORTCUT
import types.POScales
import types.PocketOperators
import types.Scales

fun PocketScaleCalculator.getRootKey(args: Array<String>) = this.also {
    this.rootKey = try {
        args[ArgsOrder.ROOT_KEY_OR_COMMAND_NAME].uppercase()
    } catch (ignored: ArrayIndexOutOfBoundsException) {
        Notes.A
    }
}

fun PocketScaleCalculator.getScale(args: Array<String>) = this.also {
    this.scale = if (this.poScale == POScales.MINOR) {
        try {
            if (args[ArgsOrder.SCALE].lowercase().indexOf(MAJOR_SHORTCUT) > -1) {
                if (args[ArgsOrder.SCALE].lowercase().indexOf(HARMONIC_SHORTCUT) > -1) {
                    Scales.MINOR_HARMONIC_MAJOR
                } else if (args[ArgsOrder.SCALE].lowercase().indexOf(PENTATONIC_SHORTCUT) > -1) {
                    Scales.MINOR_PENTATONIC_MAJOR
                } else {
                    Scales.MINOR_NATURAL_MAJOR
                }
            } else if (args[ArgsOrder.SCALE].lowercase().indexOf(BLUES_SHORTCUT) > -1) {
                Scales.MINOR_BLUES
            } else if (args[ArgsOrder.SCALE].lowercase().indexOf(DORIAN_SHORTCUT) > -1) {
                Scales.MINOR_DORIAN
            } else if (args[ArgsOrder.SCALE].lowercase().indexOf(LYDIAN_SHORTCUT) > -1) {
                Scales.MINOR_LYDIAN
            } else {
                if (args[ArgsOrder.SCALE].lowercase().indexOf(HARMONIC_SHORTCUT) > -1) {
                    Scales.MINOR_HARMONIC_MINOR
                } else if (args[ArgsOrder.SCALE].lowercase().indexOf(PENTATONIC_SHORTCUT) > -1) {
                    Scales.MINOR_PENTATONIC_MINOR
                } else {
                    Scales.MINOR_NATURAL_MINOR
                }
            }
        } catch (ignored: IndexOutOfBoundsException) {
            Scales.MINOR_NATURAL_MINOR
        }
    } else {
        try {
            if (args[ArgsOrder.SCALE].lowercase().indexOf(MAJOR_SHORTCUT) > -1) {
                if (args[ArgsOrder.SCALE].lowercase().indexOf(PENTATONIC_SHORTCUT) > -1) {
                    Scales.MAJOR_PENTATONIC_MAJOR
                } else {
                    Scales.MAJOR_NATURAL_MAJOR
                }
            } else if (args[ArgsOrder.SCALE].lowercase().indexOf(PHRYGIAN_SHORTCUT) > -1) {
                Scales.MAJOR_PHRYGIAN
            } else if (args[ArgsOrder.SCALE].lowercase().indexOf(DORIAN_SHORTCUT) > -1) {
                Scales.MAJOR_DORIAN
            } else if (args[ArgsOrder.SCALE].lowercase().indexOf(LYDIAN_SHORTCUT) > -1) {
                Scales.MAJOR_LYDIAN
            } else {
                if (args[ArgsOrder.SCALE].lowercase().indexOf(PENTATONIC_SHORTCUT) > -1) {
                    Scales.MAJOR_PENTATONIC_MINOR
                } else {
                    Scales.MAJOR_NATURAL_MINOR
                }
            }
        } catch (ignored: IndexOutOfBoundsException) {
            Scales.MAJOR_NATURAL_MAJOR
        }
    }
}

fun PocketScaleCalculator.getSnapOffHangerOption(args: Array<String>) = this.also {
    this.snapOffHanger = try {
        args[ArgsOrder.SNAP_OFF_HANGER].lowercase().indexOf(YES_SHORTCUT) > -1
    } catch (ignored: ArrayIndexOutOfBoundsException) {
        false
    }
}

fun PocketScaleCalculator.getPOModelOption(args: Array<String>) = this.also {
    this.poModel = try {
        if (args[ArgsOrder.PO_MODEL].lowercase().indexOf(PocketOperators.PO_35.modelIndex) > -1
        ) PocketOperators.PO_35 else PocketOperators.PO_33
    } catch (ignored: ArrayIndexOutOfBoundsException) {
        PocketOperators.PO_33
    }
}

fun PocketScaleCalculator.getPOScaleOption(args: Array<String>) = this.also {
    this.poScale = try {
        if (this.poModel == PocketOperators.PO_33) {
            POScales.MINOR
        } else {
            if (args[ArgsOrder.PO_SCALE].lowercase().indexOf(MAJOR_SHORTCUT) > -1
            ) POScales.MAJOR else POScales.MINOR
        }
    } catch (ignored: ArrayIndexOutOfBoundsException) {
        POScales.MINOR
    }
}

