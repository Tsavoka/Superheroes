package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.SuperHeroesTheme
import com.example.superheroes.model.Hero
import com.example.superheroes.ui.theme.Shapes

@Composable
fun HeroesScreen(hero: Hero, modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth(),
        shape = Shapes.medium,
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.card_elevation))
    ) {
        Row(modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium))) {
            Column(modifier = modifier.weight(1f)
                .padding(end = dimensionResource(R.dimen.padding_medium))) {
                Text(
                    text = LocalContext.current.getString(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = LocalContext.current.getString(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium)))
            Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .clip(Shapes.small),
                    painter = painterResource(hero.imageRes),
                    contentDescription = stringResource(hero.nameRes),
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeroesPreview() {
    SuperHeroesTheme {
        HeroesScreen(Hero(R.string.hero4, R.string.description4, R.drawable.android_superhero4))
    }

}