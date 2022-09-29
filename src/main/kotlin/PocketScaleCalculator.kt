import constants.ARAB_SHORTCUT
import constants.ARGS_SEPARATOR
import constants.ArgsOrder
import constants.BLUES_SHORTCUT
import constants.DEFAULT_INPUT_MESSAGE
import constants.ExitCodes
import constants.HEADER_OFF
import constants.HEADER_OK
import constants.HEADER_ON
import constants.HEADER_OPTIONS
import constants.MAJOR_SHORTCUT
import constants.Notes
import constants.PO_MODEL_OPTION_MESSAGE
import constants.PO_SCALE_OPTION_MESSAGE
import constants.SNAP_OFF_HANGER_OPTION_MESSAGE
import constants.YES_SHORTCUT
import constants.aboutKeywordsList
import constants.exitKeywordsList
import constants.helpKeywordsList
import constants.notesOrder
import constants.optionsKeywordsList
import constants.prepareUnrecognisedInputErrorMessage
import constants.scalesKeywordsList
import constants.supportKeywordsList
import methods.dropOctave
import methods.getPOModelOption
import methods.getPOScaleOption
import methods.getRootKey
import methods.getScale
import methods.getSnapOffHangerOption
import methods.hasText
import methods.printAbout
import methods.printCalculations
import methods.printDescription
import methods.printErrorMessage
import methods.printHeader
import methods.printInputMessage
import methods.printScales
import methods.printSupport
import methods.readUserInput
import methods.transposeNotesGroup
import types.POScales
import types.PocketOperators
import types.Scales
import kotlin.system.exitProcess

class PocketScaleCalculator(private val appArgs: Array<String>? = null) {
    var rootKey = Notes.A
    var scale = Scales.MINOR_NATURAL_MINOR
    var snapOffHanger = false
    var poModel = PocketOperators.PO_33
    var poScale = POScales.MINOR

    fun execute() {
        printHeader(HEADER_ON)
        appArgs?.let { applyArgs(appArgs) }
        checkAndCalculate()
        while (true) {
            printInputMessage(DEFAULT_INPUT_MESSAGE)
            val inputArgs = readln().split(ARGS_SEPARATOR).toTypedArray()
            when (inputArgs[ArgsOrder.ROOT_KEY_OR_COMMAND_NAME].lowercase()) {
                in helpKeywordsList -> printDescription()
                in optionsKeywordsList -> setOptions()
                in scalesKeywordsList -> printScales()
                in aboutKeywordsList -> printAbout()
                in supportKeywordsList -> printSupport()
                in exitKeywordsList -> terminate()
                else -> {
                    this.getRootKey(inputArgs)
                        .getScale(inputArgs)
                    checkAndCalculate()
                }
            }
        }
    }

    private fun applyArgs(appArgs: Array<String>) {
        this.getSnapOffHangerOption(appArgs)
            .getPOModelOption(appArgs)
            .getPOScaleOption(appArgs)
            .getRootKey(appArgs)
            .getScale(appArgs)
    }

    fun checkAndCalculate() {
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
        this.snapOffHanger = readUserInput().hasText(YES_SHORTCUT)
        printHeader(HEADER_OK)
        printInputMessage(PO_MODEL_OPTION_MESSAGE)
        val input = readUserInput()
        this.poModel = if (input.hasText(PocketOperators.PO_35.model))
            PocketOperators.PO_35
        else if (input.hasText(PocketOperators.PO_33.model)) {
            PocketOperators.PO_33.also { this.poScale = POScales.MINOR }
        } else {
            PocketOperators.PO_128.also { this.poScale = POScales.MINOR }
        }
        printHeader(HEADER_OK)
        if (poModel == PocketOperators.PO_35) {
            printInputMessage(PO_SCALE_OPTION_MESSAGE)
            val userInput = readUserInput()
            this.poScale = if (userInput.hasText(MAJOR_SHORTCUT)) {
                POScales.MAJOR
            } else if (userInput.hasText(BLUES_SHORTCUT)) {
                POScales.BLUES
            } else if (userInput.hasText(ARAB_SHORTCUT)) {
                POScales.ARAB
            } else {
                POScales.MINOR
            }
            printHeader(HEADER_OK)
        }
    }

    private fun terminate() {
        printHeader(HEADER_OFF)
        exitProcess(ExitCodes.SUCCESS)
    }
}
