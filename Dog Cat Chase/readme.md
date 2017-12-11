# Write a C++ program that allows our cat, Johnny to chase our dog, Harvey.

Johnny thinks he rules the house!

>The base of this “chase” is a 15 x 10 2-dimmensional array that represents a room.  The starting and ending positions (doors) can be any row in column 0 and column 9, in other words, either end of the room.  

>The room setup is provided in a data file called rooms.txt. The first integer value tells you how many room setups there are in the data file. Each room setup is made up of a 15’ by 10’ room where W is the wall and F is furniture.

>Your program will use the Rand_Int function to randomly find a start and end position for the animals to use in the room.  Once you locate these positions, you can change W (wall) to a D (door).

>The only global variables you are allowed to have are 15 and 10.

Now it is time to see if Johnny (J) and Harvey (H) can run through the room.  Put one of the animals at the starting location and see if they can follow a path through the room. The only hiccup is Johnny is actually a pretty lazy cat and he will only run 50 paces before he quits and does hit “cat” thing.  This program should have a minimum of two functions, Rand_Int and the Chase.   Output will include the original room setup with the doors (D), walls (W), furniture (F) and animal (J or H) represented and then the final results. The final results will have the doors, walls, furniture and the path (P, J or H) the animal took. This can be represented with Js or Hs depending on which animal does the chase. Be sure to indicate if the animals made it all the way through the room or if Johnny had to “retire” from the event.

**Note**

Due to os platform variation, you might need to change reading file path at ```line 231``` of ```main.cpp``` to locate the **rooms.txt** on your machine.
