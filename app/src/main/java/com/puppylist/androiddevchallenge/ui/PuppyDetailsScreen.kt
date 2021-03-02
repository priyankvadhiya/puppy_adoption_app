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

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.puppylist.androiddevchallenge.R
import com.puppylist.androiddevchallenge.ui.core.displayGender
import com.puppylist.androiddevchallenge.ui.data.Puppy

@Composable
fun PuppyDetailsScreen(puppy: Puppy, onBackPressed: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                elevation = 0.dp,
                backgroundColor = MaterialTheme.colors.primaryVariant,
                title = {
                    Text(text = puppy.name)
                },
                navigationIcon = {
                    IconButton(onClick = { onBackPressed() }) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                })
        }
    ) {
        Column(
            modifier = Modifier
                .background(color = MaterialTheme.colors.primaryVariant)
                .verticalScroll(
                    rememberScrollState()
                )
        ) {
            Box {
                PuppyImage(imageUrl = puppy.imageUrl, modifier = Modifier.aspectRatio(1f))
            }
            Column(
                modifier = Modifier.background(
                    color = MaterialTheme.colors.surface
                )
            ) {
                Text(
                    text = puppy.name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = puppy.nickName,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.size(4.dp))
                Text(
                    text = displayGender(gender = puppy.gender),
                    style = MaterialTheme.typography.subtitle2,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.size(12.dp))
                Characteristics(puppy)
                Spacer(modifier = Modifier.size(12.dp))
                Text(
                    text = stringResource(R.string.description),
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.size(12.dp))
                Text(
                    text = stringResource(R.string.doggo_common_description),
                    style = MaterialTheme.typography.body1.copy(lineHeight = 24.sp),
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

            }
        }
    }
}


@Composable
fun Characteristics(puppy: Puppy) {
    Column {
        Text(
            text = stringResource(id = R.string.age_n, puppy.ageInMonth.toString()),
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = stringResource(
                id = R.string.length_n,
                puppy.lengthInFeet.toString()
            ),
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Text(
            text = stringResource(id = R.string.color_n, puppy.color),
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
    }
}

@Composable
private fun CharacteristicChip(text: String) {
    Surface(
        modifier = Modifier.padding(horizontal = 12.dp),
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(width = 1.dp, color = Color.Gray)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp),
            style = MaterialTheme.typography.caption
        )
    }
}
