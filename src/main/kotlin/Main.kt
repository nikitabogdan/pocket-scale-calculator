import kotlin.system.exitProcess

// options
var rootKey = DEFAULT_ROOT_KEY
var scale = DEFAULT_SCALE
var snapOffHanger = false
var poModel = PocketOperators.PO_33

fun main(appArgs: Array<String>) {
    initUI()

    rootKey = getRootKey(appArgs)
    scale = getScale(appArgs)
    snapOffHanger = getSnapOffHangerOption(appArgs)
    poModel = getPOModelOption(appArgs)

    prepareTransposedNotesArray().calcUI()

    while (true) {
        inputUI("Input scale or press enter for help: ")
        val inputArgs = readln().split(" ").toTypedArray()

        when (inputArgs[0].lowercase()) {
            "exit", "quit", "off", "terminate" -> {
                terminateUI()
                exitProcess(0)
            }
            "", "help", "tutorial", "description" -> descriptionUI()
            "options" -> {
                optionsUI()
                inputUI("Snap off hanger? (y/n): ")
                snapOffHanger = readln().lowercase().indexOf(YES_SHORTCUT) > -1
                okUI()
                inputUI("Pocket operator model? (33/35): ")
                poModel = if (readln().lowercase().indexOf(PocketOperators.PO_35.modelIndex) > -1) {
                    PocketOperators.PO_35
                } else {
                    PocketOperators.PO_33
                }
                okUI()
            }
            "info", "about" -> aboutUI()
            else -> {
                rootKey = getRootKey(inputArgs)
                scale = getScale(inputArgs)

                if (notes.indexOf(rootKey.dropOctave()) == -1) {
                    errorMessageUI("Input [$rootKey] is unrecognised, please try again")
                } else {
                    prepareTransposedNotesArray().calcUI()

                }
            }
        }
    }
}
