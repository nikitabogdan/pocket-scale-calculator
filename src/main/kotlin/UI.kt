
fun printInitSection() {
    println("")
    println("  @@@@@@@@@@@@@@@@@@@@ ON @@@@@@@@@@@@@@@@@@@  ")
}

fun printTerminateSection() {
    println("")
    println("  @@@@@@@@@@@@@@@@@@@ OFF @@@@@@@@@@@@@@@@@@@  ")
    println("")
}

fun printOkSection() {
    println("")
    println("  @@@@@@@@@@@@@@@@@@@@ OK @@@@@@@@@@@@@@@@@@@  ")
    println("")
}

fun printErrorSection() {
    println("")
    println("  @@@@@@@@@@@@@@@@@@ ERROR @@@@@@@@@@@@@@@@@@  ")
    println("")
}

fun printEndSection() {
    println("")
    println("  @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  ")
    println("")
}

fun printErrorMessage(errorMessage: String) {
    printErrorSection()
    println(errorMessage)
    printEndSection()
}

fun printDescriptionModule() {
    println("")
    println("  @@@@@@@@@@@@@@@ DESCRIPTION @@@@@@@@@@@@@@@  ")
    println("")
    println("  Type something like 'd# maj' for D# Major or")
    println("'G5 MinH' for Harmonic G Minor or 'a# map' for")
    println("for Pentatonic A# Major, or F#3 B for F# Blues")
    println("and press enter. Please make sure you separate")
    println("root key & scale with space key, which is used")
    println("to split input arguments. You could see found")
    println("scale on the ASCII-PO display and sample key to")
    println("record into your PO to use this scale. Notes ")
    println("with [] brackets are root notes for your scale.")
    println("Empty -- notes are outside of calculated scale.")
    println("")
    println("  Currently supported scales are: ")
    println("    – Minor (Natural, Harmonic & Pentatonic)")
    println("    – Major (Natural, Harmonic & Pentatonic)")
    println("    – ${Scales.BLUES.scaleName}")
    println("    – ${Scales.DORIAN.scaleName}")
    println("    – ${Scales.LYDIAN.scaleName}")
    println("Should work the same with PO-35 / PO-137 models")
    println("with Minor scale picked on the device.")
    println("")
    println("  Additional commands: ")
    println("  'options' - set 'snap off hanger' & PO model")
    println("  'info' - more info/about section")
    println("  'off' - exit app")
    println("")
    println("To start app with specific default scale and ")
    println("options please use following arguments list ")
    println("next to the 'java -jar %file loc%' run command:")
    println("1:root note, 2:scale, 3:snap off hanger (y/n),")
    println("4:PO model (33/35). For example: F MajP Y 35")
    println("will start app with F Major Pentatonic setting,")
    println("missing hanger option and PO-35 model UI.")
    printEndSection()
}

fun printOptionsSection() {
    println("")
    println("  @@@@@@@@@@@@@@@@@ OPTIONS @@@@@@@@@@@@@@@@@  ")
    println("")
}

fun printAboutModule() {
    println("")
    println("  @@@@@@@@@@@@@@@@@@ ABOUT @@@@@@@@@@@@@@@@@@  ")
    println("")
    println("  Pocket Scale Calculator. App version: $APP_VERSION")
    println("For Teenage Engineering PO-33 / PO-133 and, ")
    println("partially, PO-35 / PO-137 series (Minor only)")
    println("https://teenage.engineering/products/po")
    println("Inspired by www.punkyv4n.me/po-33-scale-app")
    println("Dev: Nikita Bogdan  Email: nikita.bogdan@me.com")
    println("github.com/nikitabogdan/pocket-scale-calculator")
    printSupportModule()
}

fun printSupportModule() {
    println("")
    println("  @@@@@@@@@@@@@@@@@ SUPPORT @@@@@@@@@@@@@@@@@  ")
    println("")
    println("If you enjoyed Pocket Scale Calculator, you can")
    println("support development of the next app versions.")
    println("Donations could be accepted to the following ")
    println("xrp address: rD8aqf3YcxYZ3Lzv9vuoqeTfmgb4e7TdXm")
    printEndSection()
}

fun printInputSection(message: String) {
    print(message)
}

