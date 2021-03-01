package com.example.adopt_a_pup

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adopt_a_pup.ui.theme.AdoptAPupTheme

class PuppyDetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdoptAPupTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PuppyViewModel.currentPuppy?.let { PuppyDetails(puppy = it) }
                }
            }
        }
    }

    @Composable
    fun PuppyDetails(puppy: PuppyViewModel.Puppy) {
        Column {
            Image(
                painter = painterResource
                    (puppy.image ?: R.drawable.ic_launcher_background),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth()
            )
            Column {
                val map = attributeMap(puppy);
                for ((key, value) in map) {
                    PuppyAttribute(attribute = key, value = value)
                    Spacer(Modifier.size(20.dp))
                }
            }
        }
    }

    @Composable
    fun PuppyAttribute(attribute: String, value: String) {
        Row {
            Text(text = attribute)
            Spacer(Modifier.size(20.dp))
            Text(text = value)
        }
    }

    private fun attributeMap(puppy: PuppyViewModel.Puppy): HashMap<String, String> {
        val attributeMap = LinkedHashMap<String, String>()
        attributeMap["Name"] = puppy.name
        attributeMap["Age"] = puppy.ageInMonths.toString() + " months"
        attributeMap["Breed"] = puppy.breed
        attributeMap["Height"] = puppy.heightInCm.toString() + " cm"
        attributeMap["Weight"] = puppy.weightInKg.toString() + " kg"
        attributeMap["Personality"] = puppy.personality
        return attributeMap
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        PuppyViewModel.currentPuppy?.let { PuppyDetails(puppy = it) }
    }
}