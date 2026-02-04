package com.dpappdev.uscitizenship.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Up to date answers: https://uscis.gov/citizenship/testupdates
 *
 */
class AllQuestionsLocalDataSource(
    testYear: String,
    userStateOrDistrict: String,
    usRepresentative: String,
) {
    val allQuestions: Flow<List<Question>> = flow {
        emit(
            when (testYear) {
                "2008 Civics Test" -> consolidate2008Answers(userStateOrDistrict, usRepresentative, get2008Questions())
                "2025 Civics Test" -> consolidate2025Answers(userStateOrDistrict, usRepresentative, get2025Questions())
                else -> listOf()
            }
        )
    }

    fun consolidate2008Answers(
        userStateOrDistrict: String,
        usRepresentative: String,
        questions: List<Question>,
    ): List<Question> {
        if (questions.isEmpty()) return questions

        val stateGovernor = getGovernor(userStateOrDistrict)
        val stateCapital = getStateCapital(userStateOrDistrict)
        val stateSenators = getSenators(userStateOrDistrict)
        if (stateSenators.isNotEmpty()) {
            questions[19].answer = stateSenators
        }
        if (usRepresentative.isNotEmpty()) {
            questions[22].answer = listOf(usRepresentative)
        }
        if (!stateGovernor.isNullOrEmpty()) {
            questions[42].answer = listOf(stateGovernor)
        }
        if (!stateCapital.isNullOrEmpty()) {
            questions[43].answer = listOf(stateCapital)
        }
        return questions
    }

    fun consolidate2025Answers(
        userStateOrDistrict: String,
        usRepresentative: String,
        questions: List<Question>,
    ): List<Question> {
        if (questions.isEmpty()) return questions

        val stateGovernor = getGovernor(userStateOrDistrict)
        val stateCapital = getStateCapital(userStateOrDistrict)
        val stateSenators = getSenators(userStateOrDistrict)
        if (stateSenators.isNotEmpty()) {
            questions[22].answer = stateSenators
        }
        if (usRepresentative.isNotEmpty()) {
            questions[28].answer = listOf(usRepresentative)
        }
        if (!stateGovernor.isNullOrEmpty()) {
            questions[60].answer = listOf(stateGovernor)
        }
        if (!stateCapital.isNullOrEmpty()) {
            questions[61].answer = listOf(stateCapital)
        }
        return questions
    }

    fun get2008Questions(): List<Question> {
        return listOf(
            // 1
            Question(
                questionNumber = 1,
                question = "What is the supreme law of the land?",
                answer = listOf(
                    "The Constitution"
                ),
            ),
            // 2
            Question(
                questionNumber = 2,
                question = "What does the Constitution do?",
                answer = listOf(
                    "Sets up the government",
                    "Defines the government",
                    "Protects basic rights of Americans"
                ),
            ),
            // 3
            Question(
                questionNumber = 3,
                question = "The idea of self-government is in the first three words of the Constitution. What are these words?",
                answer = listOf(
                    "We the People"
                ),
            ),
            // 4
            Question(
                questionNumber = 4,
                question = "What is an amendment?",
                answer = listOf(
                    "A change (to the Constitution)",
                    "An addition (to the Constitution)"
                ),
            ),
            // 5
            Question(
                questionNumber = 5,
                question = "What do we call the first ten amendments to the Constitution?",
                answer = listOf(
                    "The Bill of Rights"
                ),
            ),
            // 6
            Question(
                questionNumber = 6,
                question = "What is one right or freedom from the First Amendment?",
                answer = listOf(
                    "Speech",
                    "Religion",
                    "Assembly",
                    "Press",
                    "Petition the government"
                ),
            ),
            // 7
            Question(
                questionNumber = 7,
                question = "How many amendments does the Constitution have?",
                answer = listOf(
                    "Twenty-seven (27)"
                ),
            ),
            // 8
            Question(
                questionNumber = 8,
                question = "What did the Declaration of Independence do?",
                answer = listOf(
                    "Announced our independence (from Great Britain)",
                    "Declared our independence (from Great Britain)",
                    "Said that the United States is free (from Great Britain)"
                ),
            ),
            // 9
            Question(
                questionNumber = 9,
                question = "What are two rights in the Declaration of Independence?",
                answer = listOf(
                    "Life",
                    "Liberty",
                    "Pursuit of happiness"
                ),
            ),
            // 10
            Question(
                questionNumber = 10,
                question = "What is freedom of religion?",
                answer = listOf(
                    "You can practice any religion, or not practice a religion."
                ),
            ),
            // 11
            Question(
                questionNumber = 11,
                question = "What is the economic system in the United States?",
                answer = listOf(
                    "Capitalist economy",
                    "Market economy"
                ),
            ),
            // 12
            Question(
                questionNumber = 12,
                question = "What is the \"rule of law\"?",
                answer = listOf(
                    "Everyone must follow the law.",
                    "Leaders must obey the law.",
                    "Government must obey the law.",
                    "No one is above the law."
                ),
            ),
            // 13
            Question(
                questionNumber = 13,
                question = "Name one branch or part of the government.",
                answer = listOf(
                    "Congress",
                    "Legislative",
                    "President",
                    "Executive",
                    "The courts",
                    "Judicial"
                ),
            ),
            // 14
            Question(
                questionNumber = 14,
                question = "What stops one branch of government from becoming too powerful?",
                answer = listOf(
                    "Checks and balances",
                    "Separation of powers"
                ),
            ),
            // 15
            Question(
                questionNumber = 15,
                question = "Who is in charge of the executive branch?",
                answer = listOf(
                    "The President"
                ),
            ),
            // 16
            Question(
                questionNumber = 16,
                question = "Who makes federal laws?",
                answer = listOf(
                    "Congress",
                    "Senate and House (of Representatives)",
                    "(U.S. or national) legislature"
                ),
            ),
            // 17
            Question(
                questionNumber = 17,
                question = "What are the two parts of the U.S. Congress?",
                answer = listOf(
                    "The Senate and House (of Representatives)"
                ),
            ),
            // 18
            Question(
                questionNumber = 18,
                question = "How many U.S. Senators are there?",
                answer = listOf(
                    "One hundred (100)"
                ),
            ),
            // 19
            Question(
                questionNumber = 19,
                question = "We elect a U.S. Senator for how many years?",
                answer = listOf(
                    "Six (6)"
                ),
            ),
            // 20
            Question(
                questionNumber = 20,
                question = "Who is one of your state's U.S. Senators now?",
                answer = listOf(
                    "<Answers will vary>"
                ),
            ),
            // 21
            Question(
                questionNumber = 21,
                question = "The House of Representatives has how many voting members?",
                answer = listOf(
                    "Four hundred thirty-five (435)"
                ),
            ),
            // 22
            Question(
                questionNumber = 22,
                question = "We elect a U.S. Representative for how many years?",
                answer = listOf(
                    "Two (2)"
                ),
            ),
            // 23
            Question(
                questionNumber = 23,
                question = "Name your U.S. Representative.",
                answer = listOf(
                    "<Answers will vary>"
                ),
            ),
            // 24
            Question(
                questionNumber = 24,
                question = "Who does a U.S. Senator represent?",
                answer = listOf(
                    "All people of the state"
                ),
            ),
            // 25
            Question(
                questionNumber = 25,
                question = "Why do some states have more Representatives than other states?",
                answer = listOf(
                    "(because of) the state's population",
                    "(because) they have more people",
                    "(because) some states have more people"
                ),
            ),
            // 26
            Question(
                questionNumber = 26,
                question = "We elect a President for how many years?",
                answer = listOf(
                    "Four (4)"
                ),
            ),
            // 27
            Question(
                questionNumber = 27,
                question = "In what month do we vote for President?",
                answer = listOf(
                    "November"
                ),
            ),
            // 28
            Question(
                questionNumber = 28,
                question = "What is the name of the President of the United States now?",
                answer = listOf(
                    "Donald Trump"
                ),
            ),
            // 29
            Question(
                questionNumber = 29,
                question = "What is the name of the Vice President of the United States now?",
                answer = listOf(
                    "JD Vance"
                ),
            ),
            // 30
            Question(
                questionNumber = 30,
                question = "If the President can no longer serve, who becomes President?",
                answer = listOf(
                    "The Vice President"
                ),
            ),
            // 31
            Question(
                questionNumber = 31,
                question = "If both the President and the Vice President can no longer serve, who becomes President?",
                answer = listOf(
                    "The Speaker of the House"
                ),
            ),
            // 32
            Question(
                questionNumber = 32,
                question = "Who is the Commander in Chief of the military?",
                answer = listOf(
                    "The President"
                ),
            ),
            // 33
            Question(
                questionNumber = 33,
                question = "Who signs bills to become laws?",
                answer = listOf(
                    "The President"
                ),
            ),
            // 34
            Question(
                questionNumber = 34,
                question = "Who vetoes bills?",
                answer = listOf(
                    "The President"
                ),
            ),
            // 35
            Question(
                questionNumber = 35,
                question = "What does the President's Cabinet do?",
                answer = listOf(
                    "Advises the President"
                ),
            ),
            // 36
            Question(
                questionNumber = 36,
                question = "What are two Cabinet-level positions?",
                answer = listOf(
                    "Secretary of Agriculture",
                    "Secretary of Commerce",
                    "Secretary of Defense",
                    "Secretary of Education",
                    "Secretary of Energy",
                    "Secretary of Health and Human Services",
                    "Secretary of Homeland Security",
                    "Secretary of Housing and Urban Development",
                    "Secretary of the Interior",
                    "Secretary of Labor",
                    "Secretary of State",
                    "Secretary of Transportation",
                    "Secretary of the Treasury",
                    "Secretary of Veterans Affairs",
                    "Attorney General",
                    "Vice President"
                ),
            ),
            // 37
            Question(
                questionNumber = 37,
                question = "What does the judicial branch do?",
                answer = listOf(
                    "Reviews laws",
                    "Explains laws",
                    "Resolves disputes (disagreements)",
                    "Decides if a law goes against the Constitution"
                ),
            ),
            // 38
            Question(
                questionNumber = 38,
                question = "What is the highest court in the United States?",
                answer = listOf(
                    "The Supreme Court"
                ),
            ),
            // 39
            Question(
                questionNumber = 39,
                question = "How many justices are on the Supreme Court?",
                answer = listOf(
                    "Nine (9)"
                ),
            ),
            // 40
            Question(
                questionNumber = 40,
                question = "Who is the Chief Justice of the United States now?",
                answer = listOf(
                    "John Roberts"
                ),
            ),
            // 41
            Question(
                questionNumber = 41,
                question = "Under our Constitution, some powers belong to the federal government. What is one power of the federal government?",
                answer = listOf(
                    "To print money",
                    "To declare war",
                    "To create an army",
                    "To make treaties"
                ),
            ),
            // 42
            Question(
                questionNumber = 42,
                question = "Under our Constitution, some powers belong to the states. What is one power of the states?",
                answer = listOf(
                    "Provide schooling and education",
                    "Provide protection (police)",
                    "Provide safety (fire departments)",
                    "Give a driver's license",
                    "Approve zoning and land use"
                ),
            ),
            // 43
            Question(
                questionNumber = 43,
                question = "Who is the Governor of your state now?",
                answer = listOf(
                    "<Answers will vary>"
                ),
            ),
            // 44
            Question(
                questionNumber = 44,
                question = "What is the capital of your state?",
                answer = listOf(
                    "<Answers will vary>"
                ),
            ),
            // 45
            Question(
                questionNumber = 45,
                question = "What are the two major political parties in the United States?",
                answer = listOf(
                    "Democratic and Republican"
                ),
            ),
            // 46
            Question(
                questionNumber = 46,
                question = "What is the political party of the President now?",
                answer = listOf(
                    "Republican (Party)"
                ),
            ),
            // 47
            Question(
                questionNumber = 47,
                question = "What is the name of the Speaker of the House of Representatives now?",
                answer = listOf(
                    "Mike Johnson"
                ),
            ),
            // 48
            Question(
                questionNumber = 48,
                question = "There are four amendments to the Constitution about who can vote. Describe one of them.",
                answer = listOf(
                    "Citizens eighteen (18) and older (can vote).",
                    "You don't have to pay (a poll tax) to vote.",
                    "Any citizen can vote. (Women and men can vote.)",
                    "A male citizen of any race (can vote)."
                ),
            ),
            // 49
            Question(
                questionNumber = 49,
                question = "What is one responsibility that is only for United States citizens?",
                answer = listOf(
                    "Serve on a jury",
                    "Vote in a federal election"
                ),
            ),
            // 50
            Question(
                questionNumber = 50,
                question = "Name one right only for United States citizens.",
                answer = listOf(
                    "Vote in a federal election",
                    "Run for federal office"
                ),
            ),
            // 51
            Question(
                questionNumber = 51,
                question = "What are two rights of everyone living in the United States?",
                answer = listOf(
                    "Freedom of expression",
                    "Freedom of speech",
                    "Freedom of assembly",
                    "Freedom to petition the government",
                    "Freedom of religion",
                    "The right to bear arms"
                ),
            ),
            // 52
            Question(
                questionNumber = 52,
                question = "What do we show loyalty to when we say the Pledge of Allegiance?",
                answer = listOf(
                    "The United States",
                    "The flag"
                ),
            ),
            // 53
            Question(
                questionNumber = 53,
                question = "What is one promise you make when you become a United States citizen?",
                answer = listOf(
                    "Give up loyalty to other countries",
                    "Defend the Constitution and laws of the United States",
                    "Obey the laws of the United States",
                    "Serve in the U.S. military (if needed)",
                    "Serve (do important work for) the nation (if needed)",
                    "Be loyal to the United States"
                ),
            ),
            // 54
            Question(
                questionNumber = 54,
                question = "How old do citizens have to be to vote for President?",
                answer = listOf(
                    "Eighteen (18) and older"
                ),
            ),
            // 55
            Question(
                questionNumber = 55,
                question = "What are two ways that Americans can participate in their democracy?",
                answer = listOf(
                    "Vote",
                    "Join a political party",
                    "Help with a campaign",
                    "Join a civic group",
                    "Join a community group",
                    "Give an elected official your opinion on an issue",
                    "Call Senators and Representatives",
                    "Publicly support or oppose an issue or policy",
                    "Run for office",
                    "Write to a newspaper"
                ),
            ),
            // 56
            Question(
                questionNumber = 56,
                question = "When is the last day you can send in federal income tax forms?",
                answer = listOf(
                    "April 15"
                ),
            ),
            // 57
            Question(
                questionNumber = 57,
                question = "When must all men register for the Selective Service?",
                answer = listOf(
                    "At age eighteen (18)",
                    "Between eighteen (18) and twenty-six (26)"
                ),
            ),
            // 58
            Question(
                questionNumber = 58,
                question = "What is one reason colonists came to America?",
                answer = listOf(
                    "Freedom",
                    "Political liberty",
                    "Religious freedom",
                    "Economic opportunity",
                    "Practice their religion",
                    "Escape persecution"
                ),
            ),
            // 59
            Question(
                questionNumber = 59,
                question = "Who lived in America before the Europeans arrived?",
                answer = listOf(
                    "American Indians",
                    "Native Americans"
                ),
            ),
            // 60
            Question(
                questionNumber = 60,
                question = "What group of people was taken to America and sold as slaves?",
                answer = listOf(
                    "Africans",
                    "People from Africa"
                ),
            ),
            // 61
            Question(
                questionNumber = 61,
                question = "Why did the colonists fight the British?",
                answer = listOf(
                    "Because of high taxes (taxation without representation)",
                    "Because the British army stayed in their houses (boarding, quartering)",
                    "Because they didn't have self-government"
                ),
            ),
            // 62
            Question(
                questionNumber = 62,
                question = "Who wrote the Declaration of Independence?",
                answer = listOf(
                    "(Thomas) Jefferson"
                ),
            ),
            // 63
            Question(
                questionNumber = 63,
                question = "When was the Declaration of Independence adopted?",
                answer = listOf(
                    "July 4, 1776"
                ),
            ),
            // 64
            Question(
                questionNumber = 64,
                question = "There were 13 original states. Name three.",
                answer = listOf(
                    "New Hampshire",
                    "Massachusetts",
                    "Rhode Island",
                    "Connecticut",
                    "New York",
                    "New Jersey",
                    "Pennsylvania",
                    "Delaware",
                    "Maryland",
                    "Virginia",
                    "North Carolina",
                    "South Carolina",
                    "Georgia"
                ),
            ),
            // 65
            Question(
                questionNumber = 65,
                question = "What happened at the Constitutional Convention?",
                answer = listOf(
                    "The Constitution was written.",
                    "The Founding Fathers wrote the Constitution."
                ),
            ),
            // 66
            Question(
                questionNumber = 66,
                question = "When was the Constitution written?",
                answer = listOf(
                    "1787"
                ),
            ),
            // 67
            Question(
                questionNumber = 67,
                question = "The Federalist Papers supported the passage of the U.S. Constitution. Name one of the writers.",
                answer = listOf(
                    "(James) Madison",
                    "(Alexander) Hamilton",
                    "(John) Jay",
                    "Publius"
                ),
            ),
            // 68
            Question(
                questionNumber = 68,
                question = "What is one thing Benjamin Franklin is famous for?",
                answer = listOf(
                    "U.S. diplomat",
                    "Oldest member of the Constitutional Convention",
                    "First Postmaster General of the United States",
                    "Writer of \"Poor Richard's Almanac\"",
                    "Started the first free libraries"
                ),
            ),
            // 69
            Question(
                questionNumber = 69,
                question = "Who is the \"Father of Our Country\"?",
                answer = listOf(
                    "(George) Washington"
                ),
            ),
            // 70
            Question(
                questionNumber = 70,
                question = "Who was the first President?",
                answer = listOf(
                    "(George) Washington"
                ),
            ),
            // 71
            Question(
                questionNumber = 71,
                question = "What territory did the United States buy from France in 1803?",
                answer = listOf(
                    "The Louisiana Territory",
                    "Louisiana"
                ),
            ),
            // 72
            Question(
                questionNumber = 72,
                question = "Name one war fought by the United States in the 1800s",
                answer = listOf(
                    "War of 1812",
                    "Mexican-American War",
                    "Civil War",
                    "Spanish-American War"
                ),
            ),
            // 73
            Question(
                questionNumber = 73,
                question = "Name the U.S. war between the North and the South",
                answer = listOf(
                    "The Civil War",
                    "The War between the States"
                ),
            ),
            // 74
            Question(
                questionNumber = 74,
                question = "Name one problem that led to the Civil War.",
                answer = listOf(
                    "Slavery",
                    "Economic reasons",
                    "States' rights"
                ),
            ),
            // 75
            Question(
                questionNumber = 75,
                question = "What was one important thing that Abraham Lincoln did?",
                answer = listOf(
                    "Freed the slaves (Emancipation Proclamation)",
                    "Saved (or preserved) the Union",
                    "Led the United States during the Civil War"
                ),
            ),
            // 76
            Question(
                questionNumber = 76,
                question = "What did the Emancipation Proclamation do?",
                answer = listOf(
                    "Freed the slaves",
                    "Freed slaves in the Confederacy",
                    "Freed slaves in the Confederate states",
                    "Freed slaves in most Southern states"
                ),
            ),
            // 77
            Question(
                questionNumber = 77,
                question = "What did Susan B. Anthony do?",
                answer = listOf(
                    "Fought for women's rights",
                    "Fought for civil rights"
                ),
            ),
            // 78
            Question(
                questionNumber = 78,
                question = "Name one war fought by the United States in the 1900s.",
                answer = listOf(
                    "World War I",
                    "World War II",
                    "Korean War",
                    "Vietnam War",
                    "(Persian) Gulf War"
                ),
            ),
            // 79
            Question(
                questionNumber = 79,
                question = "Who was President during World War I?",
                answer = listOf(
                    "(Woodrow) Wilson"
                ),
            ),
            // 80
            Question(
                questionNumber = 80,
                question = "Who was President during the Great Depression and World War II?",
                answer = listOf(
                    "(Franklin) Roosevelt"
                ),
            ),
            // 81
            Question(
                questionNumber = 81,
                question = "Who did the United States fight in World War II?",
                answer = listOf(
                    "Japan, Germany, and Italy"
                ),
            ),
            // 82
            Question(
                questionNumber = 82,
                question = "Before he was President, Eisenhower was a general. What war was he in?",
                answer = listOf(
                    "World War II"
                ),
            ),
            // 83
            Question(
                questionNumber = 83,
                question = "During the Cold War, what was the main concern of the United States?",
                answer = listOf(
                    "Communism"
                ),
            ),
            // 84
            Question(
                questionNumber = 84,
                question = "What movement tried to end racial discrimination?",
                answer = listOf(
                    "Civil rights (movement)"
                ),
            ),
            // 85
            Question(
                questionNumber = 85,
                question = "What did Martin Luther King, Jr. do?",
                answer = listOf(
                    "Fought for civil rights",
                    "Worked for equality for all Americans"
                ),
            ),
            // 86
            Question(
                questionNumber = 86,
                question = "What major event happened on September 11, 2001, in the United States?",
                answer = listOf(
                    "Terrorists attacked the United States."
                ),
            ),
            // 87
            Question(
                questionNumber = 87,
                question = "Name one American Indian tribe in the United States.",
                answer = listOf(
                    "Cherokee",
                    "Navajo",
                    "Sioux",
                    "Chippewa",
                    "Choctaw",
                    "Pueblo",
                    "Apache",
                    "Iroquois",
                    "Creek",
                    "Blackfeet",
                    "Seminole",
                    "Cheyenne",
                    "Arawak",
                    "Shawnee",
                    "Mohegan",
                    "Huron",
                    "Oneida",
                    "Lakota",
                    "Crow",
                    "Teton",
                    "Hopi",
                    "Inuit"
                ),
            ),
            // 88
            Question(
                questionNumber = 88,
                question = "Name one of the two longest rivers in the United States.",
                answer = listOf(
                    "Missouri (River)",
                    "Mississippi (River)"
                ),
            ),
            // 89
            Question(
                questionNumber = 89,
                question = "What ocean is on the West Coast of the United States?",
                answer = listOf(
                    "Pacific (Ocean)"
                ),
            ),
            // 90
            Question(
                questionNumber = 90,
                question = "What ocean is on the East Coast of the United States?",
                answer = listOf(
                    "Atlantic (Ocean)"
                ),
            ),
            // 91
            Question(
                questionNumber = 91,
                question = "Name one U.S. territory.",
                answer = listOf(
                    "Puerto Rico",
                    "U.S. Virgin Islands",
                    "American Samoa",
                    "Northern Mariana Islands",
                    "Guam"
                ),
            ),
            // 92
            Question(
                questionNumber = 92,
                question = "Name one state that borders Canada.",
                answer = listOf(
                    "Maine",
                    "New Hampshire",
                    "Vermont",
                    "New York",
                    "Pennsylvania",
                    "Ohio",
                    "Michigan",
                    "Minnesota",
                    "North Dakota",
                    "Montana",
                    "Idaho",
                    "Washington",
                    "Alaska",
                ),
            ),
            // 93
            Question(
                questionNumber = 93,
                question = "Name one state that borders Mexico.",
                answer = listOf(
                    "California",
                    "Arizona",
                    "New Mexico",
                    "Texas"
                ),
            ),
            // 94
            Question(
                questionNumber = 94,
                question = "What is the capital of the United States?",
                answer = listOf(
                    "Washington, D.C."
                ),
            ),
            // 95
            Question(
                questionNumber = 95,
                question = "Where is the Statue of Liberty?",
                answer = listOf(
                    "New York (Harbor)",
                    "Liberty Island"
                ),
            ),
            // 96
            Question(
                questionNumber = 96,
                question = "Why does the flag have 13 stripes?",
                answer = listOf(
                    "Because there were 13 original colonies",
                    "Because the stripes represent the original colonies"
                ),
            ),
            // 97
            Question(
                questionNumber = 97,
                question = "Why does the flag have 50 stars?",
                answer = listOf(
                    "Because there is one star for each state",
                    "Because each star represents a state",
                    "Because there are 50 states"
                ),
            ),
            // 98
            Question(
                questionNumber = 98,
                question = "What is the name of the national anthem?",
                answer = listOf(
                    "The Star-Spangled Banner"
                ),
            ),
            // 99
            Question(
                questionNumber = 99,
                question = "When do we celebrate Independence Day?",
                answer = listOf(
                    "July 4"
                ),
            ),
            // 100
            Question(
                questionNumber = 100,
                question = "Name two national U.S. holidays.",
                answer = listOf(
                    "New Year's Day",
                    "Martin Luther King, Jr. Day",
                    "Presidents' Day",
                    "Memorial Day",
                    "Juneteenth",
                    "Independence Day",
                    "Labor Day",
                    "Columbus Day",
                    "Veterans Day",
                    "Thanksgiving",
                    "Christmas"
                ),
            )
        )
    }

    fun get2025Questions(): List<Question> {
        return listOf(
            Question(
                questionNumber = 1,
                question = "What is the form of government of the United States?",
                answer = listOf(
                    "Republic",
                    "Constitution-based federal republic",
                    "Representative democracy"
                ),
            ),
            Question(
                questionNumber = 2,
                question = "What is the supreme law of the land?",
                answer = listOf(
                    "(U.S.) Constitution"
                ),
            ),
            Question(
                questionNumber = 3,
                question = "Name one thing the U.S. Constitution does.",
                answer = listOf(
                    "Forms the government",
                    "Defines powers of government",
                    "Defines the parts of government",
                    "Protects the rights of the people"
                ),
            ),
            Question(
                questionNumber = 4,
                question = "The U.S. Constitution starts with the words “We the People.” What does “We the People” mean?",
                answer = listOf(
                    "Self-government",
                    "Popular sovereignty",
                    "Consent of the governed",
                    "People should govern themselves",
                    "(Example of) social contract"
                ),
            ),
            Question(
                questionNumber = 5,
                question = "How are changes made to the U.S. Constitution?",
                answer = listOf(
                    "Amendments",
                    "The amendment process"
                ),
            ),
            Question(
                questionNumber = 6,
                question = "What does the Bill of Rights protect?",
                answer = listOf(
                    "(The basic) rights of Americans",
                    "(The basic) rights of people living in the United States"
                ),
            ),
            Question(
                questionNumber = 7,
                question = "How many amendments does the U.S. Constitution have?",
                answer = listOf(
                    "Twenty-seven (27)"
                ),
            ),
            Question(
                questionNumber = 8,
                question = "Why is the Declaration of Independence important?",
                answer = listOf(
                    "It says America is free from British control.",
                    "It says all people are created equal.",
                    "It identifies inherent rights.",
                    "It identifies individual freedoms."
                ),
            ),
            Question(
                questionNumber = 9,
                question = "What founding document said the American colonies were free from Britain?",
                answer = listOf(
                    "Declaration of Independence"
                ),
            ),
            Question(
                questionNumber = 10,
                question = "Name two important ideas from the Declaration of Independence and the U.S. Constitution.",
                answer = listOf(
                    "Equality",
                    "Liberty",
                    "Social contract",
                    "Natural rights",
                    "Limited government",
                    "Self-government"
                ),
            ),
            Question(
                questionNumber = 11,
                question = "The words “Life, Liberty, and the pursuit of Happiness” are in what founding document?",
                answer = listOf(
                    "Declaration of Independence"
                ),
            ),
            Question(
                questionNumber = 12,
                question = "What is the economic system of the United States?",
                answer = listOf(
                    "Capitalism",
                    "Free market economy"
                ),
            ),
            Question(
                questionNumber = 13,
                question = "What is the rule of law?",
                answer = listOf(
                    "Everyone must follow the law.",
                    "Leaders must obey the law.",
                    "Government must obey the law.",
                    "No one is above the law."
                ),
            ),
            Question(
                questionNumber = 14,
                question = "Many documents influenced the U.S. Constitution. Name one.",
                answer = listOf(
                    "Declaration of Independence",
                    "Articles of Confederation",
                    "Federalist Papers",
                    "Anti-Federalist Papers",
                    "Virginia Declaration of Rights",
                    "Fundamental Orders of Connecticut",
                    "Mayflower Compact",
                    "Iroquois Great Law of Peace"
                ),
            ),
            Question(
                questionNumber = 15,
                question = "There are three branches of government. Why?",
                answer = listOf(
                    "So one part does not become too powerful",
                    "Checks and balances",
                    "Separation of powers"
                ),
            ),
            Question(
                questionNumber = 16,
                question = "Name the three branches of government.",
                answer = listOf(
                    "Legislative, executive, and judicial",
                    "Congress, president, and the courts"
                ),
            ),
            Question(
                questionNumber = 17,
                question = "The President of the United States is in charge of which branch of government?",
                answer = listOf(
                    "Executive branch"
                ),
            ),
            Question(
                questionNumber = 18,
                question = "What part of the federal government writes laws?",
                answer = listOf(
                    "(U.S.) Congress",
                    "(U.S. or national) legislature",
                    "Legislative branch"
                ),
            ),
            Question(
                questionNumber = 19,
                question = "What are the two parts of the U.S. Congress?",
                answer = listOf(
                    "Senate and House (of Representatives)"
                ),
            ),
            Question(
                questionNumber = 20,
                question = "Name one power of the U.S. Congress.",
                answer = listOf(
                    "Writes laws",
                    "Declares war",
                    "Makes the federal budget"
                ),
            ),
            Question(
                questionNumber = 21,
                question = "How many U.S. senators are there?",
                answer = listOf(
                    "One hundred (100)"
                ),
            ),
            Question(
                questionNumber = 22,
                question = "How long is a term for a U.S. senator?",
                answer = listOf(
                    "Six (6) years"
                ),
            ),
            Question(
                questionNumber = 23,
                question = "Who is one of your state's U.S. senators now?",
                answer = listOf(
                    "<Answers will vary>"
                ),
            ),
            Question(
                questionNumber = 24,
                question = "How many voting members are in the House of Representatives?",
                answer = listOf(
                    "Four hundred thirty-five (435)"
                ),
            ),
            Question(
                questionNumber = 25,
                question = "How long is a term for a member of the House of Representatives?",
                answer = listOf(
                    "Two (2) years"
                ),
            ),
            Question(
                questionNumber = 26,
                question = "Why do U.S. representatives serve shorter terms than U.S. senators?",
                answer = listOf(
                    "To more closely follow public opinion"
                ),
            ),
            Question(
                questionNumber = 27,
                question = "How many senators does each state have?",
                answer = listOf(
                    "Two (2)"
                ),
            ),
            Question(
                questionNumber = 28,
                question = "Why does each state have two senators?",
                answer = listOf(
                    "Equal representation (for small states)",
                    "The Great Compromise (Connecticut Compromise)"
                ),
            ),
            Question(
                questionNumber = 29,
                question = "Name your U.S. representative.",
                answer = listOf(
                    "<Answers will vary>"
                ),
            ),
            Question(
                questionNumber = 30,
                question = "What is the name of the Speaker of the House of Representatives now?",
                answer = listOf(
                    "Mike Johnson"
                ),
            ),
            Question(
                questionNumber = 31,
                question = "Who does a U.S. senator represent?",
                answer = listOf(
                    "Citizens of their state",
                    "People of their state"
                ),
            ),
            Question(
                questionNumber = 32,
                question = "Who elects U.S. senators?",
                answer = listOf(
                    "Citizens from their state"
                ),
            ),
            Question(
                questionNumber = 33,
                question = "Who does a member of the House of Representatives represent?",
                answer = listOf(
                    "Citizens in their (congressional) district",
                    "Citizens in their district",
                    "People from their (congressional) district",
                    "People in their district"
                ),
            ),
            Question(
                questionNumber = 34,
                question = "Who elects members of the House of Representatives?",
                answer = listOf(
                    "Citizens from their (congressional) district"
                ),
            ),
            Question(
                questionNumber = 35,
                question = "Some states have more representatives than other states. Why?",
                answer = listOf(
                    "(Because of) the state's population",
                    "(Because) they have more people",
                    "(Because) some states have more people"
                ),
            ),
            Question(
                questionNumber = 36,
                question = "The President of the United States is elected for how many years?",
                answer = listOf(
                    "Four (4) years"
                ),
            ),
            Question(
                questionNumber = 37,
                question = "The President of the United States can serve only two terms. Why?",
                answer = listOf(
                    "(Because of) the 22nd Amendment",
                    "To keep the president from becoming too powerful"
                ),
            ),
            Question(
                questionNumber = 38,
                question = "What is the name of the President of the United States now?",
                answer = listOf(
                    "Donald Trump"
                ),
            ),
            Question(
                questionNumber = 39,
                question = "What is the name of the Vice President of the United States now?",
                answer = listOf(
                    "JD Vance"
                ),
            ),
            Question(
                questionNumber = 40,
                question = "If the president can no longer serve, who becomes president?",
                answer = listOf(
                    "The Vice President (of the United States)"
                ),
            ),
            Question(
                questionNumber = 41,
                question = "Name one power of the president.",
                answer = listOf(
                    "Signs bills into law",
                    "Vetoes bills",
                    "Enforces laws",
                    "Commander in Chief (of the military)",
                    "Chief diplomat",
                    "Appoints federal judges"
                ),
            ),
            Question(
                questionNumber = 42,
                question = "Who is Commander in Chief of the U.S. military?",
                answer = listOf(
                    "The President (of the United States)"
                ),
            ),
            Question(
                questionNumber = 43,
                question = "Who signs bills to become laws?",
                answer = listOf(
                    "The President (of the United States)"
                ),
            ),
            Question(
                questionNumber = 44,
                question = "Who vetoes bills?",
                answer = listOf(
                    "The President (of the United States)"
                ),
            ),
            Question(
                questionNumber = 45,
                question = "Who appoints federal judges?",
                answer = listOf(
                    "The President (of the United States)"
                ),
            ),
            Question(
                questionNumber = 46,
                question = "The executive branch has many parts. Name one.",
                answer = listOf(
                    "President (of the United States)",
                    "Cabinet",
                    "Federal departments and agencies"
                ),
            ),
            Question(
                questionNumber = 47,
                question = "What does the President's Cabinet do?",
                answer = listOf(
                    "Advises the President (of the United States)"
                ),
            ),
            Question(
                questionNumber = 48,
                question = "What are two Cabinet-level positions?",
                answer = listOf(
                    "Attorney General",
                    "Secretary of Agriculture",
                    "Secretary of Commerce",
                    "Secretary of Education",
                    "Secretary of Energy",
                    "Secretary of Health and Human Services",
                    "Secretary of Homeland Security",
                    "Secretary of Housing and Urban Development",
                    "Secretary of the Interior",
                    "Secretary of Labor",
                    "Secretary of State",
                    "Secretary of Transportation",
                    "Secretary of the Treasury",
                    "Secretary of Veterans Affairs",
                    "Secretary of War (Defense)",
                    "Vice-President",
                    "Administrator of the Environmental Protection Agency",
                    "Administrator of the Small Business Administration",
                    "Director of the Central Intelligence Agency",
                    "Director of the Office of Management and Budget",
                    "Director of National Intelligence",
                    "United States Trade Representative"
                ),
            ),
            Question(
                questionNumber = 49,
                question = "Why is the Electoral College important?",
                answer = listOf(
                    "It decides who is elected president.",
                    "It provides a compromise between the popular election of the president and congressional selection."
                ),
            ),
            Question(
                questionNumber = 50,
                question = "What is one part of the judicial branch?",
                answer = listOf(
                    "Supreme Court",
                    "Federal Courts"
                ),
            ),
            Question(
                questionNumber = 51,
                question = "What does the judicial branch do?",
                answer = listOf(
                    "Reviews laws",
                    "Explains laws",
                    "Resolves disputes (disagreements) about the law",
                    "Decides if a law goes against the (U.S.) Constitution"
                ),
            ),
            Question(
                questionNumber = 52,
                question = "What is the highest court in the United States?",
                answer = listOf(
                    "Supreme Court"
                ),
            ),
            Question(
                questionNumber = 53,
                question = "How many seats are on the Supreme Court?",
                answer = listOf(
                    "Nine (9)"
                ),
            ),
            Question(
                questionNumber = 54,
                question = "How many Supreme Court justices are usually needed to decide a case?",
                answer = listOf(
                    "Five (5)"
                ),
            ),
            Question(
                questionNumber = 55,
                question = "How long do Supreme Court justices serve?",
                answer = listOf(
                    "(For) life",
                    "Lifetime appointment",
                    "(Until) retirement"
                ),
            ),
            Question(
                questionNumber = 56,
                question = "Supreme Court justices serve for life. Why?",
                answer = listOf(
                    "To be independent (of politics)",
                    "To limit outside (political) influence"
                ),
            ),
            Question(
                questionNumber = 57,
                question = "Who is the Chief Justice of the United States now?",
                answer = listOf(
                    "John Roberts"
                ),
            ),
            Question(
                questionNumber = 58,
                question = "Name one power that is only for the federal government.",
                answer = listOf(
                    "Print paper money",
                    "Mint coins",
                    "Declare war",
                    "Create an army",
                    "Make treaties",
                    "Set foreign policy"
                ),
            ),
            Question(
                questionNumber = 59,
                question = "Name one power that is only for the states.",
                answer = listOf(
                    "Provide schooling and education",
                    "Provide protection (police)",
                    "Provide safety (fire departments)",
                    "Give a driver's license",
                    "Approve zoning and land use"
                ),
            ),
            Question(
                questionNumber = 60,
                question = "What is the purpose of the 10th Amendment?",
                answer = listOf(
                    "(It states that the) powers not given to the federal government belong to the states or to the people."
                ),
            ),
            Question(
                questionNumber = 61,
                question = "Who is the governor of your state now?",
                answer = listOf(
                    "<Answers will vary>"
                ),
            ),
            Question(
                questionNumber = 62,
                question = "What is the capital of your state?",
                answer = listOf(
                    "<Answers will vary>"
                ),
            ),
            Question(
                questionNumber = 63,
                question = "There are four amendments to the U.S. Constitution about who can vote. Describe one of them.",
                answer = listOf(
                    "Citizens eighteen (18) and older (can vote).",
                    "You don't have to pay (a poll tax) to vote.",
                    "Any citizen can vote. (Women and men can vote.)",
                    "A male citizen of any race (can vote)."
                ),
            ),
            Question(
                questionNumber = 64,
                question = "Who can vote in federal elections, run for federal office, and serve on a jury in the United States?",
                answer = listOf(
                    "Citizens",
                    "Citizens of the United States",
                    "U.S. citizens"
                ),
            ),
            Question(
                questionNumber = 65,
                question = "What are three rights of everyone living in the United States?",
                answer = listOf(
                    "Freedom of expression",
                    "Freedom of speech",
                    "Freedom of assembly",
                    "Freedom to petition the government",
                    "Freedom of religion",
                    "The right to bear arms"
                ),
            ),
            Question(
                questionNumber = 66,
                question = "What do we show loyalty to when we say the Pledge of Allegiance?",
                answer = listOf(
                    "The United States",
                    "The flag"
                ),
            ),
            Question(
                questionNumber = 67,
                question = "Name two promises that new citizens make in the Oath of Allegiance.",
                answer = listOf(
                    "Give up loyalty to other countries",
                    "Defend the (U.S.) Constitution",
                    "Obey the laws of the United States",
                    "Serve in the military (if needed)",
                    "Serve (help, do important work for) the nation (if needed)",
                    "Be loyal to the United States"
                ),
            ),
            Question(
                questionNumber = 68,
                question = "How can people become United States citizens?",
                answer = listOf(
                    "Be born in the United States, under the conditions set by the 14th Amendment",
                    "Naturalize",
                    "Derive citizenship (under conditions set by Congress)"
                ),
            ),
            Question(
                questionNumber = 69,
                question = "What are two examples of civic participation in the United States?",
                answer = listOf(
                    "Vote",
                    "Run for office",
                    "Join a political party",
                    "Help with a campaign",
                    "Join a civic group",
                    "Join a community group",
                    "Give an elected official your opinion (on an issue)",
                    "Contact elected officials",
                    "Support or oppose an issue or policy",
                    "Write to a newspaper"
                ),
            ),
            Question(
                questionNumber = 70,
                question = "What is one way Americans can serve their country?",
                answer = listOf(
                    "Vote",
                    "Pay taxes",
                    "Obey the law",
                    "Serve in the military",
                    "Run for office",
                    "Work for local, state, or federal government"
                ),
            ),
            Question(
                questionNumber = 71,
                question = "Why is it important to pay federal taxes?",
                answer = listOf(
                    "Required by law",
                    "All people pay to fund the federal government",
                    "Required by the (U.S.) Constitution (16th Amendment)",
                    "Civic duty"
                ),
            ),
            Question(
                questionNumber = 72,
                question = "It is important for all men age 18 through 25 to register for the Selective Service. Name one reason why.",
                answer = listOf(
                    "Required by law",
                    "Civic duty",
                    "Makes the draft fair, if needed"
                ),
            ),
            Question(
                questionNumber = 73,
                question = "The colonists came to America for many reasons. Name one.",
                answer = listOf(
                    "Freedom",
                    "Political liberty",
                    "Religious freedom",
                    "Economic opportunity",
                    "Escape persecution"
                ),
            ),
            Question(
                questionNumber = 74,
                question = "Who lived in America before the Europeans arrived?",
                answer = listOf(
                    "American Indians",
                    "Native Americans"
                ),
            ),
            Question(
                questionNumber = 75,
                question = "What group of people was taken and sold as slaves?",
                answer = listOf(
                    "Africans",
                    "People from Africa"
                ),
            ),
            Question(
                questionNumber = 76,
                question = "What war did the Americans fight to win independence from Britain?",
                answer = listOf(
                    "American Revolution",
                    "The (American) Revolutionary War",
                    "War for (American) Independence"
                ),
            ),
            Question(
                questionNumber = 77,
                question = "Name one reason why the Americans declared independence from Britain.",
                answer = listOf(
                    "High taxes",
                    "Taxation without representation",
                    "British soldiers stayed in Americans' houses (boarding, quartering)",
                    "They did not have self-government",
                    "Boston Massacre",
                    "Boston Tea Party (Tea Act)",
                    "Stamp Act",
                    "Sugar Act",
                    "Townshend Acts",
                    "Intolerable (Coercive) Acts"
                ),
            ),
            Question(
                questionNumber = 78,
                question = "Who wrote the Declaration of Independence?",
                answer = listOf(
                    "(Thomas) Jefferson"
                ),
            ),
            Question(
                questionNumber = 79,
                question = "When was the Declaration of Independence adopted?",
                answer = listOf(
                    "July 4, 1776"
                ),
            ),
            Question(
                questionNumber = 80,
                question = "The American Revolution had many important events. Name one.",
                answer = listOf(
                    "(Battle of) Bunker Hill",
                    "Declaration of Independence",
                    "Washington Crossing the Delaware (Battle of Trenton)",
                    "(Battle of) Saratoga",
                    "Valley Forge (Encampment)",
                    "(Battle of) Yorktown (British surrender at Yorktown)"
                ),
            ),
            Question(
                questionNumber = 81,
                question = "There were 13 original states. Name five.",
                answer = listOf(
                    "New Hampshire",
                    "Massachusetts",
                    "Rhode Island",
                    "Connecticut",
                    "New York",
                    "New Jersey",
                    "Pennsylvania",
                    "Delaware",
                    "Maryland",
                    "Virginia",
                    "North Carolina",
                    "South Carolina",
                    "Georgia"
                ),
            ),
            Question(
                questionNumber = 82,
                question = "What founding document was written in 1787?",
                answer = listOf(
                    "(U.S.) Constitution"
                ),
            ),
            Question(
                questionNumber = 83,
                question = "The Federalist Papers supported the passage of the U.S. Constitution. Name one of the writers.",
                answer = listOf(
                    "(James) Madison",
                    "(Alexander) Hamilton",
                    "(John) Jay",
                    "Publius"
                ),
            ),
            Question(
                questionNumber = 84,
                question = "Why were the Federalist Papers important?",
                answer = listOf(
                    "They helped people understand the (U.S.) Constitution.",
                    "They supported passing the (U.S.) Constitution."
                ),
            ),
            Question(
                questionNumber = 85,
                question = "Benjamin Franklin is famous for many things. Name one.",
                answer = listOf(
                    "Founded the first free public libraries",
                    "First Postmaster General of the United States",
                    "Helped write the Declaration of Independence",
                    "Inventor",
                    "U.S. diplomat"
                ),
            ),
            Question(
                questionNumber = 86,
                question = "George Washington is famous for many things. Name one.",
                answer = listOf(
                    "“Father of Our Country”",
                    "First president of the United States",
                    "General of the Continental Army",
                    "President of the Constitutional Convention"
                ),
            ),
            Question(
                questionNumber = 87,
                question = "Thomas Jefferson is famous for many things. Name one.",
                answer = listOf(
                    "Writer of the Declaration of Independence",
                    "Third president of the United States",
                    "Doubled the size of the United States (Louisiana Purchase)",
                    "First Secretary of State",
                    "Founded the University of Virginia",
                    "Writer of the Virginia Statute on Religious Freedom"
                ),
            ),
            Question(
                questionNumber = 88,
                question = "James Madison is famous for many things. Name one.",
                answer = listOf(
                    "“Father of the Constitution”",
                    "Fourth president of the United States",
                    "President during the War of 1812",
                    "One of the writers of the Federalist Papers"
                ),
            ),
            Question(
                questionNumber = 89,
                question = "Alexander Hamilton is famous for many things. Name one.",
                answer = listOf(
                    "First Secretary of the Treasury",
                    "One of the writers of the Federalist Papers",
                    "Helped establish the First Bank of the United States",
                    "Aide to General George Washington",
                    "Member of the Continental Congress"
                ),
            ),
            Question(
                questionNumber = 90,
                question = "What territory did the United States buy from France in 1803?",
                answer = listOf(
                    "Louisiana Territory",
                    "Louisiana"
                ),
            ),
            Question(
                questionNumber = 91,
                question = "Name one war fought by the United States in the 1800s.",
                answer = listOf(
                    "War of 1812",
                    "Mexican-American War",
                    "Civil War",
                    "Spanish-American War"
                ),
            ),
            Question(
                questionNumber = 92,
                question = "Name the U.S. war between the North and the South.",
                answer = listOf(
                    "The Civil War"
                ),
            ),
            Question(
                questionNumber = 93,
                question = "The Civil War had many important events. Name one.",
                answer = listOf(
                    "(Battle of) Fort Sumter",
                    "Emancipation Proclamation",
                    "(Battle of) Vicksburg",
                    "(Battle of) Gettysburg",
                    "Sherman's March",
                    "(Surrender at) Appomattox",
                    "(Battle of) Antietam/Sharpsburg",
                    "Lincoln was assassinated."
                ),
            ),
            Question(
                questionNumber = 94,
                question = "Abraham Lincoln is famous for many things. Name one.",
                answer = listOf(
                    "Freed the slaves (Emancipation Proclamation)",
                    "Saved (or preserved) the Union",
                    "Led the United States during the Civil War",
                    "16th president of the United States",
                    "Delivered the Gettysburg Address"
                ),
            ),
            Question(
                questionNumber = 95,
                question = "What did the Emancipation Proclamation do?",
                answer = listOf(
                    "Freed the slaves",
                    "Freed slaves in the Confederacy",
                    "Freed slaves in the Confederate states",
                    "Freed slaves in most Southern states"
                ),
            ),
            Question(
                questionNumber = 96,
                question = "What U.S. war ended slavery?",
                answer = listOf(
                    "The Civil War"
                ),
            ),
            Question(
                questionNumber = 97,
                question = "What amendment says all persons born or naturalized in the United States, and subject to the jurisdiction thereof, are U.S. citizens?",
                answer = listOf(
                    "14th Amendment"
                ),
            ),
            Question(
                questionNumber = 98,
                question = "When did all men get the right to vote?",
                answer = listOf(
                    "After the Civil War",
                    "During Reconstruction",
                    "(With the) 15th Amendment",
                    "1870"
                ),
            ),
            Question(
                questionNumber = 99,
                question = "Name one leader of the women's rights movement in the 1800s.",
                answer = listOf(
                    "Susan B. Anthony",
                    "Elizabeth Cady Stanton",
                    "Sojourner Truth",
                    "Harriet Tubman",
                    "Lucretia Mott",
                    "Lucy Stone"
                ),
            ),
            Question(
                questionNumber = 100,
                question = "Name one war fought by the United States in the 1900s.",
                answer = listOf(
                    "World War I",
                    "World War II",
                    "Korean War",
                    "Vietnam War",
                    "(Persian) Gulf War"
                ),
            ),
            Question(
                questionNumber = 101,
                question = "Why did the United States enter World War I?",
                answer = listOf(
                    "Because Germany attacked U.S. (civilian) ships",
                    "To support the Allied Powers (England, France, Italy, and Russia)",
                    "To oppose the Central Powers (Germany, Austria-Hungary, the Ottoman Empire, and Bulgaria)"
                ),
            ),
            Question(
                questionNumber = 102,
                question = "When did all women get the right to vote?",
                answer = listOf(
                    "1920",
                    "After World War I",
                    "(With the) 19th Amendment"
                ),
            ),
            Question(
                questionNumber = 103,
                question = "What was the Great Depression?",
                answer = listOf(
                    "Longest economic recession in modern history"
                ),
            ),
            Question(
                questionNumber = 104,
                question = "When did the Great Depression start?",
                answer = listOf(
                    "The Great Crash (1929)",
                    "Stock market crash of 1929"
                ),
            ),
            Question(
                questionNumber = 105,
                question = "Who was president during the Great Depression and World War II?",
                answer = listOf(
                    "(Franklin) Roosevelt"
                ),
            ),
            Question(
                questionNumber = 106,
                question = "Why did the United States enter World War II?",
                answer = listOf(
                    "(Bombing of) Pearl Harbor",
                    "Japanese attacked Pearl Harbor",
                    "To support the Allied Powers (England, France, and Russia)",
                    "To oppose the Axis Powers (Germany, Italy, and Japan)"
                ),
            ),
            Question(
                questionNumber = 107,
                question = "Dwight Eisenhower is famous for many things. Name one.",
                answer = listOf(
                    "General during World War II",
                    "President at the end of (during) the Korean War",
                    "34th president of the United States",
                    "Signed the Federal-Aid Highway Act of 1956 (Created the Interstate System)"
                ),
            ),
            Question(
                questionNumber = 108,
                question = "Who was the United States' main rival during the Cold War?",
                answer = listOf(
                    "Soviet Union",
                    "USSR",
                    "Russia"
                ),
            ),
            Question(
                questionNumber = 109,
                question = "During the Cold War, what was one main concern of the United States?",
                answer = listOf(
                    "Communism",
                    "Nuclear war"
                ),
            ),
            Question(
                questionNumber = 110,
                question = "Why did the United States enter the Korean War?",
                answer = listOf(
                    "To stop the spread of communism"
                ),
            ),
            Question(
                questionNumber = 111,
                question = "Why did the United States enter the Vietnam War?",
                answer = listOf(
                    "To stop the spread of communism"
                ),
            ),
            Question(
                questionNumber = 112,
                question = "What did the civil rights movement do?",
                answer = listOf(
                    "Fought to end racial discrimination"
                ),
            ),
            Question(
                questionNumber = 113,
                question = "Martin Luther King, Jr. is famous for many things. Name one.",
                answer = listOf(
                    "Fought for civil rights",
                    "Worked for equality for all Americans",
                    "Worked to ensure that people would “not be judged by the color of their skin, but by the content of their character”"
                ),
            ),
            Question(
                questionNumber = 114,
                question = "Why did the United States enter the Persian Gulf War?",
                answer = listOf(
                    "To force the Iraqi military from Kuwait"
                ),
            ),
            Question(
                questionNumber = 115,
                question = "What major event happened on September 11, 2001 in the United States?",
                answer = listOf(
                    "Terrorists attacked the United States",
                    "Terrorists took over two planes and crashed them into the World Trade Center in New York City",
                    "Terrorists took over a plane and crashed into the Pentagon in Arlington, Virginia",
                    "Terrorists took over a plane originally aimed at Washington, D.C., and crashed in a field in Pennsylvania"
                ),
            ),
            Question(
                questionNumber = 116,
                question = "Name one U.S. military conflict after the September 11, 2001 attacks.",
                answer = listOf(
                    "(Global) War on Terror",
                    "War in Afghanistan",
                    "War in Iraq"
                ),
            ),
            Question(
                questionNumber = 117,
                question = "Name one American Indian tribe in the United States.",
                answer = listOf(
                    "Apache",
                    "Blackfeet",
                    "Cayuga",
                    "Cherokee",
                    "Cheyenne",
                    "Chippewa",
                    "Choctaw",
                    "Creek",
                    "Crow",
                    "Hopi",
                    "Huron",
                    "Inupiat",
                    "Lakota",
                    "Mohawk",
                    "Mohegan",
                    "Navajo",
                    "Oneida",
                    "Onondaga",
                    "Pueblo",
                    "Seminole",
                    "Seneca",
                    "Shawnee",
                    "Sioux",
                    "Teton",
                    "Tuscarora"
                ),
            ),
            Question(
                questionNumber = 118,
                question = "Name one example of an American innovation.",
                answer = listOf(
                    "Light bulb",
                    "Automobile (cars, internal combustion engine)",
                    "Skyscrapers",
                    "Airplane",
                    "Assembly line",
                    "Landing on the moon",
                    "Integrated circuit (IC)"
                ),
            ),
            Question(
                questionNumber = 119,
                question = "What is the capital of the United States?",
                answer = listOf(
                    "Washington, D.C."
                ),
            ),
            Question(
                questionNumber = 120,
                question = "Where is the Statue of Liberty?",
                answer = listOf(
                    "New York (Harbor)",
                    "Liberty Island [Also acceptable are New Jersey, near New York City, and on the Hudson (River).]"
                ),
            ),
            Question(
                questionNumber = 121,
                question = "Why does the flag have 13 stripes?",
                answer = listOf(
                    "(Because there were) 13 original colonies",
                    "(Because the stripes) represent the original colonies"
                ),
            ),
            Question(
                questionNumber = 122,
                question = "Why does the flag have 50 stars?",
                answer = listOf(
                    "(Because there is) one star for each state",
                    "(Because) each star represents a state",
                    "(Because there are) 50 states"
                ),
            ),
            Question(
                questionNumber = 123,
                question = "What is the name of the national anthem?",
                answer = listOf(
                    "The Star-Spangled Banner"
                ),
            ),
            Question(
                questionNumber = 124,
                question = "The Nation's first motto was “E Pluribus Unum.” What does that mean?",
                answer = listOf(
                    "Out of many, one",
                    "We all become one"
                ),
            ),
            Question(
                questionNumber = 125,
                question = "What is Independence Day?",
                answer = listOf(
                    "A holiday to celebrate U.S. independence (from Britain)",
                    "The country's birthday"
                ),
            ),
            Question(
                questionNumber = 126,
                question = "Name three national U.S. holidays.",
                answer = listOf(
                    "New Year's Day",
                    "Martin Luther King, Jr. Day",
                    "Presidents Day (Washington's Birthday)",
                    "Memorial Day",
                    "Juneteenth",
                    "Independence Day",
                    "Labor Day",
                    "Columbus Day",
                    "Veterans Day",
                    "Thanksgiving Day",
                    "Christmas Day"
                ),
            ),
            Question(
                questionNumber = 127,
                question = "What is Memorial Day?",
                answer = listOf(
                    "A holiday to honor soldiers who died in military service"
                ),
            ),
            Question(
                questionNumber = 128,
                question = "What is Veterans Day?",
                answer = listOf(
                    "A holiday to honor people in the (U.S.) military",
                    "A holiday to honor people who have served (in the U.S. military)"
                ),
            ),
        )
    }
}
