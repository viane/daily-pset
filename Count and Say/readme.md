# Count and Say problem

Write a code to do following:

|n | String to print|
|---|---|
|0 | 1|
|1 | 1 1|
|2 | 2 1|
|3 | 1 2 1 1|
|... | ...|


Base case: n = ```0``` print "```1```"

for n = ```1```, look at previous string and write number of times a digit is seen and the digit itself. In this case,
digit 1 is seen 1 time in a row… so print “```1(One) 1```”

for n = ```2```, digit 1 is seen two times in a row, so print “```2(Two) 1```”

for n = ```3```, digit 2 is seen 1 time and then digit 1 is seen 1 so print “```1 2 1 1```”

for n = ```4```, you will print “```1 1 1 2 2 1```”

![](result.png)