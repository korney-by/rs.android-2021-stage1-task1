package subtask3

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        //throw NotImplementedError("Not implemented")

        val arrayCountersBracket = IntArray(3) //{ i -> 0 }
        val arrayBracketsMap = IntArray(inputString.length)
        var currentTypeBracket: Int

        for (i in 0 until inputString.length) {
            currentTypeBracket = getTypeBracket(inputString[i])
            inputString[i]
            if (currentTypeBracket != TYPE_BRACKET_NO) {
                if (getDirectionBracket(inputString[i]) == DIR_BRACKET_OPEN) {
                    arrayCountersBracket[currentTypeBracket]++
                    arrayBracketsMap[i] = arrayCountersBracket[currentTypeBracket]
                } else {
                    arrayBracketsMap[i] = arrayCountersBracket[currentTypeBracket]
                    arrayCountersBracket[currentTypeBracket]--
                }

            }
        }
        return getArraySubstrings(inputString, arrayBracketsMap)
    }

    fun getArraySubstrings(string: String, arrayBracketsMap: IntArray): Array<String> {
        val resultArrayList = ArrayList<String>(0)

        for (i in 0 until arrayBracketsMap.size) {
            if (arrayBracketsMap[i] != 0) { // find bracket
                for (j in i + 1 until arrayBracketsMap.size) {
                    if (arrayBracketsMap[j] == arrayBracketsMap[i] &&
                        getTypeBracket(string[i]) == getTypeBracket(string[j])
                    ) {
                        resultArrayList.add(string.substring(i + 1 until j))
                        arrayBracketsMap[i]=0
                        arrayBracketsMap[j]=0
                    }
                }
            }

        }

        val resultArray: Array<String> = resultArrayList.toTypedArray()
        return resultArray
    }

    fun getDirectionBracket(char: Char): Int {
        return when (char) {
            '(', '[', '<' -> DIR_BRACKET_OPEN
            ')', ']', '>' -> DIR_BRACKET_CLOSE
            else -> 0
        }
    }


    fun getTypeBracket(char: Char): Int {
        // return Type Bracket
        return when (char) {
            '(', ')' -> TYPE_BRACKET_ROUND
            '[', ']' -> TYPE_BRACKET_SQUARE
            '<', '>' -> TYPE_BRACKET_ANGLE
            else -> TYPE_BRACKET_NO

        }
    }
    //

    private companion object {
        const val TYPE_BRACKET_NO = -1  // not bracket
        const val TYPE_BRACKET_ROUND = 0 // ()
        const val TYPE_BRACKET_SQUARE = 1 // []
        const val TYPE_BRACKET_ANGLE = 2 // <>

        const val DIR_BRACKET_OPEN = 0
        const val DIR_BRACKET_CLOSE = 1
    }
}
