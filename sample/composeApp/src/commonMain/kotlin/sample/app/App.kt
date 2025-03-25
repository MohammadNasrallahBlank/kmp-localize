package sample.app

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.blank.kmplocalize.LocalLocale
import io.blank.kmplocalize.LocalLocalizationController
import io.blank.kmplocalize.LocalizationProvider
import io.blank.kmplocalize.t

@Composable
fun App() {
    LocalizationProvider(
        allTranslations = translations,
        initialLocale = "en"
    ) {
        DemoScreen()
    }
}


@Composable
fun DemoScreen() {

    val controller = LocalLocalizationController.current
    val currentLocale = LocalLocale.current

    Column(
        modifier = Modifier.padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(t("hello"), style = MaterialTheme.typography.headlineLarge)
        Text(t("welcome"), style = MaterialTheme.typography.bodyLarge)

        Button(onClick = {
            val newLocale = if (currentLocale == "en") "fr" else "en"
            controller.setLocale(newLocale)
        }) {
            Text(t("change_language"))
        }
    }
}