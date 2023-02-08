package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.data.Heroes
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroesApp()
        }
    }
}

@Composable
fun SuperHeroesApp() {
    SuperheroesTheme(darkTheme = !isSystemInDarkTheme()) {
        Scaffold(
          topBar = {
              TopBar()
          }
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                color = MaterialTheme.colors.background
            ) {
                HeroesList(list = HeroesRepository.heroes)
            }
        }
    }
}

@Composable
fun HeroesList(list: List<Heroes>, modifier: Modifier = Modifier){
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(list){
            it -> HeroesCard(hero = it)
        }
    }
}

@Composable
fun HeroesCard(hero: Heroes, modifier: Modifier = Modifier){
    Card (
        modifier = modifier
            .fillMaxWidth()
        ,
        elevation = 2.dp,
    ){
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            HeroInformation(
                hero = hero,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Image(
                modifier = Modifier.size(52.dp),
                painter = painterResource(id = hero.imageId),
                contentDescription = stringResource(id = hero.nameId)
            )
        }
    }
}

@Composable
fun HeroInformation(hero: Heroes, modifier: Modifier = Modifier){
    Column(
        modifier = modifier
    ){
        Text(
            text = stringResource(id = hero.nameId),
            style = MaterialTheme.typography.h3
        )
        Text(
            text = stringResource(id = hero.abilityId),
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun TopBar(modifier: Modifier = Modifier){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(MaterialTheme.colors.background),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Superheroes",
            style = MaterialTheme.typography.h1
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperHeroesApp()
}