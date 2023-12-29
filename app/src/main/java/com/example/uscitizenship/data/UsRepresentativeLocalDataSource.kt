package com.example.uscitizenship.data

fun getUsRepresentatives(stateOrDistrict: String): List<String> {
    val usRepMap = mapOf(
        "Alabama" to listOf(
            "Barry Moore",
            "Dale Strong",
            "Gary Palmer",
            "Jerry Carl",
            "Mike Rogers",
            "Robert Aderholt",
            "Terri Sewell",
        ),
        "Alaska" to listOf(
            "Mary Peltola"
        ),
        "American Samoa" to listOf(
            "Aumua Amata Radewagen"
        ),
        "Arizona" to listOf(
            "Andy Biggs",
            "David Schweikert",
            "Debbie Lesko",
            "Elijah Crane",
            "Greg Stanton",
            "Juan Ciscomani",
            "Paul Gosar",
            "Raul Grijalva",
            "Ruben Gallego",
        ),
        "Arkansas" to listOf(
            "Bruce Westerman",
            "Eric Crawford",
            "J. French Hill",
            "Steve Womack",
        ),
        /////////// sorted^^ /////////
        "California" to listOf(
            "LaMalfa, Doug",
            "Huffman, Jared",
            "Kiley, Kevin",
            "Thompson, Mike",
            "McClintock, Tom",
            "Bera, Ami",
            "Matsui, Doris",
            "Garamendi, John",
            "Harder, Josh",
            "DeSaulnier, Mark",
            "Pelosi, Nancy",
            "Lee, Barbara",
            "Duarte, John",
            "Swalwell, Eric",
            "Mullin, Kevin",
            "Eshoo, Anna",
            "Khanna, Ro",
            "Lofgren, Zoe",
            "Panetta, Jimmy",
            "McCarthy, Kevin",
            "Costa, Jim",
            "Valadao, David",
            "Obernolte, Jay",
            "Carbajal, Salud",
            "Ruiz, Raul",
            "Brownley, Julia",
            "Garcia, Mike",
            "Chu, Judy",
            "Cardenas, Tony",
            "Schiff, Adam",
            "Napolitano, Grace",
            "Sherman, Brad",
            "Aguilar, Pete",
            "Gomez, Jimmy",
            "Torres, Norma",
            "Lieu, Ted",
            "Kamlager-Dove, Sydney",
            "Sanchez, Linda",
            "Takano, Mark",
            "Kim, Young",
            "Calvert, Ken",
            "Garcia, Robert",
            "Waters, Maxine",
            "Barragan, Nanette",
            "Steel, Michelle",
            "J. Luis Correa",
            "Porter, Katie",
            "Issa, Darrell",
            "Levin, Mike",
            "Peters, Scott",
            "Jacobs, Sara",
            "Vargas, Juan",
        ),
        "Colorado" to listOf(
            "DeGette, Diana",
            "Neguse, Joe",
            "Boebert, Lauren",
            "Buck, Ken",
            "Lamborn, Doug",
            "Crow, Jason",
            "Pettersen, Brittany",
            "Caraveo, Yadira",
        ),
        "Connecticut" to listOf(
            "Larson, John",
            "Courtney, Joe",
            "DeLauro, Rosa",
            "Himes, James",
            "Hayes, Jahana",
        ),
        "Delaware" to listOf("Blunt Rochester, Lisa"),
        "District of Columbia" to listOf("Norton, Eleanor"),
        "Florida" to listOf(
            "Gaetz, Matt",
            "Dunn, Neal",
            "Cammack, Kat",
            "Bean, Aaron",
            "Rutherford, John",
            "Waltz, Michael",
            "Mills, Cory",
            "Posey, Bill",
            "Soto, Darren",
            "Frost, Maxwell",
            "Webster, Daniel",
            "Bilirakis, Gus",
            "Luna, Anna Paulina",
            "Castor, Kathy",
            "Lee, Laurel",
            "Buchanan, Vern",
            "W. Gregory Steube",
            "Franklin, Scott",
            "Donalds, Byron",
            "Cherfilus-McCormick, Sheila",
            "Mast, Brian",
            "Frankel, Lois",
            "Moskowitz, Jared",
            "Wilson, Frederica",
            "Wasserman Schultz, Debbie",
            "Diaz-Balart, Mario",
            "Salazar, Maria",
            "Gimenez, Carlos",
        ),
        "Georgia" to listOf(
            "Carter, Earl",
            "Bishop, Sanford",
            "A. Drew Ferguson",
            "Johnson, Henry",
            "Williams, Nikema",
            "McCormick, Richard",
            "McBath, Lucy",
            "Scott, Austin",
            "Clyde, Andrew",
            "Collins, Mike",
            "Loudermilk, Barry",
            "Allen, Rick",
            "Scott, David",
            "Greene, Marjorie",
        ),
        "Guam" to listOf("Moylan, James"),
        "Hawaii" to listOf(
            "Case, Ed",
            "Tokuda, Jill",
        ),
        "Idaho" to listOf(
            "Fulcher, Russ",
            "Simpson, Michael",
        ),
        "Illinois" to listOf(
            "Jackson, Jonathan",
            "Kelly, Robin",
            "Ramirez, Delia",
            "Garcia, Jesus",
            "Quigley, Mike",
            "Casten, Sean",
            "Davis, Danny",
            "Krishnamoorthi, Raja",
            "Schakowsky, Janice",
            "Schneider, Bradley",
            "Foster, Bill",
            "Bost, Mike",
            "Budzinski, Nikki",
            "Underwood, Lauren",
            "Miller, Mary",
            "Miller, Mary",
            "Sorensen, Eric",
        ),
        "Indiana" to listOf(
            "Mrvan, Frank",
            "Yakym, Rudy",
            "Banks, Jim",
            "Baird, James",
            "Spartz, Victoria",
            "Pence, Greg",
            "Carson, Andre",
            "Bucshon, Larry",
            "Houchin, Erin",
        ),
        "Iowa" to listOf(
            "Miller-Meeks, Mariannette",
            "Hinson, Ashley",
            "Nunn, Zachary",
            "Feenstra, Randy",
        ),
        "Kansas" to listOf(
            "Mann, Tracey",
            "LaTurner, Jake",
            "Davids, Sharice",
            "Estes, Ron",
        ),
        "Kentucky" to listOf(
            "Comer, James",
            "Guthrie, Brett",
            "McGarvey, Morgan",
            "Massie, Thomas",
            "Rogers, Harold",
            "Barr, Andy",
        ),
        "Louisiana" to listOf(
            "Scalise, Steve",
            "Carter, Troy",
            "Higgins, Clay",
            "Johnson, Mike",
            "Letlow, Julia",
            "Graves, Garret",
        ),
        "Maine" to listOf(
            "Pingree, Chellie",
            "Golden, Jared",
        ),
        "Maryland" to listOf(
            "Harris, Andy",
            "C.A. Dutch Ruppersberger",
            "Sarbanes, John",
            "Ivey, Glenn",
            "Hoyer, Steny",
            "Trone, David",
            "Mfume, Kweisi",
            "Raskin, Jamie",
        ),
        "Massachusetts" to listOf(
            "Neal, Richard",
            "McGovern, James",
            "Trahan, Lori",
            "Auchincloss, Jake",
            "Clark, Katherine",
            "Moulton, Seth",
            "Pressley, Ayanna",
            "Lynch, Stephen",
            "Keating, William",
        ),
        "Michigan" to listOf(
            "Bergman, Jack",
            "Moolenaar, John",
            "Scholten, Hillary",
            "Huizenga, Bill",
            "Walberg, Tim",
            "Dingell, Debbie",
            "Slotkin, Elissa",
            "Kildee, Daniel",
            "McClain, Lisa",
            "James, John",
            "Stevens, Haley",
            "Tlaib, Rashida",
            "Thanedar, Shri",
        ),
        "Minnesota" to listOf(
            "Finstad, Brad",
            "Craig, Angie",
            "Phillips, Dean",
            "McCollum, Betty",
            "Omar, Ilhan",
            "Emmer, Tom",
            "Fischbach, Michelle",
            "Stauber, Pete",
        ),
        "Mississippi" to listOf(
            "Kelly, Trent",
            "Thompson, Bennie",
            "Guest, Michael",
            "Ezell, Mike",
        ),
        "Missouri" to listOf(
            "Bush, Cori",
            "Wagner, Ann",
            "Luetkemeyer, Blaine",
            "Alford, Mark",
            "Cleaver, Emanuel",
            "Graves, Sam",
            "Burlison, Eric",
            "Smith, Jason",
        ),
        "Montana" to listOf(
            "Zinke, Ryan",
            "Rosendale, Matthew",
        ),
        "Nebraska" to listOf(
            "Flood, Mike",
            "Bacon, Don",
            "Smith, Adrian",
        ),
        "Nevada" to listOf(
            "Titus, Dina",
            "Amodei, Mark",
            "Lee, Susie",
            "Horsford, Steven",
        ),
        "New Hampshire" to listOf(
            "Pappas, Chris",
            "Kuster, Ann",
        ),
        "New Jersey" to listOf(
            "Norcross, Donald",
            "Van Drew, Jefferson",
            "Kim, Andy",
            "Smith, Christopher",
            "Gottheimer, Josh",
            "Pallone, Frank",
            "Kean, Thomas",
            "Menendez, Robert",
            "Pascrell, Bill",
            "Payne, Donald",
            "Sherrill, Mikie",
            "Watson Coleman, Bonnie",
        ),
        "New Mexico" to listOf(
            "Stansbury, Melanie",
            "Vasquez, Gabe",
            "Leger Fernandez, Teresa",
        ),
        "New York" to listOf(
            "LaLota, Nick",
            "Garbarino, Andrew",
            "Santos, George",
            "D'Esposito, Anthony",
            "Meeks, Gregory",
            "Meng, Grace",
            "Velazquez, Nydia",
            "Jeffries, Hakeem",
            "Clarke, Yvette",
            "Goldman, Daniel",
            "Malliotakis, Nicole",
            "Nadler, Jerrold",
            "Espaillat, Adriano",
            "Ocasio-Cortez, Alexandria",
            "Torres, Ritchie",
            "Bowman, Jamaal",
            "Lawler, Michael",
            "Ryan, Patrick",
            "Molinaro, Marcus",
            "Tonko, Paul",
            "Stefanik, Elise",
            "Williams, Brandon",
            "Langworthy, Nicholas",
            "Tenney, Claudia",
            "Morelle, Joseph",
            "Higgins, Brian",
        ),
        "North Carolina" to listOf(
            "Davis, Donald",
            "Ross, Deborah",
            "Murphy, Gregory",
            "Foushee, Valerie",
            "Foxx, Virginia",
            "Manning, Kathy",
            "Rouzer, David",
            "Bishop, Dan",
            "Hudson, Richard",
            "McHenry, Patrick",
            "Edwards, Chuck",
            "Adams, Alma",
            "Nickel, Wiley",
            "Jackson, Jeff",
        ),
        "North Dakota" to listOf("Armstrong, Kelly"),
        "Northern Mariana Islands" to listOf("Sablan, Gregorio"),
        "Ohio" to listOf(
            "Landsman, Greg",
            "Wenstrup, Brad",
            "Beatty, Joyce",
            "Jordan, Jim",
            "Latta, Robert",
            "Johnson, Bill",
            "Miller, Max",
            "Davidson, Warren",
            "Kaptur, Marcy",
            "Turner, Michael",
            "Brown, Shontel",
            "Balderson, Troy",
            "Sykes, Emilia",
            "Joyce, David",
            "Carey, Mike",
        ),
        "Oklahoma" to listOf(
            "Hern, Kevin",
            "Brecheen, Josh",
            "Lucas, Frank",
            "Cole, Tom",
            "Bice, Stephanie",
        ),
        "Oregon" to listOf(
            "Bonamici, Suzanne",
            "Bentz, Cliff",
            "Blumenauer, Earl",
            "Hoyle, Val",
            "Chavez-DeRemer, Lori",
            "Salinas, Andrea",
        ),
        "Pennsylvania" to listOf(
            "Fitzpatrick, Brian",
            "Boyle, Brendan",
            "Evans, Dwight",
            "Dean, Madeleine",
            "Scanlon, Mary",
            "Houlahan, Chrissy",
            "Wild, Susan",
            "Cartwright, Matt",
            "Meuser, Daniel",
            "Perry, Scott",
            "Smucker, Lloyd",
            "Lee, Summer",
            "Joyce, John",
            "Reschenthaler, Guy",
            "Thompson, Glenn",
            "Kelly, Mike",
            "Deluzio, Christopher",
        ),
        "Puerto Rico" to listOf("Gonzalez-Colon, Jenniffer"),
        "Rhode Island" to listOf(
            "Amo, Gabe",
            "Magaziner, Seth",
        ),
        "South Carolina" to listOf(
            "Mace, Nancy",
            "Wilson, Joe",
            "Duncan, Jeff",
            "Timmons, William",
            "Norman, Ralph",
            "Clyburn, James",
            "Fry, Russell",
        ),
        "South Dakota" to listOf("Johnson, Dusty"),
        "Tennessee" to listOf(
            "Harshbarger, Diana",
            "Burchett, Tim",
            "Fleischmann, Charles",
            "DesJarlais, Scott",
            "Ogles, Andrew",
            "Rose, John",
            "Green, Mark",
            "Kustoff, David",
            "Cohen, Steve",
        ),
        "Texas" to listOf(
            "Moran, Nathaniel",
            "Crenshaw, Dan",
            "Self, Keith",
            "Fallon, Pat",
            "Gooden, Lance",
            "Ellzey, Jake",
            "Fletcher, Lizzie",
            "Luttrell, Morgan",
            "Green, Al",
            "McCaul, Michael",
            "Pfluger, August",
            "Granger, Kay",
            "Jackson, Ronny",
            "Weber, Randy",
            "De La Cruz, Monica",
            "Escobar, Veronica",
            "Sessions, Pete",
            "Jackson Lee, Sheila",
            "Arrington, Jodey",
            "Castro, Joaquin",
            "Roy, Chip",
            "Nehls, Troy",
            "Gonzales, Tony",
            "Van Duyne, Beth",
            "Williams, Roger",
            "Burgess, Michael",
            "Cloud, Michael",
            "Cuellar, Henry",
            "Garcia, Sylvia",
            "Crockett, Jasmine",
            "Carter, John",
            "Allred, Colin",
            "Veasey, Marc",
            "Gonzalez, Vicente",
            "Casar, Greg",
            "Babin, Brian",
            "Doggett, Lloyd",
            "Hunt, Wesley",
        ),
        "Utah" to listOf(
            "Moore, Blake",
            "Maloy, Celeste",
            "Curtis, John",
            "Owens, Burgess",
        ),
        "Vermont" to listOf("Balint, Becca"),
        "Virginia" to listOf(
            "Wittman, Robert",
            "Kiggans, Jennifer",
            "Scott, Robert",
            "McClellan, Jennifer",
            "Good, Bob",
            "Cline, Ben",
            "Spanberger, Abigail",
            "Beyer, Donald",
            "H. Morgan Griffith",
            "Wexton, Jennifer",
            "Connolly, Gerald",
        ),
        "Virgin Islands" to listOf("Plaskett, Stacey"),
        "Washington" to listOf(
            "DelBene, Suzan",
            "Larsen, Rick",
            "Perez, Marie",
            "Newhouse, Dan",
            "Rodgers, Cathy",
            "Kilmer, Derek",
            "Jayapal, Pramila",
            "Schrier, Kim",
            "Smith, Adam",
            "Strickland, Marilyn",
        ),
        "West Virginia" to listOf(
            "Miller, Carol",
            "Mooney, Alexander",
        ),
        "Wisconsin" to listOf(
            "Steil, Bryan",
            "Pocan, Mark",
            "Van Orden, Derrick",
            "Moore, Gwen",
            "Fitzgerald, Scott",
            "Grothman, Glenn",
            "Tiffany, Thomas",
            "Gallagher, Mike",
        ),
        "Wyoming" to listOf("Hageman, Harriet"),
    )
    return usRepMap[stateOrDistrict] ?: listOf()
}