package subtask2

class BillCounter {

    // TODO: Complete the following function
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        //throw NotImplementedError("Not implemented")
        var summBill = 0

        bill.forEach { summBill += it }

        val summAnna: Int = (summBill - bill[k]) / 2

        if (b > summAnna) {
            return (b - summAnna).toString()
        } else {
            return "Bon appetit"
        }
    }
}
