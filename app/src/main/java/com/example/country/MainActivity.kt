package com.example.country

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.country.pays.Country
import com.example.country.ui.theme.CountryTheme



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CountryTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    CountryList(countries = getCountries())
                }
            }
        }
    }

    // Mock list of countries with associated images
    private fun getCountries(): List<Country> = listOf(
        Country("France", "Paris", "FR", R.drawable.image3),
        Country("USA", "Washington", "US", R.drawable.image2),
        Country("RDC", "Kinshasa", "CD", R.drawable.image1),
        Country("Spain", "Madrid", "ES", R.drawable.image3),
        Country("Canada", "Ottawa", "CA", R.drawable.image2)
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
        // Display the image associated with the country
        Image(
            painter = painterResource(id = country.imageRes),
            contentDescription = "Country Flag",
            modifier = Modifier
                .size(50.dp)
                .padding(end = 8.dp)
        )
        Column {
            Text(
                text = country.name,
                style = MaterialTheme.typography.bodyLarge
            )
            Text(
                text = "${country.capital} / ${country.code}",
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Composable
fun CountryList(countries: List<Country>) {
    LazyColumn {
        items(countries) { country ->
            CountryItem(country)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCountryList() {
    CountryTheme {
        CountryList(
            countries = listOf(
                Country("France", "Paris", "FR", R.drawable.image3),
                Country("USA", "Washington", "US", R.drawable.image2),
                Country("RDC", "Kinshasa", "CD", R.drawable.image1)
            )
        )
    }
}
