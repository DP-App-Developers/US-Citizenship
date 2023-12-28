package com.example.uscitizenship.data

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
                    question = "What is the supreme law of the land?",
                    answer = listOf(
                        "The Constitution"
                    ),
                ),
                // 2
                Question(
                    question = "What does the Constitution do?",
                    answer = listOf(
                        "Sets up the government",
                        "Defines the government",
                        "Protects basic rights of Americans"
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
                        "A change (to the Constitution)",
                        "An addition (to the Constitution)"
                    ),
                ),
                // 5
                Question(
                    question = "What do we call the first ten amendments to the Constitution?",
                    answer = listOf(
                        "The Bill of Rights"
                    ),
                ),
                // 6
                Question(
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
                    question = "How many amendments does the Constitution have?",
                    answer = listOf(
                        "Twenty-seven (27)"
                    ),
                ),
                // 8
                Question(
                    question = "What did the Declaration of Independence do?",
                    answer = listOf(
                        "Announced our independence (from Great Britain)",
                        "Declared our independence (from Great Britain)",
                        "Said that the United States is free (from Great Britain)"
                    ),
                ),
                // 9
                Question(
                    question = "What are two rights in the Declaration of Independence?",
                    answer = listOf(
                        "Life",
                        "Liberty",
                        "Pursuit of happiness"
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
                        "Capitalist economy",
                        "Market economy"
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
                        "Legislative",
                        "President",
                        "Executive",
                        "The courts",
                        "Judicial"
                    ),
                ),
                // 14
                Question(
                    question = "What stops one branch of government from becoming too powerful?",
                    answer = listOf(
                        "Checks and balances",
                        "Separation of powers"
                    ),
                ),
                // 15
                Question(
                    question = "Who is in charge of the executive branch?",
                    answer = listOf(
                        "The President"
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
                        "The Senate and House (of Representatives)"
                    ),
                ),
                // 18
                Question(
                    question = "How many U.S. Senators are there?",
                    answer = listOf(
                        "One hundred (100)"
                    ),
                ),
                // 19
                Question(
                    question = "We elect a U.S. Senator for how many years?",
                    answer = listOf(
                        "Six (6)"
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
                        "Four hundred thirty-five (435)"
                    ),
                ),
                // 22
                Question(
                    question = "We elect a U.S. Representative for how many years?",
                    answer = listOf(
                        "Two (2)"
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
                        "All people of the state"
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
                        "Four (4)"
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
                        "The Vice President"
                    ),
                ),
                // 31
                Question(
                    question = "If both the President and the Vice President can no longer serve, who becomes President?",
                    answer = listOf(
                        "The Speaker of the House"
                    ),
                ),
                // 32
                Question(
                    question = "Who is the Commander in Chief of the military?",
                    answer = listOf(
                        "The President"
                    ),
                ),
                // 33
                Question(
                    question = "Who signs bills to become laws?",
                    answer = listOf(
                        "The President"
                    ),
                ),
                // 34
                Question(
                    question = "Who vetoes bills?",
                    answer = listOf(
                        "The President"
                    ),
                ),
                // 35
                Question(
                    question = "What does the President's Cabinet do?",
                    answer = listOf(
                        "Advises the President"
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
                        "Reviews laws",
                        "Explains laws",
                        "Resolves disputes (disagreements)",
                        "Decides if a law goes against the Constitution"
                    ),
                ),
                // 38
                Question(
                    question = "What is the highest court in the United States?",
                    answer = listOf(
                        "The Supreme Court"
                    ),
                ),
                // 39
                Question(
                    question = "How many justices are on the Supreme Court?",
                    answer = listOf(
                        "Nine (9)"
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
                        "To print money",
                        "To declare war",
                        "To create an army",
                        "To make treaties"
                    ),
                ),
                // 42
                Question(
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
                        "Serve on a jury",
                        "Vote in a federal election"
                    ),
                ),
                // 50
                Question(
                    question = "Name one right only for United States citizens.",
                    answer = listOf(
                        "Vote in a federal election",
                        "Run for federal office"
                    ),
                ),
                // 51
                Question(
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
                    question = "What do we show loyalty to when we say the Pledge of Allegiance?",
                    answer = listOf(
                        "The United States",
                        "The flag"
                    ),
                ),
                // 53
                Question(
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
                    question = "How old do citizens have to be to vote for President?",
                    answer = listOf(
                        "Eighteen (18) and older"
                    ),
                ),
                // 55
                Question(
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
                    question = "When is the last day you can send in federal income tax forms?",
                    answer = listOf(
                        "April 15"
                    ),
                ),
                // 57
                Question(
                    question = "When must all men register for the Selective Service?",
                    answer = listOf(
                        "At age eighteen (18)",
                        "Between eighteen (18) and twenty-six (26)"
                    ),
                ),
                // 58
                Question(
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
                        "People from Africa"
                    ),
                ),
                // 61
                Question(
                    question = "Why did the colonists fight the British?",
                    answer = listOf(
                        "Because of high taxes (taxation without representation)",
                        "Because the British army stayed in their houses (boarding, quartering)",
                        "Because they didn't have self-government"
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
                        "Oldest member of the Constitutional Convention",
                        "First Postmaster General of the United States",
                        "Writer of \"Poor Richard's Almanac\"",
                        "Started the first free libraries"
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
                        "The Louisiana Territory",
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
                        "The Civil War",
                        "The War between the States"
                    ),
                ),
                // 74
                Question(
                    question = "Name one problem that led to the Civil War.",
                    answer = listOf(
                        "Slavery",
                        "Economic reasons",
                        "States' rights"
                    ),
                ),
                // 75
                Question(
                    question = "What was one important thing that Abraham Lincoln did?",
                    answer = listOf(
                        "Freed the slaves (Emancipation Proclamation)",
                        "Saved (or preserved) the Union",
                        "Led the United States during the Civil War"
                    ),
                ),
                // 76
                Question(
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
                    question = "What did Susan B. Anthony do?",
                    answer = listOf(
                        "Fought for women's rights",
                        "Fought for civil rights"
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
                        "Civil rights (movement)"
                    ),
                ),
                // 85
                Question(
                    question = "What did Martin Luther King, Jr. do?",
                    answer = listOf(
                        "Fought for civil rights",
                        "Worked for equality for all Americans"
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
                        "Because there were 13 original colonies",
                        "Because the stripes represent the original colonies"
                    ),
                ),
                // 97
                Question(
                    question = "Why does the flag have 50 stars?",
                    answer = listOf(
                        "Because there is one star for each state",
                        "Because each star represents a state",
                        "Because there are 50 states"
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
