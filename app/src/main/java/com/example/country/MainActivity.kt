// MainActivity.kt - Interface utilisateur
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Alignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryListScreen(countries = getCountryList())
        }
    }

    // Exemple de liste statique de pays
    private fun getCountryList(): List<Country> = listOf(
        Country("France", "Paris", "FR", R.drawable.france_flag),
        Country("Germany", "Berlin", "DE", R.drawable.germany_flag),
        Country("Spain", "Madrid", "ES", R.drawable.spain_flag),
        Country("Italy", "Rome", "IT", R.drawable.italy_flag),
        Country("Canada", "Ottawa", "CA", R.drawable.canada_flag)
    )
}

@Composable
fun CountryItem(country: Country) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = country.flagResource),
            contentDescription = "${country.name} Flag",
            modifier = Modifier
                .size(48.dp)
                .padding(end = 8.dp)
        )
        Column {
            Text(
                text = country.name,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            Text(
                text = "${country.capital} / ${country.code}",
                textAlign = TextAlign.Start
            )
        }
    }
}

@Composable
fun CountryListScreen(countries: List<Country>) {
    LazyColumn {
        items(countries) { country ->
            CountryItem(country)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCountryList() {
    val countries = listOf(
        Country("France", "Paris", "FR", R.drawable.france_flag),
        Country("Germany", "Berlin", "DE", R.drawable.germany_flag),
        Country("Spain", "Madrid", "ES", R.drawable.spain_flag),
        Country("Italy", "Rome", "IT", R.drawable.italy_flag),
        Country("Canada", "Ottawa", "CA", R.drawable.canada_flag)
    )
    CountryListScreen(countries)
}
