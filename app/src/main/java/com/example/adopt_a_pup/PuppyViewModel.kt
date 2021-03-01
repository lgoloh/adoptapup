package com.example.adopt_a_pup

object PuppyViewModel {

    var puppyList: MutableList<Puppy> = mutableListOf()
    var currentPuppy: Puppy? = null

    init {
        generatePuppyList()
    }

    private fun generatePuppyList() {
        val avery = Puppy(name = "Avery", image = R.drawable.avery, ageInMonths = 10,
            breed = "Labrador", heightInCm = 20, weightInKg = 30,
            personality = "Playful and cuddly. Moody on rainy days"
        )
        val axe = Puppy(name = "Axe", image = R.drawable.husky_puppy, ageInMonths = 5,
            breed = "Husky", heightInCm = 10, weightInKg = 12,
            personality = "Loves snow and feet"
        )
        val marsh = Puppy(name = "Marsh", image = R.drawable.puppy_poodle, ageInMonths = 12,
            breed = "Poodle", heightInCm = 8, weightInKg = 10,
            personality = "Intelligent but standoffish"
        )
        val yuki = Puppy(name = "Yuki", image = R.drawable.puppy_australian_shepherd, ageInMonths = 10,
            breed = "Australian Shepherd", heightInCm = 20, weightInKg = 30,
            personality = "Playful and cuddly. Moody on rainy days"
        )
        val yoshi = Puppy(name = "Yoshi", image = R.drawable.puppy_rottweiler, ageInMonths = 10,
            breed = "Rottweiler", heightInCm = 20, weightInKg = 30,
            personality = "Playful and cuddly. Moody on rainy days"
        )

        puppyList.add(avery)
        puppyList.add(axe)
        puppyList.add(marsh)
        puppyList.add(yuki)
        puppyList.add(yoshi)
    }

    data class Puppy (
        var name: String,
        var image: Int? = null,
        var ageInMonths: Int? = null,
        var breed: String,
        var heightInCm: Int,
        var weightInKg: Int,
        var personality: String,
    )
}