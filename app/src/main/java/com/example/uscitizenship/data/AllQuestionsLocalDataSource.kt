package com.example.uscitizenship.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Up to date answers: https://uscis.gov/citizenship/testupdates
 *
 */
class AllQuestionsLocalDataSource() {
    val allQuestions: Flow<List<Question>> = flow {
        emit(
            listOf(
                // 1
                Question(
                    question = "What is the supreme law of the land?",
                    answer = listOf(
                        "the Constitution"
                    ),
                ),
                // 2
                Question(
                    question = "What does the Constitution do?",
                    answer = listOf(
                        "sets up the government",
                        "defines the government",
                        "protects basic rights of Americans"
                    ),
                ),
                // 3
                Question(
                    question = "The idea of self-government is in the first three words of the Constitution. What are these words?",
                    answer = listOf(
                        "We the People"
                    ),
                ),
                // 4
                Question(
                    question = "What is an amendment?",
                    answer = listOf(
                        "a change (to the Constitution)",
                        "an addition (to the Constitution)"
                    ),
                ),
                // 5
                Question(
                    question = "What do we call the first ten amendments to the Constitution?",
                    answer = listOf(
                        "the Bill of Rights"
                    ),
                ),
                // 6
                Question(
                    question = "What is one right or freedom from the First Amendment?",
                    answer = listOf(
                        "speech",
                        "religion",
                        "assembly",
                        "press",
                        "petition the government"
                    ),
                ),
                // 7
                Question(
                    question = "How many amendments does the Constitution have?",
                    answer = listOf(
                        "twenty-seven (27)"
                    ),
                ),
                // 8
                Question(
                    question = "What did the Declaration of Independence do?",
                    answer = listOf(
                        "announced our independence (from Great Britain)",
                        "declared our independence (from Great Britain)",
                        "said that the United States is free (from Great Britain)"
                    ),
                ),
                // 9
                Question(
                    question = "What are two rights in the Declaration of Independence?",
                    answer = listOf(
                        "life",
                        "liberty",
                        "pursuit of happiness"
                    ),
                ),
                // 10
                Question(
                    question = "What is freedom of religion?",
                    answer = listOf(
                        "You can practice any religion, or not practice a religion."
                    ),
                ),
                // 11
                Question(
                    question = "What is the economic system in the United States?",
                    answer = listOf(
                        "capitalist economy",
                        "market economy"
                    ),
                ),
                // 12
                Question(
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
                    question = "Name one branch or part of the government.",
                    answer = listOf(
                        "Congress",
                        "legislative",
                        "President",
                        "executive",
                        "the courts",
                        "judicial"
                    ),
                ),
                // 14
                Question(
                    question = "What stops one branch of government from becoming too powerful?",
                    answer = listOf(
                        "checks and balances",
                        "separation of powers"
                    ),
                ),
                // 15
                Question(
                    question = "Who is in charge of the executive branch?",
                    answer = listOf(
                        "the President"
                    ),
                ),
                // 16
                Question(
                    question = "Who makes federal laws?",
                    answer = listOf(
                        "Congress",
                        "Senate and House (of Representatives)",
                        "(U.S. or national) legislature"
                    ),
                ),
                // 17
                Question(
                    question = "What are the two parts of the U.S. Congress?",
                    answer = listOf(
                        "the Senate and House (of Representatives)"
                    ),
                ),
                // 18
                Question(
                    question = "How many U.S. Senators are there?",
                    answer = listOf(
                        "one hundred (100)"
                    ),
                ),
                // 19
                Question(
                    question = "We elect a U.S. Senator for how many years?",
                    answer = listOf(
                        "six (6)"
                    ),
                ),
                // 20
                Question(
                    question = "Who is one of your state's U.S. Senators now?",
                    answer = listOf(
                        "<Answers will vary>"
                    ),
                ),
                // 21
                Question(
                    question = "The House of Representatives has how many voting members?",
                    answer = listOf(
                        "four hundred thirty-five (435)"
                    ),
                ),
                // 22
                Question(
                    question = "We elect a U.S. Representative for how many years?",
                    answer = listOf(
                        "two (2)"
                    ),
                ),
                // 23
                Question(
                    question = "Name your U.S. Representative.",
                    answer = listOf(
                        "<Answers will vary>"
                    ),
                ),
                // 24
                Question(
                    question = "Who does a U.S. Senator represent?",
                    answer = listOf(
                        "all people of the state"
                    ),
                ),
                // 25
                Question(
                    question = "Why do some states have more Representatives than other states?",
                    answer = listOf(
                        "(because of) the state's population",
                        "(because) they have more people",
                        "(because) some states have more people"
                    ),
                ),
                // 26
                Question(
                    question = "We elect a President for how many years?",
                    answer = listOf(
                        "four (4)"
                    ),
                ),
                // 27
                Question(
                    question = "In what month do we vote for President?",
                    answer = listOf(
                        "November"
                    ),
                ),
                // 28
                Question(
                    question = "What is the name of the President of the United States now?",
                    answer = listOf(
                        "Joe Biden"
                    ),
                ),
                // 29
                Question(
                    question = "What is the name of the Vice President of the United States now?",
                    answer = listOf(
                        "Kamala Harris"
                    ),
                ),
                // 30
                Question(
                    question = "If the President can no longer serve, who becomes President?",
                    answer = listOf(
                        "the Vice President"
                    ),
                ),
                // 31
                Question(
                    question = "If both the President and the Vice President can no longer serve, who becomes President?",
                    answer = listOf(
                        "the Speaker of the House"
                    ),
                ),
                // 32
                Question(
                    question = "Who is the Commander in Chief of the military?",
                    answer = listOf(
                        "the President"
                    ),
                ),
                // 33
                Question(
                    question = "Who signs bills to become laws?",
                    answer = listOf(
                        "the President"
                    ),
                ),
                // 34
                Question(
                    question = "Who vetoes bills?",
                    answer = listOf(
                        "the President"
                    ),
                ),
                // 35
                Question(
                    question = "What does the President's Cabinet do?",
                    answer = listOf(
                        "advises the President"
                    ),
                ),
                // 36
                Question(
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
                    question = "What does the judicial branch do?",
                    answer = listOf(
                        "reviews laws",
                        "explains laws",
                        "resolves disputes (disagreements)",
                        "decides if a law goes against the Constitution"
                    ),
                ),
                // 38
                Question(
                    question = "What is the highest court in the United States?",
                    answer = listOf(
                        "the Supreme Court"
                    ),
                ),
                // 39
                Question(
                    question = "How many justices are on the Supreme Court?",
                    answer = listOf(
                        "nine (9)"
                    ),
                ),
                // 40
                Question(
                    question = "Who is the Chief Justice of the United States now?",
                    answer = listOf(
                        "John Roberts"
                    ),
                ),
                // 41
                Question(
                    question = "Under our Constitution, some powers belong to the federal government. What is one power of the federal government?",
                    answer = listOf(
                        "to print money",
                        "to declare war",
                        "to create an army",
                        "to make treaties"
                    ),
                ),
                // 42
                Question(
                    question = "Under our Constitution, some powers belong to the states. What is one power of the states?",
                    answer = listOf(
                        "provide schooling and education",
                        "provide protection (police)",
                        "provide safety (fire departments)",
                        "give a driver's license",
                        "approve zoning and land use"
                    ),
                ),
                // 43
                Question(
                    question = "Who is the Governor of your state now?",
                    answer = listOf(
                        "<Answers will vary>"
                    ),
                ),
                // 44
                Question(
                    question = "What is the capital of your state?",
                    answer = listOf(
                        "<Answers will vary>"
                    ),
                ),
                // 45
                Question(
                    question = "What are the two major political parties in the United States?",
                    answer = listOf(
                        "Democratic and Republican"
                    ),
                ),
                // 46
                Question(
                    question = "What is the political party of the President now?",
                    answer = listOf(
                        "Democratic (Party)"
                    ),
                ),
                // 47
                Question(
                    question = "What is the name of the Speaker of the House of Representatives now?",
                    answer = listOf(
                        "Mike Johnson"
                    ),
                ),
                // 48
                Question(
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
                    question = "What is one responsibility that is only for United States citizens?",
                    answer = listOf(
                        "serve on a jury",
                        "vote in a federal election"
                    ),
                ),
                // 50
                Question(
                    question = "Name one right only for United States citizens.",
                    answer = listOf(
                        "vote in a federal election",
                        "run for federal office"
                    ),
                ),
                // 51
                Question(
                    question = "What are two rights of everyone living in the United States?",
                    answer = listOf(
                        "freedom of expression",
                        "freedom of speech",
                        "freedom of assembly",
                        "freedom to petition the government",
                        "freedom of religion",
                        "the right to bear arms"
                    ),
                ),
                // 52
                Question(
                    question = "What do we show loyalty to when we say the Pledge of Allegiance?",
                    answer = listOf(
                        "the United States",
                        "the flag"
                    ),
                ),
                // 53
                Question(
                    question = "What is one promise you make when you become a United States citizen?",
                    answer = listOf(
                        "give up loyalty to other countries",
                        "defend the Constitution and laws of the United States",
                        "obey the laws of the United States",
                        "serve in the U.S. military (if needed)",
                        "serve (do important work for) the nation (if needed)",
                        "be loyal to the United States"
                    ),
                ),
                // 54
                Question(
                    question = "How old do citizens have to be to vote for President?",
                    answer = listOf(
                        "eighteen (18) and older"
                    ),
                ),
                // 55
                Question(
                    question = "What are two ways that Americans can participate in their democracy?",
                    answer = listOf(
                        "vote",
                        "join a political party",
                        "help with a campaign",
                        "join a civic group",
                        "join a community group",
                        "give an elected official your opinion on an issue",
                        "call Senators and Representatives",
                        "publicly support or oppose an issue or policy",
                        "run for office",
                        "write to a newspaper"
                    ),
                ),
                // 56
                Question(
                    question = "When is the last day you can send in federal income tax forms?",
                    answer = listOf(
                        "April 15"
                    ),
                ),
                // 57
                Question(
                    question = "When must all men register for the Selective Service?",
                    answer = listOf(
                        "at age eighteen (18)",
                        "between eighteen (18) and twenty-six (26)"
                    ),
                ),
                // 58
                Question(
                    question = "What is one reason colonists came to America?",
                    answer = listOf(
                        "freedom",
                        "political liberty",
                        "religious freedom",
                        "economic opportunity",
                        "practice their religion",
                        "escape persecution"
                    ),
                ),
                // 59
                Question(
                    question = "Who lived in America before the Europeans arrived?",
                    answer = listOf(
                        "American Indians",
                        "Native Americans"
                    ),
                ),
                // 60
                Question(
                    question = "What group of people was taken to America and sold as slaves?",
                    answer = listOf(
                        "Africans",
                        "people from Africa"
                    ),
                ),
                // 61
                Question(
                    question = "Why did the colonists fight the British?",
                    answer = listOf(
                        "because of high taxes (taxation without representation)",
                        "because the British army stayed in their houses (boarding, quartering)",
                        "because they didn't have self-government"
                    ),
                ),
                // 62
                Question(
                    question = "Who wrote the Declaration of Independence?",
                    answer = listOf(
                        "(Thomas) Jefferson"
                    ),
                ),
                // 63
                Question(
                    question = "When was the Declaration of Independence adopted?",
                    answer = listOf(
                        "July 4, 1776"
                    ),
                ),
                // 64
                Question(
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
                    question = "What happened at the Constitutional Convention?",
                    answer = listOf(
                        "The Constitution was written.",
                        "The Founding Fathers wrote the Constitution."
                    ),
                ),
                // 66
                Question(
                    question = "When was the Constitution written?",
                    answer = listOf(
                        "1787"
                    ),
                ),
                // 67
                Question(
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
                    question = "What is one thing Benjamin Franklin is famous for?",
                    answer = listOf(
                        "U.S. diplomat",
                        "oldest member of the Constitutional Convention",
                        "first Postmaster General of the United States",
                        "writer of \"Poor Richard's Almanac\"",
                        "started the first free libraries"
                    ),
                ),
                // 69
                Question(
                    question = "Who is the \"Father of Our Country\"?",
                    answer = listOf(
                        "(George) Washington"
                    ),
                ),
                // 70
                Question(
                    question = "Who was the first President?",
                    answer = listOf(
                        "(George) Washington"
                    ),
                ),
                // 71
                Question(
                    question = "What territory did the United States buy from France in 1803?",
                    answer = listOf(
                        "the Louisiana Territory",
                        "Louisiana"
                    ),
                ),
                // 72
                Question(
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
                    question = "Name the U.S. war between the North and the South",
                    answer = listOf(
                        "the Civil War",
                        "the War between the States"
                    ),
                ),
                // 74
                Question(
                    question = "Name one problem that led to the Civil War.",
                    answer = listOf(
                        "slavery",
                        "economic reasons",
                        "states' rights"
                    ),
                ),
                // 75
                Question(
                    question = "What was one important thing that Abraham Lincoln did?",
                    answer = listOf(
                        "freed the slaves (Emancipation Proclamation)",
                        "saved (or preserved) the Union",
                        "led the United States during the Civil War"
                    ),
                ),
                // 76
                Question(
                    question = "What did the Emancipation Proclamation do?",
                    answer = listOf(
                        "freed the slaves",
                        "freed slaves in the Confederacy",
                        "freed slaves in the Confederate states",
                        "freed slaves in most Southern states"
                    ),
                ),
                // 77
                Question(
                    question = "What did Susan B. Anthony do?",
                    answer = listOf(
                        "fought for women's rights",
                        "fought for civil rights"
                    ),
                ),
                // 78
                Question(
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
                    question = "Who was President during World War I?",
                    answer = listOf(
                        "(Woodrow) Wilson"
                    ),
                ),
                // 80
                Question(
                    question = "Who was President during the Great Depression and World War II?",
                    answer = listOf(
                        "(Franklin) Roosevelt"
                    ),
                ),
                // 81
                Question(
                    question = "Who did the United States fight in World War II?",
                    answer = listOf(
                        "Japan, Germany, and Italy"
                    ),
                ),
                // 82
                Question(
                    question = "Before he was President, Eisenhower was a general. What war was he in?",
                    answer = listOf(
                        "World War II"
                    ),
                ),
                // 83
                Question(
                    question = "During the Cold War, what was the main concern of the United States?",
                    answer = listOf(
                        "Communism"
                    ),
                ),
                // 84
                Question(
                    question = "What movement tried to end racial discrimination?",
                    answer = listOf(
                        "civil rights (movement)"
                    ),
                ),
                // 85
                Question(
                    question = "What did Martin Luther King, Jr. do?",
                    answer = listOf(
                        "fought for civil rights",
                        "worked for equality for all Americans"
                    ),
                ),
                // 86
                Question(
                    question = "What major event happened on September 11, 2001, in the United States?",
                    answer = listOf(
                        "Terrorists attacked the United States."
                    ),
                ),
                // 87
                Question(
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
                    question = "Name one of the two longest rivers in the United States.",
                    answer = listOf(
                        "Missouri (River)",
                        "Mississippi (River)"
                    ),
                ),
                // 89
                Question(
                    question = "What ocean is on the West Coast of the United States?",
                    answer = listOf(
                        "Pacific (Ocean)"
                    ),
                ),
                // 90
                Question(
                    question = "What ocean is on the East Coast of the United States?",
                    answer = listOf(
                        "Atlantic (Ocean)"
                    ),
                ),
                // 91
                Question(
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
                    question = "What is the capital of the United States?",
                    answer = listOf(
                        "Washington, D.C."
                    ),
                ),
                // 95
                Question(
                    question = "Where is the Statue of Liberty?",
                    answer = listOf(
                        "New York (Harbor)",
                        "Liberty Island"
                    ),
                ),
                // 96
                Question(
                    question = "Why does the flag have 13 stripes?",
                    answer = listOf(
                        "because there were 13 original colonies",
                        "because the stripes represent the original colonies"
                    ),
                ),
                // 97
                Question(
                    question = "Why does the flag have 50 stars?",
                    answer = listOf(
                        "because there is one star for each state",
                        "because each star represents a state",
                        "because there are 50 states"
                    ),
                ),
                // 98
                Question(
                    question = "What is the name of the national anthem?",
                    answer = listOf(
                        "The Star-Spangled Banner"
                    ),
                ),
                // 99
                Question(
                    question = "When do we celebrate Independence Day?",
                    answer = listOf(
                        "July 4"
                    ),
                ),
                // 100
                Question(
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
