package types

@SuppressWarnings("MagicNumber")
enum class POScales(val scaleName: String, val transposeDiagram: IntArray) {
    MAJOR("Major", intArrayOf(7, 9, 10, 11, 0, 2, 4, 5, -5, -3, -2, -1, -12, -10, -8, -7)),
    MINOR("Minor", intArrayOf(7, 8, 10, 11, 0, 2, 3, 5, -5, -4, -2, -1, -12, -10, -9, -7)),
    // BLUES("Blues"),
    // ARAB("Arab")
}
