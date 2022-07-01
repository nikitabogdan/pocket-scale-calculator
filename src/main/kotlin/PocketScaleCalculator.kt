import constants.ARGS_SEPARATOR
import constants.ArgsOrder
import constants.DEFAULT_INPUT_MESSAGE
import constants.ExitCodes
import constants.HEADER_OFF
import constants.HEADER_ON
import constants.aboutKeywordsList
import constants.donateKeywordsList
import constants.exitKeywordsList
import constants.optionsKeywordsList
import constants.supportKeywordsList
import helpers.getPOModelOption
import helpers.getRootKey
import helpers.getScale
import helpers.getSnapOffHangerOption
import helpers.setOptions
import helpers.transposeNotesGroup
import helpers.validateInput
import types.MinorScales
import types.Notes
import types.PocketOperators
import ui.printAbout
import ui.printCalculations
import ui.printDescription
import ui.printHeader
import ui.printInputMessage
import ui.printSupport
import kotlin.system.exitProcess

class PocketScaleCalculator(private val appArgs: Array<String>? = null) {
    var rootKey = Notes.A
    var scale = MinorScales.NATURAL_MINOR
    var snapOffHanger = false
    var poModel = PocketOperators.PO_33

    fun execute() {
        printHeader(HEADER_ON)
        appArgs?.let {
            rootKey = getRootKey(appArgs)
            scale = getScale(appArgs)
            snapOffHanger = getSnapOffHangerOption(appArgs)
            poModel = getPOModelOption(appArgs)
        }

        if (this.validateInput()) this.printCalculations(this.transposeNotesGroup())
        while (true) {
            printInputMessage(DEFAULT_INPUT_MESSAGE)
            val inputArgs = readln().split(ARGS_SEPARATOR).toTypedArray()
            when (inputArgs[ArgsOrder.ROOT_KEY_OR_COMMAND_NAME].lowercase()) {
                in exitKeywordsList -> this.terminate()
                in supportKeywordsList -> printDescription()
                in optionsKeywordsList -> this.setOptions()
                in donateKeywordsList -> printSupport()
                in aboutKeywordsList -> printAbout()
                else -> {
                    rootKey = getRootKey(inputArgs)
                    scale = getScale(inputArgs)
                    if (this.validateInput()) this.printCalculations(this.transposeNotesGroup())
                }
            }
        }
    }

    private fun terminate() {
        printHeader(HEADER_OFF)
        exitProcess(ExitCodes.SUCCESS)
    }
}
