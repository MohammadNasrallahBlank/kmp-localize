package io.blank.kmplocalize

import androidx.compose.runtime.*

val LocalStrings = compositionLocalOf<Translations> {
    error("No translations provided")
}

val LocalLocale = compositionLocalOf<String> {
    error("No locale set")
}

val LocalLocalizationController = compositionLocalOf<LocalizationController> {
    error("No localization controller provided")
}

@Composable
fun LocalizationProvider(
    allTranslations: LocaleMap,
    initialLocale: String,
    content: @Composable () -> Unit
) {
    var currentLocale by remember { mutableStateOf(initialLocale) }

    val currentTranslations = remember(currentLocale, allTranslations) {
        allTranslations[currentLocale] ?: emptyMap()
    }

    val controller = remember {
        LocalizationController(
            setLocale = { newLocale -> currentLocale = newLocale },
            currentLocale = { currentLocale }
        )
    }

    CompositionLocalProvider(
        LocalStrings provides currentTranslations,
        LocalLocale provides currentLocale,
        LocalLocalizationController provides controller
    ) {
        content()
    }
}
