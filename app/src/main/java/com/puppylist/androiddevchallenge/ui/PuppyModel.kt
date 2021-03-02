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

import androidx.lifecycle.ViewModel
import com.puppylist.androiddevchallenge.ui.data.Gender
import com.puppylist.androiddevchallenge.ui.data.Puppy

class PuppyModel : ViewModel() {
    val puppies = listOf(
        Puppy(
            id = 1,
            name = "Puppy 1",
            nickName = "Ace",
            gender = Gender.FEMALE,
            ageInMonth = 6,
            lengthInFeet = 1f,
            distanceInMiles = 10,
            color = "White",
            imageUrl = "data:image/jpeg;base64,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"
        ),
        Puppy(
            id = 2,
            name = "Puppy 2",
            nickName = "Apollo",
            gender = Gender.MALE,
            ageInMonth = 8,
            lengthInFeet = 1.2f,
            distanceInMiles = 12,
            color = "Black",
            imageUrl = "data:image/jpeg;base64,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"
        ),
        Puppy(
            id = 3,
            name = "Puppy 3",
            nickName = "Bailey",
            gender = Gender.FEMALE,
            ageInMonth = 8,
            lengthInFeet = 0.8f,
            distanceInMiles = 16,
            color = "Brown",
            imageUrl = "data:image/jpeg;base64,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"
        ),
        Puppy(
            id = 4,
            name = "Puppy 4",
            nickName = "Bandit",
            gender = Gender.FEMALE,
            ageInMonth = 10,
            lengthInFeet = 0.9f,
            distanceInMiles = 19,
            color = "Black",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRNM42Oyk97PPwaMmNgmISK3bgOnMhAXVYmUg&usqp=CAU"
        ),
        Puppy(
            id = 5,
            name = "Puppy 5",
            nickName = "Baxter",
            gender = Gender.FEMALE,
            ageInMonth = 7,
            lengthInFeet = 0.5f,
            distanceInMiles = 10,
            color = "White",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRWeA5-zFa86-P6aDd5NUERS6ay9isKpgkDiQ&usqp=CAU"
        ),
        Puppy(
            id = 6,
            name = "Puppy 6",
            nickName = "Bear",
            gender = Gender.MALE,
            ageInMonth = 10,
            lengthInFeet = 0.9f,
            distanceInMiles = 19,
            color = "Brown",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRYjF1SBQBxqajfMpzzXRKHC6Zbea_SK_jngA&usqp=CAU"
        ),
        Puppy(
            id = 7,
            name = "Puppy 7",
            nickName = "Berry",
            gender = Gender.FEMALE,
            ageInMonth = 10,
            lengthInFeet = 0.9f,
            distanceInMiles = 19,
            color = "Brown",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRpoPA_wHYwW8_HYGVPbn5CNZdWSkkjEC8NhA&usqp=CAU"
        ),
        Puppy(
            id = 8,
            name = "Puppy 8",
            nickName = "Johny",
            gender = Gender.FEMALE,
            ageInMonth = 10,
            lengthInFeet = 0.9f,
            distanceInMiles = 19,
            color = "White",
            imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTRraeYH39i7peGfEJ6HlOUN_7imqt51a_a3g&usqp=CAU"
        )
    )

    private var _clickedPuppy: Puppy? = null

    val clickedPuppy get() = _clickedPuppy ?: puppies.first()

    fun onPuppyClicked(puppy: Puppy) {
        this._clickedPuppy = puppy
    }
}