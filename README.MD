## 🌍 KMP Localize - A Localization Library for Compose Web (WASM)

**KMP Localize** is a lightweight and developer-friendly localization library built specifically for **Jetpack Compose for Web (WASM)**. It provides a simple `t("key")` API and supports runtime locale switching using idiomatic Compose tools like `CompositionLocal`.

🚀 Optimized for Kotlin Multiplatform (WASM) — not intended for Android or JVM.

Note: Works up until compose-multiplatform = "1.8.0-alpha02"

---

## 📦 Installation

### Using Maven Central

1. Add Maven Central to your `settings.gradle.kts` (if not already there):

```kotlin
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}
```

2. Add the dependency to your `build.gradle.kts`:

```kotlin
dependencies {
    implementation("io.blankonline.moe:kmp-localize:<version>")
}
```

---

## 🚀 Features

✅ `t("key")` for simple translation access  
✅ Runtime locale switching  
✅ Fully Compose idiomatic with `CompositionLocal`  
✅ Tiny, no dependencies  
✅ Works great with Compose WASM

📌 This library is WASM-only. It does not support Android or JVM.

---

## 🔧 Usage

### Step 1: Define your translations

```kotlin
val translations = mapOf(
    "en" to mapOf(
        "hello" to "Hello!",
        "welcome" to "Welcome to our app",
        "change_language" to "Change to French"
    ),
    "fr" to mapOf(
        "hello" to "Bonjour !",
        "welcome" to "Bienvenue dans notre application",
        "change_language" to "Passer à l'anglais"
    )
)
```

---

### Step 2: Wrap your app with `LocalizationProvider`

```kotlin
@Composable
fun App() {
    LocalizationProvider(
        allTranslations = translations,
        initialLocale = "en"
    ) {
        DemoScreen()
    }
}
```

---

### Step 3: Use `t("key")` in your UI

```kotlin
@Composable
fun DemoScreen() {
    val controller = LocalLocalizationController.current
    val currentLocale = LocalLocale.current

    Column {
        Text(t("hello"))
        Text(t("welcome"))

        Button(onClick = {
            val newLocale = if (currentLocale == "en") "fr" else "en"
            controller.setLocale(newLocale)
        }) {
            Text(t("change_language"))
        }
    }
}
```

---

## 🧩 API Reference

| API | Description |
|-----|-------------|
| `t("key")` | Get the localized string for the current locale |
| `LocalizationProvider(...)` | Provides translations and locale state |
| `LocalLocalizationController.current` | Get the controller to change the locale |
| `LocalLocale.current` | Current active locale string (e.g., `"en"`) |
| `LocalStrings.current` | Raw translation map for the current locale |

---

## 📜 License

MIT — free for personal and commercial use. Attribution appreciated.

---

## 🙌 Credits

Built with ❤️ by [Mohamad](https://github.com/MohammadNasrallahBlank)
