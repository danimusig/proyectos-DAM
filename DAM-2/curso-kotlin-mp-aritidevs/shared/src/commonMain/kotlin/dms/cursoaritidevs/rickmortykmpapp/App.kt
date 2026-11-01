package dms.cursoaritidevs.rickmortykmpapp

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import dms.cursoaritidevs.rickmortykmpapp.ui.core.navigation.NavigationWrapper

@Composable
@Preview
fun App() {
    MaterialTheme {
        NavigationWrapper()
    }
}