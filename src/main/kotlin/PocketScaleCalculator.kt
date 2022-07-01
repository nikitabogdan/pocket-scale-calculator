import constants.ARGS_SEPARATOR
import constants.ArgsOrder
import constants.DEFAULT_INPUT_MESSAGE
import constants.ExitCodes
import constants.HEADER_OFF
import constants.HEADER_OK
import constants.HEADER_ON
import constants.HEADER_OPTIONS
import constants.Notes
import constants.PO_MODEL_OPTION_MESSAGE
import constants.SNAP_OFF_HANGER_OPTION_MESSAGE
import constants.YES_SHORTCUT
import constants.aboutKeywordsList
import constants.exitKeywordsList
import constants.helpKeywordsList
import constants.notesOrder
import constants.optionsKeywordsList
import constants.prepareUnrecognisedInputErrorMessage
import constants.supportKeywordsList
import methods.dropOctave
import methods.getPOModelOption
import methods.getRootKey
import methods.getScale
import methods.getSnapOffHangerOption
import methods.printAbout
import methods.printCalculations
import methods.printDescription
import methods.printErrorMessage
import methods.printHeader
import methods.printInputMessage
import methods.printSupport
import methods.transposeNotesGroup
import methods.userInputHasText
import types.MinorScales
import types.PocketOperators
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

        checkAndCalculate()
        while (true) {
            printInputMessage(DEFAULT_INPUT_MESSAGE)
            val inputArgs = readln().split(ARGS_SEPARATOR).toTypedArray()
            when (inputArgs[ArgsOrder.ROOT_KEY_OR_COMMAND_NAME].lowercase()) {
                in helpKeywordsList -> printDescription()
                in optionsKeywordsList -> setOptions()
                in aboutKeywordsList -> printAbout()
                in supportKeywordsList -> printSupport()
                in exitKeywordsList -> terminate()
                else -> {
                    rootKey = getRootKey(inputArgs)
                    scale = getScale(inputArgs)
                    checkAndCalculate()
                }
            }
        }
    }

    private fun checkAndCalculate() {
        if (validateUserInput()) {
            this.transposeNotesGroup().also {
                this.printCalculations(it)
            }
        } else {
            printErrorMessage(prepareUnrecognisedInputErrorMessage(rootKey))
        }
    }

    private fun validateUserInput() = notesOrder.indexOf(rootKey.dropOctave()) != -1

    private fun setOptions() {
        printHeader(HEADER_OPTIONS)
        printInputMessage(SNAP_OFF_HANGER_OPTION_MESSAGE)
        this.snapOffHanger = userInputHasText(YES_SHORTCUT)
        printHeader(HEADER_OK)
        printInputMessage(PO_MODEL_OPTION_MESSAGE)
        this.poModel =
            if (userInputHasText(PocketOperators.PO_35.modelIndex)) PocketOperators.PO_35 else PocketOperators.PO_33
        printHeader(HEADER_OK)
    }

    private fun terminate() {
        printHeader(HEADER_OFF)
        exitProcess(ExitCodes.SUCCESS)
    }
}
