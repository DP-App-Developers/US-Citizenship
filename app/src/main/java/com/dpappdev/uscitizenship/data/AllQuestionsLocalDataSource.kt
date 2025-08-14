package com.dpappdev.uscitizenship.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Up to date answers: https://uscis.gov/citizenship/testupdates
 *
 */
class AllQuestionsLocalDataSource {
    val allQuestions: Flow<List<Question>> = flow {
        emit(
            listOf(
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
                        "New Year’s Day",
                        "Martin Luther King, Jr. Day",
                        "Presidents’ Day",
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
        )
    }
}
