package methods


import constants.ArgsOrder
import constants.BLUES_SHORTCUT
import constants.DORIAN_SHORTCUT
import constants.HARMONIC_SHORTCUT
import constants.LYDIAN_SHORTCUT
import constants.MAJOR_SHORTCUT
import constants.Notes
import constants.PENTATONIC_SHORTCUT
import constants.YES_SHORTCUT
import types.MinorScales
import types.PocketOperators

fun getRootKey(args: Array<String>) = try {
    args[ArgsOrder.ROOT_KEY_OR_COMMAND_NAME].uppercase()
} catch (ignored: ArrayIndexOutOfBoundsException) {
    Notes.A
}

fun getScale(args: Array<String>): MinorScales {
    return try {
        if (args[ArgsOrder.SCALE].lowercase().indexOf(MAJOR_SHORTCUT) > -1) {
            if (args[ArgsOrder.SCALE].lowercase().indexOf(HARMONIC_SHORTCUT) > -1) {
                MinorScales.HARMONIC_MAJOR
            } else if (args[ArgsOrder.SCALE].lowercase().indexOf(PENTATONIC_SHORTCUT) > -1) {
                MinorScales.PENTATONIC_MAJOR
            } else {
                MinorScales.NATURAL_MAJOR
            }
        } else if (args[ArgsOrder.SCALE].lowercase().indexOf(BLUES_SHORTCUT) > -1) {
            MinorScales.BLUES
        } else if (args[ArgsOrder.SCALE].lowercase().indexOf(DORIAN_SHORTCUT) > -1) {
            MinorScales.DORIAN
        } else if (args[ArgsOrder.SCALE].lowercase().indexOf(LYDIAN_SHORTCUT) > -1) {
            MinorScales.LYDIAN
        } else {
            if (args[ArgsOrder.SCALE].lowercase().indexOf(HARMONIC_SHORTCUT) > -1) {
                MinorScales.HARMONIC_MINOR
            } else if (args[ArgsOrder.SCALE].lowercase().indexOf(PENTATONIC_SHORTCUT) > -1) {
                MinorScales.PENTATONIC_MINOR
            } else {
                MinorScales.NATURAL_MINOR
            }
        }
    } catch (ignored: IndexOutOfBoundsException) {
        MinorScales.NATURAL_MINOR
    }
}

fun getSnapOffHangerOption(args: Array<String>) = try {
    args[ArgsOrder.SNAP_OFF_HANGER].lowercase().indexOf(YES_SHORTCUT) > -1
} catch (ignored: ArrayIndexOutOfBoundsException) {
    false
}

fun getPOModelOption(args: Array<String>) = try {
    if (args[ArgsOrder.PO_MODEL].lowercase().indexOf(PocketOperators.PO_35.modelIndex) > -1
    ) PocketOperators.PO_35 else PocketOperators.PO_33
} catch (ignored: ArrayIndexOutOfBoundsException) {
    PocketOperators.PO_33
}
