package io.blank.kmplocalize

class LocalizationController(
    val setLocale: (String) -> Unit,
    val currentLocale: () -> String
)