fun Array<String>.printCalculationsModule() {
    println(calculationsDraft()
        .replace(DEVICE_PLACEHOLDER, poModel.displayName)
        .replace(PO_SCALE_PLACEHOLDER, getDeviceScale())
        .replace(SCALE_NAME_PLACEHOLDER, getScaleName())
        .replace(SAMPLE_KEY_PLACEHOLDER, getSampleKey())
        .replace(BUTTON_1_PLACEHOLDER, this[0])
        .replace(BUTTON_2_PLACEHOLDER, this[1])
        .replace(BUTTON_3_PLACEHOLDER, this[2])
        .replace(BUTTON_4_PLACEHOLDER, this[3])
        .replace(BUTTON_5_PLACEHOLDER, this[4])
        .replace(BUTTON_6_PLACEHOLDER, this[5])
        .replace(BUTTON_7_PLACEHOLDER, this[6])
        .replace(BUTTON_8_PLACEHOLDER, this[7])
        .replace(BUTTON_9_PLACEHOLDER, this[8])
        .replace(BUTTON_10_PLACEHOLDER, this[9])
        .replace(BUTTON_11_PLACEHOLDER, this[10])
        .replace(BUTTON_12_PLACEHOLDER, this[11])
        .replace(BUTTON_13_PLACEHOLDER, this[12])
        .replace(BUTTON_14_PLACEHOLDER, this[13])
        .replace(BUTTON_15_PLACEHOLDER, this[14])
        .replace(BUTTON_16_PLACEHOLDER, this[15])
    )
}

fun calculationsDraft() = if (snapOffHanger) {
    "                                               \n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n"
} else {
    "                                               \n" +
            "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
            "@@@@POCKET@@°                      °@@@@@@@@@@@\n" +
            "@@SCALE@@@@   .@@@@@@@@@@@@@@@@@@.   @@@@@@@@@@\n" +
            "@@@@@CALC@@   .@@@@@@@@@@@@@@@@@#.   @@@@@@@@@@\n" +
            "@@@@@@@@@@@@.    pocket operator   .@@@@@@@@@@@\n" +
            "@@@@@@@@@@@@O**o*  *****o***  ***o#@@@@@@@@@@@@\n"

} +
        "@@@@                °#  O°o*          oo   @@@@\n" +
        "@@@@   $DEVICE_PLACEHOLDER       *#OO°#°oO          @#   @@@@\n" +
        "@@@@          ...................     °°   @@@@\n" +
        "@@@@   #################################   @@@@\n" +
        "@@@@   @@  $PO_SCALE_PLACEHOLDER ##   @@@@\n" +
        "@@@@   ## $SCALE_NAME_PLACEHOLDER ##   @@@@\n" +
        "@@@@  .## $SAMPLE_KEY_PLACEHOLDER ##   @@@@\n" +
        "@@@@  .##                             ##   @@@@\n" +
        "@@@@.  ##  $ROOT_KEY_DEFINITION: root; $OUT_OF_SCALE_KEY_DEFINITION: out of scale ##  .@@@@\n" +
        "@@@@*  *o°#########################Ooo*o  *@@@@\n" +
        "@@@@.       ..''''''''''''''''''''        .@@@@\n" +
        "@@@O   .*** °'.ooo.  .ooo.  #°@##o #°@@Oo  @@@@\n" +
        "@@@O  .@*°@o °@*.#@  @O O#  @*@@°# @#@@°@  @@@@\n" +
        "@@@O   'ooO'  'OoO°  'OoO°  o*oo@* o**o#*  @@@@\n" +
        "@@@O                                 ,_.   @@@@\n" +
        "@@@O                                @O.@#  @@@@\n" +
        "@@@@   $BUTTON_1_PLACEHOLDER  $BUTTON_2_PLACEHOLDER  $BUTTON_3_PLACEHOLDER  $BUTTON_4_PLACEHOLDER   'OoO*  @@@@\n" +
        "@@@@                                 °°'   O@@@\n" +
        "@@@O                                 ,o.   O@@@\n" +
        "@@@@                                @O.@#  @@@@\n" +
        "@@@O   $BUTTON_5_PLACEHOLDER  $BUTTON_6_PLACEHOLDER  $BUTTON_7_PLACEHOLDER  $BUTTON_8_PLACEHOLDER   'OoO*  @@@@\n" +
        "@@@@                                 °'    @@@@\n" +
        "@@@O                                 oo*.  O@@@\n" +
        "@@@@                                @O.@#  @@@@\n" +
        "@@@O   $BUTTON_9_PLACEHOLDER  $BUTTON_10_PLACEHOLDER  $BUTTON_11_PLACEHOLDER  $BUTTON_12_PLACEHOLDER   'OoO*  @@@@\n" +
        "@@@@                                  °°   @@@@\n" +
        "@@@O                                 ,o.   @@@@\n" +
        "@@@@                                @O.@#  @@@@\n" +
        "@@@@   $BUTTON_13_PLACEHOLDER  $BUTTON_14_PLACEHOLDER  $BUTTON_15_PLACEHOLDER  $BUTTON_16_PLACEHOLDER   'OoO*  @@@@\n" +
        "@@@@                                       @@@@\n" +
        "@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@\n" +
        "                                               "
