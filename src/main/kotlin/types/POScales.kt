package types

@SuppressWarnings("MagicNumber")
enum class POScales(val scaleName: String, val transposeDiagram: IntArray) {
    MAJOR("Major", intArrayOf(7, 9, 10, 11, 0, 2, 4, 5, -5, -3, -2, -1, -12, -10, -8, -7)),
    MINOR("Minor", intArrayOf(7, 8, 10, 11, 0, 2, 3, 5, -5, -4, -2, -1, -12, -10, -9, -7)),
    BLUES("Blues", intArrayOf(6, 7, 10, 11, 0, 3, 4, 5, -6, -5, -2, -1, -12, -9, -8, -7)),
    ARAB("Arab", intArrayOf(6, 7, 8, 11, 0, 1, 4, 5, -6, -5, -4, -1, -12, -11, -8, -7))
}
