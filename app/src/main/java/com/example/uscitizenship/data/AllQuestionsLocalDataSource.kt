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

            )
        )
    }
}