# Iteration2- Chpt 4 - 7
### This project is for learning scala from the book _O'Reilly Programming Scala 2nd edition_
**Chapter 4**
  - Pattern Matching useing case ?: type => ? format
  - You can match by value, variable or type
  - You can use unexpected or _ to match anything else
  - You can match sequences using case head or tail of both and recall the match
  - You can match unknown tuples using _
  - You can match variable argument lists 
  
 **Chapter 5**
  - Implicits Arguments are used when you do not want to define the type explicitly 
  - Implicits can also verify the superclass type 
  - All arguments are implicit when start with implicit so it appears once 
  - Phantom types are when you decalre a type but not a value.
  
  **Chapter 6**
  - Functional programming is like mathmatics where their functions take variables and return a result
  - You can use anonymous function to help functional programming
  - Methods can also be in objects as functions
  - @tailrec is used for recursion
  - Currying transforms a function that takes multiple argument lists into a chain of functions, each taking a single argument
    - def cat2(s1: String) = (s2: String) => s1 + s2
  - functional programming focuses more on data structures (seq, set, map, etc...)
  - Traversables are filtering, mapping, foreaching, folding, reducing
    - You can fold or reduce left/right
    
**Chapter 7**
  - for comprehensions use the format for { line <- lines} yield ??
  - Try is a sealed abstract class that has Success of Failure
  
  

