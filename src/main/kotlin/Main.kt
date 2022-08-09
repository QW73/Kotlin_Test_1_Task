data class OutputData(val a: Int, val b: Int)

fun main() {
    var answer = 0
    var leftHandSum = 0
    var rightHandSum = 0
    val (n, t) = consoleRead()
    val str = readLine()!!
    val byteArray = ByteArray(n)
    val epmNumber = readLine()!!.toInt()
    val strArray = str.split(" ").toTypedArray()
    strArray.sortWith(compareBy({ it.length }, { it }))
    for (x in strArray.indices) {
        if (x >= byteArray.size) break
        byteArray[x] = strArray[x].toByte()
    }

    if (t < byteArray[epmNumber - 1]) {

        for (i in 0 until (epmNumber - 1)) {
            leftHandSum += byteArray[i]
        }
        for (i in epmNumber until byteArray.size) {
            rightHandSum += byteArray[i]
        }

        if (leftHandSum < rightHandSum) {
            answer =
                (byteArray[epmNumber - 1] - byteArray[0]) + (byteArray[epmNumber - 1] - byteArray[0]) + (byteArray[n - 1] - byteArray[epmNumber - 1])
        }
        if (leftHandSum >= rightHandSum) {
            answer =
                (byteArray[n - 1] - byteArray[epmNumber - 1]) + (byteArray[n - 1] - byteArray[epmNumber - 1]) + (byteArray[epmNumber - 1] - byteArray[0])
        }
    }

    if (t >= byteArray[epmNumber - 1]) {
        answer = byteArray[n - 1] - byteArray[0]
    }
    println(answer)
}


fun consoleRead(): OutputData {
    val (a, b) = readLine()!!.split(' ').map(String::toInt)
    return OutputData(a, b)
}

