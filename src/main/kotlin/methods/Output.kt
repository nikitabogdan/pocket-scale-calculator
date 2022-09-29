package methods

import PocketScaleCalculator
import constants.ABOUT_MESSAGE_TEXT
import constants.ButtonIndexes
import constants.DESCRIPTION_MESSAGE_TEXT
import constants.DOUBLE_INDENT
import constants.HEADER_ABOUT
import constants.HEADER_DESCRIPTION
import constants.HEADER_ERROR
import constants.HEADER_FILLER_SIGN
import constants.HEADER_SCALES
import constants.HEADER_SUPPORT
import constants.INDENT
import constants.Placeholders.BT01
import constants.Placeholders.BT02
import constants.Placeholders.BT03
import constants.Placeholders.BT04
import constants.Placeholders.BT05
import constants.Placeholders.BT06
import constants.Placeholders.BT07
import constants.Placeholders.BT08
import constants.Placeholders.BT09
import constants.Placeholders.BT10
import constants.Placeholders.BT11
import constants.Placeholders.BT12
import constants.Placeholders.BT13
import constants.Placeholders.BT14
import constants.Placeholders.BT15
import constants.Placeholders.BT16
import constants.Placeholders.PO_SCALE
import constants.Placeholders.SAMPLE_KEY
import constants.Placeholders.SCALE_NAME
import constants.SCALES_MESSAGE_TEXT
import constants.SUPPORT_MESSAGE_TEXT
import constants.WINDOW_WIDTH
import constants.prepareCalculationsDraft
import org.apache.commons.text.WordUtils.wrap


fun printHeader(text: String = "") {
    if (text.isEmpty()) {
        println(
            "\n$DOUBLE_INDENT${HEADER_FILLER_SIGN.repeat(WINDOW_WIDTH - (DOUBLE_INDENT.length * 2))}$DOUBLE_INDENT\n"
        )
    } else {
        if (text.length.mod(2) == 0) {
            val dividerLength = (WINDOW_WIDTH - (DOUBLE_INDENT.length * 2) - (INDENT.length * 2) - text.length) / 2
            println(
                "\n$DOUBLE_INDENT${HEADER_FILLER_SIGN.repeat(dividerLength + 1)}$INDENT$text" +
                        "$INDENT${HEADER_FILLER_SIGN.repeat(dividerLength)}$DOUBLE_INDENT\n"
            )
        } else {
            val dividerLength =
                (WINDOW_WIDTH - (DOUBLE_INDENT.length * 2) - (INDENT.length * 2) - (text.length + 1)) / 2
            println(
                "\n$DOUBLE_INDENT${HEADER_FILLER_SIGN.repeat(dividerLength + 1)}$INDENT$text" +
                        "$INDENT${HEADER_FILLER_SIGN.repeat(dividerLength + 1)}$DOUBLE_INDENT\n"
            )
        }
    }
}

fun printFooter() {
    printHeader()
}

fun printInputMessage(message: String) {
    print(message)
}

fun printErrorMessage(errorMessage: String) {
    printHeader(HEADER_ERROR)
    println(errorMessage)
    printFooter()
}

fun wrapAndPrint(message: String) {
    println(wrap(message, WINDOW_WIDTH))
}

fun printDescription() {
    printHeader(HEADER_DESCRIPTION)
    wrapAndPrint(DESCRIPTION_MESSAGE_TEXT)
    printFooter()
}

fun printScales() {
    printHeader(HEADER_SCALES)
    println(SCALES_MESSAGE_TEXT)
    printFooter()
}

fun printAbout() {
    printHeader(HEADER_ABOUT)
    wrapAndPrint(ABOUT_MESSAGE_TEXT)
    printFooter()
}

fun printSupport() {
    printHeader(HEADER_SUPPORT)
    wrapAndPrint(SUPPORT_MESSAGE_TEXT)
    printFooter()
}

fun PocketScaleCalculator.printCalculations(transposedNotes: Array<String>) {
    println(
        this.prepareCalculationsDraft()
            .replace(PO_SCALE, this.convertDeviceScalePlaceholder())
            .replace(SCALE_NAME, this.convertScaleNamePlaceholder())
            .replace(SAMPLE_KEY, this.convertSampleKeyPlaceholder())
            .replace(BT01, transposedNotes[ButtonIndexes.BT01])
            .replace(BT02, transposedNotes[ButtonIndexes.BT02])
            .replace(BT03, transposedNotes[ButtonIndexes.BT03])
            .replace(BT04, transposedNotes[ButtonIndexes.BT04])
            .replace(BT05, transposedNotes[ButtonIndexes.BT05])
            .replace(BT06, transposedNotes[ButtonIndexes.BT06])
            .replace(BT07, transposedNotes[ButtonIndexes.BT07])
            .replace(BT08, transposedNotes[ButtonIndexes.BT08])
            .replace(BT09, transposedNotes[ButtonIndexes.BT01.octaveDown()])
            .replace(BT10, transposedNotes[ButtonIndexes.BT02.octaveDown()])
            .replace(BT11, transposedNotes[ButtonIndexes.BT03.octaveDown()])
            .replace(BT12, transposedNotes[ButtonIndexes.BT04.octaveDown()])
            .replace(BT13, transposedNotes[ButtonIndexes.BT05.octaveDown()])
            .replace(BT14, transposedNotes[ButtonIndexes.BT06.octaveDown()])
            .replace(BT15, transposedNotes[ButtonIndexes.BT07.octaveDown()])
            .replace(BT16, transposedNotes[ButtonIndexes.BT08.octaveDown()])
    )
}
