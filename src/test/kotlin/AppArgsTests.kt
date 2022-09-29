import constants.Notes
import constants.YES_SHORTCUT
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import types.POScales
import types.PocketOperators
import types.Scales

class AppArgsTests {

    /**
     * Execute app in test mode to avoid ReadAfterEOFException exception
     */
    private fun PocketScaleCalculator.executeInTestMode() = this.also {
        try {
            this.execute()
        } catch (ignored: RuntimeException) {
            // Ignore runtime exception:
            // kotlin.io.ReadAfterEOFException: EOF has already been reached
        }
    }

    /**
     * Assert settings for current PocketScaleCalculator app state
     */
    private fun PocketScaleCalculator.assertSettings(
        expectedScale: Scales = Scales.MINOR_NATURAL_MINOR,
        expectedRootKey: String = Notes.A,
        expectedSnapOffHangerOption: Boolean = false,
        expectedPOModelOption: PocketOperators = PocketOperators.PO_33,
        expectedPOScaleOption: POScales = POScales.MINOR

    ) {
        assertEquals(expectedScale, this.scale)
        assertEquals(expectedRootKey, this.rootKey)
        assertEquals(expectedSnapOffHangerOption, this.snapOffHanger)
        assertEquals(expectedPOModelOption, this.poModel)
        assertEquals(expectedPOScaleOption, this.poScale)
    }

    @Test
    fun `Start app with no args positive test`() {
        PocketScaleCalculator().assertSettings()
    }

    @Test
    fun `Start app with null args positive test`() {
        PocketScaleCalculator(null).executeInTestMode().assertSettings()
    }

    @Test
    fun `Start app with 1 arg positive test`() {
        val testRootKey = Notes.F_SHARP
        PocketScaleCalculator(arrayOf(testRootKey)).executeInTestMode().assertSettings(expectedRootKey = testRootKey)
    }

    @Test
    fun `Start app with 2 args positive test`() {
        val testRootKey = Notes.B
        val testScale = Scales.MINOR_DORIAN
        PocketScaleCalculator(arrayOf(testRootKey, testScale.scaleName)).executeInTestMode()
            .assertSettings(expectedScale = testScale, expectedRootKey = testRootKey)
    }

    @Test
    fun `Start app with 3 args positive test`() {
        val testRootKey = Notes.B
        val testScale = Scales.MINOR_DORIAN
        val testSnapOffHanger = YES_SHORTCUT
        PocketScaleCalculator(arrayOf(testRootKey, testScale.scaleName, testSnapOffHanger)).executeInTestMode()
            .assertSettings(
                expectedScale = testScale,
                expectedRootKey = testRootKey,
                expectedSnapOffHangerOption = true
            )
    }

    @Test
    fun `Start app with 4 args positive test`() {
        val testRootKey = Notes.B
        val testScale = Scales.MINOR_DORIAN
        val testSnapOffHanger = YES_SHORTCUT
        val poModel = PocketOperators.PO_35
        PocketScaleCalculator(
            arrayOf(testRootKey, testScale.scaleName, testSnapOffHanger, poModel.model)
        ).executeInTestMode().assertSettings(
            expectedScale = testScale,
            expectedRootKey = testRootKey,
            expectedSnapOffHangerOption = true,
            expectedPOModelOption = poModel
        )
    }

    @Test
    fun `Start app with 5 args positive test`() {
        val testRootKey = Notes.E
        val testScale = Scales.ARAB
        val testSnapOffHanger = YES_SHORTCUT
        val poModel = PocketOperators.PO_35
        val poScale = POScales.ARAB
        PocketScaleCalculator(
            arrayOf(testRootKey, testScale.scaleName, testSnapOffHanger, poModel.model, poScale.scaleName)
        ).executeInTestMode().assertSettings(
            expectedScale = testScale,
            expectedRootKey = testRootKey,
            expectedSnapOffHangerOption = true,
            expectedPOModelOption = poModel,
            expectedPOScaleOption = poScale
        )
    }

    @Disabled
    @Test
    fun `Start app with empty arg negative test`() {
        val testRootKey = ""
        PocketScaleCalculator(arrayOf(testRootKey)).executeInTestMode()
        // need to figure out how to test error output from console
        // .assertSettings(expectedRootKey = testRootKey)
    }

    @Disabled
    @Test
    fun `Start app with wrong arg negative test`() {
        val testRootKey = "wrongNote"
        PocketScaleCalculator(arrayOf(testRootKey)).executeInTestMode()
        // need to figure out how to test error output from console
        // .assertEquals(testRootKey, it.rootKey)
    }
}
