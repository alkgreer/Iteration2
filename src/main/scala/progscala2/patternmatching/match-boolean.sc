val bools = Seq(true, false, true, true, false)

for(bool <- bools){
  bool match {
    case true => println("Got heads")
    case false => println("Got tails")
  }
}
