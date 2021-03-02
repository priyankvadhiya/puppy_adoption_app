/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.puppylist.androiddevchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.puppylist.androiddevchallenge.R
import com.puppylist.androiddevchallenge.ui.core.NetworkImage
import com.puppylist.androiddevchallenge.ui.core.displayGender
import com.puppylist.androiddevchallenge.ui.data.Puppy

@Composable
fun PuppyListScreen(puppies: List<Puppy>, onItemClicked: (puppy: Puppy) -> Unit) {
    Scaffold(topBar = {
        TopAppBar(elevation = 0.dp, backgroundColor = MaterialTheme.colors.primaryVariant, title = {
            Text(text = "Puppy List")
        })
    }) {
        Column(modifier = Modifier.background(color = MaterialTheme.colors.primaryVariant)) {
            PuppyList(
                puppies = puppies,
                modifier = Modifier.background(
                    color = Color.White
                ),
                onItemClicked = {
                    onItemClicked(it)
                }
            )
        }
    }
}

@Composable
fun PuppyList(
    puppies: List<Puppy>,
    onItemClicked: (puppy: Puppy) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(top = 8.dp, bottom = 8.dp),
        content = {
            items(puppies) { puppy ->
                PuppyItem(
                    puppy = puppy,
                    modifier = Modifier.clickable {
                        onItemClicked(puppy)
                    }
                )
            }
        }
    )
}

@Composable
fun PuppyItem(puppy: Puppy, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            PuppyImage(imageUrl = puppy.imageUrl)
            Spacer(modifier = Modifier.size(16.dp))
            PuppyInfo(puppy = puppy)
        }
    }
}

@Composable
fun PuppyImage(imageUrl: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(120.dp)
    ) {
        NetworkImage(imageUrl = imageUrl)
    }
}

@Composable
fun PuppyInfo(puppy: Puppy) {
    Column {
        Text(text = puppy.name, style = MaterialTheme.typography.h6)
        Text(text = puppy.nickName, style = MaterialTheme.typography.body2)
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = stringResource(
                id = R.string.puppy_body_info_n,
                puppy.ageInMonth.toString(),
                puppy.lengthInFeet.toString()
            ),
            style = MaterialTheme.typography.caption
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = displayGender(gender = puppy.gender),
            style = MaterialTheme.typography.subtitle2
        )
        Spacer(modifier = Modifier.size(8.dp))
    }
}
