package io.blank.kmplocalize

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

@Composable
@ReadOnlyComposable
fun t(key: String): String {
    return LocalStrings.current[key] ?: "[$key]"
}

