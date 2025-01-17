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
package com.puppylist.androiddevchallenge.ui.data

data class Puppy(
    val id: Int,
    val name: String,
    val nickName: String,
    val gender: Gender,
    val ageInMonth: Int,
    val lengthInFeet: Float,
    val distanceInMiles: Int,
    val color: String,
    val imageUrl: String
)

enum class Gender {
    MALE, FEMALE
}
