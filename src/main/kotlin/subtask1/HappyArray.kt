package subtask1


class HappyArray {
    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        //throw NotImplementedError("Not implemented")

        var i = 1
        var arraySize: Int = sadArray.size

        while (i < arraySize - 1) {
            if (isBadElement(sadArray, i)) {
                arraySize=delElement(sadArray, i, arraySize)
                if (i > 1) {
                    i--
                }
            } else {
                i++
            }
        }
        return sadArray.copyOfRange(0,arraySize)
    }

    fun isBadElement(array: IntArray, index: Int): Boolean {
        return array[index] > array[index - 1] + array[index + 1]
    }

    fun delElement(array: IntArray, index: Int, arraySize: Int):Int {
    // delete element and return new size Array
        for (i in index..arraySize - 2) {
            array[i] = array[i + 1]
        }
        return arraySize-1
    }
}
