# <u>java8-learning</u>


1. https://www.oracle.com/java/technologies/ma14-java-se-8-streams.html


2. Java Generics FAQs - Type Arguments
http://www.angelikalanger.com/GenericsFAQ/FAQSections/TypeArguments.html#FAQ103

3. Difference between <? super T> and <? extends T> in Java [duplicate]
https://stackoverflow.com/questions/4343202/difference-between-super-t-and-extends-t-in-java


4. Covariance, Invariance and Contravariance explained in plain English?
https://stackoverflow.com/questions/8481301/covariance-invariance-and-contravariance-explained-in-plain-english




# <h2>Great question! You spotted the diamond operator</h2>

So far, we’ve been declaring our ArrayLists by showing the element type twice:
ArrayList<String> songs = new ArrayList<String>();

Most of the time, we don’t need to say the same thing twice. The compiler can
tell from what you wrote on the left-hand side what you probably want on the
right-hand side. It uses type inference to infer (work out) the type you need.

ArrayList<String> songs = new ArrayList<>();

<i>Over time, Java has evolved to remove unnecessary code duplication from its syntax. 
If the compiler can figure out a type, you don't always need to write it out in full. </i> 







#<h4><i> <span style="color:green;">Q: Should I be using the diamond operator all </span></h4></i>  
the time? Are there any downsides?
A: The diamond operator is “syntactic sugar,” which
means it’s there to make our lives easier as we write
(and read) code, but it doesn’t make any difference to
the underlying byte code. So if you’re worried about
whether using the diamond means something different
to using the specific type, don’t worry! It’s basically
the same thing.
However, sometimes you might choose to write out
the full type. The main reason you might want to is
to help people reading your code. For example, if the
variable is declared a long way from where it’s initialized,
you might want to use the type when you initialize
it so you can see clearly what objects go into it.
ArrayList<String> songs;
// lots of code between these lines...
songs = new ArrayList<String>();


#<h4><i> <span style="color:green;">Q: Are there any other places the compiler can work out the types for me?</span></h4></i>

A: Yes! For example, the var keyword (“Local
Variable Type Inference”), which we’ll talk about in
Appendix B. And another important example, lambda
expressions, which we will see later in this chapter.
there are no Dumb Questions



#<h4><i> <span style="color:green;">Q: I saw you were creating an ArrayList but assigning it to a List reference, and that you created an ArrayList but returned a List from the method. Why not just use ArrayList everywhere?</span></h4></i>  


A: One of the advantages of polymorphism
is that code doesn’t need to know the
specific implementation type of an object to
work well with it. List is a well-known, wellunderstood
interface (which we’ll see more of
in this chapter). Code that is working with an
ArrayList doesn’t usually need to know it’s an
ArrayList. It could be a LinkedList. Or a specialized
type of List. Code that’s working with the
List only needs to know it can call List methods
on it (like add(), size() etc). It’s usually safer
to pass the interface type (i.e., List) around
instead of the implementation. That way, other
code can’t go rooting around inside your object
in a way that was never intended.
It also means that should you ever want to
change from an ArrayList to a LinkedList, or a
CopyOnWriteArrayList (see Chapter 18, Dealing
with Concurrency Issues) at a later date, you can
without having to change all the places the
List is used.


