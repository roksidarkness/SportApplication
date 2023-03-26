package com.roksidark.foosballmatchesapplication.util

import com.roksidark.foosballmatchesapplication.data.model.entity.Game
import com.roksidark.foosballmatchesapplication.data.model.entity.RatingGame

fun gamesToRatingGames(games: List<Game>?): List<RatingGame> {
    val listRatingGames = mutableListOf<RatingGame>()
    games?.let {
        for (game in it) {
            val firstPerson = RatingGame(game.firstPerson, 1, 0)
            val secondPerson = RatingGame(game.secondPerson, 1, 0)

            if (game.firstPersonScore == game.secondPersonScore){
                    val item = listRatingGames.find { ratingGame->
                        ratingGame.person == firstPerson.person
                    }
                    item?.let { ratingGame->
                        ratingGame.person = firstPerson.person
                        ratingGame.finishedGames += 1
                    } ?: run {
                        listRatingGames.add(firstPerson)
                    }
                    val itemSecond = listRatingGames.find { ratingGame->
                        ratingGame.person == secondPerson.person
                    }
                    itemSecond?.let { ratingGame->
                        ratingGame.person = secondPerson.person
                        ratingGame.finishedGames += 1
                    } ?: run {
                        listRatingGames.add(secondPerson)
                    }
            }
            else if (game.firstPersonScore > game.secondPersonScore){
                    val item = listRatingGames.find { ratingGame->
                        ratingGame.person == firstPerson.person
                    }
                    item?.let { ratingGame->
                        ratingGame.person = firstPerson.person
                        ratingGame.wonGames += 1
                        ratingGame.finishedGames += 1
                    } ?: run {
                        firstPerson.wonGames +=1
                        listRatingGames.add(firstPerson)
                    }

                    val itemSecond = listRatingGames.find { ratingGame->
                        ratingGame.person == secondPerson.person
                    }
                    itemSecond?.let { ratingGame->
                        ratingGame.person = secondPerson.person
                        ratingGame.finishedGames += 1
                    } ?: run {
                        listRatingGames.add(secondPerson)
                    }
            }
            else if (game.firstPersonScore < game.secondPersonScore){

                    val item = listRatingGames.find { ratingGame->
                        ratingGame.person == firstPerson.person
                    }
                    item?.let { ratingGame->
                        ratingGame.person = firstPerson.person
                        ratingGame.finishedGames += 1
                    } ?: run {
                        listRatingGames.add(firstPerson)
                    }

                    val itemSecond = listRatingGames.find { ratingGame->
                        ratingGame.person == secondPerson.person
                    }
                    itemSecond?.let { ratingGame->
                        ratingGame.person = secondPerson.person
                        ratingGame.finishedGames += 1
                        ratingGame.wonGames += 1
                    } ?: run {
                        secondPerson.wonGames +=1
                        listRatingGames.add(secondPerson)
                    }
            }
        }
    }
    return listRatingGames
}
