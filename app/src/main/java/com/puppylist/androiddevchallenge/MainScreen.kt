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
package com.puppylist.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.puppylist.androiddevchallenge.ui.PuppyDetailsScreen
import com.puppylist.androiddevchallenge.ui.PuppyListScreen
import com.puppylist.androiddevchallenge.ui.PuppyModel
import com.puppylist.androiddevchallenge.ui.core.Routes
import com.puppylist.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()
    val viewModel = viewModel<PuppyModel>()

    Surface(color = MaterialTheme.colors.background) {
        NavHost(navController = navController, startDestination = Routes.PUPPY_LIST_SCREEN) {
            composable(Routes.PUPPY_LIST_SCREEN) {
                PuppyListScreen(
                    puppies = viewModel.puppies,
                    onItemClicked = {
                        viewModel.onPuppyClicked(it)
                        navController.navigate(Routes.PUPPY_DETAILS_SCREEN)
                    }
                )
            }
            composable(Routes.PUPPY_DETAILS_SCREEN) {
                PuppyDetailsScreen(
                    puppy = viewModel.clickedPuppy,
                    onBackPressed = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
