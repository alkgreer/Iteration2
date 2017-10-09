// src/main/scala/Module/Search-Engine.scala
package Module

object searchEngine {
  /*
                           **Class**
  */
  class User(userName: String, pass: String, history: List[Search]) {
    val name = userName
    private val password = pass
    val searchHistory = history

    override def toString: String = {
      return s"${userName}'s Search History\n$searchHistory"
    }
  }

  case class Search(value: String, results: List[Result])

  case class Result(title: String, description: String)

  def userFrequentSearch(searches: List[Search]): String = {
    if (searches.isEmpty) {
      return "No Search History"
    } else {
      val frequencies = for {
        search <- searches
      } yield {
        search -> searches.count(_ == search)
      }
      val mostFrequentSearch = frequencies.maxBy(_._2)
      return mostFrequentSearch._1.value
    }
  }

  def engineFrequentSearch(users: List[User]): String = {
    val engineHistory = (for (usr <- users) yield usr.searchHistory).flatten
    if (engineHistory.isEmpty) {
      return "No Users Found"
    } else {
      val frequencies = for {
        s <- engineHistory
      } yield {
        s -> engineHistory.count(_ == s)
      }
      val mostFrequent = frequencies.maxBy(_._2)
      return mostFrequent._1.value
    }
  }



  /*
                           **MAIN**
  */

  def main(args: Array[String]) {
    // Make some searches and fill them with results
    val GameSearch = Search("League of Legends", List(
      Result("Top 5 plays", "The best plays of League of Legends"),
      Result("Top 5 Champions", "The best champions of League of Legends"),
      Result("Builds", "Champion build guides for League of Legends")
    ))

    val VideoSearch = Search("Funny", List(
      Result("Top 5 funniest moments", "The funniest moments"),
      Result("Top 5 funniest things", "The funniest things"),
      Result("Funny Comedians", "Comedians whom are funny")
    ))

    val ShoppingSearch = Search("Computer", List(
      Result("Top 5 best computers", "The best computers"),
      Result("Top 5 most bought computers", "The most bought computers"),
      Result("How-to-build computers", "Build guides for computers")
    ))

    val RandomSearch = Search("Randomness", List(
      Result("Top 5 most random things", "The most random things"),
      Result("Top 5 most random incidents", "The most random incidents")
    ))


    val FinalSearch = Search("Finals", List(
      Result("Top 5 final questions", "The most occurying final questions"),
      Result("Top 5 hardest finals", "The hardest taken finals"),
      Result("How-to-pass a final", "Passing guides for finals")
    ))

    //make users
    val Alisha = new User("Alisha", "StrongPassWord", List(GameSearch, VideoSearch))
    val Kate = new User("BestFriend", "SecretPass", List(GameSearch, ShoppingSearch, FinalSearch))
    val Marcus = new User("Marcus", "TypicalPass", List(GameSearch, VideoSearch))
    val Sarah = new User("Beth", "MoreSecret", List(RandomSearch))
    val Abby = new User("Friend", "HelloWorld1", List(RandomSearch, GameSearch))

    val searchEngineUsers = List(Alisha, Kate, Marcus, Sarah, Abby)


    // Find each user's most frequent search
    for (user <- searchEngineUsers) println(s"${user.name}'s most frequent search: ${userFrequentSearch(user.searchHistory)}")

    // Find the most frequent search on the engine
    println(s"Most frequent search on this engine: ${engineFrequentSearch(searchEngineUsers)}")
  }
}
