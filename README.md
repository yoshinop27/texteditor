# CSC 207: Text Editor

**Author**: Preston, Reo

## Resources Used

+ https://docs.oracle.com/javase/8/docs/api/index.html?java/nio/file/Files.html
+ https://mabe02.github.io/lanterna/apidocs/3.1/overview-summary.html
+ ...

## Part 2

In our String back text buffer, for the insert method we consider our relavant operation to be the reassignment of simpleStringBuffer. In this reassignment we assign 2 substrings and one character to simpleStringBuffer. We can analyze the time complexity with the funciton T(n) where n represents the length of simpleStringBuffer. T(n)=n+1. This is because we are copying our old string and the new character into new memory that gets reassigned to simpleStringBuffer. Because strings are immutable, we can't modify that original memory space, thus we have to obtain new memory to hold our new string, and write in n+1 characters to that new memory which gets assigned to simpleStringBuffer. Thus we classify this operation O(n). We can see how this becomes wasteful as n grows larger.

## Changelog

_(TODO: fill me in with a log of your committed changes)_
