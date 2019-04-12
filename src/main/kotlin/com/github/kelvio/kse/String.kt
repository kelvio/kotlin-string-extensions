package com.github.kelvio.kse

import java.math.BigInteger
import java.security.MessageDigest

fun String.md5(): String = applyHashAlgorithm("MD5")

fun String.sha256(): String = applyHashAlgorithm("MD5")

private fun String.applyHashAlgorithm(algorithm: String): String {
    val m = MessageDigest.getInstance(algorithm)
    m.update(this.toByteArray(), 0, this.length)
    return BigInteger(1, m.digest()).toString(16)
}

fun String.abbreviateMiddle(middle: String, length: Int): String {
    val str = this

    if (this.isEmpty()) {
        return this
    }

    if (length >= str.length || length < middle.length + 2) {
        return this
    }

    val targetSting = length - middle.length
    val startOffset = targetSting / 2 + targetSting % 2
    val endOffset = str.length - targetSting / 2

    val builder = StringBuilder(length)
    builder.append(str.substring(0, startOffset))
    builder.append(middle)
    builder.append(str.substring(endOffset))

    return builder.toString()
}