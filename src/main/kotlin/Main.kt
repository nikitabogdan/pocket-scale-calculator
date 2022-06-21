import kotlin.system.exitProcess

var rootKey = DEFAULT_ROOT_KEY
var scale = DEFAULT_SCALE
var snapOffHanger = false
var poModel = PocketOperators.PO_33

fun main(appArgs: Array<String>) {
    printInitSection()

    rootKey = getRootKey(appArgs)
    scale = getScale(appArgs)
    snapOffHanger = getSnapOffHangerOption(appArgs)
    poModel = getPOModelOption(appArgs)

    prepareTransposedNotesArray().printCalculationsModule()

    while (true) {
        printInputSection("Input scale or press enter for help: ")
        val inputArgs = readln().split(" ").toTypedArray()

        when (inputArgs[0].lowercase()) {
            "exit", "quit", "off", "terminate" -> {
                printTerminateSection()
                exitProcess(0)
            }
            "", "help", "tutorial", "description" -> printDescriptionModule()
            "options" -> {
                printOptionsSection()
                printInputSection("Snap off hanger? (y/n): ")
                snapOffHanger = readln().lowercase().indexOf(YES_SHORTCUT) > -1
                printOkSection()
                printInputSection("Pocket operator model? (33/35): ")
                poModel = if (readln().lowercase().indexOf(PocketOperators.PO_35.modelIndex) > -1) {
                    PocketOperators.PO_35
                } else {
                    PocketOperators.PO_33
                }
                printOkSection()
            }
            "support", "donate" -> printSupportModule()
            "info", "about" -> printAboutModule()
            else -> {
                rootKey = getRootKey(inputArgs)
                scale = getScale(inputArgs)

                if (notes.indexOf(rootKey.dropOctave()) == -1) {
                    printErrorMessage("Input [$rootKey] is unrecognised, please try again")
                } else {
                    prepareTransposedNotesArray().printCalculationsModule()

                }
            }
        }
    }
}
