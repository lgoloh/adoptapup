package com.example.adopt_a_pup

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adopt_a_pup.ui.theme.AdoptAPupTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdoptAPupTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    DisplayPuppyList()
                }
            }
        }
    }

    @Composable
    fun Heading() {
        MaterialTheme {
            val typography = MaterialTheme.typography
            Text("Hello and welcome to...",
                style = typography.h4,
                fontStyle = FontStyle.Italic
            )
            Text("Adopt-A-Pup!",
                style = typography.h3,
                fontStyle = FontStyle.Italic
            )
        }
    }

    @Composable
    fun PuppyItem(
        puppy: PuppyViewModel.Puppy,
        onClick: (PuppyViewModel.Puppy) -> Unit
    ) {
        MaterialTheme {
            Row(
                modifier = Modifier
                    .clickable { onClick(puppy) }
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource
                        (puppy.image ?: R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier.size(80.dp)
                )
                Text(text = puppy.name,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic)
            }
        }
    }

    fun openPuppyDetails(puppy: PuppyViewModel.Puppy) {
        PuppyViewModel.currentPuppy = puppy
        val intent = Intent(this,
            PuppyDetailActivity::class.java)
        startActivity(intent)
    }

    @Composable
    fun DisplayPuppyList() {
        Column{
            AdoptAPupTheme {
                Heading()
                for (pup in PuppyViewModel.puppyList) {
                    PuppyItem(puppy = pup) { openPuppyDetails(pup) }
                    Spacer(Modifier.size(20.dp))
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        DisplayPuppyList()
    }
}
